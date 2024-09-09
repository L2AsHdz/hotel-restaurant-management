package com.sa.employeemicroservice.common.application.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
public class EntityNotFoudException extends Exception {
    private final ProblemDetail detail;

    public EntityNotFoudException(String message) {
        super(message);

        this.detail = ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, message);
        this.detail.setProperty("datetime", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        this.detail.setTitle("Error Interno");
    }
}
