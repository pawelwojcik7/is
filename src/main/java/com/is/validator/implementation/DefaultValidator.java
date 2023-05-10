package com.is.validator.implementation;

import com.is.model.Either;
import com.is.validator.TableCellValidator;

public class DefaultValidator implements TableCellValidator {
    @Override
    public Either<String, Boolean> validate(String value) {
        return new Either<String, Boolean>().right(true);
    }
}
