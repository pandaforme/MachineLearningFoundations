import java.math.BigDecimal;

public class PointHelper {

	public static BigDecimal mutiple(Point x, Point y) {
		BigDecimal x1 = x.x1.multiply(y.x1);
		BigDecimal x2 = x.x2.multiply(y.x2);
		BigDecimal x3 = x.x3.multiply(y.x3);
		BigDecimal x4 = x.x4.multiply(y.x4);
		BigDecimal x5 = x.x5.multiply(y.x5);
		BigDecimal sum = x1.add(x2).add(x3).add(x4).add(x5);

		return sum;
	}

	public static Point mutipleByScalar(Point x, int y) {
		BigDecimal x1 = x.x1.multiply(new BigDecimal(y));
		BigDecimal x2 = x.x2.multiply(new BigDecimal(y));
		BigDecimal x3 = x.x3.multiply(new BigDecimal(y));
		BigDecimal x4 = x.x4.multiply(new BigDecimal(y));
		BigDecimal x5 = x.x5.multiply(new BigDecimal(y));

		return new Point(x1, x2, x3, x4, x5);
	}

	public static Point mutipleByScalar(Point x, double y) {
		BigDecimal x1 = x.x1.multiply(new BigDecimal(y));
		BigDecimal x2 = x.x2.multiply(new BigDecimal(y));
		BigDecimal x3 = x.x3.multiply(new BigDecimal(y));
		BigDecimal x4 = x.x4.multiply(new BigDecimal(y));
		BigDecimal x5 = x.x5.multiply(new BigDecimal(y));

		return new Point(x1, x2, x3, x4, x5);
	}

	public static Point add(Point x, Point y) {
		BigDecimal x1 = x.x1.add(y.x1);
		BigDecimal x2 = x.x2.add(y.x2);
		BigDecimal x3 = x.x3.add(y.x3);
		BigDecimal x4 = x.x4.add(y.x4);
		BigDecimal x5 = x.x5.add(y.x5);

		return new Point(x1, x2, x3, x4, x5);
	}
}