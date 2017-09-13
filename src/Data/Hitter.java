/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author hasmy
 */
@Entity
@Table(name = "hitter")
@XmlRootElement
@NamedQueries({
//@NamedQuery(name = "Hitter.findById", query = "SELECT u FROM hitter u WHERE u.playerID = :playerID")      
})
public class Hitter implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    private int playerID;
    private int atBats;
    private int hits;
    private int baseOnBalls;
    private int hitByPitch;
    private int doubleHit;
    private int tripleHit;
    private int homeRuns;
    private int sacFly; 
    private int strikeOuts;
    private int stolenBases;
    private int caughtStealing;
    private double stealingPerc;
    private double battingAvg;
    private double slugging;
    private double onBasePerc; 
    private int totalBases; 
    
    public Hitter()
    {
        playerID = 999; 
        atBats = 0;
        hits = 0;
        baseOnBalls = 0;
        hitByPitch = 0;
        doubleHit = 0;
        tripleHit = 0;
        homeRuns = 0;
        sacFly = 0; 
        strikeOuts = 0;
        stolenBases = 0;
        caughtStealing = 0;
        stealingPerc = 0.00;
        battingAvg = 0.00;
        slugging = 0.00;
        onBasePerc = 0.00; 
        totalBases = 0; 
    }
    
    
    public Hitter(int ID)
    {
        playerID = ID;
        atBats = 0;
        hits = 0;
        baseOnBalls = 0;
        hitByPitch = 0;
        doubleHit = 0;
        tripleHit = 0;
        homeRuns = 0;
        sacFly = 0; 
        strikeOuts = 0;
        stolenBases = 0;
        caughtStealing = 0;
        stealingPerc = 0.00;
        battingAvg = 0.00;
        slugging = 0.00;
        onBasePerc = 0.00; 
        totalBases = 0; 
    }
    
    public void updateHitter(int AB, int H, int B2, int B3, int HR, int BB, int HBP, int Sac, int SO, int CS, int SB)
    {
       updateAB(AB);
       updateHits(H);
       updateDoubles(B2);
       updateTriples(B3);
       updateHomeruns(HR);
       updateBB(BB);
       updateHBP(HBP);
       updateSac(Sac);
       updateStrikeouts(SO);
       updateCaughtStealing(CS);
       updateStolenBases(SB);
       updateTotalBases();
       updateAvg();
       updateStealingPerc();
       updateSlugging(); 
       updateOBP(); 
       
       
       
    }
    
    public static Hitter loadHitterData(int inPlayerID)
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
        
        Hitter returnHitter = new Hitter(inPlayerID);
        returnHitter.updateHitter(inAB, inH, inB2, inB3, inHR, inBB, inHBP, inSac, inSO, inCS, inSB);
        
        return returnHitter;    
    }
    
    public int getPlayerID()
    {
        return playerID; 
    }
    
    
    public int getAtBats()
    {
        return atBats; 
    }
    
    public void updateAB(int AB)
    {
        this.atBats += AB; 
    }
    
    public int getHits()
    {
        return hits; 
    }
    
    public void updateHits(int inHits)
    {
        this.hits += inHits; 
    }
    
    public int getBB()
    {
        return baseOnBalls; 
    }
    
    public void updateBB(int walks)
    {
        this.baseOnBalls += walks; 
    }
    
    public int getHBP()
    {
        return hitByPitch; 
    }
    
    public void updateHBP(int HBP)
    {
        this.hitByPitch += HBP; 
    }
    
    public int getDoubles()
    {
        return doubleHit; 
    }
    
    public void updateDoubles(int doublesHit)
    {
        this.doubleHit += doublesHit; 
    }
    
    public int getTriples()
    {
        return tripleHit; 
    }
    
    public void updateTriples(int triples)
    {
        this.tripleHit += triples; 
    }
    
    public int getHomeruns()
    {
        return homeRuns; 
    }
    
    public void updateHomeruns(int homers)
    {
        this.homeRuns += homers; 
    }
    
    public int getStrikeouts()
    {
        return strikeOuts; 
    }
    
    public void updateStrikeouts(int K)
    {
        this.strikeOuts += K; 
    }
    
    public int getStolenBases()
    {
        return stolenBases; 
    }
    
    public void updateStolenBases(int steals)
    {
        this.stolenBases += steals;
    }
    
    public int getCaughtStealing()
    {
        return caughtStealing;
    }
    
    public void updateCaughtStealing(int caught)
    {
        this.caughtStealing += caught;
    }
    
    public double getStealingPerc()
    {
        return stealingPerc; 
    }
    
    public void updateStealingPerc()
    {
        this.stealingPerc = (double)stolenBases/(double)(stolenBases + caughtStealing);
    }
    
    public int getSacFly()
    {
        return sacFly;
    }
    
    public void updateSac(int sac)
    {
        this.sacFly += sac; 
    }
    
    public int getTotalBases()
    {
        return totalBases; 
    }
    
    public void updateTotalBases()
    {
        this.totalBases = hits + (doubleHit * 2) + (tripleHit * 3) + (homeRuns * 4);
    }
    
    public double getBattingAvg()
    {
        return battingAvg;
    }
    
    public void updateAvg()
    {
        if(atBats != 0)
            this.battingAvg = (double)hits/(double)atBats;
    }
    
    public double getSlugging()
    {
        return slugging; 
    }
    
    public void updateSlugging()
    {
        this.slugging = (double)totalBases/(double)atBats;
    }
    
    public double getOBP()
    {
        return onBasePerc; 
    }
    
    public void updateOBP()
    {
        this.onBasePerc = (double)(hits + baseOnBalls + hitByPitch)/(double)(atBats + baseOnBalls + hitByPitch + sacFly);
    }
    
    
    public void printStats()
    {
        System.out.println("AB: "+atBats+" Hits: "+hits+" Walks: "+baseOnBalls+" Strikeouts: "+strikeOuts+" Avg: "+(String.format("%.3f", battingAvg))+
                " Total Bases: "+totalBases+" Doubles: "+doubleHit+" Triples: "+tripleHit+" Homeruns: "+homeRuns+" Slugging: "+(String.format("%.3f", slugging))+
                " OBP: "+(String.format("%.3f", onBasePerc))+" Stolen Base Perc: "+(String.format("%.3f", stealingPerc)));
       
    }
    
}


