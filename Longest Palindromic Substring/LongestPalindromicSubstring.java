import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * LongestPalindromicSubstring
 */
public class LongestPalindromicSubstring {

    static Testcase[] testcases = new Testcase[] {
        new Testcase("babad", Arrays.asList(new String[] {"bab", "aba"})),
        new Testcase("cbbd",  Arrays.asList(new String[] {"bb"})),
        new Testcase("a",     Arrays.asList(new String[] {"a"})),
        new Testcase("ac",    Arrays.asList(new String[] {"a"}))
    };

    public static void main(String[] args) {

        //DoesStackMatchTest();
        LongestEndingPalindromTest();
        /*
        for (int testIndex = 0; testIndex < testcases.length; testIndex++) {
            System.out.println("### Testcase number: " + testIndex + " ###");
            Testcase testcase = testcases[testIndex];
            
            List<String> expected = testcase.expected;
            String input = testcase.input;
            String actual = FindLongestPalindromicSubstring(input);

            System.out.println("Actual: " + actual + ", Expected: " + expected + ", Result: " + expected.contains(actual));
        }
        */
    }


    private static String FindLongestPalindromicSubstring(String theString) {
        return theString.substring(0,1);
    }

    private static Stack<Character> Stackify(Stack<Character> oldStack) {
        Stack<Character> newStack = new Stack<Character>(); 

        //Adding array to stack 
        ArrayList<Character> array = new ArrayList(oldStack);
        for (Character c : array) {
            newStack.add(c);
        }

        return newStack;
    }

    private static int DoesStackMatch(String word, int endIndex, Stack<Character> stack) {
        stack = Stackify(stack);
        String stackAsString = Arrays.toString(stack.toArray());
        if (stack.isEmpty()) {
            return 0;
        }

        int resultIfSucess = stack.size();
        int startIndex = endIndex-stack.size()+1; 
        //System.out.println("Word: " + word + ", startindex: " + startIndex + ", endindex: " + endIndex + ", stack.size: " + stack.size());
        for (int letterIndex = startIndex; letterIndex <= endIndex; letterIndex++ ) {
            char stackLetter = stack.pop();
            /*
            System.out.println("\tLetterindex: " + letterIndex);
            System.out.println("\twordletter: " + word.charAt(letterIndex));
            System.out.println("\tstackletter: " + stackLetter);
            System.out.println("  ");
            */
            if (word.charAt(letterIndex) != stackLetter) {
                System.out.println("DoesStackMatch: Word=" + word.substring(0, endIndex) + " does not matches the stack=" + stackAsString);
                return 0;
            }
        }
        System.out.println("DoesStackMatch: Word=" + word.substring(0, endIndex) + " matches the stack=" + stackAsString);
        return resultIfSucess;
    }

    private static void DoesStackMatchTest() {

        System.out.println("### DoesStackMatchTest ###");
        String word1 = "abc";
        Stack<Character> stack1 = new Stack<Character>();
        stack1.add('c');
        stack1.add('b');
        stack1.add('a');
        int result1 = DoesStackMatch(word1, 2, stack1);
        
        String word2 = "abcdef";
        Stack<Character> stack2 = new Stack<Character>();
        stack2.add('e');
        stack2.add('d');
        stack2.add('c');
        int result2 = DoesStackMatch(word2, 3, stack2);
        
        String word3 = "abcdef";
        Stack<Character> stack3 = new Stack<Character>();
        stack3.add('e');
        stack3.add('d');
        int result3 = DoesStackMatch(word3, 4, stack3);

        System.out.println("Result1: " + result1 + ", Expected: 3");
        System.out.println("Result2: " + result2 + ", Expected: 0");
        System.out.println("Result3: " + result3 + ", Expected: 2");

    } 

    private static int LongestEndingPalindrom(String word, int endingIndex, Stack<Character> stack) {
        stack = Stackify(stack);

        int goDown = DoesStackMatch(word, endingIndex, stack);
        int goDown2 = 0;
        if (endingIndex != 0) {
            goDown2 = DoesStackMatch(word, endingIndex-1, stack);
        }

        stack.add(word.charAt(endingIndex));
        int goUp = 0;
        if (endingIndex != 0) {
            goUp = LongestEndingPalindrom(word, endingIndex-1, stack);
        } 

        if (goDown >= goDown2 && goDown >= goUp) {
            System.out.println("LongestEndingPalindrom: Will go down");
            return endingIndex-stack.size();
        }
        if (goDown2 >= goDown && goDown2 >= goUp) {
            System.out.println("LongestEndingPalindrom: Will step and go up");
            return endingIndex-stack.size()-1;
        }
        if (goUp >= goDown && goUp >= goDown2) {
            System.out.println("LongestEndingPalindrom: Will go up");
            return goUp;
        }

        return -1000000;
    }

    private static void LongestEndingPalindromTest() {

        String word1 = "aaaaaxyzzyx";
        int endindex = word1.length()-1;
        int start = LongestEndingPalindrom(word1, endindex, new Stack<Character>());
        String palindrom = word1.substring(start, endindex);

        System.out.println(palindrom);
    }
}

