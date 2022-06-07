package com.victor.bookstoreapi.controller.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class FieldMessage implements Serializable {

    private String filedName;
    private String message;
}
