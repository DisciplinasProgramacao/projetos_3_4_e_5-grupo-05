

import java.util.Scanner;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.Random;

class Main {

  private final static Random gerador = new Random();
  private final static String[] GENEROS = {
      "Ação", "Policial","Romance", "Comédia",
      "Suspense", "Drama", "Anime",
      "Aventura", "Documentario"
  };
  private final static String[] IDIOMAS = {
      "Ingles", "Português", "Espanhol",
      "Mandarim", "Turco", "Francês",
      "Russo", "Alemão", "Japonês",
      "Koreano", "Italiano", "Grego"
  };
  static Scanner input = new Scanner(System.in);
  static PlataformaStreaming streaming = new PlataformaStreaming("Uiuiflix");
  int opcao;

  public static void main(String[] args) {
    streaming.carregarArquivo("POO_Series_2023/POO_Espectadores.csv", 1);
    streaming.carregarArquivo("POO_Series_2023/POO_Series.csv", 2);
    streaming.carregarArquivo("POO_Series_2023/POO_Audiencia.csv", 3);
    streaming.carregarArquivo("POO_Series_2023/POO_Filmes.csv", 4);
    boolean logado = false;
    int opcao;
    do {
      System.out.println("\nBem vindo ao Uiuiflix!");
      System.out.println("Selecione a opção desejada.");
      System.out.println("1 - Cadastro");
      System.out.println("2 - Entrar");
      if (streaming.getClienteAtual() != null) {
        logado = true;
        System.out.println("3 - Suas Series");
        System.out.println("4 - Seus Filmes");
        System.out.println("5 - Gerenciar Series");
        System.out.println("6 - Gerenciar Filmes");
        System.out.println("8 - Carregar arquivo");
        System.out.println("9 - Conteudo e suas avaliações");
      }
      System.out.println("");
      System.out.println("0 - Sair");
      System.out.print("\nResposta: ");
      opcao = input.nextInt();
      input.nextLine();
      switch (opcao) {
        case 0:
          System.out.println("Até mais! o/ ");
          break;
        case 1:
          cadastrarUsuario();
          break;
        case 2:
          listarC();
          logarPlataforma();
          break;
        case 3:
          if (!logado) {
            System.out.println("Logue antes de acessar esse recurso");
            break;
          }
          menuSeries();
          break;
        case 4:
          if (!logado) {
            System.out.println("Logue antes de acessar esse recurso");
            break;
          }
          menuFilmes();
          break;
        case 5:
          if (!logado) {
            System.out.println("Logue antes de acessar esse recurso");
            break;
          }
          gerenciarS(); // mudar
          break;
        case 6:
          if (!logado) {
            System.out.println("Logue antes de acessar esse recurso");
            break;
          }
          gerenciarF(); // mudar
          break;
        case 8:
          if (!logado) {
            System.out.println("Logue antes de acessar esse recurso");
            break;
          }
          int tipo;
          System.out.print("\nQual dado deseja carregar?\n1 - Cliente\n2 - Série\n3 - Audência\n4 - Filme\nResposta: ");
          tipo = input.nextInt();
          input.nextLine();
          System.out.print("\nNome do arquivo: ");
          streaming.carregarArquivo(input.nextLine(), tipo);
          break;
        default:
          System.out.println("Código inválido");
          break;
        // =====================================================================================================================================
        case 9: // verificar se o mano já deu a nota

          System.out.println("Id da avaliação: ");
          // int num = input.nextInt();
          //Lista<Avaliacao> LAvaliacao = null;
          
          for (Avaliacao a : streaming.retornaAvaliacoes().values()) {
            System.out.println("Nota: " + a.getNota());
            System.out.println("Comentario: " + a.getComentario());
          }

          for (Serie s : streaming.series.values()) {

            int cont = 0;
            float xxx = 0;
          for (Avaliacao a : streaming.retornaAvaliacoes().values()) {
              if (a.getIdConteudo() == s.getId()) { // verificar se é diferente de null a avaliação
                cont++;
                xxx += a.getNota();
                //System.out.println("passei aki");
              }
              if(streaming.series.get(s.getId()) == streaming.series.get(a.getIdConteudo()) && a.getComentario() != null) {
              System.out.println("Comentário de "+a.getAutor().getNomeDeUsuario()+": "+a.getComentario());
              }
              //LAvaliacao.add(a);
            }
          	
            float media = 0;
            if(cont!=0)
              media = xxx / cont;
//            s.setAvaliacoes(null);
            System.out.println("Serie: "+s.getNome()+"\nid: "+s.getId()+"\nMedia: "+media+"\n");
            
          }
//================================
          for (Filme f : streaming.filmes.values()) {

            int cont = 0;
            float xxx = 0;
            for (Avaliacao a : streaming.retornaAvaliacoes().values()) {
                if (a.getIdConteudo() == f.getId()) { // verificar se é diferente de null a avaliação
                  cont++;
                  xxx += a.getNota();
                  //System.out.println("passei aki");
                }
                if(streaming.series.get(f.getId()) == streaming.series.get(a.getIdConteudo()) && a.getComentario() != null) {
                System.out.println("Comentário de "+a.getAutor().getNomeDeUsuario()+": "+a.getComentario());
                }
                //LAvaliacao.add(a);
              }
            
            float media = 0;
            if(cont!=0)
              media = xxx / cont;
            
            System.out.println("Filme: "+f.getNome()+"\nid: "+f.getId()+"\nMedia: "+media+"\n");
          }

          // System.out.println("Notas: ");
          // Cliente atual = streaming.getClienteAtual();
          // Avaliacao a = new Avaliacao();
          // a = streaming.avaliacoes.get(atual);
          // for (Avaliacao aa : a) {
          // if (aa == null) {
          // break;
          // }
          // System.out.println(aa.getNota() + " - " + aa.getComentario());
          // }
          //
          // System.out.println("Notas: ");
          // Cliente atual = streaming.getClienteAtual();
          // Serie[] series = new Serie[streaming.series.size()];
          // series = atual.getListaParaVer().allElements(series);
          // for (Serie serie : series) {
          // if (serie == null) {
          // break;
          // }
          // System.out.println(serie.getId() + " - " + serie.getNome());
          // }

          break;
        // =====================================================================================================================================

        case 10:
        	Cliente atual = streaming.getClienteAtual();
        	Avaliacao[] a = new Avaliacao[streaming.avaliacoes.size()];
        	Serie s = streaming.getSerie(3459);
        	Lista<Avaliacao> AL = new Lista<Avaliacao>();
        	AL = s.getAvaliacoes();
        	a = s.getAvaliacoes().allElements(a);
        	
        	System.out.println("Tá ligado?: ");
        	
        	for (Avaliacao xxx : a) {
                if (xxx == null) {
                  break;
                }
                System.out.println(xxx.getId() + " - " + xxx.getNota());
              }
            
//            Serie[] series = new Serie[streaming.series.size()];
//            series = atual.getListaParaVer().allElements(series);
//            
//            for (Serie serie : series) {
//              if (serie == null) {
//                break;
//              }
//              System.out.println(serie.getId() + " - " + serie.getNome());
//            }
        	
          break;
      }
    } while (opcao != 0);
  }

  public static void cadastrarUsuario() {
    System.out.println("Digite seu nome");
    String nome = input.nextLine();
    System.out.println("Digite um nome de usuario");
    String username = input.nextLine();
    System.out.println("Digite uma senha");
    String password = input.nextLine();
    Cliente s = new Cliente(nome, password, username);
    streaming.salvaCliente(nome, password, username);
    streaming.adicionarCliente(s);
  }

  public static void logarPlataforma() {
    while (true) {
      System.out.println("Digite o nome de usuario");
      String login = input.nextLine();
      System.out.println("Digite uma senha");
      String senha = input.nextLine();
      if (streaming.logar(login, senha) == null) {
        System.out.println("Usuário não foi encontrado D:");

      } else {
        System.out.println("\nLogado com sucesso!!\nBem vindo " + streaming.getClienteAtual().getNomeDeUsuario());
        break;
      }
    }
  }

  public static void menuSeries() {
    int opcao;
    do {
      System.out.println("");
      System.out.println("1 - Mostrar series para ver ");
      System.out.println("2 - Mostrar series ja vistas ");
      System.out.println("3 - Assistir serie");
      System.out.println("4 - Adicionar serie a lista");
      System.out.println("5 - Filtrar suas series");
      System.out.println("6 - Filtrar todas as series ");
      System.out.println("");
      System.out.println("0 - Voltar");
      System.out.print("\nResposta: ");
      opcao = input.nextInt();
      input.nextLine();
      switch (opcao) {
        case 0:
          System.out.println("Voltando ao menu");
          break;
        case 1:
          seriesParaver();
          // Séries da lista
          break;
        case 2:
          seriesJaVistas();
          break;
        case 3:
          assisteSerie();
          // Assistir
          break;
        case 4:
          addSPVer();
          // Adicionar na lista
          break;
        case 5:
          filtros(1, 1);
          break;
        case 6:
          filtros(1, 2);
          break;
        default:
          System.out.println("Código inválido");
          break;
      }

    } while (opcao != 0);
  }

  public static void gerenciarS() {
    int opcao;
    do {
      System.out.println();
      System.out.println("1 - Lista de séries");
      System.out.println("2 - Cadastrar série");
      System.out.println("3 - Mostrar séries mais vistas");
      System.out.println("4 - Mostrar series mais vistas por genero");
      System.out.println("5 - Mostrar series mais vistas com 100 avaliações");
      System.out.println("6 - Mostrar series mais vistas por genero com 100 avaliações");
      System.out.println("");
      System.out.println("0 - Voltar");
      System.out.print("\nResposta: ");
      opcao = input.nextInt();
      input.nextLine();
      switch (opcao) {
        case 0:
          System.out.println("Voltando ao menu");
          break;
        case 1:
          listarS();
          break;
        case 2:
          adicionaSeries();
          break;
        case 3:
          int index = 1;
          for (Serie s : streaming.seriesMaisVistas()) {
            System.out.println(index++ + " " + s.getNome() + " -> " + s.getAudiencia());
          }
          break;
        case 4:
          int gCounter = 1;
          for (String g : Conteudo.GENEROS) {
            System.out.println(gCounter + " " + g);
            gCounter++;
          }
          System.out.print("Qual genero deseja filtrar? ");
          int mostViewdByGender = input.nextInt();
          if (mostViewdByGender > gCounter) {
            System.out.println("Opção invalida");
          }
          int index2 = 1;
          for (Serie s : streaming.seriesMaisVistasPorGenero(Conteudo.GENEROS[mostViewdByGender - 1]))
            System.out.println(index2++ + " " + s.getNome() + " -> " + s.getAudiencia());
          break;
        case 5:
          int index3 = 1;
          for (Serie s : streaming.seriesMaisVistasCom100Review()) {
            System.out.println(index3++ + " " + s.getNome() + " -> " + s.getAudiencia());
          }
          break;
        case 6:
          int gCounter2 = 1;
          for (String g : Conteudo.GENEROS) {
            System.out.println(gCounter2 + " " + g);
            gCounter2++;
          }
          System.out.print("Qual genero deseja filtrar? ");
          int mostViewdByGenderWith100Reviews = input.nextInt();
          if (mostViewdByGenderWith100Reviews > gCounter2) {
            System.out.println("Opção invalida");
          }
          int index4 = 1;
          for (Serie s : streaming.seriesMaisVistasPorGenero(Conteudo.GENEROS[mostViewdByGenderWith100Reviews - 1]))
            System.out.println(index4++ + " " + s.getNome() + " -> " + s.getAudiencia());
          break;
        default:
          System.out.println("Código inválido");
          break;
      }

    } while (opcao != 0);
  }

  public static void gerenciarF() {
    int opcao;
    do {
      System.out.println("");
      System.out.println("1 - Lista de filmes ");
      System.out.println("2 - Cadastrar filme");
      System.out.println("3 - Mostrar filmes mais vistos");
      System.out.println("4 - Mostrar filmes mais vistos por genero");
      System.out.println("5 - Mostrar filmes mais vistos com 100 avaliações");
      System.out.println("6 - Mostrar filmes mais vistos por genero com 100 avaliações");
      System.out.println("");
      System.out.println("0 - Voltar");
      System.out.print("\nResposta: ");
      opcao = input.nextInt();
      input.nextLine();
      switch (opcao) {
        case 0:
          System.out.println("Voltando ao menu");
          break;
        case 1:
          listarF();
          break;
        case 2:
          adicionaFilme();
          break;
        case 3:
          int index = 1;
          for (Filme f : streaming.filmesMaisVistos()) {
            System.out.println(index++ + " " + f.getNome() + " -> " + f.getAudiencia());
          }
          break;
        case 4:
          int gCounter = 1;
          for (String g : Conteudo.GENEROS) {
            System.out.println(gCounter + " " + g);
            gCounter++;
          }
          System.out.print("Qual genero deseja filtrar? ");
          int mostViewdByGender = input.nextInt();
          if (mostViewdByGender > gCounter) {
            System.out.println("Opção invalida");
          }
          int index2 = 1;
          for (Filme f : streaming.filmesMaisVistosPorGenero(Conteudo.GENEROS[mostViewdByGender - 1]))
            System.out.println(index2++ + " " + f.getNome() + " -> " + f.getAudiencia());
          break;
        case 5:
          int index3 = 1;
          for (Filme f : streaming.filmesMaisVistosCom100Review()) {
            System.out.println(index3++ + " " + f.getNome() + " -> " + f.getAudiencia());
          }
          break;
        case 6:
          int gCounter2 = 1;
          for (String g : Conteudo.GENEROS) {
            System.out.println(gCounter2 + " " + g);
            gCounter2++;
          }
          System.out.print("Qual genero deseja filtrar? ");
          int mostViewdByGenderWith100Review = input.nextInt();
          if (mostViewdByGenderWith100Review > gCounter2) {
            System.out.println("Opção invalida");
          }
          int index4 = 1;
          for (Filme f : streaming.filmesMaisVistosPorGeneroCom100Review(Conteudo.GENEROS[mostViewdByGenderWith100Review - 1]))
            System.out.println(index4++ + " " + f.getNome() + " -> " + f.getAudiencia());
          break;
        default:
          System.out.println("Código inválido");
          break;
      }

    } while (opcao != 0);
  }

  public static void menuFilmes() {// mudar funções
    int opcao;
    do {
      System.out.println("1 - Mostrar filmes para ver ");
      System.out.println("2 - Mostrar filmes ja vistos ");
      System.out.println("3 - Assistir filme");
      System.out.println("4 - Adicionar filme a lista");
      System.out.println("5 - Filtrar seus filmes");
      System.out.println("6 - Filtrar todos os filmes");
      System.out.println("");
      System.out.println("0 - Voltar");
      System.out.print("\nResposta: ");
      opcao = input.nextInt();
      input.nextLine();
      switch (opcao) {
        case 0:
          System.out.println("Voltando ao menu");
          break;
        case 1:

          filmesParaVer();
          // Séries da lista
          break;
        case 2:
          filmesJaVistas();

          break;
        case 3:
          assisteFilme();

          // Assistir
          break;
        case 4:
          addFPVer();

          // Adicionar na lista
          break;
        case 5:
          filtros(2, 1);
          break;
        case 6:
          filtros(2, 2);
          break;
        default:
          System.out.println("Código inválido");
          break;
      }

    } while (opcao != 0);
  }

  public static void adicionaSeries() {
    int qtdE;
    String nome;
    String dt;
    System.out.print("Nome da série: ");
    nome = input.nextLine();
    System.out.print("Data de lançamento: ");
    dt = input.nextLine();
    System.out.print("Id: ");
    qtdE = input.nextInt();
    input.nextLine();
    streaming.adicionarSerie(new Serie(qtdE, nome, dt));
    streaming.salvaSerie(new Serie(qtdE, nome, dt));
  }

  public static void adicionaFilme() {
    int qtdE, duracao;
    String nome;
    String dt;
    System.out.print("Nome do filme: ");
    nome = input.nextLine();
    System.out.print("Data de lançamento: ");
    dt = input.nextLine();
    System.out.print("Id: ");
    qtdE = input.nextInt();
    System.out.println("Qual a duração do filme: ");
    duracao = input.nextInt();
    input.nextLine();
    streaming.adicionarFilme(new Filme(qtdE, nome, dt, duracao));
    streaming.salvaFilme(new Filme(qtdE, nome, dt, duracao));
  }

  public static void addSPVer() {
    listarS();
    System.out.print("\nId da série para ver: ");
    streaming.getClienteAtual().adicionarNaLista(streaming.series.get(input.nextInt()));
    input.nextLine();
  }

  public static void addFPVer() {
    listarF();
    System.out.print("\nId do filme para ver: ");
    streaming.getClienteAtual().adicionarFilmeNaLista(streaming.filmes.get(input.nextInt()));
    input.nextLine();
  }

  public static void seriesParaver() {
    System.out.println("Series para ver: ");
    Cliente atual = streaming.getClienteAtual();
    Serie[] series = new Serie[streaming.series.size()];
    series = atual.getListaParaVer().allElements(series);
    for (Serie serie : series) {
      if (serie == null) {
        break;
      }
      System.out.println(serie.getId() + " - " + serie.getNome());
      
      for (Serie s : streaming.series.values()) {
          int cont = 0;
          float xxx = 0;
        for (Avaliacao a : streaming.retornaAvaliacoes().values()) {
            if (a.getIdConteudo() == s.getId()) { // verificar se é diferente de null a avaliação
              cont++;
              xxx += a.getNota();
            }
          }
          float media = 0;
          if(cont!=0)
          media = xxx / cont;
          if (serie == s) {
          System.out.println("Nota: "+media+"\n");
          }
        }
    }
  }

  public static void filmesParaVer() {
    System.out.println("Filmes para ver: ");
    Cliente atual = streaming.getClienteAtual();
    Filme[] filmes = new Filme[streaming.filmes.size()];
    filmes = atual.getListaDeFilmesParaVer().allElements(filmes);
    for (Filme f : filmes) {
      if (f == null) {
        break;
      }
      System.out.println(f.getId() + " - " + f.getNome());
    }
  }

  public static void seriesJaVistas() {
    System.out.println("Series ja vistas: ");
    Cliente atual = streaming.getClienteAtual();
    Serie[] series = new Serie[streaming.series.size()];
    series = atual.getListaJaVista().allElements(series);
    for (Serie serie : series) {
      if (serie == null) {
        break;
      }
      System.out.println(serie.getId() + " - " + serie.getNome());
    }
  }

  public static void filmesJaVistas() {
    System.out.println("Filmes ja vistas: ");
    Cliente atual = streaming.getClienteAtual();
    Filme[] filmes = new Filme[streaming.filmes.size()];
    filmes = atual.getListaDeFilmesJaVista().allElements(filmes);
    for (Filme f : filmes) {
      if (f == null) {
        break;
      }
      System.out.println(f.getId() + " - " + f.getNome());
    }
  }

  // -0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0
  public static void assisteSerie() {
	  
	//Serie s = null;
	boolean pode=true;
	//Avaliacao a = null;
	Cliente atual = streaming.getClienteAtual();
    seriesParaver();

//    // Determinar série que foi vista
//    // -------------------------------------------------
//    System.out.print("Id da serie que deseja assistir: ");
//    int idSerie = input.nextInt();
//    s = streaming.getSerie(idSerie);
//    // -------------------------------------------------
//
//    // Determinar se o brother vai dar nota
//    // -------------------------------------------------
//    // se ele for especialista
//    input.nextLine();
//    System.out.print("Deseja dar nota para a série?(S/N) ");
//    char darNota = input.nextLine().charAt(0);
//    
////-----------------------------------------------------------------------
//    if (darNota == 'S') {
//  	  
//        System.out.print("Nota da série: ");
//        int nota = input.nextInt();
//        input.nextLine();
//        
//        if (atual.isEspecialista() == false) {
//    	
//        	a = new Avaliacao(idSerie, atual, nota, null);
//        	streaming.adicionarAvaliacao(a);
//        
//        	
//        
//        	atual.registrarAudiencia(streaming.getSerie(idSerie));
//        
//        } else {
//          
//        	System.out.print("Deseja deixar um comentario?(S/N) ");
//        	darNota = input.nextLine().charAt(0); // aproveitei variavel
//          
//        	if (darNota == 'S') {
//          	
//        		System.out.print("Comentario: ");
//        		String comentario = input.nextLine();
//        		input.nextLine();
//
//        		a = new Avaliacao(idSerie, atual, nota, comentario);
//        		streaming.adicionarAvaliacao(a);
//        		
//        		atual.registrarAudiencia(streaming.getSerie(idSerie));
//        
//        	} else {
//        		a = new Avaliacao(idSerie, atual, nota, null);	
//        		atual.registrarAudiencia(streaming.getSerie(idSerie));
//      }
//      
//    } // se ele NÃO for especialista
////-----------------------------------------------------------------------
//      
//      } if (darNota == 'N') {
//    	  atual.registrarAudiencia(streaming.getSerie(idSerie));
//      }
//      
//      	Lista<Avaliacao> AL = new Lista<Avaliacao>();
//      	//AL = s.getAvaliacoes();
//  		AL.add(a);
//  		s.setAvaliacoes(AL);
//    

    System.out.print("Id da serie que deseja assistir: ");
    int idSerie = input.nextInt();
    // -------------------------------------------------
    
    // Determinar se o brother vai dar nota
    // -------------------------------------------------
    // se ele for especialista
    input.nextLine();
    
    for (Avaliacao a : streaming.retornaAvaliacoes().values()) {
        if (a.getAutor() == atual) { // verificar se é diferente de null a avaliação
        	pode=false;
          //System.out.println("passei aki");
        }
      }
    
    if(pode==true) {
    	System.out.print("Deseja dar nota para a série?(S/N) ");
        char darNota = input.nextLine().charAt(0);
        if (atual.isEspecialista() == false) {

          if (darNota == 'S') {
            System.out.print("Nota da série: ");
            int nota = input.nextInt();
            input.nextLine();
            Avaliacao a = new Avaliacao(idSerie, atual, nota);
            // a(idSerie , atual, nota);
            streaming.adicionarAvaliacao(a);

            atual.registrarAudiencia(streaming.getSerie(idSerie));

          } else {
            atual.registrarAudiencia(streaming.getSerie(idSerie));
          }
        } else { // se ele NÃO for especialista

          if (darNota == 'S') {
            System.out.print("Nota da série: ");
            int nota = input.nextInt();
            input.nextLine();
            System.out.print("Deseja deixar um comentario?(S/N) ");
            darNota = input.nextLine().charAt(0); // aproveitei variavel
            if (darNota == 'S') {
              System.out.print("Comentario: ");
              String comentario = input.nextLine();
              input.nextLine();

              Avaliacao a = new Avaliacao(idSerie, atual, nota, comentario);
              // a(idSerie , atual, nota);
              streaming.adicionarAvaliacao(a);
              atual.registrarAudiencia(streaming.getSerie(idSerie));
            } else {
              atual.registrarAudiencia(streaming.getSerie(idSerie));
            }
          }
        }
    }
    
    	
    
    
    
    	
    
    
    
    

    // -------------------------------------------------

    // Determinar data em que a série foi vista
    // -------------------------------------------------
    Calendar hoje = new GregorianCalendar();
    hoje.getTime();

    Calendar c = new GregorianCalendar();
    // PARA CASO QUEIRA COLOCAR UMA DATA ESPECÍFICA
    /*
     * int ano, mes, dia;
     * System.out.print("Data vista:\n Ano");
     * ano = input.nextInt();
     * System.out.print("Data vista:\n Mes");
     * mes = input.nextInt();
     * System.out.print("Data vista:\n Dia");
     * dia = input.nextInt();
     */
    c.set(hoje.get(Calendar.YEAR), (hoje.get(Calendar.MONTH) + 1), hoje.get(Calendar.DAY_OF_MONTH));
    atual.adicionarNaListaDatasAssistidasSeries(c);
    if (atual.isEspecialista() == false) {
      atual.conferirEstadoCliente();
    }

    System.out.println("Dia atual " + hoje.get(Calendar.DAY_OF_MONTH) + "/" + (hoje.get(Calendar.MONTH) + 1) + "/"
        + hoje.get(Calendar.YEAR));
    // PARA CASO QUEIRA PRINTAR DATA ESPECÍFICA
    // System.out.println("Dia digitado " + c.get(Calendar.DAY_OF_MONTH) + "/" +
    // c.get(Calendar.MONTH) + "/" + c.get(Calendar.YEAR));
  }

  // -0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0
  public static void assisteFilme() {
    Cliente atual = streaming.getClienteAtual();
    filmesParaVer();
    System.out.print("Id do filme que deseja assistir: ");
    int idFilme = input.nextInt();

    if (atual.isEspecialista() == false) {
      input.nextLine();
      System.out.print("Deseja dar nota para a série?(S/N) ");
      char darNota = input.nextLine().charAt(0);
      if (darNota == 'S') {
        System.out.print("Nota da série: ");
        int nota = input.nextInt();
        input.nextLine();

        Avaliacao a = new Avaliacao(idFilme, atual, nota);
        // a(idSerie , atual, nota);
        streaming.adicionarAvaliacao(a);

        atual.registrarAudiencia(streaming.getSerie(idFilme));

      } else {
        atual.registrarAudiencia(streaming.getSerie(idFilme));
      }
    } else { // se ele NÃO for especialista
      input.nextLine();
      System.out.print("Deseja dar nota para a série?(S/N) ");
      char darNota = input.nextLine().charAt(0);
      if (darNota == 'S') {
        System.out.print("Nota da série: ");
        int nota = input.nextInt();
        input.nextLine();

        System.out.print("Deseja deixar um comentario?(S/N) ");
        darNota = input.nextLine().charAt(0); // aproveitei variavel
        if (darNota == 'S') {
          System.out.print("Comentario: ");
          String comentario = input.nextLine();
          input.nextLine();

          Avaliacao a = new Avaliacao(idFilme, atual, nota, comentario);
          // a(idSerie , atual, nota);
          streaming.adicionarAvaliacao(a);
          atual.registrarAudiencia(streaming.getSerie(idFilme));
        } else {
          atual.registrarAudiencia(streaming.getSerie(idFilme));
        }
      }
    }

    Calendar hoje = new GregorianCalendar();
    hoje.getTime();

    Calendar c = new GregorianCalendar();
    // PARA CASO QUEIRA COLOCAR UMA DATA ESPECÍFICA
    /*
     * int ano, mes, dia;
     * System.out.print("Data vista:\n Ano");
     * ano = input.nextInt();
     * System.out.print("Data vista:\n Mes");
     * mes = input.nextInt();
     * System.out.print("Data vista:\n Dia");
     * dia = input.nextInt();
     */
    c.set(hoje.get(Calendar.YEAR), (hoje.get(Calendar.MONTH) + 1), hoje.get(Calendar.DAY_OF_MONTH));
    atual.adicionarNaListaDatasAssistidasSeries(c);
    if (atual.isEspecialista() == false) {
      atual.conferirEstadoCliente();
    }

    System.out.println("Dia atual " + hoje.get(Calendar.DAY_OF_MONTH) + "/" + (hoje.get(Calendar.MONTH) + 1) + "/"
        + hoje.get(Calendar.YEAR));
    // System.out.println("Dia digitado " + c.get(Calendar.DAY_OF_MONTH) + "/" +
    // c.get(Calendar.MONTH) + "/" + c.get(Calendar.YEAR));

  }

  public static void listarS() {
    System.out.println("\nLista de Series: ");
    for (Map.Entry<Integer, Serie> entry : streaming.series.entrySet()) {
      int key = entry.getKey();
      Serie value = entry.getValue();
      System.out.println(key + " - " + value.getNome());
    }
    System.out.println("");
  }

  public static void listarF() {
    System.out.println("\nLista de Series: ");
    for (Map.Entry<Integer, Filme> entry : streaming.filmes.entrySet()) {
      int key = entry.getKey();
      Filme value = entry.getValue();
      System.out.println(key + " - " + value.getNome());
    }
    System.out.println("");
  }

  public static void listarC() {
    Cliente c = streaming.clientes.get("Dav33092");
    System.out.println("Usuário: Dav33092 / Senha: " + c.getSenha());
  }

  // filtros

  public static void filtros(int tipo, int lista) {
    // tipo = 1 -> filtros de série
    // tipo = 2 -> filtros de filme
    // lista = 1 -> lista do cliente
    // lista = 2 -> lista geral
    int idioma;
    int opcao;
    if (tipo == 1) { // SÉRIE
      do {
        System.out.println("");
        System.out.println("Selecione o filtro desejado.");
        System.out.println("1 - Idioma");
        System.out.println("2 - Gênero");
        System.out.println("3 - Quantidade de episódios");
        System.out.println("");
        System.out.println("0 - Sair");
        System.out.print("\nResposta: ");
        opcao = input.nextInt();
        input.nextLine();
        Serie[] series;
        series = new Serie[streaming.series.size()];
        String strIdioma;
        switch (opcao) {
          case 0:
            System.out.println("Voltando ao menu");
            break;
          case 1: // SÉRIE POR IDIOMA
            System.out.println("");
            System.out.println("Qual idioma você deseja filtrar? ");
            System.out.println("1 - Inglês");
            System.out.println("2 - Português");
            System.out.println("3 - Espanhol");
            System.out.println("4 - Mandarim");
            System.out.println("5 - Turco");
            System.out.print("\nResposta: ");
            idioma = input.nextInt();
            input.nextLine();
            switch (idioma) {
              case 1:
                strIdioma = "Inglês";
                break;
              case 2:
                strIdioma = "Português";
                // streaming.filtrarPorIdioma("Português");
                break;
              case 3:
                strIdioma = "Espanhol";
                // streaming.filtrarPorIdioma("Espanhol");
                break;
              case 4:
                strIdioma = "Mandarim";
                // streaming.filtrarPorIdioma("Mandarim");
                break;
              case 5:
                strIdioma = "Turco";
                // streaming.filtrarPorIdioma("Turco");
                break;
              default:
                strIdioma = "Inexistênte";
                break;

            }
            if (lista == 2) { // Lista de todos
              series = streaming.filtrarPorIdioma(strIdioma).allElements(series);
            } else { // Lista do cliente atual
              series = streaming.getClienteAtual().filtrarPorIdioma(strIdioma).allElements(series);
            }
            if (series.length == 0) {
              System.out.println("Não existem series neste idioma");
              break;
            }
            for (Serie s : series) { // display das séries
              if (s == null) {
                continue;
              }
              System.out.println(s.getNome());
            }
            break;
          case 2: // SÉRIE POR GÊNERO
            System.out.println("");
            System.out.println("Qual genero você deseja filtrar? ");
            System.out.println("1 - Ação");
            System.out.println("2 - Terror");
            System.out.println("3 - Comédia");
            System.out.println("4 - Suspense");
            System.out.println("5 - Drama");
            System.out.print("\nResposta: ");
            idioma = input.nextInt();
            switch (idioma) {
              case 1:
                if (lista == 2) { // Lista de todos
                  series = streaming.filtrarPorGenero("Ação").allElements(series);
                } else { // Lista do cliente atual
                  series = streaming.getClienteAtual().filtrarPorGenero("Ação").allElements(series);
                }
                if (series.length == 0) {
                  System.out.println("Não existem series com esse genero");
                  break;
                }
                for (Serie s : series) {
                  if (s == null) {
                    break;
                  }
                  System.out.println(s.getNome());
                }
                break;
              case 2:
                if (lista == 2) { // Lista de todos
                  series = streaming.filtrarPorGenero("Terror").allElements(series);
                } else { // Lista do cliente atual
                  series = streaming.getClienteAtual().filtrarPorGenero("Terror").allElements(series);
                }
                if (series.length == 0) {
                  System.out.println("Não existem series com esse genêro");
                  break;
                }
                for (Serie s : series) {
                  if (s == null) {
                    break;
                  }
                  System.out.println(s.getNome());
                }
                break;
              case 3:
                if (lista == 2) { // Lista de todos
                  series = streaming.filtrarPorGenero("Comédia").allElements(series);
                } else { // Lista do cliente atual
                  series = streaming.getClienteAtual().filtrarPorGenero("Comédia").allElements(series);
                }
                if (series.length == 0) {
                  System.out.println("Não existem series com esse genêro");
                  break;
                }
                for (Serie s : series) {
                  if (s == null) {
                    break;
                  }
                  System.out.println(s.getNome());
                }
                break;
              case 4:
                if (lista == 2) { // Lista de todos
                  series = streaming.filtrarPorGenero("Suspense").allElements(series);
                } else { // Lista do cliente atual
                  series = streaming.getClienteAtual().filtrarPorGenero("Suspense").allElements(series);
                }
                if (series.length == 0) {
                  System.out.println("Não existem series com esse genêro");
                  break;
                }
                for (Serie s : series) {
                  if (s == null) {
                    break;
                  }
                  System.out.println(s.getNome());
                }
                break;
              case 5:
                if (lista == 2) { // Lista de todos
                  series = streaming.filtrarPorGenero("Drama").allElements(series);
                } else { // Lista do cliente atual
                  series = streaming.getClienteAtual().filtrarPorGenero("Drama").allElements(series);
                }
                if (series.length == 0) {
                  System.out.println("Não existem series com esse genêro");
                  break;
                }
                for (Serie s : series) {
                  if (s == null) {
                    break;
                  }
                  System.out.println(s.getNome());
                }
                break;
              default:
                System.out.println("O genêro informado não foi encontrado");
                break;
            }
            break;
          case 3: // SÉRIE POR QUANTIDADE DE EPISÓDIOS
            System.out.println("\nDigite a quantidade de episodios ");
            int numEpisodios = input.nextInt();
            Serie[] seriesEp = new Serie[streaming.series.size()];
            if (lista == 2) { // Lista de todos
              seriesEp = streaming.filtrarPorQtdEpisodios(numEpisodios).allElements(seriesEp);
            } else { // Lista do cliente atual
              seriesEp = streaming.getClienteAtual().filtrarPorQtdEpisodios(numEpisodios).allElements(seriesEp);
            }
            for (Serie s : seriesEp) {
              if (s == null) {
                break;
              }
              if (s.getQuantidadeEpisodios() == numEpisodios) {
                System.out.println(s.getNome());
              }
            }
            break;
          default:
            System.out.println("Código inválido");
            break;
        }
      } while (opcao != 0);
    } else { // FILMES
      do {

        System.out.println("\nSelecione o filtro desejado.");
        System.out.println("1 - Idioma");
        System.out.println("2 - Gênero");
        System.out.println("3 - Duração");
        System.out.println("");
        System.out.println("0 - Sair");
        System.out.print("\nResposta: ");
        opcao = input.nextInt();
        input.nextLine();
        Filme[] filmes;
        filmes = new Filme[streaming.filmes.size()];
        String strIdioma;
        switch (opcao) {
          case 0:
            System.out.println("Voltando ao menu");
            break;
          case 1: // FILME POR IDIOMA
            System.out.println("\nQual idioma você deseja filtrar? ");
            System.out.println("1 - Inglês");
            System.out.println("2 - Português");
            System.out.println("3 - Espanhol");
            System.out.println("4 - Mandarim");
            System.out.println("5 - Turco");
            System.out.print("\nResposta: ");
            idioma = input.nextInt();
            input.nextLine();
            switch (idioma) {
              case 1:
                strIdioma = "Inglês";
                break;
              case 2:
                strIdioma = "Português";
                // streaming.filtrarPorIdioma("Português");
                break;
              case 3:
                strIdioma = "Espanhol";
                // streaming.filtrarPorIdioma("Espanhol");
                break;
              case 4:
                strIdioma = "Mandarim";
                // streaming.filtrarPorIdioma("Mandarim");
                break;
              case 5:
                strIdioma = "Turco";
                // streaming.filtrarPorIdioma("Turco");
                break;
              default:
                strIdioma = "Inexistênte";
                break;

            }
            if (lista == 2) { // Lista de todos
              filmes = streaming.filtrarFilmePorIdioma(strIdioma).allElements(filmes);
            } else { // Lista do cliente atual
              filmes = streaming.getClienteAtual().filtrarFilmePorIdioma(strIdioma).allElements(filmes);
            }
            if (filmes.length == 0) {
              System.out.println("Não existem series neste idioma");
              break;
            }
            for (Filme f : filmes) { // display das séries
              if (f == null) {
                continue;
              }
              System.out.println(f.getNome());
            }
            break;
          case 2: // FILME POR GÊNERO
            System.out.println("\nQual genero você deseja filtrar? ");
            System.out.println("1 - Ação");
            System.out.println("2 - Terror");
            System.out.println("3 - Comédia");
            System.out.println("4 - Suspense");
            System.out.println("5 - Drama");
            System.out.print("\nResposta: ");
            idioma = input.nextInt();
            switch (idioma) {
              case 1:
                if (lista == 2) { // Lista de todos
                  filmes = streaming.filtrarFilmePorGenero("Ação").allElements(filmes);
                } else { // Lista do cliente atual
                  filmes = streaming.getClienteAtual().filtrarFilmePorGenero("Ação").allElements(filmes);
                }
                if (filmes.length == 0) {
                  System.out.println("Não existem series com esse genero");
                  break;
                }
                for (Filme f : filmes) {
                  if (f == null) {
                    break;
                  }
                  System.out.println(f.getNome());
                }
                break;
              case 2:
                if (lista == 2) { // Lista de todos
                  filmes = streaming.filtrarFilmePorGenero("Terror").allElements(filmes);
                } else { // Lista do cliente atual
                  filmes = streaming.getClienteAtual().filtrarFilmePorGenero("Terror").allElements(filmes);
                }
                if (filmes.length == 0) {
                  System.out.println("Não existem series com esse genêro");
                  break;
                }
                for (Filme f : filmes) {
                  if (f == null) {
                    break;
                  }
                  System.out.println(f.getNome());
                }
                break;
              case 3:
                if (lista == 2) { // Lista de todos
                  filmes = streaming.filtrarFilmePorGenero("Comédia").allElements(filmes);
                } else { // Lista do cliente atual
                  filmes = streaming.getClienteAtual().filtrarFilmePorGenero("Comédia").allElements(filmes);
                }
                if (filmes.length == 0) {
                  System.out.println("Não existem series com esse genêro");
                  break;
                }
                for (Filme f : filmes) {
                  if (f == null) {
                    break;
                  }
                  System.out.println(f.getNome());
                }
                break;
              case 4:
                if (lista == 2) { // Lista de todos
                  filmes = streaming.filtrarFilmePorGenero("Suspense").allElements(filmes);
                } else { // Lista do cliente atual
                  filmes = streaming.getClienteAtual().filtrarFilmePorGenero("Suspense").allElements(filmes);
                }
                if (filmes.length == 0) {
                  System.out.println("Não existem series com esse genêro");
                  break;
                }
                for (Filme f : filmes) {
                  if (f == null) {
                    break;
                  }
                  System.out.println(f.getNome());
                }
                break;
              case 5:
                if (lista == 2) { // Lista de todos
                  filmes = streaming.filtrarFilmePorGenero("Drama").allElements(filmes);
                } else { // Lista do cliente atual
                  filmes = streaming.getClienteAtual().filtrarFilmePorGenero("Drama").allElements(filmes);
                }
                if (filmes.length == 0) {
                  System.out.println("Não existem series com esse genêro");
                  break;
                }
                for (Filme f : filmes) {
                  if (f == null) {
                    break;
                  }
                  System.out.println(f.getNome());
                }
                break;
              default:
                System.out.println("O genêro informado não foi encontrado");
                break;
            }
            break;
          case 3: // FILME POR DURAÇÃO
            System.out.println("\nDigite a duração desejada(min)");
            int numDuracao = input.nextInt();
            Filme[] filmeDuracao = new Filme[streaming.filmes.size()];
            filmeDuracao = streaming.filtrarFilmePorDuracao(numDuracao).allElements(filmeDuracao);
            for (Filme f : filmeDuracao) {
              if (f == null) {
                break;
              }
              if (f.getDuracao() == numDuracao) {
                System.out.println(f.getNome());
              }
            }
            break;
          default:
            System.out.println("Código inválido");
            break;
        }
      } while (opcao != 0);
    }
  }

}