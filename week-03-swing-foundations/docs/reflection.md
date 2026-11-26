# Week 3 — Swing reflection

The important Week 3 boundary is the EDT. A static screen can still be wrong if it creates components on an arbitrary thread. The `EdtCheck` program makes the rule observable instead of leaving it as a comment.
