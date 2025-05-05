package br.edu.lab5.integration;

import br.edu.lab5.figuras.Calculable;

public interface LogPerformedCalculation {
    boolean logResultValue(Calculable calculable) throws ErrorPerformCalcException; 
}