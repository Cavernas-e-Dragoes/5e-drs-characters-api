# 1. Build Stage
FROM maven:3.8.4-openjdk-17 as builder

# Declaração do argumento para a variável de ambiente
ARG RAILWAY_ENVIRONMENT

# Define a variável de ambiente dentro do contêiner
ENV RAILWAY_ENVIRONMENT=$RAILWAY_ENVIRONMENT

WORKDIR /app

# Copia os arquivos do projeto pai (pom.xml) e dos módulos para o contêiner
COPY pom.xml ./
COPY utilities/ ./utilities
COPY characters/ ./characters
COPY users/ ./users

# Executa o build de cada módulo individualmente
RUN mvn clean package -DskipTests

# 2. Run Stage
FROM openjdk:17-jdk

# Diretório de trabalho no contêiner
WORKDIR /app

# Copia os artefatos JAR de cada módulo a partir do build stage para este contêiner
COPY --from=builder /app/utilities/target/utilities-1.jar ./utilities-1.jar
COPY --from=builder /app/characters/target/characters-1.jar ./characters-1.jar
COPY --from=builder /app/users/target/users.jar-1 ./users-1.jar

# Expõe a porta do aplicativo Spring Boot de cada módulo (ajuste conforme necessário)
EXPOSE 8080 8081 8082

# Comando de execução para iniciar cada módulo (use a variável de ambiente definida acima)
CMD ["java", "-jar", "$RAILWAY_ENVIRONMENT.jar"]
