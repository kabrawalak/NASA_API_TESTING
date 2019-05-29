package com.automated.testapi;

import com.automated.testapi.response.JSONCollectionResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;


/*
    Test for /album endpoint.
    There are 3 tests:
    -   With dummy parameter
    -   Real parameter
    -   Real parameter with page number

    Real parameters are taken from api documentation.
*/


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AlbumEndpointTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private static final String ENDPOINT = "https://images-api.nasa.gov/album/";

    @Test
    public void captions_WithDummyParameter_ReturnsStatusNotFound() {

        ResponseEntity<Object> responseEntity = restTemplate.getForEntity(ENDPOINT + UUID.randomUUID().toString(), Object.class);

        assertThat(responseEntity.getStatusCode(), is(HttpStatus.NOT_FOUND));

    }


    @Test
    public void captions_With_Real_Parameter_ReturnsStatusOk() {
        String parameter = "Test";
        ResponseEntity<JSONCollectionResponse> responseEntity = restTemplate.getForEntity(ENDPOINT + parameter, JSONCollectionResponse.class);

        assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));
        assertThat(responseEntity.getBody().getCollection().getItems().length, greaterThan(0));
    }

    @Test
    public void captions_With_Real_Parameter_AndPageNumber_ReturnsStatusOk() {
        String parameter = "Test";
        String page = "2";
        ResponseEntity<JSONCollectionResponse> responseEntity = restTemplate.getForEntity(ENDPOINT + parameter + "?page=" + page, JSONCollectionResponse.class);

        assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));
        assertThat(responseEntity.getBody().getCollection().getItems().length, greaterThan(0));
    }
}
