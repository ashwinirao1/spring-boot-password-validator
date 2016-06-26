package com.rest.password.validator.integration;

import static org.junit.Assert.assertEquals;

import com.rest.password.validator.constants.ControllerPathConstants;
import com.rest.password.validator.response.GenericResponse;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * The Class ValidationControllerIntegrationTest.
 */
public class ValidationControllerIntegrationTest extends BaseIntegrationTest {

    /**
     * Test validate password.
     */
    @Test
    public void testValidatePassword() {
        String password = "zawertyuiopasdWR1";
        final ResponseEntity<GenericResponse> response = testRestTemplate.getForEntity(test_base_url + ControllerPathConstants.VALIDATE_URL + "?password=" + password, GenericResponse.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    /**
     * Test validate password minimum exact.
     */
    @Test
    public void testValidatePasswordMinimumExact() {
        String password = "zawerWR1";// 8 characters
        final ResponseEntity<GenericResponse> response = testRestTemplate.getForEntity(test_base_url + ControllerPathConstants.VALIDATE_URL + "?password=" + password, GenericResponse.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    /**
     * Test validate password maximum exact.
     */
    @Test
    public void testValidatePasswordMaximumExact() {
        String password = "12345678901234567Wu";// 19 characters
        final ResponseEntity<GenericResponse> response = testRestTemplate.getForEntity(test_base_url + ControllerPathConstants.VALIDATE_URL + "?password=" + password, GenericResponse.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    /**
     * Test validate invalid url.
     */
    @Test
    public void testValidateInvalidUrl() {
        String password = "";
        final ResponseEntity<GenericResponse> response = testRestTemplate.getForEntity(test_base_url + ControllerPathConstants.VALIDATE_URL + "/hack/" + "?password=" + password, GenericResponse.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    /**
     * Test validate size constraint minimum.
     */
    @Test
    public void testValidateSizeConstraintMinimum() {
        String password = "1234567";
        final ResponseEntity<GenericResponse> response = testRestTemplate.getForEntity(test_base_url + ControllerPathConstants.VALIDATE_URL + "?password=" + password, GenericResponse.class);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    /**
     * Test validate size constraint maximum.
     */
    @Test
    public void testValidateSizeConstraintMaximum() {
        String password = "1234567890aB1234567890";
        final ResponseEntity<GenericResponse> response = testRestTemplate.getForEntity(test_base_url + ControllerPathConstants.VALIDATE_URL + "?password=" + password, GenericResponse.class);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    /**
     * Test validate constraint upper case.
     */
    @Test
    public void testValidateConstraintUpperCase() {
        String password = "testvalidateword1";
        final ResponseEntity<GenericResponse> response = testRestTemplate.getForEntity(test_base_url + ControllerPathConstants.VALIDATE_URL + "?password=" + password, GenericResponse.class);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    /**
     * Test validate constraint lower case.
     */
    @Test
    public void testValidateConstraintLowerCase() {
        String password = "TESTVALIDATEWORD1";
        final ResponseEntity<GenericResponse> response = testRestTemplate.getForEntity(test_base_url + ControllerPathConstants.VALIDATE_URL + "?password=" + password, GenericResponse.class);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    /**
     * Test validate constraint number.
     */
    @Test
    public void testValidateConstraintNumber() {
        String password = "TESTVALIDATEwordw";
        final ResponseEntity<GenericResponse> response = testRestTemplate.getForEntity(test_base_url + ControllerPathConstants.VALIDATE_URL + "?password=" + password, GenericResponse.class);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    /**
     * Test validate constraint sequence.
     */
    @Test
    public void testValidateConstraintSequence() {
        String password = "TEs1TVALIDATEDATE";
        final ResponseEntity<GenericResponse> response = testRestTemplate.getForEntity(test_base_url + ControllerPathConstants.VALIDATE_URL + "?password=" + password, GenericResponse.class);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    /**
     * Test validate constraint sequence numbers.
     */
    @Test
    public void testValidateConstraintSequenceNumbers() {
        String password = "TEs1TVALI1111";
        final ResponseEntity<GenericResponse> response = testRestTemplate.getForEntity(test_base_url + ControllerPathConstants.VALIDATE_URL + "?password=" + password, GenericResponse.class);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    /**
     * Test validate constraint sequence numbers and letters mixed.
     */
    @Test
    public void testValidateConstraintSequenceMixed() {
        String password = "TEs1TVALId1d1";
        final ResponseEntity<GenericResponse> response = testRestTemplate.getForEntity(test_base_url + ControllerPathConstants.VALIDATE_URL + "?password=" + password, GenericResponse.class);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }
}
