package de.bielefeld.umweltamt.aui.mappings.generated.atl;
// Generated 13.07.2012 16:41:05 by Hibernate Tools 3.3.0.GA


import java.util.HashSet;
import java.util.Set;

/**
 * AtlProbeart generated by hbm2java
 */
public abstract class AbstractAtlProbeart  implements java.io.Serializable {


     private int id;
     private String art;
     private Set<AtlProbepkt> atlProbepkts = new HashSet<AtlProbepkt>(0);

    public AbstractAtlProbeart() {
    }

	
    public AbstractAtlProbeart(int id, String art) {
        this.id = id;
        this.art = art;
    }
    public AbstractAtlProbeart(int id, String art, Set<AtlProbepkt> atlProbepkts) {
       this.id = id;
       this.art = art;
       this.atlProbepkts = atlProbepkts;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getArt() {
        return this.art;
    }
    
    public void setArt(String art) {
        this.art = art;
    }
    public Set<AtlProbepkt> getAtlProbepkts() {
        return this.atlProbepkts;
    }
    
    public void setAtlProbepkts(Set<AtlProbepkt> atlProbepkts) {
        this.atlProbepkts = atlProbepkts;
    }




}

