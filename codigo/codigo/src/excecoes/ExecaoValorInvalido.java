package excecoes;
public class ExecaoValorInvalido extends Exception {
	public ExecaoValorInvalido() {
		super("O valor informado é inválido.");
	}
}