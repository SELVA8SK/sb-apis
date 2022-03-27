FROM openjdk:8
EXPOSE 9090
ADD target/spring-api-docker.jar
MAINTAINER baeldung.com
COPY target/sbapi-docker-0.0.1-SNAPSHOT message-server-1.0.0.jar
ENTRYPOINT ["java","-jar","/spring-api-docker"]