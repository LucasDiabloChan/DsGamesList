# Etapa 1: Construir o projeto
FROM eclipse-temurin:latest AS build
WORKDIR /build

# Copiar os arquivos do projeto
COPY ./mvnw ./mvnw
COPY ./pom.xml ./pom.xml
COPY ./.mvn ./.mvn
COPY ./src ./src

# Instalar dependências e construir o projeto
RUN chmod +x ./mvnw
RUN ./mvnw clean package -DskipTests

# Etapa 2: Criar a imagem final
FROM eclipse-temurin:latest
WORKDIR /app

# Copiar o JAR gerado para o container final
COPY --from=build /build/target/*.jar app.jar

# Expor a porta padrão do Spring Boot
EXPOSE 8080

# Comando para rodar a aplicação
CMD ["java", "-jar", "app.jar"]
