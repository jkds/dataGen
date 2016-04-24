package com.maskibth.util;

import java.io.IOException;

import static java.lang.System.exit;

public class Application {

    public static void main(String[] args) throws IOException {

        Generator generator = new DataGenerator20();

        if (args == null || args.length < 2) {
            System.out.println("please enter parameters");
            exit(0);
        }

        if (args[0] == null || "".equals(args[0].trim())) {
            System.out.println("Missing file path. e.g. /home/abc.csv");
        }

        if (args[1] == null || "".equals(args[1].trim()) || new Integer(args[1].trim()) > (Integer.MAX_VALUE - 1)) {
            System.out.println("Invalid/missing row count");
        }

        if (args[2] == null || "".equals(args[2].trim())) {
            System.out.println("Invalid/missing row count");
        } else if(args[2].equals("large")) {
            generator = new DataGenerator35();
        }

        String path = args[0];
        int maxCount = new Integer(args[1]);

        generator.generate(path, maxCount);

    }
}
