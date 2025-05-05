package br.edu.lab5.figuras;

public class Quadrado implements Calculable {
	private double lado;
	
	public Quadrado(final double pLado) {
		lado = pLado;
	}

	@Override
	public double calcularArea() {
		Calculable c = new Retangulo(lado, lado);
		return c.calcularArea();
	}
	
}
