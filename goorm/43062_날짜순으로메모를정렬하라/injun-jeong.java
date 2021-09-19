package goorm;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Q43062 {
    private static BufferedReader br;
    private static Map<String, String> memo;

    public static void main(String[] args) throws Exception {
        /* init instance variable */
        setup();

        /* create memo */
        createMemo();

        /* sort by date */
        List<String> sortedMemo = getSortedMemo();

        /* result */
        printResult(sortedMemo);
    }



    private static void setup() {
        br = new BufferedReader(new InputStreamReader(System.in));
        memo = new HashMap<>();
    }


    private static void createMemo() throws IOException {
        while (true) {
            String input = br.readLine();
            if (input.equals("END")) {
                break;
            }

            String date = getDate(input);
            memo.put(date, input);
        }

    }


    private static String getDate(String data) {
        data = data.replaceAll("[/년월]", "-");
        String[] parse = data.split("[^0-9-]");

        Pattern pattern = Pattern.compile("^\\d{2}[0-9]*-\\d{1}[0-9]*-\\d{1}[0-9]*");
        Matcher matcher;
        for (String p : parse) {
            matcher = pattern.matcher(p);
            if (matcher.matches()) {
                return formatDate(p);
            }
        }

        return "";
    }


    private static String formatDate(String date) {
        String[] dateData = date.split("-");

        String yyyy = dateData[0].length() == 2 ? "20".concat(dateData[0]) : dateData[0];
        String MM = dateData[1].length() == 1 ? "0".concat(dateData[1]) : dateData[1];
        String dd = dateData[2].length() == 1 ? "0".concat(dateData[2]) : dateData[2];

        return yyyy.concat(MM).concat(dd);
    }


    private static List<String> getSortedMemo() {
        List<String> sortedMemo = memo.keySet()
                                        .stream()
                                        .sorted()
                                        .collect(Collectors.toList());
        return sortedMemo;
    }


    private static void printResult(List<String> list) {
        list.stream().map(i->memo.get(i)).forEach(System.out::println);
    }
}
