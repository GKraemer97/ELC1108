package bridge;

/**
* @author Guilherme Kraemer
*\file Produto.java
*
* Classe que representa um item a ser incluído no Cardapio
*/

/**
* @author Guilherme Kraemer
* @class public class Produto
* @brief Classe fornece atributos para identificar um item do Cardapio, 
* bem como métodos getters e setters para manipulá-los
*/

public class Produto {
    /**
	 * @var nome - nome do produto
     * @var preco - preço do produto
	 */
    public String nome;
    public int preco;
    
    public Produto(String nome, int preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }
    
}
