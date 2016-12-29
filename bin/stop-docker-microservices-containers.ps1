# -------------------------------------------------------------------------------------
# -- Detiene todas los contenedores de los microservicios de la demo
# -------------------------------------------------------------------------------------

docker stop scd-config-server
docker stop scd-eureka-server
docker stop scd-zipkin-server

docker stop scd-notes-server
docker stop scd-notes-client

docker stop scd-dataflow-server
docker stop scd-hystrix-dashboard
docker stop scd-oauth-server
