package com.is;

import com.is.components.MainFrame;
import com.is.database.Connector;
import com.is.database.DataBaseRepository;
import com.is.web.LaptopServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import javax.xml.ws.Endpoint;
import java.sql.SQLException;

@SpringBootApplication
public class IntegracjeApplication {

	public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(IntegracjeApplication.class);
		builder.headless(false).run(args);
		new Thread(MainFrame::new).start();

	}

}
