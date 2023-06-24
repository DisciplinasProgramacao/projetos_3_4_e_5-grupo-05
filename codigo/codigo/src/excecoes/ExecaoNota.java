package excecoes;

public class ExecaoNota extends Exception {
	public ExecaoNota() {
		super("O valor informado está fora do intervalo válido (1 a 5).");
	}
}
