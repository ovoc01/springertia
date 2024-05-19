package com.vue.inertiajs.demo.configuration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.noar.inert.js.core.InertiaRendererAspect;
import com.noar.inert.js.core.InertiaView;

@Configuration
@EnableAspectJAutoProxy
public class InertiaConfigurer {
    @Bean
    public InertiaView inertiaView(ApplicationContext applicationContext) {
        return new InertiaView(applicationContext);
    }

    @Bean
    public InertiaRendererAspect inertiaRendererAspect() {
        return new InertiaRendererAspect();
    }
}
