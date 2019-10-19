package com.bindstone.gql;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class GraphQLConfigRegistrar implements ImportBeanDefinitionRegistrar, ResourceLoaderAware, ApplicationContextAware {

    private static ApplicationContext context;

    public static ApplicationContext getApplicationContext() {
        return context;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {}

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
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
            findAnnotatedClasses(basePackage);
        }
    }

    public void findAnnotatedClasses(String scanPackage) {
        ClassPathScanningCandidateComponentProvider provider = createComponentScanner();
        for (BeanDefinition beanDef : provider.findCandidateComponents(scanPackage)) {
            printMetadata(beanDef);
        }
    }

    private ClassPathScanningCandidateComponentProvider createComponentScanner() {
        ClassPathScanningCandidateComponentProvider provider
                = new ClassPathScanningCandidateComponentProvider(false);
        provider.addIncludeFilter(new AnnotationTypeFilter(GraphQLService.class));
        return provider;
    }

    private void printMetadata(BeanDefinition beanDef) {
        try {
            Class<?> cl = Class.forName(beanDef.getBeanClassName());

            GraphQLService findable = cl.getAnnotation(GraphQLService.class);
            System.out.printf("Found class: %s",
                    cl.getSimpleName());

            for (Method method : cl.getMethods()) {
                GraphQLDataFetcher annotation = AnnotationUtils.findAnnotation(method, GraphQLDataFetcher.class);
                if (Objects.nonNull(annotation)) {
                    System.out.println(annotation);
                }
            }
        } catch (Exception e) {
            System.err.println("Got exception: " + e.getMessage());
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
}
