package custom;
public final class RefactoredMain { public static void main(String[] args){ DataModel model=new DataModel(); model.addObserver(Displays.label()); model.addObserver(Displays.chart()); model.addObserver(Displays.logger()); model.setValue(10); model.setValue(20); } }
