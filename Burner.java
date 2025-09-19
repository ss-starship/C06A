
public class Burner {
	public final static int TIME_DURATION = 2;
	private enum Temperature {
		BLAZING,
		HOT,
		WARM,
		COLD
	}
	
	private Temperature myTemperature;
	Setting mySetting; //don't know its privacy
	int timer;
	//end variables
	
	//constructor
	public Burner() {
		myTemperature = Temperature.COLD;
		mySetting = Setting.OFF;
	}
	
	//getter
	public Temperature getMyTemperature() {
		return myTemperature;
	}
	
	//functions
	public void plusButton() {
		// TODO Auto-generated method stub
		
	}

	public void minusButton() {
		// TODO Auto-generated method stub
		
	}

	public void updateTemperature() {
		// TODO Auto-generated method stub
		
	}
	
	public void display() {
		
	}

}
