package CodeSource;

public class Stat {

	private String name;
	private double value;
	private double valuePerLevel;

	public Stat(String name, double value, double valuePerLevel) {

		this.name = name;
		this.value = value;
		this.valuePerLevel = valuePerLevel;

	}

	public String getName() {
		return this.name;
	}

	public double getValue() {
		return this.value;
	}

	public double getValuePerLevel() {
		return this.valuePerLevel;
	}
}
