/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders_app;

import java.util.LinkedList;
import java.util.ListIterator;
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
public class ShootPlayer extends Canvas{
    protected int w,h,x,y;
    protected Group root;
    protected Stage stage;
    protected Timeline timeline;
    protected GraphicsContext gc;
    protected Player numb1;
    protected Invader inv;
    protected LinkedList zoznam;
    
    public ShootPlayer(int w, int h, int x, int y, Group root, Stage stage, LinkedList zoznam) {
        super(w,h);
        //x,y suradnice od invadera
        this.w = w;
        this.h = h;
        this.x = x;
        this.y = y;
        this.root = root;
        this.stage = stage;
        //this.inv = inv;
        this.zoznam = zoznam;
        
        setLayoutX(x);
        setLayoutY(y);
        gc = this.getGraphicsContext2D();
        vykresli();
        timeline = new Timeline(new KeyFrame(Duration.millis(50),e->pohyb()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
    
   
    protected void pohyb(){
        setLayoutY(getLayoutY()-10);
        if (getLayoutY()<=0) {
            timeline.stop();
            root.getChildren().remove(this);
            //System.out.println("vonku");
        }
        if (naraz()) {
            koniec();
            //inv.koniec();
            //System.out.println("naraz");
        }
        if (zoznam.size()==0) {
            koniec();
        } 
    }
    
    private void vykresli() {
        gc.setFill(Color.WHITE);
        gc.fillRect(0,0,w,h);
    }
    
    protected boolean naraz (){
        boolean vysledok = false;
        
        for (int i=0; i<zoznam.size(); i++){
            //System.out.println(zoznam.get(i).toString());
            inv = (Invader) zoznam.get(i);
            if(getLayoutY()>=inv.getLayoutY() && getLayoutY()<=inv.getLayoutY()+inv.getHeight()) {
                if(getLayoutX()>=inv.getLayoutX() && getLayoutX()<=inv.getLayoutX()+inv.getWidth()) {
             
                    vysledok = true;
                    inv.koniec();
                    inv.skore = inv.getSkore() + 1;
                    inv.aktualizuj_skore();
                    //System.out.println("naraz");
                }
            }
        }
        return vysledok;
    }
    
    protected void koniec(){
        timeline.stop();
        root.getChildren().remove(this);
        gc.clearRect(0,0,w,h);
    }
    
}
