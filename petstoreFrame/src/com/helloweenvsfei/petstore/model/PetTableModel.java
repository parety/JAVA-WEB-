package com.helloweenvsfei.petstore.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.helloweenvsfei.petstore.entity.PetEO;

public class PetTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 9150627867821655867L;

	/** 表格数据 */
	public List<PetEO> list = new ArrayList<PetEO>();

	/** 表头信息 */
	public final String[] header = { "编号", "名称", "类别", "价格", };

	/** 返回列名 */
	@Override
	public String getColumnName(int column) {
		return header[column];
	}

	/** 返回列数 */
	public int getColumnCount() {
		return header.length;
	}

	/** 返回行数 */
	public int getRowCount() {
		return list.size();
	}

	/** 返回 rowIndex 行，columnIndex 列 单元格的值 */
	public Object getValueAt(int rowIndex, int columnIndex) {
		PetEO pet = list.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return pet.getId();
		case 1:
			return pet.getName();
		case 2:
			return pet.getCategory().getName();
		case 3:
			return pet.getPrice();
		}
		return null;
	}

	/** 返回 rowIndex 行，columnIndex 列 单元格是否可编辑 */
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return super.isCellEditable(rowIndex, columnIndex);
	}

	/** 修改 rowIndex 行，columnIndex 列 单元格 */
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		super.setValueAt(aValue, rowIndex, columnIndex);
	}

	public List<PetEO> getList() {
		return list;
	}

	public void setList(List<PetEO> list) {
		this.list = list;
	}

}