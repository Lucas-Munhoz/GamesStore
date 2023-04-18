//Lucas Andre Munhoz da Cruz
//Joao Victor Viera dos Anjos
//Matheus Augusto da Cruz Grossi
//RA 2418312
//RA 2311500
//RA 2348110
//JDK 18.0.1.1
//Netbeans 15

package gamesstoreapp;

public class Usuario {
    private int cpf;
    private String nome;
    private String sobrenome;
    private String login;
    private String senha;
    private Boolean adm;
    
    public Endereco endereco;
	
    public Usuario() {
        endereco = new Endereco();
    }
        
    public int getCpf(){
        return cpf;
    }
    public void setCpf(int cpf){
        this.cpf = cpf;
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getSobrenome(){
        return sobrenome;
    }
    public void setSobrenome(String sobrenome){
        this.sobrenome = sobrenome;
    }
    public String getLogin(){
        return login;
    }
    public void setLogin(String login){
        this.login = login;
    }
    public String getSenha(){
        return senha;
    }
    public void setSenha(String senha){
        this.senha = senha;
    }
    public Boolean getAdm(){
        return adm;
    }
    public void setAdm(Boolean adm){
        this.adm = adm;
    }
}
