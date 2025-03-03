package state;

import command.PagamentoCommand;

/**
* @author Guilherme Kraemer
*\file PedidoPronto.java
*
* Classe que representa um estado de um pedido de um restaurante
* 
*/

/**
* @author Guilherme Kraemer
* @class public class PedidoPronto
* @brief métodos que definem as possibilidades de transição de estado com base no estado atual
*
*/

public class PedidoPronto implements EstadoPedido {
    
    public PedidoPronto(PedidoCriado estado) {
        // atribuindo null ao objeto de estado anterior para que o garbage collection delete-o
        estado = null;
    }

    @Override
    public EstadoPedido entregarPedido() {
        System.out.println("Pedido entregue!\n");
        return new PedidoEntregue(this);
    }

    @Override
    public EstadoPedido prepararPedido() {
        System.out.println("O pedido já está pronto\n");
        return this;
    }

    @Override
    public EstadoPedido receberPagamento(int valor, PagamentoCommand formaDePagamento) {
        System.out.println("O pedido ainda não foi entregue!\n");
        return this;
    }
    
    
}
