import java.util.ArrayList;

public class QuestionOne{
    public static ArrayList<Integer> q1(int[] array1){
        int sum=0; 
        ArrayList<Integer> newarray1= new ArrayList<Integer>();
        for(int i=0;i<array1.length;i++){
            sum+=array1[i];
            if(array1[i]>10){
                newarray1.add(array1[i]);
            }
        }
        System.out.println(sum);
        return newarray1;
    }
}