package com.beloin.domain.syntax.interperter.token.parsers;

import com.beloin.domain.exceptions.DomainException;
import com.beloin.domain.syntax.interperter.token.TokenType;

import java.util.Objects;

public class ModelTokenHandler extends AbstractTokenHandler {
    public ModelTokenHandler(TokenParserHandler successor) {
        this.successor = successor;
    }

    public ModelTokenHandler() {
    }

    private static final String MODEL = "model";

    private TokenParserHandler successor;
    @Override
    public TokenType handle(String token) throws DomainException {
        if (Objects.equals(token, MODEL)) {
            return TokenType.MODEL;
        }

        return this.successor(token);
    }

    @Override
    public TokenType successor(String token) throws DomainException {
        if (successor != null) {
            return successor.handle(token);
        }

        // THIS EXCEPTION SHOULD NEVER TROW;
        throw new DomainException("Token Not Found.");
    }

    @Override
    public void setSuccessor(TokenParserHandler successor) {
        this.successor = successor;
    }
}
