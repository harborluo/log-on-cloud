[![JDK](http://img.shields.io/badge/JDK-v8.0-yellow.svg)](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
[![Build](http://img.shields.io/badge/Build-Maven_2-green.svg)](https://maven.apache.org/)
[![License](http://img.shields.io/badge/L``icense-Apache_2-red.svg)](http://www.apache.or``g/licenses/LICENSE-2.0)


本项目包含以下`feature`的演示
1. 服务发现与注册
2. 服务的消费
3. 配置中心化

## 总览

服务名称           | 功能            | 默认占用端口号 | Docker宿主机端口映射  
-------------------|-----------------|----------------|-------------------
discovery-service    | 服务发现与注册服务 | 8061      | 8061              
config-service       | 配置服务           | 8088      | 8088              
message-service      | 信息服务           | 8089      | 8089             
notification-service | 日志通知服务       | 8090      | 8090              
