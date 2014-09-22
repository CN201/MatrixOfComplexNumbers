/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exmatrix;

/**
 *
 * @author phisan
 */
public class ExMatrix {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Matrix a = new Matrix(2);
        Matrix b = new Matrix(2);
        a.scanInput();
        b.scanInput();
        Matrix c = a.add(b);
        Matrix d = a.minus(b);
        Matrix e = Matrix.mul(a,b);
        c.printMatrix();
        d.printMatrix();
        e.printMatrix();

    }
}
