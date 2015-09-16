package CodeSource;

public class Hero {

	public static final int ROLE_ASSASSIN = 0;
	public static final int ROLE_WARRIOR = 1;
	public static final int ROLE_SUPPORT = 2;
	public static final int ROLE_SPECIALIST = 3;

	public static final int TYPE_MELEE = 0;
	public static final int TYPE_RANGED = 1;

	private String name;
	private int role;
	private int type;
	private Stat[] stats;

	public Hero(String name, int role, int type, Stat[] stats) {
		this.name = name;
		this.role = role;
		this.type = type;
		this.stats = stats;
	}

	public Hero(String name) {
		this.name = name;

		String htmlSource = HotsData.getHtmlSource(name);
		String data = htmlSource.substring(htmlSource.indexOf("> Role"),
				htmlSource.lastIndexOf("<th> Energy Regen") + 50);
		htmlSource = null;
		System.out.println(data);
		String role = data.substring(data.indexOf("<td>") + 5, data.indexOf("</td>"));
		System.out.println(role);
	}

	public String getName() {
		return name;
	}

	public int getRole() {
		return role;
	}

	public int getType() {
		return type;
	}

	public Stat[] getStats() {
		return stats;
	}
}
