package Encapsulation.FirstPackage;

public class Animal {

    private String privateField = "";
    protected String protectedField = "";
    String packagePrivateField = "";
    public String publicField = "";

    static int intStatic = 0;



    {
        //this is an initializing block - it is being executed when a class is created before all the class' constructors
        //when the class has more than one initializing blocks, then they will be executed in the declaration order
        //it can access both static either non-static fields and methods that are declared before the initializer block
        intStatic = 2;
        privateField = "a";
    }

    static {
        //this is a static initializing block - it is being executed once when the class is initialized - before all the class' constructors
        //when the class has more than one initializing blocks, then they will be executed in the declaration order
        //it can access only static fields and methods nevertheless of their declaration point
        intStatic = 3;
    }


}
