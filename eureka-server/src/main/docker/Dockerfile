FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD eureka-server-0.0.1-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS=""
ENV spring.cloud.config.uri http://scd-config-server:8888
ENV EUREKA_SERVICE_URL http://scd-eureka-server:8761/eureka
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]