FROM gradle:4.9.0-jdk8-slim
ARG app_name=loadtest
ENV APP_NAME=$app_name
ENV GRADLE_USER_HOME=/usr/src/.gradle

# RUN-CONTAINER BUILDER
USER root
WORKDIR /usr/src/${APP_NAME}
COPY ./src /usr/src/${APP_NAME}/src
COPY settings.gradle build.gradle /usr/src/${APP_NAME}/
CMD pwd && ls && gradle loadTest