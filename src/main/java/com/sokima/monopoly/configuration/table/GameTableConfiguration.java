package com.sokima.monopoly.configuration.table;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "monopoly.game-table.custom")
public class GameTableConfiguration {

    private String tableName = "Default Monopoly";
    private Integer diceCount = 2;
    private Long startUpMoney = 15000L;
    private Integer userCount = 4;
}
