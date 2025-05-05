package br.edu.fatec.sjc;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberAscOrder<T extends Number & Comparable<T>> {
    private CustomStack<T> customStack;

    public NumberAscOrder(CustomStack<T> customStack){
        if(customStack == null){
            throw new IllegalArgumentException("CustomStack não pode ser null");
        }
        this.customStack = customStack;
    }

    public List<T> sort() {
        List<T> sortedList = new ArrayList<>();
    
        try {
            while (!customStack.isEmpty()) {
                sortedList.add(customStack.pop());
            }
            Collections.sort(sortedList);
        } catch (StackEmptyException e) {
            throw new RuntimeException("Erro ao acessar elementos da pilha: " + e.getMessage());
        }
    
        return sortedList;
    }
    
}
