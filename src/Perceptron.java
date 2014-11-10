import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Perceptron {
	private int	updates;

	public Perceptron() {
	}

	public Point learn(ArrayList<Datum> data, boolean isShuffle) {
		Weight weight = new Weight(new Point(0, 0, 0, 0, 0), 0);
		int currentUpdates = 0;
		do {
			currentUpdates = findMistakeAndUpdateWeight(data, isShuffle, weight);
			this.updates += currentUpdates;
		}
		while (currentUpdates > 0);

		// System.out.println(String.format("Updates¡G%s", updates));

		return weight.weight;
	}

	public Point pocket(ArrayList<Datum> data, boolean isShuffle, int iteration) {
		Weight weight = new Weight(new Point(0, 0, 0, 0, 0), 0);
		int updates = 0;
		int minMistakes = Integer.MAX_VALUE;
		Point bestWeight = null;
		do {
			if (isShuffle) {
				shuffle(data);
			}

			for (Datum datum : data) {
				if (!isCorrect(datum, weight)) {
					if (updates == iteration)
						break;
					weight.weight = PointHelper.add(weight.weight, PointHelper.mutipleByScalar(datum.point, datum.result));
					int mistakes = validate(data, weight.weight);
					if (mistakes < minMistakes) {
						minMistakes = mistakes;
						bestWeight = weight.weight;
					}
					updates++;
				}
			}
		}
		while (updates != iteration);

		// System.out.println(String.format("Updates¡G%s", updates));

		return bestWeight;
	}

	public Point getWeight(ArrayList<Datum> data, int iteration) {
		Weight weight = new Weight(new Point(0, 0, 0, 0, 0), 0);
		shuffle(data);

		while (iteration > 0) {
			for (Datum datum : data) {
				if (!isCorrect(datum, weight)) {
					if (iteration == 0)
						break;
					iteration--;
					weight.weight = PointHelper.add(weight.weight, PointHelper.mutipleByScalar(datum.point, datum.result));
				}
			}
		}

		return weight.weight;
	}

	public int validate(ArrayList<Datum> data, Point weight) {
		int mistakeCount = 0;

		for (Datum datum : data) {
			if (!isCorrect(datum, new Weight(weight, 0))) {
				mistakeCount++;
			}
		}

		return mistakeCount;
	}

	public int getUpdates() {
		return updates;
	}

	public void setUpdates(int updates) {
		this.updates = updates;
	}

	private <T> void shuffle(List<T> list) {
		Collections.shuffle(list, new Random(System.currentTimeMillis()));
	}

	private int findMistakeAndUpdateWeight(ArrayList<Datum> data, boolean isShuffle, Weight weight) {
		int updates = 0;

		if (isShuffle) {
			shuffle(data);
		}

		for (Datum datum : data) {
			if (!isCorrect(datum, weight)) {
				weight.weight = PointHelper.add(weight.weight, PointHelper.mutipleByScalar(datum.point, datum.result));
				updates++;
			}
		}

		return updates;
	}

	private boolean isCorrect(Datum datum, Weight weight) {
		Point point = datum.point;
		int result = datum.result;

		BigDecimal product = PointHelper.mutiple(point, weight.weight);
		int sign = (product.signum() == 1) ? 1 : -1;

		if (result != sign) {
			return false;
		}

		return true;
	}

	private Point findBestWeight(ArrayList<Weight> weights) {
		Weight bestWeight = Collections.min(weights, new Comparator<Weight>() {

			@Override
			public int compare(Weight o1, Weight o2) {
				if (o1.mistakes < o2.mistakes) {
					return -1;
				}
				else
					if (o1.mistakes == o2.mistakes) {
						return 0;
					}
					else {
						return 1;
					}
			}
		});

		return bestWeight.weight;
	}
}
