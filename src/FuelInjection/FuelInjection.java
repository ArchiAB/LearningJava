package FuelInjection;

public class FuelInjection {

	public int xThrottle, yFuel;
	
	void calculaeFuelInjection() {
		@SuppressWarnings("unused")
		boolean isXLessThan127 = xThrottle <=127;
		
		
		if (xThrottle <= 127) {
			
			yFuel = xThrottle *2;
			
		}
		
		else {
			yFuel = xThrottle +127;
			
		}
		System.out.println("yFuel value is: "+ yFuel);
		
	}
	
	void anotherMethodToCalculateFuelInjectin() {
		boolean isXLessThan127 = xThrottle <=127;
		if (isXLessThan127 ==true)
	}

}
