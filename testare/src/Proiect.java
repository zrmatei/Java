import java.util.Objects;

public class Proiect implements Comparable<Proiect> {
    protected int cod;
    protected String acronim, sef, departament;
    protected double buget;
    protected int nr_membrii;

    public Proiect() {
    }

    public Proiect(int cod, String acronim, String sef, String departament, double buget, int nr_membrii) {
        this.cod = cod;
        this.acronim = acronim;
        this.sef = sef;
        this.departament = departament;
        this.buget = buget;
        this.nr_membrii = nr_membrii;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getAcronim() {
        return acronim;
    }

    public void setAcronim(String acronim) {
        this.acronim = acronim;
    }

    public String getSef() {
        return sef;
    }

    public void setSef(String sef) {
        this.sef = sef;
    }

    public String getDepartament() {
        return departament;
    }

    public void setDepartament(String departament) {
        this.departament = departament;
    }

    public double getBuget() {
        return buget;
    }

    public void setBuget(double buget) {
        this.buget = buget;
    }

    public int getNr_membrii() {
        return nr_membrii;
    }

    public void setNr_membrii(int nr_membrii) {
        this.nr_membrii = nr_membrii;
    }

    @Override
    public String toString() {
        return "Proiect{" +
                "cod=" + cod +
                ", acronim='" + acronim + '\'' +
                ", sef='" + sef + '\'' +
                ", departament='" + departament + '\'' +
                ", buget=" + buget +
                ", nr_membrii=" + nr_membrii +
                '}';
    }

    @Override
    public boolean equals(Object o) { //o folosesc la verificare egalitate
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Proiect proiect = (Proiect) o;
        return cod == proiect.cod;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cod);
    }


    @Override
    public int compareTo(Proiect p) { //metoda de comparare
        if (this.buget == p.buget){
            return 0;
        } else if (this.buget < p.buget) {
            return -1;
        }
        else{
            return 1;
        }
    }
}
