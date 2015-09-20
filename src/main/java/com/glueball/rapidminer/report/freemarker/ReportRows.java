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
import java.util.List;

import com.rapidminer.example.Example;
import com.rapidminer.example.ExampleSet;

/**
 * @author karesz
 *
 */
public final class ReportRows {

	/**
	 * Hidden constructor.
	 */
	private ReportRows() {
	}

	/**
	 * Helper method to provide the list of rows.
	 *
	 * @param es
	 *            the RapidMiner ExampleSet.
	 * @return the list of rows.
	 */
	public static final List<ReportRow> getRows(final ExampleSet es) {

		final List<ReportRow> rows = new ArrayList<ReportRow>();

		for (final Example ex : es) {

			rows.add(new ReportRow(ex));
		}
		return rows;
	}
}
