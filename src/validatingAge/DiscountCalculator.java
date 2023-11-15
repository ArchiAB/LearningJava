package validatingAge;

import java.util.Scanner;

		public class DiscountCalculator {
		    @SuppressWarnings("resource")
			public static void main(String[] args) {
		        Scanner scanner = new Scanner(System.in);

		        // Base discount of 50%
		        double baseDiscount = 0.5; // 50%

		        System.out.print("Enter the original price of the product: ");
		        double originalPrice = scanner.nextDouble();

		        System.out.print("Enter the promo code (if any, other then enter 'N'): ");
		        String promoCode = scanner.next();
		        

		        double finalDiscountedPrice = originalPrice * baseDiscount; // Applying base discount

		        switch (promoCode) {
		            case "Promo5":
		                finalDiscountedPrice *= 0.95; //  5% discount
		                break;
		            case "Promo10":
		                finalDiscountedPrice *= 0.90; //  10% discount
		                break;
		            case "Promo20":
		                finalDiscountedPrice *= 0.80; // 20% discount
		                break;
		            case "None":
		                // No discount, base discount only
		                break;
		            default:
		                System.out.println("Invalid your promo code.");
		               return;
		        }

		        System.out.println("Final discounted price: $" + finalDiscountedPrice);

		        scanner.close();
	    }
		
	}

