package br.com.infnet.project.enums;

public enum EnumParentesco {

	PAI('P'), MAE('M'), OUTROS('O');

	public char parentesco;

	EnumParentesco(char parentesco) {
		this.parentesco = parentesco;
	}

	public char getParentesco() {
		return this.parentesco;
	}
}