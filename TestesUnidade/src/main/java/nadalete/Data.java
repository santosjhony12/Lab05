package nadalete;

import java.time.LocalDate;

public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data() {
        LocalDate hoje = LocalDate.now();
        this.dia = hoje.getDayOfMonth();
        this.mes = hoje.getMonthValue();
        this.ano = hoje.getYear();
    }

    public Data(int dia, int mes, int ano) {
        if (validarData(dia, mes, ano)) {
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        } else {
            this.dia = 1;
            this.mes = 1;
            this.ano = 2000;
        }
    }

    private boolean validarData(int dia, int mes, int ano) {
        if (mes < 1 || mes > 12 || dia < 1) return false;
        int[] diasPorMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (ano % 4 == 0 && (ano % 100 != 0 || ano % 400 == 0)) {
            diasPorMes[1] = 29;
        }
        return dia <= diasPorMes[mes - 1];
    }

    public void avancarDia() {
        if (validarData(dia + 1, mes, ano)) {
            dia++;
        } else if (validarData(1, mes + 1, ano)) {
            dia = 1;
            mes++;
        } else {
            dia = 1;
            mes = 1;
            ano++;
        }
    }

    @Override
    public String toString() {
        return dia + "/" + mes + "/" + ano;
    }
}