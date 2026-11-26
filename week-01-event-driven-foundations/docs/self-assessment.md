# Week 1 self-assessment

1. An event is a state change or occurrence, such as a click or timer expiry.
2. An event source produces the occurrence; a button and a sensor are examples.
3. A listener waits for a relevant event; `ActionListener` is a Swing example.
4. A handler is the code that decides what to do after dispatch.
5. The event loop removes queued events and sends them to handlers.
6. Procedural code owns a fixed sequence; event-driven code reacts to externally timed input.
7. A GUI should not block its event thread because painting and input share that thread.
8. The EDT is Swing's event-processing thread.
9. Five examples are ATM, microwave, traffic lights, online shopping, and a smart home.

## Honest reflection

The part I find easiest to underestimate is the event queue. It is invisible when the handlers are short, so the application feels direct. The freeze demonstration makes the mechanism obvious: the queue is still there, but the thread that should drain it is busy. That connection is more convincing to me than memorising the words “event loop.”
