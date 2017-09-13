package Data;

import javax.persistence.*;
/**
 *
 * @author austin hasemeyer
 */
public class DBUtil {
    
    private static final EntityManagerFactory emf =
        Persistence.createEntityManagerFactory("TeamManagerPU");
    
    
    public static EntityManager getEM()
    {
        return emf.createEntityManager();
    }
    
    public static Player createPlayer()
    {
        try {
            System.out.println("create Player Table start.");
            EntityManager em = getEM();
            em.getTransaction().begin();
            Player h = new Player();
            em.persist(h);
            em.getTransaction().commit();
            em.close();
            System.out.println("create Player Table ended.");
            return h;
        } catch (Exception e){
            System.out.println("Exception in create Player "+e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    
    public static Player createPlayer(String first, String last, String pos)
    {
        try {
            System.out.println("create Player Table start.");
            EntityManager em = getEM();
            em.getTransaction().begin();
            Player h = new Player(first, last, pos);
            em.persist(h);
            em.getTransaction().commit();
            em.close();
            System.out.println("create Player Table ended.");
            return h;
        } catch (Exception e){
            System.out.println("Exception in create Player "+e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
        
        
    public static Hitter createHitter(int playerID)
    {
        try {
            System.out.println("create Hitter Table start.");
            EntityManager em = getEM();
            em.getTransaction().begin();
            Hitter h = new Hitter(playerID);
            em.persist(h);
            em.getTransaction().commit();
            em.close();
            System.out.println("create Hitter Table ended.");
            return h;
        } catch (Exception e){
            System.out.println("Exception in create Hitter "+e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    
    
    public static Hitter updateHitter(Hitter h)
    {
        try {
            System.out.println("Update Hitter start.");
            EntityManager em = getEM();
            em.getTransaction().begin();
            em.merge(h);
            em.getTransaction().commit();
            em.close();
            System.out.println("Update Hitter ended.");
            return h;
        } catch (Exception e){
            System.out.println("Exception in Update Hitter "+e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    
    
    public static Pitcher createPitcher(int playerID)
    {
        try {
            System.out.println("create Pitcher Table start.");
            EntityManager em = getEM();
            em.getTransaction().begin();
            Pitcher p = new Pitcher(playerID);
            em.persist(p);
            em.getTransaction().commit();
            em.close();
            System.out.println("create Pitcher Table ended.");
            return p;
        } catch (Exception e){
            System.out.println("Exception in create Pitcher "+e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    
    
        public static Pitcher updatePitcher(Pitcher p)
    {
        try {
            System.out.println("Update Hitter start.");
            EntityManager em = getEM();
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
            em.close();
            return p;
        } catch (Exception e){
            System.out.println("Exception in Update Hitter "+e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    
}