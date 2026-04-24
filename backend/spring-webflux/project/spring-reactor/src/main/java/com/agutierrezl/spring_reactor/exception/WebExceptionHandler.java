package com.agutierrezl.spring_reactor.exception;

import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.webflux.autoconfigure.error.AbstractErrorWebExceptionHandler;
import org.springframework.boot.webflux.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Component
//@Order(Ordered.HIGHEST_PRECEDENCE)
@Order(-1)
public class WebExceptionHandler extends AbstractErrorWebExceptionHandler {

    public WebExceptionHandler(ErrorAttributes errorAttributes, WebProperties.Resources resources, ApplicationContext applicationContext, ServerCodecConfigurer configurer) {
        super(errorAttributes, resources, applicationContext);
        setMessageWriters(configurer.getWriters());
    }

    @Override
    protected RouterFunction<ServerResponse> getRoutingFunction(ErrorAttributes errorAttributes) {
        return RouterFunctions.route(RequestPredicates.all(), this::renderErrorResponse); //e -> renderErrorResponse(e)
    }

    private Mono<ServerResponse> renderErrorResponse(ServerRequest e) {
        Map<String, Object> generalError = getErrorAttributes(e, ErrorAttributeOptions.defaults());
//        Map<String, Object> customError = new HashMap<>();

        Throwable error = getError(e);
        int codeStatus = Integer.parseInt(String.valueOf(generalError.get("status")));
//        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

//        System.out.println(error.getMessage());

//        switch (codeStatus) {
//            case 200:
//                customError.put("message", error.getMessage());
//                customError.put("stats", codeStatus);
//                httpStatus = HttpStatus.BAD_REQUEST;
//
//            case 400, 402:
//                customError.put("message", error.getMessage());
//                customError.put("stats", codeStatus);
//                httpStatus = HttpStatus.BAD_REQUEST;
//
//            default:
//                customError.put("message", error.getMessage());
//                customError.put("stats", codeStatus);
//                httpStatus = HttpStatus.I_AM_A_TEAPOT;
//        }

        CustomError customError = CustomError.fromStatus(codeStatus);
        Map<String, Object> response = new HashMap<>();
        response.put("status",customError.getStatus());
        response.put("error",customError.getError());
        response.put("details", Arrays.asList(error.getMessage().split("; ")));

        return ServerResponse.status(customError.getHttpStatus())
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(response));
    }
}
