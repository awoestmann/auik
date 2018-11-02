/**
 * Copyright 2005-2042, Stadt Bielefeld
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

package de.bielefeld.umweltamt.aui.mappings;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.NullPrecedence;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;

import de.bielefeld.umweltamt.aui.HibernateSessionFactory;
import de.bielefeld.umweltamt.aui.SettingsManager;
import de.bielefeld.umweltamt.aui.mappings.atl.Einheiten;
import de.bielefeld.umweltamt.aui.mappings.atl.Klaeranlage;
import de.bielefeld.umweltamt.aui.mappings.atl.Parameter;
import de.bielefeld.umweltamt.aui.mappings.basis.Adresse;
import de.bielefeld.umweltamt.aui.mappings.basis.Orte;
import de.bielefeld.umweltamt.aui.mappings.basis.Strassen;
import de.bielefeld.umweltamt.aui.mappings.basis.Gemarkung;
import de.bielefeld.umweltamt.aui.mappings.basis.Lage;
import de.bielefeld.umweltamt.aui.mappings.basis.Standort;
import de.bielefeld.umweltamt.aui.mappings.basis.Objekt;
import de.bielefeld.umweltamt.aui.mappings.basis.Objektarten;
import de.bielefeld.umweltamt.aui.mappings.basis.Objektchrono;
import de.bielefeld.umweltamt.aui.mappings.basis.Objektverknuepfung;
import de.bielefeld.umweltamt.aui.mappings.basis.Sachbearbeiter;
import de.bielefeld.umweltamt.aui.mappings.basis.TabStreets;
import de.bielefeld.umweltamt.aui.mappings.indeinl.Anh49Abfuhr;
import de.bielefeld.umweltamt.aui.mappings.indeinl.Anh49Fachdaten;
import de.bielefeld.umweltamt.aui.mappings.awsv.Wassereinzugsgebiet;
import de.bielefeld.umweltamt.aui.utils.AuikLogger;
import de.bielefeld.umweltamt.aui.utils.StringUtils;

/**
 * This is a service class for all custom queries from the basis package.
 *
 * @author <a href="mailto:post@connz.de">Conny Pearce (u633z)</a>
 * @see de.bielefeld.umweltamt.aui.mappings.DatabaseQuery
 */
abstract class DatabaseBasisQuery extends DatabaseIndeinlQuery {

	/** Logging */
	private static final AuikLogger log = AuikLogger.getLogger();

	/* ********************************************************************** */
	/* Queries for package BASIS */
	/* ********************************************************************** */

	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	/* Queries for package BASIS : class Adresse */
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

	/**
	 * Get all Adresse with a given search string in the selected property that
	 * contain a Betreiber. <br>
	 * If property is <code>null</code>, we search in all three properties.
	 * 
	 * @param property
	 *            Name of the property
	 * @param search
	 *            Search string
	 * @return <code>List&lt;Adresse&gt;</code> List of Adresse with the given
	 *         search string in the given property
	 */
	public static List<Adresse> getAdresse(String property, String search) {

		String modSearch = search.trim().toLowerCase() + "%";
		log.debug("Suche nach '" + modSearch + "' (" + property + ").");

		String query = "SELECT DISTINCT Adresse " + "FROM adresse JOIN adresse.objektsForBetreiberid objekt ";
		if (property == null) {
			query += "WHERE LOWER(adresse.betrname) like '" + modSearch + "' OR LOWER(betranrede) like '" + modSearch
					+ "' OR LOWER(betrnamezus) like '" + modSearch + "'";
		} else if (property.equals("name")) {
			query += "WHERE LOWER(adresse.betrname) like '" + modSearch + "'";
		} else if (property.equals("anrede")) {
			query += "WHERE LOWER(adresse.betranrede) like '" + modSearch + "'";
		} else if (property.equals("zusatz")) {
			query += "WHERE LOWER(adresse.betrzus) like '" + modSearch + "'";
		} else {
			log.debug("Something went really wrong here...");
		}
		query += " AND adresse.deleted = false";
		query += " ORDER BY adresse.betrname ASC, adresse.betrnamezus ASC";

		return HibernateSessionFactory.currentSession().createQuery(query).list();
	}

	/**
	 * Get a nicely formatted street and house number for a Adresse
	 * 
	 * @param betreiber
	 *            Adresse
	 * @return String
	 */
	public static String getBetriebsgrundstueck(Adresse betreiber) {
		String strasse = betreiber.getStrasse();
		Integer hausnr = betreiber.getHausnr();
		String zusatz = betreiber.getHausnrzus();
		return (strasse != null ? strasse + " " : "") + (hausnr != null ? hausnr.toString() : "")
				+ (zusatz != null ? zusatz : "");
	}

	/**
	 * Get a formatted string for a BasisStandortAdresse
	 * 
	 * @param standort
	 *            Standort
	 * @return String
	 */
	public static String getStandortString(Standort standort) {
		String strasse = standort.getAdresse().getStrasse();
		Integer hausnr = standort.getAdresse().getHausnr();
		String zusatz = standort.getAdresse().getHausnrzus();
		return (strasse != null ? strasse + " " : "") + (hausnr != null ? hausnr.toString() : "")
				+ (zusatz != null ? zusatz : "");
	}

	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	/* Queries for package BASIS : class Gemarkung */
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

	private static Gemarkung[] gemarkungen = null;

	/**
	 * Get an array with all <code>Gemarkung</code>en
	 * 
	 * @return <code>Gemarkung[]</code>
	 */
	public static Gemarkung[] getGemarkungen() {
		if (DatabaseBasisQuery.gemarkungen == null) {
			DatabaseBasisQuery.gemarkungen = DatabaseQuery.getOrderedAll(new Gemarkung()).toArray(new Gemarkung[0]);
		}
		return DatabaseBasisQuery.gemarkungen;
	}

	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	/* Queries for package BASIS : class Gemarkung */
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

	/**
	 * Get all Gemarkungen and sort them by their name
	 * 
	 * @return <code>Eine Liste aller Gemarkungen</code>
	 */
	public static List<Gemarkung> getGemarkungenlist() {
		List<Gemarkung> gemarkungenlist = new DatabaseAccess().executeCriteriaToList(
				DetachedCriteria.forClass(Gemarkung.class).addOrder(Order.asc("gemarkung")), new Gemarkung());
		return gemarkungenlist;
	}

	/**
	 * Get next id for new Gemarkung
	 * 
	 * @return <code>Gemarkung</code>
	 */
	public static Integer newGemarkungID() {
		Integer id = new DatabaseAccess().executeCriteriaToUniqueResult(
				DetachedCriteria.forClass(Gemarkung.class).setProjection(Property.forName("id").max()), new Integer(0));
		return id + 1;
	}

	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	/* Queries for package BASIS : class Objekt */
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

	/**
	 * Liefert eine Liste von Objekten, die einem bestimmten Betreiber zugeordnet
	 * sind.
	 * 
	 * @param betreiber
	 *            Der Betreiber.
	 * @param abteilung
	 *            Die Abteilung, wenn nach ihr gefiltert werden soll, sonst
	 *            <code>null</code>.
	 * @return Eine Liste von Objekten dieses Betreibers.
	 */
	public static List<Objekt> getObjekteByBetreiber(Adresse betreiber, String abteilung) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Objekt.class).createAlias("standort", "lage")
				.createAlias("objektarten", "art").add(Restrictions.eq("adresse", betreiber))
				.addOrder(Order.asc("inaktiv")).addOrder(Order.asc("lage.strasse")).addOrder(Order.asc("lage.hausnr"))
				.addOrder(Order.asc("art.objektart"));
		if (abteilung != null) {
			detachedCriteria.add(Restrictions.eq("art.abteilung", abteilung));
		}
		return new DatabaseAccess().executeCriteriaToList(detachedCriteria, new Objekt());
	}

	/**
	 * Liefert eine Liste von Objekten, die einem bestimmten Standort zugeordnet
	 * sind.
	 * 
	 * @param betreiber
	 *            Die Standortadresse.
	 * @param abteilung
	 *            Die Abteilung, wenn nach ihr gefiltert werden soll, sonst
	 *            <code>null</code>.
	 * @param artid
	 *            Die Objektart, die (nicht) dargestellt werden soll.
	 * @return Eine Liste von Objekten an diesem Standort.
	 */

	public static List<Objekt> getObjekteByStandort(Standort standort, String abteilung) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Objekt.class).createAlias("lage", "lage")
				.createAlias("objektarten", "art").add(Restrictions.eq("standort", standort))
				.addOrder(Order.asc("inaktiv")).addOrder(Order.asc("lage.strasse")).addOrder(Order.asc("lage.hausnr"))
				.addOrder(Order.asc("art.objektart"));
		if (abteilung != null) {
			detachedCriteria.add(Restrictions.eq("art.abteilung", abteilung));
		}
		return new DatabaseAccess().executeCriteriaToList(detachedCriteria, new Objekt());
	}

	public static List<Objekt> getObjekteByAdresse(Adresse adresse, String abteilung, Integer artid,
			Boolean matchArtId) {
		log.debug("Fetching objects at " + adresse);
		// Find objects witch matching standortid
		String query = "SELECT o.* from basis.objekt o, basis.standort s " 
				+ " WHERE o.standortid = s.id "
				+ " AND (s.adresseid = " + adresse.getId()
				+ " OR o.betreiberid = " + adresse.getId() + " ) "
				+ " AND o._deleted = false ORDER BY o.inaktiv, o.objektartid";

		String filter = " ";
		if (abteilung != null) {
			filter += " AND art.abteilung = '" + abteilung + "' ";
		}
		if (artid != null) {
			if (matchArtId) {
				filter += "AND art.id = " + artid + " ";
			} else {
				filter += "AND art.id != " + artid + " ";

			}
		}

		SQLQuery q = HibernateSessionFactory.currentSession().createSQLQuery(query);

		q.addEntity("o", Objekt.class);
		return q.list();
	}

	public static List<Objekt> getObjekteByStandort(Standort standort, String abteilung, Integer artid,
			Boolean matchArtId) {
		String strasse = standort.getAdresse().getStrasse();
		Integer hausnr = standort.getAdresse().getHausnr();
		String hausnrzus = standort.getAdresse().getHausnrzus();
		log.debug("Fetching objects at " + standort);
		// Find objects with standortid of adresse with matching fields
		String query = "SELECT o.* from basis.objekt o, basis.standort s, basis.adresse a, basis.objektarten art "
				+ " WHERE o.standortid = s.id AND s.adresseid = a.id AND o.objektartid = art.id"
				+ " AND a.strasse = '" + strasse + "'"
				+ " AND a.hausnr = " + hausnr
				+ " AND CASE WHEN (hausnrzus IS NOT NULL) THEN (a.hausnrzus = '" + hausnrzus + "') ELSE (a.hausnrzus IS NULL) END"
				+ " AND o._deleted = false ORDER BY o.inaktiv, o.objektartid";

		String filter = " ";
		if (abteilung != null) {
			filter += " AND art.abteilung = '" + abteilung + "' ";
		}
		if (artid != null) {
			if (matchArtId) {
				filter += "AND art.id = " + artid + " ";
			} else {
				filter += "AND art.id != " + artid + " ";

			}
		}
		query += filter + ";";
		SQLQuery q = HibernateSessionFactory.currentSession().createSQLQuery(query);
		q.addEntity("o", Objekt.class);
		return q.list();
	}

	/**
	 * Liefert eine Liste von Objekten, die einer bestimmten Strasse, Hausnummer und
	 * Hausnummernzusatz zugeordnet sind.
	 * 
	 * @param adr
	 *            Die Standortadresse.
	 * @param abteilung
	 *            Die Abteilung, wenn nach ihr gefiltert werden soll, sonst
	 *            <code>null</code>.
	 * @param artid
	 *            Die Objektart, die (nicht) dargestellt werden soll.
	 * @return Eine Liste von Objekten an diesem Standort.
	 */

	public static List<Objekt> getObjekteByStrasse(Adresse adr, String abteilung, Integer artid, Boolean matchArtId) {

		String strasse = adr.getStrasse().replaceAll("'", "''");
		Integer nr = adr.getHausnr();
		String zus = adr.getHausnrzus();

		log.debug("Fetching objects at " + adr);
		// Find objects witch matching fields
		String query = "SELECT o.*, a.* from basis.objekt o, basis.adresse a, basis.objektarten art "
				+ " WHERE o.standortid = a.id AND o.objektartid = art.id " + "AND a.strasse = '" + strasse
				+ "' AND a.hausnr = " + nr;
		if (zus != null) {
			query += " AND a.hausnrzus = '" + zus + "' ";
		} else {
			query += " AND a.hausnrzus IS NULL ";
		}

		query += " AND o._deleted = false ";

		String filter = " ";
		if (abteilung != null) {
			filter += " AND art.abteilung = '" + abteilung + "' ";
		}
		if (artid != null) {
			if (matchArtId) {
				filter += "AND art.id = " + artid + " ";
			} else {
				filter += "AND art.id != " + artid + " ";

			}
		}
		query += filter + "ORDER BY o.inaktiv, a.betrname, art.objektart, o.beschreibung;";
		SQLQuery q = HibernateSessionFactory.currentSession().createSQLQuery(query);
		// log.debug(query1 + query2);
		q.addEntity("o", Objekt.class);
		return q.list();

	}

	/**
	 * Liefert eine Liste von Objekten einer Objektart sind.
	 * 
	 * @param artid
	 *            Die Objektart, die (nicht) dargestellt werden soll.
	 * @return Eine Liste von Objekten an diesem Standort.
	 */
	public static List<Objekt> getObjekteByArt(Integer artid) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Objekt.class).createAlias("adresse", "betreiber")
				.createAlias("objektarten", "art").add(Restrictions.eq("art.id", artid)).addOrder(Order.asc("inaktiv"))
				.addOrder(Order.asc("betreiber.betrname")).addOrder(Order.asc("art.objektart"));

		return new DatabaseAccess().executeCriteriaToList(detachedCriteria, new Objekt());
	}

	/**
	 * Cascade a priority to all objects from the same Adresse and Lage
	 * 
	 * @param prioritaet
	 *            String
	 * @param basisObjekt
	 *            Objekt
	 * @return <code>true</code> if every merge was successful, <code>false</code>
	 *         otherwise
	 */
	public static Boolean cascadePriority(String prioritaet, Objekt basisObjekt) {
		Boolean result = true;
		List<Objekt> list = new DatabaseAccess().executeCriteriaToList(
				DetachedCriteria.forClass(Objekt.class).add(Restrictions.eq("adresse", basisObjekt.getAdresses()))
						.add(Restrictions.eq("lage", basisObjekt.getStandortid().getLage())),
				new Objekt());
		for (Objekt objekt : list) {
			objekt.setPrioritaet(prioritaet);
			result = result && objekt.merge();
		}
		return result;
	}

	/**
	 * Get a list of all priorities. The list contains an array with
	 * <code>Lage</code>, <code>Adresse</code>, <code>String</code> (priority) and
	 * <code>Sachbearbeiter</code>
	 * 
	 * @return <code>List&lt;?&gt;</code>
	 */
	public static List<?> getObjektsWithPriority() {
		return new DatabaseAccess().executeCriteriaToList(
				DetachedCriteria.forClass(Objekt.class).add(Restrictions.eq("inaktiv", false))
						.add(Restrictions.eq("deleted", false)).add(Restrictions.isNotNull("prioritaet"))
						.add(Restrictions.isNotNull("sachbearbeiter"))
						.setProjection(Projections.distinct(Projections.projectionList()
								.add(Projections.property("lage")).add(Projections.property("adresse"))
								.add(Projections.property("prioritaet")).add(Projections.property("sachbearbeiter"))))
						.addOrder(Order.asc("prioritaet")).addOrder(Order.asc("lage")).addOrder(Order.asc("adresse")),
				new Objekt());
	}

	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	/* Queries for package BASIS : class Objektarten */
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

	private static Objektarten[] objektarten = null;

	/**
	 * Get all Objektarten and sort them by their name
	 * 
	 * @return <code>Objektarten[]</code>
	 */
	public static Objektarten[] getObjektarten() {
		if (DatabaseBasisQuery.objektarten == null) {
			DatabaseBasisQuery.objektarten = DatabaseQuery.getOrderedAll(new Objektarten(), "objektart")
					.toArray(new Objektarten[0]);
		}
		return DatabaseBasisQuery.objektarten;
	}

	/**
	 * Get all Objektarten and sort them by their name and kind
	 * 
	 * @return <code>Objektarten[]</code>
	 */
	public static List<Objektarten> getObjektartenlist() {
		List<Objektarten> objektartenlist = new DatabaseAccess().executeCriteriaToList(DetachedCriteria
				.forClass(Objektarten.class).addOrder(Order.asc("abteilung")).addOrder(Order.asc("objektart")),
				new Objektarten());
		return objektartenlist;
	}

	/**
	 * Get next id for new Objektarten
	 * 
	 * @return <code>ObjektartenID</code>
	 */
	public static Integer newObjektartenID() {
		Integer id = new DatabaseAccess().executeCriteriaToUniqueResult(
				DetachedCriteria.forClass(Objektarten.class).setProjection(Property.forName("id").max()),
				new Integer(0));
		return id + 1;
	}

	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	/* Queries for package BASIS : class Objektchrono */
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

	/**
	 * Go throw the Objektchrono Set and grep the earliest chrono.
	 * 
	 * @param objekt
	 *            Objekt
	 * @return Objektchrono
	 */
	public static Timestamp getLastChronoDateForObjekt(Objekt objekt) {

		return new DatabaseAccess().executeCriteriaToUniqueResult(DetachedCriteria.forClass(Objektchrono.class)
				.add(Restrictions.eq("objekt", objekt)).setProjection(Projections.distinct(Projections.max("datum"))),
				new Timestamp(0));
	}

	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	/* Queries for package indeinl : class Anh49Abfuhr */
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

	/**
	 * Go throw the Anh49Abfuhr Set and grep the earliest abfuhrdatum.
	 * 
	 * @param objekt
	 *            Anh49Fachdaten
	 * @return Anh49Abfuhr
	 */
	public static Timestamp getLastAbfuhrDateForObjekt(Anh49Fachdaten objekt) {

		return new DatabaseAccess().executeCriteriaToUniqueResult(
				DetachedCriteria.forClass(Anh49Abfuhr.class).add(Restrictions.eq("anh49Fachdaten", objekt))
						.setProjection(Projections.distinct(Projections.max("abfuhrdatum"))),
				new Timestamp(0));
	}

	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	/* Queries for package indeinl : class Anh49Abfuhr */
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

	/**
	 * Go throw the Anh49Abfuhr Set and grep the earliest naechsteabfuhr.
	 * 
	 * @param objekt
	 *            Anh49Fachdaten
	 * @return Anh49Abfuhr
	 */
	public static Timestamp getNextAbfuhrDateForObjekt(Anh49Fachdaten objekt) {

		return new DatabaseAccess()
				.executeCriteriaToUniqueResult(
						DetachedCriteria.forClass(Anh49Abfuhr.class).add(Restrictions.eq("anh49Fachdaten", objekt))
								.setProjection(Projections.distinct(Projections.max("naechsteabfuhr"))),
						new Timestamp(0));
	}

	// TODO: This may be replaced with objekt.getObjektchonos() if we find
	// an easy way to load them as they are lazy loaded.
	public static List<Objektchrono> getChronos(Objekt objekt) {
		return new DatabaseAccess().executeCriteriaToList(DetachedCriteria.forClass(Objektchrono.class)
				.add(Restrictions.eq("objekt", objekt)).addOrder(Order.asc("datum")), new Objektchrono());
	}

	public static List<Objektchrono> getAllChronos(Objekt objekt) {
		return new DatabaseAccess().executeCriteriaToList(
				DetachedCriteria.forClass(Objektchrono.class).createAlias("objekt", "objekt")
						.add(Restrictions.eq("objekt.adresse", objekt.getAdresses()))
						.add(Restrictions.eq("objekt.lage", objekt.getStandortid().getLage())).addOrder(Order.asc("datum")),
				new Objektchrono());
	}

	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	/* Queries for package BASIS : class Objektverknuepfung */
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

	/**
	 * Liefert alle verknuepften Objekte zu einem bestimmten Objekt.
	 * 
	 * @param objekt
	 *            Das Objekt.
	 * @return Eine Liste mit Objekten.
	 */
	public static List<Objektverknuepfung> getLinkedObjekts(Objekt objekt) {
		return new DatabaseAccess().executeCriteriaToList(DetachedCriteria.forClass(Objektverknuepfung.class)
				.add(Restrictions.or(Restrictions.eq("objektByIstVerknuepftMit", objekt),
						Restrictions.eq("objektByObjekt", objekt))),
				new Objektverknuepfung());
	}

	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	/* Queries for package BASIS : class Sachbearbeiter */
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

	private static Sachbearbeiter[] sachbearbeiter = null;

	/**
	 * Get a sorted array of all enabled Sachbearbeiter
	 * 
	 * @return <code>Sachbearbeiter[]</code>
	 */
	public static Sachbearbeiter[] getEnabledSachbearbeiter() {
		if (DatabaseBasisQuery.sachbearbeiter == null) {
			DatabaseBasisQuery.sachbearbeiter = new DatabaseAccess().executeCriteriaToArray(DetachedCriteria
					.forClass(Sachbearbeiter.class).add(Restrictions.eq("enabled", true)).addOrder(Order.asc("name")),
					new Sachbearbeiter[0]);
		}
		return DatabaseBasisQuery.sachbearbeiter;
	}

	/**
	 * Get the current Sachbearbeiter.
	 * 
	 * @return <code>Sachbearbeiter</code>
	 */
	public static Sachbearbeiter getCurrentSachbearbeiter() {
		return Sachbearbeiter.findByKennummer(SettingsManager.getInstance().getSetting("auik.prefs.lastuser"));
	}

	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	/* Queries for package BASIS : class Sachbearbeiter */
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

	/**
	 * Get all Sachbearbeiter and sort them by their name
	 * 
	 * @return <code>Eine Liste aller Parameter</code>
	 */
	public static List<Sachbearbeiter> getSachbearbeiterlist() {
		List<Sachbearbeiter> sachbearbeiterlist = new DatabaseAccess().executeCriteriaToList(
				DetachedCriteria.forClass(Sachbearbeiter.class).addOrder(Order.asc("name")), new Sachbearbeiter());
		return sachbearbeiterlist;
	}

	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	/* Queries for package BASIS : class BasisLage */
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

	/**
	 * Check if a location already exists
	 * 
	 * @param strasse
	 *            The street
	 * @param hausnr
	 *            The house number
	 * @param zusatz
	 *            Addition to the house number
	 * @return <code>true</code>, if the given location exists, <code>false</code>
	 *         otherwise
	 */
	public static boolean basisStandortExists(String strasse, Integer hausnr, String zusatz) {
		return (!(new DatabaseAccess()
				.executeCriteriaToList(DetachedCriteria.forClass(Adresse.class).add(Restrictions.eq("strasse", strasse))
						.add(Restrictions.eq("hausnr", hausnr))
						.add(DatabaseAccess.getRestrictionsEqualOrNull("hausnrzus", zusatz)), new Adresse())
				.isEmpty()));
	}

	/**
	 * Returns a List of all Adresse and BasisLage objects that are connected
	 * through a BasisMapAdresseLage object Output format is
	 * List<[Adresse][BasisLage]>
	 * 
	 * @param strasse
	 *            String
	 * @param hausnr
	 *            Integer (-1: all)
	 * @param ort
	 *            String
	 * @return <code>List&lt;Object[]&gt;</code>
	 */
	public static List<Object[]> findStandorteNew(String strasse, Integer hausnr, String ort) {
		// Check which parameters are set
		boolean bStrasse = (strasse != null && strasse.length() > 0);
		boolean bHausnr = (hausnr != null && hausnr != -1);
		boolean bOrt = (ort != null && ort.length() > 0);
		String str = strasse.toLowerCase();
		str = str.replace("'", "''");

		String query = "SELECT * FROM " + " (SELECT DISTINCT ON (a.strasse, a.hausnr, a.hausnrzus) m.*, a.* "
				+ "FROM basis.standort m JOIN basis.adresse a ON a.id = m.adresseid";
		if (bStrasse || bHausnr || bOrt) {
			query += " WHERE ";
			if (bStrasse) {
				query += " lower(a.strasse) like '" + str + "%' ";
			}
			if (hausnr != null && hausnr != -1) {
				if (bStrasse) {
					query += " AND ";
				}
				query += " a.hausnr = " + hausnr;
			}
			if (bOrt) {
				if (bStrasse || bHausnr) {
					query += " AND ";
				}
				query += " lower(a.ort) like '" + ort.toLowerCase() + "%' ";
			}
			query += " AND a._deleted = false";
		}
		query += ") AS q ORDER BY q.strasse ASC, q.hausnr ASC, q.hausnrzus ASC;";
		SQLQuery q = HibernateSessionFactory.currentSession().createSQLQuery(query);
		q.addEntity("a", Adresse.class);
		q.addEntity("m", Standort.class);
		return q.list();
	}

	/**
	 * Returns a List of Adresse objects for the given parameters Output format is
	 * List<[Adresse]>
	 * 
	 * @param Name
	 *            String
	 * @param strasse
	 *            String
	 * @param hausnr
	 *            Integer (-1: all)
	 * @param ort
	 *            String
	 * @return <code>List&lt;Adresse[]&gt;</code>
	 */

	public static List<Adresse> findBetreiber(String name, String strasse, Integer hausnr, String ort) {
		// Check which parameters are set
		boolean bName = (name != null && name.length() > 0);
		boolean bStrasse = (strasse != null && strasse.length() > 0);
		boolean bHausnr = (hausnr != null && hausnr != -1);
		boolean bOrt = (ort != null && ort.length() > 0);
		String str = strasse.toLowerCase();
		str = str.replace("'", "''");

		String query = "SELECT DISTINCT adresse " + "FROM objekt as obj JOIN obj.adresseByBetreiberid adresse";
		if (bName || bStrasse || bHausnr || bOrt) {
			query += " WHERE ";
			if (bName) {
				query += "LOWER(adresse.betrname) like '" + name.toLowerCase() + "%' AND ";
			}
			if (bStrasse) {
				query += "LOWER(adresse.strasse) like '" + strasse.toLowerCase() + "%' AND ";
			}
			if (bHausnr) {
				query += "adresse.hausnr = " + hausnr + " AND ";
			}
			if (bOrt) {
				query += "LOWER(adresse.ort) like '" + ort.toLowerCase() + "%' AND ";
			}

			query += "adresse.deleted = false ";

			query += "ORDER BY adresse.strasse ASC, adresse.hausnr ASC, adresse.hausnrzus ASC, adresse.betrname ASC";
		}
		return HibernateSessionFactory.currentSession().createQuery(query).list();
	}

	/**
	 * Returns a List of Adresse objects for the given parameters Output format is
	 * List<[Adresse]>
	 * 
	 * @param Name
	 *            String
	 * @param strasse
	 *            String
	 * @param hausnr
	 *            Integer (-1: all)
	 * @param ort
	 *            String
	 * @return <code>List&lt;Adresse[]&gt;</code>
	 */

	public static List<Adresse> findStandorte(String name, String strasse, Integer hausnr, String ort) {
		// Check which parameters are set
		boolean bName = (name != null && name.length() > 0);
		boolean bStrasse = (strasse != null && strasse.length() > 0);
		boolean bHausnr = (hausnr != null && hausnr != -1);
		boolean bOrt = (ort != null && ort.length() > 0);
		String str = strasse.toLowerCase();
		str = str.replace("'", "''");

		String query = "SELECT DISTINCT adresse " + "FROM Objekt as obj JOIN obj.adresseByStandortid adresse";
		if (bName || bStrasse || bHausnr || bOrt) {
			query += " WHERE ";
			if (bName) {
				query += "LOWER(adresse.betrname) like '" + name.toLowerCase() + "%' AND ";
			}
			if (bStrasse) {
				query += "LOWER(adresse.strasse) like '" + strasse.toLowerCase() + "%' AND ";
			}
			if (bHausnr) {
				query += "adresse.hausnr = " + hausnr + " AND ";
			}
			if (bOrt) {
				query += "LOWER(adresse.ort) like '" + ort.toLowerCase() + "%' AND ";
			}

			query += "adresse.deleted = false ";

			query += "ORDER BY adresse.strasse ASC, adresse.hausnr ASC, adresse.hausnrzus ASC, adresse.betrname ASC";
		}
		return HibernateSessionFactory.currentSession().createQuery(query).list();
	}

	public static List<Adresse> findStandorte(String strasse, Integer hausnr, String ort) {
		// Check which parameters are set
		boolean bStrasse = (strasse != null && strasse.length() > 0);
		boolean bHausnr = (hausnr != null && hausnr != -1);
		boolean bOrt = (ort != null && ort.length() > 0);
		String str = strasse.toLowerCase();
		str = str.replace("'", "''");

		String query = "SELECT DISTINCT adresse " + "FROM MapAdresseLage as map JOIN map.adresse";
		if (bStrasse || bHausnr || bOrt) {
			query += " WHERE ";
			if (bStrasse) {
				query += "LOWER(adresse.strasse) like '" + str + "%' ";
			}
			if (hausnr != null && hausnr != -1) {
				if (bStrasse) {
					query += " AND ";
				}
				query += " adresse.hausnr = " + hausnr;
			}
			if (bOrt) {
				if (bStrasse || bHausnr) {
					query += " AND ";
				}
				query += " LOWER(adresse.ort) like '" + ort.toLowerCase() + "%' ";
			}
			query += " AND adresse.deleted = false";
		}
		query += " ORDER BY adresse.strasse ASC, adresse.hausnr ASC, adresse.hausnrzus ASC, adresse.betrname ASC";
		return HibernateSessionFactory.currentSession().createQuery(query).list();
	}

	/**
	 * Returns a List of Adresse objects matching the given parameters and having a
	 * connection to a BasisMapAdresseLage object
	 * 
	 * Output format is List<[Adresse]>
	 * 
	 * @param search
	 *            String Betreibername
	 * @param property
	 *            String
	 * @return <code>List&lt;Adresse[]&gt;</code>
	 */

	public static List<Adresse> findStandorte(String search, String property) {

		String query = "SELECT DISTINCT adresse " + "FROM Adresse as adresse";

		query += " WHERE ";

		query += " adresse.ort = 'Bielefeld' ";

		query += " AND ";

		query += "LOWER(adresse.betrname) like '" + search.toLowerCase() + "%' ";

		query += " ORDER BY adresse.strasse ASC, adresse.hausnr ASC, adresse.hausnrzus ASC, adresse.betrname ASC";
		return HibernateSessionFactory.currentSession().createQuery(query).list();
	}

	/**
	 * Returns a List of all Adresse objects matching the given parameters
	 * 
	 * Output format is List<[Adresse]>
	 * 
	 * @param search
	 *            String Betreibername
	 * @param property
	 *            String
	 * @return <code>List&lt;Adresse[]&gt;</code>
	 */

	public static List<Adresse> findAdressen(String search, String property) {

		String query = "SELECT DISTINCT adresse " + "FROM Adresse adresse";

		query += " WHERE ";

		query += "LOWER(adresse.betrname) like '" + search.toLowerCase() + "%' AND adresse.deleted = false";

		query += " ORDER BY adresse.strasse ASC, adresse.hausnr ASC, adresse.hausnrzus ASC, adresse.betrname ASC";
		return HibernateSessionFactory.currentSession().createQuery(query).list();
	}

	/**
	 * Returns a List of all Adresse objects matching the given parameters
	 * 
	 * Output format is List<[Adresse]>
	 * 
	 * @param search
	 *            String Betreibername
	 * @param property
	 *            String
	 * @return <code>List&lt;Adresse[]&gt;</code>
	 */

	public static List<Adresse> findAdressen(String name, String strasse, Integer hausnr, String ort, String property) {

		boolean bName = (name != null && name.length() > 0);
		boolean bStrasse = (strasse != null && strasse.length() > 0);
		boolean bHausnr = (hausnr != null && hausnr != -1);
		boolean bOrt = (ort != null && ort.length() > 0);

		String query = "SELECT adresse " + "FROM Adresse adresse";
		if (bName || bStrasse || bHausnr || bOrt) {
			query += " WHERE ";
			if (bName && property == null) {
				query += "(LOWER(adresse.betrname) like '" + name.toLowerCase() + "%' OR LOWER(betrvorname) like '"
						+ name.toLowerCase() + "%' OR LOWER(betranrede) like '" + name.toLowerCase()
						+ "%' OR LOWER(betrnamezus) like '" + name.toLowerCase() + "') AND ";
			} else if (bName && property.equals("anrede")) {
				query += "LOWER(adresse.betranrede) like '" + name.toLowerCase() + "%' AND ";
			} else if (bName && property.equals("vorname")) {
				query += "LOWER(adresse.betrvorname) like '" + name.toLowerCase() + "%' AND ";
			} else if (bName && property.equals("name")) {
				query += "LOWER(adresse.betrname) like '" + name.toLowerCase() + "%' AND ";
			}

			else if (bName && property.equals("zusatz")) {
				query += "LOWER(adresse.betrnamezus) like '" + name.toLowerCase() + "%' AND ";
			}
			if (bStrasse) {
				query += "LOWER(adresse.strasse) like '" + strasse.toLowerCase() + "%' AND ";
			}
			if (bHausnr) {
				query += "adresse.hausnr = " + hausnr + " AND ";
			}
			if (bOrt) {
				query += "LOWER(adresse.ort) like '" + ort.toLowerCase() + "%' AND ";
			}

			query += "adresse.deleted = false ";

			query += "ORDER BY adresse.strasse ASC, adresse.hausnr ASC, adresse.hausnrzus ASC, adresse.betrname ASC";
		}
		return HibernateSessionFactory.currentSession().createQuery(query).list();
	}

	private static String[] entwaesserungsgebiete = null;

	/**
	 * Get a list of all Entwässerungsgebiet Ids.
	 * 
	 * @return <code>String[]</code>
	 */
	public static String[] getEntwaesserungsgebiete() {
		if (DatabaseBasisQuery.entwaesserungsgebiete == null) {
			DatabaseBasisQuery.entwaesserungsgebiete = new DatabaseAccess().executeCriteriaToArray(DetachedCriteria
					.forClass(Lage.class).setProjection(Projections.distinct(Projections.property("entgebid")))
					.addOrder(Order.asc("entgebid")), new String[0]);
		}
		return DatabaseBasisQuery.entwaesserungsgebiete;
	}

	public static List<TabStreets> findStandorte(String strasse) {
		return new DatabaseAccess().executeCriteriaToList(
				DetachedCriteria.forClass(TabStreets.class).add(Restrictions.eq("name", strasse))
						.addOrder(Order.asc("hausnr")).addOrder(Order.asc("hausnrZusatz").nulls(NullPrecedence.FIRST)),
				new TabStreets());
	}

	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	/* Queries for package BASIS : class BasisTabStreets */
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

	public static List<TabStreets> getTabStreetslist(MatchMode mm) {

		DetachedCriteria dc = DetachedCriteria.forClass(TabStreets.class).addOrder(Order.asc("name"));

		List<TabStreets> tabstreetslist = new DatabaseAccess().executeCriteriaToList(dc, new TabStreets());

		return tabstreetslist;

	}

	/**
	 * Get BasisTabStreets
	 * 
	 * @return <code>Eine Liste aller Strassennamen</code>
	 */
	public static String[] getTabStreets() {

		List<String> basisAllTabStreets = getAllTabStreetslist();

		String[] tabStreets = new String[basisAllTabStreets.size()];
		return tabStreets = basisAllTabStreets.toArray(tabStreets);

	}

	/**
	 * Get all BasisTabStreets and sort them by their name
	 * 
	 * @return <code>Eine Liste aller Stassen</code>
	 */
	public static List<String> getAllTabStreetslist() {

		String query = "SELECT DISTINCT name " + "FROM TabStreets ORDER BY name";

		return HibernateSessionFactory.currentSession().createQuery(query).list();

	}

	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	/* Queries for package BASIS : class Strassen */
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

	/**
	 * Get all Strassen sorted by strasse
	 * 
	 * @return <code>Strassen[]</code>
	 */
	public static Strassen[] getAllStrassen() {

		List<Strassen> basisAllStrassen = getAllStrassenlist();

		return basisAllStrassen.toArray(new Strassen[0]);
	}

	/**
	 * Get all Strassen and sort them by their name
	 * 
	 * @return <code>Eine Liste aller Stassen</code>
	 */
	public static List<Strassen> getAllStrassenlist() {
		List<Strassen> strassenlist = new DatabaseAccess().executeCriteriaToList(
				DetachedCriteria.forClass(Strassen.class).addOrder(Order.asc("strasse")), new Strassen());
		return strassenlist;

	}

	/**
	 * Get Strassen sorted by strasse
	 * 
	 * @return <code>Strassen[]</code>
	 */
	public static Strassen[] getStrassen(String ort, MatchMode mm) {

		List<Strassen> basisStrassen = getStrassenlist(ort, mm);

		return basisStrassen.toArray(new Strassen[0]);
	}

	/**
	 * Get Strassen filtered by plzort and sort them by their name
	 * 
	 * @return <code>Eine Liste aller Stassen</code>
	 */
	public static List<Strassen> getStrassenlist(String ort, MatchMode mm) {

		DetachedCriteria dc = DetachedCriteria.forClass(Strassen.class).addOrder(Order.asc("strasse"));

		// if (!StringUtils.isNullOrEmpty(plz))
		// {
		// dc = dc.add(Restrictions.like("plz", plz, mm));
		// }

		if (!StringUtils.isNullOrEmpty(ort)) {
			dc = dc.add(Restrictions.like("ort", ort, mm));
		}

		List<Strassen> strassenlist = new DatabaseAccess().executeCriteriaToList(dc, new Strassen());

		return strassenlist;

	}

	/**
	 * Get the first matching BasisStrasse for the search String
	 * 
	 * @param search
	 *            String
	 * @return <code>Strassen</code>
	 */
	public static Strassen findStrasse(String search) {
		List<Strassen> list = new DatabaseAccess().executeCriteriaToList(DetachedCriteria.forClass(Strassen.class)
				.add(Restrictions.ilike("strasse", search, MatchMode.START)).addOrder(Order.asc("strasse")),
				new Strassen());
		// If we got something, just return the first result
		return (list.isEmpty() ? null : list.get(0));
	}

	/**
	 * Get next id for new Strassen
	 * 
	 * @return <code>StrassenID</code>
	 */
	public static Integer newStrassenID() {
		Integer id = new DatabaseAccess().executeCriteriaToUniqueResult(
				DetachedCriteria.forClass(Strassen.class).setProjection(Property.forName("id").max()), new Integer(0));
		return id + 1;
	}

	private static List<Orte> orte = null;

	/**
	 * Get cities sorted by zip code
	 * 
	 * @return <code>BasisStrassen[]</code>
	 */
	public static Orte[] getOrte() {

		if (orte == null) {
			orte = getOrtelist();
		}

		return orte.toArray(new Orte[0]);
	}

	/**
	 * Get cities sorted by zip code
	 * 
	 * @return <code>Liste aller Orte</code>
	 */
	public static List<Orte> getOrtelist() {

		if (orte == null) {
			DetachedCriteria dc = DetachedCriteria.forClass(Strassen.class).setProjection(
					Projections.distinct(Projections.projectionList().add(Projections.property("ort"), "ort")
					// .add(Projections.property("plz"), "plz")
					)).setResultTransformer(Transformers.aliasToBean(Orte.class)).addOrder(Order.asc("ort"))
			// .addOrder(Order.asc("plz"))
			;

			orte = new DatabaseAccess().executeCriteriaToList(dc, new Orte());
		}

		return orte;

	}

	private static Orte ort = null;

	/**
	 * Get city for a given street
	 * 
	 * @return <code>Einen Ort</code>
	 */
	public static Orte getOrt(String street) {

		// if (ort == null)
		{
			DetachedCriteria dc = DetachedCriteria.forClass(Strassen.class).setProjection(
					Projections.distinct(Projections.projectionList().add(Projections.property("ort"), "ort")
					// .add(Projections.property("plz"), "plz")
					)).setResultTransformer(Transformers.aliasToBean(Orte.class))
					.add(Restrictions.ilike("strasse", street, MatchMode.START)).addOrder(Order.asc("ort"))
			// .addOrder(Order.asc("plz"))
			;

			ort = new DatabaseAccess().executeCriteriaToUniqueResult(dc, new Orte());
		}

		return ort;

	}

	/* ********************************************************************** */
	/* Queries for package ATL */
	/* ********************************************************************** */

	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	/* Queries for package ATL : class Einheiten */
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

	/**
	 * Get all Einheiten and sort them by their name
	 * 
	 * @return <code>Eine Liste aller Einheiten</code>
	 */
	public static List<Einheiten> getEinheitenlist() {
		List<Einheiten> strassenlist = new DatabaseAccess().executeCriteriaToList(
				DetachedCriteria.forClass(Einheiten.class).addOrder(Order.asc("id")), new Einheiten());
		return strassenlist;

	}

	/**
	 * Get next id for new Einheiten
	 * 
	 * @return <code>EinheitenID</code>
	 */
	public static Integer newEinheitenID() {
		Integer id = new DatabaseAccess().executeCriteriaToUniqueResult(
				DetachedCriteria.forClass(Einheiten.class).setProjection(Property.forName("id").max()), new Integer(0));
		return id + 1;
	}

	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	/* Queries for package ATL : class Parameter */
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

	/**
	 * Get all Parameter and sort them by their name
	 * 
	 * @return <code>Eine Liste aller Parameter</code>
	 */
	public static List<Parameter> getParameterlist() {
		List<Parameter> parameterlist = new DatabaseAccess().executeCriteriaToList(
				DetachedCriteria.forClass(Parameter.class).addOrder(Order.asc("id")), new Parameter());
		return parameterlist;
	}

	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	/* Queries for package ATL : class Klaeranlage */
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

	/**
	 * Get all Klaeranlage and sort them by their name
	 * 
	 * @return <code>Eine Liste aller Parameter</code>
	 */
	public static List<Klaeranlage> getKlaeranlagelist() {
		List<Klaeranlage> klaeranlagenlist = new DatabaseAccess().executeCriteriaToList(
				DetachedCriteria.forClass(Klaeranlage.class).addOrder(Order.asc("id")), new Klaeranlage());
		return klaeranlagenlist;
	}

	/**
	 * Get next id for new Klaeranlage
	 * 
	 * @return <code>KlaeranlageID</code>
	 */
	public static Integer newKlaeranlageID() {
		Integer id = new DatabaseAccess().executeCriteriaToUniqueResult(
				DetachedCriteria.forClass(Klaeranlage.class).setProjection(Property.forName("id").max()),
				new Integer(0));
		return id + 1;
	}

	/* ********************************************************************** */
	/* Queries for package VAWS */
	/* ********************************************************************** */

	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	/* Queries for package VAWS : class VawsWasserschutzgebiete */
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

	/**
	 * Get all VawsWasserschutzgebiete and sort them by their name
	 * 
	 * @return <code>Eine Liste aller Wasserschutzgebiete</code>
	 */
	public static List<Wassereinzugsgebiet> getWasserschutzgebietelist() {
		List<Wassereinzugsgebiet> wsglist = new DatabaseAccess().executeCriteriaToList(
				DetachedCriteria.forClass(Wassereinzugsgebiet.class).addOrder(Order.asc("id")),
				new Wassereinzugsgebiet());
		return wsglist;

	}

	/**
	 * Get next id for new Wassereinzugsgebiet
	 * 
	 * @return <code>WassereinzugsgebietID</code>
	 */
	public static Integer newWSGID() {
		Integer id = new DatabaseAccess().executeCriteriaToUniqueResult(
				DetachedCriteria.forClass(Wassereinzugsgebiet.class).setProjection(Property.forName("id").max()),
				new Integer(0));
		return id + 1;
	}

}
