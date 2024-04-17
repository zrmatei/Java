import static java.lang.Math.sqrt;

public class Puncte implements Comparable<Puncte>{

    private String eticheta;
    private String eti_punct;
    private double co_ox, co_oy;
    public Puncte() {
    }

    public Puncte(String eticheta, String eti_punct, double co_ox, double co_oy) {
        this.eticheta = eticheta;
        this.eti_punct = eti_punct;
        this.co_ox = co_ox;
        this.co_oy = co_oy;
    }

    public String getEticheta() {
        return eticheta;
    }

    public void setEticheta(String eticheta) {
        this.eticheta = eticheta;
    }

    public String getEti_punct() {
        return eti_punct;
    }

    public void setEti_punct(String eti_punct) {
        this.eti_punct = eti_punct;
    }

    public double getCo_ox() {
        return co_ox;
    }

    public void setCo_ox(double co_ox) {
        this.co_ox = co_ox;
    }

    public double getCo_oy() {
        return co_oy;
    }

    public void setCo_oy(double co_oy) {
        this.co_oy = co_oy;
    }

    @Override
    public String toString() {
        return "Puncte{" +
                "eticheta='" + eticheta + '\'' +
                ", eti_punct='" + eti_punct + '\'' +
                ", co_ox=" + co_ox +
                ", co_oy=" + co_oy +
                '}';
    }

    public double distanta(){
        double x = this.co_ox;
        double y = this.co_oy;
        return sqrt(x * x + y * y);
    }

    @Override
    public int compareTo(Puncte p) {
        if(this.distanta() == p.distanta()){
            return 0;
        } else if (this.distanta() > p.distanta()) {
            return 1;
        }
        else {
            return -1;
        }
    }
}
