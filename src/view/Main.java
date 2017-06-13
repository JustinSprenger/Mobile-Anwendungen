package view;

import database.Speed;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.Event;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
	
	public static void main(String[] args){
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Button login = new Button("Anmelden");
		TextField name = new TextField();
		TextField pw = new TextField();
		Label username = new Label("Benutzer:");
		Label password = new Label("Passwort:");
		Hyperlink registration = new Hyperlink("Registrieren");
		
		//
		
		FlowPane flpane1 = new FlowPane();
		FlowPane flpane2 = new FlowPane();
		FlowPane flpane3 = new FlowPane();
		FlowPane flpane4 = new FlowPane();
		FlowPane flpane5 = new FlowPane();
		FlowPane flpane6 = new FlowPane();
		
		flpane1.getChildren().add(username);
		flpane2.getChildren().add(name);
		flpane3.getChildren().add(password);
		flpane4.getChildren().add(pw);
		flpane5.getChildren().add(login);
		flpane6.getChildren().add(registration);
		
		VBox vbox = new VBox(1);
		vbox.getChildren().addAll(flpane1,flpane2,flpane3,flpane4,flpane5,flpane6);
		
		Scene scene = new Scene(vbox,300,300);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		login.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				try {
					prog(primaryStage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		registration.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				try {
					reg(primaryStage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
	}
	
	public void reg(Stage primaryStage) throws Exception {
		Button registration = new Button("Registrieren");
		Button cancel = new Button("Abbrechen");
		TextField name = new TextField();
		TextField pw = new TextField();
		TextField pwr = new TextField();
		Label username = new Label("Benutzer:");
		Label password = new Label("Passwort:");
		Label passwordr = new Label("Passwort wiederholen:");
		
		
		FlowPane flpane1 = new FlowPane();
		FlowPane flpane2 = new FlowPane();
		FlowPane flpane3 = new FlowPane();
		FlowPane flpane4 = new FlowPane();
		FlowPane flpane5 = new FlowPane();
		FlowPane flpane6 = new FlowPane();
		FlowPane flpane7 = new FlowPane(Orientation.HORIZONTAL,100,100);
		
		flpane1.getChildren().add(username);
		flpane2.getChildren().add(name);
		flpane3.getChildren().add(password);
		flpane4.getChildren().add(pw);
		flpane5.getChildren().add(passwordr);
		flpane6.getChildren().add(pwr);
		flpane7.getChildren().addAll(registration,cancel);
		
		VBox vbox = new VBox(1);
		vbox.getChildren().addAll(flpane1,flpane2,flpane3,flpane4,flpane5,flpane6,flpane7);
		
		Scene scene = new Scene(vbox,300,300);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		cancel.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				try {
					start(primaryStage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
	}
	
	public void prog(Stage primaryStage) throws Exception {
		Button speed = new Button("Geschwindigkeit messen");
		Button logout = new Button("Ausloggen");
		Button viewresult = new Button("Letzte Messung anzeigen");
		Label l1 = new Label("Ereignisse:");
		TextArea result = new TextArea();
		result.setPrefColumnCount(50);
		result.setPrefRowCount(15);
		
		FlowPane flpane1 = new FlowPane(Orientation.HORIZONTAL,370,100);
		FlowPane flpane2 = new FlowPane(Orientation.HORIZONTAL,385,100);
		FlowPane flpane3 = new FlowPane();
		flpane1.getChildren().addAll(speed,logout);
		flpane2.getChildren().addAll(l1,viewresult);
		flpane3.getChildren().add(result);
		VBox vbox = new VBox(1);
		vbox.getChildren().addAll(flpane1,flpane2,flpane3);
		Scene scene = new Scene(vbox,600,350);
		
		primaryStage.setScene(scene);
		
		primaryStage.show();
		speed.setOnAction((event)->{
			result.setText(result.getText() + Speed.getSpeed());
			Thread t = new Thread(()->{
				
			});
		});
		
		
		logout.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				try {
					start(primaryStage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		
	}
	
}
