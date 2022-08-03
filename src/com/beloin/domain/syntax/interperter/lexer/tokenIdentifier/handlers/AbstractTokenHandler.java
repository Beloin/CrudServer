package com.beloin.domain.syntax.interperter.lexer.tokenIdentifier.handlers;

import com.beloin.domain.exceptions.DomainException;
import com.beloin.domain.syntax.interperter.TokenType;

public abstract class AbstractTokenHandler implements TokenIdentifierHandler {
    protected TokenIdentifierHandler successor;

    public AbstractTokenHandler(TokenIdentifierHandler successor) {
        this.successor = successor;
    }

    public AbstractTokenHandler() {
    }

    abstract public TokenType handle(String token, HandlerContext ctx) throws DomainException;

    @Override
    public TokenType successor(String token, HandlerContext ctx) throws DomainException {
        if (successor != null) {
            return successor.handle(token, ctx);
        }

        // THIS EXCEPTION SHOULD NEVER TROW;
        throw new DomainException("Token Not Found.");
    }

    public void setSuccessor(TokenIdentifierHandler successor) {
        this.successor = successor;
    }

}
