package validatingAge;

public class ValidateAge {
    public static void checkLicense(int age, String currentLevel) {
       
    	if (age >= 18)  {
            if (currentLevel.equals("G")) {
                System.out.println("You can get G license.");
            } else if (currentLevel.equals("G2")) {
                System.out.println("You can get full G license.");
            } else if (currentLevel.equals("G1")) {
                System.out.println("You are eligible for a G2 license.");
            } else if (currentLevel.equals(" ")) {
                System.out.println("You are eligible for a G1 license.");
            } 
            
            else {
                System.out.println("You are not eligible.");
            }
            
           
       } else {
            System.out.println("You need to wait for a driving license.");
       		}
    }

    public static void main(String[] args) {
        int age = 19;
        String currentLevel = " ";

        checkLicense(age, currentLevel);
    }
}