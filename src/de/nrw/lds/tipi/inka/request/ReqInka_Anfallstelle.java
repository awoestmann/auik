/**
 * ReqInka_Anfallstelle.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package de.nrw.lds.tipi.inka.request;

public class ReqInka_Anfallstelle  extends de.nrw.lds.tipi.inka.general.ReqStandard  implements java.io.Serializable {
    private de.nrw.lds.tipi.inka.Inka_Anfallstelle objInka_Anfallstelle;

    public ReqInka_Anfallstelle() {
    }

    public ReqInka_Anfallstelle(
           java.util.Calendar clientTimestamp,
           java.lang.String clientVendor,
           java.lang.String clientVersion,
           java.lang.String kennung,
           java.lang.Integer numberOfObjects,
           java.lang.String password,
           java.lang.Integer startsFromObject,
           de.nrw.lds.tipi.inka.Inka_Anfallstelle objInka_Anfallstelle) {
        super(
            clientTimestamp,
            clientVendor,
            clientVersion,
            kennung,
            numberOfObjects,
            password,
            startsFromObject);
        this.objInka_Anfallstelle = objInka_Anfallstelle;
    }


    /**
     * Gets the objInka_Anfallstelle value for this ReqInka_Anfallstelle.
     * 
     * @return objInka_Anfallstelle
     */
    public de.nrw.lds.tipi.inka.Inka_Anfallstelle getObjInka_Anfallstelle() {
        return objInka_Anfallstelle;
    }


    /**
     * Sets the objInka_Anfallstelle value for this ReqInka_Anfallstelle.
     * 
     * @param objInka_Anfallstelle
     */
    public void setObjInka_Anfallstelle(de.nrw.lds.tipi.inka.Inka_Anfallstelle objInka_Anfallstelle) {
        this.objInka_Anfallstelle = objInka_Anfallstelle;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ReqInka_Anfallstelle)) return false;
        ReqInka_Anfallstelle other = (ReqInka_Anfallstelle) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.objInka_Anfallstelle==null && other.getObjInka_Anfallstelle()==null) || 
             (this.objInka_Anfallstelle!=null &&
              this.objInka_Anfallstelle.equals(other.getObjInka_Anfallstelle())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getObjInka_Anfallstelle() != null) {
            _hashCode += getObjInka_Anfallstelle().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ReqInka_Anfallstelle.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://request.inka.tipi.lds.nrw.de", "ReqInka_Anfallstelle"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("objInka_Anfallstelle");
        elemField.setXmlName(new javax.xml.namespace.QName("", "objInka_Anfallstelle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://inka.tipi.lds.nrw.de", "Inka_Anfallstelle"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
