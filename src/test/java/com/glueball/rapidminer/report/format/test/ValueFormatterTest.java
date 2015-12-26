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
package com.glueball.rapidminer.report.format.test;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.glueball.rapidminer.report.format.ValueFormatter;
import com.glueball.rapidminer.report.freemarker.ReportContext;
import com.rapidminer.example.Attribute;
import com.rapidminer.example.Example;

/**
 * Test cases for the ValueFormatter utility class.
 *
 * @author karesz
 *
 */
public class ValueFormatterTest {

	/**
	 * Attribute instance.
	 */
	private Attribute attr;

	/**
	 * Example instance.
	 */
	private Example ex;

	/**
	 * Test value for the nominal formatter tests.
	 */
	private static final String TEST_NOMINAL_VALUE = "testVal";

	/**
	 * Test value for the numerical formatter tests.
	 */
	private static final Double TEST_NUMERICAL_VALUE = 11.11D;

	/**
	 * Test value for the date formatter tests.
	 */
	private static final Date TEST_DATE_VALUE = new Date();

	/**
	 * Quote string for the quoted output tests.
	 */
	private static final String QUOTE_STRING = "'";

	/**
	 * Control value for the long formatter tests.
	 */
	private static final String FORMATTED_LONG = "11";

	/**
	 * Control value for the numerical formatter tests.
	 */
	private static final String FORMATTED_NUMERICAL = "11.11";

	/**
	 * Control value for the date formatter tests.
	 */
	private static final String FORMATTED_DATE = new SimpleDateFormat(
			"yyyy-MM-dd hh:mm:ss").format(TEST_DATE_VALUE);

	/**
	 * Initialization method.
	 *
	 * @throws Exception
	 *             on any Error.
	 */
	@Before
	public void setUp() throws Exception {

		attr = Mockito.mock(Attribute.class);
		ex = Mockito.mock(Example.class);

		Mockito.when(ex.getValueAsString(attr)).thenReturn(TEST_NOMINAL_VALUE);
		Mockito.when(ex.getNumericalValue(attr)).thenReturn(
				TEST_NUMERICAL_VALUE);

		Mockito.when(ex.getDateValue(attr)).thenReturn(TEST_DATE_VALUE);
	}

	/**
	 * Test method for
	 * {@link com.glueball.rapidminer.report.format.ValueFormatter #formatNominal()}
	 * .
	 */
	@Test
	public final void testFormatNominal() {

		final ReportContext context = new ReportContext();
		context.setFormatNumbers(true);

		assertEquals(TEST_NOMINAL_VALUE,
				ValueFormatter.formatNominal(attr, ex, context));

		context.setQuoteNominal(true);
		context.setQuoteStr(QUOTE_STRING);

		assertEquals(QUOTE_STRING + TEST_NOMINAL_VALUE + QUOTE_STRING,
				ValueFormatter.formatNominal(attr, ex, context));
	}

	/**
	 * Test method for
	 * {@link com.glueball.rapidminer.report.format.ValueFormatter #formatLong()}
	 * .
	 */
	@Test
	public final void testFormatLong() {

		final ReportContext context = new ReportContext();
		context.setFormatNumbers(true);

		assertEquals(FORMATTED_LONG,
				ValueFormatter.formatLong(attr, ex, context));

		context.setQuoteNumerical(true);
		context.setQuoteStr(QUOTE_STRING);

		assertEquals(QUOTE_STRING + FORMATTED_LONG + QUOTE_STRING,
				ValueFormatter.formatLong(attr, ex, context));
	}

	/**
	 * Test method for
	 * {@link com.glueball.rapidminer.report.format.ValueFormatter #formatNumerical()}
	 * .
	 */
	@Test
	public final void testFormatNumerical() {

		final ReportContext context = new ReportContext();
		context.setFormatNumbers(true);

		assertEquals(FORMATTED_NUMERICAL,
				ValueFormatter.formatNumerical(attr, ex, context));

		context.setQuoteNumerical(true);
		context.setQuoteStr(QUOTE_STRING);

		assertEquals(QUOTE_STRING + FORMATTED_NUMERICAL + QUOTE_STRING,
				ValueFormatter.formatNumerical(attr, ex, context));
	}

	/**
	 * Test method for
	 * {@link com.glueball.rapidminer.report.format.ValueFormatter #formatDateTime()}
	 * .
	 */
	@Test
	public final void testFormatDateTime() {

		final ReportContext context = new ReportContext();
		context.setDateFormat(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"));

		assertEquals(FORMATTED_DATE,
				ValueFormatter.formatDateTime(attr, ex, context));

		context.setQuoteDateTime(true);
		context.setQuoteStr(QUOTE_STRING);

		assertEquals(QUOTE_STRING + FORMATTED_DATE + QUOTE_STRING,
				ValueFormatter.formatDateTime(attr, ex, context));
	}
}
