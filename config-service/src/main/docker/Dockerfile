# Version 0.0.1
FROM java:8

MAINTAINER harbor.luo "85098287@qq.com"

# 环境变量
ENV WORK_PATH=/home/project/ APP_NAME=config-service-1.0.jar APP_VERSION=1.0

EXPOSE 8088

#USER
#USER user:group

#VOLUME
VOLUME ["/home/project", "/tmp/data"]

#ADD

#COPY
COPY $APP_NAME $WORK_PATH/

#LABEL
#STOPSIGNAL
#ARG
#ONBUILD

#WORKDIR
WORKDIR $WORK_PATH

# ENTRYPOINT
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom"]

# CMD
CMD ["-jar", "$APP_NAME"]
