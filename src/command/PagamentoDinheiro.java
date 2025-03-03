package command;

import application.Leitor;
import chainOfResponsability.*;

/**
* @author Guilherme Kraemer
*\file PagamentoDinheiro.java
*
* Classe que representa um modo de pagamento
* 
*/

/**
* @author Guilherme Kraemer
* @class public class PagamentoDinheiro
* @brief Implementa o método usado para processar o pagamento do modo Credito
*/

public class PagamentoDinheiro implements PagamentoCommand {

    public PagamentoDinheiro() {
    }

    /**
	 * @var Montante - valor a ser cobrado
     * @var flag - variável usada para controlar o loop while
     * @var M1 - representa o caixa do restaurante
     * @var C1 - representa uma moeda de 1 real
     * @var C2 - cédula 2 reais
     * @var C3 - cédula 5 reais
     * @var C4 - cédula 10 reais
     * @var C5 - cédula 20 reais
     * @var C6 - cédula 50 reais
     * @var C7 - cédula 100 reais
     * @var temp - variável que recebe a leitura do teclado
	 */

     /**
	 * @brief Método usado para processar pagamentos em dinheiro
	 * @param int
	 * @return void
	 */
    @Override
    public void processarPagamento(int valor) {
        
        int Montante = valor, flag = 0;
        Caixa M1 = new Caixa();
        UmR C1 = new UmR();
        DoisR C2 = new DoisR(C1);
        CincoR C3 = new CincoR(C2);
        DezR C4 = new DezR(C3);
        VinteR C5 = new VinteR(C4);
        CinquentaR C6 = new CinquentaR(C5);
        CemR C7 = new CemR(C6);
        int temp = 0;

        while(flag == 0){
            
            System.out.println("A conta é de R$" + String.valueOf(Montante) + ",00. Digite o valor do pagamento para cálculo do troco:\n");
            
            temp = Leitor.lerInt();

            if(temp < Montante){

                System.out.println("Valor insuficiente!\n");

            } else if(temp == Montante) {

                System.out.println("Pagamento efetuado com sucesso!\n");
                flag = 1;
                break;

            } else {

                System.out.println("Pagamento efetuado com sucesso! Seu troco é de R$" + String.valueOf(temp-Montante) + ",00.\n");
                M1.contador((temp-Montante), C7);
                flag = 1;

            }
        }
    }  
}
