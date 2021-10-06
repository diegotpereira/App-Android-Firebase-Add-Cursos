package br.java.app_android_firebaseusuario.datamodels;

public class Usuario {

    private String nome;
    private String uID;

    public Usuario() {
    }

    public Usuario(String nome, String uID) {
        this.nome = nome;
        this.uID = uID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getuID() {
        return uID;
    }

    public void setuID(String uID) {
        this.uID = uID;
    }
}
