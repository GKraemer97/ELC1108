package state;

import command.PagamentoCommand;

/**
* @author Guilherme Kraemer
*\file PedidoPago.java
*
* Classe que representa um estado de um pedido de um restaurante
* 
*/

/**
* @author Guilherme Kraemer
* @class public class PedidoPago
* @brief métodos que definem as possibilidades de transição de estado com base no estado atual
*
*/

public class PedidoPago implements EstadoPedido {
    
    public PedidoPago(PedidoEntregue estado) {
        // atribuindo null ao objeto de estado anterior para que o garbage collection delete-o
        estado = null;
        System.out.println("Pedido concluído!\n");
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
        System.out.println("O pedido já foi pago!\n");
        return this;
    }
    
}
