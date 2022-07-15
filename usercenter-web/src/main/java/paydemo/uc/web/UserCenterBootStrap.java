package paydemo.uc.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @auther YDXiaa
 * <p>
 * userCenter启动类.
 */
@SpringBootApplication(scanBasePackages = "paydemo")
@EnableTransactionManagement
@MapperScan(basePackages = "paydemo.uc.dao.mapper")
public class UserCenterBootStrap {

    public static void main(String[] args) {
        SpringApplication.run(UserCenterBootStrap.class, args);
    }

}
