package de.bielefeld.umweltamt.aui.mappings.generated.vaws;
// Generated 13.07.2012 16:41:05 by Hibernate Tools 3.3.0.GA



/**
 * VawsPruefer generated by hbm2java
 */
public abstract class AbstractVawsPruefer  implements java.io.Serializable {


     private int id;
     private String pruefer;

    public AbstractVawsPruefer() {
    }

	
    public AbstractVawsPruefer(int id) {
        this.id = id;
    }
    public AbstractVawsPruefer(int id, String pruefer) {
       this.id = id;
       this.pruefer = pruefer;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getPruefer() {
        return this.pruefer;
    }
    
    public void setPruefer(String pruefer) {
        this.pruefer = pruefer;
    }




}

