package ihm;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import java.io.File;

public class Video extends Application {
	
	 
	


    @Override
    public void start(Stage primaryStage) throws Exception{
        AnchorPane anchorPane = new AnchorPane();
        MediaView mediaview = new MediaView();
        anchorPane.getChildren().addAll(mediaview);
        primaryStage.setTitle("Mode Demo");
        primaryStage.setScene(new Scene(anchorPane, 1000, 1000));
        primaryStage.show();

        File file=new File("./ressources/test.mp4");
        Media media=new Media(file.toURI().toString());
        MediaPlayer mediaplayer = new MediaPlayer(media);
        mediaview.setMediaPlayer(mediaplayer);
        mediaplayer.play();
    }



    public static void main(String[] args) {
        launch(args);
    }


}