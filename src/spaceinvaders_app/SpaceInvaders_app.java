/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders_app;

import java.io.File;
import java.util.LinkedList;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Mimi
 */
public class SpaceInvaders_app extends Application {
    private static final int startTime =0;
    private Timeline timeline2;
    private int timeSeconds = startTime;
    private Label timerLabel = new Label("0");
    protected int zaznamSkore;
    
    
    
    @Override
    public void start(Stage primaryStage) {
        LinkedList<Node> zoznam = new LinkedList();
        Group root = new Group();
        TextField text = new TextField();
        text.setEditable(false);
        text.setFocusTraversable(false);
        text.setText("0");
        
        Scene scene = new Scene(root, 900, 680);
        primaryStage.setResizable(false);
        
        primaryStage.setTitle("Space Invaders"); 
        Label vysledok = new Label();
        Label inDev = new Label("IN DEV");
        Button btn = new Button();
        
        
        Button restart = new Button("restart");
        restart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                timeline2.stop();
                root.getChildren().clear();
                zoznam.clear();
                text.setText("0");
                root.getChildren().addAll(text,btn);
                
            }
        });
        
        
        Button lvl2 = new Button("Next LVL");
        lvl2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                /*Rectangle rect1 = new Rectangle(0, 0, primaryStage.getWidth(), primaryStage.getHeight());
                rect1.setFill(Color.BLACK);
                root.getChildren().clear();
                inDev.setStyle("-fx-font-size: 4em;");
                root.getChildren().addAll(rect1, inDev);*/
                
                root.getChildren().clear();
                zoznam.clear();
                root.getChildren().remove(btn);
                root.getChildren().add(text);
                Invader in = null;
                Player hrac = new Player(44, 32, root, primaryStage, zoznam,in);
                //zoznam.add(hrac);
                for (int i = 1; i<=9; i++) {
                    in = new Invader(44, 32, root, primaryStage, zoznam,hrac,text);
                    zoznam.add(in);
                    in.setLayoutX((i*84));
                    root.getChildren().add(in);
                }
                
                for (int i = 1; i<=9; i++) {
                    in = new RedInv(44, 32, root, primaryStage, zoznam,hrac,text);
                    zoznam.add(in);
                    in.setLayoutX((i*84));
                    in.setLayoutY(in.h*2);
                    root.getChildren().add(in);
                }
                
                for (int i = 1; i<=9; i++) {
                    in = new GreenInv(44, 32, root, primaryStage, zoznam,hrac,text);
                    zoznam.add(in);
                    in.setLayoutX((i*84));
                    in.setLayoutY(in.h*3 + 32);
                    root.getChildren().add(in);
                }
                
                for (int i = 1; i<=9; i++) {
                    in = new OrangeInv(44, 32, root, primaryStage, zoznam,hrac,text);
                    zoznam.add(in);
                    in.setLayoutX((i*84));
                    in.setLayoutY(in.h*4 + 32*2);
                    root.getChildren().add(in);
                }
                
                root.getChildren().add(hrac);
                
             
                timeSeconds = startTime;
                timeline2 = new Timeline();
                timeline2 = new Timeline(new KeyFrame(Duration.seconds(1), (ActionEvent event2)-> {
                    timeSeconds++;
                    timerLabel.setText(Integer.toString(timeSeconds));
                    //System.out.println(zoznam.size());
                    if (zoznam.size()<=0 && root.getChildren().contains(hrac)) {
                        timeline2.stop();
                        Rectangle rect1 = new Rectangle(0, 0, primaryStage.getWidth(), 1);
                        rect1.setFill(Color.BLACK);
                        ScaleTransition rect1T = new ScaleTransition(Duration.seconds(1), rect1);
                        rect1T.setToY(primaryStage.getHeight()*2);
                        rect1T.setCycleCount(1);
                        rect1T.play();
                        zaznamSkore = Integer.parseInt(text.getText());
                        vysledok.setText("LVL COMPLETED"+ "\nScore: "+zaznamSkore+"");
                                               
                        root.getChildren().add(rect1);
                        root.getChildren().add(vysledok);
                        vysledok.setTextFill(Color.WHITE);
                        
                        vysledok.setStyle("-fx-font-size: 4em;");
                        root.getChildren().add(lvl2);
                        lvl2.setLayoutX(450);
                        lvl2.setLayoutY(300);
                        lvl2.setScaleX(5);
                        lvl2.setScaleY(5);
                    }
                    
                    
                    if (!root.getChildren().contains(hrac)) {
                        timeline2.stop();
                        zoznam.clear();
                        root.getChildren().clear();
                        
                        //System.out.println(zoznam);
                      
                        Rectangle rect1 = new Rectangle(0, 0, primaryStage.getWidth(), 1);
                        rect1.setFill(Color.BLACK);
                        ScaleTransition rect1T = new ScaleTransition(Duration.seconds(1), rect1);
                        rect1T.setToY(primaryStage.getHeight()*2);
                        rect1T.setCycleCount(1);
                        rect1T.play();
                        zaznamSkore = Integer.parseInt(text.getText());
                        vysledok.setText("GAME OVER"+ "\nScore: "+zaznamSkore+"");
                        
                        root.getChildren().add(rect1);
                        root.getChildren().add(vysledok);
                        vysledok.setTextFill(Color.WHITE);
                        
                        vysledok.setStyle("-fx-font-size: 4em;");
                        root.getChildren().add(restart);
                        restart.setLayoutX(450);
                        restart.setLayoutY(300);
                        restart.setScaleX(5);
                        restart.setScaleY(5);
                    }
                }));
                timeline2.setCycleCount(Animation.INDEFINITE);
                timeline2.play();
            }
        });
        
        
        
        
                
        btn.setText("Start");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                root.getChildren().clear();
                zoznam.clear();
                root.getChildren().remove(btn);
                root.getChildren().add(text);
                
                Invader in = null;
                Player hrac = new Player(44, 32, root, primaryStage, zoznam,in);
                //zoznam.add(hrac);
                for (int i = 1; i<=9; i++) {
                    in = new Invader(44, 32, root, primaryStage, zoznam,hrac,text);
                    zoznam.add(in);
                    in.setLayoutX((i*84));
                    root.getChildren().add(in);
                }
                
                for (int i = 1; i<=9; i++) {
                    in = new RedInv(44, 32, root, primaryStage, zoznam,hrac,text);
                    zoznam.add(in);
                    in.setLayoutX((i*84));
                    in.setLayoutY(in.h*2);
                    root.getChildren().add(in);
                }
                
              /*  for (int i = 1; i<=9; i++) {
                    in = new GreenInv(44, 32, root, primaryStage, zoznam,hrac,text);
                    zoznam.add(in);
                    in.setLayoutX((i*84));
                    in.setLayoutY(in.h*3 + 32);
                    root.getChildren().add(in);
                }
                
                for (int i = 1; i<=9; i++) {
                    in = new OrangeInv(44, 32, root, primaryStage, zoznam,hrac,text);
                    zoznam.add(in);
                    in.setLayoutX((i*84));
                    in.setLayoutY(in.h*4 + 32*2);
                    root.getChildren().add(in);
                }*/
                
                root.getChildren().add(hrac);
                
             
                timeSeconds = startTime;
                timeline2 = new Timeline();
                timeline2 = new Timeline(new KeyFrame(Duration.seconds(1), (ActionEvent event2)-> {
                    timeSeconds++;
                    timerLabel.setText(Integer.toString(timeSeconds));
                    //System.out.println(zoznam.size());
                    if (zoznam.size()<=0 && root.getChildren().contains(hrac)) {
                        timeline2.stop();
                        Rectangle rect1 = new Rectangle(0, 0, primaryStage.getWidth(), 1);
                        rect1.setFill(Color.BLACK);
                        ScaleTransition rect1T = new ScaleTransition(Duration.seconds(1), rect1);
                        rect1T.setToY(primaryStage.getHeight()*2);
                        rect1T.setCycleCount(1);
                        rect1T.play();
                        zaznamSkore = Integer.parseInt(text.getText());
                        vysledok.setText("LVL COMPLETED"+ "\nScore: "+zaznamSkore+"");
                                               
                        root.getChildren().add(rect1);
                        root.getChildren().add(vysledok);
                        vysledok.setTextFill(Color.WHITE);
                        
                        vysledok.setStyle("-fx-font-size: 4em;");
                        root.getChildren().add(lvl2);
                        lvl2.setLayoutX(450);
                        lvl2.setLayoutY(300);
                        lvl2.setScaleX(5);
                        lvl2.setScaleY(5);
                    }
                    
                    
                    if (!root.getChildren().contains(hrac)) {
                        timeline2.stop();
                        zoznam.clear();
                        root.getChildren().clear();
                        
                        //System.out.println(zoznam);
                      
                        Rectangle rect1 = new Rectangle(0, 0, primaryStage.getWidth(), 1);
                        rect1.setFill(Color.BLACK);
                        ScaleTransition rect1T = new ScaleTransition(Duration.seconds(1), rect1);
                        rect1T.setToY(primaryStage.getHeight()*2);
                        rect1T.setCycleCount(1);
                        rect1T.play();
                        zaznamSkore = Integer.parseInt(text.getText());
                        vysledok.setText("GAME OVER"+ "\nScore: "+zaznamSkore+"");
                        
                        root.getChildren().add(rect1);
                        root.getChildren().add(vysledok);
                        vysledok.setTextFill(Color.WHITE);
                        
                        vysledok.setStyle("-fx-font-size: 4em;");
                        root.getChildren().add(restart);
                        restart.setLayoutX(450);
                        restart.setLayoutY(300);
                        restart.setScaleX(5);
                        restart.setScaleY(5);
                    }
                }));
                timeline2.setCycleCount(Animation.INDEFINITE);
                timeline2.play();
                }
        });
        
        btn.setLayoutX(100);
        btn.setLayoutY(100);
        btn.setScaleX(5);
        btn.setScaleY(5);
        root.getChildren().addAll(text, btn);
        text.setAlignment(Pos.CENTER);
        text.setLayoutX(0);
        text.setLayoutY(scene.getHeight()-20);
        text.setMaxWidth(50);
        
        scene.setFill(Color.BLACK);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
