# Demo de Spring Cloud
Proyecto demo de uso spring cloud

## Instalando RabbitMQ
Podemos arrancar un servidor con RabbitMQ con docker ejecutando el script:

    cd bin
    ./run-rabbitmq.ps1

Se puede acceder a la consola de administración en;
+ http://localhost:15672 (guest/guest)


## Spring dataflow
Vamos a hacer un ejemplo para insertar notas escribiendo las notas en ficheros de texto.

SpringDataflow crearemos un stream que lee ficheros de un directorio
 + Para cada línea de fichero enviará el contenido al stream/canal "notes"
 + El canal notes está asociado a una cola rabbitmq "notes"
 + La app notes-server está leyendo de la cola "notes" y los mensajes los da de alta como nuevas notas

Para crear el stream **files-to-notes** ejecutar los siguientes comandos en directorio bin.

    cd bin
    java -jar spring-cloud-dataflow-shell-1.1.0.RELEASE.jar
    
    # Registra las apps de rabbitmq
    app import --uri http://bit.ly/Avogadro-GA-stream-applications-rabbit-maven
    stream create --name files-to-notes --definition "file --file.consumer.mode=lines --file.directory=/tmp/in > :notes" --deploy

## OAuth 2

Se ha creado un servidor con Oauth2 que permite autenticar ciertas operaciones.

El servicio se han creado varios usuarios:
+ admin/admin (con los roles ROLE_ADMIN y ROLE_USER)
+ user/password (con los roles ROLE_USER)

Únicamente tiene un client_id (acme/acmesecert) que está dado de alta para el scope "openid"

El endpoint para autenticar es http://localhost:9191/oauth/token

    POST http://localhost:9191/uaa/oauth/token
    
    HEADERS
     - Content-Type: application/json
     - Authorization: Basic YWNtZTphY21lc2VjcmV0 (BASE64(acme:acmepassword))
    BODY
     - username: admin
     - password: admin
     - grant_type: password
     - scope: openid

## Endpoints

###Eureka
+ http://localhost:8761/

###Zipkin
+ http://10.0.75.1:9411/

###Notes - Server
+ http://localhost:8000/notes - Listado de notas
+ http://localhost:8000/message - Mensaje leido de property

###Notes - Client ApiGateway 
**SECURIZADO** Todas las petición van con autenticación, la de creación de notas hay que tener usuario con rol 
administrador (admin/admin).

+ http://localhost:9999/notes/text - Listado de notas (solo texto) recuperado de notes-server
+ http://localhost:9999/notes/message - Mensaje leido de property recuperado de notes-server
+ http://localhost:9999/notes - POST inserta nueva nota (enviando mensaje por cola rabbitmq leida por notes-server)

###Config Server
+ http://localhost:8888/notes-server/default
+ http://localhost:8888/notes-client/default