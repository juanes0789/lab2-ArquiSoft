FROM eclipse-temurin:17-jre
EXPOSE 8080
COPY target/lab22026.jar lab22026.jar
ENTRYPOINT ["java", "-jar", "/lab22026.jar"]

