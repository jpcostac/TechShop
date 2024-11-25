package org.example;

public class Main {

    public static void main(String[] args) {

        Produto produto1 = new Produto("Smartphone", 1200.0);
        Produto produto2 = new Produto("Laptop", 3000.0);

        Carrinho carrinho = new Carrinho();
        carrinho.adicionarProduto(produto1);
        carrinho.adicionarProduto(produto2);

        carrinho.aplicarDesconto(10.0);

        Endereco endereco = new Endereco("Rua das Flores, 123", "São Paulo", "SP");

        Pedido pedido = new Pedido(carrinho);
        pedido.setEnderecoEntrega(endereco);

        pedido.calcularTaxaEntrega();

        BancoDeDados banco = new BancoDeDados();
        banco.salvarPedido(pedido);

        pedido.imprimirResumo();

        Pedido pedidoSalvo = banco.buscarPedido(1);
        System.out.println("\nPedido recuperado do banco:");
        pedidoSalvo.imprimirResumo();
    }
}