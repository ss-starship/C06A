
public enum Setting {
	OFF("---"),
	LOW("--+"),
	MEDIUM("-++"),
	HIGH("+++");

	private final String display;
	
	private Setting(String display) {
		this.display = display;
	}
	
	@Override
	public String toString() {
		return display;
	}
}
