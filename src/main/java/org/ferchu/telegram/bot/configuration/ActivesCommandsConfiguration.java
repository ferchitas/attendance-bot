package org.ferchu.telegram.bot.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "bot")
public class ActivesCommandsConfiguration {

    private List<String> commands;

    public static class Command {

        private String name;

        public String getName() {

            return name;
        }

        public void setName(String name) {

            this.name = name;
        }
    }
}