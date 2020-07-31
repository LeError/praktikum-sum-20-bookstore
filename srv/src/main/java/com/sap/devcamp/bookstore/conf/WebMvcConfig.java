package com.sap.devcamp.bookstore.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration public class WebMvcConfig
implements WebMvcConfigurer {

    @Override public void addViewControllers (ViewControllerRegistry registry) {
        registry.addViewController("/admin").setViewName("forward:/admin/index.htm");
        registry.addViewController("/").setViewName("forward:/app/index.htm");
    }

}