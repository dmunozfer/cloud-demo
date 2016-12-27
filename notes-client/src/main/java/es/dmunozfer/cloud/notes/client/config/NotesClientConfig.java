package es.dmunozfer.cloud.notes.client.config;

import org.springframework.cloud.sleuth.Sampler;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by David Muñoz on 27/12/2016.
 */
@Configuration
public class NotesClientConfig {

    @Bean
    public Sampler defaultSampler() {
        return new AlwaysSampler();
    }
}
