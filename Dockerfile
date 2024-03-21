FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY target/crud-api-0.0.1-SNAPSHOT.jar movieapi.jar
CMD ["java", "-jar", "movieapi.jar"]