FROM openjdk:17-oracle

WORKDIR /app

COPY target/student-registration-service-0.0.1-SNAPSHOT.jar /app/student-registration-service.jar

EXPOSE 8080

CMD ["java", "-jar", "student-registration-service.jar"]
