FROM openjdk:11-jre-slim

ENV APPLICATION_USER ktor
RUN adduser --disabled-password  --gecos '' $APPLICATION_USER
ENV KTOR_ENV prod

RUN mkdir /application

RUN chown -R $APPLICATION_USER /application

USER $APPLICATION_USER

COPY ./build/libs/Minestom-Website-fat.jar /application/webserver.jar
WORKDIR /application

CMD ["java", "-server", "-jar", "webserver.jar"]