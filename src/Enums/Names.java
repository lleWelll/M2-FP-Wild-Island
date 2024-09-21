package Enums;

import java.util.HashMap;

public enum Names {
			JOHN("John", "male", 0),
			EMMA("Emma", "female", 1),
			JAMES("James", "male", 2),
			OLIVIA("Olivia", "female", 3),
			ROBERT("Robert", "male", 4),
			AVA("Ava", "female", 5),
			MICHAEL("Michael", "male", 6),
			ISABELLA("Isabella", "female", 7),
			WILLIAM("William", "male", 8),
			SOPHIA("Sophia", "female", 9),
			CHARLES("Charles", "male", 10),
			AMELIA("Amelia", "female", 11),
			DAVID("David", "male", 12),
			CHARLOTTE("Charlotte", "female", 13),
			JOSEPH("Joseph", "male", 14),
			ABIGAIL("Abigail", "female", 15),
			THOMAS("Thomas", "male", 16),
			MIA("Mia", "female", 17),
			CHRISTOPHER("Christopher", "male", 18),
			EMILY("Emily", "female", 19),
			DANIEL("Daniel", "male", 20),
			HARPER("Harper", "female", 21),
			PAUL("Paul", "male", 22),
			EVELYN("Evelyn", "female", 23),
			EDWARD("Edward", "male", 24),
			SCARLETT("Scarlett", "female", 25),
			MARK("Mark", "male", 26),
			ELLA("Ella", "female", 27),
			GEORGE("George", "male", 28),
			GRACE("Grace", "female", 29),
			RICHARD("Richard", "male", 30),
			LILY("Lily", "female", 31),
			STEVEN("Steven", "male", 32),
			CHLOE("Chloe", "female", 33),
			BRIAN("Brian", "male", 34),
			PENELOPE("Penelope", "female", 35),
			KEVIN("Kevin", "male", 36),
			ZOE("Zoe", "female", 37),
			JOSHUA("Joshua", "male", 38),
			LAYLA("Layla", "female", 39),
			TIMOTHY("Timothy", "male", 40),
			VICTORIA("Victoria", "female", 41),
			JASON("Jason", "male", 42),
			HAZEL("Hazel", "female", 43),
			RYAN("Ryan", "male", 44),
			AURORA("Aurora", "female", 45),
			ERIC("Eric", "male", 46),
			SAVANNAH("Savannah", "female", 47),
			JEFFREY("Jeffrey", "male", 48),
			STELLA("Stella", "female", 49),
			ADAM("Adam", "male", 50),
			ELENA("Elena", "female", 51),
			JUSTIN("Justin", "male", 52),
			ELEANOR("Eleanor", "female", 53),
			SEAN("Sean", "male", 54),
			LUCY("Lucy", "female", 55),
			JACOB("Jacob", "male", 56),
			HANNAH("Hannah", "female", 57),
			ANTHONY("Anthony", "male", 58),
			ARIEL("Ariel", "female", 59),
			BENJAMIN("Benjamin", "male", 60),
			NORA("Nora", "female", 61),
			ZACHARY("Zachary", "male", 62),
			VIOLET("Violet", "female", 63),
			KYLE("Kyle", "male", 64),
			ELLIE("Ellie", "female", 65),
			JEREMY("Jeremy", "male", 66),
			SKYLAR("Skylar", "female", 67),
			ETHAN("Ethan", "male", 68),
			PAISLEY("Paisley", "female", 69),
			AARON("Aaron", "male", 70),
			ALLISON("Allison", "female", 71),
			NICHOLAS("Nicholas", "male", 72),
			SOPHIE("Sophie", "female", 73),
			MATTHEW("Matthew", "male", 74),
			RILEY("Riley", "female", 75),
			ANDREW("Andrew", "male", 76),
			SAMANTHA("Samantha", "female", 77),
			JONATHAN("Jonathan", "male", 78),
			AUBREY("Aubrey", "female", 79),
			GREGORY("Gregory", "male", 80),
			VIVIAN("Vivian", "female", 81),
			JACKSON("Jackson", "male", 82),
			EVA("Eva", "female", 83),
			ALEXANDER("Alexander", "male", 84),
			ARIA("Aria", "female", 85),
			CHRISTIAN("Christian", "male", 86),
			SADIE("Sadie", "female", 87),
			PATRICK("Patrick", "male", 88),
			NAOMI("Naomi", "female", 89),
			DYLAN("Dylan", "male", 90),
			ALEXA("Alexa", "female", 91),
			LUKE("Luke", "male", 92),
			LEAH("Leah", "female", 93),
			BRADLEY("Bradley", "male", 94),
			JULIA("Julia", "female", 95),
			VICTOR("Victor", "male", 96),
			MADISON("Madison", "female", 97),
			SAMUEL("Samuel", "male", 98),
			LUNA("Luna", "female", 99);

	private final String NAME;
	private final String GENDER;
	private final int NAME_INDEX;
	private static final HashMap<Integer, Names> NAME_MAP = new HashMap<>(); //HashMap for quick search by index
	static {
		for (Names name : Names.values()) {
			NAME_MAP.put(name.getNAME_INDEX(), name);
		}
	}

	Names(String name, String gender, int nameIndex) {
		this.NAME = name;
		this.GENDER = gender;
		this.NAME_INDEX = nameIndex;
	}
	public static Names getNameInstance(int index) {
		return NAME_MAP.get(index);
	}
	public static String getNameByIndex(int index) {
		return NAME_MAP.get(index).getNAME();
	}

	public String getNAME() {
		return NAME;
	}

	public String getGENDER() {
		return GENDER;
	}

	public int getNAME_INDEX() {
		return NAME_INDEX;
	}
}
