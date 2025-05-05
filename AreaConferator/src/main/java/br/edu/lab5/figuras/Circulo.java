package br.edu.lab5.figuras;

public class Circulo implements Calculable {
	private double raio;
	
	public Circulo(final double pRaio) {
		raio = pRaio;
	}

	@Override
	public double calcularArea() {
		return Math.PI * Math.pow(raio, 2);
	}
	
}
