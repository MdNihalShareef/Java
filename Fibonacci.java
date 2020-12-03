import java.util.Scanner;
public class Fibonacci{
    static int fib(int a){
        if (a==1)
        return 0;
        else if (a==2)
        return 1;
        else return fib(a-1)+fib(a-2);
    }
     public static void main(String []args){
        Scanner scan=new Scanner(System.in);
        int a=scan.nextInt();
        System.out.println("The 1st "+a+" finocci no. are");
        for(int i=1;i<=a;i++)
        System.out.println(fib(i));
     }
}