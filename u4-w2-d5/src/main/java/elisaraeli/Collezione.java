package elisaraeli;

import elisaraeli.entities.Giochi;

import java.util.ArrayList;
import java.util.List;

public class Collezione {

    private final List<Giochi> listaGiochi = new ArrayList<>();


    // AGGIUNTA DI UN ELEMENTO (non deve essere possibile inserire un elemento con lo stesso id)

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

    // 3. RICERCA PER PREZZO

    // 4. RICERCA PER NUMERO DI GIOCATORI (GiocoDaTavolo)

    // 5. RIMOZIONE PER ID

    // 6. AGGIORNAMENTO DI UN ELEMENTO PER ID

    // 7. STATISTICHE DELLA COLLEZIONE (numero tot di videogiochi e giochi da tavolo presenti,
    // il gioco con il prezzo più alto e la media dei prezzi di tutti gli elementi)


}

