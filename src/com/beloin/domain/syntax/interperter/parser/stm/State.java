package com.beloin.domain.syntax.interperter.parser.stm;

import com.beloin.domain.syntax.interperter.CrudToken;

import java.util.Objects;

// ClassIndex.getAnnotated(com.test.YourCustomAnnotation.class)
public abstract class State {
    public State() {
        this.name = this.getClass().getName();
    }
    public State(String name) {
        this.name = name;
        this.isFinalState = false;
    }
    public State(boolean isFinalState) {
        this.isFinalState = isFinalState;
        this.name = this.getClass().getName();
    }
    public State(String name, boolean isFinalState) {
        this.name = name;
        this.isFinalState = isFinalState;
    }
    private final String name;
    protected boolean isFinalState;

    public State addEvent(CrudToken event) {
        return this.receiveEvent(event);
    }

    public boolean isFinalState() {
        return isFinalState;
    }

    /**
     * Receives event and must return next (or current) state.
     * Should be implemented in order to choose
     *
     * @param event Event coming from STM
     * @return new State to STM
     */
    protected abstract State receiveEvent(CrudToken event);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof State state)) return false;
        return name.equals(state.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
