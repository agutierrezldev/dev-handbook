package com.agutierrezl.spring_reactor.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum CustomError {
    BAD_REQUEST(400, "Bad Request", HttpStatus.BAD_REQUEST),
    NOT_FOUND(404, "Not Found", HttpStatus.NOT_FOUND),
    DEFAULT(500, "Internal Error", HttpStatus.INTERNAL_SERVER_ERROR);

    private final int status;
    private final String error;
    private final HttpStatus httpStatus;


    CustomError(int status, String error, HttpStatus httpStatus) {
        this.status = status;
        this.error = error;
        this.httpStatus = httpStatus;
    }

    public static CustomError fromStatus(int status) {
        for (CustomError e : values()) {
            if (e.status == status) return e;
        }
        return DEFAULT;
    }
}
