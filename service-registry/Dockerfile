FROM openjdk:17-jdk-alpine
ARG ARG JAR_FILE=/target/service-registry-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} service-registry.jar
COPY ./target/service-registry-0.0.1-SNAPSHOT.jar service-registry.jar
ENTRYPOINT ["java","-jar","/service-registry.jar"]
