import java.util.Scanner;  //if want to input, need to import a scanner library

public class Greet{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);   //need to create scanner object in the class
        String greet=scanner.nextLine();   // nextLine(): wait for input, and store input as string variable
        System.out.println(greet);
        scanner.close();     //need to manually close the scanner object
    }
}