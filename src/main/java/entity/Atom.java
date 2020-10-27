package entity;

//елементи з нової стрічки маюь бути
public enum Atom {HOLE("hole"), BLUE("blue"), BLACK("black");
    //хочу щоб виводило 0,1,2
    private final String name;

    Atom(String name) {
        this.name = name;
    }

    //не використовувалось
    public String getName(){ return name;}

}

