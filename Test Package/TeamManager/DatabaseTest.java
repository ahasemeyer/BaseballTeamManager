/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TeamManager;
import javax.persistence.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hasmy
 */
public class DatabaseTest {
    private static final boolean DEBUG = false;
    
    
    @Test
    public void connectionTest(){        
    EntityManager em = null; 
    em = Data.DBUtil.getEM();
    
    assertNotNull(em);
    
    }
    
    
}
