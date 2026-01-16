package elisaraeli.entities;

// La mia classe astratta
public abstract class Giochi {
    // L'ID deve essere univoco
    private static int incremento = 1;
    private final int id;
    private String titolo;
    private int annoPubblicazione;
    private double prezzo;

    public Giochi(String titolo, int annoPubblicazione, double prezzo) {
        // GESTIONE DELLE ECCEZIONI
        // controllo che il titolo non sia null o vuoto/formato solo da spazi
        // uso il throw invece di un sout perché nel sout apparirebbe solo il msg senza "bloccarmi"
        if (titolo == null || titolo.isBlank()) {
            throw new IllegalArgumentException("Errore: titolo non valido.");
        }

        // controllo che l'anno di pubblicazione sia maggiore di 1950 e minore dell'anno corrente
        int annoCorrente = java.time.LocalDate.now().getYear();
        if (annoPubblicazione < 1950 || annoPubblicazione > annoCorrente) {
            throw new IllegalArgumentException("Errore: l'anno di pubblicazione non è valido.");
        }

        // il prezzo deve avere un valore positivo, quindi controllo che non sia minore/uguale a zero
        if (prezzo <= 0) {
            throw new IllegalArgumentException("Errore: il prezzo non è valido.");
        }

        // per avere un id univoco, ho deciso di mettere l'id che incrementa di volta in volta.
        this.id = incremento++;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.prezzo = prezzo;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public double getPrice() {
        return prezzo;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", titolo: " + titolo + ", anno di pubblicazione: " + annoPubblicazione
                + ", prezzo: " + prezzo;
    }
}