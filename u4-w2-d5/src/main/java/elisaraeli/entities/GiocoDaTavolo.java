package elisaraeli.entities;

public class GiocoDaTavolo extends Giochi {
    private int numeroGiocatori; // da 2 a 10
    private int durataMedia; // in minuti

    public GiocoDaTavolo(String titolo, int annoPubblicazione, double prezzo,
                         int numeroGiocatori, int durataMedia) {
        // Uso i costruttori del padre (Giochi)
        super(titolo, annoPubblicazione, prezzo);

        // Gestisco le eccezioni
        if (numeroGiocatori < 2 || numeroGiocatori > 10) {
            throw new IllegalArgumentException("Errore: Il numero di giocatori deve essere compreso" +
                    " tra 2 e 10.");
        }

        if (durataMedia <= 0) {
            throw new IllegalArgumentException("Errore: la durata deve essere maggiore di 0.");
        }

        this.numeroGiocatori = numeroGiocatori;
        this.durataMedia = durataMedia;


    }

    @Override
    public String toString() {
        return super.toString() +
                ", numero di giocatori: " + numeroGiocatori + ", durata media partita: "
                + durataMedia + " minuti";
    }
}
