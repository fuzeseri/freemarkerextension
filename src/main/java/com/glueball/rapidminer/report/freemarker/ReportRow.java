package com.glueball.rapidminer.report.freemarker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.rapidminer.example.Attribute;
import com.rapidminer.example.Example;

public class ReportRow {

	private final Example ex;

	public ReportRow(final Example example) {

		this.ex = example;
	}

	public List<Cell> getCells() {

		final List<Cell> cells = new ArrayList<Cell>();

		final Iterator<Attribute> it = ex.getAttributes().allAttributes();

		while (it.hasNext()) {

			cells.add(new Cell(ex, it.next()));
		}
		return cells;
	}
}
