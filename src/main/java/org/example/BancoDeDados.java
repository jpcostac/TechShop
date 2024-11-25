package org.example;
import java.util.HashMap;
import java.util.Map;

public class BancoDeDados {
    private Map<Integer, Pedido> pedidos;
    private int idCounter;

    public BancoDeDados() {
        pedidos = new HashMap<>();
        idCounter = 1;
    }

    public void salvarPedido(Pedido pedido) {
        pedido.gerarPedido();
        pedidos.put(idCounter++, pedido);
    }

    public Pedido buscarPedido(int id) {
        return pedidos.get(id);
    }
}
