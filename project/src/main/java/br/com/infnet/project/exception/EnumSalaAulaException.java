package br.com.infnet.project.exception;

public class EnumSalaAulaException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EnumSalaAulaException() {
		super("Número da sala de aula inválido.");
	}
}