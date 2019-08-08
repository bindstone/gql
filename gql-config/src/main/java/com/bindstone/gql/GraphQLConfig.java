package com.bindstone.gql;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Import(GraphQLConfigRegistrar.class)
@Documented
public @interface GraphQLConfig {
    String basePackage() default "";
}
