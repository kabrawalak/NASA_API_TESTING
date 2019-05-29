package com.automated.testapi;

import com.automated.testapi.response.JSONCollectionResponse;
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
import static org.hamcrest.Matchers.*;

/*
    Test for /metadata endpoint.
    There are 2 tests:
    -   With dummy parameter
    -   With real parameter

    Real parameters are taken from api documentation.
*/

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MetadataEndpointTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private static final String ENDPOINT = "https://images-api.nasa.gov/metadata/";

    @Test
    public void metadata_WithDummyParameter_ReturnsStatusNotFound() {

        ResponseEntity<Object> responseEntity = restTemplate.getForEntity(ENDPOINT + UUID.randomUUID().toString(), Object.class);

        assertThat(responseEntity.getStatusCode(), is(HttpStatus.NOT_FOUND));
    }

    @Test
    public void metadata_With_Real_Parameter_ReturnsStatusOk() {
        String parameter = "as11-40-5874";
        ResponseEntity<Object> responseEntity = restTemplate.getForEntity(ENDPOINT + parameter, Object.class);

        assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));
        assertThat(responseEntity.getBody(), is(notNullValue()));
    }
}
