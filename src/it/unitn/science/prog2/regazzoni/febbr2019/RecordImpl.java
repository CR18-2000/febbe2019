/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.science.prog2.regazzoni.febbr2019;

import java.util.Comparator;


public class RecordImpl implements Comparator {

    public int compare(Object o1, Object o2) {
        return ((Record) o1).field3 - ((Record) o2).field3;
    }
    
}
