package br.edu.lab5.figuras;

public class Hexagono implements Calculable {
	private double lado;
	
	public Hexagono(final double pLado) {
		lado = pLado;
	}

	@Override
	public double calcularArea() {
		return ((3 * Math.pow(lado, 2)) * Math.sqrt(3)) / 2;
	}
	
}
