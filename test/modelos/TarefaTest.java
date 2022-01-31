
package modelos;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author spart
 */
public class TarefaTest {
    
    public TarefaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

     /**
     * Test of getTitulo method, of class Tarefa.
     */
    @Test
    public void testGetTitulo() {
        System.out.println("getTitulo");
        Tarefa instance = new Tarefa();
        String expResult = "";
        String result = instance.getTitulo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTitulo method, of class Tarefa.
     */
    @Test
    public void testSetTitulo() {
        System.out.println("setTitulo");
        String titulo = "";
        Tarefa instance = new Tarefa();
        instance.setTitulo(titulo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescricao method, of class Tarefa.
     */
    @Test
    public void testGetDescricao() {
        System.out.println("getDescricao");
        Tarefa instance = new Tarefa();
        String expResult = "";
        String result = instance.getDescricao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescricao method, of class Tarefa.
     */
    @Test
    public void testSetDescricao() {
        System.out.println("setDescricao");
        String descricao = "";
        Tarefa instance = new Tarefa();
        instance.setDescricao(descricao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDeadline method, of class Tarefa.
     */
    @Test
    public void testGetDeadline() {
        System.out.println("getDeadline");
        Tarefa instance = new Tarefa();
        Date expResult = null;
        Date result = instance.getDeadline();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDeadeline method, of class Tarefa.
     */
    @Test
    public void testSetDeadeline() {
        System.out.println("setDeadeline");
        Date deadline = null;
        Tarefa instance = new Tarefa();
        instance.setDeadline(deadline);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdResponsavel method, of class Tarefa.
     */
    @Test
    public void testGetResponsavel() {
        System.out.println("getIdResponsavel");
        Tarefa instance = new Tarefa();
        Pessoa expResult = null;
        Pessoa result = instance.getResponsavel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdResponsavel method, of class Tarefa.
     */
    @Test
    public void testSetResponsavel() {
        System.out.println("setIdResponsavel");
        Pessoa idResponsavel = null;
        Tarefa instance = new Tarefa();
        instance.setResponsavel(idResponsavel);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
