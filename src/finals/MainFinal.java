package finals;

public class MainFinal {
    //GETTERS AND SETTERS
    String name;
    int age;

    //ACCESS MODIFIERS
    String defaultMessage = "test run, nothing to announce";
    public String publicServiceAnnouncment = "Martial Law declared good luck";
    protected String protectedAnnouncment = "Martial Law not declared, it was a prank bro";
    private String privateAnnouncment = "Just kidding, it wasn't a prank, martial law is actually declared. Lock and Load.";

    public static void main(String[] args) {

        //METHODS

        /*int a = 5;
        int b = 10;
        System.out.println(a * b);

        int c = 2;
        int d = 3;
        System.out.println(c * d);

        int e = 6;
        int f = 8;
        System.out.println(e * f);*/
        //instead of that use methods

        multiply(5, 10);
        divide(6, 8);
        //System.out.println("Welcome to the end!);
        //Method version of printing something is this...
        welcome();

        //CLASSES AND OBJECTS

        /*finals.Final bio = new finals.Final();
        bio.firstName = "Barney";
        bio.lastName = "N/A";
        bio.occupation = "Philosopher";
        bio.IQ = 220;
        bio.age = 13000;
        bio.fictional = true;
        System.out.println(bio.firstName);*/

        //CONSTRUCTORS

        Final bio2 = new Final("Elmo", "Crime Lord");
        //for barney
        Final bio = new Final("Barney", "Philosopher");
        //for fun
        Final bio3 = new Final("Big Bird", "Mercenary");

        //DATA TYPES
        //see notes

        //STATIC AND DYNAMIC ARRAYS
        //notes

        //GETTERS AND SETTERS
        MainFinal Stephanus = new MainFinal();
        Stephanus.happyBirthday("Stephanus Maximus");
        MainFinal Nacho = new MainFinal();
        Nacho.age = 35;
        Nacho.name = "Libre";
        System.out.println(Nacho.name);
        System.out.println(Nacho.age);
        Nacho.printInfo();
        Nacho.setName("Esqueleto");
        Nacho.setAge(34);
        System.out.println("Mr. " + Nacho.getName() + " is " + Nacho.getAge());

        //METHOD OVERLOADING
        //change the data type in the methods and it will work
        //that's it...
        int result = addNumber(5, 10);
        double result2 = addNumber(6, 10);
        System.out.println(result);
        System.out.println(result2);

        //ACCESS MODIFIERS
        MainFinal c = new MainFinal();
        System.out.println(c.defaultMessage); //must be within same package
        System.out.println(c.publicServiceAnnouncment);//anyone can access it
        System.out.println(c.protectedAnnouncment); //accessible to different class in different package
                                                    // as long as that class is subclass of the class that owns protected message
        System.out.println(c.privateAnnouncment); //only that same class can access that info

        //INTERFACES
        //refer to queue and stack interface class files
        //interface = template that can be applied to a class
        //similar to inheritance but specifies what a class has or must do
        //classes can apply more than one interface, inheritance is limited to one

    }

    public static void multiply(int a, int b) {
        System.out.println(a * b);
    }

    public static void welcome() {
        System.out.println("Welcome to the end!");
    }

    public static void divide(int e, int f) {
        System.out.println(e / f);
    }

    public static void happyBirthday(String name) {
        System.out.println("Happy birthday " + name + "!");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    public void printInfo() {
        System.out.println("Mr. " + name + " is " + age + " years old.");
    }

    public static int addNumber(int a, int b) {
        return a + b;
    }

    public static double addNumber(double a, double b) {
        return a + b;
    }

}


