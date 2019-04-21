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
public class GreenInv extends Invader{
    
    public GreenInv(int w, int h, Group root, Stage stage, LinkedList zoznam, Player numb1, TextField text) {
        super(w, h, root, stage, zoznam, numb1, text);
        color = Color.GREEN;
        vykresli(color);
    }
    
    @Override
    protected void vykresli(Color color){
        gc.setFill(color);
        gc.fillRect(16,0,8,4);
        gc.fillRect(12,4,16,4);
        gc.fillRect(8,8,24,4);
        gc.fillRect(4,12,8,4);
        gc.fillRect(16,12,8,4);
        gc.fillRect(28,12,8,4);
        gc.fillRect(4,16,32,4);
        gc.fillRect(12,20,4,4);
        gc.fillRect(24,20,4,4);
        gc.fillRect(8,24,4,4);
        gc.fillRect(16,24,8,4);
        gc.fillRect(28,24,4,4);
        gc.fillRect(0,28,8,4);
        gc.fillRect(12,28,4,4);
        gc.fillRect(24,28,4,4);
        gc.fillRect(32,28,8,4);
        
        
        
    }
    
}
