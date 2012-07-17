/**
 * Copyright 2005-2011, Stadt Bielefeld
 *
 * This file is part of AUIK (Anlagen- und Indirekteinleiter-Kataster).
 *
 * AUIK is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the
 * Free Software Foundation, either version 2 of the License, or (at your
 * option) any later version.
 *
 * AUIK is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public
 * License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with AUIK. If not, see <http://www.gnu.org/licenses/>.
 *
 * AUIK has been developed by Stadt Bielefeld and Intevation GmbH.
 */

// Generated 17.07.2012 18:33:28 by Hibernate Tools 3.3.0.GA

package de.bielefeld.umweltamt.aui.mappings.generated.tipi;


import java.util.Date;

/**
 * A class that represents a row in a database table.
 * You can customize the behavior of this class by editing the class,
 * {@link DeaArbeitsstaette}.
 */
public abstract class AbstractDeaArbeitsstaette  implements java.io.Serializable {

     private DeaArbeitsstaetteId id;
     private Date inkaGueltigVon;
     private Date inkaGueltigBis;
     private short istAktuellTog;
     private Date erfassungsDatum;
     private Date aenderungsDatum;
     private String gaaId;
     private String astId;
     private Integer rechtswert;
     private Integer hochwert;
     private Integer e32;
     private Integer n32;
     private Date datum1;
     private Date datum2;
     private String wkl;
     private Character meldeart;
     private Character temp;
     private Character gpr;
     private String BGkz;
     private String BFirma1;
     private String BFirma2;
     private String BArt;
     private String BPostfach;
     private String BPlzPostfach;
     private String BStrasse;
     private String BNr;
     private String BLk;
     private String BPlz;
     private String BOrt;
     private String BOrtsteil;
     private String BTelNr;
     private String BTfxNr;
     private String ggr;
     private Integer pagingId;
     private int zustandsNr;
     private Date gueltigVon;
     private Date igStichtag;
     private Date gueltigBis;
     private Date erstellDat;
     private Date aktualDat;
     private int versionsnr;
     private Date zeitstempel;

    public AbstractDeaArbeitsstaette() {
    }

    public AbstractDeaArbeitsstaette(
    	DeaArbeitsstaetteId id, Date inkaGueltigVon, short istAktuellTog, Date erfassungsDatum, String gaaId, String astId, int zustandsNr, Date gueltigVon, Date erstellDat, Date aktualDat, int versionsnr) {
        this.id = id;
        this.inkaGueltigVon = inkaGueltigVon;
        this.istAktuellTog = istAktuellTog;
        this.erfassungsDatum = erfassungsDatum;
        this.gaaId = gaaId;
        this.astId = astId;
        this.zustandsNr = zustandsNr;
        this.gueltigVon = gueltigVon;
        this.erstellDat = erstellDat;
        this.aktualDat = aktualDat;
        this.versionsnr = versionsnr;
    }

    public AbstractDeaArbeitsstaette(
    	DeaArbeitsstaetteId id, Date inkaGueltigVon, Date inkaGueltigBis, short istAktuellTog, Date erfassungsDatum, Date aenderungsDatum, String gaaId, String astId, Integer rechtswert, Integer hochwert, Integer e32, Integer n32, Date datum1, Date datum2, String wkl, Character meldeart, Character temp, Character gpr, String BGkz, String BFirma1, String BFirma2, String BArt, String BPostfach, String BPlzPostfach, String BStrasse, String BNr, String BLk, String BPlz, String BOrt, String BOrtsteil, String BTelNr, String BTfxNr, String ggr, Integer pagingId, int zustandsNr, Date gueltigVon, Date igStichtag, Date gueltigBis, Date erstellDat, Date aktualDat, int versionsnr, Date zeitstempel) {
        this.id = id;
        this.inkaGueltigVon = inkaGueltigVon;
        this.inkaGueltigBis = inkaGueltigBis;
        this.istAktuellTog = istAktuellTog;
        this.erfassungsDatum = erfassungsDatum;
        this.aenderungsDatum = aenderungsDatum;
        this.gaaId = gaaId;
        this.astId = astId;
        this.rechtswert = rechtswert;
        this.hochwert = hochwert;
        this.e32 = e32;
        this.n32 = n32;
        this.datum1 = datum1;
        this.datum2 = datum2;
        this.wkl = wkl;
        this.meldeart = meldeart;
        this.temp = temp;
        this.gpr = gpr;
        this.BGkz = BGkz;
        this.BFirma1 = BFirma1;
        this.BFirma2 = BFirma2;
        this.BArt = BArt;
        this.BPostfach = BPostfach;
        this.BPlzPostfach = BPlzPostfach;
        this.BStrasse = BStrasse;
        this.BNr = BNr;
        this.BLk = BLk;
        this.BPlz = BPlz;
        this.BOrt = BOrt;
        this.BOrtsteil = BOrtsteil;
        this.BTelNr = BTelNr;
        this.BTfxNr = BTfxNr;
        this.ggr = ggr;
        this.pagingId = pagingId;
        this.zustandsNr = zustandsNr;
        this.gueltigVon = gueltigVon;
        this.igStichtag = igStichtag;
        this.gueltigBis = gueltigBis;
        this.erstellDat = erstellDat;
        this.aktualDat = aktualDat;
        this.versionsnr = versionsnr;
        this.zeitstempel = zeitstempel;
    }

    public DeaArbeitsstaetteId getId() {
        return this.id;
    }
    public void setId(DeaArbeitsstaetteId id) {
        this.id = id;
    }

    public Date getInkaGueltigVon() {
        return this.inkaGueltigVon;
    }
    public void setInkaGueltigVon(Date inkaGueltigVon) {
        this.inkaGueltigVon = inkaGueltigVon;
    }

    public Date getInkaGueltigBis() {
        return this.inkaGueltigBis;
    }
    public void setInkaGueltigBis(Date inkaGueltigBis) {
        this.inkaGueltigBis = inkaGueltigBis;
    }

    public short getIstAktuellTog() {
        return this.istAktuellTog;
    }
    public void setIstAktuellTog(short istAktuellTog) {
        this.istAktuellTog = istAktuellTog;
    }

    public Date getErfassungsDatum() {
        return this.erfassungsDatum;
    }
    public void setErfassungsDatum(Date erfassungsDatum) {
        this.erfassungsDatum = erfassungsDatum;
    }

    public Date getAenderungsDatum() {
        return this.aenderungsDatum;
    }
    public void setAenderungsDatum(Date aenderungsDatum) {
        this.aenderungsDatum = aenderungsDatum;
    }

    public String getGaaId() {
        return this.gaaId;
    }
    public void setGaaId(String gaaId) {
        this.gaaId = gaaId;
    }

    public String getAstId() {
        return this.astId;
    }
    public void setAstId(String astId) {
        this.astId = astId;
    }

    public Integer getRechtswert() {
        return this.rechtswert;
    }
    public void setRechtswert(Integer rechtswert) {
        this.rechtswert = rechtswert;
    }

    public Integer getHochwert() {
        return this.hochwert;
    }
    public void setHochwert(Integer hochwert) {
        this.hochwert = hochwert;
    }

    public Integer getE32() {
        return this.e32;
    }
    public void setE32(Integer e32) {
        this.e32 = e32;
    }

    public Integer getN32() {
        return this.n32;
    }
    public void setN32(Integer n32) {
        this.n32 = n32;
    }

    public Date getDatum1() {
        return this.datum1;
    }
    public void setDatum1(Date datum1) {
        this.datum1 = datum1;
    }

    public Date getDatum2() {
        return this.datum2;
    }
    public void setDatum2(Date datum2) {
        this.datum2 = datum2;
    }

    public String getWkl() {
        return this.wkl;
    }
    public void setWkl(String wkl) {
        this.wkl = wkl;
    }

    public Character getMeldeart() {
        return this.meldeart;
    }
    public void setMeldeart(Character meldeart) {
        this.meldeart = meldeart;
    }

    public Character getTemp() {
        return this.temp;
    }
    public void setTemp(Character temp) {
        this.temp = temp;
    }

    public Character getGpr() {
        return this.gpr;
    }
    public void setGpr(Character gpr) {
        this.gpr = gpr;
    }

    public String getBGkz() {
        return this.BGkz;
    }
    public void setBGkz(String BGkz) {
        this.BGkz = BGkz;
    }

    public String getBFirma1() {
        return this.BFirma1;
    }
    public void setBFirma1(String BFirma1) {
        this.BFirma1 = BFirma1;
    }

    public String getBFirma2() {
        return this.BFirma2;
    }
    public void setBFirma2(String BFirma2) {
        this.BFirma2 = BFirma2;
    }

    public String getBArt() {
        return this.BArt;
    }
    public void setBArt(String BArt) {
        this.BArt = BArt;
    }

    public String getBPostfach() {
        return this.BPostfach;
    }
    public void setBPostfach(String BPostfach) {
        this.BPostfach = BPostfach;
    }

    public String getBPlzPostfach() {
        return this.BPlzPostfach;
    }
    public void setBPlzPostfach(String BPlzPostfach) {
        this.BPlzPostfach = BPlzPostfach;
    }

    public String getBStrasse() {
        return this.BStrasse;
    }
    public void setBStrasse(String BStrasse) {
        this.BStrasse = BStrasse;
    }

    public String getBNr() {
        return this.BNr;
    }
    public void setBNr(String BNr) {
        this.BNr = BNr;
    }

    public String getBLk() {
        return this.BLk;
    }
    public void setBLk(String BLk) {
        this.BLk = BLk;
    }

    public String getBPlz() {
        return this.BPlz;
    }
    public void setBPlz(String BPlz) {
        this.BPlz = BPlz;
    }

    public String getBOrt() {
        return this.BOrt;
    }
    public void setBOrt(String BOrt) {
        this.BOrt = BOrt;
    }

    public String getBOrtsteil() {
        return this.BOrtsteil;
    }
    public void setBOrtsteil(String BOrtsteil) {
        this.BOrtsteil = BOrtsteil;
    }

    public String getBTelNr() {
        return this.BTelNr;
    }
    public void setBTelNr(String BTelNr) {
        this.BTelNr = BTelNr;
    }

    public String getBTfxNr() {
        return this.BTfxNr;
    }
    public void setBTfxNr(String BTfxNr) {
        this.BTfxNr = BTfxNr;
    }

    public String getGgr() {
        return this.ggr;
    }
    public void setGgr(String ggr) {
        this.ggr = ggr;
    }

    public Integer getPagingId() {
        return this.pagingId;
    }
    public void setPagingId(Integer pagingId) {
        this.pagingId = pagingId;
    }

    public int getZustandsNr() {
        return this.zustandsNr;
    }
    public void setZustandsNr(int zustandsNr) {
        this.zustandsNr = zustandsNr;
    }

    public Date getGueltigVon() {
        return this.gueltigVon;
    }
    public void setGueltigVon(Date gueltigVon) {
        this.gueltigVon = gueltigVon;
    }

    public Date getIgStichtag() {
        return this.igStichtag;
    }
    public void setIgStichtag(Date igStichtag) {
        this.igStichtag = igStichtag;
    }

    public Date getGueltigBis() {
        return this.gueltigBis;
    }
    public void setGueltigBis(Date gueltigBis) {
        this.gueltigBis = gueltigBis;
    }

    public Date getErstellDat() {
        return this.erstellDat;
    }
    public void setErstellDat(Date erstellDat) {
        this.erstellDat = erstellDat;
    }

    public Date getAktualDat() {
        return this.aktualDat;
    }
    public void setAktualDat(Date aktualDat) {
        this.aktualDat = aktualDat;
    }

    public int getVersionsnr() {
        return this.versionsnr;
    }
    public void setVersionsnr(int versionsnr) {
        this.versionsnr = versionsnr;
    }

    public Date getZeitstempel() {
        return this.zeitstempel;
    }
    public void setZeitstempel(Date zeitstempel) {
        this.zeitstempel = zeitstempel;
    }

}

