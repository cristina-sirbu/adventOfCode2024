package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// From https://github.com/kalaspuffar/advent2024/blob/main/src/main/java/org/ea/aoc/Util.java
public class Util {
    public static List<String> readInput(boolean test, int day, boolean partb) throws IOException {
        String testdir = "";
        if (test) {
            testdir = (partb) ? "test_b" : "test_a";
        } else {
            testdir = (partb) ? "input_b" : "input_a";
        }
        BufferedReader br = new BufferedReader(new FileReader("day2_java/src/main/resources/input.txt"));
        List<String> list = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            list.add(line);
        }
        return list;
    }
}