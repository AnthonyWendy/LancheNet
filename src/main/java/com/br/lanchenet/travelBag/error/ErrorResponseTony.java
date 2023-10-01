package com.br.lanchenet.travelBag.error;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ErrorResponseTony {
    private final int code;
    private final String status;
    private final String objectName;
    private final List<ErrorObject> errors;
}
