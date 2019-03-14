import java.time.LocalDate;
import java.util.*;

public class CarPark {
static Set<Car> autoPark = new TreeSet<Car>();

Date date;

    public static void main(String[] args) {
        Car c1 = new Car(1,"Tom");
        Car c2 = new Car(2,"JAck");
        Car c3 = new Car (3,"Tom");

        getOwnerCars(autoPark);
    }
public static void comeIn(Car car1, String date1){
   car1.time.put(date1,null);
    autoPark.add(car1);
}
public static void getTime(Date date1, Date date2){
    Map<Car,Long> list = new TreeMap<>();
    for(Car temp:autoPark){
        long result=0;
        for(Map.Entry<Date,Date> t:temp.time.entrySet()){

           if( t.getKey().after(date1)&&t.getKey().before(date2)){
               result = result+(date2.getTime()-date1.getTime())/3600;
           }

        }
        list.put(temp,result);
    }
    System.out.println(list);
}
public static void getOwnerCars(Set<Car> autoPark){

  for(Car temp:autoPark){
   String  t = temp.ownerName;
      System.out.println(temp.ownerName);
     if(autoPark.contains(t)){
          System.out.println(temp+temp.ownerName);
      }
  }

}
public static void comeOut(Car car1, Date date2){
   for(Map.Entry<Date,Date> temp:car1.time.entrySet()){
       if(temp.getValue()==null){
           car1.time.put(temp.getKey(),new Date());
       }
    }
}
}
 class Car implements Comparable<Car>{
    Map<Date, Date> time  = new TreeMap<>();



    int carNumber=0;

String ownerName;

     public Car(int carNumber, String ownerName) {
         this.carNumber = carNumber;
         this.ownerName = ownerName;
     }

     @Override
     public int compareTo(Car o) {
         return this.carNumber-o.carNumber;
     }


     class Owner{
        String name;

         public Owner(String name) {
             this.name = name;
         }
     }
}