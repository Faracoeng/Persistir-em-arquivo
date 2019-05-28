package poo;

import java.io.Serializable;

public class Pessoa implements Serializable {
    private String nome;
    private  String email;
    private  double salario;

    public Pessoa (String nome, String email, double salario) {
        this.nome = nome;
        this.email = email;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", salario=" + salario +
                "}\n";
    }
}
