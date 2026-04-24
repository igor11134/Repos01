FROM node:20-alpine AS build
WORKDIR /app
COPY package.json tsconfig.json vite.config.ts ./
COPY public ./public
COPY src ./src
RUN npm install
RUN npm run build

FROM node:20-alpine AS runtime
WORKDIR /app
RUN npm install -g serve
COPY --from=build /app/dist ./dist
EXPOSE 4173
CMD ["serve", "-s", "dist", "-l", "4173"]
