class Rectangle{
    int length;
    int width;
    int perimeter(){
        return 2*(length+width);
    }
    int area(){
        return length*width;
    }

Rectangle(int a, int b)
{
    length=a;
    width=b;
}
}
public class RectangleOperations{

     public static void main(String []args){
        
        Rectangle rec= new Rectangle(10,20);
        System.out.println("The perimiter of Rectangle is "+rec.perimeter());
        System.out.println("The area of Rectangle is "+rec.area());
    
     }
}