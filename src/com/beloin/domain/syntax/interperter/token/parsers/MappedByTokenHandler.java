package com.beloin.domain.syntax.interperter.token.parsers;

import com.beloin.domain.exceptions.DomainException;
import com.beloin.domain.syntax.interperter.token.TokenType;

public class MappedByTokenHandler extends AbstractTokenHandler{
    @Override
    public TokenType handle(String token, HandlerContext ctx) throws DomainException {
        if (token.equals("mappedby")) {
            return TokenType.MAPPEDBY;
        }

        return this.successor(token, ctx);
    }
}
