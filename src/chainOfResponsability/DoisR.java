package chainOfResponsability;

/**
* @author Guilherme Kraemer
*\file DoisR.java
*
* Classe que representa uma cédula de dinheiro
* 
*/

/**
* @author Guilherme Kraemer
* @class public class DoisR
* @brief Implementa o método usado para escolher as cédulas do troco
*/

public class DoisR implements Slots{
    private Slots sucessor;
    public final int valor = 2;

    public DoisR(Slots suc) {
        this.sucessor = suc;
    }

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

