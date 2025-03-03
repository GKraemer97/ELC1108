package command;

/**
* @author Guilherme Kraemer
*\file PagamentoCartaoCredito.java
*
* Classe que representa um modo de pagamento
* 
*/

/**
* @author Guilherme Kraemer
* @class public class PagamentoCartaoCredito
* @brief Implementa o método usado para processar o pagamento do modo Credito
*/

public class PagamentoCartaoCredito implements PagamentoCommand {
    
    public PagamentoCartaoCredito() {
    }

    @Override
    public void processarPagamento(int valor) {
        System.out.println("Pagamento de R$" + String.valueOf(valor) + ",00 reais efetuado com cartão de crédito!\n");
    }
    
}
