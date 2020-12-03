import java.util.Scanner;
public class MatrixMultiply{

     public static void main(String []args){
        int a,b,c,d;
        System.out.println("Enter the size of 1st matrix");
        Scanner scan=new Scanner(System.in);
        a=scan.nextInt();
        b=scan.nextInt();
        int mat1[][]=new int[a][b];
        System.out.println("Enter the size of 2nd matrix");
        c=scan.nextInt();
        d=scan.nextInt();
        int mat2[][]=new int[c][d];
        if (b==c)
        {
            int mat3[][]=new int[a][d];
        System.out.println("Enter the elemnets of 1st matrix ");
        for(int i=0;i<a;i++)
        for(int j=0;j<b;j++)
        mat1[i][j]=scan.nextInt();
        System.out.println("Enter the elemnets of 2nd matrix ");
        for(int i=0;i<c;i++)
        for(int j=0;j<d;j++)
        mat2[i][j]=scan.nextInt();
        for(int i=0;i<a;i++)
        for(int j=0;j<d;j++)
        for(int k=0;k<b;k++)
        mat3[i][j]+=mat1[i][k]*mat2[k][i];
        System.out.println("The multiplied mattix is ");
        for(int i=0;i<a;i++)
        {
        for(int j=0;j<d;j++)
        System.out.print(mat3[i][j]+" ");
        System.out.println();
            
        }
        }
        else
        System.out.println("The matricies of given order cant be multiplied");
     }
}