import java.util.ArrayList;
import java.util.Arrays;



public class PuzzleJava{
    public static void main(String[] args){

        // //Question One:
        int[] array1={3,5,1,2,7,9,8,13,25,32};
        QuestionOne q1= new QuestionOne();
        System.out.println(q1.q1(array1));
    
        // //Question Two:
        String[] array2={"Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa"};
        QuestionTwo q2=new QuestionTwo();
        System.out.println(q2.q2(array2));

        //Question Three:
        ArrayList<Character> array3=new ArrayList<Character>();
        Character[] array31={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        for(int i=0;i<array31.length;i++){
            array3.add(array31[i]);
        }
        QuestionThree q3=new QuestionThree();
        q3.q3(array3);

        //Question Four:
        QuestionFour q4=new QuestionFour();
        q4.q4();

        //Question Five:
        QuestionFive q5=new QuestionFive();
        q5.q5();

        //Question Six:
        QuestionSix q6=new QuestionSix();
        q6.q6();
        
        //Question Seven:
        // QuestionSix q6=new QuestionSix(); {{ALREADY DEFINED IN QUESTION SIX ABOVE}}
        String[] array7;
        array7=new String[10];
        for(int i=0;i<array7.length;i++){
            array7[i]=q6.q6();
        }
        System.out.println(Arrays.toString(array7));

    }
}