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
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Mimi
 */
public class ShootInvader extends Canvas{
    protected int w,h,x,y,a=0;
    protected Group root;
    protected Stage stage;
    protected Timeline timeline;
    protected GraphicsContext gc;
    protected Player numb1;
    protected LinkedList zoznam;
    protected Color color;

    public ShootInvader(int w, int h, int x, int y, Group root, Stage stage, Player numb1, LinkedList zoznam, Color color) {
        super(w,h);
        //x,y suradnice od invadera
        this.w = w;
        this.h = h;
        this.x = x;
        this.y = y;
        this.root = root;
        this.stage = stage;
        this.numb1 = numb1;
        this.zoznam=zoznam;
        this.color = color;
        setLayoutX(x);
        setLayoutY(y);
        gc = this.getGraphicsContext2D();
        vykresli(color);
        timeline = new Timeline(new KeyFrame(Duration.millis(150),e->pohyb()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        //System.out.println(a++);
        //
    }

    private void vykresli(Color color) {
        gc.setFill(color);
        gc.fillRect(0,0,w,h);
    }
    
    protected void pohyb(){
        setLayoutY(getLayoutY()+5);
        //System.out.println(numb1.getLayoutX());
        if (getLayoutY()>=stage.getHeight()) {
            timeline.stop();
            root.getChildren().remove(this);
        }
        if (naraz()) {
            timeline.stop();
            //System.out.println("aaa");
            koniec();
            numb1.koniec();
        }
      }
    
    protected boolean naraz (){
        boolean vysledok = false;
        //System.out.println(numb1.getLayoutX());
        if(getLayoutY()>=numb1.getLayoutY() && getLayoutY()<=numb1.getLayoutY()+numb1.getHeight()) {
            if(getLayoutX()>=numb1.getLayoutX() && getLayoutX()<=numb1.getLayoutX()+numb1.getWidth()) {
                vysledok = true;
                //System.out.println("naraz");
            }
        }
        return vysledok;
    }
    
    protected void koniec(){
        timeline.stop();
        gc.clearRect(0,0,w,h);
        root.getChildren().remove(this);
        setDisable(true);
    }
    
}
