package piecharts;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

import java.text.Bidi;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class PieCharts extends Application {
	private final GridPane root = new GridPane();

	@Override
	public void start(Stage primaryStage) {
		root.setAlignment(Pos.CENTER);
		root.setHgap(20);
		root.setVgap(10);

		createPieChart();

		Scene scene = new Scene(root, 500, 300);
		primaryStage.setTitle("Pie Chart");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void createPieChart() {
		SimpleIntegerProperty sum = new SimpleIntegerProperty(1);
		List<SimpleIntegerProperty> intermediateSums = new ArrayList<>();
		List<SimpleIntegerProperty> values = new ArrayList<>();
		int amountOfSlices = 4;
		for (int i = 0; i < amountOfSlices; i++) {
			TextField textField = new TextField("1");
			textField.textProperty().addListener(
					(observable, oldValue, newValue) -> {
						if (!newValue.matches("[1-9]\\d{0,3}")) {
							textField.setText(oldValue);
						}
					}
			);

			SimpleIntegerProperty value = new SimpleIntegerProperty(1);
			Bindings.bindBidirectional(textField.textProperty(), value, new NumberStringConverter());
			values.add(value);

			SimpleIntegerProperty intermediateSum = new SimpleIntegerProperty();
			intermediateSum.bind(i == 0 ? value : intermediateSums.get(i - 1).add(value));
			intermediateSums.add(intermediateSum); // Add intermediate sum to array list
			root.add(textField, 0, i);
		}

		sum.bind(intermediateSums.get(intermediateSums.size() - 1)); // Sum will be bound to last intermediate sum

		for (int i = 0; i < amountOfSlices; i++) {
			SimpleIntegerProperty value = values.get(i);
			SimpleDoubleProperty outputValue = new SimpleDoubleProperty();
			SimpleDoubleProperty sumDouble = new SimpleDoubleProperty();
			sumDouble.bind(sum);
			outputValue.bind(value.divide(sumDouble));

			Label outputLabel = new Label();
			outputLabel.textProperty().bind(outputValue.asString());
			root.add(outputLabel, 1, i);
		}
		Label sumLabel = new Label();
		sumLabel.textProperty().bind(sum.asString());
		root.add(sumLabel, 0, 4);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
