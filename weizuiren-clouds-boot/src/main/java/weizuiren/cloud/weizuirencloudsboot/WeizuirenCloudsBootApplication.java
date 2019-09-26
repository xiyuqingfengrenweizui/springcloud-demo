package weizuiren.cloud.weizuirencloudsboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication(scanBasePackageClasses = WeizuirenCloudsBootApplication.class)
//@ComponentScan(value = "weizuiren.cloud.**")
public class WeizuirenCloudsBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeizuirenCloudsBootApplication.class, args);
    }

}
