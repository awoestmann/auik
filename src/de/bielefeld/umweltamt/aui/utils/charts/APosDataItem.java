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

/*
 * Datei:
 * $Id: APosDataItem.java,v 1.3.2.1 2010-11-23 10:25:59 u633d Exp $
 *
 * Erstellt am 31.05.2005 von David Klotz (u633z)
 *
 * CVS-Log:
 * $Log: not supported by cvs2svn $
 * Revision 1.3  2009/12/11 07:22:34  u633d
 * AuswertungSielhaut
 *
 * Revision 1.2  2009/03/24 12:35:20  u633d
 * Umstellung auf UTF8
 *
 * Revision 1.1  2008/06/05 11:38:38  u633d
 * Start AUIK auf Informix und Postgresql
 *
 * Revision 1.1  2005/05/31 15:52:18  u633z
 * - Charts und ChartDataSets nach utils.charts verschoben
 * - Neue Klasse APosDataItem um eine Analyseposition als Punkt einer
 *   TimeSeries Datenreihe zu repräsentieren
 * - Bessere Tooltips im Auswertungs-Diagramm
 *
 */
package de.bielefeld.umweltamt.aui.utils.charts;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.jfree.data.time.Minute;
import org.jfree.data.time.TimeSeriesDataItem;

import de.bielefeld.umweltamt.aui.mappings.atl.Analyseposition;

/**
 * Eine Klasse um eine Analysposition als Datenpunkt in einer TimeSeries-Datenreihe
 * darstellen zu können.
 * @author David Klotz
 */
public class APosDataItem extends TimeSeriesDataItem {
    private static final long serialVersionUID = -8582014620416975204L;
    private Analyseposition pos;

    public APosDataItem(Analyseposition pos) {
        // es werden die Messwerte beachtet
        this(pos, createMinuteFromDate(new Timestamp(pos.getProbenahme().getDatumDerEntnahme().getTime()), pos.getProbenahme().getDatumDerEntnahme().toString().substring(11, 16)));
    }

    public APosDataItem(String norm,Analyseposition pos) {
        // es werden die Normwerte beachtet
        this("normwert",pos, createMinuteFromDate(new Timestamp(pos.getProbenahme().getDatumDerEntnahme().getTime()), pos.getProbenahme().getZeitDerEntnahmen()));
    }

    public APosDataItem( Analyseposition pos, Minute minute) {
        // es werden die Messwerte beachtet
            super(minute, pos.getWert());

        this.pos = pos;
    }

    public APosDataItem(String norm ,Analyseposition pos, Minute minute) {
    // es werden die Normwerte beachtet
        super(minute, pos.getNormwert());

    this.pos = pos;
}

    public Minute getMinute() {
        return (Minute) getPeriod();
    }

    public Analyseposition getAnalysePosition() {
        return pos;
    }

    public static Minute createMinuteFromDate(Timestamp date, String zeit) {
        int hour = 0;
        int minute = 0;

        Calendar cal = GregorianCalendar.getInstance();

        cal.setTime(date);
        if (zeit != null) {
            //Zeit ist im Format: "15:30:00"
            hour = Integer.parseInt(zeit.substring(0,2));
            minute = Integer.parseInt(zeit.substring(3,5));
        }

        return new Minute(minute, hour, cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.MONTH)+1, cal.get(Calendar.YEAR));
    }
}
