package com.thoughtworks.salestax.ex;

public class ParseException extends RuntimeException {
    /**
     * Thrown when an {@link com.thoughtworks.salestax.util.ItemParser} cannot parse a line
     * @param line The line that was passed in
     * @param fileName The name of the file the line came from
     */
    public ParseException(String line, String fileName) {
        super(String.format("%nError parsing the following line in %s:%n%s%n" +
                "Be sure input is in the following format: " +
                "'[quantity] [item description] at [price]'", fileName, line));
    }
}
