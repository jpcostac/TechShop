package org.example;

public class Pedido {
    private static int contadorId = 1;
    private int id;
    private Carrinho carrinho;
    private Endereco enderecoEntrega;
    private double taxaEntrega;
    private double total;

    // Construtor com carrinho
    public Pedido(Carrinho carrinho) {
        this.id = contadorId++;
        this.carrinho = carrinho;
    }

    // Construtor padrão
    public Pedido() {
        this.id = contadorId++;
        this.carrinho = new Carrinho();
    }


    public void setEnderecoEntrega(Endereco endereco) {
        this.enderecoEntrega = endereco;
    }


    public double calcularTaxaEntrega() {
        if (enderecoEntrega == null) {
            throw new IllegalArgumentException("Endereço de entrega não pode ser nulo.");
        }

        if (enderecoEntrega.getEstado().equals("SP")) {
            taxaEntrega = 15.0;
        } else {
            taxaEntrega = 20.0;
        }
        return taxaEntrega;
    }


    public void gerarPedido() {
        if (carrinho.getProdutos().isEmpty()) {
            throw new IllegalStateException("Carrinho vazio, não é possível gerar o pedido.");
        }
        total = carrinho.calcularTotal() + calcularTaxaEntrega();
    }

    // Retorna o total do pedido
    public double getTotal() {
        return total;
    }

    // Imprime o resumo do pedido
    public void imprimirResumo() {
        System.out.println("Resumo do Pedido:");
        System.out.println("Total Carrinho: R$ " + carrinho.calcularTotal());
        System.out.println("Taxa de Entrega: R$ " + taxaEntrega);
        System.out.println("Total Pedido: R$ " + total);
    }

    // Método para definir o carrinho
    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;  // Agora atribui o carrinho ao campo da classe
    }

    // Método para acessar o carrinho (útil para o teste)
    public Carrinho getCarrinho() {
        return carrinho;
    }

    // Método para acessar o ID do pedido
    public int getId() {
        return id;  // Retorna o ID único do pedido
    }
}
