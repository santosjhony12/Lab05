package br.edu.fatec.sjc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class NumberAscOrderTest {
    private CalculableStrategy<Integer> calculableStrategy;

    @BeforeEach
    void setUp() {
        calculableStrategy = Mockito.mock(CalculableStrategy.class);
        when(calculableStrategy.calculateValue(anyInt())).thenAnswer(invocation -> invocation.getArgument(0));
    }

    @Test
    public void testPilhaComNumeros() throws Exception {
        CustomStack<Integer> stack = new CustomStack<>(6, calculableStrategy);

        stack.push(23);
        stack.push(4);
        stack.push(42);
        stack.push(18);
        stack.push(7);
        stack.push(30);

        NumberAscOrder<Integer> sorter = new NumberAscOrder<>(stack);
        List<Integer> sorted = sorter.sort();

        assertEquals(List.of(4, 7, 18, 23, 30, 42), sorted);
    }

    @Test
    public void testPilhaVazia() throws Exception {
        CustomStack<Integer> stack = new CustomStack<>(6, calculableStrategy);

        NumberAscOrder<Integer> sorter = new NumberAscOrder<>(stack);
        List<Integer> sorted = sorter.sort();

        assertTrue(sorted.isEmpty());
    }

    @Test
    public void testStackFullException() {
        assertThrows(StackFullException.class, () -> {
            CustomStack<Integer> stack = new CustomStack<>(2, calculableStrategy);
            stack.push(1);
            stack.push(2);
            stack.push(3);
        });
    }

    @Test
    public void testStackEmptyExceptionOnPop() {
        CustomStack<Integer> stack = new CustomStack<>(3, calculableStrategy);
        assertThrows(StackEmptyException.class, stack::pop);
    }

    @Test
    public void testConstrutorComCustomStackNulo() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            new NumberAscOrder<>(null);
        });

        assertEquals("CustomStack não pode ser null", thrown.getMessage());
    }

    @Test
    public void testSortLancaRuntimeExceptionAoPopFalhar() throws StackEmptyException {
        @SuppressWarnings("unchecked")
        CustomStack<Integer> mockStack = mock(CustomStack.class);

        when(mockStack.isEmpty()).thenReturn(false);
        when(mockStack.pop()).thenThrow(new StackEmptyException());

        NumberAscOrder<Integer> sorter = new NumberAscOrder<>(mockStack);

        RuntimeException thrown = assertThrows(RuntimeException.class, sorter::sort);
        assertTrue(thrown.getMessage().contains("Erro ao acessar elementos da pilha"));
    }

}
