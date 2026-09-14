FROM eclipse-temurin:21-jdk
ARG JAR_FILE=target/api-0.0.1.jar
COPY ${JAR_FILE} app_bazar.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app_bazar.jar"]