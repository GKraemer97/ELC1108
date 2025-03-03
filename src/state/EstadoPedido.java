package state;

import command.PagamentoCommand;

/**
* @author Guilherme Kraemer
*\file EstadoPedido.java
*
* Interface que representa o estado de um pedido
* 
*/

/**
* @author Guilherme Kraemer
* @class public class EstadoPedido
* @brief declara os métodos para mudar o estado dos pedidos
* 
*/

public interface EstadoPedido {

    EstadoPedido prepararPedido();

    EstadoPedido entregarPedido();

    EstadoPedido receberPagamento(int valor, PagamentoCommand formaDePagamento);
}
