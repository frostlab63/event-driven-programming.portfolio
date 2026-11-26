# Week 10 — University Management System

This is the portfolio centrepiece. It follows the course specification: JavaFX for the client, FXML for the view, JavaFX properties in the model, MySQL for persistence, JDBC behind a database utility, a background `Task` for database work, and a scheduled heartbeat for time-driven events.

## Setup

1. Create a MySQL database with `sql/schema.sql`.
2. Export `DB_URL`, `DB_USER`, and `DB_PASSWORD` in your shell. Defaults are intentionally absent.
3. Run `mvn javafx:run`.

The source is structured so the UI does not own SQL. `StudentDao` owns persistence, `Student` owns observable state, and `StudentController` coordinates user events with background work.
