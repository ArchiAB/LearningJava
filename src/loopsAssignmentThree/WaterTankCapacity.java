package loopsAssignmentThree;
import java.util.Scanner;

public class WaterTankCapacity {
    public static void main(String[] args) {
        // Constants
        final int Tank_Capacity = 100;
        final int Bucket_Capacity = 10;

        // Variables
        int currentWaterLevel = 0;
        Scanner scanner = new Scanner(System.in);

        // Filling the tank
        while (currentWaterLevel < Tank_Capacity) {
            System.out.println("Current water level: " + currentWaterLevel + " liters");
            System.out.println("Enter 1 to fill the bucket, 0 to end the process: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                // Fill the bucket
                int waterToAdd = Math.min(Bucket_Capacity, Tank_Capacity - currentWaterLevel);
                currentWaterLevel += waterToAdd;
                System.out.println("Filled " + waterToAdd + " liters into the tank.");
            } else if (choice == 0) {
                System.out.println("End of the process.");
                break;
            } else {
                System.out.println("Invalid choice. Please enter 1 to fill the bucket or 0 to end the process.");
            }

            // Check for overflow
            if (currentWaterLevel >= Tank_Capacity) {
                System.out.println("Tank is full. End the process.");
                break;
            }
        }

        scanner.close();
    }
}