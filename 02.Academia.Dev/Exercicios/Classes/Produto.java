public class Produto {
    private String nome;
    private Double preco;
    private String categoria;

    public Produto(String nome, Double preco, String categoria) {
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
    }
    
    public Double getPreco() {
        return preco;
    }
    public String getCategoria() {
        return categoria;
    }
    public String getNome() {
        return nome;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}
