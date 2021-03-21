/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sorting;

/**
 *
 * @author sabri
 */
public class InsertionSorter extends BaseSorter{

    public InsertionSorter(int[] array) {
        super(array);
    }
    private void InsertionSort() 
    { 
        for (int i = 1; i < array.length; ++i) { 
            int key = array[i]; 
            int j = i - 1;             
            while (j >= 0 && array[j] > key) { 
                array[j + 1] = array[j]; 
                j = j - 1; 
            } 
            array[j + 1] = key; 
        } 
    } 
    @Override
    public void sort() {
        startDate = System.nanoTime();
        InsertionSort();
        endDate = System.nanoTime();

    }
    
}
