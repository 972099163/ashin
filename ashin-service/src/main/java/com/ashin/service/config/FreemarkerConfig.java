package com.ashin.service.config;//package com.debug.springboot.server.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Properties;
//
////Freemarker配置
//@Configuration
//public class FreemarkerConfig {
//
//    @Bean
//    public FreeMarkerConfigurer freeMarkerConfigurer(){
//        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
//        configurer.setTemplateLoaderPath("classpath:/templates");
//
//        Map<String, Object> variables = new HashMap<>(1);
//        //可以全局性的设置freemarker变量-用于前端页面使用
//        configurer.setFreemarkerVariables(variables);
//
//        Properties settings = new Properties();
//        settings.setProperty("default_encoding", "utf-8");
//        settings.setProperty("number_format", "0.##");
//        configurer.setFreemarkerSettings(settings);
//        return configurer;
//    }
//
//}
