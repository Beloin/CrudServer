package com.beloin.domain.syntax.interperter;

public record CrudToken(TokenType type, String text, int startPos) {

    public TokenType getType() {
        return type;
    }

    public String getText() {
        return text;
    }

    public int getStartPos() {
        return startPos;
    }
}
