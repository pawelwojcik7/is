package com.is.web;

import com.is.database.Connector;
import com.is.database.DataBaseRepository;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import javax.xml.ws.Endpoint;
import java.sql.SQLException;


@Configuration
public class WebServiceConfig {

    private final Bus bus;

    public WebServiceConfig(Bus bus) {
        this.bus = bus;
    }

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

    @Bean
    @Order(1)
    public ServletRegistrationBean<CXFServlet> servletRegistrationBean() {
        return new ServletRegistrationBean<>(new CXFServlet(), "/services/*");
    }
}
