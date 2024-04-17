import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static List<Proiect>list_pr = new ArrayList<>();
    public static double buget_tot;

    public static void main(String[] args) {
        Proiect p1 = new Proiect(13, "DA", "Gigel", "Constructii", 5.3, 5);
        Proiect p2 = new Proiect(13, "NU", "Floricel", "IT", 10.3, 6);
        System.out.println(p1.equals(p2));
        System.out.println(p1.compareTo(p2));

        //citire de date din fisier
        citireDate("proiect.csv");
        for (Proiect p: list_pr){
            System.out.println(p);
        }
        for(Proiect p: list_pr){
            buget_tot += p.buget;
        }
        System.out.println("Buget total: " + buget_tot);

        //cerinta3
        System.out.println("Cerinta 3");
//        for (Proiect p: list_pr){
//            System.out.println(p.departament + ":" + p.acronim);
//        }
         Map<String, List<String>> lista= list_pr.stream()
                 .collect(Collectors.toMap(
                         Proiect::getDepartament,
                         proiect -> Collections.singletonList(proiect.getAcronim())
                         ));

         lista.forEach( (dep, acronim ) -> {
                     System.out.println(dep + ":" + String.join(", ", acronim));
                 }
                 );

         //cerinta4 - ordonare descrescatoare dupa nr membrii
        salvare("dep_buget.csv");

    }

    public static void citireDate(String numeFisier){
        try {
            BufferedReader in = new BufferedReader(new FileReader(numeFisier));

            String linie;
            while((linie = in.readLine()) != null){
                linie = linie.trim();
                String[] info = linie.split(",");
                Proiect p = new Proiect( Integer.parseInt(info[0]),
                        info[1], info[2], info[3],
                        Double.parseDouble(info[4]),
                        Integer.parseInt(info[5])
                );
                list_pr.add(p);
            }
        }
        catch (Exception e){
            System.err.println(e);
        }
    }
    public static void salvare(String numeFisier){
        try(PrintWriter out = new PrintWriter(numeFisier)){
            //am mutat asta din main in functia de salvare ca atunci cand salvez fisierul sa schimb ordinea
            List<Proiect>lista_sort = list_pr.stream()
                    .sorted(Comparator.comparing(Proiect::getNr_membrii).reversed())
                    .collect(Collectors.toList());
            lista_sort.forEach(System.out::println);
            //iau fiecare proiect din lista sortata si afisez ce-mi trebuie in functie de nr de membrii
            for(Proiect p: lista_sort){
                out.println(p.getCod() + "," +
                        p.getAcronim() + "," + p.getBuget() + "," + p.getNr_membrii());
            }
        }
        catch(Exception e){
            System.err.println(e);
        }
    }

}
