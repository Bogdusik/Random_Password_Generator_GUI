# Multi-stage build for Java application
FROM maven:3.9-eclipse-temurin-11 AS builder

WORKDIR /app

# Copy pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source code and build
COPY src ./src
RUN mvn clean package -DskipTests

# Runtime stage
FROM eclipse-temurin:11-jre-alpine

WORKDIR /app

# Copy JAR from builder stage
COPY --from=builder /app/target/random-password-generator-gui-1.0.0.jar app.jar

# Install X11 and required libraries for GUI
RUN apk add --no-cache \
    xvfb \
    x11vnc \
    fluxbox \
    ttf-dejavu \
    fontconfig

# Set display environment variable
ENV DISPLAY=:99

# Create a script to run the application
RUN echo '#!/bin/sh' > /app/run.sh && \
    echo 'Xvfb :99 -screen 0 1024x768x24 > /dev/null 2>&1 &' >> /app/run.sh && \
    echo 'sleep 2' >> /app/run.sh && \
    echo 'java -jar app.jar' >> /app/run.sh && \
    chmod +x /app/run.sh

# Note: GUI applications in Docker require X11 forwarding or VNC
# For headless testing, use: docker run -e DISPLAY=$DISPLAY -v /tmp/.X11-unix:/tmp/.X11-unix
ENTRYPOINT ["/app/run.sh"]

