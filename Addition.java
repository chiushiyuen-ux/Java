import java.util.Scanner;

public class Addition{
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        float a=scanner.nextFloat();
        float b=scanner.nextFloat();
        float sum=a+b;
        System.out.println(sum);
        scanner.close();
    }
}