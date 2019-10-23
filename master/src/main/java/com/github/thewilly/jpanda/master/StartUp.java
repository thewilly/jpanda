package com.github.thewilly.jpanda.master;

import com.github.thewilly.jpanda.master.configuration.DefaultMasterNodeConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StartUp {

    private static final Logger logger = LoggerFactory.getLogger(StartUp.class);

    public static DefaultMasterNode masterNode;

    public static void main(String... args) {

        logger.debug("Starting application");

        masterNode = new DefaultMasterNode(new DefaultMasterNodeConfiguration(
                "",
                20,
                "",
                2,
                23,
                2
        ));

        logger.debug("Master node created");

        SpringApplication.run(StartUp.class, args);
    }
}
