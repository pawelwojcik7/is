package com.is.menager;

import com.is.database.Connector;
import com.is.database.DataBaseRepository;
import com.is.exception.ReadDataException;
import com.is.exception.SaveDataException;
import com.is.format.database.DataBaseInputFormat;
import com.is.model.ComputerInfo;

import java.sql.SQLException;
import java.util.List;

public class DataBaseInputFormatManager implements InputFormatManager {
    @Override
    public List<ComputerInfo> getRecords() throws ReadDataException {
        Connector dataBaseConnector;
        try {
            dataBaseConnector = new Connector();
            if (!dataBaseConnector.isTableExist("laptops")) {
                dataBaseConnector.createLaptopsTable();
            }
            DataBaseRepository repository = new DataBaseRepository(dataBaseConnector);
            return repository.getDatabaseInputFormats().stream().map(DataBaseInputFormat::toComputerInfo).toList();
        } catch (SQLException | ClassNotFoundException e) {
            throw new ReadDataException(e.getMessage());
        }
    }

    @Override
    public void saveRecords(List<ComputerInfo> computerInfos) throws SaveDataException {
        Connector dataBaseConnector;
        try {
            dataBaseConnector = new Connector();
            if (!dataBaseConnector.isTableExist("laptops")) {
                dataBaseConnector.createLaptopsTable();
            }
            DataBaseRepository repository = new DataBaseRepository(dataBaseConnector);
            List<DataBaseInputFormat> list = computerInfos.stream().map(DataBaseInputFormat::convert).toList();
            for (DataBaseInputFormat format : list) {
                try {
                    repository.saveDataBaseInputFormat(format);
                } catch (SQLException e) {
                    throw new SaveDataException(e.getMessage());
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new SaveDataException(e.getMessage());
        }
    }
}
