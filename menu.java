/*
 * @author N
 **/
package ihm;

import java.io.File;

import javax.swing.GroupLayout.Alignment;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.TextAlignment;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class menu extends Application {

	public void start(Stage stage) {

		Application.setUserAgentStylesheet(getClass().getResource("style.css").toExternalForm());

		BackgroundImage bg = new BackgroundImage(new Image("file:/Users/yazst/Documents/NetBeansProjects/Gangsta/src/ressources/background.png"),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, null);
		BackgroundImage bg2 = new BackgroundImage(new Image("file:/Users/yazst/Documents/NetBeansProjects/Gangsta/src/ressources/bg2.jpg"),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, null);

		VBox v1 = new VBox();
		v1.setPadding(new Insets(15, 15, 15, 15));
		v1.setSpacing(10);
		v1.setBackground(new Background(bg));

		// BorderPane bp = new BorderPane();
		// bp.setBackground(new Background(bg));
		
		HBox menu = new HBox();
	

		Button lancerdemo = new Button("    Mode Demo");
		lancerdemo.setId("xx");
		lancerdemo.setTextAlignment(TextAlignment.CENTER);
		lancerdemo.setMaxWidth(155);

		Button choixporte = new Button("  Choix Porte ");
		choixporte.setId("xx");
		choixporte.setMaxWidth(155);

		Button choixgarage = new Button("  Choix Garage");
		choixgarage.setId("xx");
		choixgarage.setMaxWidth(165);

		Button lancerprog = new Button("       Lancez");
		lancerprog.setId("xx");
		lancerprog.setMaxWidth(155);

		Button retour = new Button("     retour");
		retour.setId("xxx");
		retour.setMaxWidth(125);
		
		final MenuBar menuBar = new MenuBar(); 
		final BorderPane root = new BorderPane();
		root.setTop(menuBar);
		final Menu fileMenu = new Menu("Fichier"); 
		final Menu editMenu = new Menu("edition"); 
		final Menu helpMenu = new Menu("Aide");  
		menuBar.getMenus().setAll(fileMenu, editMenu, helpMenu);

		menu.getChildren().add(root);
		v1.getChildren().addAll(lancerdemo, lancerprog);
		
		

		class video implements EventHandler<ActionEvent> {

			public void handle(ActionEvent event) {

				if (event.getTarget().equals(lancerdemo)) {
					VBox vid = new VBox();
					MediaView mediaview = new MediaView();
					vid.getChildren().addAll(mediaview);
					stage.setTitle("Mode Demo");
					stage.setScene(new Scene(vid, 1000, 1000));
					stage.show();
					File file = new File("file:/Users/yazst/Documents/NetBeansProjects/Gangsta/src/ressources/test.mp4");
					Media media = new Media(file.toURI().toString());
					MediaPlayer mediaplayer = new MediaPlayer(media);
					mediaview.setMediaPlayer(mediaplayer);
					mediaplayer.play();

				}

			}

		}

		retour.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				VBox v2 = new VBox();
				v2.setSpacing(10);
				v2.setAlignment(Pos.CENTER);
				v2.setBackground(new Background(bg));
				v2.getChildren().addAll(lancerdemo, lancerprog);
				Scene scene = new Scene(v2);
				stage.setTitle("Virtual View");
				stage.setScene(scene);
				stage.setHeight(1000);
				stage.setWidth(1000);
				stage.show();

			}

		});

		lancerdemo.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				
				Canvas canvaspace = new Canvas (40,40);
				VBox v2 = new VBox();
				v2.setSpacing(10);
				v2.setAlignment(Pos.CENTER);
				v2.getChildren().addAll(retour);
				VBox vid = new VBox();
				vid.setBackground(new Background(bg2));
				MediaView mediaview = new MediaView();
				vid.getChildren().addAll(mediaview,canvaspace,retour);
				stage.setTitle("Mode Demo");
				stage.setScene(new Scene(vid, 1000, 1000));
				stage.show();
				File file = new File("file:/Users/yazst/Documents/NetBeansProjects/Gangsta/src/ressources/test.mp4");
				Media media = new Media(file.toURI().toString());
				MediaPlayer mediaplayer = new MediaPlayer(media);
				mediaview.setMediaPlayer(mediaplayer);
				mediaplayer.play();

			}

		});

		choixporte.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Image imageVirtuelle;
				FileChooser f = new FileChooser();
				if (event.getTarget().equals(choixporte)) {
					Stage global = null;
					File path;
					path = f.showOpenDialog(global);

					ImageView test = new ImageView(path.toURI().toString());
					Image img = test.getImage();
					imageVirtuelle = img;

				}

			}

		});

		choixgarage.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Image imageVirtuelle;
				FileChooser f = new FileChooser();
				if (event.getTarget().equals(choixporte)) {
					Stage global = null;
					File path;
					path = f.showOpenDialog(global);

					ImageView test = new ImageView(path.toURI().toString());
					Image img = test.getImage();
					imageVirtuelle = img;

				}

			}

		});

		lancerprog.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				new Main(stage);
				stage.setHeight(800);
				stage.setWidth(1000);
			}
		});

		v1.setAlignment(Pos.CENTER);
		Scene scene = new Scene(v1);
		stage.setTitle("Virtual Views");
		stage.setScene(scene);
		stage.setHeight(800);
		stage.setWidth(1000);
		stage.show();

	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
