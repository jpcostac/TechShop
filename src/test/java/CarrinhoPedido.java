import static org.junit.jupiter.api.Assertions.*;

import org.example.Carrinho;
import org.example.Endereco;
import org.example.Pedido;
import org.example.Produto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarrinhoPedido {
    private Carrinho carrinho;
    private Pedido pedido;
    public Endereco endereco;


    @BeforeEach
    public void setup() {
        carrinho = new Carrinho();
        pedido = new Pedido();
        endereco = new Endereco();
    }

    @Test
    public void testGerarPedidoIntegradoComCarrinho() {
        carrinho.adicionarProduto(new Produto("Produto A", 100.0));
        carrinho.aplicarDesconto(10.0);
        endereco.setEstado("São Paulo");
        endereco.setCidade("SP");
        endereco.setRua("Rua 2");

        pedido.setEnderecoEntrega(endereco);
        pedido.setCarrinho(carrinho);

        pedido.gerarPedido();

        assertEquals(110.0, pedido.getTotal(), "O total do pedido deve ser o valor do carrinho com desconto.");
    }
}
