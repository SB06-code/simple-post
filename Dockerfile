FROM gradle:8-jdk17 AS builder

WORKDIR /app
COPY . .

RUN chmod +x ./gradlew
RUN ./gradlew bootJar

FROM amazoncorretto:17-alpine

COPY --from=builder /app/build/libs/simple-post-0.0.1-SNAPSHOT.jar /app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app.jar"]
