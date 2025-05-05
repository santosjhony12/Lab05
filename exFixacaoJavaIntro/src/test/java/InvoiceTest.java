import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import nadalete.Invoice;

public class InvoiceTest {

    @ParameterizedTest
    @MethodSource("provideInputAndExpectedValues")
    public void validarConfiguracoesInvoices(int codItemFaturado, String descricao, int quantidade,
            int quantidadeEsperada, double precoUnitario,
            double precoUnitarioEsperado) {
            Invoice cut = new Invoice(codItemFaturado, descricao, quantidade, precoUnitario);

                assertEquals(codItemFaturado, cut.getCodItemFaturado());
                assertEquals(descricao, cut.getDescricao());
                assertEquals(quantidadeEsperada, cut.getPrecoUnitario());
                assertEquals(precoUnitarioEsperado, cut.getPrecoUnitario());
                assertEquals(quantidadeEsperada * precoUnitarioEsperado, cut.getInvoiceAmount());
    }

    private static Stream<Arguments> provideInputAndExpectedValues(){
        return Stream.of(
            Arguments.of(1, "Descrição 1", 0, 0, -1, 0),
            Arguments.of(3, "Descrição 3", 10, 10, 10, 10)
        );
    }

    
}
