java -jar spring-cloud-dataflow-shell-1.1.0.RELEASE.jar

#- Registra las apps de rabbitmq
#app import --uri http://bit.ly/Avogadro-GA-stream-applications-rabbit-maven
#stream create --name files-to-notes --definition "file --file.consumer.mode=lines --file.directory=/tmp/in > :notes" --deploy