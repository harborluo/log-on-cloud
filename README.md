[![JDK](http://img.shields.io/badge/JDK-v8.0-yellow.svg)](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
[![Build](http://img.shields.io/badge/Build-Maven_3-green.svg)](https://maven.apache.org/)
[![License](http://img.shields.io/badge/License-Apache_2-red.svg)](http://www.apache.or``g/licenses/LICENSE-2.0)


本项目包含以下`feature`的演示
1. 服务发现与注册
2. 服务的消费
3. 配置中心化

## 总览

启动顺序  |服务名称             | 功能               | 默认占用端口号 | Docker宿主机端口映射  
----------|---------------------|--------------------|----------------|-------------------
1         |config-service       | 配置服务           | 8088           | 8088
2         |discovery-service    | 服务发现与注册服务 | 8061           | 8061            
3         |notification-service | 日志通知服务       | 8090           | 8090        
3         |web-ui-service       | web ui 服务        | 8091           | 8091
4         |message-service      | 信息服务           | 8089           | 8089     

## 许可证

[Apache 2.0](LICENSE)

## 联系我

![QQ](http://img.shields.io/badge/QQ-85098287-blue.svg)
![WeChat](http://img.shields.io/badge/WeChat-harbor_luo-blue.svg)
![Email](http://img.shields.io/badge/Email-85098287@qq.com-blue.svg)