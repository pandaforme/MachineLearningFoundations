import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class Run {

	public static void main(String[] args) throws IOException {
		// question15();
		// question16();
		// question18();
		// question19();
		 question20();
	}

	private static ArrayList<Datum> readDataSet(String url) throws IOException {
		ArrayList<Datum> data = new ArrayList<>();

		try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new URL(url).openStream()));) {

			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				String[] tmp = line.split(" |\t");
				Point point = new Point("1", tmp[0], tmp[1], tmp[2], tmp[3]);

				Datum datum = new Datum(point, Integer.valueOf(tmp[4]));
				data.add(datum);
			}
		}

		// data.add(new Datum(new Point("1", "0.97", "0.10","0.64", "0.29"),
		// 1));
		// data.add(new Datum(new Point("1", "0.67", "0.24","0.83", "0.42"),
		// -1));
		// data.add(new Datum(new Point("1", "0.20", "0.23","0.810", "0.98"),
		// 1));
		// data.add(new Datum(new Point("1", "0.51", "0.05","0.92", "0.75"),
		// -1));
		// data.add(new Datum(new Point("1", "0.70", "0.10","0.33", "0.77"),
		// 1));

		return data;
	}

	private static void question15() throws IOException {
		Perceptron perceptron = new Perceptron();
		ArrayList<Datum> trainingData = readDataSet("https://d396qusza40orc.cloudfront.net/ntumlone%2Fhw1%2Fhw1_15_train.dat");
		perceptron.learn(trainingData, false);
	}

	private static void question16() throws IOException {
		Perceptron perceptron = new Perceptron();
		ArrayList<Datum> trainingData = readDataSet("https://d396qusza40orc.cloudfront.net/ntumlone%2Fhw1%2Fhw1_15_train.dat");
		double sum = 0;
		for (int i = 0; i < 2000; i++) {
			perceptron.learn(trainingData, true);
			sum += perceptron.getUpdates();
			perceptron.setUpdates(0);
		}

		System.out.println(sum / 2000);
	}

	private static void question18() throws IOException {
		double sum = 0;
		ArrayList<Datum> trainingData = readDataSet("https://d396qusza40orc.cloudfront.net/ntumlone%2Fhw1%2Fhw1_18_train.dat");
		ArrayList<Datum> testData = readDataSet("https://d396qusza40orc.cloudfront.net/ntumlone%2Fhw1%2Fhw1_18_test.dat");
		Perceptron perceptron = new Perceptron();
		Point bestWeight;
		for (int i = 0; i < 2000; i++) {
			bestWeight = perceptron.pocket(trainingData, true, 50);
			int mistakeCount = perceptron.validate(testData, bestWeight);
			sum += ((double) mistakeCount / testData.size());
			System.out.println(i);
		}

		System.out.println(sum / 2000);
	}

	private static void question19() throws IOException {
		double sum = 0;
		ArrayList<Datum> trainingData = readDataSet("https://d396qusza40orc.cloudfront.net/ntumlone%2Fhw1%2Fhw1_18_train.dat");
		ArrayList<Datum> testData = readDataSet("https://d396qusza40orc.cloudfront.net/ntumlone%2Fhw1%2Fhw1_18_test.dat");
		Perceptron perceptron = new Perceptron();
		Point bestWeight;
		for (int i = 0; i < 2000; i++) {
			bestWeight = perceptron.getWeight(trainingData, 50);
			int mistakeCount = perceptron.validate(testData, bestWeight);
			sum += ((double) mistakeCount / testData.size());
		}

		System.out.println(sum / 2000);
	}

	private static void question20() throws IOException {
		double sum = 0;
		ArrayList<Datum> trainingData = readDataSet("https://d396qusza40orc.cloudfront.net/ntumlone%2Fhw1%2Fhw1_18_train.dat");
		ArrayList<Datum> testData = readDataSet("https://d396qusza40orc.cloudfront.net/ntumlone%2Fhw1%2Fhw1_18_test.dat");
		Perceptron perceptron = new Perceptron();
		Point bestWeight;
		for (int i = 0; i < 2000; i++) {
			bestWeight = perceptron.pocket(trainingData, true, 100);
			int mistakeCount = perceptron.validate(testData, bestWeight);
			sum += ((double) mistakeCount / testData.size());
		}
		System.out.println(sum / 2000);
	}
}
