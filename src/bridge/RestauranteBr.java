package bridge;

import java.util.LinkedList;
import command.PagamentoCommand;
import state.Pedido;

/**
* @author Guilherme Kraemer
*\file RestauranteBr.java
*
* Classe concreta que representa um restaurante
*/

/**
* @author Guilherme Kraemer
* @class public class RestauranteBr
* @brief Implementa o método usado para adicionar um novo pedido à lista de pedidos deste restaurante
*/

public class RestauranteBr extends Restaurante {

    public RestauranteBr(String n, Cardapio c, LinkedList<Pedido> pedidos) {
        super(n, c, pedidos);
    }

    @Override
    public void executarPedido(String nomePrato, int preco, PagamentoCommand formaDePagamento) {
        Pedido pedido = new Pedido(nomePrato, preco, formaDePagamento);
        pedidos.addFirst(pedido);
    }
    
    
}
