package PTBR.BibliotecaOSPastaNaoFinalizado;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class BibliotecaOS {
    // atributos gerais
    static Scanner scanner = new Scanner(System.in);
    static String nome = "", autor = "", editora = "", CDD = "", ISBN = "", secao = "";
    static String ISSN = "";
    static int edicao = 0, anoPublicacao = 0, prateleira = 0, opcao0 = 0, opcao2 = 0, opcao2_b = 0;
    static ArrayList<Livro> listaLivros = new ArrayList<Livro>();
    static ArrayList<Revista> listaRevistas = new ArrayList<Revista>();
    //Erros
    static String nenhumItemEncontradoString = "ERRO: Nenhum item encontrado!";
    static String opcaoInvalidaString = "ERRO: Opção inválida!";
    static String listaCheiaString = "ERRO: A lista está cheia!";
    static String listaVaziaString = "ERRO: A lista está vazia!";

    public static void main(String[] args) {

        /*
         * =================================================
         * Github: delunatriestocode
         * Linkedin: in/gabrielsilveiradeluna
         * =================================================
         */

        listaLivros.add(new Livro("O Pequeno Principe", "Antoine de Saint-Exupéry", "Nova Fronteira", "843",
                "978-8520930144", 1, 2016, "Infantil, Fábula, Ficção", 10));

        listaLivros.add(new Livro("Harry Potter e a Pedra Filosofal", "J. K. Rowlling", "Rocco", "239",
                "978-8532530783", 1, 2017, "Infantil, Fantasia, Aventura, Ficção", 7));

        listaLivros.add(new Livro("Biblia Sagrada", "Deus", "Paulinas", "200", "978-8535611748", 1, 2005, "Religião", 4));

        listaLivros.add(new Livro("Heartstopper", "Alice Oseman e Guilherme Miranda", "Seguinte", "741.5",
                "978-8555341618", 1, 2021, "Drama, Romance, LGBT, Comédia", 17));

        listaLivros.add(new Livro("Percy Jackson: O Ladrão de Raios", "Rick Riordan", "Intrínseca", "028.5",
                "978-8580575392", 1, 2014, "Ação, Aventura, Fantasia", 4));

        listaLivros.add(new Livro("99 Tons de Cinza", "E. L. James", "Intrínseca", "123", "978-8580572186", 2, 2012,
                "Erótico", 8));

        listaLivros.add(new Livro("50 Tons de Cinza", "E. L. James", "Intrínseca", "123", "978-8580572186", 2, 2012,
                "Erótico", 8));

        listaLivros.add(new Livro("1984", "George Orwell", "Companhia das Letras", "123", "978-8535914849", 1, 2009,
                "Ficção Distópica, Sci-fi, Ficção Política", 3));

        // Revistas
        listaRevistas.add(new Revista("Veja", "Roberto Civita", "Abril", "123", "978-8523203245", 3000, 2021,
                "política, cultura e econômia", 7, "0100-7122"));

        listaRevistas.add(new Revista("Xeja", "Roberto Civita", "Abril", "123", "978-8523203245", 3000, 2021,
                "política, cultura e econômia", 7, "0100-7122"));

        listaRevistas.add(new Revista("Geja", "Roberto Civita", "Abril", "123", "978-8523203245", 3000, 2021,
                "política, cultura e econômia", 7, "0100-7122"));

        listaRevistas.add(new Revista("Beja", "Roberto Civita", "Abril", "123", "978-8523203245", 3000, 2021,
                "política, cultura e econômia", 7, "0100-7122"));
        // Navegação do App
        do {
            switch (opcao0) {
                case 0:
                    // Intro
                    System.out.println("\n============================\n\tBibliotecaOS\n\t    v1.0\n============================");
                    System.out.println("\nBem-vindo(a), usuário(a)! Insira o número correspondente à opção desejada:");
                    System.out.println("\n[1] Cadastrar \n[2] Filtrar \n[3] Listar \n[4] Espaço livre\n[5] Créditos\n[6] Sair\n");
                    // Input
                    opcao0 = verificarInt("> ");
                    break;
                case 1:
                    // Cadastrar livro/revista
                    cadastrarLivroRevista();
                    break;
                case 2:
                    //Filtrar livro/revista
                    filtrarLivroRevista();
                    break;
                case 3:
                    // Listar livro/revista
                    listarLivroRevista();
                    break;
                case 4:
                    // Gerenciamento de Espaço
                    gerenciarEspacoLivrosRevistas();
                    break;
                case 5:
                    //Abrir página do git (se possível)
                    abrirPagWeb("https://github.com/delunatriestocode");
                    opcao0 = 0;
                case 6:
                    // Se o usuário tiver escolhido sair
                    break;
                default:
                    // Se o usuário tiver escolhido um número abaixo de 0 ou maior que 7
                    System.out.println(opcaoInvalidaString);
                    esperar(1000);
                    opcao0 = 0;
            }
            // Se o usuário tiver escolhido sair
            if (opcao0 == 6) {
                System.out.println("\n===========================\n\tTchauzinho!\n===========================\n");
                break;
            }
        } while (true);
        // Fechar scanner
        scanner.close();
    }

    // Método que pausa a aplicação por x milisegundos (1000 ms = 1 s)
    public static void esperar(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    //Inputs de int
    public static int verificarInt(String msg) {
        int atributo = 0;
        do {                                                                                                                                                          
            try {
                System.out.print(msg);
                atributo = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("ERRO: Apenas números, por favor.");
                scanner.next();
            }
        } while (true);
        scanner.nextLine(); 
        return atributo;
    }

    //Inputs de double
    public static double verificarDouble(String msg) {
        double atributo = 0;                                                                                                                                                        
        do {       
            try {
                System.out.print(msg);
                atributo = scanner.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("ERRO: Apenas números, por favor.");
                scanner.next();
            }
        } while (true);
        scanner.nextLine(); 
        return atributo;
    }

    //Input de Strings
    public static String verificarString(String msg) {
        String atributo = "";

        do {
            System.out.print(msg);
            atributo = scanner.nextLine();
            if (!atributo.trim().isEmpty()) {
                break;
            }
        } while (true);
        return atributo;
    }

    // Método que checa se o array de livros ta organizado
    public static boolean listaLivrosEstaOrganizada(ArrayList<Livro> lista) {
        for (int k = 0; k < lista.size() - 1; k++) {
            if (lista.get(k).getNome().toUpperCase().compareTo(lista.get(k+1).getNome().toUpperCase()) > 0) {
                return false;
            }
        }
        return true;
    }

    // Método que checa se o array de revistas ta organizado
    public static boolean listaRevistasEstaOrganizada(ArrayList<Revista> lista) {
        for (int k = 0; k < lista.size() - 1; k++) {
            if (lista.get(k).getNome().toUpperCase().compareTo(lista.get(k+1).getNome().toUpperCase()) > 0) {
                return false;
            }
        }
        return true;
    }

    // Método que abre uma página da web (se possível)
    public static void abrirPagWeb(String link) {
        try {
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(new URI(link));
            } else {
                System.out.println("========================\n\tCréditos\n========================\n");
                System.out.println("Criado por TheLuna\nGithub: delunatriestocode\n");
            }
        } catch (IOException e) {
            System.out.println(e);
        } catch (URISyntaxException e) {
            System.out.println(e);
        }
    }

    // Método que cadastra livro/revista
    public static void cadastrarLivroRevista() {
        try {
            do {
                System.out.println("Livro ou revista?\n[1] Livro\n[2] Revista\n[3] Sair\n");
                int opcao1 = verificarInt("> ");
                if (opcao1 == 1) {
                    if (listaLivros.size() == 1000) {
                        System.out.println(listaCheiaString);
                        esperar(1500);
                        opcao0 = 0;
                    } else {
                        System.out.println("\n===================================\n\tCadastro de Livros\n===================================\n");
                    }
                } else if (opcao1 == 2) {
                    if (listaRevistas.size() == 1000) {
                        System.out.println(listaCheiaString);
                        esperar(1500);
                        opcao0 = 0;
                    } else {
                        System.out.println("\n===================================\n\tCadastro de Revistas\n===================================\n");
                    }
                } else if (opcao1 == 3) {
                    //SAIR
                    opcao0 = 0;
                    break;
                } else {
                    System.out.println(opcaoInvalidaString);
                } 
                        
                // Nome
                nome = verificarString("Insira o nome: ");
                // Autor
                autor = verificarString("Insira o autor: ");
                // Editora
                editora = verificarString("Insira a editora: ");
                // CDD
                CDD = verificarString("Insira o CDD: ");
                // ISBN
                ISBN = verificarString("Insira o ISBN: ");
                //ISSN (Revista)
                if (opcao1 == 2) {
                    ISSN = verificarString("Insira o ISSN: ");
                }
                // Edição
                edicao = verificarInt("Insira a edição: ");
                // Ano de Publicação
                anoPublicacao = verificarInt("Insira o ano de publicação: ");
                // Seção
                secao = verificarString("Insira o nome da seção onde está o livro/a revista: ");
                // Prateleira
                prateleira = verificarInt("Insira o número da prateleira onde está o livro/a revista: ");
                        
                // Adicionar à lista
                if (opcao1 == 1) {
                    listaLivros.add(new Livro(nome, autor, editora, CDD, ISBN, edicao, anoPublicacao, secao, prateleira));
                    opcao0 = 0;
                    break;
                } else if (opcao1 == 2) {
                    listaRevistas.add(new Revista(nome, autor, editora, CDD, ISBN, edicao, anoPublicacao, secao, prateleira, ISSN));
                    opcao0 = 0;
                    break;
                }
            } while (true); 
        }
        catch (Throwable e) {
            System.out.println("Um erro foi encontrado! Contate o suporte! \nLinha: " + e.getStackTrace()[0].getLineNumber() + "\nTipo de Erro: " + e.getStackTrace()[0].getClass().getName());
        }        
    }

    //Filtrar livro/revista
    public static void filtrarLivroRevista() {
        // Filtrar Livro/Revista
        try {
            do {
                System.out.println("Livro ou revista?\n[1] Livro\n[2] Revista\n[3] Sair\n");
                opcao2 = verificarInt("> ");
                if (opcao2 == 1) {
                    // Filtrar livro
                    if (listaLivros.size() == 0) {
                        System.out.println(listaVaziaString);
                    } else {
                        System.out.println("\n=============================\n\tFiltrar Livros\n=============================\n\n[1] - Nome\n[2] - Autor\n[3] - Editora\n[4] - CDD\n[5] - ISBN\n[6] - Edição\n[7] - Ano de Publicação\n[8] - Seção\n[9] - Número da Prateleira\n[10] - Sair\n");
                    }

                } opcao2 == 2 {
                    if (listaRevistas.size() == 0) {
                        System.out.println(listaVaziaString);
                    } else {
                        System.out.println("\n=============================\n\tFiltrar Revistas\n=============================\n\n[1] - Nome\n[2] - Autor\n[3] - Editora\n[4] - CDD\n[5] - ISBN\n[6] - Edição\n[7] - Ano de Publicação\n[8] - Seção\n[9] - Número da Prateleira\n[10] - Sair\n");
                    }
                    "\n=============================\n\tFiltrar Revistas\n=============================\n\n[1] - Nome\n[2] - Autor\n[3] - Editora\n[4] - CDD\n[5] - ISBN\n[6] - Edição\n[7] - Ano de Publicação\n[8] - Seção\n[9] - Número da Prateleira\n[10] - Sair\n");
                }
                    do {
                        int atributoInt = 0;
                        ArrayList<Livro> listaFiltrada = new ArrayList<Livro>();
                        String atributoString = "";
    
                        opcao2_b = verificarInt("\n> ");
                        // FILTRAR POR NOME
                        if (opcao2_b == 1) {
                            atributoString = verificarString("Insira o nome do livro: ");
                            atributoString = atributoString.toUpperCase().replace(" ", "");
                            for (int i = 0; i < listaLivros.size(); i++) {
                                if (listaLivros.get(i).getNome().toUpperCase().replace(" ", "").contains(atributoString)) {
                                    listaFiltrada.add(listaLivros.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("%d - %s\n", listaLivros.indexOf(listaFiltrada.get(j)),
                                            listaFiltrada.get(j).getNome());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                            // FILTRAR POR AUTOR
                        } else if (opcao2_b == 2) {
                            atributoString = verificarString("Insira o nome do autor: ");
                            atributoString = atributoString.toUpperCase().replace(" ", "");
                            for (int i = 0; i < listaLivros.size(); i++) {
                                if (listaLivros.get(i).getAutor().toUpperCase().replace(" ", "")
                                        .contains(atributoString)) {
                                    listaFiltrada.add(listaLivros.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("\n%d - %s\n", listaLivros.indexOf(listaFiltrada.get(j)),
                                            listaFiltrada.get(j).getAutor());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                            // FILTRAR POR EDITORA
                        } else if (opcao2_b == 3) {
                            atributoString = verificarString("Insira o nome da editora: ");
                            atributoString = atributoString.toUpperCase().replace(" ", "");
                            for (int i = 0; i < listaLivros.size(); i++) {
                                if (listaLivros.get(i).getEditora().toUpperCase().replace(" ", "")
                                        .contains(atributoString)) {
                                    listaFiltrada.add(listaLivros.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("\n%d - %s\n", listaLivros.indexOf(listaFiltrada.get(j)),
                                            listaFiltrada.get(j).getEditora());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                            // FILTRAR POR CDD
                        } else if (opcao2_b == 4) {
                            atributoString = verificarString("Insira o CDD: ");
                            atributoString = atributoString.toUpperCase().replace(" ", "");
                            for (int i = 0; i < listaLivros.size(); i++) {
                                if (listaLivros.get(i).getCDD().toUpperCase().replace(" ", "")
                                        .contains(atributoString)) {
                                    listaFiltrada.add(listaLivros.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("\n%d - %s\n", listaLivros.indexOf(listaFiltrada.get(j)),
                                            listaFiltrada.get(j).getNome());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                            // FILTRAR POR ISBN
                        } else if (opcao2_b == 5) {
                            atributoString = verificarString("Insira o ISBN: ");
                            atributoString = atributoString.toUpperCase().replace(" ", "");
                            for (int i = 0; i < listaLivros.size(); i++) {
                                if (listaLivros.get(i).getISBN().toUpperCase().replace(" ", "")
                                        .contains(atributoString)) {
                                    listaFiltrada.add(listaLivros.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("\n%d - %s\n", listaLivros.indexOf(listaFiltrada.get(j)),
                                            listaFiltrada.get(j).getNome());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                            // FILTRAR POR EDIÇÃO
                        } else if (opcao2_b == 6) {
                            atributoInt = verificarInt("Insira a edição: ");
                            for (int i = 0; i < listaLivros.size(); i++) {
                                if (listaLivros.get(i).getEdicao() == atributoInt) {
                                    listaFiltrada.add(listaLivros.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("\n%d - %s\n", listaLivros.indexOf(listaFiltrada.get(j)),
                                            listaFiltrada.get(j).getNome());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                            // FILTRAR POR ANO DE PUBLICAÇÃO
                        } else if (opcao2_b == 7) {
                            atributoInt = verificarInt("Insira o ano: ");
                            for (int i = 0; i < listaLivros.size(); i++) {
                                if (listaLivros.get(i).getAnoPublicacao() == atributoInt) {
                                    listaFiltrada.add(listaLivros.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("\n%d - %s\n", listaLivros.indexOf(listaFiltrada.get(j)),
                                            listaFiltrada.get(j).getNome());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                            // FILTRAR POR SEÇÃO
                        } else if (opcao2_b == 8) {
                            atributoString = verificarString("Insira a seção: ");
                            atributoString = atributoString.toUpperCase().replace(" ", "");
                            for (int i = 0; i < listaLivros.size(); i++) {
                                if (listaLivros.get(i).getSecao().toUpperCase().replace(" ", "")
                                        .contains(atributoString)) {
                                    listaFiltrada.add(listaLivros.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("\n%d - %s\n", listaLivros.indexOf(listaFiltrada.get(j)),
                                            listaFiltrada.get(j).getNome());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                            // FILTRAR POR NÚMERO DE PRATELEIRA
                        } else if (opcao2_b == 9) {
                            atributoInt = verificarInt("Insira o número da prateleira: ");
                            for (int i = 0; i < listaLivros.size(); i++) {
                                if (listaLivros.get(i).getPrateleira() == atributoInt) {
                                    listaFiltrada.add(listaLivros.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("\n%d - %s\n", listaLivros.indexOf(listaFiltrada.get(j)),
                                            listaFiltrada.get(j).getNome());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                            // SAIR
                        } else if (opcao2_b == 10) {
                            opcao0 = 0;
                            break;
                        } else {
                            System.out.println(opcaoInvalidaString);
                        }
                    } while (true);
                } else if (opcao2 == 2) {
                    // Filtrar Revistas
                    do {
                        int atributoInt = 0;
                        ArrayList<Revista> listaFiltradaRevista = new ArrayList<Revista>();
                        String atributoString = "";
    
                        System.out.println(
                                "\n=============================\n\tFiltrar Revistas\n=============================\n\n[1] - Nome\n[2] - Autor\n[3] - Editora\n[4] - CDD\n[5] - ISBN\n[6] - Edição\n[7] - Ano de Publicação\n[8] - Seção\n[9] - Número da Prateleira\n[10] - Sair\n");
                        opcao2_b = verificarInt("\n> ");
                        // FILTRAR POR NOME
                        if (opcao2_b == 1) {
                            atributoString = verificarString("Insira o nome da revista: ");
                            atributoString = atributoString.toUpperCase().replace(" ", "");
                            for (int i = 0; i < listaRevistas.size(); i++) {
                                if (listaRevistas.get(i).getNome().toUpperCase().replace(" ", "")
                                        .contains(atributoString)) {
                                    listaFiltradaRevista.add(listaRevistas.get(i));
                                }
                            }
                            if (listaFiltradaRevista.size() == 0) {
                                System.out.println(nenhumItemEncontradoString);
                                listaFiltradaRevista.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltradaRevista.size(); j++) {
                                    System.out.printf("%d - %s\n",
                                            listaRevistas.indexOf(listaFiltradaRevista.get(j)),
                                            listaFiltradaRevista.get(j).getNome());
                                }
                                listaFiltradaRevista.clear();
                                esperar(1500);
                            }
                            // FILTRAR POR AUTOR
                        } else if (opcao2_b == 2) {
                            atributoString = verificarString("Insira o nome do autor: ");
                            atributoString = atributoString.toUpperCase().replace(" ", "");
                            for (int i = 0; i < listaRevistas.size(); i++) {
                                if (listaRevistas.get(i).getAutor().toUpperCase().replace(" ", "")
                                        .contains(atributoString)) {
                                    listaFiltradaRevista.add(listaRevistas.get(i));
                                }
                            }
                            if (listaFiltradaRevista.size() == 0) {
                                System.out.println(nenhumItemEncontradoString);
                                listaFiltradaRevista.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltradaRevista.size(); j++) {
                                    System.out.printf("\n%d - %s\n",
                                            listaRevistas.indexOf(listaFiltradaRevista.get(j)),
                                            listaFiltradaRevista.get(j).getAutor());
                                }
                                listaFiltradaRevista.clear();
                                esperar(1500);
                            }
                            // FILTRAR POR EDITORA
                        } else if (opcao2_b == 3) {
                            atributoString = verificarString("Insira o nome da editora: ");
                            atributoString = atributoString.toUpperCase().replace(" ", "");
                            for (int i = 0; i < listaRevistas.size(); i++) {
                                if (listaRevistas.get(i).getEditora().toUpperCase().replace(" ", "")
                                        .contains(atributoString)) {
                                    listaFiltradaRevista.add(listaRevistas.get(i));
                                }
                            }
                            if (listaFiltradaRevista.size() == 0) {
                                System.out.println(nenhumItemEncontradoString);
                                listaFiltradaRevista.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltradaRevista.size(); j++) {
                                    System.out.printf("\n%d - %s\n",
                                            listaRevistas.indexOf(listaFiltradaRevista.get(j)),
                                            listaFiltradaRevista.get(j).getEditora());
                                }
                                listaFiltradaRevista.clear();
                                esperar(1500);
                            }
                            // FILTRAR POR CDD
                        } else if (opcao2_b == 4) {
                            atributoString = verificarString("Insira o CDD: ");
                            atributoString = atributoString.toUpperCase().replace(" ", "");
                            for (int i = 0; i < listaRevistas.size(); i++) {
                                if (listaRevistas.get(i).getCDD().toUpperCase().replace(" ", "")
                                        .contains(atributoString)) {
                                    listaFiltradaRevista.add(listaRevistas.get(i));
                                }
                            }
                            if (listaFiltradaRevista.size() == 0) {
                                System.out.println(nenhumItemEncontradoString);
                                listaFiltradaRevista.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltradaRevista.size(); j++) {
                                    System.out.printf("\n%d - %s\n",
                                            listaRevistas.indexOf(listaFiltradaRevista.get(j)),
                                            listaFiltradaRevista.get(j).getNome());
                                }
                                listaFiltradaRevista.clear();
                                esperar(1500);
                            }
                            // FILTRAR POR ISBN
                        } else if (opcao2_b == 5) {
                            atributoString = verificarString("Insira o ISBN: ");
                            atributoString = atributoString.toUpperCase().replace(" ", "");
                            for (int i = 0; i < listaRevistas.size(); i++) {
                                if (listaRevistas.get(i).getISBN().toUpperCase().replace(" ", "")
                                        .contains(atributoString)) {
                                    listaFiltradaRevista.add(listaRevistas.get(i));
                                }
                            }
                            if (listaFiltradaRevista.size() == 0) {
                                System.out.println(nenhumItemEncontradoString);
                                listaFiltradaRevista.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltradaRevista.size(); j++) {
                                    System.out.printf("\n%d - %s\n",
                                            listaRevistas.indexOf(listaFiltradaRevista.get(j)),
                                            listaFiltradaRevista.get(j).getNome());
                                }
                                listaFiltradaRevista.clear();
                                esperar(1500);
                            }
                            // FILTRAR POR EDIÇÃO
                        } else if (opcao2_b == 6) {
                            atributoInt = verificarInt("Insira a edição: ");
                            for (int i = 0; i < listaRevistas.size(); i++) {
                                if (listaRevistas.get(i).getEdicao() == atributoInt) {
                                    listaFiltradaRevista.add(listaRevistas.get(i));
                                }
                            }
                            if (listaFiltradaRevista.size() == 0) {
                                System.out.println(nenhumItemEncontradoString);
                                listaFiltradaRevista.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltradaRevista.size(); j++) {
                                    System.out.printf("\n%d - %s\n",
                                            listaRevistas.indexOf(listaFiltradaRevista.get(j)),
                                            listaFiltradaRevista.get(j).getNome());
                                }
                                listaFiltradaRevista.clear();
                                esperar(1500);
                            }
                            // FILTRAR POR ANO DE PUBLICAÇÃO
                        } else if (opcao2_b == 7) {
                            atributoInt = verificarInt("Insira o ano: ");
                            for (int i = 0; i < listaRevistas.size(); i++) {
                                if (listaRevistas.get(i).getAnoPublicacao() == atributoInt) {
                                    listaFiltradaRevista.add(listaRevistas.get(i));
                                }
                            }
                            if (listaFiltradaRevista.size() == 0) {
                                System.out.println(nenhumItemEncontradoString);
                                listaFiltradaRevista.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltradaRevista.size(); j++) {
                                    System.out.printf("\n%d - %s\n",
                                            listaRevistas.indexOf(listaFiltradaRevista.get(j)),
                                            listaFiltradaRevista.get(j).getNome());
                                }
                                listaFiltradaRevista.clear();
                                esperar(1500);
                            }
                            // FILTRAR POR SEÇÃO
                        } else if (opcao2_b == 8) {
                            atributoString = verificarString("Insira a seção: ");
                            atributoString = atributoString.toUpperCase().replace(" ", "");
                            for (int i = 0; i < listaRevistas.size(); i++) {
                                if (listaRevistas.get(i).getSecao().toUpperCase().replace(" ", "")
                                        .contains(atributoString)) {
                                    listaFiltradaRevista.add(listaRevistas.get(i));
                                }
                            }
                            if (listaFiltradaRevista.size() == 0) {
                                System.out.println(nenhumItemEncontradoString);
                                listaFiltradaRevista.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltradaRevista.size(); j++) {
                                    System.out.printf("\n%d - %s\n",
                                            listaRevistas.indexOf(listaFiltradaRevista.get(j)),
                                            listaFiltradaRevista.get(j).getNome());
                                }
                                listaFiltradaRevista.clear();
                                esperar(1500);
                            }
                            // FILTRAR POR NÚMERO DE PRATELEIRA
                        } else if (opcao2_b == 9) {
                            atributoInt = verificarInt("Insira o número da prateleira: ");
                            for (int i = 0; i < listaRevistas.size(); i++) {
                                if (listaRevistas.get(i).getPrateleira() == atributoInt) {
                                    listaFiltradaRevista.add(listaRevistas.get(i));
                                }
                            }
                            if (listaFiltradaRevista.size() == 0) {
                                System.out.println(nenhumItemEncontradoString);
                                listaFiltradaRevista.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltradaRevista.size(); j++) {
                                    System.out.printf("\n%d - %s\n",
                                            listaRevistas.indexOf(listaFiltradaRevista.get(j)),
                                            listaFiltradaRevista.get(j).getNome());
                                }
                                listaFiltradaRevista.clear();
                                esperar(1500);
                            }
                            // SAIR
                        } else if (opcao2_b == 10) {
                            opcao0 = 0;
                            break;
                        } else {
                            System.out.println(opcaoInvalidaString);
                        }
                    } while (true);
                } else if (opcao2 == 3) {
                    // sair
                } else {
                    System.out.println(opcaoInvalidaString);
                }
                if (opcao2 == 3 || opcao2_b == 10) {
                    opcao0 = 0;
                    break;
                }
            } while (true);
        }
        catch (Throwable e) {
            System.out.println("Um erro foi encontrado! Contate o suporte! \nLinha: " + e.getStackTrace()[0].getLineNumber() + "\nTipo de Erro: " + e.getStackTrace()[0].getClass().getName());
        }
    }

    //LISTAR LIVRO/REVISTA
    public static void listarLivroRevista() {
        int opcao3 = 0;
        String opcao3_b = "";
        try {
            do {
                System.out.println("Livro ou revista?\n[1] Livro\n[2] Revista\n[3] Sair\n");
                opcao3 = verificarInt("> ");
                // LIVRO
                if (opcao3 == 1) {
                    if (listaLivros.size() == 0) {
                        //se a lista de livro estiver vazia
                        System.out.println(listaVaziaString);
                        esperar(1500);
                        opcao0 = 0;
                    } else {
                        int minIndex = 0;
                        int maxIndex = 4;
                        int minPagina = (maxIndex + 1) / 5;
                        int maxPagina = Math.round(listaLivros.size() / 5) > 0 ? Math.round(listaLivros.size() / 5) + 1 : 1;
                        int index = 0;
    
                        do {
                            System.out.println("\n===============================\n\tLista de Livros\n===============================\n");
                            // exibir página atual + total de páginas
                            System.out.printf("Página %d/%d:\n\n", minPagina, maxPagina);
                            // exibir primeira página
                            for (int i = minIndex; i <= maxIndex; i++) {
                                try {
                                    System.out.printf("%d - %s\n", i, listaLivros.get(i).getNome());
                                } catch (IndexOutOfBoundsException e) {
                                    break;
                                }
                            }
                            // opções de input + input
                            System.out.println("\n[I] - Acessar as informações de um livro pelo ID.\n[A] - Página anterior\n[D] - Próxima página\n[P] - Primeira página\n[U] - Última página\n[E] - Excluir livro da lista pelo ID\n[O] - Organizar lista alfabéticamente\n[S] - Sair");
                            opcao3_b = verificarString("\n> ").toUpperCase().trim();
                            // ACESSAR INFORMAÇÕES PELO ID
                            if (opcao3_b.equals("I")) { 
                                index = verificarInt("Insira o ID do livro no qual você deseja acessar as informações: ");
                                System.out.printf("\nID: %d\nNome: %s\nAutor: %s\nEditora: %s\nCDD: %s\nISBN: %s\nEdição: %d°\nAno de Publicação: %d\nSeção: %s\nPrateleira: %d\n", index, 
                                                                                                                                                                                            listaLivros.get(index).getNome(),
                                                                                                                                                                                            listaLivros.get(index).getAutor(),
                                                                                                                                                                                            listaLivros.get(index).getEditora(), listaLivros.get(index).getCDD(),
                                                                                                                                                                                            listaLivros.get(index).getISBN(), listaLivros.get(index).getEdicao(),
                                                                                                                                                                                            listaLivros.get(index).getAnoPublicacao(),
                                                                                                                                                                                            listaLivros.get(index).getSecao(),
                                                                                                                                                                                            listaLivros.get(index).getPrateleira());
                                
                                esperar(3000);
                            } else if (opcao3_b.equals("D")) {
                                // PRÓXIMA PÁGINA
                                if (listaLivros.size() > maxIndex + 1) {
                                    minIndex += 5; 
                                    maxIndex += 5;
                                } else {
                                    System.out.println("ERRO: Não foi possível ir para a próxima página."); esperar(1500);
                                }
                            } else if (opcao3_b.equals("A")) {
                                // PÁGINA ANTERIOR
                                if (minIndex > 0) {
                                    minIndex -= 5;
                                    maxIndex -= 5;
                                } else {
                                    System.out.println("ERRO: Não foi possível ir para a página anterior."); esperar(1500);
                                }
                            } else if (opcao3_b.equals("P")) {
                                // PRIMEIRA PÁGINA
                                minIndex = 0;
                                maxIndex = 4;
                            } else if (opcao3_b.equals("U")) {
                                // ÚLTIMA PÁGINA
                                for (int i = 1; (i * 5) < listaLivros.size(); i++) {
                                    minIndex = 5 * i;
                                    maxIndex = 5 * (i + 1);
                                }
                            } else if (opcao3_b.equals("E")) {
                                // EXCLUIR LIVRO DA LISTA
                                index = verificarInt("Insira o ID do livro no qual você deseja remover da lista: ");
                                listaLivros.remove(index);
                            } else if (opcao3_b.equals("O")) {
                                // ORGANIZAR LISTA
                                do {
                                    for (int i = 0; i < listaLivros.size() - 1; i++) {
                                        Livro item1 = listaLivros.get(i);
                                        Livro item2 = listaLivros.get(i + 1);
                                        Livro temp = item1;
                                        
                                        if (item1.getNome().toUpperCase().compareTo(item2.getNome().toUpperCase()) > 0) {
                                            item1 = item2;
                                            item2 = temp;
                                            listaLivros.set(i, item1);
                                            listaLivros.set(i + 1, item2);
                                        }
                                    }
                                } while (!listaLivrosEstaOrganizada(listaLivros));
                            } else if (opcao3_b.equals("S")) {
                                // SAIR
                                break;
                            } else {
                                // VALOR INVÁLIDO
                                System.out.println(opcaoInvalidaString);
                            }
                        } while (true);
                    }
                    opcao0 = 0;
                } else if (opcao3 == 2) {
                    // REVISTA
                    if (listaRevistas.size() == 0) {
                        // se a lista de revistas estiver vazia
                        System.out.println(listaVaziaString);
                        esperar(1500);
                        opcao0 = 0;
                    } else {
                        int minIndex = 0;
                        int maxIndex = 4;
                        int minPage = (maxIndex + 1) / 5;
                        int maxPage = Math.round(listaRevistas.size() / 5) > 0 ? Math.round(listaRevistas.size() / 5) : 1;
                        int index = 0;
                        do {
                            System.out.println("\n===============================\n\tLista de Revistas\n===============================\n");
                            //exibir página atual + total de páginas
                            System.out.printf("Página %d/%d:\n\n", minPage, maxPage);
                            //primeira página da lista
                            for (int i = minIndex; i <= maxIndex; i++) {
                                try {
                                    System.out.printf("%d - %s\n", i, listaRevistas.get(i).getNome());
                                } catch (IndexOutOfBoundsException e) {
                                    break;
                                }
                            }
                            // opções de input + input do usuário
                            System.out.println("\n[I] - Acessar as informações de uma revista pelo ID.\n[A] - Página anterior\n[D] - Próxima página\n[P] - Primeira página\n[U] - Última página\n[E] - Excluir revista da lista pelo ID\n[O] - Organizar lista alfabéticamente\n[S] - Sair");
                            opcao3_b = verificarString("\n> ").toUpperCase().trim();
                            if (opcao3_b.equals("I")) {
                                index = verificarInt("Insira o ID da revista no qual você deseja acessar as informações: ");
                                // EXIBIR INFORMAÇÕES PELO ID
                                System.out.printf(
                                        "\nID: %d\nNome: %s\nAutor: %s\nEditora: %s\nCDD: %s\nISBN: %s\nEdição: %d°\nAno de Publicação: %d\nSeção: %s\nPrateleira: %d\n", index, 
                                                                                                                                                                                    listaRevistas.get(index).getNome(),
                                                                                                                                                                                    listaRevistas.get(index).getAutor(),
                                                                                                                                                                                    listaRevistas.get(index).getEditora(),
                                                                                                                                                                                    listaRevistas.get(index).getCDD(),
                                                                                                                                                                                    listaRevistas.get(index).getISBN(),
                                                                                                                                                                                    listaRevistas.get(index).getEdicao(),
                                                                                                                                                                                    listaRevistas.get(index).getAnoPublicacao(),
                                                                                                                                                                                    listaRevistas.get(index).getSecao(),
                                                                                                                                                                                    listaRevistas.get(index).getPrateleira());
                                // limpar buffer
                                scanner.nextLine(); 
                                esperar(3000);
                            } else if (opcao3_b.equals("D")) {
                                // PRÓXIMA PÁGINA
                                if (listaRevistas.size() > maxIndex + 1) {
                                    minIndex += 5;
                                    maxIndex += 5;
                                } else {
                                    System.out.println("ERRO: Não foi possível ir para a próxima página."); esperar(1500);
                                }
                            } else if (opcao3_b.equals("A")) {
                                // PÁGINA ANTERIOR
                                if (minIndex > 0) {
                                    minIndex -= 5;
                                    maxIndex -= 5;
                                } else {
                                    System.out.println("ERRO: Não foi possível ir para a página anterior."); esperar(1500);
                                }
                            } else if (opcao3_b.equals("P")) {
                                // PRIMEIRA PÁGINA
                                minIndex = 0;
                                maxIndex = 4;
                            } else if (opcao3_b.equals("U")) {
                                // ÚLTIMA PÁGINA
                                for (int i = 1; (i * 5) < listaRevistas.size(); i++) {
                                    minIndex = 5 * i;
                                    maxIndex = 5 * (i + 1);
                                }
                            } else if (opcao3_b.equals("E")) {
                                // EXCLUIR LIVRO DA LISTA
                                index = verificarInt(
                                        "Insira o ID da revista no qual você deseja remover da lista: ");
                                listaRevistas.remove(index);
                            } else if (opcao3_b.equals("O")) {
                                // ORGANIZAR LISTA
                                do {
                                    for (int i = 0; i < listaRevistas.size() - 1; i++) {
                                        Revista item1 = listaRevistas.get(i);
                                        Revista item2 = listaRevistas.get(i + 1);
                                        Revista temp = item1;

                                        if (item1.getNome().toUpperCase().compareTo(item2.getNome().toUpperCase()) > 0) {
                                            item1 = listaRevistas.get(i);
                                            item2 = listaRevistas.get(i + 1);
                                            temp = item1;
                                            item1 = item2;
                                            item2 = temp;
                                            listaRevistas.set(i, item1);
                                            listaRevistas.set(i + 1, item2);
                                        }
                                    }
                                } while (!listaRevistasEstaOrganizada(listaRevistas));
                            } else if (opcao3_b.equals("S")) {
                                opcao0 = 0;
                                // SAIR
                                break;
                            } else {
                                // VALOR INVÁLIDO
                                System.out.println(opcaoInvalidaString);
                            }
                        } while (true);
                    }
                    opcao0 = 0;
                } else if (opcao3 == 3) {
                    opcao0 = 0;
                    // sair
                } else {
                    System.out.println(opcaoInvalidaString);
                }
                if (opcao3 == 3 || opcao3_b.equals("S")) {
                    break;
                }
            } while (true);
        }
        catch (Throwable e) {
            System.out.println("Um erro foi encontrado! Contate o suporte! \nLinha: " + e.getStackTrace()[0].getLineNumber() + "\nTipo de Erro: " + e.getStackTrace()[0].getClass().getName());
        }
    }
    
    // GERENCIAR ESPAÇO OCUPADO POR LIVRO/REVISTA
    public static void gerenciarEspacoLivrosRevistas() {
        String opcao4 = "";
        try {
            do {
                System.out.println("================================\n\tGerenciar Espaço\n================================");
                // espaço livre
                System.out.printf("\nEspaço ocupado (livros): %d/1000", listaLivros.size());
                System.out.printf("\nEspaço ocupado (revistas): %d/1000", listaRevistas.size());
                // opção de input + input do usuário
                System.out.println("\n\n[L] - Limpar a lista de livros\n[R] - Limpar a lista de revistas\n[S] - Sair");
                do {
                    opcao4 = verificarString("\n> ").toUpperCase().trim();
                    break;
                } while (true);
                if (opcao4.equals("L")) {
                    // LIMPAR LISTA LIVROS
                    String opcao4_B = "";
                    do {
                        System.out.println("Tem certeza que deseja limpar a lista de livros? Essa ação não poderá ser revertida (escreva \"S\" ou \"N\").");
                        opcao4_B = verificarString("> ").toUpperCase();
                        if (opcao4_B.equals("S")) {
                            listaLivros.clear();
                            break;
                        }
                    } while (true);
                } else if (opcao4.equals("R")) {
                    // LIMPAR LISTA REVISTAS
                    String opcao4_B = "";
                    do {
                        System.out.println("Tem certeza que deseja limpar a lista de revistas? Essa ação não poderá ser revertida (escreva \"S\" ou \"N\").");
                        opcao4_B = verificarString("> ").toUpperCase();
                        if (opcao4_B.equals("S")) {
                            listaRevistas.clear();
                            break;
                        }
                    } while (true);
                } else if (opcao4.equals("S")) {
                    // SAIR
                    break;
                } else {
                    //OPÇÃO INVÁLIDA
                    System.out.println(opcaoInvalidaString);
                }
            } while (true);
        }
        catch (Throwable e) {
            System.out.println("Um erro foi encontrado! Contate o suporte! \nLinha: " + e.getStackTrace()[0].getLineNumber() + "\nTipo de Erro: " + e.getStackTrace()[0].getClass().getName());
        }
        opcao0 = 0;
    }
}