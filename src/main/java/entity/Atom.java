package entity;

public enum Atom {
    HOLE(0),
    BLUE(1),
    BLACK(2); //відступ
    private final int number;

    Atom(int number) {
        this.number = number;
    }

    //не стер комент
    //не використовувалось
    public int getNumber(){ return number;}

}

