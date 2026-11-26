# Week 2 self-assessment

- A subject keeps observers because it is responsible for notifying every current subscriber.
- A custom subject needs registration, removal, and notification behavior.
- Removing observers matters because a long-lived subject can otherwise retain objects that the UI no longer uses.
- The legacy API is deprecated and has inheritance and typing limitations.
- Property-change events are useful when old and new values matter.
- JavaFX bindings are the most natural choice for a JavaFX view.

The implementation made the lifecycle issue concrete: notification is easy; deciding when a listener is no longer interested is the part that prevents leaks.
