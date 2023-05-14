package com.is.web;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;
import com.is.format.database.DataBaseInputFormat;
import com.is.format.xml.XMLInputFormat;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface LaptopService {
    @WebMethod
    List<String> getAllDistinctProducers();

    @WebMethod
    int getNumberOfRecordsByProducer(String producer);

    @WebMethod
    List<String> getAllDistinctScreenTypes();

    @WebMethod
    List<XMLInputFormat> getRecordsByScreenType(String screenType);

    @WebMethod
    int customMethod(int param1, int param2);
}
