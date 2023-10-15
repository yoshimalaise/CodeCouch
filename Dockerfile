FROM eclipse-temurin:17-jdk-alpine
ENV HOST_URL=https://code-couch.onrender.com
WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN mvn install -U
RUN mvn clean package -Pproduction
COPY target/*.jar ./
CMD ["java", "-jar CodeCouch.jar"]