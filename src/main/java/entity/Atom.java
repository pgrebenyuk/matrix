package entity;

public enum Atom {
    HOLE(0),
    BLUE(1),
    BLACK(2);
    private final int number;

    //модифікатор??
    Atom(int number) {
        this.number = number;
    }

    public int getNumber(){ return number;}

}

