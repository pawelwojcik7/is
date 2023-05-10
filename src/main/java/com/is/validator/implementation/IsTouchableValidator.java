package com.is.validator.implementation;

import com.is.model.Either;
import com.is.validator.TableCellValidator;
import com.is.validator.models.IsTouchable;

import java.util.Arrays;

public class IsTouchableValidator implements TableCellValidator {
    private final String message = " doesn't exist in touchable types: " + Arrays.toString(Arrays.stream(IsTouchable.values()).map(IsTouchable::getCode).toArray());

    @Override
    public Either<String, Boolean> validate(String value) {

        if (Arrays.stream(IsTouchable.values()).anyMatch(e -> e.getCode().equals(value)) || value.equals("")) {
            return new Either<String, Boolean>().right(true);
        } else return new Either<String, Boolean>().left("[ " + value + " ]" + message);
    }
}
