import java.util.Random;
import java.util.Arrays;

public class QuestionFour{
    public static void q4(){
        int[] array4;
        array4=new int[10];
        Random r = new Random();
        int min = 55;
        int max = 100;
        for(int i=0;i<array4.length;i++){
            array4[i]=r.nextInt(max-min)+min;
        }
        System.out.println(Arrays.toString(array4));
    }
}