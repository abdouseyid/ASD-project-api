//package com.example.job_search_app;
//
//import org.junit.jupiter.api.Test;
//import org.testcontainers.containers.PostgreSQLContainer;
//import org.testcontainers.junit.jupiter.Container;
//import org.testcontainers.junit.jupiter.Testcontainers;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//
//
//@Testcontainers
//public class TestContainerTest {
//    @Container
//    private static final PostgreSQLContainer<?> postgreSQLContainer
//            = new PostgreSQLContainer<>("postgres:latest")
//            .withDatabaseName("job_tracker_unit_test")
//            .withUsername("postgres")
//            .withPassword("postgres");
//    @Test
//    void canStart() {
//	    assertThat(postgreSQLContainer.isCreated()).isTrue();
//	    assertThat(postgreSQLContainer.isRunning()).isTrue();
//    }
//}
