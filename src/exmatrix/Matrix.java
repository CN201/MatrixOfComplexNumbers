/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exmatrix;

import java.util.Scanner;

/**
 *
 * @author phisan
 */
public class Matrix {
    
    private int SIZE = 2; //default 
    private Complex[][] a = new Complex[SIZE][SIZE];
   
    public static Matrix mul(Matrix a,Matrix b){
        return a.mul(b);
    }
    public Matrix(Complex[][] val){
        SIZE = val.length;
        a = new Complex[SIZE][SIZE];
       for(int i=0;i<val.length;i++){
           for(int j=0;j<val.length;j++){
               a[i][j] = val[i][j];
           }        
        }
    }
    
    public Matrix(){}
    public Matrix(int size){
        SIZE = size;
        a = new Complex[SIZE][SIZE];
    }
    
    public void setE(int i,int j, Complex val){        
        a[i][j]= val;
    }
    public Complex getE(int i,int j){
        return a[i][j];
    }
    public void scanInput(){
        System.out.println("Enter Element");
        Scanner s = new Scanner(System.in);
       for(int i=0;i<a.length;i++){
           for(int j=0;j<a.length;j++){
               String x = s.next();
               if(x.length()==4){
                   if(x.charAt(1)=='-'){
                       int real = Integer.parseInt(x.charAt(0)+"");
                       int im = Integer.parseInt(x.charAt(2)+"")*-1;
                       a[i][j] = new Complex(real,im);
                   }
                   else{
                   int real = Integer.parseInt(x.charAt(0)+"");
                       int im = Integer.parseInt(x.charAt(2)+"");
                       a[i][j] = new Complex(real,im);
                    }
               }
               else{
                   if(x.charAt(1)=='-'){
                       int real = Integer.parseInt(x.charAt(0)+"")*-1;
                       int im = Integer.parseInt(x.charAt(3)+"")*-1;
                       a[i][j] = new Complex(real,im);
                   }
                   else{
                   int real = Integer.parseInt(x.charAt(0)+"")*-1;
                       int im = Integer.parseInt(x.charAt(3)+"");
                       a[i][j] = new Complex(real,im);
                    }
               }
           }
       }
   }
   
   public Matrix add(Matrix b){
       
       Complex [][] temp = new Complex[SIZE][SIZE];
       for(int i=0;i<a.length;i++){
           for(int j=0;j<a.length;j++){
               temp[i][j] = a[i][j].plus(b.getE(i, j));
           }
       }
       return new Matrix(temp);
   }
    public Matrix minus(Matrix b){
       
       Complex [][] temp = new Complex[SIZE][SIZE];
       for(int i=0;i<a.length;i++){
           for(int j=0;j<a.length;j++){
               temp[i][j] = a[i][j].minus(b.getE(i, j));
           }
       }
       return new Matrix(temp);
   }
   
   private Complex vmul(int i,int j,Matrix b){
       Complex sum = new Complex(0,0);
       for(int x=0;x<a.length;x++){
           sum=sum.plus(this.getE(i, x).multi(b.getE(x, j)));
       }
       return sum;
   }
   public Matrix mul(Matrix b){
       Complex [][] temp = new Complex[SIZE][SIZE];
       for(int i=0;i<a.length;i++){
           for(int j=0;j<a.length;j++){
               temp[i][j] = vmul(i,j,b);
           }
       }
       return new Matrix(temp);
         
   }
   
   public void printMatrix(){
       System.out.println("The Result Is");
       for(int i=0;i<a.length;i++){
           for(int j=0;j<a.length;j++){
               System.out.print(a[i][j]);
               System.out.print(" ");
           }
           System.out.println();
       }
   }
}
