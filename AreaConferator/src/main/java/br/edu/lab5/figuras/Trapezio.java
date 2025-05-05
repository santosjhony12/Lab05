package br.edu.lab5.figuras;

public class Trapezio implements Calculable {
	private double baseMa;
	private double baseMe;
	private double altura;
	
	public Trapezio(final double pBaseMa, final double pBaseMe, final double pAltura) {
		baseMa = pBaseMa;
		baseMe = pBaseMe;
		altura = pAltura;
	}

	@Override
	public double calcularArea() {
		return ((baseMa + baseMe) * altura) / 2;
	}
	
}
