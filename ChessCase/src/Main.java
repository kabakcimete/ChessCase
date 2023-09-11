import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        System.out.println("Enter file name:");
        Scanner sc=new Scanner(System.in);
        String inp = sc.nextLine();
        Board reader = new Board();
        reader.ReadBoard(inp);
        reader.GetScores();

    }
}