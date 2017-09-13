
package TeamManager;

import Data.*;
import org.junit.Test;


public class PlayerTest {
    private static final boolean DEBUG = false;
    
    @Test
    public void firstNameTest()
    {
        String result = null; 
        
        //assertNotNull(result);
    }
    
    @Test
    public void createAndUpdate()
    {
        Player test = Data.DBUtil.createPlayer("Bob", "Ross", "P");
        Hitter hTest = Data.DBUtil.createHitter(test.getPlayerID());

        hTest.updateAB(20);
        hTest.updateAB(40);
        Data.DBUtil.updateHitter(hTest);
        
        Player testie = Data.DBUtil.createPlayer("Dwayne", "Johnson", "Rock");
        Hitter hTestie = Data.DBUtil.createHitter(testie.getPlayerID());
        Pitcher pTestie = Data.DBUtil.createPitcher(testie.getPlayerID());
        
        //updatePitcher(int inWins, int inLosses, int inGames, int inGS, int inSave, int inSaveOpp, double inningsPitched,
          //  int inHits, int inRuns, int inER, int inHR, int inBB, int inHBP, int inSO)
          
        pTestie.updatePitcher(10, 2, 12, 5, 0, 0, 20.2, 30, 5, 5, 1, 8, 2, 10);
        pTestie.updatePitcher(10, 2, 12, 5, 0, 0, 20.2, 30, 5, 5, 1, 8, 2, 10);
        pTestie.updatePitcher(10, 2, 12, 5, 0, 0, 20.2, 30, 5, 5, 1, 8, 2, 10);
        pTestie.updatePitcher(10, 2, 12, 5, 0, 0, 20.2, 30, 5, 5, 1, 8, 2, 10);
        pTestie.updatePitcher(10, 2, 12, 5, 0, 0, 50.9, 30, 5, 5, 1, 8, 2, 10);

        Data.DBUtil.updatePitcher(pTestie);
          
        hTestie.updateHitter(743, 233, 30, 3, 17, 80, 4, 15, 150, 15, 20);
        Data.DBUtil.updateHitter(hTestie); 
        
        hTestie.updateHitter(120, 5, 1, 0, 4, 15, 2, 10, 33, 1, 30);
        Data.DBUtil.updateHitter(hTestie); 
        
        Hitter lookUp = Data.Hitter.loadHitterData(hTestie.getPlayerID());
        
        lookUp.printStats();

    }
    
    
    @Test 
    public void NewUserTest()
    {
//        Player test = Data.DBUtil.createPlayer();
//        Hitter h1 = Data.DBUtil.createHitter(test.getPlayerID());
//        System.out.println("PlayerID: "+test.getPlayerID());
        
//        Player test2 = Data.DBUtil.createPlayer("Austin", "Hasemeyer", "3B");
//        //Hitter h2 = new Hitter(21);
//        System.out.println(test2.getPlayerID());
    }
    
    
    @Test
    public void updateStats()
    {
        //System.out.print("load SQL test: ");
        //h1.loadSQLData();
        //h1.updateAB(25);
        //Data.DBUtil.updateHitter(h1); 
    }

}
