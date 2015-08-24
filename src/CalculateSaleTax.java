import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by amandeepsingh on 24/08/15.
 */
public class CalculateSaleTax {
    private Scanner sc;
    private ArrayList<String> items;
    private ArrayList<String> foodItems;
    private ArrayList<String> books;
    private ArrayList<String> medicalProducts;
    public CalculateSaleTax() {
        sc = new Scanner(System.in);
        items = new ArrayList<>();
        initializeBooks();
        initializeFoodItems();
        initializeMedicalProducts();
    }

    public static void main(String[] args) {
        CalculateSaleTax calculateSaleTax = new CalculateSaleTax();
        calculateSaleTax.takeUserInput();
        calculateSaleTax.calculateBasicSalesTax();
    }

    private void initializeMedicalProducts() {
        medicalProducts = new ArrayList<>();
        medicalProducts.add("headache pills");
    }

    private void initializeFoodItems() {
        foodItems = new ArrayList<>();
        foodItems.add("chocolate bar");
        foodItems.add("chocolates");
    }

    private void initializeBooks() {
        books = new ArrayList<>();
        books.add("book");
    }


    private void calculateBasicSalesTax() {
        for(String item : items) {
            Double price = parsePrize(item);
            System.out.println(price);
            if(!isExemptApplicable(item)) {

            }
        }
    }

    private Double parsePrize(String item) {
        int indexOfAt = item.lastIndexOf(" at ");
        return Double.parseDouble(item.substring(indexOfAt+4, item.length()));
    }

    private boolean isExemptApplicable(String item) {

        for (String book : books) {
            if(item.indexOf(book) != -1)
                return true;
        }

        for (String medicalProduct : medicalProducts) {
            if(item.indexOf(medicalProduct) != -1)
                return true;
        }

        for (String foodItem : foodItems) {
            if(item.indexOf(foodItem) != -1)
                return true;
        }
        return false;
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
