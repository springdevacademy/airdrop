FROM ubuntu:latest
LABEL authors="Ramesh Kannan Ganapathy"

# Step 1: Build stage using JDK 17 & Gradle 8
FROM gradle:8.5-jdk17 AS build
WORKDIR /app

# Copy configuration and source files
COPY build.gradle settings.gradle ./
COPY src ./src

# Build the Spring Boot executable JAR skipping unit tests
RUN gradle bootJar --no-daemon -x test

# Step 2: Lightweight runtime stage
FROM eclipse-temurin:17-jre
WORKDIR /app

# Copy the generated application JAR from the build stage
COPY --from=build /app/build/libs/*.jar app.jar

# Expose HTTP port
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]