/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.Query;
import javax.persistence.Table;

/**
 *
 * @author hasmy
 */
@Entity
@Table(name = "pitcher")
public class Pitcher implements Serializable{
    
    @Id
    private int playerID;
    private int wins;
    private int losses;
    private double earnedRunAverage;
    private int games;
    private int gamesStarted;
    private int saves;
    private int saveOpp;
    private double inningsPitched;
    private int hits;
    private int runs;
    private int earnedRuns;
    private int homeRuns;
    private int baseOnBalls;
    private int hitBatters;
    private int strikeOuts;
    private double oppAvg;
    private double WHIP;
    
    
    public Pitcher()
    {
        
    }
    
    public Pitcher(int ID)   
    {
        playerID = ID;
        wins = 0;
        losses = 0;
        earnedRunAverage = 0.0;
        games = 0;
        gamesStarted = 0;
        saves = 0;
        saveOpp = 0;
        inningsPitched = 0.0;
        hits = 0;
        runs = 0;
        earnedRuns = 0;
        homeRuns = 0;
        baseOnBalls = 0;
        hitBatters = 0;
        strikeOuts = 0;
        oppAvg = 0.000;
        WHIP = 0.000;   
    }
    
    
    public void updatePitcher(int inWins, int inLosses, int inGames, int inGS, int inSave, int inSaveOpp, double inningsPitched,
            int inHits, int inRuns, int inER, int inHR, int inBB, int inHBP, int inSO)
    {
        updateWins(inWins);
        updateLosses(inLosses);
        updateGames(inGames);
        updateGamesStarted(inGS);
        updateSaves(inSave);
        updateSaveOpp(inSaveOpp);
        updateInningsPitched(inningsPitched);
        updateHits(inHits);
        updateRuns(inRuns);
        updateEarnedRuns(inER);
        updateHomeruns(inHR);
        updateBaseOnBalls(inBB);
        updateHitBatters(inHBP);
        updateStrikeOuts(inSO);
        updateERA();
        updateWHIP(); 
        updateOppAvg();
        
    }
    
    public static Pitcher loadPitcherData(int inPlayerID)
    {
        //int AB, int H, int B2, int B3, int HR, int BB, int HBP, int Sac, int SO, int CS, int SB)
        EntityManager em = Data.DBUtil.getEM();
        Query AB = em.createNativeQuery("SELECT a.atbats FROM hitter a WHERE a.playerID=?");
        AB.setParameter(1,inPlayerID);
        int inAB = (int)AB.getSingleResult();
       
        Query H = em.createNativeQuery("SELECT a.hits FROM hitter a WHERE a.playerID=?");
        H.setParameter(1,inPlayerID);
        int inH = (int)H.getSingleResult();
        
        Query B2 = em.createNativeQuery("SELECT a.doublehit FROM hitter a WHERE a.playerID=?");
        B2.setParameter(1,inPlayerID);
        int inB2 = (int)H.getSingleResult();

        Query B3 = em.createNativeQuery("SELECT a.triplehit FROM hitter a WHERE a.playerID=?");
        B3.setParameter(1,inPlayerID);
        int inB3 = (int)B3.getSingleResult();        

        Query HR = em.createNativeQuery("SELECT a.homeruns FROM hitter a WHERE a.playerID=?");
        HR.setParameter(1,inPlayerID);
        int inHR = (int)HR.getSingleResult();      
        
        Query BB = em.createNativeQuery("SELECT a.baseonballs FROM hitter a WHERE a.playerID=?");
        BB.setParameter(1,inPlayerID);
        int inBB = (int)BB.getSingleResult();
        
        Query HBP = em.createNativeQuery("SELECT a.hitbypitch FROM hitter a WHERE a.playerID=?");
        HBP.setParameter(1,inPlayerID);
        int inHBP = (int)HBP.getSingleResult();
        
        Query Sac = em.createNativeQuery("SELECT a.sacfly FROM hitter a WHERE a.playerID=?");
        Sac.setParameter(1,inPlayerID);
        int inSac = (int)Sac.getSingleResult();
        
        Query SO = em.createNativeQuery("SELECT a.strikeouts FROM hitter a WHERE a.playerID=?");
        SO.setParameter(1,inPlayerID);
        int inSO = (int)SO.getSingleResult();
        
        Query CS = em.createNativeQuery("SELECT a.caughtstealing FROM hitter a WHERE a.playerID=?");
        CS.setParameter(1,inPlayerID);
        int inCS = (int)CS.getSingleResult();
        
        Query SB = em.createNativeQuery("SELECT a.stolenbases FROM hitter a WHERE a.playerID=?");
        SB.setParameter(1,inPlayerID);
        int inSB = (int)SB.getSingleResult();
        
        Pitcher returnPitcher = new Pitcher(inPlayerID);
        //returnHitter.updateHitter(inAB, inH, inB2, inB3, inHR, inBB, inHBP, inSac, inSO, inCS, inSB);
        
        return returnPitcher;
    }
    
    public int getWins()
    {
        return wins;
    }
    
    public void updateWins(int inWins)
    {
        wins += inWins;
    }
    
    public int getLosses()
    {
        return losses;
    }
    
    public void updateLosses(int inLoss)
    {
        losses += inLoss;
    }
    
    public double getERA()
    {
        return earnedRunAverage;
    }
    
    public void updateERA()
    {
        double totalInnings = trueInnings(); 
        
        earnedRunAverage = (earnedRuns * 9)/(totalInnings);       
    }
    
    public int getGames()
    {
        return games;
    }
    
    public void updateGames(int inGames)
    {
        games += inGames;
    }
    
    public int getGamesStarted()
    {
        return gamesStarted;
    }
    
    public void updateGamesStarted(int inStarts)
    {
        gamesStarted += inStarts;
    }
    
    public int getSaves()
    {
        return saves;
    }
    
    public void updateSaves(int inSave)
    {
        saves += inSave;
    }
    
    public int getSaveOpp()
    {
        return saveOpp;
    }
    
    public void updateSaveOpp(int inSaveOpp)
    {
        saveOpp += inSaveOpp;
    }
    
    public double getInningsPitched()
    {
        return inningsPitched;
    }
    
    public void updateInningsPitched(double inInnings)
    {
        inningsPitched += inInnings;
        double remainder = inningsPitched - (int)inningsPitched;
        while(remainder >= 0.28)
        {
            remainder = remainder - 0.3;
            inningsPitched = inningsPitched + 1;
            inningsPitched = inningsPitched - 0.3;
        }
            
    }
    
    public int getHits()
    {
        return hits;
    }
    
    public void updateHits(int inHits)
    {
        hits += inHits;
    }
    
    public int getRuns()
    {
        return runs;
    }
    
    public void updateRuns(int inRuns)
    {
        runs += inRuns;
    }
    
    public int getEarnedruns()
    {
        return earnedRuns;
    }
    
    public void updateEarnedRuns(int inEarnedRuns)
    {
        earnedRuns += inEarnedRuns;
    }
    
    public int getHomeruns()
    {
        return homeRuns;
    }
    
    public void updateHomeruns(int inHR)
    {
        homeRuns += inHR;
    }
    
    public int getBaseonBalls()
    {
        return baseOnBalls;
    }
           
    public void updateBaseOnBalls(int inBB)
    {
        baseOnBalls += inBB;
    }
    
    public int getHitBatters()
    {
        return hitBatters; 
    }
    
    public void updateHitBatters(int inHitBatters)
    {
        hitBatters += inHitBatters;
    }
    
    public int getStrikeOuts()
    {
        return strikeOuts;
    }
    
    public void updateStrikeOuts(int inStrikeOuts)
    {
        strikeOuts += inStrikeOuts; 
    }
    
    public double getOppAvg()
    {
        return oppAvg; 
    }
    
    public void updateOppAvg()
    {
        oppAvg = (hits)/totalAtBats(); 
    }
    
    public double getWHIP()
    {
        return WHIP;
    }
    
    public void updateWHIP()
    {
        WHIP = (hits+baseOnBalls)/trueInnings();
    }
    
    private double trueInnings()
    {
        double trueInnings;
        double partialInning;
        int totalInnings = (int)inningsPitched; 
        
        partialInning = inningsPitched - (int)inningsPitched;
        
        if (partialInning > 0 && partialInning <= .1 )
        {
            partialInning = 1.0/3.0;
        }
        else if(partialInning > .1 && partialInning <= .2 )
        {
            partialInning = 2.0/3.0;
        }
        else
            partialInning = 0;
        
        trueInnings = totalInnings + partialInning;
        
        return trueInnings; 
    }
    
    private double totalAtBats()
    {
        double totalAB;
        
        totalAB = hits + (trueInnings() * 3);
        
        return totalAB;
    }
}
