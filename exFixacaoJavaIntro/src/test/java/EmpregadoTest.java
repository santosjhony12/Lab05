import nadalete.Empregado;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class EmpregadoTest {
    @Test
    public void validarConfiguracaoSalarioInferiorZero() {
        Empregado cut = new Empregado("Nome 1", "Sobrenome 1", -1.0);
        assertEquals("Nome 1", cut.getPrimeiroNome());
        assertEquals("Sobrenome 1", cut.getSobrenome());
        assertEquals(0.0, cut.getSalarioMensal());
        assertEquals(0.0, cut.getSalarioAnual());
    }

    @Test
    public void validarConfiguracaoSalarioIgualZero() {
        Empregado cut = new Empregado("Nome 2", "Sobrenome 2", 0.0);
        assertEquals("Nome 2", cut.getPrimeiroNome());
        assertEquals("Sobrenome 2", cut.getSobrenome());
        assertEquals(0.0, cut.getSalarioMensal());
        assertEquals(0.0, cut.getSalarioAnual());
    }

    @Test
    public void validarConfiguracaoSalarioSuperiorZero() {
        Empregado cut = new Empregado("Nome 3", "Sobrenome 3", 1.0);
        assertEquals("Nome 3", cut.getPrimeiroNome());
        assertEquals("Sobrenome 3", cut.getSobrenome());
        assertEquals(1.0, cut.getSalarioMensal());
        assertEquals(12.0, cut.getSalarioAnual());
    }

    @Test
    public void validarAumentoDezPorcentoNoSalarioMensal() {
        Double salarioReajustado = 11.0;
        Empregado cut = new Empregado("Nome 4", "Sobrenome 4", 10.0);
        cut.aumentarSalario(10);
        assertEquals(salarioReajustado, cut.getSalarioMensal());
        assertEquals((12 * salarioReajustado), cut.getSalarioAnual());
    }

    @ParameterizedTest
    @MethodSource("provideInputAndExpectedValues")
    @Disabled
    public void validarConfiguracaoSalario(String nome, String sobreNome, Double salarioMensal,
                                           Double expectedSalMensal, Double expectedSalAnual) {
        Empregado cut = new Empregado(nome, sobreNome, salarioMensal);
        assertEquals(nome, cut.getPrimeiroNome());
        assertEquals(sobreNome, cut.getSobrenome());
        assertEquals(expectedSalMensal, cut.getSalarioMensal());
        assertEquals(expectedSalAnual, cut.getSalarioAnual());

    }

    private static Stream<Arguments> provideInputAndExpectedValues() {
        return Stream.of(
                Arguments.of("Nome 1", "Sobrenome 1", -1.0, 0.0, 0.0),
                Arguments.of("Nome 2", "Sobrenome 2", 0.0, 0.0, 0.0),
                Arguments.of("Nome 3", "Sobrenome 3", 1.0, 1.0, 12.0)
        );
    }
}
