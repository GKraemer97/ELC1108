package chainOfResponsability;

/**
* @author Guilherme Kraemer
*\file Caixa.java
*
* Classe que representa o caixa de um restaurante
* 
*/

/**
* @author Guilherme Kraemer
* @class public class Caixa
* @brief Implementa o método usado para contar o troco
*/
public class Caixa {
    
    /**
	 * @brief Método usado para contar o troco
	 * @param int valor, CemR obj
	 * @return int (valor do troco)
	 */
    public int contador(int valor, CemR obj){
        return obj.fornecerTroco(valor);
    }

}