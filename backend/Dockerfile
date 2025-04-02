# Étape 1 : image de base avec Java
FROM openjdk:17-jdk-slim

# Étape 2 : Crée un dossier dans le container pour ton app
WORKDIR /app

# Étape 3 : Copie le fichier JAR dans ce dossier
COPY target/backend-0.0.1-SNAPSHOT.jar app.jar

# Étape 4 : Lance le jar au démarrage du container
ENTRYPOINT ["java", "-jar", "app.jar"]

#1. On part d’une image avec Java 17 préinstallé
#2. On crée un dossier /app dans le container pour y mettre ton app
#3. On copie ton .jar compilé dans le container
#4. Quand le container démarre, il exécute ton .jar