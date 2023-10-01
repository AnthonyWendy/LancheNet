package com.br.lanchenet.travelBag.error;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestControllerAdvice
public class validation extends ResponseEntityExceptionHandler {

    public class Validacao extends ResponseEntityExceptionHandler {

        @Override
        protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                      HttpHeaders headers, HttpStatusCode status, WebRequest request) {

            List<ErrorObject> errors = getErrors(ex);

            ErrorResponseTony error = buildErrorResponse();

            return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
        }

        private List<ErrorObject> getErrors(MethodArgumentNotValidException ex) {
            return ex.getBindingResult().getFieldErrors().stream()
                    .map(error -> new ErrorObject(error.getDefaultMessage(), error.getField(), error.getRejectedValue()))
                    .collect(Collectors.toList());
        }


    }

//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
//        List<ErrorObject> errors = getErrors(ex);
//        ErrorResponseTony errorResponse = getErrorResponse(ex, status, errors);
//        return new ResponseEntity<>(errorResponse, status);
//    }
//
//    private ErrorResponseTony getErrorResponse(MethodArgumentNotValidException ex, HttpStatusCode status, List<ErrorObject> errors) {
//        return new ErrorResponseTony("Requisição possui campos inválidos", status.value(),
//                status.toString(), ex.getBindingResult().getObjectName(), errors);
//    }
//
//    private List<ErrorObject> getErrors(MethodArgumentNotValidException ex) {
//        return ex.getBindingResult().getFieldErrors().stream()
//                .map(error -> new ErrorObject(error.getDefaultMessage(), error.getField(), error.getRejectedValue()))
//                .collect(Collectors.toList());
//    }
}

