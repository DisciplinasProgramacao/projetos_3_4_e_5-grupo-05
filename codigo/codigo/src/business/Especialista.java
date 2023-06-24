package business;

import java.util.Date;
import java.util.List;

public class Especialista extends Cliente implements IEspecialista {

 //       Declaração de variáveis
  
	public static String estado = "Especialista";
	public Especialista(String nome, String senha, String login) {
		super(nome, senha, login);
		// TODO Auto-generated constructor stub
	}
	
	//@Override
	public Especialista(String nome, String senha, String login, List<Conteudo> listaParaVer, List<Conteudo> listaJaVista, List<Date>  listaDatasAssistidas) {
        super( nome, senha, login, listaParaVer, listaJaVista, listaDatasAssistidas);
    } 
  //------------------------------------ 


	// @Override
	// public void comentar() {
		
		
	// }

}
