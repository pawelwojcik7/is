package com.is.web;

import javax.jws.WebMethod;


import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import java.util.List;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface LaptopService {
    @WebMethod
    List<String> getAllDistinctProducers();

    @WebMethod
    int getNumberOfRecordsByProducer(String producer);
}
