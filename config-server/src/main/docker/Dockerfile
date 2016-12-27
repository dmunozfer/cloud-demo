FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD config-server-0.0.1-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS=""
ENV EUREKA_SERVICE_URL http://scd-eureka-server:8761
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
