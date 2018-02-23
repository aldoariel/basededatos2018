package vista;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class TablaJTable extends AbstractTableModel {
	
	private List<String[]> registros = new ArrayList<String[]>();
	private String[] nombreColumna={"Id","Nombre"};

	@Override
	public int getColumnCount() {
		// cantidad de columnas
		return nombreColumna.length;
	}

	@Override
	public int getRowCount() {
		// cantidad de registros
		return registros.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// Indicar que valor va a mostrar en las filas y las columnas
		Object resultado = registros.get(rowIndex)[columnIndex];		
		return resultado;
	}
	
	//nombrar la columna
	public String getColumnName(int columnIndex){
		//dar nombres a las columnas
		return nombreColumna[columnIndex];
		
	}

	public List<String[]> getRegistros() {
		return registros;
	}

	public void setRegistros(List<String[]> registros) {
		this.registros = registros;
	}

	public String[] getNombreColumna() {
		return nombreColumna;
	}

	public void setNombreColumna(String[] nombreColumna) {
		this.nombreColumna = nombreColumna;
	}
	
	


}
