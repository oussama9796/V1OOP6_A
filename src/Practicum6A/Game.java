package Practicum6A;

import java.time.LocalDate;
import java.util.Objects;

public class Game {
    private String naam;
    private int releaseJaar;
    private double nieuwprijs;

    public Game(String naam, int releaseJaar, double nieuwprijs) {
        this.naam = naam;
        this.releaseJaar = releaseJaar;
        this.nieuwprijs = nieuwprijs;
    }

    public String getNaam() {
        return naam;
    }

    public double huidigeWaarde() {
        int huidigJaar = LocalDate.now().getYear();
        int jaar = huidigJaar - releaseJaar;
        double huidigePrijs = nieuwprijs;
        for (int y = 0; y < jaar; y++) {
            huidigePrijs = huidigePrijs / 100 * 70;
        }
        return huidigePrijs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Game)) return false;
        Game game = (Game) o;
        return releaseJaar == game.releaseJaar && Objects.equals(naam, game.naam);
    }

    @Override
    public String toString() {
        return String.format("%s, uitgegeven in %d; nieuwprijs: €%.2f nu voor: €%.2f", naam, releaseJaar, nieuwprijs, huidigeWaarde());
    }
}
