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
public enum Genero 
{
    AVENTURA (0), AÇÃO (1), SUSPENSE (2), COMEDIA(3), ROMANCE(4), DRAMA(5), INFANTIL(6), NACIONAL(7);
    
    private int valor;
    
    Genero (int valor){
        this.valor = valor;
    }
    
    public int getValor(){
        return this.valor;
    }
    public static Genero ValueBy(int id){
        switch (id){
            case 0:
                return AVENTURA;
            case 1:
                return AÇÃO;
            case 2:
                return SUSPENSE;
            case 3:
                return COMEDIA;
            case 4:
                return ROMANCE;
            case 5:
                return DRAMA;
            case 6:
                return INFANTIL;
            case 7:
                return NACIONAL;
            default:
                return null;
        }
    }
    
    public Genero getById(int id){
        return Genero.values()[id];
    }       
}
