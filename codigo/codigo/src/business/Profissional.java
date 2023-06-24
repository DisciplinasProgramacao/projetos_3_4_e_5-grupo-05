package business;

public class Profissional extends Cliente implements IEspecialista {
  //       Declaração de variáveis
  
	public static String estado = "Proficional";


  //       Construtores
	public Profissional(String nome, String senha, String login) {
		super(nome, senha, login);
		// TODO Auto-generated constructor stub
	}
	
	
	// @Override
	// public void comentar() {
	// 	// TODO Auto-generated method stub
		
	// }

}
