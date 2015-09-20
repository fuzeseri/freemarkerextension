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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.rapidminer.example.Attribute;
import com.rapidminer.example.Example;

/**
 * Represents a row fo the report Table.
 *
 * @author karesz
 *
 */
public class ReportRow {

	/**
	 * The RapidMiner Example.
	 */
	private final Example ex;

	/**
	 * Constructor.
	 *
	 * @param example
	 *            the RapidMiner Example.
	 */
	public ReportRow(final Example example) {

		this.ex = example;
	}

	/**
	 * 
	 * @return the list of cell.
	 */
	public List<Cell> getCells() {

		final List<Cell> cells = new ArrayList<Cell>();

		final Iterator<Attribute> it = ex.getAttributes().allAttributes();

		while (it.hasNext()) {

			cells.add(new Cell(ex, it.next()));
		}
		return cells;
	}
}
