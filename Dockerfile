# Define a imagem base do OpenJDK
FROM adoptopenjdk:17-jdk-hotspot

# Define o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copia os arquivos JAR gerados pelo Maven para o contêiner
COPY users/target/*.jar users.jar
COPY characters/target/*.jar characters.jar

# Define o comando para executar o aplicativo de usuários
CMD ["java", "-jar", "users.jar"]

# Se desejar, pode definir um segundo comando para executar o aplicativo de personagens
# CMD ["java", "-jar", "characters.jar"]
