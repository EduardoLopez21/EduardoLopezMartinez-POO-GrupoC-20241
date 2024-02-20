
package tarea3;


public class Tarea3 {

 
    public static void main(String[] args) {
        Person firstPerson = new Person("Milka", 18, "Woman");
        Person SecondPerson = new Person("Eduardo", 18, "Men");
        Person ThirdPerson = new Person ("Luis", 21, "Men");
        Person FourthPerson = new Person ("Mariana", 21, "Woman");
        
        System.out.println("***FIRST PERSON***");
        firstPerson.getPersonInfo();
        System.out.println("***SECOND PERSON***");
        SecondPerson.getPersonInfo();
        System.out.println("***THIRD PERSON***");
        ThirdPerson.getPersonInfo();
        System.out.println("***FOURTH PERSON***");
        FourthPerson.getPersonInfo();
        
        System.out.println("/////////////////////////////////////////////////");
        System.out.println("/////////////////////////////////////////////////");
        
        Books FirtBook = new Books();
        
        System.out.println(FirtBook.name);
        System.out.println(FirtBook.author);
        System.out.println(FirtBook.publicationdate);
    }
    
}
