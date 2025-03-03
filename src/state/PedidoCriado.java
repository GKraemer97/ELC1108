package state;

import command.PagamentoCommand;

/**
* @author Guilherme Kraemer
*\file PedidoCriado.java
*
* Classe que representa um estado de um pedido de um restaurante
* 
*/

/**
* @author Guilherme Kraemer
* @class public class PedidoCriado
* @brief métodos que definem as possibilidades de transição de estado com base no estado atual
*
*/

public class PedidoCriado implements EstadoPedido {

    public PedidoCriado() {
        System.out.println("Pedido criado com sucesso!\n");
    }

    @Override
    public EstadoPedido entregarPedido() {
        System.out.println("Pedido ainda não foi preparado!\n");
        return this;
    }

    @Override
    public EstadoPedido prepararPedido() {
        System.out.println("Pedido pronto!\n");
        return new PedidoPronto(this);
    }

    @Override
    public EstadoPedido receberPagamento(int valor, PagamentoCommand formaDePagamento) {
        System.out.println("Pedido ainda não foi preparado!\n");
        return this;
    }
    
}
