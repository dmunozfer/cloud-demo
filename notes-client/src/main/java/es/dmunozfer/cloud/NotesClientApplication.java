package es.dmunozfer.cloud;

import es.dmunozfer.cloud.notes.client.messaging.channel.NotesChannel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.annotation.IntegrationComponentScan;

@EnableBinding(NotesChannel.class)
@IntegrationComponentScan
@EnableFeignClients
@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class NotesClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotesClientApplication.class, args);
    }
}
