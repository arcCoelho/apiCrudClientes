package com.clientsup.sgc.dto.errors;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class CustomListError extends CustomError{
    private List<FieldMessage> fieldMessage = new ArrayList<>();

    public CustomListError(Instant timestamp, Integer status, String error, String path) {
        super(timestamp, status, error, path);
    }

    public List<FieldMessage> getFieldMessage() {
        return fieldMessage;
    }

    public void addFieldMessage(String field, String msg){
        this.fieldMessage.add(new FieldMessage(field, msg));
    }
}
