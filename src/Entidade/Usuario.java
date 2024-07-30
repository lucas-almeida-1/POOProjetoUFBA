package Entidade;

public class Usuario {
    private String usernome;
    private String senha;
    private String email;

    public Usuario(String usernome, String senha, String email) {
        this.usernome = usernome;
        this.senha = senha;
        this.email = email;
    }

    public String getUsernome() {
        return usernome;
    }

    public void setUsernome(String usernome) {
        this.usernome = usernome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
