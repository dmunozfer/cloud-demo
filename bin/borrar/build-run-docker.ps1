# Elimina todos los contenedores de la aplicación
docker rm -f scd-oauth-server
docker rm -f scd-dataflow-server
docker rm -f scd-hystrix-dashboard

docker rm -f scd-notes-client
docker rm -f scd-notes-server

docker rm -f scd-zipkin-server
docker rm -f scd-eureka-server
docker rm -f scd-config-server


# Elimina todas las imágenes de la aplicación
docker rmi spring_cloud_demo/oauth-server
docker rmi spring_cloud_demo/dataflow-server
docker rmi spring_cloud_demo/hystrix-dashboard

docker rmi spring_cloud_demo/notes-client
docker rmi spring_cloud_demo/notes-server

docker rmi spring_cloud_demo/zipkin-server
docker rmi spring_cloud_demo/eureka-server
docker rmi spring_cloud_demo/config-server

# Regenera las imágenes de la aplicación
# --
cd .\config-server\
mvn package docker:build -DskipTests
cd ..

cd .\eureka-server\
mvn package docker:build -DskipTests
cd ..

cd .\zipkin-server\
mvn package docker:build -DskipTests
cd ..

# --
cd .\notes-server\
mvn package docker:build -DskipTests
cd ..

cd .\notes-client\
mvn package docker:build -DskipTests
cd ..

# --
cd .\dataflow-server\
mvn package docker:build -DskipTests
cd ..

cd .\hystrix-dashboard\
mvn package docker:build -DskipTests
cd ..

cd .\oauth-server\
mvn package docker:build -DskipTests
cd ..

# Crea y ejecuta los contenedores de la aplicación
docker run --network=scd_network --name scd-config-server -h scd-config-server -p 8888:8888 -d spring_cloud_demo/config-server
Start-Sleep 20
docker run --network=scd_network --name scd-eureka-server -h scd-eureka-server -p 8761:8761 -d spring_cloud_demo/eureka-server
Start-Sleep 10
docker run --network=scd_network --name scd-zipkin-server -h scd-zipkin-server -p 9411:9411 -d spring_cloud_demo/zipkin-server

docker run --network=scd_network --name scd-notes-server -h scd-notes-server -p 8000:8000 -d spring_cloud_demo/notes-server
Start-Sleep 10
docker run --network=scd_network --name scd-notes-client -h scd-notes-client -p 9999:9999 -d spring_cloud_demo/notes-client

docker run --network=scd_network --name scd-dataflow-server -h scd-dataflow-server -p 9393:9393 -d spring_cloud_demo/dataflow-server
docker run --network=scd_network --name scd-hystrix-dashboard -h scd-hystrix-dashboard -p 8010:8010 -d spring_cloud_demo/hystrix-dashboard
docker run --network=scd_network --name scd-oauth-server -h scd-oauth-server -p 9191:9191 -d spring_cloud_demo/oauth-server
