package assignment4;

import java.util.Scanner;

public class PhoneBrandMain {

	 public static void main(String[] args) {
	        PhoneBrands catalog = new PhoneBrands();
	        try (Scanner scanner = new Scanner(System.in)) {
				System.out.print("Enter a phone brand: ");
				String brand = scanner.nextLine();

				catalog.showProducts(brand); //displaying all the available brands

				System.out.print("Enter the name of the product you want: ");
				String selectedProduct = scanner.nextLine();

				catalog.selectProduct(selectedProduct);
			}
	    }

}