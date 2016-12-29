#docker run --network=scd_network --name rabbitmq -h rabbitmq -p 5672:5672 -d rabbitmq:3.6.6
docker run --network=scd_network --name rabbitmq-mng -h rabbitmq-mng -p 15672:15672 -p 5672:5672 -d rabbitmq:3.6.6-management
