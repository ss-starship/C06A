
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
	int timer = 0;
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
		switch (mySetting) {
		case OFF:
			mySetting = Setting.LOW;
		case LOW:
			mySetting = Setting.MEDIUM;
		case MEDIUM:
			mySetting = Setting.HIGH;
			//case HIGH, setting HIGH
		default:
			break;
		}
		timer = TIME_DURATION;
	}

	public void minusButton() {
		switch (mySetting) {
		//case OFF, setting OFF
		case LOW:
			mySetting = Setting.OFF;
		case MEDIUM:
			mySetting = Setting.LOW;
		case HIGH:
			mySetting = Setting.MEDIUM;
		default:
			break;
		}
		timer = TIME_DURATION;
	}

	public void updateTemperature() {
		//timer -= 1;
	}

	public void display() {
		System.out.println(mySetting + "....." + myTemperature);
	}

}
