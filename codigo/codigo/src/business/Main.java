package business;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import excecoes.ExecaoNota;
import excecoes.ExecaoValorInvalido;

class Main {

  // randomizador
  // ===========================================================================================
  private final static Random gerador = new Random();
  // ===========================================================================================

  // declaração de variável
  // ===========================================================================================
  static Scanner input = new Scanner(System.in);
  static PlataformaStreaming streaming = new PlataformaStreaming("Uiuiflix");
  int opcao;
  // ===========================================================================================

  /////////////////////////////////////////////////////////// menu
  /////////////////////////////////////////////////////////// principal\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
  public static void main(String[] args) {
    try {
      menuPrincipal();
    } catch (ExecaoValorInvalido e) {
      System.out.println("Erro: " + e.getMessage());
    } catch (ExecaoNota e) {
      System.out.println("Erro: " + e.getMessage());
    }
  }

  public static void menuPrincipal() throws ExecaoValorInvalido, ExecaoNota {
    streaming.carregarArquivo("POO_Series_2023/POO_Espectadores.csv", 1);
    streaming.carregarArquivo("POO_Series_2023/POO_Series.csv", 2);
    streaming.carregarArquivo("POO_Series_2023/POO_Audiencia.csv", 3);
    streaming.carregarArquivo("POO_Series_2023/POO_Filmes.csv", 4);
    streaming.carregarArquivo("POO_Series_2023/POO_Trailer.csv", 5);
    boolean logado = false;
    int opcao;

    do {
      System.out.println("\nBem vindo ao Uiuiflix!\nSelecione a opção desejada.\n1 - Cadastro\n2 - Entrar");
      if (streaming.getClienteAtual() != null) {
        logado = true;
        System.out.println(
            "3 - Suas Series\n4 - Seus Filmes\n5 - Menu de  trailers  \n6 - Gerenciar Series\n7 - Gerenciar Filmes\n8 - Relatórios\n9 - Cadastrar cliente profissional");
      }
      System.out.println("\n0 - Sair\nResposta: ");
      opcao = lerOpcao();

      switch (opcao) {
        case 0:
          System.out.println("Até mais! o/ ");
          break;
        // --------------------------------------------------
        case 1:
          cadastrarUsuario();
          break;
        // --------------------------------------------------
        case 2:
          // listarC();
          logarPlataforma();
          break;
        // --------------------------------------------------
        case 3:
          if (!logado) {
            System.out.println("Logue antes de acessar esse recurso");
            break;
          }
          menuSeries();
          break;
        // --------------------------------------------------
        case 4:
          if (!logado) {
            System.out.println("Logue antes de acessar esse recurso");
            break;
          }
          menuFilmes();
          break;
        // --------------------------------------------------
        case 5:
          if (!logado) {
            System.out.println("Logue antes de acessar esse recurso");
            break;
          }
          menuTrailer();
          break;
        // --------------------------------------------------
        case 6:
          if (!logado) {
            System.out.println("Logue antes de acessar esse recurso");
            break;
          }
          gerenciarS(); // mudar
          break;
        // --------------------------------------------------
        case 7:
          if (!logado) {
            System.out.println("Logue antes de acessar esse recurso");
            break;
          }
          gerenciarF(); // mudar
          break;
        // --------------------------------------------------
        case 8:
          if (!logado) {
            System.out.println("Logue antes de acessar esse recurso");
            break;
          }
          gerenciarC();
          break;
        // --------------------------------------------------
        case 9: // verificar se o mano já deu a nota
          if (!logado) {
            System.out.println("Logue antes de acessar esse recurso");
            break;
          }
          cadastrarUsuarioProfissional();
          break;
        // --------------------------------------------------

        default:
          System.out.println("Código inválido");
          break;
      }
    } while (opcao != 0);
  }

  /////////////////////////////////////////////////////////// menu
  /////////////////////////////////////////////////////////// series\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
  public static void menuSeries() throws ExecaoValorInvalido, ExecaoNota {
    int opcao;
    Cliente eu;
    int id;
    Conteudo c;
    Boolean existe = false;
    do {
      System.out.println("");
      System.out.println("1 - Mostrar series para ver ");
      System.out.println("2 - Mostrar series ja vistas ");
      System.out.println("3 - Assistir serie");
      System.out.println("4 - Adicionar serie a lista");
      System.out.println("5 - Filtrar suas series");
      System.out.println("6 - Filtrar todas as series ");
      System.out.println("7 - Dar nota uma serie ja vista ");
      System.out.println("");
      System.out.println("0 - Voltar");
      System.out.print("\nResposta: ");
      opcao = lerOpcao();
      switch (opcao) {
        case 0:
          System.out.println("Voltando ao menu");
          break;
        case 1:
          streaming.seriesParaVer();
          // Séries da lista
          break;
        case 2:
          streaming.seriesJaVistas();
          break;
        case 3: // Mudado no dia 20/06
          eu = streaming.getClienteAtual();
          List<Conteudo> lista = eu.getListaParaVer();
          for (Conteudo l : lista) {
            if (l instanceof Serie) {
              System.out.println(l);
            }
          }
          System.out.print("Id da serie que deseja assistir: ");
          id = lerId();

          for (Conteudo l : lista) {
            if (l.getId() == id) {
              existe = true;
            }
          }

          while (!existe) {
            System.out.println("Id precisa estar na sua lista!\nDigite novamente ou 0 para sair: ");
            id = lerId();
            if (id == 0) {
              break;
            }
            for (Conteudo l : lista) {
              if (l.getId() == id) {
                existe = true;
              }
            }
          }

          if (id == 0) {
            break;
          }

          c = streaming.getConteudo(id);

          // MELHORAR CÓDIGO
          if (c.getELancamento()) {

            if (eu instanceof Profissional) {
              eu.assisteConteudo(c);
              streaming.salvaAudiencia(eu.getLogin(), 'A', c.getId());
              streaming.verificaCliente();

              System.out.print("Deseja avaliar o conteúdo?(S/N) ");
              char darNota = input.nextLine().toUpperCase().charAt(0);
              if (darNota != 'S')
                break;

              avaliacao(c);
              break;
            }

            System.out.println("Está série está em lançamento, não é possível assisti-la no momento");
            break;

          } else {
            eu.assisteConteudo(c);
            streaming.salvaAudiencia(eu.getLogin(), 'A', c.getId());
            streaming.verificaCliente();

            System.out.print("Deseja avaliar o conteúdo?(S/N) ");
            char darNota = input.nextLine().toUpperCase().charAt(0);
            if (darNota != 'S')
              break;

            avaliacao(c);
            break;
          }

        case 4: // TODO
          eu = streaming.getClienteAtual();
          Map<Integer, Serie> series = streaming.listarS();
          System.out.print("\nId da série para ver: ");
          int resp = lerId();

          while (!series.containsKey(resp)) { // TODO
            System.out.println("Id invalido digite novamente ou 0 para sair: ");
            resp = lerId();
            if (resp == 0) {
              break;
            }
          }

          if (resp == 0) {
            break;
          }
          eu.adicionarNaLista(streaming.conteudos.get(resp));
          streaming.salvaAudiencia(eu.getLogin(), 'F', resp);

          // Adicionar na lista
          break;
        case 5:
          filtros(1, 1);
          break;
        case 6:
          filtros(1, 2);
          break;
        case 7:
          boolean existeJ = false;
          eu = streaming.getClienteAtual();
          List<Conteudo> listaJ = eu.getListaJaVista();
          for (Conteudo l : listaJ) {
            if (l instanceof Serie) {
              System.out.println(l);
            }
          }
          System.out.print("Id do conteúdo para avaliar: ");
          id = lerId();

          for (Conteudo l : listaJ) {
            if (l.getId() == id) {
              existeJ = true;
            }
          }
          while (!existeJ) {
            System.out.println(
                "Id precisa estar na sua lista de series ja vistas\nDigite novamente ou 0 para sair: ");
            id = lerId();
            if (id == 0) {
              break;
            }

            for (Conteudo l : listaJ) {
              if (l.getId() == id) {
                existeJ = true;
              }
            }
          }
          if (id == 0) {
            break;
          }

          c = streaming.getConteudo(id);

          avaliacao(c);

          break;
        default:
          System.out.println("Código inválido");
          break;
      }

    } while (opcao != 0);
  }
  //////////////////////////////////////////////////////////////// \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

  public static void avaliacao(Conteudo c) throws ExecaoValorInvalido, ExecaoNota {

    Cliente eu = streaming.getClienteAtual();
    Avaliacao a;
    if (!eu.clienteSemAvaliacao(c)) {

      // Comentar
      // -----------------------------------------------------------
      System.out.print("Nota do conteúdo (1 a 5): ");
      int nota = lerNota();
      while (nota == -1) {
        System.out.println("Nota invalida tente novamente (nota de 1 a 5):");
        nota = lerNota();
      }
      // -----------------------------------------------------------

      // Comentar
      // -----------------------------------------------------------
      if (eu instanceof IEspecialista) {
        System.out.print("Insira seu comentário: ");
        String comentario = input.nextLine();

        a = eu.avaliar(c.getId(), nota, comentario);
      } else {

        a = eu.avaliar(c.getId(), nota);
      }
      // -----------------------------------------------------------

      streaming.salvaAvalicao(a);
    } else {
      System.out.println("Você já deu nota para esse conteúdo");
    }
  }

  /////////////////////////////////////////////////////////// menu
  /////////////////////////////////////////////////////////// filmes\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
  public static void menuFilmes() throws ExecaoValorInvalido, ExecaoNota {// mudar funções
    int opcao;
    Cliente eu;
    int id;
    Conteudo c;
    Boolean existe = false;
    do {
      System.out.println("1 - Mostrar filmes para ver ");
      System.out.println("2 - Mostrar filmes ja vistos ");
      System.out.println("3 - Assistir filme");
      System.out.println("4 - Adicionar filme a lista");
      System.out.println("5 - Filtrar seus filmes");
      System.out.println("6 - Filtrar todos os filmes");
      System.out.println("7 - Dar nota um filme ja visto ");
      System.out.println("");
      System.out.println("0 - Voltar");
      System.out.print("\nResposta: ");
      opcao = lerOpcao();
      switch (opcao) {
        case 0:
          System.out.println("Voltando ao menu");
          break;
        case 1:

          streaming.filmesParaVer();
          // Séries da lista
          break;
        case 2:
          streaming.filmesJaVistas();

          break;
        case 3:

          eu = streaming.getClienteAtual();
          List<Conteudo> lista = eu.getListaParaVer();
          for (Conteudo l : lista) {
            if (l instanceof Filme) {
              System.out.println(l);
            }
          }
          System.out.print("Id do Filme que deseja assistir: ");
          id = lerId();

          for (Conteudo l : lista) {
            if (l.getId() == id) {
              existe = true;
            }
          }

          while (!existe) {
            System.out.println("Id precisa estar na sua lista!\nDigite novamente ou 0 para sair: ");
            id = lerId();
            if (id == 0) {
              break;
            }
            for (Conteudo l : lista) {
              if (l.getId() == id) {
                existe = true;
              }
            }
          }
          if (id == 0) {
            break;
          }
          c = streaming.getConteudo(id);

          // MELHORAR CÓDIGO
          if (c.getELancamento()) {

            if (eu instanceof Profissional) {
              eu.assisteConteudo(c);
              streaming.salvaAudiencia(eu.getLogin(), 'A', c.getId());
              streaming.verificaCliente();

              System.out.print("Deseja avaliar o conteúdo?(S/N) ");
              char darNota = input.nextLine().toUpperCase().charAt(0);
              if (darNota != 'S')
                break;

              avaliacao(c);
              break;
            }

            System.out.println("Está série está em lançamento, não é possível assisti-la no momento");
            break;

          } else {
            eu.assisteConteudo(c);
            streaming.salvaAudiencia(eu.getLogin(), 'A', c.getId());
            streaming.verificaCliente();

            System.out.print("Deseja avaliar o conteúdo?(S/N) ");
            char darNota = input.nextLine().toUpperCase().charAt(0);
            if (darNota != 'S')
              break;

            avaliacao(c);
            break;
          }

        case 4: // TODO

          eu = streaming.getClienteAtual();
          Map<Integer, Filme> filmes = streaming.listarF(); // TODO
          System.out.print("\nId do filme para ver: ");
          int resp = lerId();

          while (!filmes.containsKey(resp)) { // TODO
            System.out.println("Id invalido digite novamente ou 0 para sair: ");
            resp = lerId();
            if (resp == 0) {
              break;
            }
          }

          if (resp == 0) {
            break;
          }
          eu.adicionarNaLista(streaming.conteudos.get(resp));
          streaming.salvaAudiencia(eu.getLogin(), 'F', resp);
          // Adicionar na lista
          break;

        case 5:
          filtros(2, 1);
          break;
        case 6:
          filtros(2, 2);
          break;
        case 7:
          boolean existeJ = false;
          eu = streaming.getClienteAtual();
          List<Conteudo> listaJ = eu.getListaJaVista();
          for (Conteudo l : listaJ) {
            if (l instanceof Filme) {
              System.out.println(l);
            }
          }
          System.out.print("Id do conteúdo para avaliar: ");
          id = lerId();

          for (Conteudo l : listaJ) {
            if (l.getId() == id) {
              existeJ = true;
            }
          }
          while (!existeJ) {
            System.out.println(
                "Id precisa estar na sua lista de filmes ja vistas\nDigite novamente ou 0 para sair: ");
            id = lerId();
            if (id == 0) {
              break;
            }

            for (Conteudo l : listaJ) {
              if (l.getId() == id) {
                existeJ = true;
              }
            }
          }
          if (id == 0) {
            break;
          }

          c = streaming.getConteudo(id);

          avaliacao(c);

          break;
        default:
          System.out.println("Código inválido");
          break;
      }

    } while (opcao != 0);
  }
  ///////////////////////////////////////////////////////////////// \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

  /////////////////////////////////////////////////////////// menu
  /////////////////////////////////////////////////////////// trailer\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
  public static void menuTrailer() throws ExecaoValorInvalido, ExecaoNota {// mudar funções
    int opcao;
    do {
      System.out.println("1 - Mostrar trailers");
      System.out.println("2 - Adicionar trailer");
      System.out.println("3 - Assistir trailer");
      System.out.println("0 - Voltar");
      System.out.print("\nResposta: ");
      opcao = lerOpcao();
      switch (opcao) {
        case 0:
          System.out.println("Voltando ao menu");
          break;
        case 1:
          streaming.listarT();
          // Séries da lista
          break;
        case 2:
          System.out.print("Nome do trailer: ");
          String nome = input.nextLine();
          System.out.print("Id: ");

          int id = lerId();
          while (id == -1) {
            System.out.println("Apenas numeros positivos\nDigite novamente");
            id = lerId();
          }
          streaming.adicionaTrailer(id, nome);

          break;
        case 3:
          System.out.print("Id do trailer que deseja assistir: ");
          Map<Integer, Trailer> listaTrailer = streaming.listarT();

          int idT = lerId();
          while (idT<0) {
            System.out.println("Apenas numeros positivos\nDigite novamente");
            idT = lerId();
          }

          streaming.assisteTrailer(idT);

          // Assistir
          break;
        default:
          System.out.println("Código inválido");
          break;
      }

    } while (opcao != 0);
  }
  ///////////////////////////////////////////////////////////////// \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

  /////////////////////////////////////////////////////////// menu
  /////////////////////////////////////////////////////////// filtros\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
  public static void filtros(int tipo, int lista) throws ExecaoValorInvalido {
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
        System.out.println("4 - Nome");
        System.out.println("");
        System.out.println("0 - Sair");
        System.out.print("\nResposta: ");

        opcao = lerOpcao();

        List<Conteudo> series;

        String strIdioma;

        switch (opcao) {
          case 0:
            System.out.println("Voltando ao menu");
            break;
          // xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
          case 1: // SÉRIE POR IDIOMA

            System.out.println("");
            System.out.println("Qual idioma você deseja filtrar? ");
            System.out.println("1 - Inglês");
            System.out.println("2 - Português");
            System.out.println("3 - Espanhol");
            System.out.println("4 - Mandarim");
            System.out.println("5 - Turco");
            System.out.print("\nResposta: ");
            idioma = lerOpcao();

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
              series = streaming.filtrarPorIdioma(strIdioma);
            } else { // Lista do cliente atual
              series = streaming.getClienteAtual().filtrarPorIdioma(strIdioma);
            }

            if (series == null) {
              System.out.println("Não existem series neste idioma");
              break;
            }

            for (Conteudo s : series) { // display das séries
              if (s == null) {
                continue;
              }
              System.out.println(s.getNome());
            }
            break;
          // xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

          case 2: // SÉRIE POR GÊNERO
            System.out.println("");
            System.out.println("Qual genero você deseja filtrar? ");
            System.out.println("1 - Ação");
            System.out.println("2 - Terror");
            System.out.println("3 - Comédia");
            System.out.println("4 - Suspense");
            System.out.println("5 - Drama");
            System.out.print("\nResposta: ");
            idioma = lerOpcao();
            switch (idioma) {
              case 1:
                if (lista == 2) { // Lista de todos
                  series = streaming.filtrarPorGenero("Ação");
                } else { // Lista do cliente atual
                  series = streaming.getClienteAtual().filtrarPorGenero("Ação");
                }
                if (series == null) {
                  System.out.println("Não existem series com esse genero");
                  break;
                }
                for (Conteudo s : series) {
                  if (s == null) {
                    break;
                  }
                  System.out.println(s.getNome());
                }
                break;
              case 2:
                if (lista == 2) { // Lista de todos
                  series = streaming.filtrarPorGenero("Terror");
                } else { // Lista do cliente atual
                  series = streaming.getClienteAtual().filtrarPorGenero("Terror");
                }
                if (series == null) {
                  System.out.println("Não existem series com esse genêro");
                  break;
                }
                for (Conteudo s : series) {
                  if (s == null) {
                    break;
                  }
                  System.out.println(s.getNome());
                }
                break;
              case 3:
                if (lista == 2) { // Lista de todos
                  series = streaming.filtrarPorGenero("Comédia");
                } else { // Lista do cliente atual
                  series = streaming.getClienteAtual().filtrarPorGenero("Comédia");
                }
                if (series == null) {
                  System.out.println("Não existem series com esse genêro");
                  break;
                }
                for (Conteudo s : series) {
                  if (s == null) {
                    break;
                  }
                  System.out.println(s.getNome());
                }
                break;
              case 4:
                if (lista == 2) { // Lista de todos
                  series = streaming.filtrarPorGenero("Suspense");
                } else { // Lista do cliente atual
                  series = streaming.getClienteAtual().filtrarPorGenero("Suspense");
                }
                if (series == null) {
                  System.out.println("Não existem series com esse genêro");
                  break;
                }
                for (Conteudo s : series) {
                  if (s == null) {
                    break;
                  }
                  System.out.println(s.getNome());
                }
                break;
              case 5:
                if (lista == 2) { // Lista de todos
                  series = streaming.filtrarPorGenero("Drama");
                } else { // Lista do cliente atual
                  series = streaming.getClienteAtual().filtrarPorGenero("Drama");
                }
                if (series == null) {
                  System.out.println("Não existem series com esse genêro");
                  break;
                }
                for (Conteudo s : series) {
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
          // xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
          case 3: // SÉRIE POR QUANTIDADE DE EPISÓDIOS
            System.out.println("\nDigite a quantidade de episodios ");
            int numEpisodios = lerOpcao();
            while (numEpisodios == -1) {
              System.out.println("Por favor digite um numero inteiro\nDigite novamente:");
              numEpisodios = lerOpcao();
            }
            List<Serie> seriesEp;
            if (lista == 2) { // Lista de todos
              seriesEp = streaming.filtrarPorQtdEpisodios(numEpisodios);
            } else { // Lista do cliente atual
              Cliente atual = streaming.getClienteAtual();
              seriesEp = atual.filtrarPorQtdEpisodios(numEpisodios);
            }
            if (seriesEp.isEmpty()) {
              System.out.println("Nenhuma serie com essa quantidade de episodios");
            }
            for (Serie s : seriesEp) {
              if (s.getQuantidadeEpisodios() == numEpisodios) {
                System.out.println(s.getNome());
              }
            }
            break;
          case 4:
                System.out.print("\nDigite o nome da serie: ");
                Scanner scan = new Scanner(System.in);
                String nome = scan.nextLine();

                if(lista == 1) {
                    List<Conteudo> nomeSeries = streaming.getClienteAtual().filtrarPorNome(nome);

                    nomeSeries.stream()
                            .filter(c -> c instanceof Serie)
                            .map(c -> (Serie) c)
                            .forEach(s -> System.out.println(s.getNome()));
                } else {
                    List<Conteudo> nomeSeries = streaming.filtrarPorNome(nome);

                    nomeSeries.stream()
                            .filter(c -> c instanceof Serie)
                            .map(c -> (Serie) c)
                            .forEach(s -> System.out.println(s.getNome()));
                }

                break;

          default:
            System.out.println("Código inválido");
            break;

        }
      } while (opcao != 0);
      // o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-
    } else { // FILMES
      do {

        System.out.println("\nSelecione o filtro desejado.");
        System.out.println("1 - Idioma");
        System.out.println("2 - Gênero");
        System.out.println("3 - Duração");
        System.out.println("4 - Nome");
        System.out.println("");
        System.out.println("0 - Sair");
        System.out.print("\nResposta: ");
        opcao = lerOpcao();

        List<Conteudo> filmes;
        String strIdioma;

        switch (opcao) {
          case 0:
            System.out.println("Voltando ao menu");
            break;
          // xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
          case 1: // FILME POR IDIOMA
            System.out.println("\nQual idioma você deseja filtrar? ");
            System.out.println("1 - Inglês");
            System.out.println("2 - Português");
            System.out.println("3 - Espanhol");
            System.out.println("4 - Mandarim");
            System.out.println("5 - Turco");
            System.out.print("\nResposta: ");
            idioma = lerOpcao();
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
              filmes = streaming.filtrarPorIdioma(strIdioma);
            } else { // Lista do cliente atual
              filmes = streaming.getClienteAtual().filtrarPorIdioma(strIdioma);
            }
            if (filmes == null) {
              System.out.println("Não existem series neste idioma");
              break;
            }
            for (Conteudo f : filmes) { // display das séries
              if (f == null) {
                continue;
              }
              System.out.println(f.getNome());
            }
            break;
          // xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
          case 2: // FILME POR GÊNERO
            System.out.println("\nQual genero você deseja filtrar? ");
            System.out.println("1 - Ação");
            System.out.println("2 - Terror");
            System.out.println("3 - Comédia");
            System.out.println("4 - Suspense");
            System.out.println("5 - Drama");
            System.out.print("\nResposta: ");

            idioma = lerOpcao();

            switch (idioma) {

              case 1:
                if (lista == 2) { // Lista de todos
                  filmes = streaming.filtrarPorGenero("Ação");
                } else { // Lista do cliente atual
                  filmes = streaming.getClienteAtual().filtrarPorGenero("Ação");
                }
                if (filmes == null) {
                  System.out.println("Não existem series com esse genero");
                  break;
                }
                for (Conteudo f : filmes) {
                  if (f == null) {
                    break;
                  }
                  System.out.println(f.getNome());
                }
                break;

              case 2:
                if (lista == 2) { // Lista de todos
                  filmes = streaming.filtrarPorGenero("Terror");
                } else { // Lista do cliente atual
                  filmes = streaming.getClienteAtual().filtrarPorGenero("Terror");
                }
                if (filmes == null) {
                  System.out.println("Não existem series com esse genêro");
                  break;
                }
                for (Conteudo f : filmes) {
                  if (f == null) {
                    break;
                  }
                  System.out.println(f.getNome());
                }
                break;

              case 3:
                if (lista == 2) { // Lista de todos
                  filmes = streaming.filtrarPorGenero("Comédia");
                } else { // Lista do cliente atual
                  filmes = streaming.getClienteAtual().filtrarPorGenero("Comédia");
                }
                if (filmes == null) {
                  System.out.println("Não existem series com esse genêro");
                  break;
                }
                for (Conteudo f : filmes) {
                  if (f == null) {
                    break;
                  }
                  System.out.println(f.getNome());
                }
                break;

              case 4:
                if (lista == 2) { // Lista de todos
                  filmes = streaming.filtrarPorGenero("Suspense");
                } else { // Lista do cliente atual
                  filmes = streaming.getClienteAtual().filtrarPorGenero("Suspense");
                }
                if (filmes == null) {
                  System.out.println("Não existem series com esse genêro");
                  break;
                }
                for (Conteudo f : filmes) {
                  if (f == null) {
                    break;
                  }
                  System.out.println(f.getNome());
                }
                break;

              case 5:
                if (lista == 2) { // Lista de todos
                  filmes = streaming.filtrarPorGenero("Drama");
                } else { // Lista do cliente atual
                  filmes = streaming.getClienteAtual().filtrarPorGenero("Drama");
                }
                if (filmes == null) {
                  System.out.println("Não existem series com esse genêro");
                  break;
                }
                for (Conteudo f : filmes) {
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
          // xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
          case 3: // FILME POR DURAÇÃO
            System.out.println("\nDigite a duração desejada(min)");
            int numDuracao = lerOpcao();
            while (numDuracao == -1) {
              System.out.println("Por favor digite um numero inteiro\nDigite novamente:");
              numDuracao = lerOpcao();
            }
            List<Filme> filmeDuracao;
            if (lista == 2) { // Lista de todos
              filmeDuracao = streaming.filtrarPorDuracao(numDuracao);
            } else { // Lista do cliente atual
              Cliente atual = streaming.getClienteAtual();
              filmeDuracao = atual.filtrarFilmePorDuracao(numDuracao);
            }
            if (filmeDuracao.isEmpty()) {
              System.out.println("Nenhuma filme com essa duracao");
            }
            for (Filme s : filmeDuracao) {
              if (s.getDuracao() == numDuracao) {
                System.out.println(s.getNome());
              }
            }
            break;
          case 4:
              System.out.print("\nDigite o nome da serie: ");
              Scanner scan = new Scanner(System.in);
              String nome = scan.nextLine();

              if(lista == 1) {
                  List<Conteudo> nomeSeries = streaming.getClienteAtual().filtrarPorNome(nome);

                  nomeSeries.stream()
                          .filter(c -> c instanceof Filme)
                          .map(c -> (Filme) c)
                          .forEach(f -> System.out.println(f.getNome()));
              } else {
                  List<Conteudo> nomeSeries = streaming.filtrarPorNome(nome);

                  nomeSeries.stream()
                          .filter(c -> c instanceof Filme)
                          .map(c -> (Filme) c)
                          .forEach(f -> System.out.println(f.getNome()));
              }
              break;
          // xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

          default:
            System.out.println("Código inválido");
            break;

        }
      } while (opcao != 0);
    }
  }
  ///////////////////////////////////////////////////////////////// \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

  /////////////////////////////////////////////////////////// menu gerenciar
  /////////////////////////////////////////////////////////// serie\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
  public static void gerenciarS() throws ExecaoValorInvalido, ExecaoNota {
    int opcao;
    do {
      System.out.println();
      System.out.println("1 - Lista de séries");
      System.out.println("2 - Cadastrar série");
      System.out.println("");
      System.out.println("0 - Voltar");
      System.out.print("\nResposta: ");
      opcao = lerOpcao();
      switch (opcao) {
        case 0:
          System.out.println("Voltando ao menu");
          break;
        case 1:
          streaming.listarS();
          break;
        case 2:
          System.out.print("Nome da série: ");
          String nome = input.nextLine();
          System.out.print("Data de lançamento: ");
          String dt = lerData();
          System.out.print("Digite o id: ");
          int resp = lerOpcao();
          while (resp == -1) {
            System.out.print("Digite Novamente: ");
            resp = lerOpcao();
          }
          streaming.adicionaSeries(resp, nome, dt);
          break;

        default:
          System.out.println("Código inválido");
          break;
      }
    } while (opcao != 0);
  }
  ///////////////////////////////////////////////////////////////// \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

  /////////////////////////////////////////////////////////// menu gerenciar
  /////////////////////////////////////////////////////////// filme\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
  public static void gerenciarF() throws ExecaoValorInvalido, ExecaoNota {
    int opcao;
    do {
      System.out.println("");
      System.out.println("1 - Lista de filmes ");
      System.out.println("2 - Cadastrar filme");
      System.out.println("");
      System.out.println("0 - Voltar");
      System.out.print("\nResposta: ");
      opcao = lerOpcao();
      switch (opcao) {
        case 0:
          System.out.println("Voltando ao menu");
          break;
        case 1:
          streaming.listarF();
          break;
        case 2:
          System.out.print("Nome da série: ");
          String nome = input.nextLine();
          System.out.print("Data de lançamento: ");
          String dt = lerData();
          System.out.print("Id: ");
          int resp = lerOpcao();
          while (resp == -1) {
            System.out.print("Digite Novamente: ");
            resp = lerOpcao();
          }
          System.out.print("Duração em minutos: ");
          int duracao = lerOpcao();
          while (duracao == -1) {
            System.out.print("Digite Novamente: ");
            duracao = lerOpcao();
          }
          streaming.adicionaFilmes(resp, nome, dt, duracao);
          break;
        default:
          System.out.println("Código inválido");
          break;
      }

    } while (opcao != 0);
  }
  ///////////////////////////////////////////////////////////////// \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

  /////////////////////////////////////////////////////////// menu gerenciar
  /////////////////////////////////////////////////////////// filme\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
  public static void gerenciarC() {
    int opcao;
    do {
      System.out.println("");
      System.out.println("1 - Dez conteudos mais vistos");
      System.out.println("2 - Cem conteudos mais vistos");
      System.out.println("3 - Dez conteudos mais vistos por gênero");
      System.out.println("4 - Cem conteudos mais vistos por gênero");

      System.out.println("5 - Dez conteudos mais bem avaliados");
      System.out.println("6 - Cem conteudos mais bem avaliados");
      System.out.println("7 - Dez conteudos mais bem avaliados por gênero");
      System.out.println("8 - Cem conteudos mais bem avaliados por gênero");
      System.out.println("");
      System.out.println("0 - Voltar");
      System.out.print("\nResposta: ");
      opcao = lerOpcao();
      switch (opcao) {
        case 0:
          System.out.println("Voltando ao menu");
          break;
        case 1:
          streaming.conteudosMaisVistas(10);
          break;
        case 2:
          streaming.conteudosMaisVistas(100);
          break;
          case 3:
          System.out.println("Digite o genêro que você quer filtrar");
          System.out.println("1 - Ação");
          System.out.println("2 - Aventura");
          System.out.println("3 - Anime");
          System.out.println("4 - Comédia");
          System.out.println("5 - Documentario");
          System.out.println("6 - Drama");
          System.out.println("7 - Policial");
          System.out.println("8 - Romance");
          System.out.println("9 - Suspense");
          System.out.println("0 - Voltar");
          System.out.print("\nResposta: ");
          int idGenero = lerOpcao();
          switch (idGenero) {
            case 1:
              streaming.conteudosMaisVistasPorGenero(10, 1);
              break;
            case 2:
              streaming.conteudosMaisVistasPorGenero(10, 2);
              break;
            case 3:
              streaming.conteudosMaisVistasPorGenero(10, 3);
              break;
            case 4:
              streaming.conteudosMaisVistasPorGenero(10, 5);
              break;
            case 5:
              streaming.conteudosMaisVistasPorGenero(10, 5);
              break;
            case 6:
              streaming.conteudosMaisVistasPorGenero(10, 6);
              break;
            case 7:
              streaming.conteudosMaisVistasPorGenero(10, 7);
              break;
            case 8:
              streaming.conteudosMaisVistasPorGenero(10, 8);
              break;
            case 9:
              streaming.conteudosMaisVistasPorGenero(10, 9);
              break;
            case 0:
              gerenciarC();
            default:
              System.out.println("Código inválido");
              break;
          }
          break;
        case 4:
          System.out.println("Digite o genêro que você quer filtrar");
          System.out.println("1 - Ação");
          System.out.println("2 - Aventura");
          System.out.println("3 - Anime");
          System.out.println("4 - Comédia");
          System.out.println("5 - Documentario");
          System.out.println("6 - Drama");
          System.out.println("7 - Policial");
          System.out.println("8 - Romance");
          System.out.println("9 - Suspense");
          System.out.println("0 - Voltar");
          System.out.print("\nResposta: ");
          idGenero = lerOpcao();
          switch (idGenero) {
            case 1:
              streaming.conteudosMaisVistasPorGenero(100, 1);
              break;
            case 2:
              streaming.conteudosMaisVistasPorGenero(100, 2);
              break;
            case 3:
              streaming.conteudosMaisVistasPorGenero(100, 3);
              break;
            case 4:
              streaming.conteudosMaisVistasPorGenero(100, 5);
              break;
            case 5:
              streaming.conteudosMaisVistasPorGenero(100, 5);
              break;
            case 6:
              streaming.conteudosMaisVistasPorGenero(100, 6);
              break;
            case 7:
              streaming.conteudosMaisVistasPorGenero(100, 7);
              break;
            case 8:
              streaming.conteudosMaisVistasPorGenero(100, 8);
              break;
            case 9:
              streaming.conteudosMaisVistasPorGenero(100, 9);
              break;
            case 0:
              gerenciarC();
            default:
              System.out.println("Código inválido");
              break;
          }
          break;
        case 5:
          streaming.verMelhoresAvaliados(10);
          break;
        case 6:
          streaming.verMelhoresAvaliados(100);
          break;
        case 7:
          System.out.println("Digite o genêro que você quer filtrar");
          System.out.println("1 - Ação");
          System.out.println("2 - Aventura");
          System.out.println("3 - Anime");
          System.out.println("4 - Comédia");
          System.out.println("5 - Documentario");
          System.out.println("6 - Drama");
          System.out.println("7 - Policial");
          System.out.println("8 - Romance");
          System.out.println("9 - Suspense");
          System.out.println("0 - Voltar");
          System.out.print("\nResposta: ");
           idGenero = lerOpcao();
          switch (idGenero) {
            case 1:
              streaming.verMelhoresAvaliadosPorGenero(10, 1);
              break;
            case 2:
              streaming.verMelhoresAvaliadosPorGenero(10, 2);
              break;
            case 3:
              streaming.verMelhoresAvaliadosPorGenero(10, 3);
              break;
            case 4:
              streaming.verMelhoresAvaliadosPorGenero(10, 5);
              break;
            case 5:
              streaming.verMelhoresAvaliadosPorGenero(10, 5);
              break;
            case 6:
              streaming.verMelhoresAvaliadosPorGenero(10, 6);
              break;
            case 7:
              streaming.verMelhoresAvaliadosPorGenero(10, 7);
              break;
            case 8:
              streaming.verMelhoresAvaliadosPorGenero(10, 8);
              break;
            case 9:
              streaming.verMelhoresAvaliadosPorGenero(10, 9);
              break;
            case 0:
              gerenciarC();
            default:
              System.out.println("Código inválido");
              break;
          }
          break;
        case 8:
          System.out.println("Digite o genêro que você quer filtrar");
          System.out.println("1 - Ação");
          System.out.println("2 - Aventura");
          System.out.println("3 - Anime");
          System.out.println("4 - Comédia");
          System.out.println("5 - Documentario");
          System.out.println("6 - Drama");
          System.out.println("7 - Policial");
          System.out.println("8 - Romance");
          System.out.println("9 - Suspense");
          System.out.println("0 - Voltar");
          System.out.print("\nResposta: ");
          idGenero = lerOpcao();
          switch (idGenero) {
            case 1:
              streaming.verMelhoresAvaliadosPorGenero(100, 1);
              break;
            case 2:
              streaming.verMelhoresAvaliadosPorGenero(100, 2);
              break;
            case 3:
              streaming.verMelhoresAvaliadosPorGenero(100, 3);
              break;
            case 4:
              streaming.verMelhoresAvaliadosPorGenero(100, 5);
              break;
            case 5:
              streaming.verMelhoresAvaliadosPorGenero(100, 5);
              break;
            case 6:
              streaming.verMelhoresAvaliadosPorGenero(100, 6);
              break;
            case 7:
              streaming.verMelhoresAvaliadosPorGenero(100, 7);
              break;
            case 8:
              streaming.verMelhoresAvaliadosPorGenero(100, 8);
              break;
            case 9:
              streaming.verMelhoresAvaliadosPorGenero(100, 9);
              break;
            case 0:
              gerenciarC();
            default:
              System.out.println("Código inválido");
          }
          break;
        default:
          System.out.println("Código inválido");
          break;
      }

    } while (opcao != 0);
  }
  ///////////////////////////////////////////////////////////////// \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

  // ------------------------------funções ligadas ao
  // usuário---------------------------------
  // cadastro de usuario
  public static void cadastrarUsuario() throws ExecaoValorInvalido {

    System.out.println("Digite seu nome");
    String nome = input.nextLine();
    System.out.println("Digite um nome de usuario");
    String username = input.nextLine();
    System.out.println("Digite uma senha");
    String password = input.nextLine();
    Cliente s = new Cliente(nome, password, username);
    while (streaming.clientes.get(s.getLogin()) != null) {
      System.out.print("Já existe um cliente com nome de usuário: " + s.getLogin() + "\nInsira um novo: ");
      String nomeNovo = input.nextLine();
      s.setLogin(nomeNovo);
      nome = nomeNovo;
    }
    streaming.adicionarCliente(s);
    streaming.salvaCliente(nome, password, username);

  }

  public static void cadastrarUsuarioProfissional() {
    System.out.println("Digite seu nome");
    String nome = input.nextLine();
    System.out.println("Digite um nome de usuario");
    String username = input.nextLine();
    System.out.println("Digite uma senha");
    String password = input.nextLine();
    Cliente s = new Profissional(nome, password, username);
    while (streaming.clientes.get(s.getLogin()) != null) {
      System.out.print("Já existe um cliente com nome de usuário: " + s.getLogin() + "\nInsira um novo: ");
      String nomeNovo = input.nextLine();
      s.setLogin(nomeNovo);
      nome = nomeNovo;
    }
    streaming.adicionarCliente(s);
    streaming.salvaCliente(nome, password, username);
  }

  // logar usuário
  public static void logarPlataforma() throws ExecaoValorInvalido {
    while (true) {
      System.out.println("Digite o nome de usuario(0 para cancelar)");
      String login = input.nextLine();
      if (login.equals("0"))
        break;
      System.out.println("Digite uma senha");
      String senha = input.nextLine();
      if (streaming.logar(login, senha) == null) {
        System.out.println("Usuário não foi encontrado D:");

      } else {
        System.out
            .println("\nLogado com sucesso!!\nBem vindo " + streaming.getClienteAtual().getNomeDeUsuario());
        break;
      }
    }
  }
  // ---------------------------------------------------------------
  // ---------------------------------------------------------------

  // metodo que le opção e lança erro caso não seja um inteiro
  public static int lerOpcao() {
    Scanner input = new Scanner(System.in);
    int opcao;

    try {
      opcao = input.nextInt();

    } catch (InputMismatchException e) {
      opcao = -1; // Definir um valor inválido para indicar erro

    }

    return opcao;
  }

  // ---------------------------------------------------------------
  // metodo que le id é garante que é positivo
  public static int lerId() {
    Scanner input = new Scanner(System.in);
    int opcao;

    try {
      opcao = input.nextInt();

      if (opcao < 0) {
        throw new InputMismatchException();
      }

    } catch (InputMismatchException e) {
      opcao = -1; // Definir um valor inválido para indicar erro

    }

    return opcao;
  }

  // ---------------------------------------------------------------
  public static int lerNota() {
    Scanner input = new Scanner(System.in);
    int nota;

    try {
      nota = input.nextInt();

      if (nota < 1 || nota > 5) {
        throw new InputMismatchException();
      }
    } catch (InputMismatchException e) {
      nota = -1; // Definir um valor inválido para indicar erro

    }

    return nota;
  }

  public static void ExecaoValorInvalido(int valor) throws ExecaoValorInvalido {
    if (valor < 0) {
      throw new ExecaoValorInvalido();
    }
  }

  public static void ExecaoNota(int valor) throws ExecaoNota {
    if (valor < 1 || valor > 5) {
      throw new ExecaoNota();
    }
  }

  public static String lerData() {
    Scanner input = new Scanner(System.in);
    String data;
    boolean formatoValido = false;

    do {
      data = input.nextLine();

      // Verifica se a data está no formato xx/xx/xxxx
      if (data.matches("^(0[1-9]|1[0-9]|2[0-9]|30)/(0[1-9]|1[0-2])/(\\d{4})$")) {
        formatoValido = true;
      } else {
        System.out.println("Formato de data inválido. Digite novamente no formato xx/xx/xxxx:");
      }
    } while (!formatoValido);

    return data;
  }

}
