FROM eclipse-temurin:24
LABEL maintainer="contato@pedrofolder.com"
WORKDIR /app

COPY target/cadastroNinjas-0.0.1-SNAPSHOT.jar /app/cadastroNinjas.jar

ENTRYPOINT ["java", "-jar", "cadastroNinjas.jar"]