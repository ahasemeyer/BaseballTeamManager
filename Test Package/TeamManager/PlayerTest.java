
package TeamManager;

import Data.*;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;


public class PlayerTest {
    private static final boolean DEBUG = false;
    
    
    @Test
    public void playerTest()
    {
        Player test = Data.DBUtil.createPlayer("Bob", "Ross", "P", 42, 'R', 'S', 0);
        //assertNotNull(test); 

    }
    
    
    @Test 
    public void hitterTest()
    {
        Player testie = Data.DBUtil.createPlayer("Dwayne", "Johnson", "Rock", 99, 'L', 'L', 0);
        Hitter hTestie = new Hitter(testie.getPlayerID());
        
        hTestie.updateHitter(743, 233, 30, 3, 17, 80, 4, 15, 150, 15, 20);
        Data.DBUtil.updateHitter(hTestie);
        
        hTestie.updateHitter(120, 5, 1, 0, 4, 15, 2, 10, 33, 1, 30);
        Data.DBUtil.updateHitter(hTestie);
        
        Hitter lookUp = Data.Hitter.loadHitterData(hTestie.getPlayerID());
        
        lookUp.printStats();
    }
    
    
    @Test
    public void pitcherTest()
    {
        Player testie = Data.DBUtil.createPlayer("Sonny", "Gray", "P", 23, 'R', 'R', 0);
        Pitcher pTestie = new Pitcher(testie.getPlayerID());
        
        pTestie.updatePitcher(10, 2, 12, 5, 0, 0, 20.2, 30, 5, 5, 1, 8, 2, 10);
        pTestie.updatePitcher(10, 2, 12, 5, 0, 0, 20.2, 30, 5, 5, 1, 8, 2, 10);
        pTestie.updatePitcher(10, 2, 12, 5, 0, 0, 20.2, 30, 5, 5, 1, 8, 2, 10);
        pTestie.updatePitcher(10, 2, 12, 5, 0, 0, 20.2, 30, 5, 5, 1, 8, 2, 10);
        pTestie.updatePitcher(10, 2, 12, 5, 0, 0, 50.9, 30, 5, 5, 1, 8, 2, 10);
        
        Data.DBUtil.updatePitcher(pTestie);
        
        Pitcher lookUpP = Data.Pitcher.loadPitcherData(pTestie.getPlayerID());
        lookUpP.printStats();
        
    }
    
    
    
    @Test
    public void teamTest()
    {
        Team tTest = Data.DBUtil.createTeam("Cunder Thunts");
        tTest.updateTeam(15, 2, 2);
        Data.DBUtil.updateTeam(tTest);  
    }
    
    
    @Test
    public void managerTest()
    {
        Player testie = Data.DBUtil.createPlayer("Bob", "Melvin", "M", 12, 'R', 'R', 0);
        Manager mTestie = Data.DBUtil.createManager(testie.getPlayerID());
        
        //Manager with team test
        Team tTest = Data.DBUtil.createTeam("Alaskan Snow Dragons");
        Player testie1 = Data.DBUtil.createPlayer("George", "Manfred", "M", 21, 'L', 'S', tTest.getTeamID());
        Manager mtTestie = Data.DBUtil.createManager(testie1.getPlayerID(), tTest.getTeamID());
        
        Player testie2 = Data.DBUtil.createPlayer("Uncle", "Phil", "M", 1738, 'B', 'S', tTest.getTeamID());
        Manager mtTestie1 = Data.DBUtil.createManager(testie2.getPlayerID(), tTest.getTeamID());
        
        mtTestie1.updateManager(102, 40, 1);
        Data.DBUtil.updateManager(mtTestie1);
        
        mtTestie.updateManager(87, 65, 3);
        Data.DBUtil.updateManager(mtTestie);
        
        System.out.println("Print Created Manager");
        mtTestie.printStats(); 
        
        Manager cTest = Data.Manager.loadManager(mtTestie.getPlayerID()); 
        System.out.println("Loaded Manager");
        cTest.printStats(); 
        
        System.out.println("Print Created Manager");
        mtTestie1.printStats(); 
        
        Manager cTest1 = Data.Manager.loadManager(mtTestie1.getPlayerID()); 
        System.out.println("Loaded Manager");
        cTest1.printStats(); 
    }

}
