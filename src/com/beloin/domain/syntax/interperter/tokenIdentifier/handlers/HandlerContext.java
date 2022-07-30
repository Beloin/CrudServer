package com.beloin.domain.syntax.interperter.tokenIdentifier.handlers;

public class HandlerContext {
    private int currentPosition;

    public HandlerContext(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }
}
