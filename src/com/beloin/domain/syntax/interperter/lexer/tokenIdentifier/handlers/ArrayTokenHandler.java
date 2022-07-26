package com.beloin.domain.syntax.interperter.lexer.tokenIdentifier.handlers;

import com.beloin.domain.exceptions.DomainException;
import com.beloin.domain.syntax.interperter.TokenType;

public class ArrayTokenHandler extends AbstractTokenHandler {
    public ArrayTokenHandler(TokenIdentifierHandler successor) {
        super(successor);
    }

    public ArrayTokenHandler() {
    }

    @Override
    public TokenType handle(String token, HandlerContext ctx) throws DomainException {
        if (token.equals(";")) {
            return TokenType.ARRAYTOKEN;
        }

        return this.successor(token, ctx);
    }

}
