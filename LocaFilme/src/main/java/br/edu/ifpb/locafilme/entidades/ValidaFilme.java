/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.locafilme.entidades;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author laerton
 */
public class ValidaFilme {
    
    public static boolean validaTamanhoTitulo(String titulo) throws Exception{
        if (titulo.length() > 50){
            throw  new Exception("Filme não pode conter mais que 50 caracteres.");
        }
        return true;
    }
    
    public static boolean validaGenero(Genero genero)throws Exception{
        if (genero == null){
            throw  new Exception("Genero é obrigatório.");
        }
        return true;
    }
    
    public static boolean validaDuracao(int duracao) throws Exception{
        if (duracao <= 0){
            throw  new Exception("Duração do filme não pode ser menor ou igual a zero.");
        }
        return true;
    }
    
    public static boolean validaTitulo(String nome) throws Exception{
        Pattern valido = Pattern.compile("^[a-zA-Z0-9!#?]*$");
        Matcher m = valido.matcher(nome);
        if (!m.matches()){
            throw new Exception("O título do filme não pode conter caracteres especiais.");
        }
        return true;
    }
    
    
}
