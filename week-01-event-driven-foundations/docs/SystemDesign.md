# Activity 5 — Smart Home Controller design

## Event sources

1. Light toggle — user requests a light state change.
2. Security toggle — user arms or disarms the system.
3. Door sensor button — prototype event representing a physical sensor.
4. Event log — records the response to each event.
5. Status label — displays the current system state.

## Event flow

```text
User action -> Swing component -> ActionEvent -> EDT queue -> handler -> state/log update
```

## Risks and controls

- A real sensor may emit repeated events; debounce or coalesce them.
- An alarm action must not block the EDT; send notifications asynchronously.
- Security state should be persisted by a trusted service rather than inferred from label text.

The working prototype is `src/SmartHomePrototype.java`.
