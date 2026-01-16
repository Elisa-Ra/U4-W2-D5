package elisaraeli;

import elisaraeli.entities.Giochi;
import elisaraeli.entities.GiocoDaTavolo;
import elisaraeli.entities.Videogioco;

import java.util.Scanner;


public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Collezione collezione = new Collezione();

        // Creo i giochi
        Videogioco v1 = new Videogioco("Baldur's Gate III", 2023, 60.00,
                "PC, PlayStation, Xbox", 200, Videogioco.Genere.GDR);
        Videogioco v2 = new Videogioco("Life is Strange", 2015, 20.00,
                "PC, PlayStation, Xbox", 20, Videogioco.Genere.AVVENTURAGRAFICA);
        Videogioco v3 = new Videogioco("Gears of War 2", 2008, 30.00,
                "Xbox", 15, Videogioco.Genere.TPS);
        Videogioco v4 = new Videogioco("Silent Hill", 2015, 20.00,
                "PC, PlayStation, Xbox", 20, Videogioco.Genere.HORROR);
        GiocoDaTavolo t1 = new GiocoDaTavolo("Le Case della Follia", 2011,
                84.99, 5, 60);
        GiocoDaTavolo t2 = new GiocoDaTavolo("Cluedo", 1948, 10.00,
                6, 30);
        // Aggiungo i giochi alla collezione
        collezione.aggiungiGioco(v1);
        collezione.aggiungiGioco(v2);
        collezione.aggiungiGioco(v3);
        collezione.aggiungiGioco(v4);
        collezione.aggiungiGioco(t1);
        collezione.aggiungiGioco(t2);

        int scelta;

        do {
            System.out.println("\n----- MENU -----");
            System.out.println("Premi 1 per aggiungere un videogioco");
            System.out.println("Premi 2 per aggiungere un gioco da tavolo");
            System.out.println("Premi 3 per cercare un gioco tramite l'ID");
            System.out.println("Premi 4 per cercare un gioco col prezzo minore di quello che inserisci");
            System.out.println("Premi 5 per cercare un gioco da tavolo per numero di giocatori");
            System.out.println("Premi 6 per rimuovere un gioco per ID");
            System.out.println("Premi 7 per aggiornare un gioco per ID");
            System.out.println("Premi 8 per vedere le statistiche");
            System.out.println("Premi 0 Esci");
            System.out.print("Scelta: ");

            scelta = scanner.nextInt();
            scanner.nextLine();

            switch (scelta) {

                case 1 -> {
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Anno: ");
                    int anno = scanner.nextInt();

                    System.out.print("Prezzo: ");
                    double prezzo = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Piattaforma: ");
                    String piattaforma = scanner.nextLine();

                    System.out.print("Ore di gioco: ");
                    int ore = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Genere (GDR, TPS, HORROR, AVVENTURAGRAFICA): ");
                    String gen = scanner.nextLine();

                    Videogioco nuovo = new Videogioco(
                            nome, anno, prezzo, piattaforma, ore,
                            Videogioco.Genere.valueOf(gen.toUpperCase())
                    );

                    collezione.aggiungiGioco(nuovo);
                    System.out.println("Videogioco aggiunto con successo!");
                }

                case 2 -> {
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Anno: ");
                    int anno = scanner.nextInt();

                    System.out.print("Prezzo: ");
                    double prezzo = scanner.nextDouble();

                    System.out.print("Numero giocatori: ");
                    int n = scanner.nextInt();

                    System.out.print("Durata (minuti): ");
                    int durata = scanner.nextInt();
                    scanner.nextLine();

                    GiocoDaTavolo nuovo = new GiocoDaTavolo(nome, anno, prezzo, n, durata);
                    collezione.aggiungiGioco(nuovo);

                    System.out.println("Gioco da tavolo aggiunto con successo!");
                }

                case 3 -> {
                    System.out.print("Scrivi l'id che vuoi cercare: ");
                    int id = scanner.nextInt();

                    try {
                        Giochi g = collezione.cercaId(id);
                        System.out.println("L'ID: " + id + " corrisponde a: " + g);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }

                case 4 -> {
                    System.out.print("Inserisci il prezzo sotto cui vuoi cercare i giochi: ");
                    double prezzoScelto = scanner.nextDouble();

                    var risultati = collezione.cercaPrezzo(prezzoScelto);

                    if (risultati.isEmpty()) {
                        System.out.println("Nessun gioco trovato sotto questo prezzo.");
                    } else {
                        risultati.forEach(System.out::println);
                    }
                }

                case 5 -> {
                    System.out.print("Scrivi il numero di giocatori che deve avere il gioco: ");
                    int n = scanner.nextInt();

                    var risultati = collezione.cercaNgiocatori(n);

                    if (risultati.isEmpty()) {
                        System.out.println("Nessun gioco trovato con questo numero di giocatori.");
                    } else {
                        risultati.forEach(System.out::println);
                    }
                }

                case 6 -> {
                    System.out.print("Scrivi l'ID del gioco da rimuovere: ");
                    int id = scanner.nextInt();

                    try {
                        collezione.rimuoviGiocoById(id);
                        System.out.println("Gioco rimosso con successo!");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }

                case 7 -> {
                    // non sono arrivata a finirlo
                    System.out.println("Aggiungere metodo per modificare giochi");
                }

                case 8 -> collezione.statistiche();

                case 0 -> System.out.println("Uscita...");

                default -> System.out.println("Scelta non valida.");
            }

        } while (scelta != 0);

        scanner.close();
    }
}
