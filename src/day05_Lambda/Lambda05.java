package day05_Lambda;

import day04_Lambda.Universite;

import java.util.*;
import java.util.stream.Collectors;

public class Lambda05 {

    /*
    TASK :
    fields --> Universite (String)
               bolum (String)
               ogrcSayisi (int)
               notOrt (int)
               olan POJO clas craete edip main method içinde 5 farklı obj'den List create ediniz.
     */
    public static void main(String[] args) {

        Universite u01 = new Universite("bogazici", "matematik", 571, 93);
        Universite u02 = new Universite("istanbul teknik", "matematik", 622, 81);
        Universite u03 = new Universite("istanbul", "hukuk", 1453, 71);
        Universite u04 = new Universite("marmara", "bilgisayar muh", 1071, 77);
        Universite u05 = new Universite("yıldız teknik", "gemi", 333, 74);
        List<Universite> unv = new ArrayList<>(Arrays.asList(u01, u02, u03, u04, u05));


        System.out.println(enAzOgrcSaysi2Unv(unv));
        System.out.println("\n   ***   ");
        System.out.println("task 7: " + notOrt63BykUnvOgrcSayisiTopla(unv));
        System.out.println("\n   ***   ");
        System.out.println("mapToInt ile : " + notOrt63BykUnvOgrcSayisiToplaToInt(unv));
        System.out.println("\n   ***   ");
        System.out.println("task 8 : " + ogrcSayisi333BykNotOrtOrtlamaAl(unv));
        System.out.println("\n   ***   ");
        System.out.println("task 9 : " + mathBolmSayısı(unv));
        System.out.println("\n   ***   ");
        System.out.println("task 10 : " + ogrcSayisi571BykMaxNotort(unv));
        System.out.println("\n   ***   ");
        System.out.println("task 11 : " + ogrcSayisi1071AzMinnotOrt(unv));
        System.out.println("\n   ***   ");

    }

    public static List<Universite> enAzOgrcSaysi2Unv(List<Universite> unv) {
        return unv.
                stream().
                sorted(Comparator.comparing(Universite::getOgrSayisi)).
                limit(2).
                skip(1).
                collect(Collectors.toList());

    }
    //task 07--> notOrt 63 'den buyuk olan universite'lerin ogrc sayilarini toplamini print ediniz.

    public static int notOrt63BykUnvOgrcSayisiTopla(List<Universite> unv) {
        return unv.
                stream().
                filter(t -> t.getNotOrt() > 63).
                map(t -> t.getOgrSayisi()).
                // reduce(Integer::sum);
                // reduce(Math::addExact);
                        reduce(0, (t, u) -> t + u);

    }

    public static int notOrt63BykUnvOgrcSayisiToplaToInt(List<Universite> unv) {
        return unv.
                stream().
                filter(t -> t.getNotOrt() > 63).
                mapToInt(t -> t.getOgrSayisi()).
                sum();
        // mapToInt() --> bu method akısdaki elemanların data type'nı
        // parameterisindeki() degere göre Int data type update eder

    }

    //task 08--> Ogrenci sayisi 333'dan buyuk olan universite'lerin notOrt'larinin ortalamasini bulunuz.
    public static OptionalDouble ogrcSayisi333BykNotOrtOrtlamaAl(List<Universite> unv) {

        return unv.
                stream().
                filter(t -> t.getOgrSayisi() > 333).
                mapToDouble(t -> t.getNotOrt()).//
                        average();//akısdakş elamnalrın ortlaması alındı
        // mapToDouble() --> bu method akısdaki elemanların data type'nı
        // parameterisindeki degere göre dooble data type update eder

    }

    //task 09-->"matematik" bolumlerinin sayisini  print ediniz.
    public static int mathBolmSayısı(List<Universite> unv) {
        return (int) unv.
                stream().
                filter(t -> t.getBolum().contains("mat")).
                count();//akısdaki elelman sayısını return eder
        //count();-->akısdaki elelman sayısını return eder

    }

    //task 10-->Ogrenci sayilari 571'dan fazla olan universite'lerin en buyuk notOrt'unu bulunuz.
    public static OptionalInt ogrcSayisi571BykMaxNotort(List<Universite> unv) {
        return unv.
                stream().//akıs
                        filter(t -> t.getOgrSayisi() > 571).//unv obj akısı fittrelendi
                        mapToInt(t -> t.getNotOrt()).//akısdaki unv obj notOrt akısı olarak update edildi
                        max();   //akısın en byk degerini return eder

    }

    //task 11-->Ogrenci sayilari 1071'dan az olan universite'lerin en kucuk notOrt'unu bulunuz.
    public static OptionalInt ogrcSayisi1071AzMinnotOrt(List<Universite> unv) {
        return unv.
                stream().
                filter(t -> t.getOgrSayisi() < 1071).
                mapToInt(t -> t.getNotOrt()).
                min();

    }
}
