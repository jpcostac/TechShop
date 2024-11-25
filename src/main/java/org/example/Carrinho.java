package org.example;
import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private List<Produto> produtos;
    private double desconto;

    public Carrinho() {
        this.produtos = new ArrayList<>();
        this.desconto = 0.0;
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void aplicarDesconto(double percentual) {
        if (percentual < 0 || percentual > 100) {
            throw new IllegalArgumentException("Desconto inválido!");
        }
        this.desconto = percentual;
    }

    public double calcularTotal() {
        double total = produtos.stream().mapToDouble(Produto::getPreco).sum();
        return total - (total * (desconto / 100));
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}
