package com.is.validator.implementation;

import com.is.model.Either;
import com.is.validator.TableCellValidator;

public class ProducerValidator implements TableCellValidator {

    private final static String onlyLettersRegex = "^[a-zA-Z]+$";

    private final static String message = " doesn't match format: Only letters";

    @Override
    public Either<String, Boolean> validate(String value) {
        if (value.matches(onlyLettersRegex) || value.equals("")) {
            return new Either<String, Boolean>().right(true);
        } else return new Either<String, Boolean>().left("[ " + value + " ]" + message);
    }
}
