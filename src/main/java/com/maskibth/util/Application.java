package com.maskibth.util;

import com.maskibth.util.DataGenerator;

import static java.lang.System.exit;

public class Application {

    public static void main(String[] args) {

        if (args == null || args.length != 2) {
            System.out.println("please enter parameters");
            exit(0);
        }

        if (args[0] == null || "".equals(args[0].trim())) {
            System.out.println("Missing file path");
        }

        if (args[1] == null || "".equals(args[1].trim())) {
            System.out.println("Missing file path");
        }

        String path = args[0];
        int maxCount = new Integer(args[1]);


        DataGenerator generator = new DataGenerator();
        generator.generate(path, maxCount);

    }
}
