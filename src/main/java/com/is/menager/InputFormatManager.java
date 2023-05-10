package com.is.menager;

import com.is.exception.ReadDataException;
import com.is.exception.SaveDataException;
import com.is.model.ComputerInfo;

import java.util.List;

public interface InputFormatManager {

    List<ComputerInfo> getRecords() throws ReadDataException;

    void saveRecords(List<ComputerInfo> computerInfos) throws SaveDataException;


}
