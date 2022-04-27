package day01;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Praxis {

    public static void main(String[] args) {
        LinkedList<String> ll1 = new LinkedList<>(Arrays.asList("haluk", "ipek", "harun", "irem"));

        /*  TASK:
                 Node'larin değereleri; "haluk" "ipek" "harun" "irem" olan bir LinkedList olusturun
                 Kullanicidan bir isim alin o isim LinkedList'de varsa silin ve kullaniciya
                "Bu isim LinkedList'de vardi ve silindi" diye mesaj verin
                 Girilen isim yoksa "Bu isim LinkedList'de yok bu yuzden silinemedi" diye mesaj verin

         */

        Scanner scan = new Scanner(System.in);
        System.out.print("isim giriniz : ");
        String isim = scan.nextLine().toLowerCase();

        System.out.println(ll1.removeIf(v -> v.contains(isim)) ?
                "Bu isim LinkedList'de vardi ve silindi":
                "Bu isim LinkedList'de yok bu yuzden silinemedi");
        System.out.println(ll1);

    }


}
