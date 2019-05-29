package com.automated.testapi;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

/*
    Test for /asset endpoint.
    There are 3 tests:
    -   With dummy parameter
    -   With wrong parameter
    -   With real parameter

    Real parameters are taken from api documentation.
*/

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CaptionsEndpointTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private static final String ENDPOINT = "https://images-api.nasa.gov/captions/";

    @Test
    public void captions_WithDummyParameter_ReturnsStatusNotFound() {

        ResponseEntity<Object> responseEntity = restTemplate.getForEntity(ENDPOINT + UUID.randomUUID().toString(), Object.class);

        assertThat(responseEntity.getStatusCode(), is(HttpStatus.NOT_FOUND));
    }

    @Test
    public void captions_With_Wrong_Parameter_ReturnsStatusBadRequest() {
        String parameter = "as11-40-5874";
        ResponseEntity<Object> responseEntity = restTemplate.getForEntity(ENDPOINT + parameter, Object.class);

        assertThat(responseEntity.getStatusCode(), is(HttpStatus.BAD_REQUEST));
    }

    @Test
    public void captions_With_Real_Parameter_ReturnsStatusOk() {
        String parameter = "172_ISS-Slosh";
        ResponseEntity<Object> responseEntity = restTemplate.getForEntity(ENDPOINT + parameter, Object.class);

        assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));
        assertThat(responseEntity.getBody(), is(notNullValue()));
    }
}
