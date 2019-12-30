package xyz.ipkr.pokercloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(encoding = "UTF-8", value = {"classpath:config/mqtt.properties"})
@MapperScan(basePackages = "xyz.ipkr.pokercloud.mapper")
public class PokercloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(PokercloudApplication.class, args);
    }

}
