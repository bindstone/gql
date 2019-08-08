package com.bindstone.gql;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface GraphQLDataFetcher {
    String fieldName() default "";
}
