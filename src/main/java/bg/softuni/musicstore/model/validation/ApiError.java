package bg.softuni.musicstore.model.validation;

import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

public class ApiError {

    private final HttpStatus httpStatus;
    private List<String> fieldWithErrors = new ArrayList<>();

    public ApiError(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void addFieldWithError(String error) {
        fieldWithErrors.add(error);
    }

    public List<String> getFieldWithErrors() {
        return fieldWithErrors;
    }

    public ApiError setFieldWithErrors(List<String> fieldWithErrors) {
        this.fieldWithErrors = fieldWithErrors;
        return this;
    }
}
