package com.beloin.domain.syntax.interperter.token.parsers;

public class HandlerContext {
    private int currentPosition;

    public HandlerContext(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }
}
