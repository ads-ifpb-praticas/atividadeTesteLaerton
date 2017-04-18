/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Integracao;

import br.edu.ifpb.locafilme.entidades.Filme;
import br.edu.ifpb.locafilme.entidades.FilmeControler;
import br.edu.ifpb.locafilme.entidades.Genero;
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
public class testIntegracao {
    private static FilmeControler controler;
    private static Filme f1;
    private static Filme f2;
    
    public testIntegracao() {
    }
    
    
    
    @Before
    public void setUp() {
        controler = new FilmeControler();
        //Criando filmes para validação
        f1 = new Filme(1, "Indiana Jones e o templo da perdição.", Genero.AVENTURA, 120);
        f2 = new Filme(2, "Drogas? Tô fora!", Genero.DRAMA, 120);
    
    }
    
    @Test
    public void testCadastraFilme(){
        
        try {
            controler.cadastraFilme(f1);
        } catch (Exception ex) {
            Logger.getLogger(testIntegracao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
