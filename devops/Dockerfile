#Download base image ubuntu 20.04
FROM ubuntu:20.04
# Refer to Maven build -> finalName
ARG JAR_FILE=target/alex-exercise-0.0.1-SNAPSHOT.jar

WORKDIR /opt/app

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","app.jar"]
