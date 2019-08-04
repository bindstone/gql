package com.bindstone.gql.graphql;

import com.bindstone.gql.sevices.MotorBikeService;
import com.google.common.collect.ImmutableMap;
import graphql.schema.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
public class GraphQLDataFetchers {

    @Autowired
    MotorBikeService motorBikeService;

    public DataFetcher getMotorBikesDataFetcher() {
        return dataFetchingEnvironment -> {
            return motorBikeService.getAll();
        };
    }

    public DataFetcher getMotorBikeByIdDataFetcher() {
        return dataFetchingEnvironment -> {
            Long id = dataFetchingEnvironment.getArgument("id");
            return motorBikeService.getById(id);
        };
    }
}
