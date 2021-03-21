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
public class QuickSorter extends BaseSorter{

    public QuickSorter(int[] array) {
        super(array);
    }
    private int Partition( int low,int high)
    {
        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++)
        {
            if (array[j] < pivot)
            {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp1 = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp1;
        return i + 1;
    }

    private void quickSort( int low, int high)
    {
        if (low < high)
        {
            int partition = Partition(low, high);
            quickSort( low, partition - 1);
            quickSort( partition + 1, high);
        }
    }

    @Override
    public void sort() {
        startDate = System.nanoTime();
        quickSort(0, array.length-1);
        endDate = System.nanoTime();
    }
    
}
