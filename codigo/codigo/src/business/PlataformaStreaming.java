package business;
import excecoes.ExecaoNota;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collectors;

import excecoes.ExecaoNota;
import excecoes.ExecaoValorInvalido;

public class PlataformaStreaming {

	public static ArrayList<Conteudo> midia;


  //Declaração de variáveis

	private String nome;
	public static Map<Integer, Conteudo> conteudos;
	public static Map<String, Cliente> clientes;
	private static Cliente clienteAtual;



  // Construtor
  
	public PlataformaStreaming(String nome) {
		this.nome = nome;
		this.conteudos = new HashMap<Integer, Conteudo>();
		this.clientes = new HashMap<String, Cliente>();
		this.clienteAtual = null;
	}

    // Getters e Setters
  
  	public Cliente getClienteAtual() {
		return this.clienteAtual;
	}

	public Serie getSerie(int id) { 
		return (Serie) conteudos.get(id);
	}

	public Filme getFilme(int id) {
		return (Filme) conteudos.get(id);
	}

	public Cliente getCliente(String login) {
		return clientes.get(login);
	}

	public static Map<Integer, Conteudo> getConteudos() {
		return conteudos;
	}

	public Conteudo getConteudo(int id) {
		return conteudos.get(id);
	}
  
  /**Função de logar um usuário à plataforma
  *
  * @param login String - Campo login do usuário a ser conectado
  * @param senha String - Campo login do usuário a ser conectado
  * @return Cliente - Cliente que está usando a plataforma
  */
	public Cliente logar(String login, String senha) {
		this.clienteAtual = null;
		Cliente c = this.clientes.get(login);
		if (c != null && c.getSenha().equals(senha)) {
			System.out.println("Senha:" + c.getSenha());
			this.clienteAtual = c;
		}
		return clienteAtual;
	}



  /**Função para adicionar alguma nova série à plataforma
  *
  * @param serie Serie - Serie que será incluida na plataforma
  */
  
	public void adicionarSerie(Serie serie) throws ExecaoValorInvalido { /// transformar em um só
		boolean existia = false;
		int id = serie.getId();
		int idNovo = serie.getId();

		while (conteudos.get(serie.getId()) != null) {
			existia = true;
			serie.setId(idNovo++);
		}
		if (existia) {
			System.out.println("Já existia uma série com o id " + id + " ele será mudado para: " + serie.getId());
		}
		conteudos.put(serie.getId(), serie);
	}

  /**Função para adicionar algum novo filme à plataforma
  *
  * @param filme Filme - Filme que será incluido na plataforma
  */
  
	public static void adicionarFilme(Filme filme) throws ExecaoValorInvalido {
		boolean existia = false;
		int id = filme.getId();
		int idNovo = filme.getId();

		while (conteudos.get(filme.getId()) != null) {
			existia = true;
			filme.setId(idNovo++);
		}
		if (existia) {
			System.out.println("Já existia um filme com o id " + id + " ele será mudado para: " + filme.getId());
		}
		conteudos.put(filme.getId(), filme);
	}

  /** Função para adicionar algum novo trailer à plataforma
  *
  * @param trailer Trailer - Trailer que será incluido na plataforma
  */
  
	public static void adicionarTrailer(Trailer trailer) throws ExecaoValorInvalido {
		boolean existia = false;
		int id = trailer.getId();
		int idNovo = trailer.getId();

		while (conteudos.get(trailer.getId()) != null) {
			existia = true;
			trailer.setId(idNovo++);
		}
		if (existia) {
			System.out.println("Já existia um trailer com o id " + id + " ele será mudado para: " + trailer.getId());
		}
		conteudos.put(trailer.getId(), trailer);
	}

  /**Função para adicionar novo cliente na plataforma
  *
  * @param cliente Cliente - Cliente que será incluido na plataforma
  */
  
	public void adicionarCliente(Cliente cliente) {// Dá pra melhorar a robustez, é tranquilo// luiz~ melhorei...
		clientes.put(cliente.getLogin(), cliente);
	}

  /** Função de filtrar alguma mídia por nome
  *
  * @param nome String - Nome do conteúdo a ser filtrado
  * @return List<Conteudo> - Lista de conteúdos com o nome solicitado
  */

	public List<Conteudo> filtrarPorNome(String nome) {
        return conteudos.values().stream().filter((conteudo) -> conteudo.getNome() != null && conteudo.getNome().contains(nome))
                .collect(Collectors.toList());
    }

  /** Função de filtrar alguma mídia por gênero
  *
  * @param genero String - Gênero que deseja consultar 
  * @return List<Conteudo> - Lista de conteúdos disponíveis com o gênero solicitado
  */

	   public List<Conteudo> filtrarPorGenero(String genero) {
	        return conteudos.values().stream()
	                .filter((conteudo) -> conteudo.getGenero() != null && conteudo.getGenero().equals(genero))
	                .collect(Collectors.toList());
	    }

  /** Função de filtrar alguma mídia por idioma
  *
  * @param idioma String - Idioma que deseja consultar 
  * @return List<Conteudo> - Lista de conteúdos disponíveis com o idioma solicitado
  */
  

	
	   public List<Conteudo> filtrarPorIdioma(String idioma) {
	        return conteudos.values().stream()
	                .filter((conteudo) -> conteudo.getIdioma() != null && conteudo.getIdioma().equals(idioma))
	                .collect(Collectors.toList());
	    }

  /** Função de filtrar alguma series por quantidade de episódios 
  *
  * @param quantEpisodios int - Quantidades de episódios que deseja consultar 
  * @return List<Serie> - Lista de series disponíveis com a quantidade solicitada de episódios
  */

	    public List<Serie> filtrarPorQtdEpisodios(int quantEpisodios) { // transformar em um, prioridade baixa
	        return conteudos.values().stream().filter(conteudo -> conteudo instanceof Serie)
	                .map(conteudo -> (Serie) conteudo).filter(serie -> serie.getQuantidadeEpisodios() == quantEpisodios)
	                .collect(Collectors.toList());
	    }

  /** Função de filtrar algum filme por sua duração
  *
  * @param duracao int - Número de duração do filme que deseja procurar
  * @return List<Filme> - Lista de filmes disponíveis com a duração solicitada
  */
	    public List<Filme> filtrarPorDuracao(int duracao) {
	        return conteudos.values().stream().filter(conteudo -> conteudo instanceof Filme)
	                .map(conteudo -> (Filme) conteudo).filter(filme -> filme.getDuracao() == duracao)
	                .collect(Collectors.toList());
	    }

    /** Função de mostrar as avaliações do usuario
   *
   * @return List<Avalicao> - Lista com todas as avaliações do usuario
   */
  public List<Avaliacao> mostrarAvaliacoes() {
    Cliente atual = this.getClienteAtual();
    List<Conteudo> allConteudos = atual.getListaJaVista();

    List<Avaliacao> avaliacaos = new ArrayList<>();

    allConteudos.stream()
            .filter(c -> c.getAvaliacoes().containsKey(atual.getNomeDeUsuario()))
            .forEach(c -> avaliacaos.add(c.getAvaliacoes().get(atual.getNomeDeUsuario())));

    return avaliacaos;
  }


  /** Função de incrementar a audiência do conteúdo
  *
  * @param conteudo Conteudo - Conteudo a ser visto
  */
  
	public void registrarAudiencia(Conteudo conteudo) { // juntar em um
		conteudos.get(conteudo.getId()).registrarAudiencia();
	}


  /** Função responsável por salvar o avaliação no conteúdo
  *
  * @param a Avaliacao - Avaliação a ser salvo
  */
	public void salvaAvalicao(Avaliacao a) {
		conteudos.get(a.getIdConteudo()).getAvaliacoes().put(clienteAtual.getNomeDeUsuario(), a);
	}

  /** Função responsável por verificar o estado do cliente logado e transforma-lo em Cliente Especialista
  *
  */
  
	public void verificaCliente() {
		if (clienteAtual.conferirCliente()) {
			transformaCliente();
		}
	}

  /** Função auxiliar responsável por criar um Cliente Especialista 
  *
  */
  
	public void transformaCliente() {
		clienteAtual = new Especialista(clienteAtual.getNomeDeUsuario(), clienteAtual.getSenha(),
				clienteAtual.getLogin(), clienteAtual.getListaParaVer(), clienteAtual.getListaJaVista(),
				clienteAtual.getListaDatasAssistidasSeries());
	}

  /** Função responsável por carregar o arquivo com as informações da plataforma
  * @param nomeArquivo String - Nome do arquivo que será carreado
  * @param tipo int - Index referente ao tipo de informação que será carregado
  */
  
	public void carregarArquivo(String nomeArquivo, int tipo) throws NumberFormatException, ExecaoValorInvalido{ 
		Scanner input = new Scanner(System.in);
		Scanner sc; 

		File arq = new File(nomeArquivo);
		while (true) {
			try {
				sc = new Scanner(arq);
				break;
			} catch (FileNotFoundException e) {
				System.out.println("Arquivo não encontrado! Tente novamente");
				System.out.print("Nome do arquivo: ");
				arq = new File(input.nextLine());
			}
		}

		sc.useDelimiter(";|\\n");
		String param1, param2, param3, param4;
		int vez = 0;

		switch (tipo) {
		case 1:
			while (sc.hasNext()) {
				if (vez != 0) {
					param1 = sc.next();
					if (!param1.equals(""))
						param1 = param1.trim();
				} else {
					param1 = (sc.next().substring(1)).trim();
					vez++;
				}
				param3 = sc.next().trim();
				param2 = sc.next().trim();
				adicionarCliente(new Cliente(param1, param2, param3));
			}
			break;
		// ---------------------------------------------------------
		case 2:
			while (sc.hasNext()) {
				if (vez != 0) {
					adicionarSerie(new Serie(Integer.parseInt(sc.next().trim()), sc.next(), sc.next()));
				} else {
					adicionarSerie(new Serie(Integer.parseInt(sc.next().substring(1).trim()), sc.next(), sc.next()));
					vez++;
				}
			}
			break;
		// ---------------------------------------------------------
		case 3:
			while (sc.hasNext()) {
				if (vez != 0) {
					param1 = sc.next();
				} else {
					param1 = sc.next().substring(1);
					vez++;
				}
				param2 = sc.next();
				param3 = sc.next();
				if (clientes.get(param1) != null) {
					if (conteudos.get(Integer.parseInt(param3.trim())) != null) {
						if (param2.equals("A")) {
							clientes.get(param1).assisteConteudo(conteudos.get(Integer.parseInt(param3.trim())));
						} else {
							clientes.get(param1).adicionarNaLista(conteudos.get(Integer.parseInt(param3.trim())));
						}
					} else {
						System.out.println("Conteúdo com id: " + param3 + " inexistente");
					}
				}
			}
			break;
		// ---------------------------------------------------------
		case 4:
			while (sc.hasNext()) {
				if (vez == 0) {
					sc.nextLine();
				} else {
					vez++;
				}
				param1 = sc.next();
				param2 = sc.next();
				param3 = sc.next();
				param4 = sc.next();
				adicionarFilme(new Filme(Integer.parseInt(param1.trim()), param2.trim(), param3.trim(),
						Integer.parseInt(param4.trim())));
			}
			break;
		// ---------------------------------------------------------
		case 5:
			while (sc.hasNext()) {
				if (vez == 0) {
					sc.nextLine();
				} else {
					vez++;
				}
				param1 = sc.next();
				param2 = sc.next();
				adicionarTrailer(new Trailer(param2.trim(), Integer.parseInt(param1.trim())));
			}
			break;
		// ---------------------------------------------------------
		default:
			System.out.println("Tipo inválido");
			break;
		}
	}

  /** Função responsável por salvar o cliente no arquivo
  * @param nome String - Nome do cliente 
  * @param password String - Campo senha do cliente
  * @param username String - Campo username do Cliente
  */
  
	public void salvaCliente(String nome, String password, String username) {
		String conteudo = "\n" + nome + ";" + username + ";" + password;
		try (FileWriter writer = new FileWriter("POO_Series_2023/POO_Espectadores.csv", true)) {
			writer.write(conteudo);
			System.out.println("Dados adicionados ao arquivo com sucesso.");
			System.out.println(conteudo);
			writer.close();
		} catch (IOException e) {
			System.out.println("Ocorreu um erro ao adicionar os dados ao arquivo.");
			e.printStackTrace();
		}

	}

  /** Função responsável por salvar uma serie no arquivo
  *
  * @param serie Serie - Serie a ser salva 
  */
	public void salvaSerie(Serie serie) throws ExecaoNota, ExecaoValorInvalido {
		boolean existia = false;
		int id = serie.getId();
		int idNovo = serie.getId();
		while (conteudos.get(serie.getId()) != null) {
			existia = true;
			serie.setId(idNovo++);
		}
		if (existia) {
			System.out.println("Já existia uma série com o id " + id + " ele será mudado para: " + serie.getId());
		}
		String conteudo = "\n" + serie.getId() + ";" + serie.getNome() + ";" + serie.getDataDeLancamento();
		try (FileWriter writer = new FileWriter("POO_Series_2023/POO_Series.csv", true)) {
			writer.write(conteudo);
			System.out.println("Dados adicionados ao arquivo com sucesso.");
			writer.close();
		} catch (IOException e) {
			System.out.println("Ocorreu um erro ao adicionar os dados ao arquivo.");
			e.printStackTrace();
		}
		adicionarSerie(serie);
	}

  /** Função responsável por salvar um filme no arquivo
  *
  * @param filme Filme - Filme que será salvo no arquivo
  */
  
	public static void salvaFilme(Filme filme) throws ExecaoNota, ExecaoValorInvalido {
		boolean existia = false;
		int id = filme.getId();
		int idNovo = filme.getId();
		while (conteudos.get(filme.getId()) != null) {
			existia = true;
			filme.setId(idNovo++);
		}
		if (existia) {
			System.out.println("Já existia um filme com o id " + id + " ele será mudado para: " + filme.getId());
		}

		String conteudo = "\n" + filme.getId() + ";" + filme.getNome() + ";" + filme.getDataDeLancamento() + ";"
				+ filme.getDuracao();

		try (FileWriter writer = new FileWriter("POO_Series_2023/POO_Filmes.csv", true)) {
			writer.write(conteudo);
			System.out.println("Dados adicionados ao arquivo com sucesso.");
			writer.close();
		} catch (IOException e) {
			System.out.println("Ocorreu um erro ao adicionar os dados ao arquivo.");
			e.printStackTrace();
		}
		adicionarFilme(filme);
	}
	
  /** Função responsável por salvar um trailer no arquivo
  *
  * @param trailer Trailer - Trailer a ser salvo no arquivo
  */
  
	public static void salvaTrailer(Trailer trailer) throws ExecaoNota, ExecaoValorInvalido {
		boolean existia = false;
		int id = trailer.getId();
		int idNovo = trailer.getId();
		while (conteudos.get(trailer.getId()) != null) {
			existia = true;
			trailer.setId(idNovo++);
		}
		if (existia) {
			System.out.println("Já existia um trailer com o id " + id + " ele será mudado para: " + trailer.getId());
		}

		String conteudo = "\n" + trailer.getId() + ";" + trailer.getNome();

		try (FileWriter writer = new FileWriter("POO_Series_2023/POO_Trailer.csv", true)) {
			writer.write(conteudo);
			System.out.println("Dados adicionados ao arquivo com sucesso.");
			writer.close();
		} catch (IOException e) {
			System.out.println("Ocorreu um erro ao adicionar os dados ao arquivo.");
			e.printStackTrace();
		}
		adicionarTrailer(trailer);
	}

  /** Função responsável por salvar a audiencia de um conteudo no arquivo
  * @param login String - Campo login do cliente que assistiu o conteúdo
  * @param tipo Char - Caractér responsável por identificar 
  * @param conteudo_id int - Index de referencia para o tipo de conteúdo
  */
  
	public void salvaAudiencia(String login, char tipo, int conteudo_id) {
		String conteudo = "\n" + login + ";" + tipo + ";" + conteudo_id;
		try (FileWriter writer = new FileWriter("POO_Series_2023/POO_Audiencia.csv", true)) {
			writer.write(conteudo);
			System.out.println("Dados adicionados ao arquivo com sucesso.");
			System.out.println(conteudo);
			writer.close();
		} catch (IOException e) {
			System.out.println("Ocorreu um erro ao adicionar os dados ao arquivo.");
			e.printStackTrace();
		}

	}


  
	static Scanner input = new Scanner(System.in);

// Funções auxiliares para o menu de séries

  /** Função responsável por mostrar as séries salvas na lista de "Para Assistir" do Cliente
  * 
  */
  
	public void seriesParaVer() {
		for (Conteudo conteudo : clienteAtual.getListaParaVer()) {
			if (conteudo instanceof Serie) {
				System.out.println("Id: " + conteudo.getId() + " Nome: " + conteudo.getNome() + " - Nota média: "
						+ conteudo.mediaNotas());
			}
		}
	}

  /** Função responsável por mostrar as séries salvas na lista de "Já assistados" do Cliente
  *
  */
  
	public void seriesJaVistas() {
		for (Conteudo conteudo : clienteAtual.getListaJaVista()) {
			if (conteudo instanceof Serie) {
				System.out.println("Nome: " + conteudo.getNome() + " - Nota média: " + conteudo.mediaNotas());
				if (conteudo.getAvaliacoes().containsKey(clienteAtual.getNomeDeUsuario())) {
					Avaliacao avaliacao = conteudo.getAvaliacoes().get(clienteAtual.getNomeDeUsuario());
					if (avaliacao != null) {
						if (avaliacao.getComentario() != null) {
							System.out.println("Comentário: "
									+ conteudo.getAvaliacoes().get(clienteAtual.getNomeDeUsuario()).getComentario());
						}
						int nota = avaliacao.getNota();
						if (nota != 0) {
							System.out.println("Nota dada: "
									+ conteudo.getAvaliacoes().get(clienteAtual.getNomeDeUsuario()).getNota());
						}
					}
				} // conteudo.getAvaliacoes().get(clienteAtual.getNomeDeUsuario()).getIdConteudo()

			}
		}
	}

  // Funções auxiliares para o menu de filmes

  /** Função responsável por mostrar os filmes salvos na lista de "Para assistir" do Cliente
  * 
  */
  
	public void filmesParaVer() {
		for (Conteudo conteudo : clienteAtual.getListaParaVer()) {
			if (conteudo instanceof Filme) {
				System.out.println("Nome: " + conteudo.getNome() + " Nota média: " + conteudo.mediaNotas() );
			}
		}
	}


  /** Função responsável por mostrar os filmes salvos na lista de "Assistidos" do Cliente
  *
  */
  
	public void filmesJaVistas() {
		for (Conteudo conteudo : clienteAtual.getListaJaVista()) {
			if (conteudo instanceof Filme) {
				System.out.println("Nome: " + conteudo.getNome() + " - Nota média: " + conteudo.mediaNotas());
				if (conteudo.getAvaliacoes().containsKey(clienteAtual.getNomeDeUsuario())) {
					Avaliacao avaliacao = conteudo.getAvaliacoes().get(clienteAtual.getNomeDeUsuario());
					if (avaliacao != null) {
						if (avaliacao.getComentario() != null) {
							System.out.println("Comentário: "
									+ conteudo.getAvaliacoes().get(clienteAtual.getNomeDeUsuario()).getComentario());
						}
						int nota = avaliacao.getNota();
						if (nota != 0) {
							System.out.println("Nota dada: "
									+ conteudo.getAvaliacoes().get(clienteAtual.getNomeDeUsuario()).getNota());
						}
					}
				} // conteudo.getAvaliacoes().get(clienteAtual.getNomeDeUsuario()).getIdConteudo()

			}
		}
	}

// Funções auxiliares para o menu de trailers
  
	public void assisteTrailer(Integer id) {
		System.out.println("Trailer assistido com sucesso!");
	}

// Funções referentes ao gerenciamento de conteúdos
  

  /** Função responsável por adicionar uma série na lista de conteúdos da plataforma e salva-la no arquivo.
  * @param nome2 String - Nome da série
  * @param dt String - Data de lançamento da série
  * @param resp Int - ID da série
  */
  
	public void adicionaSeries(int resp, String nome2, String dt) throws ExecaoValorInvalido, ExecaoNota {

		salvaSerie(new Serie(resp, nome2, dt));
	}

  /** Função responsável por adicionar um filme na lista de conteúdos da plataforma e salva-lo no arquivo.
  * @param nome String - Nome do filme 
  * @param dt String - Data de lançamento do filme
  * @param id Int - ID do filme
  * @param duracao Int - Duração do filme
  */
  
	public void adicionaFilmes(int id, String nome, String dt, int duracao) throws ExecaoValorInvalido, ExecaoNota {

		salvaFilme(new Filme(id, nome, dt, duracao));
	}

  /** Função responsável por adicionar um trailer na lista de conteúdos da plataforma e salva-lo no arquivo.
  * @param nome String - Nome do trailer 
  * @param id Int - ID do trailer
  */
  
	public void adicionaTrailer(int id, String nome) throws ExecaoValorInvalido, ExecaoNota {
		//conteudos.put(id, new Trailer(nome, id));
		salvaTrailer(new Trailer(nome, id));
	}


  /** Função responsável por mostrar uma lista de conteúdos mais assistidos da plataforma
  * @param qtdViews Integer - Número de conteúdos a serem mostrados na lista
  *
  */
	public void conteudosMaisVistas(int qtdViews) {
		int index = 1;

//		  List<Conteudo> listaDeConteudosMaisVistas = new ArrayList();
//		  for (Conteudo entrada : conteudos.values()) {
//			  
//			  if(tipo.equals("S")) {
//				  if(entrada instanceof Serie) {
//				  listaDeConteudosMaisVistas.add((Serie) entrada);
//			  	}
//			  } else if(tipo.equals("F")) { 
//				  if(entrada instanceof Filme) {
//				  listaDeConteudosMaisVistas.add((Filme) entrada);
//				}
//			  } 
//		  }

		for (Conteudo c : conteudos.values().stream()
				.sorted((s1, s2) -> Integer.compare(s2.getAudiencia(), s1.getAudiencia())).limit(qtdViews).toList()) {
			System.out.println(index++ + " " + c.getNome() + " -> " + c.getAudiencia());
		}

	}


  /** Função responsável por mostra os conteúdos mais vistos por genêro
  * @param qtdViews String - Tamanho da lista
  * @param opcaoGenero - Index que refere ao genero, selecionado pelo usuário
  */
  
	public void conteudosMaisVistasPorGenero(int qtdViews, int opcaoGenero) {
		List<Conteudo> conteudos = new ArrayList<>();
		String genero = "";

		switch (opcaoGenero) {
			case 1:
				genero = "Ação";
				break;
			case 2:
				genero = "Aventura";
				break;
			case 3:
				genero = "Anime";
				break;
			case 4:
				genero = "Comédia";
				break;
			case 5:
				genero = "Documentario";
				break;
			case 6:
				genero = "Drama";
				break;
			case 7:
				genero = "Policial";
				break;
			case 8:
				genero = "Romance";
				break;
			case 9:
				genero = "Suspense";
				break;
		}

		for (Conteudo c : this.getConteudos().values()) {
			if (c.getGenero() == genero)
				conteudos.add(c);
		}

		List<Conteudo> maisAvaliados = conteudos.stream()
				.sorted((c1, c2) -> Double.compare(c2.getAudiencia(), c1.getAudiencia())).limit(qtdViews).toList();

		for (Conteudo c : maisAvaliados) {
			System.out.println("ID: " + c.getId());
			System.out.println("Nome: " + c.getNome());
			System.out.println("Audiência: " + c.getAudiencia());
			System.out.println("");
		}
	}

  /** Função responsável por mostrar uma lista de conteúdos mais bem avaliados por genero
  * @param qtdRank Integer - Tamanho da lista
  * @param opcaoGenero Integer - Index para referenciar o genêro a ser filtrado, inserido no menu pelo cliente.
  */
  
	public void verMelhoresAvaliadosPorGenero(int qtdRank, int opcaoGenero) {
		List<Conteudo> conteudos = new ArrayList<>();
		String genero = "";

		switch (opcaoGenero) {
		case 1:
			genero = "Ação";
			break;
		case 2:
			genero = "Aventura";
			break;
		case 3:
			genero = "Anime";
			break;
		case 4:
			genero = "Comédia";
			break;
		case 5:
			genero = "Documentario";
			break;
		case 6:
			genero = "Drama";
			break;
		case 7:
			genero = "Policial";
			break;
		case 8:
			genero = "Romance";
			break;
		case 9:
			genero = "Suspense";
			break;
		}

		for (Conteudo c : this.getConteudos().values()) {
			if (c.getGenero() == genero)
				conteudos.add(c);
		}

		List<Conteudo> maisAvaliados = conteudos.stream()
				.sorted((c1, c2) -> Double.compare(c2.mediaNotas(), c1.mediaNotas())).limit(qtdRank).toList();

		for (Conteudo c : maisAvaliados) {
			System.out.println("ID: " + c.getId());
			System.out.println("Nome: " + c.getNome());
			System.out.println("Nota: " + c.mediaNotas());
			System.out.println("");
		}
	}


//Funções auxiliares responsáveis por listar informações
  
  /** Função responsável por devolver os trailers salvos na plataforma
  *
  * @return Map<Integer, Trailer> - Lista de trailers salvos na plataforma
  */
  
	public Map<Integer, Trailer> listarT() { // TODO
		 Map<Integer, Trailer> listaDeTrailers = new HashMap<Integer, Trailer>();
		
		System.out.println("\nLista de trailers: ");
		for (Entry<Integer, Conteudo> entry : conteudos.entrySet()) {
			Conteudo value = entry.getValue();
			if (value instanceof Trailer) {
				int key = entry.getKey();
				listaDeTrailers.put(entry.getKey() ,(Trailer) entry.getValue());
				System.out.println(key + " - " + value.getNome());
			}
		}
		System.out.println("");
		return listaDeTrailers;
	}

  /** Função responsável por devolver as séries salvas na plataforma
  *
  * @return Map<Integer, Series> - Lista de series salvas na plataforma
  */
  
	public Map<Integer, Serie> listarS() { //TODO
		 Map<Integer, Serie> listaDeSeries = new HashMap<Integer, Serie>();
		
		System.out.println("\nLista de Series: ");
		for (Entry<Integer, Conteudo> entry : conteudos.entrySet()) {
			Conteudo value = entry.getValue();
			if (value instanceof Serie) {
				int key = entry.getKey();
				listaDeSeries.put(entry.getKey() ,(Serie) entry.getValue());
				System.out.println(key + " - " + value.getNome() + " - Nota: (" + value.mediaNotas() + ")");
			}
		}
		System.out.println("");
		return listaDeSeries;
	}

  /** Função responsável por devolver os filmes salvos na plataforma
  *
  * @return Map<Integer, Filme> - Lista de filmes salvos na plataforma
  */
  
	public Map<Integer, Filme> listarF() { //TODO
		 Map<Integer, Filme> listaDeFilmes = new HashMap<Integer, Filme>();
		
		System.out.println("\nLista de filmes: ");
		for (Map.Entry<Integer, Conteudo> entry : conteudos.entrySet()) {
			Conteudo value = entry.getValue();
			if (value instanceof Filme) {
				int key = entry.getKey();
				listaDeFilmes.put(entry.getKey() ,(Filme) entry.getValue());
				System.out.println(key + " - " + value.getNome() + " - Nota: (" + value.mediaNotas() + ")");
			}
		}
		System.out.println("");
		return listaDeFilmes;
	}

	public void listarC() {
		Cliente c = clientes.get("Dav33092");
		System.out.println("Usuário: Dav33092 / Senha: " + c.getSenha());
	}

	public void verMelhoresAvaliados(int qtdRank) {
        List<Conteudo> conteudos = new ArrayList<>();

        for (Conteudo c : this.getConteudos().values()) {
            conteudos.add(c);
        }

        List<Conteudo> maisAvaliados = conteudos.stream()
                .sorted((c1, c2) -> Double.compare(c2.mediaNotas(), c1.mediaNotas())).limit(qtdRank).toList();

        for (Conteudo c : maisAvaliados) {
            System.out.println("ID: " + c.getId());
            System.out.println("Nome: " + c.getNome());
            System.out.println("Nota: " + c.mediaNotas());
            System.out.println("");
        }
    }

}
