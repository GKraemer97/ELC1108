package chainOfResponsability;

/**
* @author Guilherme Kraemer
*\file UmR.java
*
* Classe que representa uma cédula de dinheiro
* 
*/

/**
* @author Guilherme Kraemer
* @class public class UmR
* @brief Implementa o método usado para escolher as cédulas do troco
*/

public class UmR implements Slots {
    public final int valor = 1;

    public UmR() {
    }

    @Override
    public int fornecerTroco(int valor) {
        if(valor < this.valor){

            System.out.println("Erro no troco!\n");
            return 0;

        } else if(valor == this.valor) {
            System.out.println("Moeda de R$" + String.valueOf(this.valor) + ",00\n");
            return this.valor;

        } else {
            System.out.println("Moeda de R$" + String.valueOf(this.valor) + ",00\n");
            return (this.valor + fornecerTroco(valor - this.valor));

        }
    }
}
