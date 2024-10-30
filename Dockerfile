# Dockerfile tidak menggunakan sintaks YAML
FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY ./build/libs/test-api-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
