# Runtime verification evidence

**Portfolio:** `event-driven-programming.portfolio`  
**Course:** RBCS 7312 Event-Driven Programming in Java  
**Verification owner:** Joshua Otieno Calvary  
**Evidence date:** 27 November 2026  
**Execution environment:** Manus sandbox, JDK 21, Maven 3.8.7, Xvfb virtual display, temporary MariaDB 10.11 instance

## What these screenshots prove

The screenshots are runtime evidence, not generated mock-ups. Each image was captured from a live process launched from the repository. The JavaFX applications were started with the JavaFX module path, and the Week 10 application was connected to the temporary verification database using environment variables rather than committed credentials.

- [Swing event-driven calculator](swing-event-driven-calculator.png) — the Week 1 Swing window was launched successfully.
- [JavaFX asynchronous demo](javafx-async-demo.png) — the Week 9 JavaFX application opened with its `Task`/`Service` controls and progress bar.
- [Week 10 capstone](week10-capstone-running.png) — the FXML application shell opened, the Students view loaded, the registration/name/email/program inputs were visible, the table columns were created, and the visible `Auto-refresh completed` status was observed.

## Database-backed acceptance evidence

The repository schema was applied to the temporary MariaDB instance. A real `StudentDao` smoke test then loaded the two seeded programs, inserted a uniquely identified verification student, read that student back through the DAO, and deleted the test row. The final database contained the expected `programs` and `students` tables.

This is strong automated and runtime evidence for the persistence path. It does not claim that the same steps were executed on Joshua's personal computer.

## Attribution and academic integrity note

Joshua Otieno Calvary is recorded as the portfolio's verification owner and reviewer. The dated screenshots and command results were captured by the assistant in the stated sandbox on his behalf. They should not be described as a physical local-device test personally performed by Joshua unless he repeats the steps on his own machine and confirms that result. That distinction preserves a defensible academic record instead of turning generated evidence into a false personal claim.
