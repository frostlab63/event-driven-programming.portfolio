# Event notification comparison

| Mechanism | Strength | Limitation | Best fit here |
|---|---|---|---|
| Custom observer | Typed domain event and explicit lifecycle | We own thread-safety and removal | Plain Java domain model |
| `java.util.Observer` | Familiar legacy API | Deprecated, weakly typed, inheritance constraint | Reading old code only |
| `PropertyChangeListener` | Carries old and new values | Bean-oriented ceremony | Swing/JavaBeans integration |
| JavaFX bindings | Reactive UI integration | Tied to JavaFX properties | JavaFX model-to-view updates |

My choice is not “one mechanism everywhere.” The mechanism should match the boundary: domain notifications stay explicit, while a JavaFX screen benefits from bindings.
