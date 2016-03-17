package com.springapp.mvc.configuration.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

/**
 * Created by Anton on 06.03.2016.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.springapp.mvc")
public class AppConfig extends WebMvcConfigurerAdapter{

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer matcher) {
        matcher.setUseRegisteredSuffixPatternMatch(true);
    }

    @Bean
    public UrlBasedViewResolver viewResolver(){
        UrlBasedViewResolver configurer = new UrlBasedViewResolver();
        configurer.setViewClass(TilesView.class);
        return configurer;
    }
    @Bean
    public TilesConfigurer tilesConfigurer(){
        TilesConfigurer configurer = new TilesConfigurer();
        configurer.setDefinitions("/WEB-INF/defs/general.xml");

        return configurer;
    }

    /*@Override
    public void configureViewResolvers(ViewResolverRegistry registry) {

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/pages/registration/");
        viewResolver.setSuffix(".jsp");
        registry.viewResolver(viewResolver);
    }*/
    /* Configuration resource like css*/



}
