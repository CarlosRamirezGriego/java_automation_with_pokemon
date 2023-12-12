package org.example;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class Calculator {
    public static int solution(int[] a) {
        // Implement your solution here
        HashSet<Integer> set = new HashSet<>();

        for(int element: a)
        {
            set.add(element);
        }

        return set.size();

    }
}
