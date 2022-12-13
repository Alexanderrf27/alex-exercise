#Download base image ubuntu 20.04
FROM ubuntu:20.04
# Refer to Maven build -> finalName
ARG JAR_FILE=target/alex-exercise-0.0.1-SNAPSHOT.jar

# cd /opt/app
WORKDIR /opt/app

# cp target/spring-boot-web.jar /opt/app/app.jar
COPY ${JAR_FILE} app.jar

# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","app.jar"]
