package com.sap.devcamp.bookstore.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Data @Slf4j @ToString @NoArgsConstructor @AllArgsConstructor public class ErrorResponse {

    private String timestamp;
    private int status;
    private String error;
    private String exception;
    private String message;
    private String path;

    public String asJson ()
    throws JsonProcessingException {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            log.warn("Could not write ErrorResponses as Json: {}", toString());
            throw e;
        }
    }

}
