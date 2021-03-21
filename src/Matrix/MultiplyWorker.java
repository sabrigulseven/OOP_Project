/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matrix;


/**
 *
 * @author sabri
 */
public class MultiplyWorker implements Runnable
{
    static int numberOfThreads = 0;
    int threadNumber;
    int matrix1[][];
    int matrix2[][];
    Buffer buffer;
    public MultiplyWorker(int matrix1[][], int matrix2[][], Buffer buffer) 
    {
        threadNumber = ++numberOfThreads;
        System.out.println("Thread " + threadNumber + " is created.");
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.buffer = buffer;
    }
    
    @Override
    public void run() 
    {
        calculate(); 
    }
    
    public void calculate()
    {
        // matrix2 kolon sayısı kadar
        for(int i = 0; i < matrix2[0].length; i++)
        {
            int sum = 0;
            for(int j = 0; j < matrix1[threadNumber - 1].length; j++)
            {
                // her thread matrix1deki kendi satırında işlem yapıyor
                sum += matrix1[threadNumber - 1][j] * matrix2[j][i];
            }
            
            buffer.Put(sum, threadNumber - 1, i);
            
            sum = 0;
        }
    }
    
}
