package com.datachampions.Data.Champions.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@EnableScheduling
public class AppConfig {

    private static final String BASE_URL = "https://br1.api.riotgames.com";

    @Value("${riot.api.key}")
    private String riotApiKey;

    @Bean
    @Qualifier("regionalWebClient") // Nome para o cliente REGIONAL
    public WebClient regionalWebClient() {
        return WebClient.builder()
                .baseUrl("https://br1.api.riotgames.com") // URL REGIONAL
                .defaultHeader("X-Riot-Token", riotApiKey)
                .build();
    }

    @Bean
    @Qualifier("platformWebClient") // Nome para o cliente de PLATAFORMA
    public WebClient platformWebClient() {
        return WebClient.builder()
                .baseUrl("https://americas.api.riotgames.com") // URL DE PLATAFORMA
                .defaultHeader("X-Riot-Token", riotApiKey)
                .build();
    }
}
