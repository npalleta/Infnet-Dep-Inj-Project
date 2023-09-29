package br.com.infnet.project.util;

import java.util.Random;

public class Funcoes {

	public static String gerarMatricula() {
		return String.valueOf(new Random().nextInt(10000) + 1);
	}
}