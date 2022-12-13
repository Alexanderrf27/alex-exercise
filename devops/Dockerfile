#Download base image ubuntu 20.04
FROM ubuntu:20.04

VOLUME /tmp

EXPOSE 8080

ARG JAR_FILE=target/target/*.jar

ADD ${JAR_FILE} app.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]



