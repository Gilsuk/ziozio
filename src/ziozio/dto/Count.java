package ziozio.dto;

public class Count implements DTO {
	private int count;
	@Override
	public String toString() {
		return "Count [count=" + count + "]";
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
