package com.example.myjavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class StoneStory extends Application {

    public static void main(String[] args){
        launch(args);
    }


    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("StoneStory.fxml"));


        Image icon = new Image("com/example/myjavafx/StoneStoryLogo.png");
        stage.getIcons().add(icon);

        stage.setTitle("Stone Story Avg Dmg Calc");
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.show();

    }
}
