import static org.junit.jupiter.api.Assertions.*;

import org.example.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PedidoBanco {
    private Pedido pedido;
    private BancoDeDados banco;

    @BeforeEach
    public void setup() {
        banco = new BancoDeDados();
        Carrinho carrinho = new Carrinho();
        pedido = new Pedido(carrinho);
    }

    @Test
    public void testRegistrarPedidoNoBanco() {
        Endereco endereco = new Endereco();
        endereco.setCidade("São Paulo");
        endereco.setEstado("SP");
        endereco.setRua("Rua 1");

        pedido.setEnderecoEntrega(endereco);

        Carrinho carrinho = pedido.getCarrinho();
        carrinho.adicionarProduto(new Produto("Produto A", 100.0));
        carrinho.aplicarDesconto(10.0);

        pedido.gerarPedido();

        banco.salvarPedido(pedido);

        Pedido pedidoSalvo = banco.buscarPedido(pedido.getId());
        assertNotNull(pedidoSalvo, "O pedido deve ser salvo corretamente no banco de dados.");
        assertEquals(105.0, pedidoSalvo.getTotal(), "O total do pedido salvo deve ser o mesmo do pedido gerado.");
    }
}
