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
        try {
            // Compute the greatest common divisor of the input parameters
            int gcd = greatestCommonDivisor(param1, param2);

            // Reduce the input parameters to their simplest form
            param1 /= gcd;
            param2 /= gcd;

            List<DataBaseInputFormat> databaseInputFormats = dataBaseRepository.getDatabaseInputFormats();
            int count = 0;

            for (DataBaseInputFormat inputFormat : databaseInputFormats) {
                String resolution = inputFormat.getResolution();

                if (isResolutionMatch(resolution, param1, param2)) {
                    count++;
                }
            }

            return count;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    private boolean isResolutionMatch(String resolution, int param1, int param2) {
        String[] resolutionParts = resolution.split("x");
        if (resolutionParts.length == 2) {
            try {
                int width = Integer.parseInt(resolutionParts[0]);
                int height = Integer.parseInt(resolutionParts[1]);

                int aspectRatioWidth = width / greatestCommonDivisor(width, height);
                int aspectRatioHeight = height / greatestCommonDivisor(width, height);

                return aspectRatioWidth == param1 && aspectRatioHeight == param2;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    private int greatestCommonDivisor(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

}
