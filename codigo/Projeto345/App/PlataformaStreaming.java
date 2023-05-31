
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class PlataformaStreaming {
  private String nome;
  // public Colection series;
  public Map<Integer, Serie> series;
  public Map<Integer, Filme> filmes;
  public Map<String, Cliente> clientes;
  public Map<Integer, Avaliacao> avaliacoes;
  private Cliente clienteAtual;

  public PlataformaStreaming(String nome) {
    this.nome = nome;
    this.series = new HashMap<Integer, Serie>();
    this.clientes = new HashMap<String, Cliente>();
    this.filmes = new HashMap<Integer, Filme>();
    this.avaliacoes = new HashMap<Integer, Avaliacao>();
    this.clienteAtual = null;
  }

  // ======================================================
  public void adicionarAvaliacao(Avaliacao a) {
    avaliacoes.put(a.getId(), a);
  }

  public Avaliacao getAvaliacao(int id) {
    return avaliacoes.get(id);
  }

  public Map<Integer, Avaliacao> retornaAvaliacoes() {
    return avaliacoes;
  }
  // ======================================================

  public Cliente logar(String login, String senha) {
    this.clienteAtual = null;
    Cliente c = this.clientes.get(login);
    if (c != null && c.getSenha().equals(senha)) {
      System.out.println("Senha:" + c.getSenha());
      this.clienteAtual = c;
    }
    return clienteAtual;
  }

  public Cliente getClienteAtual() {
    return this.clienteAtual;
  }

  public void adicionarSerie(Serie serie) {
    boolean existia = false;
    int id = serie.getId();
    int idNovo = serie.getId();
    while (series.get(serie.getId()) != null) {
      existia = true;
      serie.setId(idNovo++);
    }
    if (existia) {
      //System.out.println("Já existia uma série com o id " + id + " ele será mudado para: " + serie.getId());
    }
    series.put(serie.getId(), serie);
  }

  public Serie getSerie(int id) {
    return series.get(id);
  }

  public void adicionarFilme(Filme filme) {
    filmes.put(filme.getId(), filme);
  }

  public Filme getFilme(int id) {
    return filmes.get(id);
  }

  public void adicionarCliente(Cliente cliente) {// Dá pra melhorar a robustez, é tranquilo
    Scanner input = new Scanner(System.in);
    while (clientes.get(cliente.getLogin()) != null) {
      System.out.print("Já existe um cliente com nome de usuário: " + cliente.getLogin() + "\nInsira um novo: ");
      String nomeNovo = input.nextLine();
      cliente.setLogin(nomeNovo);
    }
    clientes.put(cliente.getLogin(), cliente);
  }

  public Cliente getCliente(String login) {
    return clientes.get(login);
  }

  public Lista<Serie> filtrarPorGenero(String genero) {
    Lista<Serie> listaNova = new Lista<Serie>();
    for (Serie s : this.series.values()) {
      if (s.getGenero().equals(genero)) {
        listaNova.add(s);
      }
    }
    return listaNova;
  }

  public Lista<Serie> filtrarPorIdioma(String idioma) {
    Lista<Serie> listaNova = new Lista<Serie>();
    for (Serie s : this.series.values()) {
      if (s.getIdioma().equals(idioma)) {
        listaNova.add(s);
      }
    }
    return listaNova;
  }

  public Lista<Serie> filtrarPorQtdEpisodios(int quantEpisodios) {
    Lista<Serie> listaNova = new Lista<Serie>();
    for (Serie s : this.series.values()) {
      if (s.getQuantidadeEpisodios() == quantEpisodios) {
        listaNova.add(s);
      }
    }
    return listaNova;
  }

  public Lista<Serie> filtrarPorNome(String nome) {
    Lista<Serie> listaNova = new Lista<Serie>();
    for (Serie s : this.series.values()) {
      if (s.getNome() == nome) {
        listaNova.add(s);
      }
    }
    return listaNova;
  }

  public Lista<Filme> filtrarFilmePorGenero(String genero) {
    Lista<Filme> listaNova = new Lista<>();
    for (Filme f : this.filmes.values()) {
      if (f.getGenero().equals(genero)) {
        listaNova.add(f);
      }
    }
    return listaNova;
  }

  public Lista<Filme> filtrarFilmePorIdioma(String idioma) {
    Lista<Filme> listaNova = new Lista<>();
    for (Filme f : this.filmes.values()) {
      if (f.getIdioma().equals(idioma)) {
        listaNova.add(f);
      }
    }
    return listaNova;
  }

  public Lista<Filme> filtrarFilmePorDuracao(int duracao) {
    int duracaoEmSegundos = duracao * 60;
    Lista<Filme> listaNova = new Lista<>();
    for (Filme f : this.filmes.values()) {
      if (f.getDuracao() == duracaoEmSegundos) {
        listaNova.add(f);
      }
    }
    return listaNova;
  }

  public void registrarAudiencia(Serie serie) {
    series.get(serie.getId()).registrarAudiencia();
  }

  public void registrarAudienciaParaFilme(Filme filme) {
    filmes.get(filme.getId()).registrarAudiencia();
  }

  public Serie[] seriesMaisVistas() {
    return this.series.values()
        .stream()
        .sorted((s1, s2) -> Integer.compare(s2.getAudiencia(), s1.getAudiencia()))
        .limit(10)
        .toArray(Serie[]::new);
  }

    public Serie[] seriesMaisVistasCom100Review() {
    return this.series.values()
        .stream()
        .filter(s -> s.getAvaliacoes().size() > 100)
        .sorted((s1, s2) -> Integer.compare(s2.getAudiencia(), s1.getAudiencia()))
        .limit(10)
        .toArray(Serie[]::new);
  }

  public Serie[] seriesMaisVistasPorGenero(String genero) {
    return this.series.values()
        .stream()
        .filter(s1 -> s1.getGenero().equals(genero))
        .sorted((s1, s2) -> Integer.compare(s2.getAudiencia(), s1.getAudiencia()))
        .limit(10)
        .toArray(Serie[]::new);
  }

  public Serie[] seriesMaisVistasPorGeneroCom100Review(String genero) {
    return this.series.values()
        .stream()
        .filter(s -> s.getAvaliacoes().size() > 100)
        .filter(s1 -> s1.getGenero().equals(genero))
        .sorted((s1, s2) -> Integer.compare(s2.getAudiencia(), s1.getAudiencia()))
        .limit(10)
        .toArray(Serie[]::new);
  }

  public Filme[] filmesMaisVistos() {
    return this.filmes.values()
        .stream()
        .sorted((s1, s2) -> Integer.compare(s2.getAudiencia(), s1.getAudiencia()))
        .limit(10)
        .toArray(Filme[]::new);
  }

  public Filme[] filmesMaisVistosCom100Review() {
    return this.filmes.values()
        .stream()
        .filter(s -> s.getAvaliacoes().size() > 100)
        .sorted((s1, s2) -> Integer.compare(s2.getAudiencia(), s1.getAudiencia()))
        .limit(10)
        .toArray(Filme[]::new);
  }

  public Filme[] filmesMaisVistosPorGenero(String genero) {
    return this.filmes.values()
        .stream()
        .filter(s1 -> s1.getGenero().equals(genero))
        .sorted((s1, s2) -> Integer.compare(s2.getAudiencia(), s1.getAudiencia()))
        .limit(10)
        .toArray(Filme[]::new);
  }

  public Filme[] filmesMaisVistosPorGeneroCom100Review(String genero) {
    return this.filmes.values()
        .stream()
        .filter(s -> s.getAvaliacoes().size() > 100)
        .filter(s1 -> s1.getGenero().equals(genero))
        .sorted((s1, s2) -> Integer.compare(s2.getAudiencia(), s1.getAudiencia()))
        .limit(10)
        .toArray(Filme[]::new);
  }

  public void carregarArquivo(String nomeArquivo, int tipo) {
    Scanner input = new Scanner(System.in);
    Scanner sc; // Scanner para ler do arquivo

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
            param1 = sc.next().trim();
          } else {
            param1 = (sc.next().substring(1)).trim();
            vez++;
          }
          param3 = sc.next().trim();
          param2 = sc.next().trim();
          adicionarCliente(new Cliente(param1, param2, param3));
        }
        break;
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
            if (series.get(Integer.parseInt(param3.trim())) != null) {
              if (param2.equals("A")) {
                clientes.get(param1).registrarAudiencia(series.get(Integer.parseInt(param3.trim())));
              } else {
                clientes.get(param1).adicionarNaLista(series.get(Integer.parseInt(param3.trim())));
              }
            } else {
              System.out.println("Série com id: " + param3 + " inexistente");
            }
          }
        }
        break;
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
      default:
        System.out.println("Tipo inválido");
        break;
    }
  }

  // ====================METODOS DE ADICIONAR INFORMAÇÃO NO
  // ARQUIVO=======================
  // =====================================================================================
  public void salvaCliente(String nome, String password, String username) {

    String conteudo = "\n" + nome + ";" + username + ";" + password;

    try (FileWriter writer = new FileWriter("POO_Series_2023/POO_Espectadores.csv", true)) {
      writer.write(conteudo);
      System.out.println("Dados adicionados ao arquivo com sucesso.");
    } catch (IOException e) {
      System.out.println("Ocorreu um erro ao adicionar os dados ao arquivo.");
      e.printStackTrace();
    }

  }

  // =====================================================================================
  public void salvaSerie(Serie serie) {

    // String nomeSerie=serie.getNome(), dataSerie=serie.getDataDeLancamento();

    boolean existia = false;
    int id = serie.getId();
    int idNovo = serie.getId();
    while (series.get(serie.getId()) != null) {
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
    } catch (IOException e) {
      System.out.println("Ocorreu um erro ao adicionar os dados ao arquivo.");
      e.printStackTrace();
    }
  }

  // =====================================================================================
  public void salvaFilme(Filme filme) {

    // String nomeSerie=serie.getNome(), dataSerie=serie.getDataDeLancamento();

    boolean existia = false;
    int id = filme.getId();
    int idNovo = filme.getId();
    while (filmes.get(filme.getId()) != null) {
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
    } catch (IOException e) {
      System.out.println("Ocorreu um erro ao adicionar os dados ao arquivo.");
      e.printStackTrace();
    }
  }
}

  // =======================================================================================
  // public void visualizarSerieDeMelhoresNotas(){
  // List<Conteudo> seriesList;
  // for(Serie s : this.series.values()){
  // seriesList.add(s);
  // }
  // List<Conteudo> melhoresSeries = seriesList.filter((s) -> s.get)

// MODIFICAR
  // public float pegarMedia(Conteudo c){
  //   float soma = c.getAvaliacoes().getData().stream()
  //     .forEach(a -> System.out.println(a));
  //   return (soma / c.getAvaliacoes().size());
  // }

//   public Cliente maisMidias(){
//     Cliente maior;
    
//     List<Cliente> clientesList = new List();
//     Cliente clientes = this.clientes.get(0);
//       for(Cliente c: this.clientes.values()){
//         if(c.getListaJaVista.length() + c.getListaDeFilmesParaVer.length()>maior){
//           maior=c;
//         }
//       }
//   }
  
//   public Cliente verClienteMaisAvaliacoes(){
//     Cliente clienteQueMaisAvaliou = this.clientes.get(0);
//     List<Cliente> clientesList = new LinkedList<Cliente>(this.clientes.values());
//     for(Cliente c : clientesList){
//       if(c.getAvaliacoesFeitas().size() > clienteQueMaisAvaliou.getAvaliacoesFeitas().size()){
//         clienteQueMaisAvaliou = c;
//       }
//     }

//     return clienteQueMaisAvaliou;
//   }

//   public float verPorcentagemClientes(){
//     Lista<Cliente> clienteComAvaliacoes = new Lista();
//     for(Cliente c : this.clientes.keySet()){
//       if(c.getAvaliacoesFeitas().size() > 15){
//         clienteComAvaliacoes.add(c);
//       }
//     }
//     float porcentagem = (clienteComAvalicoes.size() * 100) / this.clientes.size();
//     return porcentagem;
//   }
  
// }

// }

// }
