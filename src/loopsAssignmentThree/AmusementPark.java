package loopsAssignmentThree;

public class AmusementPark {
    private static final int Max_Capacity = 10;
    private static final int Min_Height = 90;
    private static final int Max_Height = 200;

    private int currentCapacity;

    public AmusementPark () {
        this.currentCapacity = 0;
    }

    public boolean checkHeight(int height) {
        return height > Min_Height && height < Max_Height;
    }

    public void addPerson(int height) {
        if (currentCapacity < Max_Capacity && checkHeight(height)) {
            currentCapacity++;
            
            System.out.println("Person added to the ride.");
        } else if (currentCapacity >= Max_Capacity) {
            System.out.println("The ride is full.");
            
        } else {
            System.out.println("The person's height does not meet for the ride");
        }
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public static void main(String[] args) {
        AmusementPark ride = new AmusementPark();

        // Example usage:
        ride.addPerson(120);  // Person added to the ride.
        ride.addPerson(180);  // Person added to the ride.
        ride.addPerson(120);  // Person added to the ride.
        ride.addPerson(285);   // The person's height does not meet for the ride.
        ride.addPerson(120);  // Person added to the ride.
        ride.addPerson(180);  // Person added to the ride.
        ride.addPerson(120);  // Person added to the ride.
        ride.addPerson(180);  // Person added to the ride.
        ride.addPerson(120);  // Person added to the ride.
        ride.addPerson(180);  // Person added to the ride.
        ride.addPerson(199);  // Person added to the ride.
        ride.addPerson(260);  // The person's height does not meet for the ride.

        // Check the current capacity
        System.out.println("Current capacity: " + ride.getCurrentCapacity());
    }
}