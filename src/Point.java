import java.math.BigDecimal;

public class Point {
	public BigDecimal	x1;
	public BigDecimal	x2;
	public BigDecimal	x3;
	public BigDecimal	x4;
	public BigDecimal	x5;

	public Point(String x1, String x2, String x3, String x4, String x5) {
		this.x1 = new BigDecimal(x1);
		this.x2 = new BigDecimal(x2);
		this.x3 = new BigDecimal(x3);
		this.x4 = new BigDecimal(x4);
		this.x5 = new BigDecimal(x5);
	}
	
	public Point(int x1, int x2, int x3, int x4, int x5) {
		this.x1 = new BigDecimal(x1);
		this.x2 = new BigDecimal(x2);
		this.x3 = new BigDecimal(x3);
		this.x4 = new BigDecimal(x4);
		this.x5 = new BigDecimal(x5);
	}

	public Point(BigDecimal x1, BigDecimal x2, BigDecimal x3, BigDecimal x4, BigDecimal x5) {
		this.x1 = x1;
		this.x2 = x2;
		this.x3 = x3;
		this.x4 = x4;
		this.x5 = x5;
	}

	public String toString() {
		return String.format("(%s, %s, %s, %s, %s)", x1, x2, x3, x4, x5);
	}
}
