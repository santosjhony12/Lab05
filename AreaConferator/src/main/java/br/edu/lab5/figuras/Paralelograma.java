package br.edu.lab5.figuras;

public class Paralelograma implements Calculable {
	private double base;
	private double altura;
	
	public Paralelograma(final double pBase, final double pAltura) {
		base = pBase;
		altura = pAltura;
	}

	@Override
	public double calcularArea() {
		Calculable c = new Retangulo(base, altura);
		return c.calcularArea();
	}
	
}
