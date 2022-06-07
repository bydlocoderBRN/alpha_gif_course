FROM openjdk:17-alpine
EXPOSE 8081
RUN apk update
RUN apk add gradle
WORKDIR gifRate
COPY . .
