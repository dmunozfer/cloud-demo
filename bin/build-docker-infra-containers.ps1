# --------------------------------------------------------------------------------------
# -- Script regenera y ejecuta todos los contenedores de la infraestructura para la demo
# -- Las operaciones que realiza son:
# --   + Elimina todos los contenedores de la infraestructura
# --   + Crea y ejecuta los contedores
# --------------------------------------------------------------------------------------

# Elimina todos los contenedores de la infraestructura
docker rm -f scd-rabbitmq

# Crea y ejecuta los contenedores de la aplicación
docker run --network=scd_network --name scd-rabbitmq -h scd-rabbitmq -p 15672:15672 -p 5672:5672 -d rabbitmq:3.6.6-management
