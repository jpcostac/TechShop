import static org.junit.jupiter.api.Assertions.*;

import org.example.Carrinho;
import org.example.Produto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarrinhoTest {
    private Carrinho carrinho;

    @BeforeEach
    public void setup() {
        carrinho = new Carrinho();
    }

    @Test
    public void testCalcularDescontoComDescontoValido() {
        carrinho.adicionarProduto(new Produto("Produto A", 100.0));
        carrinho.aplicarDesconto(10.0);

        double totalComDesconto = carrinho.calcularTotal();
        assertEquals(90.0, totalComDesconto, "O total com desconto deve ser 90.");
    }

    @Test
    public void testCalcularDescontoSemDesconto() {
        carrinho.adicionarProduto(new Produto("Produto A", 100.0));

        double totalSemDesconto = carrinho.calcularTotal();
        assertEquals(100.0, totalSemDesconto, "O total sem desconto deve ser 100.");
    }

    @Test
    public void testCalcularDescontoComValorInvalido() {
        carrinho.adicionarProduto(new Produto("Produto A", 100.0));

        assertThrows(IllegalArgumentException.class, () -> {
            carrinho.aplicarDesconto(-10.0);
        });
    }
}
