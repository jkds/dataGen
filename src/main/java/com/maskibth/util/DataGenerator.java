package com.maskibth.util;

import java.util.ArrayList;
import java.util.List;

class DataGenerator {


    void generate(String fileWithAbsolutePath, int rowCount) {

        List<String[]> rows = new ArrayList<>();
        rows.add(DataUtils.generateHeaders());

        for (int i = 1; i < rowCount; i++) {

            String[] row = new String[DataUtils.generateHeaders().length];

            int j = 0;
            row[j++] = Integer.toString(DataUtils.generateRandomInteger(500));
            row[j++] = DataUtils.generateRandomString(20);
            row[j++] = DataUtils.generateRandomString(8);
            row[j++] = DataUtils.generateRandomString(19);
            row[j++] = DataUtils.generateRandomString(10);
            row[j++] = DataUtils.generateRandomDate(1900, 2016);
            row[j++] = DataUtils.generateRandomDate(2000, 2016);
            row[j++] = DataUtils.generateRandomString(20);
            row[j++] = Integer.toString(DataUtils.generateRandomInteger(1000));
            row[j++] = Integer.toString(DataUtils.generateRandomInteger(5));
            row[j++] = DataUtils.generateRandomDate(2015, 2016);
            row[j++] = DataUtils.generateRandomString(4);
            row[j++] = DataUtils.generateRandomString(8);
            row[j++] = DataUtils.generateRandomString(8);
            row[j++] = DataUtils.generateRandomString(17);
            row[j++] = DataUtils.STATUS.getRandomStatus().toString();
            row[j++] = DataUtils.generateRandomString(14);
            row[j++] = DataUtils.generateRandomString(19);
            row[j++] = Integer.toString(DataUtils.generateRandomInteger(500));
            row[j] = DataUtils.generateRandomCurrency();
            rows.add(row);
        }

        CsvWriter.writeCsv(fileWithAbsolutePath, rows);
    }

}
