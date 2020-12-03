import java.util.Scanner;
class Account{
    String name;
    int accountNumber;
    int balance;
    Account(String a, int b){
        name=a;
        accountNumber=b;
        
    }
    void deposit(int a){
        balance+=a;
        
    }
    void withdraw(int a)
    {
        if (balance-a>=500)
        balance-=a;
        else
        System.out.println("Sorry, the minimun balance in the account must be 500");
    }
    void balanceCheck(){
        System.out.println("The balance in your account is "+balance);
    }
}
public class BankAccount{

     public static void main(String []args){
        int a;
        Account account=new Account("Edward",19882169);
        Scanner scan=new Scanner(System.in);
        while(true)
        {
    System.out.println("Select the option to perfomr certain operation\n1. Deposit\n2. Withdraw\n3. Check Balance\n4. Exit");
    a=scan.nextInt();
    switch(a){
        case 1: System.out.println("Enter the amount to deposit ");
                int b=scan.nextInt();
                account.deposit(b); 
                break;
        case 2: System.out.println("Enter the amount to be Withdrawn ");
                int c=scan.nextInt();
                account.withdraw(c);
                break;
        case 3: account.balanceCheck();break;
        case 4: System.exit(0);
        default: System.out.println("Please Enter a valid option");
        }
    }
}
}