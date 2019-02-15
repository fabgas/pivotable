package org.myg.pivottable.swing.layer.rowheader;

import java.awt.Component;
import java.awt.Graphics;
import java.util.Iterator;
import java.util.List;

import javax.swing.JComponent;

import org.myg.pivottable.swing.cells.ICell;
import org.myg.pivottable.swing.layer.BasicPivotTableHeaderUI;
import org.myg.pivottable.swing.layer.PivotTableHeader;

public class BasicPivotTableRowHeaderUI extends BasicPivotTableHeaderUI {

	PivotTableHeader header = null;
	
	/**
	 * Paint the cells .
	 */
	@Override
	public void paint(Graphics g, JComponent c) {
		// header : get the model!
		// go over the cells and  print them.
			
		super.paint(g, c);
	}

	/**
	 * Recursive methods : paint the main cells and then paint the childs
	 */
	private void paintCells(List<ICell> cells,Graphics g, JComponent c ) {
		if (cells!=null) {
			for (Iterator iterator = cells.iterator(); iterator.hasNext();) {
				ICell iCell = (ICell) iterator.next();
				paintCells(cells, g, c);
				// paint the current cell
				paintCells(iCell.getChilds(),g,  c);
				// paint the child
			}
		}
	}

	/**
	 * Return the renderer for the cell
	 */
	@Override
	protected Component getHeaderCellRenderer(ICell cell) {
		return header.prepareRenderer(null,cell);
	}
	
}
