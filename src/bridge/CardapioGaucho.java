package bridge;

import java.util.ArrayList;

/**
* @author Guilherme Kraemer
*\file CardapioGaucho.java
*
* Implementa a interface Cardapio
*/

/**
* @author Guilherme Kraemer
* @class public class CardapioGaucho 
* @brief Classe utiliza um ArrayList para armazenar objetos do tipo Produto. Implementa os métodos da
* interface 
*/

public class CardapioGaucho implements Cardapio {
    /**
	 * @var produtos - instancia de um ArrayList, usado para armazenar objetos da classe Produto
	 */
    public ArrayList<Produto> produtos = new ArrayList<Produto>();

    public CardapioGaucho() {
    }

    /**
	 * @brief Método usado para printar informações de cada produto presente no Cardapio
	 * @param void
	 * @return void
	 */
    @Override
    public void mostrarCardapio() {
        for(int i = 0; i < produtos.size(); i++){
            System.out.println(produtos.get(i).nome + "(R$" + String.valueOf(produtos.get(i).preco) + ",00)\n");
        }
    }

    /**
	 * @brief Método usado para adicionar produtos ao Cardapio
	 * @param void
	 * @return void
	 */
    @Override
    public void adicionarItem(String nome, int preco) {
        produtos.add(new Produto(nome, preco));
    }

    /**
	 * @brief Método usado para excluir todos os elementos do Cardapio
	 * @param void
	 * @return void
	 */
    @Override
    public void eliminarCardapio() {
        produtos.clear();
    }

    /**
	 * @brief Método usado para obter a quantidade de elementos no Cardapio
	 * @param void
	 * @return int
	 */
    public int tamanhoCardapio(){
        return produtos.size();
    }

    /**
	 * @brief Método usado obter o Cardapio
	 * @param void
	 * @return Produto
	 */
    public Produto getProdutos(int index) {
        return produtos.get(index);
    }

}
