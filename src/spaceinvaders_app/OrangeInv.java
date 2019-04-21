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
public class OrangeInv extends Invader{
    
    public OrangeInv(int w, int h, Group root, Stage stage, LinkedList zoznam, Player numb1, TextField text) {
        super(w, h, root, stage, zoznam, numb1, text);
        color = Color.ORANGE;
        vykresli(color);
    }
    
    @Override
   protected void vykresli (Color color){
      gc.setFill(color);
      gc.fillRect(0,16,4,4);
      gc.fillRect(0,24,4,4);
      gc.fillRect(12,4,20,4);
      gc.fillRect(8,8,28,4);
      gc.fillRect(4,12,8,4);
      gc.fillRect(20,12,4,4);
      gc.fillRect(32,12,8,4);
      gc.fillRect(0,16,w,4);
      gc.fillRect(0,20,w,4);
      gc.fillRect(0,24,4,8);
      gc.fillRect(8,24,4,8);
      gc.fillRect(16,24,4,8);
      gc.fillRect(24,24,4,8);
      gc.fillRect(32,24,4,8);
      gc.fillRect(40,24,4,8);
   }
}
