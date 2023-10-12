FROM openjdk:17-jdk-alpine
ARG ARG JAR_FILE=/target/external-service-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} external-service.jar
COPY ./target/external-service-0.0.1-SNAPSHOT.jar external-service.jar
ENTRYPOINT ["java","-jar","/external-service.jar"]
