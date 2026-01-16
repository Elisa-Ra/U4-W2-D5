package elisaraeli;

import elisaraeli.entities.Giochi;
import elisaraeli.entities.GiocoDaTavolo;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Collezione {

    private final List<Giochi> listaGiochi = new ArrayList<>();


    //1. AGGIUNTA DI UN ELEMENTO (non deve essere possibile inserire un elemento con lo stesso id)

    public void add(Giochi gioco) {
        // Controllo che il gioco non sia null
        if (gioco == null) {
            throw new IllegalArgumentException("Errore: il gioco non può essere null.");
        }

        // faccio uno stream su listaGiochi per vedere se c'è almeno un gioco (anyMatch) con lo stesso id
        boolean idEsistente = listaGiochi.stream()
                .anyMatch(g -> g.getId() == gioco.getId());
        // se c'è, non posso aggiungere il gioco con lo stesso id
        if (idEsistente) {
            throw new IllegalArgumentException("Errore: esiste già un gioco con questo ID: "
                    + gioco.getId());
        }
        // aggiungo il gioco
        listaGiochi.add(gioco);
    }

    // 2. RICERCA PER ID
    // Faccio una stream sulla lista giochi, uso l'id come filtro, prendo il primo elemento
    // se non esiste, lancio un errore
    public Giochi cercaId(int id) {
        return listaGiochi.stream().filter(g -> g.getId() == id).findFirst()
                .orElseThrow(() -> // consigliato da intelliJ
                        new NoSuchElementException("Non è stato trovato nessun gioco con l'id: " + id));
    }

    // 3. RICERCA PER PREZZO (deve ritornare quindi una lista di giochi
    // con prezzo inferiore al prezzo inserito)
    // faccio uno stream su listaGiochi, uso come filtro il fatto che il prezzo debba essere minore del
    // prezzo scelto. E poi uso toList per restituire una lista
    public List<Giochi> cercaPrezzo(double prezzoScelto) {
        return listaGiochi.stream().filter(g -> g.getPrice() < prezzoScelto).toList();
    }

    // 4. RICERCA PER NUMERO DI GIOCATORI (GiocoDaTavolo)
    // faccio lo stream sulla lista giochi, ma il numero di giocatori lo possiede solo il GiocoDaTavolo
    // quindi filtro gli elementi GiocoDaTavolo e controllo che il numero di giocatori corrisponda
    // e poi restituisco una lista di GiocoDaTavolo
    public List<GiocoDaTavolo> cercaNgiocatori(int ngiocatori) {
        return listaGiochi.stream().filter(g -> g instanceof GiocoDaTavolo giocoTavolo
                        && giocoTavolo.getNumeroGiocatori() == ngiocatori)
                .map(g -> (GiocoDaTavolo) g).toList();
    }

    // 5. RIMOZIONE PER ID
    public void rimuoviGiocoById(int id) {

        // Se la condizione è soddisfatta (quindi l'id del gioco corrisponde), removeIf rimuove l'elemento
        boolean elimina = listaGiochi.removeIf(g -> g.getId() == id);
        // se la condizione non viene soddisfatta (quindi non esiste un gioco con quell'id)
        // lancio un Exception
        if (!elimina) {
            throw new NoSuchElementException("Non è stato trovato nessun gioco con l'id: " + id);
        }
    }

    // 6. AGGIORNAMENTO DI UN ELEMENTO PER ID
    public void aggiornaGiocoById(int id, Giochi newGioco) {
        // faccio lo stream su listaGiochi, filtro per id, prendo il primo elemento
        // se non c'è lancio un Exception
        // prendo l'index del gioco con l'id scelto
        // e uso set per aggiornarlo
        Giochi giocoEsistente = listaGiochi.stream()
                .filter(g -> g.getId() == id)
                .findFirst()
                .orElseThrow(() ->
                        new NoSuchElementException("Non è stato trovato nessun gioco con l'id: " + id));

        int index = listaGiochi.indexOf(giocoEsistente);

        listaGiochi.set(index, newGioco);
    }
    
    // 7. STATISTICHE DELLA COLLEZIONE (numero tot di videogiochi e giochi da tavolo presenti,
    // il gioco con il prezzo più alto e la media dei prezzi di tutti gli elementi)

}

