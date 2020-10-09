FROM openjdk:8-jre
LABEL Description="Starts Movie List API"

COPY ./build/libs/movie-list-api.jar /opt/movie-list/movie-list-api.jar

WORKDIR /opt/movie-list

ENV API_PORT=80
ENV STORE_SERVICE_API=http://localhost:9080

EXPOSE $SERVICE_PORT

CMD java -jar ./movie-list-api.jar

