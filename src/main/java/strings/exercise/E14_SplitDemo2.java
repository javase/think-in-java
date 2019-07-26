package strings.exercise;

import static net.mindview.util.Print.*;

import java.util.Arrays;

public class E14_SplitDemo2 {
           public static void main(String[] args) {
             String input =
               "This!!unusual use!!of exclamation!!points";
             print(Arrays.toString(input.split("!!")));
             // Only do the first three:
             print(Arrays.toString(input.split("!!", 3)));
           }
         } /* Output:
         [This, unusual use, of exclamation, points]
         [This, unusual use, of exclamation!!points]
         *///:~