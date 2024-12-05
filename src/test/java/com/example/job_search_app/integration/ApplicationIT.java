package com.example.job_search_app.integration;

import com.example.job_search_app.dto.ApplicationDTO;
import com.example.job_search_app.dto.UserDTO;
import com.example.job_search_app.dto.UserReqDTO;
import com.example.job_search_app.entities.ApplicationStatus;
import com.example.job_search_app.entities.Role;
import com.example.job_search_app.utils.Constants;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class ApplicationIT {

    @Autowired
    private WebTestClient webTestClient;

//    int userId = 1;
    String USER_URI = Constants.BASED_URL + Constants.USERS;
    String register =  "api/v1/auth/register";

    ApplicationDTO request = new ApplicationDTO(
            "Full stack", "2 years python", "HCSC", "chicago",
            LocalDate.now(), ApplicationStatus.IN_PROGRESS
    );

    UserReqDTO requestUser = new UserReqDTO(
            1,
            "Abderrahmane",
            "Seyid",
            "mseyid@miu.edu",
            "Software Engineer",
            "1234",
            Role.ADMIN
    );

    String APP_URI = USER_URI + "/" + requestUser.id() + Constants.APPLICATIONS;

//    @Test
//    void canRegisterApplication() {
//        webTestClient.post().uri(USER_URI)
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON)
//                .body(Mono.just(requestUser), UserDTO.class)
//                .exchange()
//                .expectStatus()
//                .isOk();
//        // Send POST request to register a new application
//        webTestClient.post()
//                .uri(APP_URI)
//                .accept(MediaType.APPLICATION_JSON)
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(Mono.just(request), ApplicationDTO.class)
//                .exchange()
//                .expectStatus()
//                .isOk() // Expect a 200 OK status if successfully inserted
//                .expectBody(ApplicationDTO.class)
//                .consumeWith(response -> {
//                    ApplicationDTO responseBody = response.getResponseBody();
//                    assertThat(responseBody).isNotNull();
//                });
//    }

    @Test
    void canGetAll() {
        // Register new user
        webTestClient.post().uri(register)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(requestUser), UserDTO.class)
                .exchange()
                .expectStatus()
                .isOk();
        // Post a new application first to ensure there is data
        webTestClient.post()
                .uri(APP_URI)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(request), ApplicationDTO.class)
                .exchange()
                .expectStatus()
                .isOk();

        // Retrieve all applications for the user
        List<ApplicationDTO> allApplications = webTestClient.get()
                .uri(APP_URI)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(ApplicationDTO.class)
                .returnResult().getResponseBody();

        // Verify the list of applications
        assertThat(allApplications).isNotNull().hasSize(1);
    }
}
