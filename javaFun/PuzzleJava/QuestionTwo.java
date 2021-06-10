import java.util.ArrayList;
import java.util.Collections;

public class QuestionTwo{
    public static ArrayList<String> q2(String[] array2){
    ArrayList<String> newarray2=new ArrayList<String>();
    for(int i=0;i<array2.length;i++){
        newarray2.add(array2[i]);
        }
    Collections.shuffle(newarray2);
    for(String name:newarray2){
        System.out.println(name);
        }
    ArrayList<String> newarray22=new ArrayList<String>();
    for(String name:array2){
        if (name.length()>5){
            newarray22.add(name);
        }
        }
    return newarray22;
    }
}