package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class IMC extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Text text = new Text("Peso");
			TextField Peso = new TextField("0");
			Peso.setPrefColumnCount(4);
			Text text2 = new Text("Altura");
			TextField Altura = new TextField("0");
			Altura.setPrefColumnCount(4);
			Text TextResul = new Text("");

			HBox PesoBox = new HBox();
			PesoBox.setAlignment(Pos.BASELINE_CENTER);
			PesoBox.setSpacing(5);
			PesoBox.getChildren().addAll(text, Peso);

			HBox Alturabox = new HBox();
			Alturabox.setAlignment(Pos.BASELINE_CENTER);
			Alturabox.setSpacing(5);
			Alturabox.getChildren().addAll(text2, Altura);
			Text IMC = new Text("");
			Button Calcular = new Button("Calcular");
			Calcular.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					double peso = Integer.parseInt(Peso.getText());
					double altura = Integer.parseInt(Altura.getText());
					double op = peso / (altura * altura);
					double resultado = op * 10000;
					IMC.setText("IMC: " + resultado);
					if (resultado < 18.5) {
						TextResul.setText("Bajo Peso");
					}
					if (resultado > 18.5 && resultado < 25) {
						TextResul.setText("Peso Normal");
					}
					if (resultado > 25 && resultado < 30) {
						TextResul.setText("Sobrepeso");
					}
					if (resultado > 30) {
						TextResul.setText("Obeso");
					}
				}

			});

			VBox root = new VBox();
			root.setSpacing(5);
			root.setAlignment(Pos.CENTER);

			root.getChildren().addAll(PesoBox, Alturabox, Calcular, IMC, TextResul);
			Scene scene = new Scene(root, 400, 400);
			primaryStage.setTitle("IMC");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
