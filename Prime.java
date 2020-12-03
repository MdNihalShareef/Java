import java.util.Scanner;
public class Prime{

     public static void main(String[] args){
         int a,count=0,n=2;
         System.out.print("Enter the no. of prime no. you want to print ");
         Scanner scan = new Scanner(System.in);
         a=scan.nextInt();
         System.out.println("The 1st "+a+" prime no. are");
         
         while(count<a){
             String k="prime";
             for(int i=2;i<n;i++)
             if(n%i==0)
             {
                 k="composite";break;
             }
             if (k=="prime")
             {System.out.println(n);count++;
             }n++;
         }
        
     }
}