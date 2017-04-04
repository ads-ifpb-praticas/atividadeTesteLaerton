package br.edu.ifpb.locafilme.entidades;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.edu.ifpb.locafilme.entidades.Filme;
import br.edu.ifpb.locafilme.entidades.FilmeControler;
import br.edu.ifpb.locafilme.entidades.Genero;
import br.edu.ifpb.locafilme.entidades.StatusFilme;
import br.edu.ifpb.locafilme.entidades.ValidaFilme;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author laerton
 */
public class UnitTest {
    
    public UnitTest() {
    }
    private static FilmeControler controler;
    private static Filme f1;
    private static Filme f2;
    private static Filme f3;
    private static Filme f4;
    private static Filme f5;
    private static Filme f6;
    private static Filme f7;
    private static Filme f8;
    
    
    
    @Before
    public void setUp() throws Exception {
            controler = new FilmeControler();
        
        //Criando filmes para validação
        f1 = new Filme(1, "Indiana Jones e o templo da perdição.", Genero.AVENTURA, 120);
        f2 = new Filme(2, "Drogas? Tô fora!", Genero.DRAMA, 120);
        f3 = new Filme(3, "#Sem valor", Genero.COMEDIA, 120);
        f4 = new Filme(4, "Onde está você Scoobydoo?", Genero.INFANTIL, 120);
        f5 = new Filme(5, "Os traalões na serra pelada", Genero.INFANTIL, 0);
        f6 = new Filme(6, "Os traalões na serra pelada", null, 120);
        f7 = new Filme(7, "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", Genero.AÇÃO, 120);
        f6 = new Filme(8, "%%%+", Genero.COMEDIA, 120);
        
        //Cadastrando filmes váidos
        controler.cadastraFilme(f1);
        controler.cadastraFilme(f2);
        controler.cadastraFilme(f3);
    }
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    
    @Test
    public void testEditaFilme(){
        
        f1.setStatus(StatusFilme.LOCADO);
        try {
            controler.merge(f1);
        } catch (Exception ex) {
            assertEquals("", "Filme não pode ser editado.",  ex.getMessage());
        }
        
        f1.setStatus(StatusFilme.DISPONIVEL);
        try {
            controler.merge(f1);
        } catch (Exception ex) {
            assertEquals("", "Filme não pode ser editado.",  ex.getMessage());
        }
        
        
    }
    
    @Test
    public void testValidaDataEmprestimo() {
        String mensagem = null ;
        try {
            controler.locaFilme(f1, LocalDate.parse("2017-01-01"));
        } catch (Exception ex) {
            mensagem = ex.getMessage();
        }
        assertEquals("", "Data inválida.",  mensagem);
        mensagem = null;
        try {
            controler.locaFilme(f1, LocalDate.now());
        } catch (Exception ex) {
            mensagem = ex.getMessage();
        }
        assertNull(mensagem);
    }
    
    @Test
    public void testValidaDevolucao(){
        
        f1.setDataUltimoEmprestimo(LocalDate.parse("2017-03-31"));
        String mensagem = null;
        try {
            controler.devolveFilme(f1, LocalDate.parse("2017-03-10"));
        } catch (Exception ex) {
            mensagem = ex.getMessage();
        }
        assertEquals("", "Data de devolução inválida.",  mensagem);
        
        mensagem = null;
        try {
            controler.devolveFilme(f1, LocalDate.parse("2017-04-01"));
        } catch (Exception ex) {
            mensagem = ex.getMessage();
        }
        
        assertNull(mensagem);
        
    }
    
     @Test
     public void testValidaFilmeGenero ()  
     {
        
        try {
            ValidaFilme.validaGenero(f1.getGenero());
            ValidaFilme.validaGenero(f4.getGenero());
        } catch (Exception ex) {
            assertEquals("", "Genero é obrigatório.", ex.getMessage());
        }
         
    }
     @Test 
     public void testValidaFilmeDuracao()
     {
        try {
            ValidaFilme.validaDuracao(f1.getDuracao());
            ValidaFilme.validaDuracao(f5.getDuracao());
        } catch (Exception ex) {
            assertEquals("","Duração do filme não pode ser menor ou igual a zero." , ex.getMessage());
        }
     }
     
     @Test 
     public void testValidaFilmeTamanhoTitulo()
     {
        try {
            ValidaFilme.validaTamanhoTitulo(f1.getNome());
            ValidaFilme.validaTamanhoTitulo(f7.getNome());
        } catch (Exception ex) {
            assertEquals("", "Filme não pode conter mais que 50 caracteres.", ex.getMessage());
        }
     }
      @Test
      public void testFilmeTamanho() throws Exception{
          assertEquals("", ValidaFilme.validaTamanhoTitulo(f1.getNome()), true);
      }
      @Test 
     public void testValidaFilmeTitulo()
     {
        try {
            ValidaFilme.validaTitulo(f1.getNome());
            ValidaFilme.validaTitulo(f8.getNome());
        } catch (Exception ex) {
            assertEquals("", "O título do filme não pode conter caracteres especiais.", ex.getMessage());
        }
     }
    
     
}
