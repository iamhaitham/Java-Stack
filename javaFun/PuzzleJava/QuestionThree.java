import java.util.Collections;
import java.util.ArrayList;
public class QuestionThree{
    public static void q3(ArrayList<Character> array3){
        Collections.shuffle(array3);
        System.out.println(array3.get(25));
        System.out.println(array3.get(0));
        if (array3.get(0)=='A'||array3.get(0)=='E'||array3.get(0)=='I'||array3.get(0)=='O'||array3.get(0)=='U'){
            System.out.println("The first letter is a vowel");
        }
    }
}