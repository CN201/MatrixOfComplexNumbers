
package exmatrix;
public class Complex {

    private final int re;
    private final int im;

    public Complex(int real, int imag) {
        re = real;
        im = imag;
    }

    public String toString() {
        if (im == 0) {
            return re + "";
        }
        if (re == 0) {
            return im + "j";
        }
        if (im < 0) {
            return re + " - " + (-im) + "j";
        }
        return re + " + " + im + "j";
    }

    public Complex plus(Complex b) {
        Complex a = this;
        int real = a.re + b.re;
        int imag = a.im + b.im;
        return new Complex(real, imag);
    }

    public Complex minus(Complex b) {
        Complex a = this;
        int real = a.re - b.re;
        int imag = a.im - b.im;
        return new Complex(real, imag);
    }

    public Complex multi(Complex b) {
        Complex a = this;
        int real = a.re * b.re - a.im * b.im;
        int imag = a.re * b.im + a.im * b.re;
        return new Complex(real, imag);
    }

    public Complex multi(int alpha) {
        return new Complex(alpha * re, alpha * im);
    }

    public double re() {
        return re;
    }

    public double im() {
        return im;
    }

    public static Complex plus(Complex a, Complex b) {
        int real = a.re + b.re;
        int imag = a.im + b.im;
        Complex sum = new Complex(real, imag);
        return sum;
    }
}