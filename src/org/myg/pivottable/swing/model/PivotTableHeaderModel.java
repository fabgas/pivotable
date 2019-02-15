package org.myg.pivottable.swing.model;

import java.util.List;

import org.myg.pivottable.swing.cells.ICell;
/**
 * Cells model for a header. It could be a RowHeader or a Column Header
 * Both defines a PivotTableHeader
 * @author GASTINEAU
 *
 */
public interface PivotTableHeaderModel {
	// Model modification by adding, removing cells
	/**
	 * add a cell to this model
	 * @param newCell
	 * @return
	 */
	public ICell addCell(ICell newCell,ICell neighbour, ICell parent);
	/**
	 * remove a cell from this model
	 * @param cellToBeRemoved
	 */
	public void  removeCell(ICell cellToBeRemoved);
	
	/**
	 * move cell from its current position to another position
	 * @param cellTopBeMoved
	 * @param neighbour
	 * @param parent
	 */
	public void  moveCell(ICell cellTopBeMoved, ICell neighbour, ICell parent);
	
	// ask to the model some information
	/**
	 * Return the column number
	 * @return
	 */
	public Integer	getCellCount();
	
	/**
	 * Return the cells
	 * @return
	 */
	public List<ICell> getColumns();
	
	/**
	 * Return the cell corresponding to the id
	 * @param id
	 * @return
	 */
	public ICell getColumn(String id);
	
	/**
	 * Return the cell at the (x,y) position
	 * @param xPosition
	 * @param yPosition
	 * @return
	 */
	public ICell getColumnIndexAtX(int xPosition,int yPosition);
	
	/**
	 * Return the total width if this header
	 * @return
	 */
	public Integer getTotalColumnWidth();
	
	/**
	 * return the total height of this header;
	 * @return
	 */
	public Integer getTotalColumnHeight();

	// missed somme selection model stuff and also listeners
	
}
