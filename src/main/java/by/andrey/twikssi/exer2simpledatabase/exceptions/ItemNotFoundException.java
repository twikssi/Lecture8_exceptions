package by.andrey.twikssi.exer2simpledatabase.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ItemNotFoundException extends Exception{
    public static final Logger log = LoggerFactory.getLogger(ItemNotFoundException.class);

    public ItemNotFoundException() {
        log.info("No book with this id!!!");
    }
}
