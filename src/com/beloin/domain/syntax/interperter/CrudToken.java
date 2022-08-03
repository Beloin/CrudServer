package com.beloin.domain.syntax.interperter;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CrudToken crudToken)) return false;
        return startPos == crudToken.startPos && type == crudToken.type && text.equals(crudToken.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, text, startPos);
    }
}
