package br.edu.lab5.factory;

import br.edu.lab5.integration.ErrorPerformCalcException;

public interface Factory<R, T> {
	R create(final T ft, double... params) throws ErrorPerformCalcException;
}
