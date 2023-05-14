package com.is.web;

import com.is.database.DataBaseRepository;
import com.is.format.database.DataBaseInputFormat;
import com.is.format.xml.XMLInputFormat;

import javax.jws.WebService;
import java.sql.SQLException;
import java.util.List;

@WebService(endpointInterface = "com.is.web.LaptopService")
public class LaptopServiceImpl implements LaptopService {
    private final DataBaseRepository dataBaseRepository;

    public LaptopServiceImpl(DataBaseRepository dataBaseRepository) {
        this.dataBaseRepository = dataBaseRepository;
    }

    @Override
    public List<String> getAllDistinctProducers() {
        try {
            return dataBaseRepository.getAllDistinctProducers();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int getNumberOfRecordsByProducer(String producer) {
        try {
            return dataBaseRepository.getNumberOfRecordsByProducer(producer);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public List<String> getAllDistinctScreenTypes() {
        try {
            return dataBaseRepository.getAllDistinctScreenTypes();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<XMLInputFormat> getRecordsByScreenType(String screenType) {
        try {
            return dataBaseRepository.getRecordsByScreenType(screenType).stream().map(DataBaseInputFormat::toXMLInputFormat).toList();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public int customMethod(int param1, int param2) {
        // Implementacja metody zostanie dodana później
        return 0;
    }
}
