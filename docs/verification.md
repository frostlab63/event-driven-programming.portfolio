# Verification record

This file records checks actually executed during the current verification pass rather than only suggested commands.

- **Date:** 27 November 2026
- **Verification owner:** Joshua Otieno Calvary
- **Execution:** assistant-run verification in the Manus sandbox on the owner's behalf
- **Runtime evidence:** [`docs/evidence/runtime-verification.md`](evidence/runtime-verification.md)

## Passed checks

### Plain Java and Swing source verification

All Java sources from Weeks 1–5 compiled with JDK 21 into a temporary output directory. The following demonstrations then ran successfully:

- `ObserverDemo` printed the current reading, hot-day warning, and remaining observer count.
- `custom.RefactoredMain` notified the label, chart, and logger observers for values 10 and 20.
- `property.PropertyChangeDemo` printed both property transitions: `null -> Alice` and `Alice -> Bob`.
- `procedural.ProceduralCalculator` evaluated the sample input `6 * 7` and printed `Result: 42.0`.

A Swing runtime smoke test also launched `EventDrivenCalculator` under Xvfb. The captured window is [`swing-event-driven-calculator.png`](evidence/swing-event-driven-calculator.png).

### Maven package verification

Each JavaFX/capstone module completed a clean package with `mvn -q -DskipTests clean package`:

- Week 6 — JavaFX foundations
- Week 7 — JavaFX events
- Week 8 — JavaFX properties and bindings
- Week 9 — JavaFX asynchronous programming
- Week 10 — University Management System capstone

### Database and DAO verification

A temporary MariaDB 10.11 service was started for this verification pass. The repository's exact `sql/schema.sql` was applied successfully. A temporary verification account was used only through environment variables.

The real `StudentDao` completed this sequence:

1. Loaded the two seeded programs.
2. Inserted a uniquely identified student containing registration number, name, email, and program.
3. Read the inserted student back through `findAll()`.
4. Deleted the temporary verification row.

The resulting schema contained the expected `programs` and `students` tables. No repository credential or secret was added.

### JavaFX runtime verification

The following applications launched successfully under Xvfb using the JavaFX module path:

- Week 9 `AsyncDemo`; screenshot captured with the Start work, Cancel, progress, and status controls visible.
- Week 10 `portfolio.capstone.App`; screenshot captured after the FXML shell loaded and database-backed students view initialized. The visible `Auto-refresh completed` status confirms the scheduled refresh callback ran while the window was open.

See [`runtime-verification.md`](evidence/runtime-verification.md) for the evidence index and provenance statement.

## Repository hygiene and synchronization

The final pass must continue to confirm the following before publication:

```bash
git diff --check
# inspect for credential-like assignments and private-key material
git fetch origin
git status --short --branch
git rev-parse HEAD
git rev-parse origin/main
```

The repository is expected to contain no compiled classes or Maven `target` directories after cleanup. The local `main` branch must match `origin/main` before the verification commit is pushed.

## Remaining personal-device checks

The sandbox evidence is not a substitute for a personal local-device sign-off. If Joshua wants the portfolio to state that he personally verified it locally, he should repeat the commands in the setup documents on his own machine and confirm the following:

- keyboard focus and visual layout on his desktop;
- Swing and JavaFX control interaction;
- saving a student from the visible Week 10 form;
- observing the table reload after the asynchronous save; and
- observing the five-second scheduled refresh.

Until that confirmation is made, the repository should use the more precise wording: **runtime verified in the stated sandbox on behalf of Joshua Otieno Calvary; personal local-device verification pending**.
