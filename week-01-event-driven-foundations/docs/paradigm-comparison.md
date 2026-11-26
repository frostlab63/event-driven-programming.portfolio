# Activity 3 — Paradigm comparison

| Question | Procedural calculator | Event-driven calculator |
|---|---|---|
| Who controls the sequence? | The program asks for input in a fixed order. | The user chooses which event happens next. |
| Can the user calculate again? | Not without another loop or restart. | Yes; the window remains active. |
| Main state | Local variables inside `main`. | Fields updated by handlers. |
| Failure mode | Invalid input interrupts the linear path. | Each event handler must preserve a valid state. |

The procedural version is simpler for a single transaction. The event-driven version is a better fit for a GUI because it does not assume when the next action will occur.
