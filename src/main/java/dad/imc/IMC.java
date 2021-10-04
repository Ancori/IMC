package dad.imc;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;
;
    
public class IMC extends Application{
	private TextField PesoText, Alturatext;
	private DoubleProperty Peso= new SimpleDoubleProperty();
	private DoubleProperty Altura= new SimpleDoubleProperty();
	DoubleProperty resultado= new SimpleDoubleProperty();
	private Label imcresult,result; 
	private StringProperty p=new SimpleStringProperty();
	
	public void start(Stage primaryStage) throws Exception {
	    DoubleProperty resultado= new SimpleDoubleProperty();
		Peso.set(1);
		Altura.set(1);
		PesoText = new TextField();
		PesoText.setMaxWidth(100);
		Alturatext = new TextField();
		Alturatext.setMaxWidth(100);
		imcresult=new Label();
		result=new Label();
		Label l1 =new Label("Peso: ");
		Label l2 =new Label(" KG");
		HBox Peso2 = new HBox(5);
		Peso2.setAlignment(Pos.CENTER);
		Peso2.getChildren().addAll(l1,PesoText,l2);
		Label l3 =new Label("Altura: ");
		Label l4 =new Label(" CM");
		HBox ALtura = new HBox(5);
		ALtura.setAlignment(Pos.CENTER);
		ALtura.getChildren().addAll(l3,Alturatext,l4);
		HBox IMC = new HBox(5);
		IMC.setAlignment(Pos.CENTER);
		IMC.getChildren().addAll(imcresult);
		HBox VALOR = new HBox(5);
		VALOR.setAlignment(Pos.CENTER);
		VALOR.getChildren().addAll(result);
		
		VBox root= new VBox(5);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(Peso2,ALtura,IMC,VALOR);
		
		Scene scene = new Scene(root, 320, 200);
		primaryStage.setTitle("Suma");
		primaryStage.setScene(scene);
		primaryStage.show();
	  
		Bindings.bindBidirectional(PesoText.textProperty(), Peso ,new NumberStringConverter());
		Bindings.bindBidirectional(Alturatext.textProperty(), Altura ,new NumberStringConverter());
		resultado.bind(Peso.divide(Altura.multiply(Altura)).multiply(10000));
		imcresult.textProperty().bind(Bindings.concat("IMC: ").concat(resultado.asString()));
		resultado.addListener((o, ov, nv) -> {
			double i = nv.doubleValue();
			if(i<18.5) {
				p.set("Bajo Peso");
			}else if(i>=18.5 && i<25){
				p.set("Normal");
			}else if(i>=25 && i<30){
				p.set("Sobrepeso");
			}else if(i>=30) {
				p.set("Obeso");
			}
		});
		result.textProperty().bind(p);
	   

	
		
		
	}




	public static void main(String[] args) {
		launch(args);
	}

}
