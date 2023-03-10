package Generics.classes;

import java.util.ArrayList;
import java.util.List;

public class RunnerGeneric {
    //Generics ile hangi data tipini kullanacagimizi karar verebiliriz.
    //Java 7 ile sag tarafta data tipi yazmaya gerek kalmadi
    public static void main(String[] args) {
        GenericClass<String> object1 = new GenericClass<>();
        object1.setType("Generic Class");


        //GenericClass<String> object2 = new GenericClass<>();
        //object2.getType(65);//CTE verdi, String gerekli, int verdik

        GenericClass<Integer> object3 = new GenericClass<>();
        object3.setType(65);
        int n = object3.getType();//CASTING e gerek kalmadı

        List<String> list = new ArrayList<>();
        list.add("Mursel");
        list.add("Ebubekir");
        //list.add(100);//String tipinde oldugunu belirttik.

        //list.get(2);
        //list.get(3); //ClassCastException'dan kurtulduk




    }

}
