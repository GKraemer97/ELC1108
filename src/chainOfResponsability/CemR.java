package chainOfResponsability;

/**
* @author Guilherme Kraemer
*\file CemR.java
*
* Classe que representa uma cédula de dinheiro
* 
*/

/**
* @author Guilherme Kraemer
* @class public class CemR
* @brief Implementa o método usado para escolher as cédulas do troco
*/

public class CemR implements Slots {
    /**
	 * @var sucessor - indica a cédula de maior valor abaixo da atual
     * @var valor - representa o valor da cédula atual
	 */
    private Slots sucessor;
    public final int valor = 100;

    public CemR(Slots suc) {
        this.sucessor = suc;
    }

    /**
	 * @brief Método usado para escolher as cédulas do troco
	 * @param int 
	 * @return int 
	 */
    @Override
    public int fornecerTroco(int valor) {
        if(valor < this.valor){

            return sucessor.fornecerTroco(valor);

        } else if(valor == this.valor) {
            System.out.println("Cédula de R$" + String.valueOf(this.valor) + ",00\n");
            return this.valor;

        } else {
            System.out.println("Cédula de R$" + String.valueOf(this.valor) + ",00\n");
            return (this.valor + sucessor.fornecerTroco(valor - this.valor));

        }
    }
}
