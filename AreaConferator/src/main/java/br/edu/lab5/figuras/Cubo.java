package br.edu.lab5.figuras;

public class Cubo implements Calculable {
	private double lado;
	
	public Cubo(final double pLado) {
		lado = pLado;
	}

	@Override
	public double calcularArea() {
		final Calculable c = new Quadrado(lado);
		return 6 * c.calcularArea();
	}
	
}
