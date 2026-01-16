package elisaraeli.entities;

// La mia classe astratta
public abstract class Giochi {
    private int id;
    private String title;
    private int annoPubblicazione;
    private double prezzo;


    public Giochi(int id, String title, int annoPubblicazione, double prezzo) {
        this.id = id;
        this.title = title;
        this.annoPubblicazione = annoPubblicazione;
        this.prezzo = prezzo;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public double getPrice() {
        return prezzo;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", titolo: " + title + "anno di pubblicazione: " + annoPubblicazione
                + ", prezzo: " + prezzo;
    }
}