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

/**

 @Autowired
 GraphQLDataFetchers graphQLDataFetchers;

 private GraphQL graphQL;

 @PostConstruct
 public void init() throws IOException {
 URL url = Resources.getResource("schema.graphqls");
 String sdl = Resources.toString(url, Charsets.UTF_8);
 GraphQLSchema graphQLSchema = buildSchema(sdl);
 this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
 }

 private GraphQLSchema buildSchema(String sdl) {
 TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(sdl);
 RuntimeWiring runtimeWiring = buildWiring();
 SchemaGenerator schemaGenerator = new SchemaGenerator();
 return schemaGenerator.makeExecutableSchema(typeRegistry, runtimeWiring);
 }

 private RuntimeWiring buildWiring() {
 return RuntimeWiring.newRuntimeWiring()
 .type(newTypeWiring("Query")
 .dataFetcher("Motorbike", graphQLDataFetchers.getMotorBikesDataFetcher()))
 .type(newTypeWiring("MotorbikeById")
 .dataFetcher("id", graphQLDataFetchers.getMotorBikeByIdDataFetcher()))
 .build();
 }

 @Bean
 public GraphQL graphQL() {
 return graphQL;
 }

 **/
