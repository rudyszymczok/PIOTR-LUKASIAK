package sample;

import javafx.application.Application;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeType;

public class Plansza {



    public static int rozmiar = Setup.setup.rozmiar;

    public static int wielkosc_pola=400/rozmiar;


    private Pole[][] plansza = new Pole[rozmiar][rozmiar];

    private Group grupaPola = new Group();
    private Group grupaPionki = new Group();

    public Parent init(){
        Pane root = new Pane();

        root.setPrefSize(600,400);
        root.getChildren().addAll(grupaPola,grupaPionki);
        int wolne=(rozmiar-3)/2;
        for(int y=0;y<rozmiar;y++){
            for (int x=0;x<rozmiar;x++)
            {
                Pionek pionek = null;
                if (((y>=wolne) && (y<rozmiar-wolne)) || ((x>=wolne) && (x<rozmiar-wolne))) {
                    Pole pole = new Pole(true,x,y);
                    plansza[x][y] = pole;
                    grupaPola.getChildren().add(pole);
                    if ((x!=(rozmiar-1)/2) || (y!=(rozmiar-1)/2))
                    {
                        pionek = dodajPionek(x,y);
                    }
                    if(pionek != null) {
                        pole.setPionek(pionek);
                        grupaPionki.getChildren().add(pionek);
                    }

                }
                else
                {
                    Pole pole = new Pole(false,x,y);
                    plansza[x][y] = pole;
                    grupaPola.getChildren().add(pole);

                }
            }
        }
        return root;

    }
    private WynikRuchu tryMove(Pionek pionek, int newX, int newY)
    {
        int x0=toBoard(pionek.getOldX());
        int y0=toBoard(pionek.getOldY());

        if(plansza[newX][newY].zajetePole()){
            return new WynikRuchu(Ruch.BRAK);
        }

        else if (Math.abs(newX - x0) == 2 ^ Math.abs(newY - y0) == 2)
        {
            if(newX-x0==2 && plansza[newX-1][newY].zajetePole())
            {
                return new WynikRuchu(Ruch.RUCH,plansza[newX-1][newY].getPionek());
            }
            else if(newX-x0==-2 && plansza[newX+1][newY].zajetePole())
            {
                return new WynikRuchu(Ruch.RUCH,plansza[newX+1][newY].getPionek());
            }
            else if(newY-y0==2 && plansza[newX][newY-1].zajetePole())
            {
                return new WynikRuchu(Ruch.RUCH,plansza[newX][newY-1].getPionek());
            }
            else if(newY-y0==-2 && plansza[newX][newY+1].zajetePole())
            {
                return new WynikRuchu(Ruch.RUCH,plansza[newX][newY+1].getPionek());
            }
            else
            {
                return new WynikRuchu(Ruch.BRAK);
            }
        }
        else
        {
            return new WynikRuchu(Ruch.BRAK);
        }
    }
    private int toBoard(double pixel)
    {
        return (int)(pixel + wielkosc_pola / 2) / wielkosc_pola;
    }
    private Pionek dodajPionek(int x, int y)
    {
        Pionek pionek = new Pionek(x,y);

        pionek.setOnMouseReleased(e -> {
            int newX = toBoard(pionek.getLayoutX());
            int newY = toBoard(pionek.getLayoutY());

            WynikRuchu wynik = tryMove(pionek, newX, newY);

            int x0=toBoard(pionek.getOldX());
            int y0=toBoard(pionek.getOldY());

            switch (wynik.getRuch()) {
                case BRAK:
                    pionek.cofnijRuch();
                    break;
                case RUCH:
                    pionek.ruch(newX,newY);
                    plansza[x0][y0].setPionek(null);
                    plansza[newX][newY].setPionek(pionek);

                    Pionek pionekZbijany = wynik.getPionek();
                    plansza[toBoard(pionekZbijany.getOldX())][toBoard(pionekZbijany.getOldY())].setPionek(null);
                    grupaPionki.getChildren().remove(pionekZbijany);
                    break;
            }
        });
        return pionek;
    }



}
