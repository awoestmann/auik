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
package de.bielefeld.umweltamt.aui.module.common.tablemodels;

import java.text.SimpleDateFormat;

import de.bielefeld.umweltamt.aui.mappings.tipi.InkaUebergabestelle;
import de.bielefeld.umweltamt.aui.utils.tablemodelbase.ListTableModel;
import de.nrw.lds.tipi.inka.Inka_Uebergabestelle;

public class InkaUebergabestelleModel extends ListTableModel {
    private static final long serialVersionUID = 3913291284739009733L;

    public InkaUebergabestelleModel() {
        super(new String[]{
                "Übergabestelle Nr.",
                "Betrieb Nr.",
                "Erfassungsdatum",
                "Gemeindekennzahl"
        },
        false);
    }

    /* (non-Javadoc)
     * @see de.bielefeld.umweltamt.aui.utils.tablemodelbase.ListTableModel#getColumnValue(java.lang.Object, int)
     */
    @Override
    public Object getColumnValue(Object objectAtRow, int columnIndex) {
        if (objectAtRow == null) {
            return "error";
        }
        if (objectAtRow instanceof InkaUebergabestelle) {
            return getInkaUebergabestelleFromDB(objectAtRow, columnIndex);
        }
        else if (objectAtRow instanceof Inka_Uebergabestelle) {
            return getInkaUebergabestelleFromService(objectAtRow, columnIndex);
        }
        else {
            return "Error";
        }
    }

    public Object getInkaUebergabestelleFromDB(Object obj, int ndx) {
    	InkaUebergabestelle fd = (InkaUebergabestelle) obj;
        Object tmp;

        switch (ndx) {
        case 0:
            tmp = fd.getUebergabestelleLfdNr();
        case 1:
            tmp = fd.getBetriebNr();
            break;
        case 2:
            tmp = new SimpleDateFormat("dd.MM.yyyy").format(fd.getErfassungsDatum().getTime());
            break;
        case 3:
            tmp = fd.getGemeindekennzahl();
            break;

        default:
            tmp = "ERROR";
            break;
        }
        return tmp;
    }


    public Object getInkaUebergabestelleFromService(Object obj, int ndx) {
    	Inka_Uebergabestelle fd = (Inka_Uebergabestelle) obj;
        Object tmp;

        switch (ndx) {
        case 0:
            tmp = fd.getUebergabestelle_lfd_nr();
        case 1:
            tmp = fd.getBetrieb_nr();
            break;
        case 2:
            tmp = fd.getErfassungs_datum();
            break;
        case 3:
            tmp = fd.getGemeindekennzahl();
            break;

        default:
            tmp = "ERROR";
            break;
        }
        return tmp;
    }


    /*
     * Leer, da kein Updaten der Liste nötig/möglich.
     */
    @Override
    public void updateList() {
    }
}
