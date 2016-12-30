package com.thoughtworks.salestax.util;

import com.thoughtworks.salestax.ex.ParseException;
import com.thoughtworks.salestax.model.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemParserTest {
    private ItemParser parser;

    @BeforeEach
    void setUp() {
        parser = new ItemParser();
    }

    @Test
    void parseItemProperlyCreatesItem() throws Exception {
        String line = "1 bottle of perfume at 18.99";

        Item item = parser.parseItem(line, "test.txt");

        assertEquals(item, new Item("bottle of perfume", 18.99, 1));
    }

    @Test
    void badInputThrowsException() {
        String line = "Hello there!";

        Throwable exception = assertThrows(ParseException.class, () -> {
            Item item = parser.parseItem(line, "test.txt");
        });
        assertEquals("\r\nError parsing the following line in test.txt:\r\nHello there!\r\n" +
                "Be sure input is in the following format: '[quantity] [item description] at [price]'",
                exception.getMessage());
    }
}