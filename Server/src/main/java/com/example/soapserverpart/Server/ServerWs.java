package com.example.soapserverpart.Server;

import jakarta.xml.ws.Endpoint;
import com.example.soapserverpart.Webervice.ProductWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(scanBasePackages = {"com.example.soapserverpart"})
public class ServerWs {

    @Autowired
    private ProductWebService productWebService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ServerWs.class, args);
        ServerWs server = context.getBean(ServerWs.class);
        server.publishWebService();
    }

    private void publishWebService() {
        String url = "http://localhost:8088/";
        try {
            Endpoint.publish(url, productWebService);
            System.out.println("Web service deployed at: " + url);
        } catch (Exception e) {
            System.err.println("Failed to publish web service: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
