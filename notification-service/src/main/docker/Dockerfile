# Version 0.0.1
FROM java:8

MAINTAINER harbor.luo "85098287@qq.com"

# 环境变量
ENV WORK_PATH=/home/project/ APP_NAME=notification-service-1.0.jar APP_VERSION=1.0

EXPOSE 8090

#USER
#USER user:group

#VOLUME
VOLUME ["/home/project", "/tmp/data"]

#ADD

#COPY
COPY notification-service-1.0.jar $WORK_PATH/

#LABEL
#STOPSIGNAL
#ARG
#ONBUILD

#WORKDIR
WORKDIR $WORK_PATH

# ENTRYPOINT
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom"]

# CMD
CMD ["-jar", "notification-service-1.0.jar"]
