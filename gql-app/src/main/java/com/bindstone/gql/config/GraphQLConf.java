package com.bindstone.gql.config;

import com.bindstone.gql.GraphQLConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
@GraphQLConfig(basePackage = "com.bindstone.gql.graphql")
public class GraphQLConf {

    public GraphQLConf() {
        System.out.println("............GraphQLConf...........");
    }
}
