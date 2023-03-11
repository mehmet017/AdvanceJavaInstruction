package Bounding;
//parametre olarak aldigimiz data tipini sinirladirabilirsiniz
//bu classta sadece Number'in alt sınıfları kullanilsin
public class GenericUpperBound<T extends Number> {
    //T:Integer, Double, Long, Float, Number; class'i ustten sinirlandirdik

    private  T[] numberArray;// field, ozellik

    public GenericUpperBound(T[] numberArray) {
        this.numberArray = numberArray;
    }

    //numberArray icindeki degerlerin ortalamasını bulan method
    public double getAvarage(){
        double sum =0;
        for (T t:this.numberArray) {
            sum+=t.doubleValue();
        }
        double avg = sum/this.numberArray.length;
        return avg;
    }
    //main-method
    public static void main(String[] args) {
        Integer [] intArr = {2,3,5,99};
        Double [] doubleArr = {2.3,5.5,88.9};
        String [] strArr = {"Generic","tipleri","ustten","sinirlandirabilirsiniz"};


        GenericUpperBound<Integer> obj1 = new GenericUpperBound<>(intArr);
        System.out.println(obj1.getAvarage());


        GenericUpperBound<Double> obj2 = new GenericUpperBound<>(doubleArr);
        System.out.println(obj2.getAvarage());

        //GenericUpperBound<String> obj3 = new GenericUpperBound<>(strArr);
        //CTE data tipini number ile sinirlandirgimiz icin musade etmedi




    }

}
