package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> list = readFile("day2_java/src/main/resources/input.txt");

        int result = 0;
        for (String line:list) {
            if (line.isEmpty()) continue;
            List<Integer> lst = Arrays.stream(line.split(" ")).map(Integer::parseInt).toList();
            boolean safe = isSafe(lst);
            if (!safe) {
                for (int i = 0; i < lst.size(); i++) {
                    List<Integer> numList = new ArrayList<>(lst);
                    numList.remove(i);
                    safe = isSafe(lst);
                    if (safe) break;
                }
            }
            result += safe ? 1:0;
        }
        System.out.println(result);

    }

    private static boolean isSafe(List<Integer> lst) {
        boolean only_cresc = true;
        boolean only_descr = true;
        boolean ok = true;

        for (int i = 0; i< lst.size()-1; i++) {
            int diff = lst.get(i+1) - lst.get(i);
            if (diff > 0) { only_descr = false; }
            if (diff < 0) { only_cresc = false; }
            if (!(1<=Math.abs(diff) && Math.abs(diff) <= 3)) {
                ok = false;
                break;
            }
        }

        if (ok && (only_cresc || only_descr)) {
            return true;
        }
        return false;
    }

    private static List<String> readFile(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        List<String> list = new ArrayList<>();
        while((line=br.readLine())!= null) {
            list.add(line);
        }
        return list;
    }
}