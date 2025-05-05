package nadalete;

import lombok.Data;

/*
Crie uma classe chamada Invoice com os atributos:
• o número do item faturado;
• a descrição do item;
• a quantidade comprada do item; e
• o preço unitário do item.
Sua classe deve ter um construtor que inicialize os quatro atributos*/
@Data
public class Invoice {
    private int codItemFaturado;
    private String descricao;
    private int quantidade;
    private double precoUnitario;

    public Invoice(int codItemFaturado, String descricao, int quantidade, double precoUnitario) {
        setCodItemFaturado(codItemFaturado);
        setDescricao(descricao);
        setQuantidade(quantidade);
        setPrecoUnitario(precoUnitario);
    }
    // Se a quantidade não for positiva, ela deve ser configurada como 0
    public void setQuantidade(int quantidade) {
        this.quantidade = (quantidade > 0) ? quantidade : 0;
    }
    // Se o preço por item não for positivo ele deve ser configurado como 0.0.
    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = (precoUnitario > 0) ? precoUnitario : 0.0;
    }

    // Além disso, forneça um método chamado getInvoiceAmount() que calcula o valor da fatura (isso é,
    // multiplica a quantidade pelo preço por item) e depois retorna o valor como um double.
    public double getInvoiceAmount() {
        return quantidade * precoUnitario;
    }
}
