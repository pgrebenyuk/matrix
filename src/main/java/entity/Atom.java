package entity;

public enum Atom {HOLE("hole"), BLUE("blue"), BLACK("black");
    private final String name;

    Atom(String name) {
        this.name = name;
    }

    public String getName(){ return name;}

}

