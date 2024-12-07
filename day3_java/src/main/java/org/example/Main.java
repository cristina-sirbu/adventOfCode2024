package org.example;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> lines = Util.readInput(false, "day3_java/src/main/resources/input.txt", false);
        String line = lines.get(0);

        boolean enable = true;

        Pattern pattern = Pattern.compile("(do\\(\\))|(don't\\(\\))|(mul\\((\\d+),(\\d+)\\))");

        Matcher m = pattern.matcher(line);

        long result = 0;
        while (m.find()) {
            if (m.group(1)!=null) {
                enable = true;
            }
            if (m.group(2)!=null) {
                enable = false;
            }
            if (m.group(3)!=null && enable) {
                int var1 = Integer.parseInt(m.group(4));
                int var2 = Integer.parseInt(m.group(5));
                System.out.println(var1 + " * " + var2);
                result += var1 * var2;
            }
        }
        System.out.println(result);
    }
}