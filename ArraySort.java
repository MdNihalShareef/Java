import java.util.Scanner;
public class ArraySort{
    
    static int[] selectionSort(int[] a){
        int min=a[0],index,k;
        for(int i=0;i<a.length;i++){
            index=i;
            min=a[i];
            for(int j=i;j<a.length;j++){
                if (min>a[j]){
                min=a[j];
                index=j; 
                }
            }
            k=a[i];
            a[i]=min;
            a[index]=k;
        }
     return a;
    }
    
     public static void main(String []args){
        int size;
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter the size of the array ");
        size=scan.nextInt();
        int a[]=new int[size];
        System.out.print("Enter the elements of the array ");
        for(int i=0;i<size;i++)
        a[i]=scan.nextInt();
        a=selectionSort(a);
        System.out.println("The values of array in sorted manner  ");
        for(int i=0;i<a.length;i++)
            System.out.println(a[i]);        
     }
}