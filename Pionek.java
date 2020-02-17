package sample;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

public class Pionek extends StackPane {
    private double mouseX,mouseY;
    private double oldX, oldY;

    public double getOldX() {
        return oldX;
    }

    public double getOldY() {
        return oldY;
    }

    public Pionek(int x, int y)
    {

        ruch(x,y);
        Ellipse tlo= new Ellipse(Plansza.wielkosc_pola * 0.3125, Plansza.wielkosc_pola * 0.26);
        tlo.setFill(Color.BLACK);
        tlo.setStroke(Color.BLACK);
        tlo.setStrokeWidth(Plansza.wielkosc_pola*0.03);

        tlo.setTranslateX((Plansza.wielkosc_pola - Plansza.wielkosc_pola*0.3125*2)/2);
        tlo.setTranslateY((Plansza.wielkosc_pola - Plansza.wielkosc_pola*0.26*2)/2 + Plansza.wielkosc_pola * 0.07);

        Ellipse pion= new Ellipse(Plansza.wielkosc_pola * 0.3125, Plansza.wielkosc_pola * 0.26);
        pion.setFill(Color.valueOf(Setup.setup.kolor)); // TUTAJ USTAWIAM KOLOR
        pion.setStroke(Color.BLACK);
        pion.setStrokeWidth(Plansza.wielkosc_pola*0.03);

        pion.setTranslateX((Plansza.wielkosc_pola - Plansza.wielkosc_pola*0.3125*2)/2);
        pion.setTranslateY((Plansza.wielkosc_pola - Plansza.wielkosc_pola*0.26*2)/2);

        getChildren().addAll(tlo,pion);

        setOnMousePressed(e ->{
            mouseX = e.getSceneX();
            mouseY = e.getSceneY();
        });

        setOnMouseDragged(e ->{
            relocate(e.getSceneX() - mouseX + oldX, e.getSceneY() - mouseY + oldY);
        });

    }
    public void ruch(int x,int y)
    {
        oldX = x * Plansza.wielkosc_pola;
        oldY = y * Plansza.wielkosc_pola;
        relocate(oldX,oldY);

    }
    public void cofnijRuch()
    {
        relocate(oldX,oldY);
    }
}
