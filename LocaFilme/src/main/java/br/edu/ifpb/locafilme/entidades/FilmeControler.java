/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.locafilme.entidades;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import jdk.nashorn.internal.runtime.regexp.JdkRegExp;
import jdk.nashorn.internal.runtime.regexp.RegExp;

/**
 *
 * @author laerton
 */
public class FilmeControler 
{
    private PersisteFilme em = new PersisteFilme();
    
    public void locaFilme(Filme filme, LocalDate data) throws Exception{
        
        if (filme.getStatus() == StatusFilme.LOCADO){
            throw  new Exception("Filme já locado.");
        }
        
        if (data.compareTo(LocalDate.now())< 0){
            throw  new Exception("Data inválida.");
        }
        
        filme.setDataUltimoEmprestimo(data);
        filme.setStatus(StatusFilme.LOCADO);
        em.merge(filme);
    }
    
    public void devolveFilme(Filme filme, LocalDate data) throws Exception{
        
        if (data.compareTo(filme.getDataUltimoEmprestimo()) < 0){
            throw  new Exception("Data de devolução inválida.");
        }
        
        filme.setDataDevolvucao(data);
        filme.setStatus(StatusFilme.DISPONIVEL);
        
    }
    
    public void merge (Filme filme) throws Exception{
        if (filme.getStatus() == StatusFilme.LOCADO){
            throw  new Exception("Filme não pode ser editado.");
        }
        
    }
    
    public void cadastraFilme(Filme filme ) throws Exception{
       validaFilme(filme);
       em.persiste(filme);
    }
    
    private void validaFilme(Filme filme) throws Exception{
       //ValidaFilme.validaTitulo(filme.getNome());
       ValidaFilme.validaDuracao(filme.getDuracao());
       ValidaFilme.validaGenero(filme.getGenero());
       ValidaFilme.validaTamanhoTitulo(filme.getNome());
       
    }
    
}
