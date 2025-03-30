# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim AS build

# Set the working directory in the container
WORKDIR /sam_demo_sharding_app

# Copy the Gradle wrapper and build files
COPY gradlew build.gradle settings.gradle /sam_demo_sharding_app/
COPY gradle /sam_demo_sharding_app/gradle

# Download the dependencies
RUN ./gradlew build -x test --no-daemon

# Copy the project source code
COPY src /sam_demo_sharding_app/src

# Build the application
RUN ./gradlew build -x test --no-daemon

# Use a smaller base image for the runtime
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /sam_demo_sharding_app

# Copy the built application from the build stage
COPY --from=build /sam_demo_sharding_app/build/libs/sam_demo_sharding-0.0.1-SNAPSHOT.jar /sam_demo_sharding_app/sam_demo_sharding-0.0.1-SNAPSHOT.jar

# Expose the port the application runs on
EXPOSE 5001

# Run the application
CMD ["java", "-jar", "sam_demo_sharding-0.0.1-SNAPSHOT.jar"]