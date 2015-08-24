import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by amandeepsingh on 24/08/15.
 */
public class CalculateSaleTax {
    private Scanner sc;
    private ArrayList<String> items;
    public CalculateSaleTax() {
        sc = new Scanner(System.in);
        items = new ArrayList<>();
    }

    public static void main(String[] args) {
        CalculateSaleTax calculateSaleTax = new CalculateSaleTax();
        calculateSaleTax.takeUserInput();
    }

    private void takeUserInput() {
        System.out.println("Enter input");
        String input="";
        while(true) {
            input = sc.nextLine();
            if(input.equals("")) {
                break;
            }
            items.add(input);
        }
    }
}
