package com.bindstone.gql;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;

public class GraphQLConfigRegistrar implements ImportBeanDefinitionRegistrar, ResourceLoaderAware, ApplicationContextAware {

    private static ApplicationContext context;

    public static ApplicationContext getApplicationContext() {
        return context;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        System.out.println("........setResourceLoader........");
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        System.out.println("........registerBeanDefinitions........");

        AnnotationAttributes mapperScanAttrs = AnnotationAttributes
                .fromMap(importingClassMetadata.getAnnotationAttributes(GraphQLConfig.class.getName()));
        if (mapperScanAttrs != null) {
            System.out.println(mapperScanAttrs);
            String[] basePackages = mapperScanAttrs.getStringArray("basePackage");
            if(basePackages != null && basePackages.length > 0) {
                scanBasePackages(basePackages);
            }
        }
    }

    private void scanBasePackages(String[] basePackages) {
        for (String basePackage : basePackages) {
            System.out.println(basePackage);
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
}
