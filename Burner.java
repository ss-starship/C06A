
public class Burner {
	public final static int TIME_DURATION = 2;
	public enum Temperature {
		BLAZING,
		HOT,
		WARM,
		COLD
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
		if (timer > 0) {
			timer --;
			return;
		}
		Temperature targetTemp = null;
		switch (mySetting) {
		case OFF:
			targetTemp = Temperature.COLD;
			break;
		case LOW:
			targetTemp = Temperature.WARM;
			break;
		case MEDIUM:
			targetTemp = Temperature.HOT;
			break;
		case HIGH:
			targetTemp = Temperature.BLAZING;
			break;
		}

		if (myTemperature.ordinal() < targetTemp.ordinal()) {
			myTemperature = Temperature.values()[myTemperature.ordinal() + 1];
			timer = TIME_DURATION;
		} else if (myTemperature.ordinal() > targetTemp.ordinal()) {
			myTemperature = Temperature.values()[myTemperature.ordinal() - 1];
			timer = TIME_DURATION;
		}
	}


	public void display() {
		String settingSymbol = "";
		
		switch (mySetting) {
		case OFF:    
			settingSymbol = "---"; 
			break;
		case LOW:    
			settingSymbol = "--+"; 
			break;
		case MEDIUM: 
			settingSymbol = "-++"; 
			break;
		case HIGH:   
			settingSymbol = "+++"; 
			break;
		}

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

		System.out.println("[" + settingSymbol + "]....." + tempText);
	}
}

