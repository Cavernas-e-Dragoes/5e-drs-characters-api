# Define a imagem base do OpenJDK
FROM openjdk:17-oracle

# Define o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copia os arquivos JAR gerados pelo Maven para o contêiner
COPY --from=builder /app/users/target/*.jar users.jar
COPY --from=builder /app/characters/target/*.jar characters.jar

# Define o comando para executar o aplicativo de usuários
CMD ["java", "-jar", "users.jar"]

# Se desejar, pode definir um segundo comando para executar o aplicativo de personagens
# CMD ["java", "-jar", "characters.jar"]
