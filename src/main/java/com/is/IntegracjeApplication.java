package com.is;

import com.is.components.MainFrame;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class IntegracjeApplication {

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(IntegracjeApplication.class);
        builder.headless(false).run(args);
        new Thread(MainFrame::new).start();

    }

}
