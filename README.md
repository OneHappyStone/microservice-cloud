### config-repository
This is the config server of spring cloud environment!

### Config-Server
当ConfigServer启动后，会以一下形式发布Rest资源请求:
- `/{application}/{profile}[/{label}]`
  
- `/{application}-{profile}.yml`
  
- `/{label}/{application}-{profile}.yml`
  
- `/{application}-{profile}.properties`
  
- `/{label}/{application}-{profile}.properties` 
所以你可以访问 (http://localhost:10001/eureka-server/development/master)地址来测试。
其中`springcloud/eureka`为`spring.config.name`属性，`development`为`spring.profiles.active`属性，`master`为git的`label`属性，默认为`master`。

### Eureka-Server
当Eureka-Server启动时，会优先根据配置的`spring.config.url`请求Config-Server中的配置属性加载到Spring容器环境中。


### Hystrix
1. Hystrix Dashboard可以成为独立服务来部署。
2. 而要监控的app中集成Hystrix，服务启动后，需要进行访问后才可以在dashboard展现出(ps:如果服务器尚未执行任何命令来生成度量，hystrix.stream servlet将循环无限地等待度量。 由于它保持循环没有数据，它永远不会尝试写入输出流。）

# 未完，待续。。。。。。。。。。