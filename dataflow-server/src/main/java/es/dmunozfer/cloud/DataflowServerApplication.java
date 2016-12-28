package es.dmunozfer.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.session.SessionAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.dataflow.server.EnableDataFlowServer;

@EnableDataFlowServer
@EnableDiscoveryClient
@SpringBootApplication(exclude = SessionAutoConfiguration.class)
public class DataflowServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataflowServerApplication.class, args);
    }
}
