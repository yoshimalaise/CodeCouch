FROM eclipse-temurin:17-jdk-alpine
ENV HOST_URL=https://code-couch.onrender.com
RUN mvn clean package -Pproduction
COPY ./target/CodeCouch.jar /home/CodeCouch.jar
ENTRYPOINT ["java","-jar","/home/CodeCouch.jar"]