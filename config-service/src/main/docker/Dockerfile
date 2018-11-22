# Version 0.0.1
FROM java:8

MAINTAINER Ryuu KK "85098287@qq.com"

# 环境变量
ENV WORK_PATH /home/project/
ENV APP_NAME config-service
ENV APP_VERSION 1.0

EXPOSE 8088

#USER
#USER user:group

#VOLUME
VOLUME ["/home/project", "/tmp/data"]

#ADD

#COPY
COPY $APP_NAME-$APP_VERSION.jar $WORK_PATH/

#LABEL
#STOPSIGNAL
#ARG
#ONBUILD

# WORKDIR
WORKDIR $WORK_PATH

# ENTRYPOINT
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom"]

# CMD
CMD ["-jar", "$APP_NAME-$APP_VERSION.jar"]
