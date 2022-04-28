package day02;

import day01.Lambda01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Praxis2 {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(Arrays.asList(4, 2, 6, 11, -5, 7, 3, 15));

        ciftElTopla(list);
    }
    public static void ciftElTopla(List<Integer> sayi) {
        List<Integer> list = new ArrayList<Integer>();
        Optional<Integer> deger = sayi.stream().filter(Lambda01::ciftBul).reduce(Math::multiplyExact);
        System.out.println(sayi.stream().filter(Lambda01::ciftBul).reduce(Math::multiplyExact));
        System.out.println(deger.get());
        int a=deger.get();
        System.out.println(a+10);

    }
}
