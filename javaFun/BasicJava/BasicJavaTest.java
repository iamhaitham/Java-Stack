import java.util.ArrayList;
import java.util.Arrays;

public class BasicJavaTest{
    // Print 1-255
    public static void q1(int end){
        for (int i=1;i<=end;i++){
            System.out.println(i);
        }
    }

    //Print odd numbers between 1-255
    public static void q2(int start, int end){
        for (int i=start;i<=end;i++){
            if (i%2!=0){
                System.out.println(i);
            }
        }
    }

    // Print Sum
    public static void q3(int start, int end){
        int sum=0;
        for(int i=start;i<=end;i++){
            sum=sum+i;
            System.out.println("New number: "+ i +"Sum: "+sum);
        }
    }
    
    //Iterating through an array
    public static void q4(){
    int [] myArray={1,3,5,7,9,13};
    for (int i:myArray){
        System.out.println(i);
        }
    }

    // Find Max
    public static void q5(int[] array){
        int max=array[0];
        for(int i=0;i<array.length;i++){
            if (array[i]>max){
                max=array[i];
            }
        }
        System.out.println(max);
    }

    //Get Average
    public static void q6(int[] array){
        int sum=0;
        int avg=0;
        for(int i=0;i<array.length;i++){
            sum=sum+array[i];
            }
            avg=sum/array.length;
            System.out.println(avg);
        }
    
    //Array with Odd Numbers
    public static void q7(){
        ArrayList<Integer> y = new ArrayList<Integer>();
        for(int i=1;i<=255;i++){
            if(i%2!=0){
            y.add(i);
            }
        }
        System.out.println(y);
    }

    //Greater Than Y
    public static void q8(int[] array, int y){
        int count=0;
        for(int i=0;i<array.length;i++){
            if(array[i]<y){
                count+=1;
            }
        }
        System.out.println(count);
    }

    //Square the values
    public static void q8(int[] array){
        int[] newarray;
        newarray=new int[array.length];
        for(int i=0;i<array.length;i++){
            newarray[i]=array[i]*array[i];
        }
        System.out.println(Arrays.toString(newarray));
    }

    //Eliminate Negative Numbers
    public static void q9(int[] array){
        int[] newarray;
        newarray=new int[array.length];
        for(int i=0;i<array.length;i++){
            if(array[i]<0){
                newarray[i]=0;
            }
            else{
                newarray[i]=array[i];
            }
        }
        System.out.println(Arrays.toString(newarray));
    }

    //Max, Min, and Average
    public static void q10(double[] array){
        double min=array[0];
        double max=array[0];
        double sum=0;
        double avg=0;
        double[] newarray;
        newarray=new double[3];
        for(int i=0;i<array.length;i++){
            if(array[i]<min){
                min=array[i];
            }
            if(array[i]>max){
                max=array[i];
            }
            sum=array[i]+sum;
        }
        avg=sum/array.length;
        newarray[0]=max;
        newarray[1]=min;
        newarray[2]=avg;
        System.out.println(Arrays.toString(newarray));
    }

    //Shifting the Values in the Array
    public static void q11(int[] array){
        int[] newarray;
        newarray=new int[array.length];
        for(int i=0;i<array.length-1;i++){
            newarray[i]=array[i+1];
        }
        newarray[newarray.length-1]=0;
        System.out.println(Arrays.toString(newarray));
    }

   public static void main(String[] args){
        q1(255);

        q2(1,255);

        q3(0,255);

        q4();

        int[] array1={1,3,-5,0,9,-13};
        q5(array1);

        int[] array2={-5,5,0,8};
        q6(array2);

        q7();

        int[] array3={0,-4,4,8};
        int y1=4;
        q8(array3,y1);

        int[] array4={1,5,10,-2};
        q8(array4);

        int[] x1={1, 5, 10, -2};
        q9(x1);

        double[] x2={1, 5, 10, -2};
        q10(x2);

        int[] x3={1, 5, 10, 7, -2};
        q11(x3);
   }

}