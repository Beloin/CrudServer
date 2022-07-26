package com.beloin.domain.syntax.interperter.token.parsers;

import com.beloin.domain.exceptions.DomainException;
import com.beloin.domain.syntax.interperter.token.TokenType;

public abstract class AbstractTokenHandler implements TokenParserHandler {
    protected TokenParserHandler successor;

    public AbstractTokenHandler(TokenParserHandler successor) {
        this.successor = successor;
    }

    public AbstractTokenHandler() {
    }

    abstract public TokenType handle(String token) throws DomainException;

    @Override
    public TokenType successor(String token) throws DomainException {
        if (successor != null) {
            return successor.handle(token);
        }

        // THIS EXCEPTION SHOULD NEVER TROW;
        throw new DomainException("Token Not Found.");
    }

    public void setSuccessor(TokenParserHandler successor) {
        this.successor = successor;
    }

}
