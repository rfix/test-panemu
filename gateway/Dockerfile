FROM --platform=linux/x86_64 eclipse-temurin:17-jdk-alpine
ARG ARG JAR_FILE=/target/gateway-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} gateway.jar
COPY ./target/gateway-0.0.1-SNAPSHOT.jar gateway.jar
ENTRYPOINT ["java","-jar","/gateway.jar"]
