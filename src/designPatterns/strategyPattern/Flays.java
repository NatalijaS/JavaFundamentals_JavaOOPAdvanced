package designPatterns.strategyPattern;

public interface Flays {

    // The interface is implemented by many other
    // subclasses that allow for many types of flaying
    // without effecting Animal, or Flays.
    // Classes that implement new Flays interface
    // subclasses can allow other classes to use
    // that code eliminating code duplication
    // I'm decoupling : encapsulating the concept that varies
    String fly();
}

// Class used if the Animal can fly
class ItFlays implements Flays {
    public String fly() {
        return "Flying High";
    }
}

//Class used if the Animal can't fly
class CantFlay implements Flays {
    public String fly() {
        return "I can't fly";
    }
}

