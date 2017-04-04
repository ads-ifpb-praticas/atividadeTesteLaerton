/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.locafilme.entidades;

/**
 *
 * @author laerton
 */
public class principal 
{
    public static void main(String[] args) {
        Filme  f = new  Filme(1, "A bala que dobrou a esquina.", Genero.AVENTURA, 10);
        PersisteFilme per = new  PersisteFilme();
        per.persiste(f);
        f.setDuracao(110);
        per.merge(f);
        
    }
    
}
