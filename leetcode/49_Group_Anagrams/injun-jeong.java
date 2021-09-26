package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Q49_Group_Anagrams {
    private List<List<String>> answer;
    private List<String> sortedByLength;
    private Map<Integer, List<String>> map;     // <Length, Collection>
    private Map<String, List<String>> ansMap;

    public List<List<String>> groupAnagrams(String[] strs) {
        setup(strs);
        getAnswer();
        return answer;
    }


    private void setup(String[] strs) {
        answer = new ArrayList<>();
        sortedByLength = Arrays.stream(strs)
                .sorted((s1, s2) -> s1.length() - s2.length())
                .collect(Collectors.toList());
        map = new HashMap<>();
        ansMap = new HashMap<>();
    }


    private void getAnswer() {
        for (String str : sortedByLength) {
            updateAnswer(str);
        }
        makeAnswer();
    }


    private void updateAnswer(String str) {
        int len = str.length();
        if ( map.containsKey(len) ) {
            for (String collect : map.get(len)) {
                if ( isSameCollect(str, collect) ) {
                    ansMap.get(collect).add(str);
                    return;
                }
            }
        }
        createNewCollect(str);
    }


    private boolean isSameCollect(String str, String collect) {
        Map<String, Integer> cntMap = new HashMap<>();
        for (String s: collect.split("")) {
            cntMap.put(s, cntMap.getOrDefault(s, 0) + 1);
        }

        for (String s: str.split("")) {
            if ( !str.contains(s) ) {
                return false;
            } else {
                if (cntMap.getOrDefault(s, 0) <= 0) {
                    return false;
                } else {
                    cntMap.put(s, cntMap.getOrDefault(s, 0) - 1);
                }
            }
        }
        return true;
    }


    private void createNewCollect(String str) {
        List<String> collect;
        if ( map.containsKey(str.length()) ) {
            collect = map.get(str.length());
        } else {
            collect = new ArrayList<>();
        }
        collect.add(str);
        map.put(str.length(), collect);

        List<String> newAns = new ArrayList<>();
        newAns.add(str);
        ansMap.put(str, newAns);
    }


    private void makeAnswer() {
        for ( List<String> list : ansMap.values() ) {
            answer.add(list);
        }
    }
}
