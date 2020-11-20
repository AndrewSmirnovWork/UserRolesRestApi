package com.werdna.UserRolesRestApi.validation;

import java.util.ArrayList;
import java.util.List;

public class ValidatorError {

    private List<FiledError> fieldErrors = new ArrayList<>();

    public ValidatorError() {
    }

    public ValidatorError(List<FiledError> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }

    public List<FiledError> getFieldErrors() {
        return fieldErrors;
    }

    public void setFieldErrors(List<FiledError> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }
}
