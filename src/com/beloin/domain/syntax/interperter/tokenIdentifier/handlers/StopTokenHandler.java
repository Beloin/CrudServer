package com.beloin.domain.syntax.interperter.tokenIdentifier.handlers;

import com.beloin.domain.exceptions.DomainException;
import com.beloin.domain.syntax.interperter.TokenType;
import com.beloin.domain.syntax.utils.StopTokensUtils;

public class StopTokenHandler extends AbstractTokenHandler {
    public StopTokenHandler(TokenIdentifierHandler successor) {
        super(successor);
    }

    public StopTokenHandler() {
    }

    @Override
    public TokenType handle(String token, HandlerContext ctx) throws DomainException {
        if (token.length() == 1 && StopTokensUtils.isStopToken(token.charAt(0))) {
            return TokenType.STOPTOKEN;
        }

        return this.successor(token, ctx);
    }

}
