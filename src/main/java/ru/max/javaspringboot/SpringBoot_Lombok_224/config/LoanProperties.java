package ru.max.javaspringboot.SpringBoot_Lombok_224.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ConfigurationProperties(prefix = "loan")
public class LoanProperties {
    private Double minimalIncome;
    private Double maxCredit;
    private Double carCredit;
}
