package custom;
import java.util.ArrayList; import java.util.List;
public final class DataModel implements DataSubject { private final List<DataObserver> observers=new ArrayList<>(); private int value; public void addObserver(DataObserver o){observers.add(o);} public void removeObserver(DataObserver o){observers.remove(o);} public void setValue(int v){value=v; observers.forEach(o->o.onDataChanged(value));} }
