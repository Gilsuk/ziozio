package ziozio.enumeration;

public enum VerificationType {
	
	FIND('F'), EMAIL('M');
	
	private final char value;
	
	private VerificationType(char value) {
		this.value = value;
	}
	
	public char getValue() {
		return this.value;
	}

}
