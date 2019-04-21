/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders_app;

import java.util.LinkedList;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Mimi
 */
public class Player extends Canvas{
    protected int w,h, skore;
    protected Group root;
    protected Stage stage;
    protected LinkedList zoznam;
    protected Timeline timeline;
    protected GraphicsContext gc;
    protected int pohybI = 0;
    protected int smerP = 1;
    protected ShootPlayer shootP;
    protected Invader inv;
    TextField text;
    
    public Player(int w, int h, Group root, Stage stage, LinkedList zoznam, Invader inv) {
        super (w,h);
        this.w = w;
        this.h = h;
        this.root = root;
        this.stage = stage;
        this.zoznam = zoznam;
        this.inv = inv;
        gc = this.getGraphicsContext2D();
        vykresli();
        
        setLayoutX(stage.getWidth()/2);
        setLayoutY(stage.getHeight()-h-20);
        
        setFocusTraversable(true);
        requestFocus();
        setFocusTraversable(true);
        setOnKeyPressed(f -> pohyb(f));
    }
    
   
    protected void vykresli(){
        gc.setFill(Color.WHITE);
        gc.fillRect(0,0,44,32);
    }
    
  
    protected void pohyb(KeyEvent f){
        KeyCode key = f.getCode();
        if (key==KeyCode.A || key==KeyCode.LEFT) {
            if (getLayoutX()<=80) {
                setLayoutX(getLayoutX());
            }
            else setLayoutX(getLayoutX()-10);
        }
        
        if (key==KeyCode.D || key==KeyCode.RIGHT) {
            if (getLayoutX()>=stage.getWidth()-w-40) {
                setLayoutX(getLayoutX());
            }
            else setLayoutX(getLayoutX()+10);
        }
        
        if (key==KeyCode.SPACE) {
            ShootPlayer sh = new ShootPlayer(8, 8, (int)getLayoutX()+22, (int)getLayoutY(), root, stage,zoznam); //new ShootPlayer(8, 8, (int)getLayoutX()+22, (int)getLayoutY(), root, stage,inv)
            root.getChildren().add(sh);
        }      
    }

    public void setInv(Invader inv) {
        this.inv = inv;
    }

    
    protected void koniec(){
        gc.clearRect(0,0,w,h);
        root.getChildren().remove(this);
        setDisable(true);
    }
    
    
    
}
