FROM openjdk:19-jdk-alpine
WORKDIR /opt/app
ARG JAR_FILE=target/*.jar
COPY ./target/GP-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 4000
ENTRYPOINT  ["java","-jar","./app.jar"]