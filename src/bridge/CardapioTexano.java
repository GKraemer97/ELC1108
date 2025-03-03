package bridge;

import java.util.ArrayList;

/**
* @author Guilherme Kraemer
*\file CardapioTexano.java
*
* Implementa a interface Cardapio
*/

/**
* @author Guilherme Kraemer
*@class public class CardapioTexano 
*@brief Classe utiliza um ArrayList para armazenar objetos do tipo Produto. Implementa os métodos da
* interface 
*/

public class CardapioTexano implements Cardapio {

    public ArrayList<Produto> produtos = new ArrayList<Produto>();

    public CardapioTexano() {
    }

    @Override
    public void mostrarCardapio() {
        for(int i = 0; i < produtos.size(); i++){
            System.out.println(produtos.get(i).nome + "(R$" + String.valueOf(produtos.get(i).preco) + ",00)\n");
        }
    }

    @Override
    public void adicionarItem(String nome, int preco) {
        produtos.add(new Produto(nome, preco));
    }

    @Override
    public void eliminarCardapio() {
        produtos.clear();
    }
    
    public int tamanhoCardapio(){
        return produtos.size();
    }

    public Produto getProdutos(int index) {
        return produtos.get(index);
    }
}
