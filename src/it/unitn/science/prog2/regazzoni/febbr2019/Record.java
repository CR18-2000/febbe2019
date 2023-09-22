/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.science.prog2.regazzoni.febbr2019;

import java.util.Comparator;
import java.util.Objects;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 *
 * @author crist
 */
public abstract class Record extends VBox implements Comparable {
    
    String field1;
    String field2;
    Integer field3;
    VBox lista;
    StackPane sp; Rectangle rect;
    Button aggiungi; Button conta; Button mescola; Button ordina; Button ordinaPerF3;
    
    Record (Pos posizione) {
        sp = new StackPane();
        rect = new Rectangle (150, 100);
        rect.setStroke(Color.BLACK);
        rect.setFill(Color.BLANCHEDALMOND);
        lista = new VBox();
        sp.getChildren().addAll(rect, lista);
        aggiungi = new Button ();
        EventHandler<ActionEvent> eventHandlerAdd = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                aggiungi();
            }
        };
        aggiungi.addEventHandler(ActionEvent.ACTION, eventHandlerAdd);
        conta = new Button ("Conta");
        EventHandler<ActionEvent> eventHandlerSize = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                conta();
            }
        };
        conta.addEventHandler(ActionEvent.ACTION, eventHandlerSize);
        mescola = new Button ("Mescola");
        EventHandler<ActionEvent> eventHandlerShuffle = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mescola();
            }
        };
        mescola.addEventHandler(ActionEvent.ACTION, eventHandlerShuffle);
        ordina = new Button ("Ordina");
        EventHandler<ActionEvent> eventHandlerSort = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ordina();
            }
        };
        ordina.addEventHandler(ActionEvent.ACTION, eventHandlerSort);
        ordinaPerF3 = new Button ();
        EventHandler<ActionEvent> eventHandlerF3 = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ordinaPerF3();
            }
        };
        ordinaPerF3.addEventHandler(ActionEvent.ACTION, eventHandlerF3);
        this.getChildren().addAll(sp, aggiungi, conta, mescola, ordina, ordinaPerF3);
        this.setAlignment(posizione);
    }
    
    Record(String field1, String field2, Integer field3) {
        this.field1=field1;
        this.field2=field2;
        this.field3=field3;
    }
    
    public abstract void ordinaPerF3 ();
    
    public abstract void ordina ();
    
    public abstract void add (String f1, String f2, Integer f3);
    
    public abstract void mescola();
    
    public abstract int conta ();
    
    public abstract void update ();
    
    public abstract void aggiungi ();
    
    @Override
    public String toString () {
        return (field1 + "  " + field2 + "  " + field3);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.field1);
        hash = 19 * hash + Objects.hashCode(this.field2);
        hash = 19 * hash + Objects.hashCode(this.field3);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Record other = (Record) obj;
        if (!Objects.equals(this.field1, other.field1)) {
            return false;
        }
        if (!Objects.equals(this.field2, other.field2)) {
            return false;
        }
        if (!Objects.equals(this.field3, other.field3)) {
            return false;
        }
        return true;
    }
    
    /**
     * ordina le persone per congnome e le auto per modello
     * @param o
     * @return 
     */
    
    public int compareTo (Object o) {
        if (this.equals(o)) return 0;
        final Record other = (Record) o;
        return (this.field2.compareTo(other.field2));
    }
    
    /**
     * ordina le persone per anno di nascita e le auto per prezzo
     * @param o
     * @return 
     */
    
    /*public int compareToInt (Object o1) {
        if (this.equals(o)) return 0;
        final Record other = (Record) o;
        return (this.field3.compareTo(other.field3));
    }*/
    
}
