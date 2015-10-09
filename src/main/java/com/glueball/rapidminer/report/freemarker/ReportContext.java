/**
 * RapidMiner GmbH
 *
 * Copyright (C) 2015-2015 by RapidMiner GmbH and the contributors
 *
 * Complete list of developers available at our web site:
 *
 *      www.rapidminer.com
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see http://www.gnu.org/licenses/.
 */
package com.glueball.rapidminer.report.freemarker;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;

/**
 * Represents report context. It contains the current configuration of the
 * outputs.
 *
 * @author karesz
 *
 */
public final class ReportContext {

	// /**
	// * Default date format.
	// */
	// // todo: it should depend on the localization.
	// private static final String DEFAULT_DATE_FORMAT = "yyyy-mm-dd hh:mm:ss";

	/**
	 * Date formatter instance.
	 */
	private SimpleDateFormat dateFormat;
	// = new SimpleDateFormat(
	// DEFAULT_DATE_FORMAT);

	/**
	 * Default null value.
	 */
	private static final String DEFAULT_NULL_VALUE = "";

	/**
	 * The string to replace the null values with in the output.
	 */
	private String nullValue = DEFAULT_NULL_VALUE;

	/**
	 * Number formatter instance. Initialized by default.
	 */
	private NumberFormat numberFormat = NumberFormat.getInstance();

	/**
	 * Format numbers by default in the output.
	 */
	private boolean formatNumbers = false;

	/**
	 * true if the nominal values should be quoted.
	 */
	private boolean quoteNominal = false;

	/**
	 * true if the numerical values should be quoted.
	 */
	private boolean quoteNumerical = false;

	/**
	 * true if the date time values should be quoted.
	 */
	private boolean quoteDateTime = false;

	/**
	 * Quote string for values;
	 */
	private String quoteStr = "";

	/**
	 * @return the dateFormat
	 */
	public SimpleDateFormat getDateFormat() {

		return dateFormat;
	}

	/**
	 * @param dateFormat
	 *            the dateFormat to set
	 */
	public void setDateFormat(final SimpleDateFormat dateFormat) {

		this.dateFormat = dateFormat;
	}

	/**
	 * @return the nullValue
	 */
	public String getNullValue() {

		return nullValue;
	}

	/**
	 * @param nullValue
	 *            the nullValue to set
	 */
	public void setNullValue(final String nullValue) {

		this.nullValue = nullValue;
	}

	/**
	 * @return the numberFormat
	 */
	public NumberFormat getNumberFormat() {

		return numberFormat;
	}

	/**
	 * @param numberFormat
	 *            the numberFormat to set
	 */
	public void setNumberFormat(final NumberFormat numberFormat) {

		this.numberFormat = numberFormat;
	}

	/**
	 * @return the quoteNominal
	 */
	public final boolean isQuoteNominal() {
		return quoteNominal;
	}

	/**
	 * @param quoteNominal
	 *            the quoteNominal to set
	 */
	public final void setQuoteNominal(final boolean quoteNominal) {
		this.quoteNominal = quoteNominal;
	}

	/**
	 * @return the quoteNumerical
	 */
	public final boolean isQuoteNumerical() {
		return quoteNumerical;
	}

	/**
	 * @param quoteNumerical
	 *            the quoteNumerical to set
	 */
	public final void setQuoteNumerical(final boolean quoteNumerical) {
		this.quoteNumerical = quoteNumerical;
	}

	/**
	 * @return the quoteDateTime
	 */
	public final boolean isQuoteDateTime() {
		return quoteDateTime;
	}

	/**
	 * @param quoteDateTime
	 *            the quoteDateTime to set
	 */
	public final void setQuoteDateTime(final boolean quoteDateTime) {
		this.quoteDateTime = quoteDateTime;
	}

	/**
	 * @return the quoteStr
	 */
	public final String getQuoteStr() {
		return quoteStr;
	}

	/**
	 * @param quoteStr
	 *            the quoteStr to set
	 */
	public final void setQuoteStr(final String quoteStr) {
		this.quoteStr = quoteStr;
	}

	/**
	 * @return the formatNumbers
	 */
	public final boolean isFormatNumbers() {
		return formatNumbers;
	}

	/**
	 * @param formatNumbers
	 *            the formatNumbers to set
	 */
	public final void setFormatNumbers(final boolean formatNumbers) {
		this.formatNumbers = formatNumbers;
	}

}
