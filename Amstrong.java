import java.util.Scanner;
public class Amstrong{

     public static void main(String []args){
        Scanner scan= new Scanner(System.in);
        String numstr=scan.next();
        int len=numstr.length(),sum=0;
        int num=Integer.parseInt(numstr);
        while(num>0)
        {
            sum+=Math.pow(num%10,len);
            num/=10;
            
        }
        if (sum==Integer.parseInt(numstr))
        System.out.println("Amstrong");
        else
        System.out.println("Anti-Amstrong");
        
     }
}