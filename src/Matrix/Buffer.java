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
public class Buffer 
{
    int[][] sonucMatrisi;
    public Buffer(int sonucSatirSayisi, int sonucSutunSayisi) 
    {
        sonucMatrisi = new int[sonucSatirSayisi][sonucSutunSayisi];
    }
    
    public synchronized void Put(int sonuc, int satir, int sutun)
    {
        sonucMatrisi[satir][sutun] = sonuc;
    }
    
    public void print()
    {
        for (int satir[] : sonucMatrisi)
        {
            for (int sayi : satir ) 
            {
                System.out.print(sayi+" ");
            }
            System.out.println();
        }
    }
}
