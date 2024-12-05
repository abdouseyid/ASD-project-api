# Use a base image with Java support
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
#WORKDIR /myapp

# Copy the built .jar file into the container
COPY target/*.jar app.jar

# Expose the port your Spring Boot app is running on (default is 8080)
EXPOSE 8083

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
