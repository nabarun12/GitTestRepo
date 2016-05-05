package server;

import java.io.IOException;
import java.util.Arrays;





import java.util.concurrent.TimeoutException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;


//import com.thoughtworks.xstream.io.json.JsonWriter;

@SpringBootApplication
@ComponentScan(basePackages = {"controller","inputprocessor","service"})
public class FalloutServer {

    public static void main(String[] args) {
    	//System.setProperty("spring.config.name", "application-service");
        SpringApplication.run(FalloutServer.class, args);
    }

}