package com.beloin.domain.syntax.interperter.token.parsers;

import com.beloin.domain.exceptions.DomainException;
import com.beloin.domain.syntax.interperter.token.TokenType;

public class DTOTokenHandler extends AbstractTokenHandler {
    public DTOTokenHandler(TokenParserHandler successor) {
        super(successor);
    }

    public DTOTokenHandler() {
    }

    @Override
    public TokenType handle(String token) throws DomainException {
        if (token.matches("dto")) {
            return TokenType.DTO;
        }

        return this.successor(token);
    }
}
