package state;

import command.PagamentoCommand;

/**
* @author Guilherme Kraemer
*\file PedidoEntregue.java
*
* Classe que representa um estado de um pedido de um restaurante
* 
*/

/**
* @author Guilherme Kraemer
* @class public class PedidoEntregue
* @brief métodos que definem as possibilidades de transição de estado com base no estado atual
*
*/

public class PedidoEntregue implements EstadoPedido {
    
    public PedidoEntregue(PedidoPronto estado) {
        // atribuindo null ao objeto de estado anterior para que o garbage collection delete-o
        estado = null;
    }

    @Override
    public EstadoPedido entregarPedido() {
        System.out.println("O pedido já foi entregue!\n");
        return this;
    }

    @Override
    public EstadoPedido prepararPedido() {
        System.out.println("O pedido já está pronto\n");
        return this;
    }

    @Override
    public EstadoPedido receberPagamento(int valor, PagamentoCommand formaDePagamento) {
        formaDePagamento.processarPagamento(valor);
        return new PedidoPago(this);
    }
    
}
