package com.beloin.domain.syntax.interperter.tokenIdentifier.handlers;

import com.beloin.domain.exceptions.DomainException;
import com.beloin.domain.syntax.interperter.TokenType;

public class ConfigurationTokenHandler extends AbstractTokenHandler {

    @Override
    public TokenType handle(String token, HandlerContext ctx) throws DomainException {
        if (isConfigurationToken(token, ctx)) {
            return TokenType.CONFIGURATION;
        }
        return this.successor(token, ctx);
    }

    private boolean isConfigurationToken(String token, HandlerContext ctx){
        if (ctx.getCurrentPosition() > 0) return false;

        for (int i = 0; i< token.length(); i++) {
            char c = token.charAt(i);
            if (c == '.') {
                return true;
            }
        }

        return false;
    }
}
