package com.persen.beijing.log4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainLog4J {

    public static final Logger LOGGER = LoggerFactory.getLogger(MainLog4J.class
            .getName());

    public static void main(String[] args) {
        String payId = "11";
        LOGGER.info("payId[{}]", payId);
    }
}
