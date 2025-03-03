package state;

import command.PagamentoCommand;

/**
* @author Guilherme Kraemer
*\file Pedido.java
*
* Classe que representa um pedido de um restaurante
* 
*/

/**
* @author Guilherme Kraemer
* @class public class Pedido
* @brief fornece atributos e métodos para manipular um pedido
*
*/

public class Pedido {
    /**
	 * @var estado - estado atual do pedido
     * @var nomeDoPrato - nome do produto que foi pedido
     * @var valorTotal - preço do produto
     * @var formaDePagamento - modo de pagamento escolhido
	 */
    protected EstadoPedido estado;
    protected String nomeDoPrato;
    protected int valorTotal;
    protected PagamentoCommand formaDePagamento;

    public Pedido(String nomeDoPrato, int valorTotal, PagamentoCommand formaDePagamento) {
        this.nomeDoPrato = nomeDoPrato;
        this.valorTotal = valorTotal;
        this.formaDePagamento = formaDePagamento;
        estado = new PedidoCriado();
    }

    /**
	 * @brief Se estado é PedidoCriado, muda para PedidoPronto, qualquer outro caso não tem efeito
	 * @param void
	 * @return void
	 */
    public void prepararPedido(){
        estado = estado.prepararPedido();
    }

    /**
	 * @brief Se estado é PedidoPronto, muda para PedidoEntregue, qualquer outro caso não tem efeito
	 * @param void
	 * @return void
	 */
    public void entregarPedido(){
        estado = estado.entregarPedido();
    }

    /**
	 * @brief Se estado é PedidoEntregue, muda para PedidoPago, qualquer outro caso não tem efeito
	 * @param void
	 * @return void
	 */
    public void receberPagamento(){
        estado = estado.receberPagamento(valorTotal, formaDePagamento);
    }

    /**
	 * @brief retorna o estado atual do pedido
	 * @param void
	 * @return EstadoPedido
	 */
    public EstadoPedido getEstado() {
        return estado;
    }  
}
