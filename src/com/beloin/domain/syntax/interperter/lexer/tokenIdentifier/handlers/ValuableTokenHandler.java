package com.beloin.domain.syntax.interperter.lexer.tokenIdentifier.handlers;

import com.beloin.domain.exceptions.DomainException;
import com.beloin.domain.syntax.interperter.TokenType;

public class ValuableTokenHandler extends AbstractTokenHandler {
    public ValuableTokenHandler(TokenIdentifierHandler successor) {
        super(successor);
    }

    public ValuableTokenHandler() {
    }

    @Override
    public TokenType handle(String token, HandlerContext ctx) throws DomainException {
        if (token.equals(":")) {
            return TokenType.VALUEABLETOKEN;
        }

        return this.successor(token, ctx);
    }

}
