package ziozio.dto;

public class ClothWithColor extends Cloth {
	private Color color;

	@Override
	public String toString() {
		return "ClothWithColor [color=" + color + ", toString()=" + super.toString() + "]";
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}
