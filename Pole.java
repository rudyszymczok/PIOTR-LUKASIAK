package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Pole extends Rectangle {

    private Pionek pionek;

    public boolean zajetePole()
    {
        return pionek != null;
    }
    public Pionek getPionek()
    {
        return pionek;
    }
    public void setPionek(Pionek pionek)
    {
        this.pionek = pionek;
    }

    public Pole(boolean in,int x, int y)
    {
        setWidth(Plansza.wielkosc_pola);
        setHeight(Plansza.wielkosc_pola);

        relocate(x * Plansza.wielkosc_pola,y * Plansza.wielkosc_pola);

        setFill(in ? Color.valueOf("#feb") : Color.valueOf("#582"));
    }
}
