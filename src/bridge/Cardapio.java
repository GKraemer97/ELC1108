package bridge;

/**
* @author Guilherme Kraemer
*\file Cardapio.java
*
* Interface de um Cardapio para compor a classe Restaurante
*/

/**
* @author Guilherme Kraemer
* @class public interface Cardapio
* @brief Interface com os headers dos métodos para uso de um Cardapio
*/

public interface Cardapio {
    
    public void mostrarCardapio();
    public void adicionarItem(String nome, int preco);
    public void eliminarCardapio();
    public int tamanhoCardapio();
    public Produto getProdutos(int index);
}
