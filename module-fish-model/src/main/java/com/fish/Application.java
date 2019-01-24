package com.fish;

import com.fish.bean.People;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner{

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired private People people;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        String config = "david.name: " + people.getName()
                    + ", david.age:" + people.getAge()
                    + ", david.sex:" + people.getSex();

        log.info("SpringBoot2.0实现自定义properties配置文件与JavaBean映射:" + config);
    }

}
