package elisaraeli.entities;

public class Videogioco extends Giochi {
    private String piattaforma;
    // la durata gioco deve essere in ore, potrei usare int o double
    private int durataGioco;
    private Genere genere;

    public Videogioco(String titolo, int annoPubblicazione, double prezzo,
                      String piattaforma, int durataGioco, Genere genere) {
        // Uso i costruttori del padre (Giochi)
        super(titolo, annoPubblicazione, prezzo);

        // Gestisco le eccezioni
        if (piattaforma == null || piattaforma.isBlank()) {
            throw new IllegalArgumentException("Errore: piattaforma non valida.");
        }

        if (durataGioco <= 0) {
            throw new IllegalArgumentException("Errore: la durata deve essere maggiore di 0.");
        }

        this.piattaforma = piattaforma;
        this.durataGioco = durataGioco;
        this.genere = genere;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", piattaforma: " + piattaforma + ", durata gioco: "
                + durataGioco + " ore, genere: " + genere;
    }

    // L'ENUM GENERE
    public enum Genere {
        HORROR,
        TPS,
        GDR,
        AVVENTURAGRAFICA,
    }
}
