# event-driven-programming.portfolio

A working portfolio for **RBCS 7312 Event-Driven Programming in Java**. The repository follows the ten-week course progression from event sources and listeners to a JavaFX/MySQL University Management System.

This is intentionally a code-first portfolio. The documentation explains the decisions behind the code, but the examples are small enough to read rather than merely run.

## Learning path

| Week | Focus | Main implementation |
|---|---|---|
| 1 | Event-driven foundations | Swing calculator, event map, paradigm comparison |
| 2 | Observer pattern | Weather station and custom notification model |
| 3 | Swing foundations | EDT-safe Student Portal layout |
| 4 | Swing event handling | Interactive registration form |
| 5 | Advanced Swing | Multi-pane file explorer with renderers |
| 6 | JavaFX foundations | Programmatic and FXML layouts |
| 7 | JavaFX events | Filters, handlers, drag/drop, custom events |
| 8 | JavaFX properties | Reactive model and bindings |
| 9 | Asynchronous JavaFX | Task, Service, cancellation, progress |
| 10 | Integrated capstone | MySQL-backed University Management System |

## Run the plain Java/Swing examples

```bash
javac $(find week-01-event-driven-foundations week-02-observer-pattern week-03-swing-foundations week-04-swing-event-handling week-05-advanced-swing -name '*.java')
java -cp week-01-event-driven-foundations/src EventDrivenCalculator
java -cp week-02-observer-pattern/src ObserverDemo
```

JavaFX modules use Maven. Open the module README for the exact command. Week 10 additionally requires a local MySQL database configured through environment variables; no credentials belong in this repository.

## Authenticity note

The reflections in this repository are implementation notes: they describe concrete choices, trade-offs, and observed behavior in these examples. They are not presented as a substitute for a student's own lab record. Before academic submission, I would add my own run dates, screenshots where required, and any mistakes I encountered while working through the exercises.

## Repository map

- `docs/` contains the outcome map, design notes, and verification record.
- `week-01...week-09/` contain focused implementations that isolate one idea at a time.
- `week-10-university-management-system/` is the deeper integrated project.
- `sql/` contains the course-aligned schema and seed data.
