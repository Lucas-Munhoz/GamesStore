//Lucas Andre Munhoz da Cruz
//Joao Victor Viera dos Anjos
//Matheus Augusto da Cruz Grossi
//RA 2418312
//RA 2311500
//RA 2348110
//JDK 18.0.1.1
//Netbeans 15

package gamesstoreapp;

public class Game {
    private int chaveAtivacao;
    private String titulo;
    private String genero;
    private Float tamanho;
    private Float preco;
    private String desenvolvedora;

    public int getChaveAtivacao(){
        return chaveAtivacao;
    }
    public void setChaveAtivacao(int chaveAtivacao){
        this.chaveAtivacao = chaveAtivacao;
    }
    public String getTitulo(){
        return titulo;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public String getGenero(){
        return genero;
    }
    public void setGenero(String genero){
        this.genero = genero;
    }
    public Float getTamanho(){
        return tamanho;
    }
    public void setTamanho(Float tamanho){
        this.tamanho = tamanho;
    }
    public Float getPreco(){
        return preco;
    }
    public void setPreco(Float preco){
        this.preco = preco;
    }
    public String getDesenvolvedora() {
        return desenvolvedora;
    }
    public void setDesenvolvedora(String desenvolvedora) {
        this.desenvolvedora = desenvolvedora;
    }
    public int getIdDesenvolvedora() {
        return idDesenvolvedora;
    }
    public void setIdDesenvolvedora(int idDesenvolvedora) {
        this.idDesenvolvedora = idDesenvolvedora;
    }
    private int idDesenvolvedora;
}
