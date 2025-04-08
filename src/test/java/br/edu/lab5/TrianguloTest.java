package br.edu.lab5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import br.edu.lab5.exercicio01.TipoTriangulo;
import br.edu.lab5.exercicio01.Triangulo;

public class TrianguloTest {

    @ParameterizedTest
    @MethodSource("provideInputAndExpectedValuesTipoTriangulo")
    public void validarTipoTriangulo(int l1, int l2, int l3, TipoTriangulo tipoEsperado, boolean isValid) {
        Triangulo triangulo = new Triangulo(l1, l2, l3);
        if (isValid) {
            assertTrue(triangulo.isTriangulo());
        } else {
            assertFalse(triangulo.isTriangulo());
        }
        assertEquals(tipoEsperado, triangulo.getTipo());
    }

    private static Stream<Arguments> provideInputAndExpectedValuesTipoTriangulo() {
        return Stream.of(
                Arguments.of(3, 4, 5, TipoTriangulo.ESCALENO, true),
                Arguments.of(5, 3, 5, TipoTriangulo.ISOSCELES, true),
                Arguments.of(3, 3, 5, TipoTriangulo.ISOSCELES, true),
                Arguments.of(3, 10, 10, TipoTriangulo.ISOSCELES, true),
                Arguments.of(4, 4, 4, TipoTriangulo.EQUILATERO, true),
                Arguments.of(3, -4, -5, null, false),
                Arguments.of(-3, -4, -5, null, false),
                Arguments.of(2, 2, 10, null, false),//false
                Arguments.of(10, 2, 2, null, false),
                Arguments.of(2, 10, 2, null, false),
                Arguments.of(3, 2, -5, null, false)       
                
                );
    }
}