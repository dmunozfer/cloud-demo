# -------------------------------------------------------------------------------------
# -- Ejecuta todas los contenedores de los microservicios de la demo
# -- PRE:
# --   + Los contenedores de las aplicaciones ya deben existir
# --   + Todos los contenedores de infraestructura (colas, etc) deben estar corriendo
# -------------------------------------------------------------------------------------

docker start scd-config-server
Start-Sleep 20
docker start scd-eureka-server
Start-Sleep 10
docker start scd-zipkin-server

docker start scd-notes-server
Start-Sleep 10
docker start scd-notes-client

docker start scd-dataflow-server
docker start scd-hystrix-dashboard
docker start scd-oauth-server

