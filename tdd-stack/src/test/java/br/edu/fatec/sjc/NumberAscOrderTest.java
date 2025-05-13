package br.edu.fatec.sjc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class NumberAscOrderTest {
    @Mock
    private CustomStack<Integer> customStack;

    @Test
    public void testPilhaComNumeros() {
        try {
            when(customStack.pop()).thenReturn(23, 4, 42, 18, 7, 30);
            when(customStack.isEmpty()).thenReturn(false, false, false, false, false, true);

        } catch (StackEmptyException e) {
            fail();
        }

        NumberAscOrder<Integer> sorter = new NumberAscOrder<>(customStack);
        List<Integer> sorted = sorter.sort();

        assertEquals(List.of(4, 7, 18, 23, 30, 42), sorted);
    }

    @Test
    public void testSortLancaRuntimeExceptionAoPopFalhar() throws StackEmptyException {
        @SuppressWarnings("unchecked")
        CustomStack<Integer> mockStack = mock(CustomStack.class);

        when(mockStack.pop()).thenThrow(new StackEmptyException());

        NumberAscOrder<Integer> sorter = new NumberAscOrder<>(mockStack);

        RuntimeException thrown = assertThrows(RuntimeException.class, sorter::sort);
        assertTrue(thrown.getMessage().contains("Erro ao acessar elementos da pilha"));
    }

}
