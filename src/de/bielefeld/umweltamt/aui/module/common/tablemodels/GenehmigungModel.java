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

import java.util.Date;

import de.bielefeld.umweltamt.aui.mappings.indeinl.IndeinlGenehmigung;
import de.bielefeld.umweltamt.aui.utils.AuikUtils;
import de.bielefeld.umweltamt.aui.utils.tablemodelbase.ListTableModel;

/**
 * Ein einfaches TableModel für Anhang 52-Fachdaten.
 * @author Gerd Genuit
 */
public class GenehmigungModel extends ListTableModel {
    public GenehmigungModel() {
        super(new String[]{
                "Betreiber",
                "Standort",
                "Datum",
                "Anhang",
                "58er",
                "59er",
                "Bemerkungen"
        },
        false);
    }

    /* (non-Javadoc)
     * @see de.bielefeld.umweltamt.aui.utils.tablemodelbase.ListTableModel#getColumnValue(java.lang.Object, int)
     */
    public Object getColumnValue(Object objectAtRow, int columnIndex) {
        IndeinlGenehmigung fd = (IndeinlGenehmigung) objectAtRow;
        Object tmp;

        switch (columnIndex) {
        case 0:
            tmp = fd.getBasisObjekt().getBasisBetreiber().toString();
            break;
        case 1:
            tmp = fd.getBasisObjekt().getBasisStandort().toString();
            break;
        case 2:
            tmp = fd.getErstellungsDatum();
            break;
        case 3:
            tmp = fd.getAnhang();
            break;
        case 4:
            if (fd.getGen58()!= null)
                tmp = new Boolean(fd.getGen58());
            else
                tmp = new Boolean(false);
            break;
        case 5:
            if (fd.getGen59()!= null)
                tmp = new Boolean(fd.getGen59());
            else
                tmp = new Boolean(false);
            break;
        case 6:
            tmp = fd.getBemerkungen();
            break;

        default:
            tmp = "ERROR";
            break;
//        }
//        if (fd.getBasisObjekt().getInaktiv() == true && columnIndex != 4 && columnIndex != 5)
//        {
//            tmp = "<html><strike>" + tmp + "</strike></html>";
        }
        return tmp;
    }
    
	  @Override
	public Class<?> getColumnClass( int columnIndex ){
		switch( columnIndex ){
			case 0: return String.class;
			case 1: return String.class;
			case 2: return Date.class;
			case 3: return Integer.class;
			case 4: return Boolean.class;
			case 5: return Boolean.class;
			case 6: return String.class;
			default: return null;
		}
	}

    /*
     * Leer, da kein Updaten der Liste nötig/möglich.
     */
    public void updateList() {
    }
}
