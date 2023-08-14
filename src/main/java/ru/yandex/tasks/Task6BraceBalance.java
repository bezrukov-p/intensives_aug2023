package ru.yandex.tasks;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Task6BraceBalance {
    public static boolean checkBalance(String sequence) {
        /*
         * sequence - последовательность скобок []{}() длины до 10^5
         * Выход: true/false, является ли строка ПСП
         */
        // (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧ WRITE CODE HERE (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧
        Set<Character> open = Set.of('(', '{', '[');

        Map<Character, Character> closeBraceToOpenBraceMap = new HashMap<>();
        closeBraceToOpenBraceMap.put(')', '(');
        closeBraceToOpenBraceMap.put('}', '{');
        closeBraceToOpenBraceMap.put(']', '[');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < sequence.length(); i++) {
            char curr = sequence.charAt(i);
            if (open.contains(curr))
                stack.add(curr);
            else {
                if (stack.isEmpty())
                    return false;
                if (stack.peek() != closeBraceToOpenBraceMap.get(curr))
                    return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void selfCheck() {
        String test1 = "[({})]{[]}";
        String test2 = "{({})}{";

        assert checkBalance(test1);
        assert !checkBalance(test2);
    }
}
