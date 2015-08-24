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

//        String input="";
//        while(true) {
//
//        }
//        for (int i = 0; i < numberOfItems ; i++) {
//            items.add(sc.nextLine());
//        }
//
//
//        for (int i = 0; i < numberOfItems; i++) {
//            System.out.println(items.get(i));
//        }
    }
}
