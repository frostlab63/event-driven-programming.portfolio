# Working notes

I am treating this repository as a learning record, not as a polished product pretending that every example is production-ready. The early weeks deliberately keep classes small. That makes the event flow visible. The capstone is different: it earns more structure because the database, UI thread, and background work need clear boundaries.

One design choice I kept returning to was whether to hide everything behind abstractions. I decided not to. In Weeks 1–4, a little repetition makes the listener mechanics easier to see. In Week 10, repetition becomes a maintenance problem, so the code moves toward models, DAOs, and services.

The course asks for MySQL, so the capstone does not quietly replace it with an embedded database. The trade-off is setup effort. The benefit is that the final example demonstrates a real persistence boundary rather than a fake in-memory success path.
