package com.maskibth.util;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class DataGenerator {

    private static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static SecureRandom stringRandom = new SecureRandom();

    public static String generateStringFor(int length) {
        StringBuilder builder = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            builder.append(AB.charAt(stringRandom.nextInt(AB.length())));
        }
        return builder.toString();
    }

    public void generate(String fileWithAbsolutePath, int rowCount) {

        int columnCount = 18;

        List<String[]> rows = new ArrayList<>();
        rows.add(DataGenerator.generateHeaders());

        for (int i = 1; i < rowCount; i++) {
            String[] row = new String[columnCount];
            row[0] = Integer.toString(DataGenerator.generateIntegerFor(50));
            row[1] = DataGenerator.generateStringFor(20);
            row[2] = DataGenerator.generateStringFor(8);
            row[3] = DataGenerator.generateStringFor(19);
            row[4] = DataGenerator.generateStringFor(10);
            row[5] = DataGenerator.generateRandomDates(1900, 2016);
            row[6] = DataGenerator.generateRandomDates(1900, 2016);
            row[7] = DataGenerator.generateStringFor(20);
            row[8] = Integer.toString(DataGenerator.generateIntegerFor(1000));
            row[9] = Integer.toString(DataGenerator.generateIntegerFor(5));
            row[10] = DataGenerator.generateRandomDates(2015, 2016);
            row[11] = DataGenerator.generateStringFor(4);
            row[12] = DataGenerator.generateStringFor(8);

            row[13] = DataGenerator.generateStringFor(8);
            row[14] = DataGenerator.generateStringFor(17);
            row[15] = DataGenerator.generateStringFor(9);
            row[16] = DataGenerator.generateStringFor(14);
            row[17] = DataGenerator.generateStringFor(19);
            rows.add(row);
        }

        CsvGenerator.writeCsv(fileWithAbsolutePath, rows);

    }

    private static int generateIntegerFor(int max) {
        return stringRandom.nextInt(max - 1) + 1;
    }

    private static String[] generateHeaders() {
        String headerString = "col1Int,col2String,col3String,col4String,col5String,col6Date, col7date,col8String, col9Int, col10Int, col11Date, col12String, col13String, col14String, col15String," +
                "col16String, col17String, Col18String";
        return headerString.split(",");
    }

    private static String generateRandomDates(int fromYear, int toYear) {
        GregorianCalendar gc = new GregorianCalendar();
        int year = randBetween(fromYear, toYear);
        gc.set(gc.YEAR, year);
        int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
        gc.set(gc.DAY_OF_YEAR, dayOfYear);
        return gc.getTime().toString();
    }

    private static int randBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

}
