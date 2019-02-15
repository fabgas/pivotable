package org.myg.pivottable.swing.layer;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.CellRendererPane;
import javax.swing.JComponent;
import javax.swing.LookAndFeel;
import javax.swing.plaf.ComponentUI;

import org.myg.pivottable.swing.cells.ICell;

public class BasicPivotTableHeaderUI extends PivotTableHeaderUI {
	
	// header reference 
	PivotTableHeader header 		= null;
	CellRendererPane rendererPane	=	null;
	
	
	 
	 public void paint(Graphics g, JComponent c) {
		 // why are they doing a renderPane.removeAll in the TableHeader class ?
	 }
	/**
	 * Share method to paint one cell of the header or a value cell.
	 * Derivative class calls this methods from paint method
	 * @param g
	 * @param cellRect
	 * @param columnIndex
	 */
	protected void paintCell(Graphics g, Rectangle cellRect, ICell cell) {
	        Component component = getHeaderRenderer(cell); 
	      
	        rendererPane.paintComponent(g, component, header, cellRect.x, cellRect.y,
	                            cellRect.width, cellRect.height, true);
	 }
    /**
     * Return the minimum size of the component.
     * Depends if it is a rowHeader, a columnHeader or a value Cell Header
     */
    public Dimension getMinimumSize(JComponent c) {
    	return new Dimension(0,0);
    }

    /**
     * Return the preferred size of the header. 
     * Depends if it is a rowHeader, a columnHeader or a value Cell Header
     */
    public Dimension getPreferredSize(JComponent c) {
    	return new Dimension(0,0);
    }

    /**
     * Return the maximum size of the header. 
     * Depends if it is a rowHeader, a columnHeader or a value Cell Header
     */
    public Dimension getMaximumSize(JComponent c) {
    	return new Dimension(0,0);
    }
	  
    protected Component getHeaderCellRenderer(ICell cell) { 
    	
		  return null;
	}
	
	  /**
	   * Create the UI component.Itself
	   * @param h
	   * @return
	   */
	 public static ComponentUI createUI(JComponent h) {
	        return new BasicPivotTableHeaderUI();
	}
	
	@Override
	public void installUI(JComponent c) {
		// do the link between pivotTableHeader and this class
		setHeader((PivotTableHeader)c);
		// initialize the pane
		rendererPane = new CellRendererPane();
	    header.add(rendererPane);
	    // initialize the default colors from Look and feel
	    installDefaults();
	}


    public void uninstallUI(JComponent c) {
        uninstallDefaults();
        header.remove(rendererPane);
        rendererPane = null;
        header = null;
    }

    
	public PivotTableHeader getHeader() {
		return header;
	}

	public void setHeader(PivotTableHeader header) {
		this.header = header;
	}
    /**
     * Initialize PivotTableHeader properties, e.g. font, foreground, and background.
     * The font, foreground, and background properties are only set if their
     * current value is either null or a UIResource, other properties are set
     * if the current value is null.
     * We used the JTable one 
     *
     * @see #installUI
     */
    protected void installDefaults() {
        LookAndFeel.installColorsAndFont(header, "TableHeader.background",
                                         "TableHeader.foreground", "TableHeader.font");
        LookAndFeel.installProperty(header, "opaque", Boolean.TRUE);
    }
    
   
    
    

    protected void uninstallDefaults() {}

 
  
}
