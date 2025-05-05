package br.edu.lab5.figuras;

public class Triangulo implements Calculable {
	private double base;
	private double altura;
	
	public Triangulo(final double pBase, final double pAltura) {
		base = pBase;
		altura = pAltura;
	}

	@Override
	public double calcularArea() {
		return (base * altura) / 2;
	}
	
}
