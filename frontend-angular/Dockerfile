# Étape 1 : Image officielle Node.js pour construire l'app Angular
FROM node:20 as build

# Dossier de travail
WORKDIR /app

# Copie des fichiers package.json et package-lock.json
COPY package*.json ./

# Installation des dépendances
RUN npm install

# Copie de tous les fichiers Angular
COPY . .

# Build de l'application Angular pour la prod
RUN npm run build --prod

# Étape 2 : Serveur NGINX pour servir le frontend
FROM nginx:alpine

# Copie du build Angular dans le dossier nginx
COPY --from=build /app/dist/frontend/browser /usr/share/nginx/html
COPY nginx/default.conf /etc/nginx/conf.d/default.conf
# Exposition du port 80
EXPOSE 80

# Lancement de nginx
CMD ["nginx", "-g", "daemon off;"]
