package com.company;

interface Comparable {
    boolean lessThan(Comparable y);
}

abstract class  AbstractEvent implements Comparable {
    abstract void execute(AbstractSimulator simulator);
}

abstract class OrderedSet {
    abstract void insert(Comparable x);
    abstract Comparable  removeFirst();
    abstract int size();
    abstract Comparable remove(Comparable x);
}

class AbstractSimulator {
    OrderedSet events;
    void insert(AbstractEvent e) {
        events.insert(e);
    }
    AbstractEvent cancel(AbstractEvent e)  {
        throw new java.lang.RuntimeException("Method not implemented");
    }
}
abstract class Event extends AbstractEvent {
    double time;
    public boolean lessThan(Comparable y) {
        Event e = (Event) y;  // Will throw an exception if y is not an Event
        return this.time < e.time;
    }
}

class Simulator extends AbstractSimulator {
    double time;
    double now() {
        return time;
    }
    void doAllEvents() {
        Event e;
        while ( (e= (Event) events.removeFirst()) != null) {
            time = e.time;
            e.execute(this);
        }
    }
}

