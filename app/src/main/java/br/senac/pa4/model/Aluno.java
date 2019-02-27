package br.senac.pa4.model;

import java.io.Serializable;

public class Aluno implements Serializable {

    private long idAluno;
    private String nome;
    private String telefone;
    private String email;
    private String site;
    private float nota;

    public Aluno(String nome, String telefone, String email, String site, float nota) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.site = site;
        this.nota = nota;
    }

    public Aluno(Long idAluno, String nome, String telefone, String email, String site, float nota) {
        this.idAluno = idAluno;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.site = site;
        this.nota = nota;
    }

    @Override
    public String toString() {
        return  nome;
    }

    public long getIdAluno() {
        return idAluno;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getSite() {
        return site;
    }

    public float getNota() {
        return nota;
    }
}
