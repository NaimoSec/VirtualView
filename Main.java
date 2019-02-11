/*
 * @Author N.
 */
package ihm;
import java.io.File;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.PerspectiveTransform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
public class Main extends Application{
	
	
	HBox root = new HBox();
	ArrayList <Coordonnees> coordonnees = new ArrayList<>();
	BackgroundImage bg = new BackgroundImage(new Image("file:/Users/yazst/Documents/NetBeansProjects/Gangsta/src/ressources/bg2.jpg"),
			BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, null);
	Canvas canvas = new Canvas (450, 450);
    Canvas canvo = new Canvas (0,20);
    Canvas canvi = new Canvas(0,15);
    Canvas canvu = new Canvas(100,135);
    double ulx,uly,urx,ury,lrx,lry,llx,lly;
    int cpt = 0;
    Button valider = new Button("Valider");
    Button reset = new Button("Reset");
    Button add = new Button("Votre Porte/Fenetre");
    Button retour = new Button("Retour");
	Button choixporte = new Button("  Choix Porte ");
    Button choixgarage = new Button("  Choix du fond");
    HBox v2 = new HBox();
    Stage global;
	FileChooser f = new FileChooser(); 
	FileChooser gg = new FileChooser();
    GraphicsContext gc;
    ArrayList<Image> listVirtuelle = new ArrayList<Image>();
    Image imageVirtuelle = new Image("file:/Users/yazst/Documents/NetBeansProjects/Gangsta/src/ressources/imageVirtuelle.png");
    Image imageRelle;
    Image imagered;
    PerspectiveTransform perspectivetransform = new PerspectiveTransform();
    
    
    public Main() {
    Application.setUserAgentStylesheet(getClass().getResource("style.css").toExternalForm());
    PerspectiveTransform perspectiveTransform = new PerspectiveTransform();
    valider.setId("xx");
    reset.setId("xx");
    add.setId("xx");
    add.setId("xx");
    retour.setId("xx");
    choixgarage.setId("xx");
    choixporte.setId("xx");
    reset.setAlignment(Pos.CENTER);
    valider.setAlignment(Pos.CENTER);
    add.setAlignment(Pos.CENTER);
    canvas.setId("test");
    root.setAlignment(Pos.CENTER);
    
    
    	
    }
    
    
    class clickButton implements EventHandler <ActionEvent> {
    	
    	
 		public void handle(ActionEvent event) {
 		
 			if(event.getTarget().equals(add)){
 				File path;
 			path = f.showOpenDialog(global);
 			
 			ImageView test =  new ImageView(path.toURI().toString());
 				Image img = test.getImage();
 				imageVirtuelle = img;
 				
 				
 			}
 			
 		}
     	
     }
    
    class selectionPoints implements EventHandler<MouseEvent> {
 

		public void handle(MouseEvent e) {
    		  
    		

    	  
    	   v2.getChildren().remove(canvas);
    	   
    	   if (cpt == 0) {
    	    perspectivetransform = new PerspectiveTransform();
    	   }
    	   cpt++;
    	   coordonnees.add(new Coordonnees((int) e.getSceneX(), (int) e.getSceneY()));

    	   if (cpt == 4) {
    	    cpt = 0;
    	    coordonnees = Coordonnees.trierCoordonnees(coordonnees);
    	    perspectivetransform.setUlx(coordonnees.get(0).x);
    	    perspectivetransform.setUly(coordonnees.get(0).y - 170);
    	    perspectivetransform.setUrx(coordonnees.get(1).x);
    	    perspectivetransform.setUry(coordonnees.get(1).y - 170);
    	    perspectivetransform.setLrx(coordonnees.get(3).x);
    	    perspectivetransform.setLry(coordonnees.get(3).y - 170);
    	    perspectivetransform.setLlx(coordonnees.get(2).x);
    	    perspectivetransform.setLly(coordonnees.get(2).y - 170);
    	    coordonnees.remove(3);
    	    coordonnees.remove(2);
    	    coordonnees.remove(1);
    	    coordonnees.remove(0);
    	  
    	   }

    	   gc.drawImage(imageRelle, 0, 0);
           gc.setFill(Color.RED);
    	   gc.fillText("o", e.getSceneX(), e.getSceneY()-170);
    	   gc.setEffect(perspectivetransform);
    	   gc.drawImage(imageVirtuelle, 0, 0);
    	   gc.setEffect(null);
    	   
    	   v2.getChildren().add(10,canvas);
    	   
    	  }
    	 }
    
    public void handle(ActionEvent event) {
 		
			if(event.getTarget().equals(choixgarage)){
				File path;
			path = f.showOpenDialog(global);
			
			ImageView test =  new ImageView(path.toURI().toString());
				Image img = test.getImage();
				imageRelle = img;
			}
			
    }
    
    
 
    
    public Main(Stage stage){
    	start(stage);
    	Application.setUserAgentStylesheet(getClass().getResource("style.css").toExternalForm());
        valider.setId("xx");
        reset.setId("xx");
        add.setId("xx");
        add.setId("xx");
        choixgarage.setId("xx");
        choixporte.setId("xx");
        reset.setAlignment(Pos.CENTER);
        valider.setAlignment(Pos.CENTER);
        add.setAlignment(Pos.CENTER);
        
        
     
    }
    
    
    
	public void start(Stage stage) {
	
		global = stage;
	    gc = canvas.getGraphicsContext2D();
	    Image imageReelle = new Image("file:/Users/yazst/Documents/NetBeansProjects/Gangsta/src/ressources/imageReelle.png");
	    
	    
	 
	    canvas.setOnMouseClicked(e -> {
	    	switch(cpt) {
	    	case 0:
	    		ulx = e.getSceneX();
	    		uly = e.getSceneY()-195;
	    	case 1:
	    		urx = e.getSceneX();
	    		ury = e.getSceneY()-195;
	    	case 2:
	    		lrx = e.getSceneX();
	    		lry = e.getSceneY()-155;
	    	case 3:
	    		llx = e.getSceneX();
	    		lly = e.getSceneY()-155;
	    	}
	    	cpt++;
	    });
	    
	    add.setOnMouseClicked(e -> {
	    	add.addEventHandler(ActionEvent.ACTION, new clickButton());
	    	cpt = 0;
	    	ulx = 0;uly= 0;urx=0;ury=0;lrx=0;lry=0;llx=0;lly=0;
	    });
	    
	    choixgarage.setOnAction(e->{
			File path;
			path = f.showOpenDialog(global);
			
			ImageView test =  new ImageView(path.toURI().toString());
				Image img = test.getImage();
				imageRelle = img;
			    Image imagered = new Image(path.toURI().toString(),450,450,false,false);
			    gc.drawImage(imagered, 0, 0);
		
 
	    	
	    });
	    
	    canvas.setOnMouseClicked(new selectionPoints());
	
	    reset.setOnMouseClicked(e -> {
	    	gc.clearRect(0, 0, canvas.getWidth(), canvas.getWidth());
	    	gc.drawImage(imageReelle, 0, 0);
	    	cpt = 0;
	    	ulx = 0;uly= 0;urx=0;ury=0;lrx=0;lry=0;llx=0;lly=0;
	    });
	    
	    
	    
	    gc.drawImage(imageReelle, 0, 0);
	    gc.drawImage(imagered, 0, 0);
	   
	   
	    
	    HBox h3 = new HBox();
 		h3.setAlignment(Pos.CENTER_LEFT);
 		h3.getChildren().addAll(canvi,add, choixgarage);
 		h3.setSpacing(20);
 		Scene scenov = new Scene(h3);
 		stage.setTitle("vbox");
 		stage.setScene(scenov);
 		stage.setHeight(100);
 		stage.setWidth(100);
 		stage.show();
 		
 		HBox labs = new HBox();
 		labs.setAlignment(Pos.CENTER);
 		Label logo = new Label("Bienvenue dans Virtual Views");
                logo.setId("logo");
	    
	    
	    
	 		v2.setAlignment(Pos.BASELINE_CENTER);
	 		v2.getChildren().addAll(valider, reset);
	 		v2.setSpacing(20);
	 		root.setBackground(new Background(bg));
	 		Scene sceno = new Scene(v2);
	 		stage.setTitle("vbox");
	 		stage.setScene(sceno);
	 		stage.setHeight(200);
	 		stage.setWidth(200);
	 		stage.show();
	 		
	 		VBox xxx = new VBox();
	 		xxx.getChildren().addAll(canvu);
	 		xxx.setMaxSize(100, 100);
	 		
	 		VBox xx = new VBox();
	 		xx.getChildren().addAll(logo,canvu,canvas,canvo,v2);
	 		
	 		
	 		
	         
	    
	    root.getChildren().addAll(xx,h3);
		root.setSpacing(20);
		root.setBackground(new Background(bg));
	    Scene scene = new Scene(root);
	    stage.setTitle("Virtual View");
	    stage.setHeight(1000);
	    stage.setWidth(1000);
	    stage.setScene(scene);
	    stage.show();
	}
	
	
	public static void main(String[] args) {
	    Application.launch(args);
	}

	public static void run() {
		// TODO Auto-generated method stub
		
	}
}