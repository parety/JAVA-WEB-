package com.helloweenvsfei.petstore.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.helloweenvsfei.petstore.entity.PetEO;

public class PetTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 9150627867821655867L;

	/** ������� */
	public List<PetEO> list = new ArrayList<PetEO>();

	/** ��ͷ��Ϣ */
	public final String[] header = { "���", "����", "���", "�۸�", };

	/** �������� */
	@Override
	public String getColumnName(int column) {
		return header[column];
	}

	/** �������� */
	public int getColumnCount() {
		return header.length;
	}

	/** �������� */
	public int getRowCount() {
		return list.size();
	}

	/** ���� rowIndex �У�columnIndex �� ��Ԫ���ֵ */
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

	/** ���� rowIndex �У�columnIndex �� ��Ԫ���Ƿ�ɱ༭ */
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return super.isCellEditable(rowIndex, columnIndex);
	}

	/** �޸� rowIndex �У�columnIndex �� ��Ԫ�� */
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