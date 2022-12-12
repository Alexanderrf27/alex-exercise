FROM java:11-jdk-alpine
COPY ./build/libs/alex-exercise-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "alex-exercise-0.0.1-SNAPSHOT.jar"]

alex-exercise-0.0.1-SNAPSHOT.jar