package com.bindstone.gql.graphql;

import com.bindstone.gql.GraphQLDataFetcher;
import com.bindstone.gql.GraphQLService;
import com.bindstone.gql.sevices.MotorBikeService;
import graphql.schema.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@GraphQLService
public class GraphQLDataFetchers {

    @Autowired
    MotorBikeService motorBikeService;

    @GraphQLDataFetcher
    public DataFetcher getMotorBikesDataFetcher() {
        return dataFetchingEnvironment -> {
            return motorBikeService.getAll();
        };
    }

    @GraphQLDataFetcher
    public DataFetcher getMotorBikeByIdDataFetcher() {
        return dataFetchingEnvironment -> {
            Long id = dataFetchingEnvironment.getArgument("id");
            return motorBikeService.getById(id);
        };
    }
}
