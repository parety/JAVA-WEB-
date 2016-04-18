package com.helloweenvsfei.petstore.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.helloweenvsfei.petstore.entity.CartItemEO;

public class CartTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 9150627867821655867L;

	private List<CartItemEO> list = new ArrayList<CartItemEO>();

	public final String[] header = { "宠物名称", "宠物类别", "购买价格", "购买数量", "购买时间", };

	public String getColumnName(int column) {
		return header[column];
	}

	public int getColumnCount() {
		return header.length;
	}

	public int getRowCount() {
		return list.size();
	}

	public Object getValueAt(int rowIndex, int columnIndex) {

		CartItemEO pet = list.get(rowIndex);

		switch (columnIndex) {
		case 0:
			return pet.getPetName();
		case 1:
			return pet.getPetCategoryName();
		case 2:
			return pet.getPrice();
		case 3:
			return pet.getCount();
		case 4:
			return pet.getDate();
		}

		return null;
	}

	public List<CartItemEO> getList() {
		return list;
	}

	public void setList(List<CartItemEO> list) {
		this.list = list;
	}

}