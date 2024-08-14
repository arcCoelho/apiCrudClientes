package com.clientsup.sgc.dto.errors;

public class FieldMessage {

    private String field;
    private String msg;

    public FieldMessage(String field, String msg) {
        this.field = field;
        this.msg = msg;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
