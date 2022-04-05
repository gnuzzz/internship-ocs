package ru.digitalleague.ocs.internship.lesson16;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testcontainers.shaded.org.bouncycastle.util.test.SimpleTest;

public class Chapter01 {

    public static final Logger log = LoggerFactory.getLogger(Chapter01.class);

    public static void main(String[] args) throws Exception {
//        log.error("Some error");
//        log.warn("Some warn");
//        log.info("Some info");
//        log.debug("Some debug");
//        log.trace("Some trace");

        User16 user = new User16("iivanov@test.com", "Иван Иванов");
//        log.debug("User is " + user.getEmail());
//        if (log.isDebugEnabled()) {
//            log.debug("User is " + user.getEmail());
//        }
        for (int i = 0; i < 1000; i++) {
            log.debug("User is {}", user.getEmail());
            Thread.sleep(1000);
        }
    }

}
