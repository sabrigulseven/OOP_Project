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
public class BubbleSorter extends BaseSorter{
    
    public BubbleSorter(int[] array){
        super(array);
    }
    
    private void bubbleSort(){
        for (int i = 0; i < array.length - 1; i++)
        {
            boolean sıralı = true;
            for (int j = 0; j < array.length - 1; j++)
            {
                if (array[j] >array[j+1])
                {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    sıralı = false;
                }
            }
            if (sıralı) //eğer liste sıralandığında çıkış yapmasaydık time complexity sürekli worst case O(n^2) olacaktı
                break;
        }
    }

    @Override
    public void sort() {
        startDate = System.nanoTime();
        bubbleSort();
        endDate = System.nanoTime();
    }    
}
