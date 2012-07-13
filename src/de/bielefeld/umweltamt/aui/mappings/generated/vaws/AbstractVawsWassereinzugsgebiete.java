package de.bielefeld.umweltamt.aui.mappings.generated.vaws;
// Generated 13.07.2012 16:41:05 by Hibernate Tools 3.3.0.GA


import de.bielefeld.umweltamt.aui.mappings.generated.basis.BasisStandort;
import java.util.HashSet;
import java.util.Set;

/**
 * VawsWassereinzugsgebiete generated by hbm2java
 */
public abstract class AbstractVawsWassereinzugsgebiete  implements java.io.Serializable {


     private int id;
     private String ezgbname;
     private Set<BasisStandort> basisStandorts = new HashSet<BasisStandort>(0);

    public AbstractVawsWassereinzugsgebiete() {
    }

	
    public AbstractVawsWassereinzugsgebiete(int id) {
        this.id = id;
    }
    public AbstractVawsWassereinzugsgebiete(int id, String ezgbname, Set<BasisStandort> basisStandorts) {
       this.id = id;
       this.ezgbname = ezgbname;
       this.basisStandorts = basisStandorts;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getEzgbname() {
        return this.ezgbname;
    }
    
    public void setEzgbname(String ezgbname) {
        this.ezgbname = ezgbname;
    }
    public Set<BasisStandort> getBasisStandorts() {
        return this.basisStandorts;
    }
    
    public void setBasisStandorts(Set<BasisStandort> basisStandorts) {
        this.basisStandorts = basisStandorts;
    }




}

