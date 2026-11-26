# Activity 2 — Event loop reflection

The event queue holds work that has happened but has not yet been handled. The event loop removes an event, dispatches it to the relevant listener, and then returns for the next event. In Swing, the Event Dispatch Thread performs this work for GUI events.

A slow handler is therefore not just a slow method. It occupies the one thread responsible for painting and responding to input. The queue continues to accumulate events, but the user experiences a frozen window because none of those events can be processed. My practical conclusion is that the handler should acknowledge the event quickly and move expensive work to a worker thread, returning to the EDT only for the small UI update.
