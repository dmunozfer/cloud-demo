# Elimina todos los contenedores de la aplicación
docker rm -f scd-notes-server
docker rm -f scd-eureka-server
docker rm -f scd-config-server

# Elimina todas las imágenes de la aplicación
docker rmi spring_cloud_demo/notes-server
docker rmi spring_cloud_demo/eureka-server
docker rmi spring_cloud_demo/config-server

# Regenera las imágenes de la aplicación
cd .\config-server\
mvn package docker:build -DskipTests
cd ..

cd .\eureka-server\
mvn package docker:build -DskipTests
cd ..

cd .\notes-server\
mvn package docker:build -DskipTests
cd ..

# Crea y ejecuta los contenedores de la aplicación
docker run --network=scd_network --name scd-config-server -h scd-config-server -p 8888:8888 -d spring_cloud_demo/config-server
Start-Sleep 20
docker run --network=scd_network --name scd-eureka-server -h scd-eureka-server -p 8761:8761 -d spring_cloud_demo/eureka-server
Start-Sleep 10
docker run --network=scd_network --name scd-notes-server -h scd-notes-server -p 8000:8000 -d spring_cloud_demo/notes-server
