package com.mycompany.birdpictures;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {
    //Web images, so it will run on your pc
    Image img1 = new Image("https://abcbirds.org/wp-content/uploads/2021/07/Blue-Jay-on-redbud-tree-by-Tom-Reichner_news.png");
    Image img2 = new Image("https://ichef.bbci.co.uk/news/976/cpsprodpb/67CF/production/_108857562_mediaitem108857561.jpg");
    
    //creates buttons, lables, and counter parts
    ImageView viewer = new ImageView();
    Button btn1 = new Button ("Bule Jay");
    Button btn2 = new Button ("Bird");
    Button btn3 = new Button ("!Rotate!");
    int i=0;
    int r=45;
    Label count = new Label ("Birds Seen: ");
         
    @Override
    public void start(Stage stage) {  
        
        //Background
        Rectangle background = new Rectangle(0,0,800,800);
        background.setFill(Color.BEIGE);
        
        //setting button size
        btn1.setMaxSize(200,50);
        btn2.setMaxSize(200,50);
        btn3.setMaxSize(70,20);
        
        //each button gets moved 
        btn1.setTranslateX(-200);     
        btn1.setTranslateY(200);
        
        btn2.setTranslateX(200);
        btn2.setTranslateY(200);
        
        btn3.setTranslateX(-280);
        btn3.setTranslateY(-220);
        
        //picture size
        viewer.setFitHeight(300);
        viewer.setFitWidth(300);
        
        //counter location
        count.setTranslateX(0);
        count.setTranslateY(200);
        
        //Links the button click to setOnAction
        btn1.setOnAction(this::swapPNG);
        btn2.setOnAction(this::swapPNG);
        btn3.setOnAction(this::swapPNG);
        
        
        StackPane pane = new StackPane(background,viewer,btn1,btn2,btn3,count);
        var scene = new Scene(pane, 640, 480);
        stage.setScene(scene);
        stage.show();
    }
       public void swapPNG(ActionEvent event){
           //When Blue Jay button is clicked
            if (event.getSource() == btn1){
                i=i+1;
                viewer.setImage(img1); //show img1
                count.setText("Birds Seen: "+i);
            }
               
            if(event.getSource() == btn2){
                i++;
                viewer.setImage(img2);//show img2
                count.setText("Bird Seen: "+i);
            }
            if(event.getSource() == btn3){
                if(r==360)//Prevents r from getting too high
                    r=0;
                viewer.setRotate(r);//rotate the view
                r=r+45;
            }
       }
    public static void main(String[] args) {
        launch();
    }

}