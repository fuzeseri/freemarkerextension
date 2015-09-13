package com.glueball.rapidminer.report.freemarker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.rapidminer.example.Example;

public final class ReportRows {

	private final Iterator<Example> ex;

	public ReportRows(Iterator<Example> it) {

		this.ex = it;
	}

	public final List<ReportRow> getRows() {

		final List<ReportRow> rows = new ArrayList<ReportRow>();

		while (ex.hasNext()) {

			rows.add(new ReportRow(ex.next()));
		}
		return rows;
	}
}
