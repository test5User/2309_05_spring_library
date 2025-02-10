package by.itclass.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@ComponentScan({"by.itclass.controllers"})
public class MvcConfig {
    @Bean
    public ViewResolver viewResolver() {
        return new InternalResourceViewResolver("/pages/", ".jsp");
    }
}
