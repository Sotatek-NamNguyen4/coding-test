package com.sotatek.codingTest.ApiResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse <T extends  Object> {

    private int responseCode;

    private String messageCode;

    private T data;

    public ApiResponse (HttpStatus httpStatus, T data) {
        this.responseCode = httpStatus.value();
        this.messageCode = httpStatus.getReasonPhrase();
        this.data = data;
    }

    public ApiResponse (HttpStatus httpStatus) {
        this.responseCode = httpStatus.value();
        this.messageCode = httpStatus.getReasonPhrase();
    }

}
