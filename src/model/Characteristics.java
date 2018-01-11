package model;

public class Characteristics {

    int nos, str, var, field;
    int fidAcs, arrAcs;
    int cast, ifs, loop, mthInvoc, newInvoc;

    public Characteristics() {
        this.nos = 0;			// num of sentence
        this.str = 0;			// string literal
        this.var = 0;			// local variable
        this.field = 0;         // field
        this.fidAcs = 0;        // field access
        this.arrAcs = 0;		// array access
        this.cast = 0;          // cast
        this.ifs = 0;           // if statement
        this.loop = 0;          // loop (for, while)
        this.mthInvoc = 0;      // method invocation
        this.newInvoc = 0;      // new invocation
    }

    public void countUp(String param) {
        switch (param) {
            case "nos" : this.nos += 1; break;
            case "str" : this.str += 1; break;
            case "var" : this.var += 1; break;
            case "field" : this.field += 1; break;
            case "fidAcs" : this.fidAcs += 1; break;
            case "arrAcs" : this.arrAcs += 1; break;
            case "cast" : this.cast += 1; break;
            case "ifs" : this.ifs += 1; break;
            case "loop" : this.loop += 1; break;
            case "mthInvoc" : this.mthInvoc += 1; break;
            case "newInvoc" : this.newInvoc += 1; break;
        }
    }

    public String out() {
        return new StringBuilder()
                .append(String.valueOf(this.nos)).append(",")
                .append(String.valueOf(this.str)).append(",")
                .append(String.valueOf(this.var)).append(",")
                .append(String.valueOf(this.field)).append(",")
                .append(String.valueOf(this.fidAcs)).append(",")
                .append(String.valueOf(this.arrAcs)).append(",")
                .append(String.valueOf(this.cast)).append(",")
                .append(String.valueOf(this.ifs)).append(",")
                .append(String.valueOf(this.loop)).append(",")
                .append(String.valueOf(this.mthInvoc)).append(",")
                .append(String.valueOf(this.newInvoc)).append(",")
                .toString();
    }
}

