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
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Mimi
 */
public class Invader extends Canvas{
    
    protected int w,h, skore;
    protected Group root;
    protected Stage stage;
    protected LinkedList zoznam;
    protected Timeline timeline;
    protected GraphicsContext gc;
    protected int pohybI = 0;
    protected int smerP = 1;
    protected Player numb1;
    TextField text;
    Color color;

    public Invader(int w, int h, Group root, Stage stage, LinkedList zoznam, Player numb1, TextField text) {
        super (w,h);
        this.w = w;
        this.h = h;
        this.root = root;
        this.stage = stage;
        this.zoznam = zoznam;
        this.numb1 = numb1;
        this.text = text;
        color = Color.BLUE;
        setNumb1(numb1);
        gc = this.getGraphicsContext2D();
        vykresli(color);
        timeline = new Timeline(new KeyFrame(Duration.millis(50), e-> pohyb()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        
        skore = getSkore();
        //System.out.println("invader");
        setOnMouseClicked(e -> vypis(e));
    }
    
    protected void vypis(MouseEvent e) {
        if (e.getButton()==MouseButton.PRIMARY) System.out.println(getLayoutX() + " " + getLayoutY());
    }

    protected void vykresli(Color color) {
        gc.setFill(color);
        gc.fillRect(8,0,4,4);
        gc.fillRect(32,0,4,4);
        gc.fillRect(12,4,4,4);
        gc.fillRect(28,4,4,4);
        gc.fillRect(8,8,28,4);
        gc.fillRect(4,12,8,4);
        gc.fillRect(16,12,12,4);
        gc.fillRect(32,12,8,4);
        gc.fillRect(0,16,w,4);
        gc.fillRect(0,20,4,8);
        gc.fillRect(8,20,28,4);
        gc.fillRect(40,20,4,8);
        gc.fillRect(8,24,4,4);
        gc.fillRect(32,24,4,4);
        gc.fillRect(12,28,8,4);
        gc.fillRect(24,28,8,4);
    }

    protected void pohyb() {
        
        setLayoutX(getLayoutX()+1*smerP);
        pohybI++;
        int x = (int)(Math.random()*100);
        if (pohybI>= 50) {
            setLayoutY(getLayoutY()+h+5);
            smerP*=-1;
            pohybI = 0;
        }
        if ((x)>98) {
            ShootInvader strela = new ShootInvader(8, 8, (int)getLayoutX()+22, (int)getLayoutY()+32, root, stage, numb1,zoznam,color);
            if (zoznam.size()==0) {
                strela.timeline.stop();
                root.getChildren().remove(strela);
            }
            else if(!root.getChildren().contains(numb1)){
                strela.timeline.stop();
                root.getChildren().remove(strela);
            }
            else {
             root.getChildren().add(strela);
            }
        }
        
        if (getLayoutY()>=(stage.getHeight()-numb1.h*2)) {
            root.getChildren().remove(numb1);
                    
        }
        //System.out.println(x);
    }
    
    protected void koniec(){
        timeline.stop();
        gc.clearRect(0,0,w,h);
        root.getChildren().remove(this);
        setDisable(true);
        zoznam.remove(this);
    }

    public void setNumb1(Player numb1) {
        this.numb1 = numb1;
    }

    public Player getNumb1() {
        return numb1;
    }

    
    protected void aktualizuj_skore() {
        text.setText(Integer.toString(skore));
    }
    
    protected int getSkore(){
        return Integer.parseInt(text.getText());
    }
    
}
