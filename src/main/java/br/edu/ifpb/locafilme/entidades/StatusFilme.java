/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.locafilme.entidades;

/**
 * Define o Status do filme
 * @author laerton
 */
public enum StatusFilme {
    LOCADO(0), DISPONIVEL(1);

    static StatusFilme ValueBy(int aInt) {
        switch (aInt){
            case(0):
                return LOCADO;
            case(1):
                return DISPONIVEL;
            default:
                return null;
        }
                
    }
    private final int valor;
    
    StatusFilme(int valor){
        this.valor = valor;
    }
    
    public int getValor(){
        return valor;
    }
    
}
