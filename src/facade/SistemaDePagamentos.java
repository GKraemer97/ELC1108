package facade;

import command.PagamentoCartaoCredito;
import command.PagamentoCartaoDebito;
import command.PagamentoDinheiro;

/**
* @author Guilherme Kraemer
*\file SistemaDePagamentos.java
*
* Classe que representa uma fachada para o subsistema de pagamentos
* 
*/

/**
* @author Guilherme Kraemer
* @class public class SistemaDePagamentos
* @brief Implementa método para inicializar os modos de pagamento e getters para
* obter as instâncias dos modos de pagamento 
*/

public class SistemaDePagamentos {
    /**
	 * @var p1 - instância do modo Credito
     * @var p2 - instância do modo Debito
     * @var p3 - instância do modo Dinheiro
	 */
    protected PagamentoCartaoCredito p1;
    protected PagamentoCartaoDebito p2;
    protected PagamentoDinheiro p3;

    public SistemaDePagamentos() {
    }

    public void configurarPagamentos(){

        p1 = new PagamentoCartaoCredito();
        p2 = new PagamentoCartaoDebito();
        p3 = new PagamentoDinheiro();

    }

    public PagamentoCartaoCredito getCredito() {
        return p1;
    }

    public PagamentoCartaoDebito getDebito() {
        return p2;
    }

    public PagamentoDinheiro getDinheiro() {
        return p3;
    }
    
}
