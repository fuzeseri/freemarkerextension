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
/**
 * 
 */
package com.glueball.rapidminer.report.freemarker.test;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.glueball.rapidminer.report.freemarker.Cell;
import com.glueball.rapidminer.report.freemarker.ReportContext;
import com.glueball.rapidminer.report.freemarker.util.ReportColumnType;
import com.rapidminer.example.Attribute;
import com.rapidminer.example.Example;
import com.rapidminer.tools.Ontology;

/**
 * @author karesz
 *
 */
public class CellTest {

	/**
	 * Cell instance to test it.
	 */
	private Cell cell;

	/**
	 * Test column name.
	 */
	private static final String COL_NAME = "colName";

	/**
	 * Test value for the nominal formatter tests.
	 */
	private static final String TEST_NOMINAL_VALUE = "testVal";

	/**
	 * Test value for the numerical formatter tests.
	 */
	private static final Double TEST_NUMERICAL_VALUE = 11.11D;

	/**
	 * Test value for the numerical formatter tests.
	 */
	private static final Double TEST_LONG_VALUE = 11D;

	/**
	 * Test value for the date formatter tests.
	 */
	private static final Date TEST_DATE_VALUE = new Date();

	/**
	 * Control value for the long formatter tests.
	 */
	private static final String FORMATTED_LONG = "11";

	/**
	 * Control value for the numerical formatter tests.
	 */
	private static final String FORMATTED_NUMERICAL = "11.11";

	/**
	 * Date format.
	 */
	private static final String DATE_FORMAT_STR = "yyyy-MM-dd hh:mm:ss";

	private static final SimpleDateFormat DATE_FOMRAT = new SimpleDateFormat(
			DATE_FORMAT_STR);

	/**
	 * Control value for the date formatter tests.
	 */
	private static final String FORMATTED_DATE = DATE_FOMRAT
			.format(TEST_DATE_VALUE);

	/**
	 * Mocked Example instance.
	 */
	private final Example ex = Mockito.mock(Example.class);

	/**
	 * Mocked Attribute instance.
	 */
	private final Attribute attr = Mockito.mock(Attribute.class);

	/**
	 * Initialization method.
	 *
	 * @throws java.lang.Exception
	 *             on any error.
	 */
	@Before
	public void setUp() throws Exception {

		final ReportContext ctx = new ReportContext();
		ctx.setFormatNumbers(true);
		ctx.setDateFormat(DATE_FOMRAT);

		Mockito.when(attr.getName()).thenReturn(COL_NAME);

		cell = new Cell(ex, attr, ctx);
	}

	/**
	 * Test method for
	 * {@link com.glueball.rapidminer.report.freemarker.Cell#getColName()}.
	 */
	@Test
	public final void testGetColName() {

		assertEquals(COL_NAME, cell.getColName());
	}

	/**
	 * Test method for
	 * {@link com.glueball.rapidminer.report.freemarker.Cell#getType()}.
	 */
	@Test
	public final void testGetType() {

		Mockito.when(attr.getValueType()).thenReturn(0);
		assertEquals(ReportColumnType.TEXT, cell.getType());

		Mockito.when(attr.getValueType()).thenReturn(1);
		assertEquals(ReportColumnType.TEXT, cell.getType());

		Mockito.when(attr.getValueType()).thenReturn(2);
		assertEquals(ReportColumnType.REAL, cell.getType());

		Mockito.when(attr.getValueType()).thenReturn(3);
		assertEquals(ReportColumnType.INTEGER, cell.getType());

		Mockito.when(attr.getValueType()).thenReturn(4);
		assertEquals(ReportColumnType.REAL, cell.getType());

		Mockito.when(attr.getValueType()).thenReturn(5);
		assertEquals(ReportColumnType.TEXT, cell.getType());

		Mockito.when(attr.getValueType()).thenReturn(6);
		assertEquals(ReportColumnType.TEXT, cell.getType());

		Mockito.when(attr.getValueType()).thenReturn(7);
		assertEquals(ReportColumnType.TEXT, cell.getType());

		Mockito.when(attr.getValueType()).thenReturn(8);
		assertEquals(ReportColumnType.TEXT, cell.getType());

		Mockito.when(attr.getValueType()).thenReturn(9);
		assertEquals(ReportColumnType.DATE, cell.getType());

		Mockito.when(attr.getValueType()).thenReturn(10);
		assertEquals(ReportColumnType.DATE, cell.getType());

		Mockito.when(attr.getValueType()).thenReturn(11);
		assertEquals(ReportColumnType.DATE, cell.getType());
	}

	/**
	 * Test method for
	 * {@link com.glueball.rapidminer.report.freemarker.Cell#getValue()}.
	 */
	@Test
	public final void testGetValueNominal() {

		Mockito.when(attr.isNominal()).thenReturn(true);
		Mockito.when(ex.getValueAsString(attr)).thenReturn(TEST_NOMINAL_VALUE);

		assertEquals(TEST_NOMINAL_VALUE, cell.getValue());
	}

	/**
	 * Test method for
	 * {@link com.glueball.rapidminer.report.freemarker.Cell#getValue()}.
	 */
	@Test
	public final void testGetValueNumerical() {

		Mockito.when(attr.isNumerical()).thenReturn(true);
		Mockito.when(attr.getValueType()).thenReturn(Ontology.REAL);
		Mockito.when(ex.getNumericalValue(attr)).thenReturn(
				TEST_NUMERICAL_VALUE);

		assertEquals(FORMATTED_NUMERICAL, cell.getValue());
	}

	/**
	 * Test method for
	 * {@link com.glueball.rapidminer.report.freemarker.Cell#getValue()}.
	 */
	@Test
	public final void testGetValueLong() {

		Mockito.when(attr.isNumerical()).thenReturn(true);
		Mockito.when(attr.getValueType()).thenReturn(Ontology.INTEGER);
		Mockito.when(ex.getNumericalValue(attr)).thenReturn(TEST_LONG_VALUE);

		assertEquals(FORMATTED_LONG, cell.getValue());
	}

	/**
	 * Test method for
	 * {@link com.glueball.rapidminer.report.freemarker.Cell#getValue()}.
	 */
	@Test
	public final void testGetValueDate() {

		Mockito.when(attr.isDateTime()).thenReturn(true);
		Mockito.when(ex.getDateValue(attr)).thenReturn(TEST_DATE_VALUE);

		assertEquals(FORMATTED_DATE, cell.getValue());
	}

	/**
	 * Test method for
	 * {@link com.glueball.rapidminer.report.freemarker.Cell#toString()}.
	 */
	@Test
	public final void testToString() {

		Mockito.when(attr.isNominal()).thenReturn(true);
		Mockito.when(ex.getValueAsString(attr)).thenReturn(TEST_NOMINAL_VALUE);

		assertEquals(cell.getValue(), cell.toString());
	}

}
