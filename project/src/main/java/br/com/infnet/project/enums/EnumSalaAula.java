package br.com.infnet.project.enums;

public enum EnumSalaAula {

	CIE(210), GEO(211), HIS(212), MAT(213), POR(214);

	public int numeroSala;

	EnumSalaAula(int numeroSala) {
		this.numeroSala = numeroSala;
	}

	public int getNumSalaAula() {
		return this.numeroSala;
	}

	public static String devolverMateria(int numSala) {

		String materia = "";

		switch (numSala) {
		case 210:
			materia = "Ciências";
			break;
		case 211:
			materia = "Geografia";
			break;
		case 212:
			materia = "História";
			break;
		case 213:
			materia = "Matemática";
			break;
		case 214:
			materia = "Português";
			break;
		default:
			materia = "Ciências";
			break;
		}
		return materia;
	}
}