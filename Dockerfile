# Maven
FROM maven:eclipse-temurin AS builder
WORKDIR /app
COPY pom.xml .
RUN mvn -e -B dependency:resolve
COPY src ./src
RUN mvn clean package -Pproduction


FROM eclipse-temurin:17.0.8.1_1-jdk
ENV HOST_URL=https://code-couch.onrender.com
WORKDIR /app
COPY --from=builder /app/target/CodeCouch.jar .
CMD ["java", "-jar", "./CodeCouch.jar"]