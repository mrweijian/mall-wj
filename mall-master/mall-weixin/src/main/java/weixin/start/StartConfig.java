package weixin.start;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = {"weixin.*"})
public class StartConfig {
}
