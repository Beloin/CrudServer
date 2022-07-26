package com.beloin.domain.syntax.interperter.token.parsers;

import com.beloin.domain.exceptions.DomainException;
import com.beloin.domain.syntax.interperter.token.TokenType;

public class ConfigurationTokenHandler extends AbstractTokenHandler {

    public ConfigurationTokenHandler(TokenParserHandler successor) {
        super(successor);
    }

    public ConfigurationTokenHandler() {
    }

    @Override
    public TokenType handle(String token) throws DomainException {
        if (token.matches("\\.")) {
            return TokenType.CONFIGURATION;
        }

        return this.successor(token);
    }
}
