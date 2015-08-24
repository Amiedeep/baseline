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
    private double salesTax;
    public CalculateSaleTax() {
        sc = new Scanner(System.in);
        items = new ArrayList<>();
        salesTax = 0.0;
        initializeBooks();
        initializeFoodItems();
        initializeMedicalProducts();
    }

    public static void main(String[] args) {
        CalculateSaleTax calculateSaleTax = new CalculateSaleTax();
        calculateSaleTax.takeUserInput();
        calculateSaleTax.calculateBasicSalesTax();
        calculateSaleTax.calculateImportDuty();
    }

    private void calculateImportDuty() {
        for(String item : items) {
            Double price = parsePrize(item);
            System.out.println(price);
            if(isImported(item)) {
                items.remove(item);
                Double newPrice = price + price/20;
                salesTax = salesTax+ price/20;
                item = item.replace(""+price, ""+newPrice);
                items.add(item);
            }
        }
    }

    private boolean isImported(String item) {
        return item.indexOf("imported") != -1;
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
            items.remove(item);
            Double newPrice = price;
            if(!isExemptApplicable(item)) {
                Double tax = roundTaxValue(price / 10);
                newPrice = newPrice+ tax;
                salesTax = salesTax+ tax;
            }
            if(isImported(item)) {
                Double tax = roundTaxValue(price / 20);
                newPrice = newPrice+ tax;
                salesTax = salesTax+ tax;
                item = item.replace(""+price, ""+newPrice);
            }
            items.add(item);
        }
    }

    private Double roundTaxValue(double value) {
        long factor = (long) Math.pow(10, 2);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
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
