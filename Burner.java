
public class Burner {
	public final static int TIME_DURATION = 2;
	public enum Temperature {
		COLD,
		WARM,
		HOT,
		BLAZING
	}

	private Temperature myTemperature;
	private Setting mySetting; //don't know its privacy
	private int timer = 0;
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
			break;
		case LOW:
			mySetting = Setting.MEDIUM;
			break;
		case MEDIUM:
			mySetting = Setting.HIGH;
			break;
		default:
			break;
		}
		timer = TIME_DURATION;
	}

	public void minusButton() {
		switch (mySetting) {
		//case OFF, setting OFF
		case HIGH:
			mySetting = Setting.MEDIUM;
			break;
		case MEDIUM:
			mySetting = Setting.LOW;
			break;
		case LOW:
			mySetting = Setting.OFF;
			break;
		case OFF:
			//do nothing, already minimum
			break;
		}
		timer = TIME_DURATION;
	}

	public void updateTemperature() {
		timer -= 1;
		if (timer == 0) {
			if (myTemperature.ordinal() < mySetting.ordinal()) {
				myTemperature = Temperature.values()[myTemperature.ordinal() + 1];
				timer = TIME_DURATION;
			} else if (myTemperature.ordinal() > mySetting.ordinal()) {
				myTemperature = Temperature.values()[myTemperature.ordinal() - 1];
				timer = TIME_DURATION;
			}
		}	
	}


	public void display() {
		String tempText = "";
		switch (myTemperature) {
		case COLD:    
			tempText = "cooool"; 
			break;
		case WARM:    
			tempText = "warm"; 
			break;
		case HOT:     
			tempText = "CAREFUL"; 
			break;
		case BLAZING: 
			tempText = "VERY HOT! DON'T TOUCH"; 
			break;
		}

		System.out.println(mySetting + "....." + tempText);
	}
}

