
import java.util.Scanner;
import java.util.Map;

class Main {
  static Scanner input = new Scanner(System.in);
  static PlataformaStreaming streaming = new PlataformaStreaming("Uiuiflix");
  int opcao;

  public static void main(String[] args) {
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
          //gerenciarF(); // mudar
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
      System.out.println("1 - Lista de séries");
      System.out.println("2 - Cadastrar série");
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
          assisteSerie();
          // Assistir
          break;
        case 4:
          addFPVer();
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

  public static void adicionaSeries() {
    int qtdE;
    String nome;
    String dt;
    System.out.print("Nome da série: ");
    nome = input.nextLine();
    System.out.print("Data de lançamento: ");
    dt = input.nextLine();
    System.out.print("Quantidade de episódios: ");
    qtdE = input.nextInt();
    input.nextLine();
    streaming.adicionarSerie(new Serie(qtdE, nome, dt));
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
      if(serie == null){
        break;
      }
      System.out.println(serie.getId() + " - " + serie.getNome());
    }
  }

  
  public static void filmesParaVer() {
    System.out.println("Filmes para ver: ");
    Cliente atual = streaming.getClienteAtual();
    Filme[] filmes = new Filme[streaming.filmes.size()];
    filmes = atual.getListaDeFilmesParaVer().allElements(filmes);
    for (Filme f : filmes) {
      if(f == null){
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
      if(serie == null){
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
      if(f == null){
        break;
      }
      System.out.println(f.getId() + " - " + f.getNome());
    }
  }

  public static void assisteSerie() {
    Cliente atual = streaming.getClienteAtual();
    seriesParaver();
    System.out.print("Id da serie que deseja assistir: ");
    int idSerie = input.nextInt();
    input.nextLine();
    System.out.print("Deseja dar nota para a série?(S/N) ");
    char darNota = input.nextLine().charAt(0);
    if(darNota == 'S'){
      System.out.print("Nota da série: ");
      int nota = input.nextInt();
      input.nextLine();
      atual.registrarAudiencia(streaming.getSerie(idSerie),nota);
    } else {
      atual.registrarAudiencia(streaming.getSerie(idSerie));
    }
   
  }

    public static void assisteFilme() {
    Cliente atual = streaming.getClienteAtual();
    filmesParaVer();
    System.out.print("Id do filme que deseja assistir: ");
    int idFilme = input.nextInt();
    input.nextLine();
    System.out.print("Deseja dar nota para a filme?(S/N) ");
    char darNota = input.nextLine().charAt(0);
    if(darNota == 'S'){
      System.out.print("Nota do filme: ");
      int nota = input.nextInt();
      input.nextLine();
      atual.assitirFilme(streaming.getFilme(idFilme),nota);
    } else {
      atual.assitirFilme(streaming.getFilme(idFilme));
    }
   
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
    System.out.println("\nLista de Clientes: ");
    int cont = 0;
    for (Map.Entry<String, Cliente> entry : streaming.clientes.entrySet()) {
      cont++;
      if(cont > 20)
        break;
      String key = entry.getKey();
      Cliente value = entry.getValue();
      System.out.println(key + " - " + value.getLogin() + " Senha: " + value.getSenha());
    }
    System.out.println("");
  }

  // filtros

  public static void filtros(int tipo, int lista) {
    // tipo = 1 -> filtros de série
    // tipo = 2 -> filtros de filme
    // lista = 1 -> lista do cliente
    // lista = 2 -> lista geral
    int idioma;
    int opcao;
    if(tipo == 1){ //SÉRIE
      do {
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
          case 1: //SÉRIE POR IDIOMA
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
            if(lista == 2){ //Lista de todos
              series = streaming.filtrarPorIdioma(strIdioma).allElements(series);
            } else { //Lista do cliente atual
              series = streaming.getClienteAtual().filtrarPorIdioma(strIdioma).allElements(series);
            }
            if(series.length == 0) {
              System.out.println("Não existem series neste idioma");
              break;
            }
            for (Serie s : series) { //display das séries
              if(s == null){
                continue;
              }
              System.out.println(s.getNome());
            }
            break;
          case 2: //SÉRIE POR GÊNERO
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
                series = streaming.filtrarPorGenero("Ação").allElements(series);
                if(series.length == 0) {
                  System.out.println("Não existem series com esse genero");
                  break;
                }
                for (Serie s : series) {
                  if(s == null){
                    break;
                  }
                  System.out.println(s.getNome());
                }
                break;
              case 2:
                series = streaming.filtrarPorGenero("Terror").allElements(series);
                if(series.length == 0) {
                  System.out.println("Não existem series com esse genêro");
                  break;
                }
                for (Serie s : series) {
                  if(s == null){
                    break;
                  }
                  System.out.println(s.getNome());
                }
                break;
              case 3:
                series = streaming.filtrarPorGenero("Comédia").allElements(series);
                if(series.length == 0) {
                  System.out.println("Não existem series com esse genêro");
                  break;
                }
                for (Serie s : series) {
                  if(s == null){
                    break;
                  }
                  System.out.println(s.getNome());
                }
                break;
              case 4:
                series = streaming.filtrarPorGenero("Suspense").allElements(series);
                if(series.length == 0) {
                  System.out.println("Não existem series com esse genêro");
                  break;
                }
                for (Serie s : series) {
                  if(s == null){
                    break;
                  }
                  System.out.println(s.getNome());
                }
                break;
              case 5:
                series = streaming.filtrarPorGenero("Drama").allElements(series);
                if(series.length == 0) {
                  System.out.println("Não existem series com esse genêro");
                  break;
                }
                for (Serie s : series) {
                  if(s == null){
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
          case 3: //SÉRIE POR QUANTIDADE DE EPISÓDIOS
            System.out.println("Digite a quantidade de episodios ");
            int numEpisodios = input.nextInt();
            Serie[] seriesEp = new Serie[streaming.series.size()];
            seriesEp = streaming.filtrarPorQtdEpisodios(numEpisodios).allElements(seriesEp);
            for(Serie s : seriesEp){
              if(s == null){
                break;
              }
              if(s.getQuantidadeEpisodios() == numEpisodios){
                System.out.println(s.getNome());
              }
            }
            break;
          default:
            System.out.println("Código inválido");
            break;
        }
      } while (opcao != 0);
    } else { //FILMES
      do {
        System.out.println("Selecione o filtro desejado.");
        System.out.println("1 - Idioma");
        System.out.println("2 - Gênero");
        System.out.println("3 - Duração");
        System.out.println("");
        System.out.println("0 - Sair");
        System.out.print("\nResposta: ");
        opcao = input.nextInt();
        input.nextLine();
        Filme[] filmes;
        switch (opcao) {
          case 0:
            System.out.println("Voltando ao menu");
            break;
          case 1: //FILME POR IDIOMA
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
                filmes = new Filme[streaming.filmes.size()];
                filmes = streaming.filtrarFilmePorIdioma("Inglês").allElements(filmes);
                if(filmes.length == 0) {
                  System.out.println("Não existem filmes neste idioma");
                  break;
                }
                for (Filme f : filmes) {
                  if(f == null){
                    continue;
                  }
                  System.out.println(f.getNome());
                }
                break;
              case 2:
                // streaming.filtrarPorIdioma("Português");
                break;
              case 3:
                // streaming.filtrarPorIdioma("Espanhol");
                break;
              case 4:
                // streaming.filtrarPorIdioma("Mandarim");
                break;
              case 5:
                // streaming.filtrarPorIdioma("Turco");
                break;
  
            }
            break;
          case 2: //FILME POR GÊNERO
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
                filmes = new Filme[streaming.filmes.size()];
                filmes = streaming.filtrarFilmePorGenero("Ação").allElements(filmes);
                if(filmes.length == 0) {
                  System.out.println("Não existem filmes com esse genero");
                  break;
                }
                for (Filme f : filmes) {
                  if(f == null){
                    break;
                  }
                  System.out.println(f.getNome());
                }
                break;
              case 2:
            	  filmes = new Filme[streaming.series.size()];
            	  filmes = streaming.filtrarFilmePorGenero("Terror").allElements(filmes);
                if(filmes.length == 0) {
                  System.out.println("Não existem filmes com esse genêro");
                  break;
                }
                for (Filme f : filmes) {
                  if(f == null){
                    break;
                  }
                  System.out.println(f.getNome());
                }
                break;
              case 3:
            	  filmes = new Filme[streaming.filmes.size()];
            	  filmes = streaming.filtrarFilmePorGenero("Comédia").allElements(filmes);
                if(filmes.length == 0) {
                  System.out.println("Não existem filmes com esse genêro");
                  break;
                }
                for (Filme f : filmes) {
                  if(f == null){
                    break;
                  }
                  System.out.println(f.getNome());
                }
                break;
              case 4:
            	  filmes = new Filme[streaming.filmes.size()];
            	  filmes = streaming.filtrarFilmePorGenero("Suspense").allElements(filmes);
                if(filmes.length == 0) {
                  System.out.println("Não existem filmes com esse genêro");
                  break;
                }
                for (Filme f : filmes) {
                  if(f == null){
                    break;
                  }
                  System.out.println(f.getNome());
                }
                break;
              case 5:
            	  filmes = new Filme[streaming.filmes.size()];
            	  filmes = streaming.filtrarFilmePorGenero("Drama").allElements(filmes);
                if(filmes.length == 0) {
                  System.out.println("Não existem filmes com esse genêro");
                  break;
                }
                for (Filme f : filmes) {
                  if(f == null){
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
          case 3: //FILME POR DURAÇÃO
            System.out.println("Digite a duração desejada(min)");
            int numEpisodios = input.nextInt();
            Serie[] seriesEp = new Serie[streaming.series.size()];
            seriesEp = streaming.filtrarPorQtdEpisodios(numEpisodios).allElements(seriesEp);
            for(Serie s : seriesEp){
              if(s == null){
                break;
              }
              if(s.getQuantidadeEpisodios() == numEpisodios){
                System.out.println(s.getNome());
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