package com.beloin.domain.syntax.interperter.tokenIdentifier.handlers;

import com.beloin.domain.exceptions.DomainException;
import com.beloin.domain.syntax.interperter.TokenType;

public class MappedByTokenHandler extends AbstractTokenHandler{
    @Override
    public TokenType handle(String token, HandlerContext ctx) throws DomainException {
        if (token.equals("mappedby")) {
            return TokenType.MAPPEDBY;
        }

        return this.successor(token, ctx);
    }
}
