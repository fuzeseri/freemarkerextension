package com.glueball.rapidminer.report.freemarker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.rapidminer.example.Attribute;

public final class ReportColumns {

	private final Iterator<Attribute> attrs;

	/**
	 * @param columns
	 */
	public ReportColumns(final Iterator<Attribute> attributes) {

		this.attrs = attributes;
	}

	public final List<ReportColumn> getColumns() {

		final List<ReportColumn> cols = new ArrayList<ReportColumn>();

		while (attrs.hasNext()) {

			cols.add(new ReportColumn(attrs.next()));
		}
		return cols;
	}
}
