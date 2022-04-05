package ru.digitalleague.ocs.internship.lesson16;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Chapter02 {

    public static final Logger log = LoggerFactory.getLogger(Chapter02.class);

    public static void main(String[] args) {
        log.error("Some error");
        log.warn("Some warn");
        log.info("Some info");
        log.debug("Some debug");
        log.trace("Some trace");

//        User16 user = new User16("iivanov@test.com", "Иван Иванов");
//        log.debug("User is " + user.getEmail());
//        if (log.isDebugEnabled()) {
//            log.debug("User is " + user.getEmail());
//        }
//        log.debug("User is {}", user.getEmail());
    }

}
