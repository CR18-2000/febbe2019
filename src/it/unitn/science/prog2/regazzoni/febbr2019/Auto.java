/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.science.prog2.regazzoni.febbr2019;

import java.util.ArrayList;
import java.util.Collections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author crist
 */
public class Auto extends Record {
    
    ArrayList<Auto> list = new ArrayList<>();
    Stage stage;
    
    Auto () {
        super(Pos.TOP_LEFT);
        lista = stampa();
        aggiungi.setText("Nuova auto");
        ordinaPerF3.setText("Ordina per prezzo");
    }
    
    Auto (String marca, String modello, Integer prezzo) {
        super(marca, modello, prezzo);
    }

    @Override
    public void ordinaPerF3() {
        Collections.sort(list, new RecordImpl());
        update();
    }

    @Override
    public void ordina() {
        Collections.sort(list);
        update();
    }

    @Override
    public void add(String f1, String f2, Integer f3) {
        list.add(new Auto (f1, f2, f3));
    }
    
    @Override
    public void mescola () {
        Collections.shuffle(list);
        update();
    }

    @Override
    public int conta() {
        System.out.println(list.size() + " auto");
        return list.size();
    }
    
    final public VBox stampa () {
        VBox vb = new VBox ();
        Text t;
        System.out.println("LISTA DI AUTO");
        for (Auto a : list) {
            t = new Text ();
            t.setText(a.toString());
            System.out.println(a.toString());
            vb.getChildren().add(t);
        }
        return vb;
    }

    @Override
    public void update() {
        lista.getChildren().clear();
        lista = stampa();
        sp.getChildren().addAll(lista);
        this.getChildren().clear();
        this.getChildren().addAll(sp, aggiungi, conta, mescola, ordina, ordinaPerF3);
    }

    @Override
    public void aggiungi() {
        GridPane tab = new GridPane ();
        Label text1 = new Label ("Marca:    ");
        tab.add(text1, 0, 0);
        TextField tf1 = new TextField ();
        tab.add(tf1, 1, 0);
        //String marca = tf1.getText();
        Label text2 = new Label ("Modello:  ");
        tab.add(text2, 0, 1);
        TextField tf2 = new TextField ();
        tab.add(tf2, 1, 1);
        //String modello = tf2.getText();
        Label text3 = new Label ("Prezzo:   ");
        tab.add(text3, 0, 2);
        TextField tf3 = new TextField ();
        tab.add(tf3, 1, 2);
        //String pr = tf3.getText();
        Button control = new Button ("Controlla e inserisci");
        EventHandler<ActionEvent> eventHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String marca = tf1.getText();
                String modello = tf2.getText();
                String pr = tf3.getText();
               boolean ok = controlla (marca, modello, pr);
               if (ok) {
                   Integer prezzo;
                   prezzo = Integer.parseInt(pr);
                   add(marca, modello, prezzo);
                   update();
                   stage.close();
               }
               else System.out.println("Inserimento fallito");
            }
        };
        control.addEventHandler(ActionEvent.ACTION, eventHandler);
        tab.add(control, 0, 4);
        Scene scene = new Scene (tab, 200, 300);
        stage = new Stage ();
        stage.setScene(scene);
        stage.show();
    }
    
    private boolean controlla (String a, String b, String c) {
        if (a.isEmpty()||b.isEmpty()||c.isEmpty()) {
            System.out.println("Campi vuoti");
            return false;
        }
        boolean nonInt = false;
        Integer i = 0;
        try {i = Integer.parseInt(c);} catch (NumberFormatException e) {nonInt=true;}
        if (nonInt) {
            System.out.println("Non int");
            return false;
        }
        for (Auto auto : list) {
            if (auto.equals(new Auto (a, b, i))) return false;
            System.out.println("Uguali");
        }
        return true;
    }
    
}
