# Activity 4 — Bug fixes

| Bug | Symptom | Root cause | Repair used in the portfolio |
|---|---|---|---|
| Blocking EDT | Window stops repainting during work | `Thread.sleep` runs in the action handler | Move work to a worker and marshal the result back to the EDT |
| Missing listener | Button appears but does nothing | No `ActionListener` was registered | Register a handler at construction time |
| Wrong thread | UI is updated from a worker | Swing components are not worker-thread state | Use `SwingUtilities.invokeLater` |
| Retained references | Removed controls remain reachable | Collection still owns old buttons | Clear the collection when controls are removed |

These are not four unrelated mistakes. They all come from treating a GUI as if it were a sequence of ordinary console statements.
