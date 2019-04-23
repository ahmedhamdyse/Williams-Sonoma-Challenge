package com.williamssonoma.challenge.williamssonomachallenge;

import com.williamssonoma.challenge.williamssonomachallenge.service.ZipCodeProcessor;
import com.williamssonoma.challenge.williamssonomachallenge.service.ZipCodeValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
@Slf4j
public class WilliamsSonomaChallengeApplication implements CommandLineRunner {

    @Autowired
    private ZipCodeProcessor zipCodeProcessor;

    @Autowired
    private ZipCodeValidator zipCodeValidator;

    public static void main(String[] args) {
        SpringApplication.run(WilliamsSonomaChallengeApplication.class, args);
    }

    @Override
    public void run(String... args) {
        zipCodeProcessor.processZipCodes(zipCodeValidator.validSortedZipCodes(Arrays.asList(args))).forEach(zipCode -> log.info(zipCode.toString()));
    }
}
