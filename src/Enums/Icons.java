package Enums;

public enum Icons {
	RIVER("\uD83D\uDFE6"),
	PLAIN("\uD83D\uDFE9"),
	MOUNTAIN("\uD83D\uDFEB"),
	BEACH("\uD83D\uDFE8"),

	WOLF("\uD83D\uDC3A"),
	BEAR("\uD83D\uDC3B"),
	EAGLE("\uD83E\uDD85"),
	FOX("\uD83E\uDD8A"),
	TIGER("\uD83D\uDC2F"),

	DEER("\uD83E\uDD8C"),
	HORSE("\uD83D\uDC34"),
	HARE("\uD83D\uDC30"),
	MOUSE("\uD83D\uDC2D"),
	DUCK("\uD83E\uDD86"),
	BUFFALO("\uD83E\uDDAC"),

	GRASS("\uD83C\uDF31"),
	TREE("\uD83C\uDF33"),
	BUSH("\uD83E\uDD66"),

	CORPSE("\uD83D\uDC80"),
	GOD("\uD83D\uDD31");


	private String icon;

	Icons(String icon) {
		this.icon = icon;
	}

	public String getIcon() {
		return icon;
	}
}
