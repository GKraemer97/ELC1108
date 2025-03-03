package command;

/**
* @author Guilherme Kraemer
*\file PagamentoCommand.java
*
* Interface que define o método que processa o pagamento
* 
*/

/**
* @author Guilherme Kraemer
* @class public interface PagamentoCommand
* @brief Declara o header do método que processa o pagamento
*/

public interface PagamentoCommand {

    public void processarPagamento(int valor);
    
}
