package portfolio.week07;
import javafx.event.Event; import javafx.event.EventType;
public final class CustomEvent extends Event { public static final EventType<CustomEvent> ORDER_PLACED=new EventType<>(Event.ANY,"ORDER_PLACED"); private final String orderId; public CustomEvent(String orderId){super(ORDER_PLACED);this.orderId=orderId;} public String orderId(){return orderId;} }
