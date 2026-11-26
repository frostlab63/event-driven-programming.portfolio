# Notification comparison

The custom observer is explicit: registration, removal, and notification are visible in the source. The old `java.util.Observer`/`Observable` API hides too much behind inheritance and has been deprecated. For JavaFX work, properties and bindings are a better fit because they carry both change information and UI integration.

My practical rule is simple: use a custom observer when the domain event is the point; use JavaFX bindings when the screen should follow model state automatically.
