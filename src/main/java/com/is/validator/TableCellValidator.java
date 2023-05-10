package com.is.validator;

import com.is.model.Either;

public interface TableCellValidator {

    Either<String, Boolean> validate(String value);

}
