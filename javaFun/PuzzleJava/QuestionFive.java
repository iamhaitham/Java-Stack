import java.util.Collections;
import java.util.Random;
import java.util.Arrays;

public class QuestionFive{
    public static void q5(){
        int[] array5;
        array5=new int[10];
        int min=55;
        int max=100;
        Random r = new Random();
        for(int i=0;i<array5.length;i++) {
            array5[i]=r.nextInt(max - min) + min;
        }
        Arrays.sort(array5);
        System.out.println(Arrays.toString(array5));
        System.out.println(array5[0]);
        System.out.println(array5[array5.length-1]);
    }
}