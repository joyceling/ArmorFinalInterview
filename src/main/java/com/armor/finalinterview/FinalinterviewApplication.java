package com.armor.finalinterview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@SpringBootApplication
@EntityScan(
        basePackageClasses = {FinalinterviewApplication.class, Jsr310JpaConverters.class}
)
public class FinalinterviewApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinalinterviewApplication.class, args);
    }
}
