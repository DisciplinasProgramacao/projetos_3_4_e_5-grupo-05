public class Cliente {

    private String nome;
    private String senha;
    private String login;
    private Lista<Serie> listaParaVer;
    private Lista<Serie> listaJaVista;
    private Lista<Filme> listaDeFilmesParaVer;
    private Lista<Filme> listaDeFilmesJaVistos;

    public Cliente(String nome, String senha, String login) {
        this.nome = nome;
        this.senha = senha;
        this.login = login;
        this.listaParaVer= new Lista<>();
        this.listaJaVista= new Lista<>();
        this.listaDeFilmesParaVer = new Lista<>();
        this.listaDeFilmesJaVistos = new Lista<>();
    }

    public String getLogin(){
        return login;
    }

    public void setLogin(String login){
        this.login=login;
    }

    public String getNomeDeUsuario() {
        return nome;
    }

    public void setNomeDeUsuario(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Lista<Serie> getListaParaVer() {
        return listaParaVer;
    }

    public void setListaParaVer(Lista<Serie> listaParaVer) {
        this.listaParaVer = listaParaVer;
    }

    public Lista<Serie> getListaJaVista() {
        return listaJaVista;
    }

    public void setListaJaVista(Lista<Serie> listaJaVista) {
        this.listaJaVista = listaJaVista;
    }

    public Lista<Filme> getListaDeFilmesParaVer() {
        return this.listaDeFilmesParaVer;
    }

    public Lista<Filme> getListaDeFilmesJaVista() {
        return this.listaDeFilmesJaVistos;
    }

    public void setListaDeFilmesParaVer(Filme filme) {
        this.listaDeFilmesParaVer.add(filme);
    }

    public void setListaDeFilmesJaVista(Filme filme) {
        this.listaDeFilmesJaVistos.add(filme);
    }

    public void adicionarNaLista(Serie serie) {
        listaParaVer.add(serie);
    }

    public void adicionarNaListaJaVista(Serie serie) {
        listaJaVista.add(serie);
    }  
    public void adicionarFilmeNaLista(Filme filme) {
        this.listaDeFilmesParaVer.add(filme);
    }

    public void retirarDaLista(Serie serie) {
        listaParaVer.remove(serie);
    }



    public Lista<Serie> filtrarPorGenero(String genero){

        Lista<Serie> novaLista = new Lista<Serie>();
        Serie[] seriesVistas = new Serie[this.listaJaVista.size()];
        Serie[] seriesParaVer = new Serie[this.listaParaVer.size()];
        seriesVistas = this.listaJaVista.allElements(seriesVistas);
        for (Serie serie : seriesVistas) {
            if (serie.getGenero().equals(genero)) {
                novaLista.add(serie);
            }
        }

        seriesParaVer=this.listaParaVer.allElements(seriesParaVer);
        for (Serie serie : seriesParaVer) {
            if (serie.getGenero().equals(genero)) {
                novaLista.add(serie);
            }
        }

        return novaLista;
    }

    public Lista<Filme> filtrarFilmePorGenero(String genero){

        Lista<Filme> novaLista = new Lista<>();
        Filme[] filmesVistas = new Filme[this.listaDeFilmesJaVistos.size()];
        Filme[] filmesParaVer = new Filme[this.listaDeFilmesParaVer.size()];
        filmesVistas = this.listaDeFilmesJaVistos.allElements(filmesVistas);
        for (Filme filme : filmesVistas) {
            if (filme.getGenero().equals(genero)) {
                novaLista.add(filme);
            }
        }

        filmesParaVer=this.listaDeFilmesParaVer.allElements(filmesParaVer);
        for (Filme filme : filmesParaVer) {
            if (filme.getGenero().equals(genero)) {
                novaLista.add(filme);
            }
        }

        return novaLista;
    }


    public Lista<Serie> filtrarPorIdioma(String idioma){
        Lista<Serie> novaLista = new Lista<Serie>();
        Serie[] seriesVistas = new Serie[this.listaJaVista.size()];
        Serie[] seriesParaVer = new Serie[this.listaParaVer.size()];
        seriesVistas = this.listaJaVista.allElements(seriesVistas);
        for (Serie serie : seriesVistas) {
            if (serie.getIdioma().equals(idioma)) {
                novaLista.add(serie);
            }
        }
        seriesParaVer=this.listaParaVer.allElements(seriesParaVer);
        for (Serie serie : seriesParaVer) {
            if (serie.getIdioma().equals(idioma)) {
                novaLista.add(serie);
            }
        }

        return novaLista;
    }

    public Lista<Filme> filtrarFilmePorIdioma(String idioma){

        Lista<Filme> novaLista = new Lista<>();
        Filme[] filmesVistas = new Filme[this.listaDeFilmesJaVistos.size()];
        Filme[] filmesParaVer = new Filme[this.listaDeFilmesParaVer.size()];
        filmesVistas = this.listaDeFilmesJaVistos.allElements(filmesVistas);
        for (Filme filme : filmesVistas) {
            if (filme.getIdioma().equals(idioma)) {
                novaLista.add(filme);
            }
        }

        filmesParaVer=this.listaDeFilmesParaVer.allElements(filmesParaVer);
        for (Filme filme : filmesParaVer) {
            if (filme.getIdioma().equals(idioma)) {
                novaLista.add(filme);
            }
        }

        return novaLista;
    }

    public Lista<Serie> filtrarPorQtdEpisodios(int Qtd) {
        Lista<Serie> novaLista = new Lista<Serie>();
        Serie[] seriesVistas = new Serie[this.listaJaVista.size()];
        Serie[] seriesParaVer = new Serie[this.listaParaVer.size()];
        this.listaJaVista.allElements(seriesVistas);
        for (int i = 0; i < seriesVistas.length; i++) {
            if (seriesVistas[i].getQuantidadeEpisodios() == Qtd) {
                novaLista.add(seriesVistas[i]);
            }
        }
        this.listaParaVer.allElements(seriesParaVer);
        for (int i = 0; i < seriesParaVer.length; i++) {
            if (seriesParaVer[i].getQuantidadeEpisodios() == Qtd) {
                novaLista.add(seriesParaVer[i]);
            }
        }
        return novaLista;
    }

    public Lista<Filme> filtrarFilmePorDuracao(int duracao){
        int duracaoEmSegundos = duracao*60;
        Lista<Filme> novaLista = new Lista<>();
        Filme[] filmesVistas = new Filme[this.listaDeFilmesJaVistos.size()];
        Filme[] filmesParaVer = new Filme[this.listaDeFilmesParaVer.size()];
        filmesVistas = this.listaDeFilmesJaVistos.allElements(filmesVistas);
        for (Filme filme : filmesVistas) {
            if (filme.getDuracao() == duracaoEmSegundos) {
                novaLista.add(filme);
            }
        }

        filmesParaVer=this.listaDeFilmesParaVer.allElements(filmesParaVer);
        for (Filme filme : filmesParaVer) {
            if (filme.getDuracao() == duracaoEmSegundos) {
                novaLista.add(filme);
            }
        }

        return novaLista;
    }


    public void registrarAudiencia(Serie serie) {
        serie.registrarAudiencia();
        this.listaParaVer.remove(serie);
        this.listaJaVista.add(serie);
    }

    public void assitirFilme(Filme filme) {
        filme.registrarAudiencia();
        this.listaDeFilmesParaVer.remove(filme);
        this.listaDeFilmesJaVistos.add(filme);
    }

    public void registrarAudiencia(Serie serie, int nota){
        serie.registrarAudiencia();
        serie.setNota(nota);
        this.listaParaVer.remove(serie);
        this.listaJaVista.add(serie);
    }

}

