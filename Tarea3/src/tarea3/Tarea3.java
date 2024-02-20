package tarea3;

public class Tarea3 {

    public static void main(String[] args) {
        Person firstPerson = new Person("Milka", 18, "Woman");
        Person SecondPerson = new Person("Eduardo", 18, "Men");
        Person ThirdPerson = new Person("Luis", 21, "Men");
        Person FourthPerson = new Person("Mariana", 21, "Woman");

        System.out.println("***FIRST PERSON***");
        firstPerson.getPersonInfo();
        System.out.println("");
        System.out.println("***SECOND PERSON***");
        SecondPerson.getPersonInfo();
        System.out.println("");
        System.out.println("***THIRD PERSON***");
        ThirdPerson.getPersonInfo();
        System.out.println("");
        System.out.println("***FOURTH PERSON***");
        FourthPerson.getPersonInfo();

        System.out.println("");
        System.out.println("///////////////////////////////////////////////////////////////////////////");
        System.out.println("///////////////////////////////////////////////////////////////////////////");
        System.out.println("");

        Books FirtBook = new Books();
        System.out.println("***FIRT BOOK***");

        System.out.println(FirtBook.name);
        System.out.println(FirtBook.author);
        System.out.println(FirtBook.publicationdate);
        System.out.println("");
        System.out.println("***SECOND BOOK***");

        Books SecondBook = new Books();
        SecondBook.name = "Don Quijote De La Mancha";
        SecondBook.author = "Miguel De Cervantes";
        SecondBook.publicationdate = "02/11/1605";

        System.out.println(SecondBook.name);
        System.out.println(SecondBook.author);
        System.out.println(SecondBook.publicationdate);
        System.out.println("");
        System.out.println("***THIRD BOOK***");

        Books ThirdBook = new Books();
        ThirdBook.name = "Negocios Chidos Con Luisito";
        ThirdBook.author = "Luis Arturo Arguello Escutia";
        ThirdBook.publicationdate = "10/12/2020";

        System.out.println(ThirdBook.name);
        System.out.println(ThirdBook.author);
        System.out.println(ThirdBook.publicationdate);
        System.out.println("");
        System.out.println("***FOURTH BOOK***");

        Books FourthBook = new Books();
        FourthBook.name = "La Razon de Estar Contigo";
        FourthBook.author = "Bruce Cameron";
        FourthBook.publicationdate = "20/06/2016";

        System.out.println(FourthBook.name);
        System.out.println(FourthBook.author);
        System.out.println(FourthBook.publicationdate);

        System.out.println("");
        System.out.println("///////////////////////////////////////////////////////////////////////////");
        System.out.println("///////////////////////////////////////////////////////////////////////////");
        System.out.println("");

        Rectangulo firstRectangle = new Rectangulo(12, 21);
        Rectangulo SecondRectangle = new Rectangulo(32, 90);
        Rectangulo ThirdRectangle = new Rectangulo(5, 9);
        Rectangulo FourthRectangle = new Rectangulo(3, 10);

        System.out.println("***FIRST RECTANGLE***");
        firstRectangle.getRectangleInfo();
        System.out.println("");
        System.out.println("***SECOND RECTANGLE***");
        SecondRectangle.getRectangleInfo();
        System.out.println("");
        System.out.println("***THIRD RECTANGLE***");
        ThirdRectangle.getRectangleInfo();
        System.out.println("");
        System.out.println("***FOURTH RECTANGLE***");
        FourthRectangle.getRectangleInfo();
        

    }

}
