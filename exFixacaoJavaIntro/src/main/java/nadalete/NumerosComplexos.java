package nadalete;

import lombok.Getter;

@Getter
public class NumerosComplexos {
    private double real;
    private double imaginario;

    public NumerosComplexos() {
        this(0, 0);
    }

    public NumerosComplexos(double real) {
        this(real, 0);
    }

    public NumerosComplexos(double real, double imaginario) {
        this.real = real;
        this.imaginario = imaginario;
    }
    public double getModulo() {
        return Math.sqrt(real * real + imaginario * imaginario);
    }

    public double getAngulo() {
        return Math.atan2(imaginario, real);
    }

    public NumerosComplexos inversoAditivo() {
        return new NumerosComplexos(-real, -imaginario);
    }

    public NumerosComplexos somar(NumerosComplexos c) {
        return new NumerosComplexos(this.real + c.real, this.imaginario + c.imaginario);
    }

    public NumerosComplexos subtrair(NumerosComplexos c) {
        return new NumerosComplexos(this.real - c.real, this.imaginario - c.imaginario);
    }

    public NumerosComplexos multiplicar(NumerosComplexos c) {
        return new NumerosComplexos(this.real * c.real - this.imaginario * c.imaginario,
                this.real * c.imaginario + this.imaginario * c.real);
    }

    public NumerosComplexos dividir(NumerosComplexos c) {
        double divisor = c.real * c.real + c.imaginario * c.imaginario;
        return new NumerosComplexos((this.real * c.real + this.imaginario * c.imaginario) / divisor,
                (this.imaginario * c.real - this.real * c.imaginario) / divisor);
    }

    @Override
    public String toString() {
        return "(" + real + ", " + imaginario + ")";
    }
}