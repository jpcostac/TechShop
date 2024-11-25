import static org.junit.jupiter.api.Assertions.*;

import org.example.Endereco;
import org.example.Pedido;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PedidoTest {
    private Pedido pedido;

    @BeforeEach
    public void setup() {
        pedido = new Pedido();
    }

    @Test
    public void testCalcularTaxaEntregaComEnderecoValido() {
        Endereco endereco = new Endereco("Rua A", "Cidade X", "SP");
        pedido.setEnderecoEntrega(endereco);

        double taxaEntrega = pedido.calcularTaxaEntrega();
        assertEquals(15.0, taxaEntrega, "A taxa de entrega deve ser 15.0 para este endereço.");
    }

    @Test
    public void testCalcularTaxaEntregaComEnderecoDiferente() {
        Endereco endereco = new Endereco("Rua B", "Cidade Y", "MG");
        pedido.setEnderecoEntrega(endereco);

        double taxaEntrega = pedido.calcularTaxaEntrega();
        assertEquals(20.0, taxaEntrega, "A taxa de entrega deve ser 20.0 para este endereço.");
    }

    @Test
    public void testCalcularTaxaEntregaComEnderecoNulo() {
        pedido.setEnderecoEntrega(null);
        assertThrows(IllegalArgumentException.class, () -> {
            pedido.calcularTaxaEntrega();
        });
    }
}
