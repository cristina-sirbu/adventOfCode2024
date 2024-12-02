package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> list = readFile("day1_java/src/main/resources/input.txt");
        List<Integer> rightList = new ArrayList<>();
        List<Integer> leftList = new ArrayList<>();

        Pattern pattern = Pattern.compile("(\\d+)[^\\d]+(\\d+)");

        for (String line:list) {
            if (line.isEmpty()) continue;
            Matcher m = pattern.matcher(line);
            if (m.find()) {
                leftList.add(Integer.parseInt(m.group(1)));
                rightList.add(Integer.parseInt(m.group(2)));
            }
        }

//        resultA(leftList, rightList);

        resultB(leftList, rightList);
    }

    private static void resultB(List<Integer> leftList, List<Integer> rightList) {
        BigInteger res = BigInteger.ZERO;
        for (int i = 0; i < leftList.size(); i++) {
            int count=0;
            for (int j = 0; j < rightList.size(); j++) {
                if (leftList.get(i).intValue() == rightList.get(j).intValue()) {
                    count++;
                }
            }
            BigInteger left = BigInteger.valueOf(leftList.get(i));
            BigInteger bigcount = BigInteger.valueOf(count);
            res = res.add(left.multiply(bigcount));
        }
        System.out.println("Result is "+res);
    }

    private static void resultA(List<Integer> leftList, List<Integer> rightList) {
        leftList.sort(Integer::compare);
        rightList.sort(Integer::compare);

        int res=0;
        for (int i = 0; i < leftList.size(); i++) {
            if(rightList.get(i) > leftList.get(i)) {
                res += rightList.get(i) - leftList.get(i);
            } else if (leftList.get(i) > rightList.get(i)) {
                res += leftList.get(i) - rightList.get(i);
            }
        }
        System.out.println("Result is "+res);
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