# Use an official Maven image as the build environment
FROM maven:3.8.3-openjdk-17 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the project's pom.xml and build dependencies
COPY pom.xml .

# Download project dependencies
RUN mvn dependency:go-offline

# Copy the rest of the application code
COPY src ./src

# Build the application
RUN mvn package

# Use a lightweight JRE image for the runtime environment
FROM openjdk:17-oracle

# Set the working directory inside the container
WORKDIR /app

# Copy the packaged Spring Boot application JAR file from the build stage
COPY --from=build /app/target/dinoname-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your Spring Boot app will listen on
EXPOSE 8080

# Define the command to run your Spring Boot application
CMD ["java", "-jar", "app.jar"]
