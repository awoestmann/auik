package de.bielefeld.umweltamt.aui.mappings.generated.basis;
// Generated 13.07.2012 16:41:05 by Hibernate Tools 3.3.0.GA



/**
 * BasisStrassen generated by hbm2java
 */
public abstract class AbstractBasisStrassen  implements java.io.Serializable {


     private int id;
     private String strasse;
     private String plz;

    public AbstractBasisStrassen() {
    }

	
    public AbstractBasisStrassen(int id) {
        this.id = id;
    }
    public AbstractBasisStrassen(int id, String strasse, String plz) {
       this.id = id;
       this.strasse = strasse;
       this.plz = plz;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getStrasse() {
        return this.strasse;
    }
    
    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }
    public String getPlz() {
        return this.plz;
    }
    
    public void setPlz(String plz) {
        this.plz = plz;
    }




}

