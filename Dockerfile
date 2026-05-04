# Stage 1 - Build karo
FROM maven:3.9-eclipse-temurin-24 AS build
WORKDIR /app
COPY . .
RUN ./mvnw clean package -DskipTests

# Stage 2 - Run karo
FROM eclipse-temurin:24-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
