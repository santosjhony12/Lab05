package br.edu.fatec.sjc;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberAscOrder<T extends Number & Comparable<T>> {
    private CustomStack<T> customStack;

    public NumberAscOrder(CustomStack<T> customStack){
        this.customStack = customStack;
    }

    public List<T> sort() throws RuntimeException {
        List<T> sortedList = new ArrayList<>();
    
        try {
            do{
                sortedList.add(customStack.pop());
            }
            while (!customStack.isEmpty());

            Collections.sort(sortedList);
        } catch (StackEmptyException e) {
            throw new RuntimeException("Erro ao acessar elementos da pilha: " + e.getMessage());
        }
    
        return sortedList;
    }
    
}
