package com.ms;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
@MapperScan("com.ms.dao")
public class MiaoShaDemoApplication {
    //日志对象
    private static final Logger LOG = LoggerFactory.getLogger(MiaoShaDemoApplication.class);

    public static void main(String[] args)
    {
        //SpringApplication.run(MiaoShaDemoApplication.class, args);
        SpringApplication app = new SpringApplication(MiaoShaDemoApplication.class);
        ConfigurableEnvironment evn = app.run(args).getEnvironment();
        LOG.info("Tomcat启动成功！");
        LOG.info("启动地址：\thttp://127.0.0.1:{}",evn.getProperty("server.port"));
    }

}
