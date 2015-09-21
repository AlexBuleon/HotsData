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

    /**
     * Hero constructor. Uses a Hero name and connect to
     * \"http://heroesofthestorm.gamepedia.com/\" and retrives the wanted data
     * to construct the wanted <code>Hero</code> object.
     * 
     * @author Elyos
     * */
    public Hero(String name) {

	this.name = name;

	String data = HotsData.getHtmlSource(name);
	data = data.substring(data.indexOf("> Role"),
		data.lastIndexOf("<th> Energy Regen") + 50);

	String role = data.substring(data.indexOf("<td>") + 5,
		data.indexOf("</td>") - 1);
	if (role.equals("Assasin"))
	    this.role = ROLE_ASSASSIN;
	if (role.equals("Warrior"))
	    this.role = ROLE_WARRIOR;
	if (role.equals("Support"))
	    this.role = ROLE_SUPPORT;
	if (role.equals("Specialist"))
	    this.role = ROLE_SPECIALIST;

	data = data.substring(data.indexOf("<th> Type") + 21);
	String type = data.substring(0, data.indexOf("</td>") - 1);
	if (type.equals("Melee"))
	    this.type = TYPE_MELEE;
	if (type.equals("Ranged"))
	    this.type = TYPE_RANGED;

	data = data.substring(data.indexOf("<th> Health") + 23);
	Double health = Double.valueOf(data.substring(0,
		data.indexOf("</td>") - 1));

	data = data.substring(data.indexOf("<th> Health Regen") + 29);
	Double healthRegen = Double.valueOf(data.substring(0,
		data.indexOf("</td>") - 1));

	data = data.substring(data.indexOf("<th> Energy") + 23);
	Double energy = Double.valueOf(data.substring(0,
		data.indexOf("</td>") - 1));

	data = data.substring(data.indexOf("<th> Energy Regen") + 29);
	Double energyRegen = Double.valueOf(data.substring(0,
		data.indexOf("</td>") - 1));

	data = data.substring(data.indexOf("<th> Speed") + 22);
	Double speed = Double.valueOf(data.substring(0,
		data.indexOf("</td>") - 1));

	data = data.substring(data.indexOf("<th> Attack Speed") + 29);
	Double attackSpeed = Double.valueOf(data.substring(0,
		data.indexOf("</td>") - 1));

	data = data.substring(data.indexOf("<th> Attack Range") + 29);
	Double attackRange = Double.valueOf(data.substring(0,
		data.indexOf("</td>") - 1));

	data = data.substring(data.indexOf("<th> Attack Damage") + 30);
	Double attackDamage = Double.valueOf(data.substring(0,
		data.indexOf("</td>") - 1));

	data = data.substring(data.indexOf("<th> Max Health") + 27);
	Double healthPerLevel = Double.valueOf(data.substring(0,
		data.indexOf("</td>") - 1));

	data = data.substring(data.indexOf("<th> Health Regen") + 29);
	Double healthRegenPerLevel = Double.valueOf(data.substring(0,
		data.indexOf("</td>") - 1));

	data = data.substring(data.indexOf("<th> Splash Damage") + 30);
	Double attackDamagePerLevel = Double.valueOf(data.substring(0,
		data.indexOf("</td>") - 1));

	data = data.substring(data.indexOf("<th> Max Energy") + 27);
	Double energyPerLevel = Double.valueOf(data.substring(0,
		data.indexOf("</td>") - 1));

	data = data.substring(data.indexOf("<th> Energy Regen") + 29);
	Double energyRegenPerLevel = Double.valueOf(data.substring(0,
		data.indexOf("</td>") - 1));

	Stat[] stats = new Stat[8];
	stats[0] = new Stat("Health", health, healthPerLevel);
	stats[1] = new Stat("Health Regen", healthRegen, healthRegenPerLevel);
	stats[2] = new Stat("Energy", energy, energyPerLevel);
	stats[3] = new Stat("Energy Regen", energyRegen, energyRegenPerLevel);
	stats[4] = new Stat("Speed", speed);
	stats[5] = new Stat("Attack Damage", attackDamage, attackDamagePerLevel);
	stats[6] = new Stat("Attack Speed", attackSpeed);
	stats[7] = new Stat("Attack Range", attackRange);

	this.stats = stats;

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
