package LetterCombination;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
//
//A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

public class Solution {
//      0 <= digits.length <= 4
//    digits[i] is a digit in the range ['2', '9'].

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.letterCombinations("234");
    }

    Map<String, List<String>> digitLetterMap = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        fillDigitLetterMap();
        if (digits.isEmpty() || digits.length() > 4) {
            return new ArrayList<>();
        } else if (digits.length() == 1) {
            return digitLetterMap.get(digits);
        }
        List<String> result = new ArrayList<>();

        for (int i = 0; i < digits.length() - 1; i++) {
            List<String> digitLetters;
            if (i == 0) {
                digitLetters = digitLetterMap.get(String.valueOf(digits.charAt(i)));
            } else {
                digitLetters = result;
            }
            List<String> digitLettersToCombine = digitLetterMap.get(String.valueOf(digits.charAt(i + 1)));
            List<String> tmp = new ArrayList<>();

            digitLetters.forEach(letter -> digitLettersToCombine.forEach(letterToCombine -> tmp.add(letter + letterToCombine)));
            result = tmp;
        }
        return result;
    }

    private void fillDigitLetterMap() {
        digitLetterMap.put("2", List.of("a", "b", "c"));
        digitLetterMap.put("3", List.of("d", "e", "f"));
        digitLetterMap.put("4", List.of("g", "h", "i"));
        digitLetterMap.put("5", List.of("j", "k", "l"));
        digitLetterMap.put("6", List.of("m", "n", "o"));
        digitLetterMap.put("7", List.of("p", "q", "r", "s"));
        digitLetterMap.put("8", List.of("t", "u", "v"));
        digitLetterMap.put("9", List.of("w", "x", "y", "z"));
    }

}
