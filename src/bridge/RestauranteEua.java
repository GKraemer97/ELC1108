package bridge;

import java.util.LinkedList;
import command.PagamentoCommand;
import state.Pedido;

/**
* @author Guilherme Kraemer
*\file RestauranteEua.java
*
* Classe concreta que representa um restaurante
*/

/**
* @author Guilherme Kraemer
* @class public class RestauranteEua
* @brief Implementa o método usado para adicionar um novo pedido à lista de pedidos deste restaurante
*/

public class RestauranteEua extends Restaurante {

    public RestauranteEua(String n, Cardapio c, LinkedList<Pedido> pedidos) {
        super(n, c, pedidos);
    }

    @Override
    public void executarPedido(String nomePrato, int preco, PagamentoCommand formaDePagamento) {
        pedidos.addFirst(new Pedido(nomePrato, preco, formaDePagamento));
    }
    
    
    
}
