package com.beloin.domain.syntax.interperter.tokenIdentifier.handlers;

import com.beloin.domain.exceptions.DomainException;
import com.beloin.domain.syntax.interperter.TokenType;

public class LiteralTokenHandler extends AbstractTokenHandler{
    public LiteralTokenHandler() {
        // Literal Token Handler should be the last handler
        super(null);
    }

    @Override
    public TokenType handle(String token, HandlerContext ctx) throws DomainException {
        return TokenType.LITERAL;
    }
}
