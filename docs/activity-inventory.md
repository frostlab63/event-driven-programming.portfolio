# RBCS 7312 activity inventory

This inventory is the traceability layer between the course packet and the repository. It distinguishes a required activity from a representative sample. A reviewer can use it to move from an outcome to a file, a command, and a recorded result.

**Status vocabulary:** `Implemented` means source and documentation are present; `Build-verified` means the source compiled in this environment; `Desktop-check` means the interaction still needs a local GUI session; `Database-check` means it requires MySQL credentials and the supplied schema.

## Week 1 — Foundations

| Activity | Evidence | Status |
|---|---|---|
| Spot the components | `docs/event-components.md` | Implemented |
| Build the event loop | `docs/event-loop-reflection.md` | Implemented |
| Procedural vs event-driven calculators | `src/procedural/ProceduralCalculator.java`, `src/EventDrivenCalculator.java`, `docs/paradigm-comparison.md` | Build-verified |
| Debug the event handler | `src/bugfix/`, `docs/BugFixes.md` | Build-verified |
| Design a system and prototype | `docs/SystemDesign.md`, `src/SmartHomePrototype.java` | Build-verified; Desktop-check |
| Self-assessment and summary | `docs/self-assessment.md`, `docs/summary.md` | Implemented |

## Week 2 — Observer pattern

| Activity | Evidence | Status |
|---|---|---|
| Weather station | `src/ObserverDemo.java` and observer classes | Build-verified |
| Legacy Observer evaluation | `src/legacy/LegacyObserverDemo.java`, `docs/LegacyLimitations.md` | Build-verified |
| Refactoring to a custom observer | `src/custom/`, `docs/refactoring-notes.md` | Build-verified |
| Notification comparison | `src/property/PropertyChangeDemo.java`, `docs/Comparison.md` | Build-verified |
| Self-assessment and summary | `docs/self-assessment.md`, `docs/summary.md` | Implemented |

## Weeks 3–5 — Swing evidence

The source examples are intentionally separated by the learning emphasis rather than being hidden in one large application.

| Week | Required evidence | Repository evidence | Status |
|---|---|---|---|
| 3 | Window, components, layouts, EDT, static UI | `BasicWindow.java`, `StudentPortal.java`, `EdtCheck.java`, weekly checklist | Build-verified; Desktop-check |
| 4 | Action/item/document listeners and interactive application | `RegistrationForm.java`, `ListenerTechniques.java`, weekly checklist | Build-verified; Desktop-check |
| 5 | Lists, tables, trees, renderer, menus, dialogs, navigation | `FileExplorer.java`, `ComponentModelDemo.java`, weekly checklist | Build-verified; Desktop-check |

## Weeks 6–9 — JavaFX evidence

| Week | Required evidence | Repository evidence | Status |
|---|---|---|---|
| 6 | Stage/Scene/Node, layouts, FXML/controller structure | `week-06-javafx-foundations` | Build-verified; Desktop-check |
| 7 | Action/key/mouse events, filters/handlers, custom event design | `week-07-javafx-events` including `CustomEventDemo` | Build-verified; Desktop-check |
| 8 | Properties, listeners, unidirectional/bidirectional bindings | `week-08-javafx-bindings` including `ListenerDemo` | Build-verified; Desktop-check |
| 9 | Blocking demonstration, Task/Service, safe updates, progress/cancel | `week-09-javafx-asynchronous` including `FreezeDemo` | Build-verified; Desktop-check |

## Week 10 — University Management System

| Requirement | Evidence | Status |
|---|---|---|
| MySQL schema and relationship | `sql/schema.sql` | SQL-reviewed; Database-check |
| Environment-based connection | `DatabaseUtil.java` | Build-verified |
| Observable student/program model | `Student.java`, `Program.java` | Build-verified |
| Named background load task | `LoadStudentsTask.java` | Build-verified |
| Named background save task | `SaveStudentTask.java` | Build-verified |
| FXML shell and navigation | `main-view.fxml`, `MainController.java` | Build-verified; Desktop-check |
| Email and program selection | `student-view.fxml`, `StudentController.java`, `StudentDao.java` | Build-verified; Database-check |
| Visible scheduled refresh | `App.java`, status label and reload callback | Build-verified; Desktop-check |
| Clean setup and run record | `docs/setup-and-acceptance.md` | Implemented; Database-check |

## Honest limits

The repository records build results that were actually obtained in the sandbox. Swing and JavaFX windows cannot be treated as visually verified merely because they compile. The remaining desktop checks are marked explicitly instead of being presented as completed evidence. The same rule applies to MySQL: a successful Maven build is not a successful database acceptance test.
