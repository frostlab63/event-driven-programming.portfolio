# Legacy Observer limitations

`java.util.Observable` and `java.util.Observer` are retained here only as a historical comparison. The subject must extend a class, which consumes Java's single inheritance slot. The notification API also exposes a weakly typed `Object` payload, and the pull-style design makes it easy for an observer to depend on mutable subject state. The types were deprecated in Java 9.

The custom interfaces in `src/custom` avoid those constraints and make registration/removal explicit.
