FROM openjdk:17-jdk-alpine
ARG ARG JAR_FILE=/target/api2-service-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} api2-service.jar
COPY ./target/api2-service-0.0.1-SNAPSHOT.jar api2-service.jar
ENTRYPOINT ["java","-jar","/api2-service.jar"]
