package com.is.validator.implementation;

import com.is.model.Either;
import com.is.validator.TableCellValidator;

public class ResolutionValidator implements TableCellValidator {
    private final static String resolutionRegex = "\\d+x\\d+";

    private final static String message = " doesn't match regex: NxN";

    @Override
    public Either<String, Boolean> validate(String value) {
        if (value.matches(resolutionRegex) || value.equals("")) {
            return new Either<String, Boolean>().right(true);
        } else return new Either<String, Boolean>().left("[ " + value + " ]" + message);
    }

}
