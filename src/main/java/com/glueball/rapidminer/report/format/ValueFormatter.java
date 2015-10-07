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
package com.glueball.rapidminer.report.format;

import com.glueball.rapidminer.report.freemarker.ReportContext;
import com.rapidminer.example.Attribute;
import com.rapidminer.example.Example;

/**
 * Helper class to format cell values based on the report context.
 *
 * @author karesz
 *
 */
public final class ValueFormatter {

	/**
	 * Hidden constructor.
	 */
	private ValueFormatter() {
	}

	/**
	 * Format the nominal value based on the context.
	 * 
	 * @param attr
	 *            the Attribute object.
	 * @param ex
	 *            the Example object.
	 * @param context
	 *            the report context.
	 * @return the formatted string value.
	 */
	public static String formatNominal(final Attribute attr, final Example ex,
			final ReportContext context) {

		String retVal = checkNull(attr, ex) ? context.getNullValue() : ex
				.getValueAsString(attr);

		if (context.isQuoteNominal()) {

			retVal = quoteValue(retVal, context);
		}

		return retVal;
	}

	/**
	 * Format the numerical value based on the context.
	 * 
	 * @param attr
	 *            the Attribute object.
	 * @param ex
	 *            the Example object.
	 * @param context
	 *            the report context.
	 * @return the formatted string value.
	 */
	public static String formatLong(final Attribute attr, final Example ex,
			final ReportContext context) {

		String retVal = checkNull(attr, ex) ? context.getNullValue() : (context
				.isFormatNumbers() ? context.getNumberFormat().format(
				(long) ex.getNumericalValue(attr)) : String.valueOf((long) ex
				.getNumericalValue(attr)));

		if (context.isQuoteNumerical()) {

			retVal = quoteValue(retVal, context);
		}

		return retVal;
	}

	/**
	 * Format the numerical value based on the context.
	 * 
	 * @param attr
	 *            the Attribute object.
	 * @param ex
	 *            the Example object.
	 * @param context
	 *            the report context.
	 * @return the formatted string value.
	 */
	public static String formatNumerical(final Attribute attr,
			final Example ex, final ReportContext context) {

		String retVal = checkNull(attr, ex) ? context.getNullValue() : (context
				.isFormatNumbers() ? context.getNumberFormat().format(
				ex.getNumericalValue(attr)) : ex.getValueAsString(attr));

		if (context.isQuoteNumerical()) {

			retVal = quoteValue(retVal, context);
		}

		return retVal;
	}

	/**
	 * Format the dateTime value based on the context.
	 * 
	 * @param attr
	 *            the Attribute object.
	 * @param ex
	 *            the Example object.
	 * @param context
	 *            the report context.
	 * @return the formatted string value.
	 */
	public static String formatDateTime(final Attribute attr, final Example ex,
			final ReportContext context) {

		String retVal = checkNull(attr, ex) ? context.getNullValue() : (context
				.getDateFormat() != null ? context.getDateFormat().format(
				ex.getDateValue(attr)) : ex.getValueAsString(attr));

		if (context.isQuoteDateTime()) {

			retVal = quoteValue(retVal, context);
		}

		return retVal;
	}

	private static boolean checkNull(final Attribute attr, final Example ex) {

		return Double.isNaN(ex.getValue(attr))
				|| "?".equals(ex.getValueAsString(attr));
	}

	private static String quoteValue(final String value,
			final ReportContext context) {

		return context.getQuoteStr() + value + context.getQuoteStr();
	}
}
