package com.automated.testapi;

import com.automated.testapi.response.JSONCollectionResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
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
import org.springframework.web.util.UriBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

import org.apache.http.client.utils.URIBuilder;

/*
    Test for /search endpoint.
    There are 2 inner classes:
    -   Without parameter:
        -   1 Test run for no parameters set
    -   With parameter
        -   27 Tests are run.
        -   Dummy value tests failed
        -   Real parameter test are run successfully

    Real parameters are taken from api documentation.
*/

class SearchEndpointTest {

    private static final String ENDPOINT = "https://images-api.nasa.gov/search";

    @Nested
    @ExtendWith(SpringExtension.class)
    @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
    public class With_No_Parameters_Test {

        @Autowired
        private TestRestTemplate restTemplate;

        @Test
        public void search_WithNoPathVariables_ReturnsStatusBadRequest() {

            ResponseEntity<Object> responseEntity = restTemplate.getForEntity(ENDPOINT, Object.class);

            assertThat(responseEntity.getStatusCode(), is(HttpStatus.BAD_REQUEST));
        }

    }

    @Nested
    @ExtendWith(SpringExtension.class)
    @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
    public class With_Dummy_Parameters_Test {

        @Autowired
        private TestRestTemplate restTemplate;

        private URIBuilder uri;
        private Map<String, String> params;

        @BeforeEach
        public void setUp() {
            try {
                uri = new URIBuilder(ENDPOINT);
            } catch (Exception e) {

            }
            params = new HashMap<>();

            params.put("q", "apollo 2011");
            params.put("center", "HQ");

            //Dont have any specific description currently
            //params.put("description", "");

            //Dont have any specific description_508 currently
            //params.put("description_508", "");
            params.put("keywords", "Atlantis");
            params.put("location", "NASA Kennedy Space Center");
            params.put("media_type", "image");
            params.put("nasa_id", "201211020033HQ");
            params.put("page", "1");

            //Dont have any specific photographer currently
            //params.put("photographer", "NASA/Bill Ingalls");

            //Dont have any specific secondary_creator currently
            //params.put("secondary_creator", "");
            params.put("title", "Space Shuttle Atlantis Move");
            params.put("year_start", "1000");
            params.put("year_end", "2100");

        }

        @Test
        public void search_WithDummy_Q_Parameter_ReturnsStatusOK_WithEmptyItemsArray() {
            uri.addParameter("q", UUID.randomUUID().toString());

            ResponseEntity<JSONCollectionResponse> responseEntity = restTemplate.getForEntity(uri.toString(), JSONCollectionResponse.class);

            assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));
            assertThat(responseEntity.getBody().getCollection().getItems().length, is(0));
        }

        @Test
        public void search_WithDummy_Center_Parameter_ReturnsStatusOK_WithEmptyItemsArray() {
            uri.addParameter("center", UUID.randomUUID().toString());

            ResponseEntity<JSONCollectionResponse> responseEntity = restTemplate.getForEntity(uri.toString(), JSONCollectionResponse.class);

            assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));
            assertThat(responseEntity.getBody().getCollection().getItems().length, is(0));
        }

        @Test
        public void search_WithDummy_Description_Parameter_ReturnsStatusOK_WithEmptyItemsArray() {
            uri.addParameter("description", UUID.randomUUID().toString());

            ResponseEntity<JSONCollectionResponse> responseEntity = restTemplate.getForEntity(uri.toString(), JSONCollectionResponse.class);

            assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));
            assertThat(responseEntity.getBody().getCollection().getItems().length, is(0));
        }

        @Test
        public void search_WithDummy_Description_508_Parameter_ReturnsStatusOK_WithEmptyItemsArray() {
            uri.addParameter("description_508", UUID.randomUUID().toString());

            ResponseEntity<JSONCollectionResponse> responseEntity = restTemplate.getForEntity(uri.toString(), JSONCollectionResponse.class);

            assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));
            assertThat(responseEntity.getBody().getCollection().getItems().length, is(0));
        }

        @Test
        public void search_WithDummy_Keywords_Parameter_ReturnsStatusOK_WithEmptyItemsArray() {
            uri.addParameter("keywords", UUID.randomUUID().toString());

            ResponseEntity<JSONCollectionResponse> responseEntity = restTemplate.getForEntity(uri.toString(), JSONCollectionResponse.class);

            assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));
            assertThat(responseEntity.getBody().getCollection().getItems().length, is(0));
        }

        @Test
        public void search_WithDummy_Location_Parameter_ReturnsStatusOK_WithEmptyItemsArray() {
            uri.addParameter("location", UUID.randomUUID().toString());

            ResponseEntity<JSONCollectionResponse> responseEntity = restTemplate.getForEntity(uri.toString(), JSONCollectionResponse.class);

            assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));
            assertThat(responseEntity.getBody().getCollection().getItems().length, is(0));
        }

        @Test
        public void search_WithDummy_Media_Type_Parameter_ReturnsStatusOK_WithEmptyItemsArray() {
            uri.addParameter("media_type", UUID.randomUUID().toString());

            ResponseEntity<JSONCollectionResponse> responseEntity = restTemplate.getForEntity(uri.toString(), JSONCollectionResponse.class);

            assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));
            assertThat(responseEntity.getBody().getCollection().getItems().length, is(0));
        }

        @Test
        public void search_WithDummy_Nasa_Id_Parameter_ReturnsStatusOK_WithEmptyItemsArray() {
            uri.addParameter("nasa_id", UUID.randomUUID().toString());

            ResponseEntity<JSONCollectionResponse> responseEntity = restTemplate.getForEntity(uri.toString(), JSONCollectionResponse.class);

            assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));
            assertThat(responseEntity.getBody().getCollection().getItems().length, is(0));
        }

        @Test
        public void search_WithDummy_Page_Parameter_As_String_ReturnsStatusBadRequest() {
            uri.addParameter("page", UUID.randomUUID().toString());

            ResponseEntity<JSONCollectionResponse> responseEntity = restTemplate.getForEntity(uri.toString(), JSONCollectionResponse.class);

            assertThat(responseEntity.getStatusCode(), is(HttpStatus.BAD_REQUEST));

        }

        @Test
        public void search_WithDummy_Page_Parameter_Missing_Q_Paramater_ReturnsStatusBadRequest() {
            uri.addParameter("page", UUID.randomUUID().toString());

            ResponseEntity<JSONCollectionResponse> responseEntity = restTemplate.getForEntity(uri.toString(), JSONCollectionResponse.class);

            assertThat(responseEntity.getStatusCode(), is(HttpStatus.BAD_REQUEST));
        }

        @Test
        public void search_WithDummy_Photographer_Parameter_ReturnsStatusOK_WithEmptyItemsArray() {
            uri.addParameter("photographer", UUID.randomUUID().toString());

            ResponseEntity<JSONCollectionResponse> responseEntity = restTemplate.getForEntity(uri.toString(), JSONCollectionResponse.class);

            assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));
            assertThat(responseEntity.getBody().getCollection().getItems().length, is(0));
        }

        @Test
        public void search_WithDummy_Secondary_Creator_Parameter_ReturnsStatusOK_WithEmptyItemsArray() {
            uri.addParameter("secondary_creator", UUID.randomUUID().toString());

            ResponseEntity<JSONCollectionResponse> responseEntity = restTemplate.getForEntity(uri.toString(), JSONCollectionResponse.class);

            assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));
            assertThat(responseEntity.getBody().getCollection().getItems().length, is(0));
        }

        @Test
        public void search_WithDummy_Title_Parameter_ReturnsStatusOK_WithEmptyItemsArray() {
            uri.addParameter("title", UUID.randomUUID().toString());

            ResponseEntity<JSONCollectionResponse> responseEntity = restTemplate.getForEntity(uri.toString(), JSONCollectionResponse.class);

            assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));
            assertThat(responseEntity.getBody().getCollection().getItems().length, is(0));
        }

        @Test
        public void search_WithDummy_Year_Start_Parameter_WithoutFormat_ReturnsStatusBadRequest() {
            uri.addParameter("year_start", UUID.randomUUID().toString());

            ResponseEntity<JSONCollectionResponse> responseEntity = restTemplate.getForEntity(uri.toString(), JSONCollectionResponse.class);

            assertThat(responseEntity.getStatusCode(), is(HttpStatus.BAD_REQUEST));
        }

        @Test
        public void search_WithDummy_Year_End_Parameter_WithoutFormat_ReturnsStatusBadRequest() {
            uri.addParameter("year_end", UUID.randomUUID().toString());

            ResponseEntity<JSONCollectionResponse> responseEntity = restTemplate.getForEntity(uri.toString(), JSONCollectionResponse.class);

            assertThat(responseEntity.getStatusCode(), is(HttpStatus.BAD_REQUEST));

        }

        // All parameters are set as random string
        @Test
        public void search_WithDummy_All_Parameter_With_Wrong_Format_ReturnsStatusBadRequest() {
            uri.addParameter("q", UUID.randomUUID().toString());
            uri.addParameter("center", UUID.randomUUID().toString());
            uri.addParameter("description", UUID.randomUUID().toString());
            uri.addParameter("description_508", UUID.randomUUID().toString());
            uri.addParameter("keywords", UUID.randomUUID().toString());
            uri.addParameter("location", UUID.randomUUID().toString());
            uri.addParameter("media_type", UUID.randomUUID().toString());
            uri.addParameter("nasa_id", UUID.randomUUID().toString());
            uri.addParameter("page", UUID.randomUUID().toString());
            uri.addParameter("photographer", UUID.randomUUID().toString());
            uri.addParameter("secondary_creator", UUID.randomUUID().toString());
            uri.addParameter("title", UUID.randomUUID().toString());
            uri.addParameter("year_start", UUID.randomUUID().toString());
            uri.addParameter("year_end", UUID.randomUUID().toString());

            ResponseEntity<JSONCollectionResponse> responseEntity = restTemplate.getForEntity(uri.toString(), JSONCollectionResponse.class);

            assertThat(responseEntity.getStatusCode(), is(HttpStatus.BAD_REQUEST));

        }

        //Year and Integer parameters are set in correct format
        @Test
        public void search_WithDummy_All_Parameter_With_Correct_Format_ReturnsStatusOK_WithEmptyItemsArray() {
            Random random = new Random();
            uri.addParameter("q", UUID.randomUUID().toString());
            uri.addParameter("center", UUID.randomUUID().toString());
            uri.addParameter("description", UUID.randomUUID().toString());
            uri.addParameter("description_508", UUID.randomUUID().toString());
            uri.addParameter("keywords", UUID.randomUUID().toString());
            uri.addParameter("location", UUID.randomUUID().toString());
            uri.addParameter("media_type", UUID.randomUUID().toString());
            uri.addParameter("nasa_id", UUID.randomUUID().toString());
            uri.addParameter("page", String.valueOf(random.nextInt(10)));
            uri.addParameter("photographer", UUID.randomUUID().toString());
            uri.addParameter("secondary_creator", UUID.randomUUID().toString());
            uri.addParameter("title", UUID.randomUUID().toString());
            uri.addParameter("year_start", String.valueOf(random.nextInt(8999) + 1000));
            uri.addParameter("year_end", String.valueOf(random.nextInt(8999) + 1000));

            ResponseEntity<JSONCollectionResponse> responseEntity = restTemplate.getForEntity(uri.toString(), JSONCollectionResponse.class);

            assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));
            assertThat(responseEntity.getBody().getCollection().getItems().length, is(0));
        }

        @Test
        public void search_With_Real_Q_Parameter_ReturnsStatusOK_WithNonEmptyItemsArray() {
            uri.addParameter("q", params.get("q"));

            ResponseEntity<JSONCollectionResponse> responseEntity = restTemplate.getForEntity(uri.toString(), JSONCollectionResponse.class);

            assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));
            assertThat(responseEntity.getBody().getCollection().getItems().length, greaterThan(0));
        }

        @Test
        public void search_With_Real_Center_Parameter_ReturnsStatusOK_WithNonEmptyItemsArray() {
            uri.addParameter("center", params.get("center"));

            ResponseEntity<JSONCollectionResponse> responseEntity = restTemplate.getForEntity(uri.toString(), JSONCollectionResponse.class);

            assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));
            assertThat(responseEntity.getBody().getCollection().getItems().length, greaterThan(0));
        }

        @Test
        public void search_With_Real_Keywords_Parameter_ReturnsStatusOK_WithNonEmptyItemsArray() {
            uri.addParameter("keywords", params.get("keywords"));

            ResponseEntity<JSONCollectionResponse> responseEntity = restTemplate.getForEntity(uri.toString(), JSONCollectionResponse.class);

            assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));
            assertThat(responseEntity.getBody().getCollection().getItems().length, greaterThan(0));
        }

        @Test
        public void search_With_Real_Location_Parameter_ReturnsStatusOK_WithNonEmptyItemsArray() {
            uri.addParameter("location", params.get("location"));

            ResponseEntity<JSONCollectionResponse> responseEntity = restTemplate.getForEntity(uri.toString(), JSONCollectionResponse.class);

            assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));
            assertThat(responseEntity.getBody().getCollection().getItems().length, greaterThan(0));
        }

        @Test
        public void search_With_Real_Media_Tyep_Parameter_ReturnsStatusOK_WithNonEmptyItemsArray() {
            uri.addParameter("media_type", params.get("media_type"));

            ResponseEntity<JSONCollectionResponse> responseEntity = restTemplate.getForEntity(uri.toString(), JSONCollectionResponse.class);

            assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));
            assertThat(responseEntity.getBody().getCollection().getItems().length, greaterThan(0));
        }

        @Test
        public void search_With_Real_Nasa_Id_Parameter_ReturnsStatusOK_WithNonEmptyItemsArray() {
            uri.addParameter("nasa_id", params.get("nasa_id"));

            ResponseEntity<JSONCollectionResponse> responseEntity = restTemplate.getForEntity(uri.toString(), JSONCollectionResponse.class);

            assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));
            assertThat(responseEntity.getBody().getCollection().getItems().length, greaterThan(0));
        }

        @Test
        public void search_With_Real_Title_Parameter_ReturnsStatusOK_WithNonEmptyItemsArray() {
            uri.addParameter("title", params.get("title"));

            ResponseEntity<JSONCollectionResponse> responseEntity = restTemplate.getForEntity(uri.toString(), JSONCollectionResponse.class);

            assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));
            assertThat(responseEntity.getBody().getCollection().getItems().length, greaterThan(0));
        }

        @Test
        public void search_With_Real_Year_Start_Parameter_ReturnsStatusOK_WithNonEmptyItemsArray() {
            uri.addParameter("year_start", params.get("year_start"));

            ResponseEntity<JSONCollectionResponse> responseEntity = restTemplate.getForEntity(uri.toString(), JSONCollectionResponse.class);

            assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));
            assertThat(responseEntity.getBody().getCollection().getItems().length, greaterThan(0));
        }

        @Test
        public void search_With_Real_Year_End_Parameter_ReturnsStatusOK_WithNonEmptyItemsArray() {
            uri.addParameter("year_end", params.get("year_end"));

            ResponseEntity<JSONCollectionResponse> responseEntity = restTemplate.getForEntity(uri.toString(), JSONCollectionResponse.class);

            assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));
            assertThat(responseEntity.getBody().getCollection().getItems().length, greaterThan(0));
        }

        @Test
        public void search_With_Real_All_Parameters_ReturnsStatusOK_WithNonEmptyItemsArray() {

            params.entrySet().stream()
                    .forEach(val -> uri.addParameter(val.getKey(), val.getValue()));

            ResponseEntity<JSONCollectionResponse> responseEntity = restTemplate.getForEntity(uri.toString(), JSONCollectionResponse.class);

            assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));
            assertThat(responseEntity.getBody().getCollection().getItems().length, greaterThan(0));
        }

    }


}
