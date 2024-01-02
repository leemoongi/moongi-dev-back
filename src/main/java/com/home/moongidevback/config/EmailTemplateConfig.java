package com.home.moongidevback.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;

@Configuration
public class EmailTemplateConfig {

    @Bean
    public TemplateEngine htmlTemplateEngin(SpringResourceTemplateResolver springResourceTemplateResolver) {
        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.addTemplateResolver(springResourceTemplateResolver);

        return templateEngine;
    }
}
