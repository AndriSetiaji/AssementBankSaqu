# Dockerfile tidak menggunakan sintaks YAML
FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY app.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
