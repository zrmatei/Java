import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static List<Puncte>list_p = new ArrayList<>();
    public static int nr_pct;


    public static void main(String[] args) {
        Puncte p1 = new Puncte("F1","A",1,1);
        Puncte p2 = new Puncte("F1","B",2,1);
        //cerinta 1
        System.out.println(p1.distanta());
        System.out.println(p1.compareTo(p2));
        //cerinta2
        citire("puncte.csv");
        for(Puncte p: list_p){
            System.out.println(p);
        }
        for(Puncte p: list_p){
            ++nr_pct;
        }
        System.out.println("Nr puncte: " + nr_pct);

        //cerinta3
        Map<String, List<Puncte>> list_eti = list_p.stream()
                .collect(Collectors.groupingBy(Puncte::getEticheta));
        list_eti.forEach((eti, nr_punct) -> {
            System.out.print(eti  + ":");
            System.out.println(nr_punct.size());
                }
                );
        //cerinta4
        salvare("distante.csv");

    }

    public static void citire(String numeFis){
        try (BufferedReader in = new BufferedReader(new FileReader(numeFis))) {
            String linie;
            while((linie = in.readLine()) != null){
                String[] info = linie.split(",");
                Puncte p = new Puncte(info[0],
                        info[1], Double.parseDouble(info[2]),
                        Double.parseDouble(info[3])
                );
                list_p.add(p);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void salvare(String numeFis){
        try (PrintWriter out = new PrintWriter(numeFis)){

            List<Puncte>list_sort = list_p.stream()
                    .sorted(Comparator.comparing(Puncte::distanta).reversed())
                    .collect(Collectors.toList());

            for(Puncte p: list_sort){
                out.println(p.getEticheta() + "," + p.getEti_punct()
                + "," + p.distanta() );
            }


        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
