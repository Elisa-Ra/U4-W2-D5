package elisaraeli;

import elisaraeli.entities.GiocoDaTavolo;
import elisaraeli.entities.Videogioco;

public class Application {

    public static void main(String[] args) {

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

    }
}
