package com.bindstone.gql;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Component
@Inherited
public @interface GraphQLService {
}
