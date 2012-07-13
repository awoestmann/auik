package de.bielefeld.umweltamt.aui.mappings.generated.vaws;
// Generated 13.07.2012 16:41:05 by Hibernate Tools 3.3.0.GA


import de.bielefeld.umweltamt.aui.mappings.generated.basis.BasisBetreiber;
import java.util.HashSet;
import java.util.Set;

/**
 * VawsWirtschaftszweige generated by hbm2java
 */
public abstract class AbstractVawsWirtschaftszweige  implements java.io.Serializable {


     private int id;
     private String wirtschaftszweig;
     private Set<BasisBetreiber> basisBetreibers = new HashSet<BasisBetreiber>(0);

    public AbstractVawsWirtschaftszweige() {
    }

	
    public AbstractVawsWirtschaftszweige(int id) {
        this.id = id;
    }
    public AbstractVawsWirtschaftszweige(int id, String wirtschaftszweig, Set<BasisBetreiber> basisBetreibers) {
       this.id = id;
       this.wirtschaftszweig = wirtschaftszweig;
       this.basisBetreibers = basisBetreibers;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getWirtschaftszweig() {
        return this.wirtschaftszweig;
    }
    
    public void setWirtschaftszweig(String wirtschaftszweig) {
        this.wirtschaftszweig = wirtschaftszweig;
    }
    public Set<BasisBetreiber> getBasisBetreibers() {
        return this.basisBetreibers;
    }
    
    public void setBasisBetreibers(Set<BasisBetreiber> basisBetreibers) {
        this.basisBetreibers = basisBetreibers;
    }




}

