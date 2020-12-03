import java.util.Scanner;
public class Array{

     public static void main(String[] args){
        int[] array=new int[5];
        Scanner scan= new Scanner(System.in);
        System.out.println("Enter the elements of array");
        for(int i=0;i<array.length;i++)
        array[i]=scan.nextInt();
        System.out.println("The elements of the array are");
        for(int i=0;i<array.length;i++)
        System.out.println(array[i]);
     }
}