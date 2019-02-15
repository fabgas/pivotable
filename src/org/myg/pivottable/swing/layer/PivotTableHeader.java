package org.myg.pivottable.swing.layer;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JComponent;

import org.myg.pivottable.swing.cells.ICell;
import org.myg.pivottable.swing.model.PivotTableHeaderModel;

public class PivotTableHeader extends JComponent {
	
	private PivotTableHeaderModel headerModel = null;

	public PivotTableHeaderModel getHeaderModel() {
		return headerModel;
	}

	public void setHeaderModel(PivotTableHeaderModel headerModel) {
		this.headerModel = headerModel;
	}
	
	
	public Component prepareRenderer(ICell column, ICell row) {
		
		return renderer.getTableCellRendererComponent(this,value, column, row,isSelected);
	}
	
	
	public PivotTableHeader() {
		super();
		this.setBackground(Color.WHITE);
		setOpaque(false); // important sinon les layers inférieurs sont non visibles !
		//Calculation of the initial bound
		setBounds(0,0,10000,1000); // important sinon les layers inférieurs sont non visibles
	}
}
