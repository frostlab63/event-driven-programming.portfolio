# Verification record

This file records executed checks, not only suggested commands. The date below reflects the current remediation pass.

## Executed successfully

- Plain Java/Swing sources compiled with JDK 21 using `javac`.
- `ObserverDemo` ran and printed the current reading, warning, and remaining observer count.
- Week 6 JavaFX Maven package completed successfully.
- Week 7 JavaFX Maven package completed successfully.
- Week 8 JavaFX Maven package completed successfully.
- Week 9 JavaFX Maven package completed successfully.
- Week 10 JavaFX/MySQL Maven package completed successfully without requiring database credentials.

## Repeatable commands

```bash
find week-01-event-driven-foundations week-02-observer-pattern   week-03-swing-foundations week-04-swing-event-handling week-05-advanced-swing   -name '*.java' -print0 | xargs -0 javac
java -Djava.awt.headless=true -cp week-02-observer-pattern/src ObserverDemo

for d in week-06-javafx-foundations week-07-javafx-events   week-08-javafx-bindings week-09-javafx-asynchronous   week-10-university-management-system; do
  (cd "$d" && mvn -q -DskipTests package)
done
```

## Still requiring a desktop or database session

- Clicking through Swing and JavaFX controls.
- Checking visual layout and keyboard focus behavior.
- Running `sql/schema.sql` against a local MySQL instance.
- Saving a student through the capstone and observing the table refresh.
- Confirming the five-second scheduled refresh while the UI is open.

These are marked as pending rather than silently inferred from compilation.
