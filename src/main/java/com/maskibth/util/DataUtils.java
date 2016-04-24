package com.maskibth.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.*;

class DataUtils {

    private static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static SecureRandom stringRandom = new SecureRandom();
    private static String[] currencyArray;

    static String generateRandomString(int length) {
        StringBuilder builder = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            builder.append(AB.charAt(stringRandom.nextInt(AB.length())));
        }
        return builder.toString();
    }

    static int generateRandomInteger(int max) {
        return stringRandom.nextInt(max - 1) + 1;
    }

    static String generateRandomDate(int fromYear, int toYear) {
        GregorianCalendar gc = new GregorianCalendar();
        int year = randBetween(fromYear, toYear);
        gc.set(gc.YEAR, year);
        int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
        gc.set(gc.DAY_OF_YEAR, dayOfYear);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ");
        return format.format(gc.getTime());
    }

    private static int randBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    static String generateRandomCurrency() {
        if (currencyArray == null || currencyArray.length < 1) {
            readCurrencyFromFile();
        }
        return currencyArray[stringRandom.nextInt(166)];
    }

    private static void readCurrencyFromFile() {
        List<String> currencyList = new ArrayList<>();
        BufferedReader br = null;
        try {
            FileInputStream fstream = new FileInputStream("src/main/resources/currency.txt");
            br = new BufferedReader(new InputStreamReader(fstream));

            String strLine;

            while ((strLine = br.readLine()) != null) {
                // Print the content on the console
                currencyList.add(strLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        currencyArray = new String[currencyList.size()];
        currencyList.toArray(currencyArray);
    }

    static String[] generate20Headers() {
        List<String> colList = new ArrayList<>();
        int i = 1;
        colList.add("col" + i++ + "Int");
        colList.add("col" + i++ + "String");
        colList.add("col" + i++ + "String");
        colList.add("col" + i++ + "String");
        colList.add("col" + i++ + "String");
        colList.add("col" + i++ + "Date");
        colList.add("col" + i++ + "Date");
        colList.add("col" + i++ + "String");
        colList.add("col" + i++ + "Int");
        colList.add("col" + i++ + "Int");
        colList.add("col" + i++ + "Date");
        colList.add("col" + i++ + "String");
        colList.add("col" + i++ + "String");
        colList.add("col" + i++ + "String");
        colList.add("col" + i++ + "String");
        colList.add("col" + i++ + "Enum");
        colList.add("col" + i++ + "String");
        colList.add("col" + i++ + "String");
        colList.add("col" + i++ + "Int");
        colList.add("col" + i + "String");


        return colList.toArray(new String[colList.size()]);
    }

    static String[] generate35Headers() {
        List<String> colList = new ArrayList<>();
        int i = 1;
        colList.add(genColString("Int",i++));
        colList.add(genColString("String",i++));
        colList.add(genColString("String",i++));
        colList.add(genColString("String",i++));
        colList.add(genColString("String",i++));
        colList.add(genColString("Date",i++));
        colList.add(genColString("Date",i++));
        colList.add(genColString("String",i++));
        colList.add(genColString("Int",i++));
        colList.add(genColString("Int",i++));
        colList.add(genColString("Date",i++));
        colList.add(genColString("String",i++));
        colList.add(genColString("String",i++));
        colList.add(genColString("String",i++));
        colList.add(genColString("String",i++));
        colList.add(genColString("String",i++));
        colList.add(genColString("Enum",i++));
        colList.add(genColString("String",i++));
        colList.add(genColString("String",i++));
        colList.add(genColString("Int",i++));
        colList.add(genColString("String",i++));
        colList.add(genColString("Date",i++));
        colList.add(genColString("String",i++));
        colList.add(genColString("Int",i++));
        colList.add(genColString("Date",i++));
        colList.add(genColString("String",i++));
        colList.add(genColString("String",i++));
        colList.add(genColString("String",i++));
        colList.add(genColString("String",i++));
        colList.add(genColString("Int",i++));
        colList.add(genColString("String",i++));
        colList.add(genColString("Int",i++));
        colList.add(genColString("String",i++));
        colList.add(genColString("String",i++));
        colList.add(genColString("Currency",i++));
        return colList.toArray(new String[colList.size()]);
    }

    private static String genColString(String type, int index) {
        return "col"+index+type;
    }

    enum STATUS {

        NEW, AMEND, CANCEL;

        private static final List<STATUS> VALUES = Collections.unmodifiableList(Arrays.asList(values()));

        private static final int SIZE = VALUES.size();
        private static final SecureRandom RANDOM = new SecureRandom();

        public static STATUS getRandomStatus() {
            return VALUES.get(RANDOM.nextInt(SIZE));
        }

    }

}
