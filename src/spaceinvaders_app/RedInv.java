/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders_app;

import java.util.LinkedList;
import javafx.scene.Group;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Mimi
 */
public class RedInv extends Invader{
    
    
    
    public RedInv(int w, int h, Group root, Stage stage, LinkedList zoznam, Player numb1, TextField text) {
        super(w, h, root, stage, zoznam, numb1, text);
        color = Color.RED;
        vykresli(color);
    }
    
    @Override
   protected void vykresli(Color color){
       gc.setFill(color);
       gc.fillRect(16, 0, 12, 4);
       gc.fillRect(4,4,36,4);
       gc.fillRect(0,8,w,4);
       gc.fillRect(0,12,12,4);
       gc.fillRect(20,12,4,4);
       gc.fillRect(32,12,12,4);
       gc.fillRect(0,16,w,4);
       gc.fillRect(8,20,12,4);
       gc.fillRect(24,20,12,4);
       gc.fillRect(24,4,8,4);
       gc.fillRect(4,24,8,4);
       gc.fillRect(20,24,4,4);
       gc.fillRect(32,24,8,4);
       gc.fillRect(8,28,8,4);
       gc.fillRect(28,28,8,4);
       
   }
}
