/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matrix;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author sabri
 */
public class Matrix {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException 
    {
        int matrix1[][] = createMatrix("Matris1.txt");
        int matrix2[][] = createMatrix("Matris2.txt");
        
        Thread[] threadArr = new Thread[matrix1.length];//Creates Thread array with a length with a total line number of Matrix1
        Buffer buffer = new Buffer(matrix1.length, matrix2[0].length);
        for(int i =0 ; i < threadArr.length; i++){//Creates and adds threads to threadArr
            threadArr[i] = new Thread(new MultiplyWorker(matrix1, matrix2, buffer));
            threadArr[i].start();
        }
        for(Thread thread: threadArr) thread.join();
        
        buffer.print();
        
        System.out.println("");
    }
    
    public static int[][] createMatrix(String path){//Creates and returns 2D array
        try {
            Scanner scanner = new Scanner(new File(path));
            int numberOfColumns,numberOfLines = 0; 
            while(scanner.hasNextLine()){//Calculates the total lines of a matrix
                numberOfLines++;  
                scanner.nextLine();
            }
            scanner = new Scanner(new File(path));
            numberOfColumns = scanner.nextLine().split(" ").length;//Calculates the total columns of a matrix
            scanner = new Scanner(new File(path));
            int[][] matrix = new int[numberOfLines][numberOfColumns];//Creates matrix as a 2D array
            int iterLine = 0;int iterColumn = 0;
            while(scanner.hasNextInt()){//Adds each cell to 2D array 
                matrix[iterLine][iterColumn] = scanner.nextInt();
                if(iterColumn == numberOfColumns - 1){iterColumn = 0; iterLine++;}
                else{iterColumn++;} 
            }
            String str = "";
            for(int[] line : matrix){
                for(int cell : line) str += cell + " ";
                str += "\n";        
            }
            System.out.println(str);//Prints the matrix.
            return matrix;
        } catch (FileNotFoundException e) {
            System.out.println("File was not found.");
            return null;
        }
    }
}
