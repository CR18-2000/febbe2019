/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.science.prog2.regazzoni.febbr2019;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author crist
 */
public class Febbr2019 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Record auto = new Auto ();
        Record persona = new Persona ();
        GridPane root = new GridPane();
        root.add(auto, 1, 0);
        root.add(persona, 0, 0);
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
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
