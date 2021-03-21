/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sorting;

import java.util.Arrays; 

/**
 *
 * @author sabri
 */
public abstract class BaseSorter implements ISorter {
    long startDate;
    long endDate;
    int[] array;
    
    public BaseSorter(int[] array){
        //diziyi kopyaladım
        this.array = Arrays.copyOf(array, array.length);
    }
    
    public void sureYazdir() {
        long dateDiff = endDate - startDate;
        System.out.println(this.getClass().toString() + " için çalışma süresi(nanosecond): " + dateDiff);
    }
    public void diziYazdır(){
        System.out.println(this.getClass().toString() + " sıralaması" );
        for (int i : array) {
            System.out.println(i);            
        }
    }
}
