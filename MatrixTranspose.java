import java.util.Scanner;
public class MatrixTranspose{

     public static void main(String []args){
        int a,b;
        System.out.println("Enter the size of matrix");
        Scanner scan=new Scanner(System.in);
        a=scan.nextInt();
        b=scan.nextInt();
        int mat[][]=new int[a][b];
        System.out.println("Enter the elemnets of matrix ");
        for(int i=0;i<a;i++)
        for(int j=0;j<b;j++)
        mat[i][j]=scan.nextInt();
        System.out.println("The transpose of given matrix is ");
        for(int i=0;i<b;i++){
        for(int j=0;j<a;j++)
        System.out.print(mat[j][i]+" ");
            System.out.println();
        }
}}