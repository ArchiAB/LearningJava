package assignment4;

//Write a program which when given a phone brand name.
public class PhoneBrands {

    private String[][] productCatalog;

    // shows all the available products present in that category
    public PhoneBrands() {
        this.productCatalog = new String[][]{
                {"Samsung", "Galaxy S20", "Smartphone"},
                {"Samsung", "Galaxy S21", "Smartphone"},
                {"Samsung", "Flip3", "Smartphone"},
                {"Samsung", "Fold3", "Smartphone"},
                
                {"Google", "Google Pixel 6", "Smartphone"},
                {"Google", "Google Pixel 6 Pro", "Smartphone"},
                {"Google", "Google Pixel Pro", "Smartphone"},
                {"Google", "Google Pixel 5", "Smartphone"},
                
                {"Apple", "iPhone 12", "Smartphone"},
                {"Apple", "iPhone SE", "Smartphone"},
                {"Apple", "iPhone 15", "Smartphone"},
                {"Apple", "iPhone 13", "Smartphone"},
                {"Apple", "iPhone 15", "Smartphone"}
                
        };
    }

    public void showProducts(String brand) {
    	
        System.out.println("Available products for " + brand + ":");
     // shows all the available products present in that category
        
        for (String[] product : productCatalog) {
            if (product[0].equalsIgnoreCase(brand)) {
                System.out.println("- " + product[1] + " (" + product[2] + ")");
            }
        }
    }

    public void selectProduct(String productName) {
        boolean productFound = false;
        // If user enters a name which is present in list, print  “product selected is : name of product “
        for (String[] product : productCatalog) {
            if (product[1].equalsIgnoreCase(productName)) {
                productFound = true;
                System.out.println("Product selected is: " + product[1] + " (" + product[2] + ")");
                break;
            }
        }

        if (!productFound) {
            System.out.println("Please select a product from the list.");
            //an error message – “Please select a product from the list”
        }
    } 

   
}
