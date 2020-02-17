package sample;

public class WynikRuchu {
    private Ruch ruch;

    public Ruch getRuch(){
        return ruch;
    }

    private Pionek pionek;

    public Pionek getPionek(){
        return pionek;
    }
    public WynikRuchu(Ruch ruch)
    {
        this(ruch, null);
    }
    public WynikRuchu(Ruch ruch, Pionek pionek)
    {
        this.ruch = ruch;
        this.pionek = pionek;
    }
}
