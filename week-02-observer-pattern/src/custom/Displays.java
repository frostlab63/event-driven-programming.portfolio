package custom;
public final class Displays { private Displays(){} public static DataObserver label(){return v->System.out.println("Label shows: "+v);} public static DataObserver chart(){return v->System.out.println("Bar height: "+v);} public static DataObserver logger(){return v->System.out.println("LOG value="+v);} }
