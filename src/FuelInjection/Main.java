package FuelInjection;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//class object=new class();
		
		FuelInjection gas=new FuelInjection();
		//Assigning value to the variable object.variable
		gas.xThrottle=128;
		
		//condtion
		if(gas.xThrottle<=127) {
			
			//expression
			gas.yFuel=gas.xThrottle*2;
			
		}
		else {
			gas.yFuel=gas.xThrottle+127;
		}
		System.out.println("The fuel injection value is "+gas.yFuel);
		
		
	}

}
