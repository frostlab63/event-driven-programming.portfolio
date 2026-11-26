# Verification record

The first verification pass is deliberately command-based. GUI behavior still needs to be checked on a desktop session, but compilation catches naming, imports, and package mistakes early.

```bash
# Plain Java and Swing
find week-01-event-driven-foundations week-02-observer-pattern week-03-swing-foundations week-04-swing-event-handling week-05-advanced-swing -name '*.java' -print0 | xargs -0 javac

# JavaFX modules
for d in week-06-javafx-foundations week-07-javafx-events week-08-javafx-bindings week-09-javafx-asynchronous week-10-university-management-system; do (cd "$d" && mvn -q -DskipTests package); done
```

A database-connected capstone run additionally depends on local MySQL credentials and schema setup; the build itself must not require those credentials.
