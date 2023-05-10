package com.is.web;

import com.is.database.Connector;
import com.is.database.DataBaseRepository;
import lombok.RequiredArgsConstructor;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;
import java.sql.SQLException;

@Configuration
@RequiredArgsConstructor
public class WebServiceConfig {

    private final Bus bus;

    @Bean
    public Endpoint endpoint() {
        DataBaseRepository repository;
        try {
            repository = new DataBaseRepository(new Connector());
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        EndpointImpl endpoint = new EndpointImpl(bus, new LaptopServiceImpl(repository));
        endpoint.publish("/LaptopService");
        return endpoint;
    }
}
