/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.locafilme.entidades;

import java.time.LocalDate;

/**
 * Classe que trata-se de um filme 
 * @author laerton
 */
public class Filme 
{
    private int id;
    private String nome;
    private Genero genero;
    private int duracao;
    private StatusFilme status;

    private LocalDate dataUltimoEmprestimo;
    private LocalDate dataDevolvucao;

    
    /***
     * Cria um filme em branco.
     */
    public Filme() {
        duracao =  0;
        status = StatusFilme.DISPONIVEL;
    }

    /***
     * Controi um objeto filme com os dados repassados nos parametros
     * @param id - Id do filme
     * @param nome - Nome do filme 
     * @param genero - Genero do filme 
     * @param duracao  - Duração do filme 
     */
    public Filme(int id, String nome, Genero genero, int duracao) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.duracao = duracao;
        status = StatusFilme.DISPONIVEL;
    }

    public LocalDate getDataDevolvucao() {
        return dataDevolvucao;
    }

    public void setDataDevolvucao(LocalDate dataDevolvucao) {
        this.dataDevolvucao = dataDevolvucao;
    }

    public LocalDate getDataUltimoEmprestimo() {
        return dataUltimoEmprestimo;
    }

    public void setDataUltimoEmprestimo(LocalDate dataUltimoEmprestimo) {
        this.dataUltimoEmprestimo = dataUltimoEmprestimo;
    }
    
    public StatusFilme getStatus() {
        return status;
    }

    public void setStatus(StatusFilme status) {
        this.status = status;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    @Override
    public String toString() {
        return "Filme{" + "id=" + id + ", nome=" + nome + ", genero=" + genero + ", duracao=" + duracao + ", status=" + status + '}';
    }
    
    
    
}
