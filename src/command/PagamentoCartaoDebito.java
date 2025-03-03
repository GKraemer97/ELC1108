package command;

/**
* @author Guilherme Kraemer
*\file PagamentoCartaoDebito.java
*
* Classe que representa um modo de pagamento
* 
*/

/**
* @author Guilherme Kraemer
* @class public class PagamentoCartaoDebito
* @brief Implementa o método usado para processar o pagamento do modo Debito
*/

public class PagamentoCartaoDebito implements PagamentoCommand {

    public PagamentoCartaoDebito() {
    }

    @Override
    public void processarPagamento(int valor) {
        System.out.println("Pagamento de R$" + String.valueOf(valor) + ",00 reais efetuado com cartão de débito!\n");
    }
    
}
