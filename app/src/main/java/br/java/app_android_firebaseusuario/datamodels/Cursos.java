package br.java.app_android_firebaseusuario.datamodels;

public class Cursos {

    private String cursoNome;
    private String cursoDescricao;
    private String cursoDuracao;

    public Cursos() {
    }

    public Cursos(String cursoNome, String cursoDescricao, String cursoDuracao) {
        this.cursoNome = cursoNome;
        this.cursoDescricao = cursoDescricao;
        this.cursoDuracao = cursoDuracao;
    }

    public String getCursoNome() {
        return cursoNome;
    }

    public void setCursoNome(String cursoNome) {
        this.cursoNome = cursoNome;
    }

    public String getCursoDescricao() {
        return cursoDescricao;
    }

    public void setCursoDescricao(String cursoDescricao) {
        this.cursoDescricao = cursoDescricao;
    }

    public String getCursoDuracao() {
        return cursoDuracao;
    }

    public void setCursoDuracao(String cursoDuracao) {
        this.cursoDuracao = cursoDuracao;
    }
}
