import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import nadalete.NumerosComplexos;

public class NumerosComplexosTest {

    @Test
    public void validarConstrutorPadrao() {
        NumerosComplexos num = new NumerosComplexos();
        assertEquals(0.0, num.getReal());
        assertEquals(0.0, num.getImaginario());
    }

    @Test
    public void validarConstrutorComUmParametro() {
        NumerosComplexos num = new NumerosComplexos(5);
        assertEquals(5.0, num.getReal());
        assertEquals(0.0, num.getImaginario());
    }

    @Test
    public void validarConstrutorComDoisParametros() {
        NumerosComplexos num = new NumerosComplexos(3, 4);
        assertEquals(3.0, num.getReal());
        assertEquals(4.0, num.getImaginario());
    }

    @Test
    public void validarModulo() {
        NumerosComplexos num = new NumerosComplexos(3, 4);
        assertEquals(5.0, num.getModulo(), 0.0001);
    }

    @Test
    public void validarAngulo() {
        NumerosComplexos num = new NumerosComplexos(1, 1);
        assertEquals(Math.PI / 4, num.getAngulo(), 0.0001);
    }

    @Test
    public void validarInversoAditivo() {
        NumerosComplexos num = new NumerosComplexos(3, -4);
        NumerosComplexos inverso = num.inversoAditivo();
        assertEquals(-3.0, inverso.getReal());
        assertEquals(4.0, inverso.getImaginario());
    }

    @Test
    public void validarSoma() {
        NumerosComplexos num1 = new NumerosComplexos(2, 3);
        NumerosComplexos num2 = new NumerosComplexos(1, 1);
        NumerosComplexos resultado = num1.somar(num2);
        assertEquals(3.0, resultado.getReal());
        assertEquals(4.0, resultado.getImaginario());
    }

    @Test
    public void validarSubtracao() {
        NumerosComplexos num1 = new NumerosComplexos(5, 4);
        NumerosComplexos num2 = new NumerosComplexos(2, 3);
        NumerosComplexos resultado = num1.subtrair(num2);
        assertEquals(3.0, resultado.getReal());
        assertEquals(1.0, resultado.getImaginario());
    }

    @Test
    public void validarMultiplicacao() {
        NumerosComplexos num1 = new NumerosComplexos(1, 2);
        NumerosComplexos num2 = new NumerosComplexos(3, 4);
        NumerosComplexos resultado = num1.multiplicar(num2);
        assertEquals(-5.0, resultado.getReal());
        assertEquals(10.0, resultado.getImaginario());
    }

    @Test
    public void validarDivisao() {
        NumerosComplexos num1 = new NumerosComplexos(3, 2);
        NumerosComplexos num2 = new NumerosComplexos(1, -1);
        NumerosComplexos resultado = num1.dividir(num2);
        assertEquals(0.5, resultado.getReal(), 0.0001);
        assertEquals(2.5, resultado.getImaginario(), 0.0001);
    }

    @Test
    public void validarToString() {
        NumerosComplexos num = new NumerosComplexos(3.5, -2.1);
        assertEquals("(3.5, -2.1)", num.toString());
    }
}
