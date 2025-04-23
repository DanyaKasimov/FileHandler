package app;

import app.config.RowConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties({RowConfig.class})
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class FileHandlerServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(FileHandlerServiceApplication.class, args);
    }
}