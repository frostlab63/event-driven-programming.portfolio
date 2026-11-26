# Event map

| Source | Event | Listener | Handler |
|---|---|---|---|
| Number button | User clicks a digit | `ActionListener` | Append digit to display |
| Operator button | User chooses an operator | `ActionListener` | Save operand and operator |
| Equals button | User requests a result | `ActionListener` | Calculate or report division by zero |
| Clear button | User resets input | `ActionListener` | Restore initial calculator state |

The useful detail is that the calculator does not call `calculate()` from a fixed top-to-bottom script. It waits for input, then reacts. That is the practical difference between describing an event-driven program and merely giving one a GUI.
