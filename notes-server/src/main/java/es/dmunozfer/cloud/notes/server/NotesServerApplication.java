package es.dmunozfer.cloud.notes.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableDiscoveryClient
@SpringBootApplication
public class NotesServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotesServerApplication.class, args);
    }

}
