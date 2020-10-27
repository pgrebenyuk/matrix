package entity;

public enum Atom {
    HOLE(0),
    BLUE(1),
    BLACK(2);
    private final int number;

    Atom(int number) {
        this.number = number;
    }

    //не використовувалось
    public int getNumber(){ return number;}

}

