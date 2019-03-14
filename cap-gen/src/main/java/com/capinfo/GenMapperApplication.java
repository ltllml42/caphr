package com.capinfo;

import org.springframework.boot.SpringApplication;

/*@SpringBootConfiguration
@EnableAutoConfiguration
@MapperScan(basePackages ={"com.capinfo.mappers"},markerInterface = MyBaseMapper.class)*/
public class GenMapperApplication {

    public static void main(String[] args) {
        SpringApplication.run(GenMapperApplication.class,args);
    }
}
