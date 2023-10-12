FROM openjdk:17-jdk-alpine
ARG ARG JAR_FILE=/target/main-app-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} main-app.jar
COPY ./target/main-app-0.0.1-SNAPSHOT.jar main-app.jar
ENTRYPOINT ["java","-jar","/main-app.jar"]
