/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sorting;

import java.util.Random;

/**
 *
 * @author sabri
 */
public class main {
    //algoritmaların çalışma sürelerini test etmek için arrayLength değerini değiştirebilirsiniz
    static int arrayLength = 10;
    static int array[] = new int[arrayLength];
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        fillArrayRandomly();

        BaseSorter sorters[] = new BaseSorter[3];
        
        BubbleSorter bubbleSorter = new BubbleSorter(array);
        sorters[0] = bubbleSorter;
        
        QuickSorter quickSorter = new QuickSorter(array);
        sorters[1] = quickSorter;
        
        InsertionSorter insertionSorter = new  InsertionSorter(array);
        sorters[2] = insertionSorter;
        
        //dizileri sıralar ve çalışma sürelerini hesaplar
        for(BaseSorter sorter : sorters){
            sorter.sort();
            sorter.sureYazdir();
        }
        
        //sıralanmış dizileri yazdırır
        for (BaseSorter sorter : sorters) {
            sorter.diziYazdır();
        }
    }
    
    public static void fillArrayRandomly(){
        Random random = new Random();
        for (int i = 0; i < arrayLength; i++) {
            array[i] = random.nextInt();
        }
    }
}
