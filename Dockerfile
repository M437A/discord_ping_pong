FROM gradle:8.3-jdk17 AS build
WORKDIR /app

COPY . .

RUN gradle clean build -x test
CMD ["java", "-jar", "/app/build/libs/bot-0.0.1-SNAPSHOT.jar"]