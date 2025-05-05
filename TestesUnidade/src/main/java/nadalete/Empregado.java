package nadalete;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Empregado {
    private String primeiroNome;
    private String sobrenome;
    private double salarioMensal;

    public Empregado(String primeiroNome, String sobrenome, double salarioMensal) {
        this.primeiroNome = primeiroNome;
        this.sobrenome = sobrenome;
        setSalarioMensal(salarioMensal);
    }

    // Se o salário mensal não for positivo, configure-o como 0.0.
    public void setSalarioMensal(double salarioMensal) {
        this.salarioMensal = (salarioMensal > 0) ? salarioMensal : 0.0;
    }

    public double getSalarioAnual() {
        return salarioMensal * 12;
    }

    public void aumentarSalario(double percentual) {
        this.salarioMensal += this.salarioMensal * (percentual / 100);
    }
}
