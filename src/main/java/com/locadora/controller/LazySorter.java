package com.locadora.controller;

import java.util.Comparator;

import org.primefaces.model.SortOrder;

import com.locadora.model.Veiculo;
 
public class LazySorter implements Comparator<Veiculo> {
 
    private String sortField;
     
    private SortOrder sortOrder;
     
    public LazySorter(String sortField, SortOrder sortOrder) {
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }
 
    public int compare(Veiculo v1, Veiculo v2) {
        try {
            Object value1 = Veiculo.class.getField(this.sortField).get(v1);
            Object value2 = Veiculo.class.getField(this.sortField).get(v2);
 
			int value = ((Comparable)value1).compareTo(value2);
             
            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
        } catch(Exception e) {
            throw new RuntimeException();
        }
    }
}