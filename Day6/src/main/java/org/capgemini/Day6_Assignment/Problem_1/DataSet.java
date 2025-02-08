package org.capgemini.Day6_Assignment.Problem_1;

public class DataSet {
    public final int[] data;

     public DataSet(int size){
         this.data = new int[size];
         for(int i =0; i<size ; i++){
             data[i] = i;
         }
     }
}
