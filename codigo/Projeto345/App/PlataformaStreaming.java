import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class PlataformaStreaming {
  private String nome;
  public Map<Integer, Serie> series;
  public Map<Integer, Filme> filmes;
  public Map<String, Cliente> clientes;
  private Cliente clienteAtual;

  public PlataformaStreaming(String nome) {
    this.nome = nome;
    this.series = new HashMap<Integer, Serie>();
    this.clientes = new HashMap<String, Cliente>();
    this.filmes = new HashMap<Integer, Filme>();
    this.clienteAtual = null;
  }

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
    int idNovo = series.size();
    while (series.get(serie.getId()) != null) {
      existia = true;
      serie.setId(idNovo++);
    }
    if (existia) {
      System.out.println("Já existia uma série com o id " + id + " ele será mudado para: " + serie.getId());
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
          if (vez != 0) {
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

}
