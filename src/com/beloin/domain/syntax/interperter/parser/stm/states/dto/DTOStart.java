package com.beloin.domain.syntax.interperter.parser.stm.states.dto;

import com.beloin.domain.exceptions.TokenNotAcceptedException;
import com.beloin.domain.syntax.interperter.CrudToken;
import com.beloin.domain.syntax.interperter.TokenType;
import com.beloin.domain.syntax.interperter.parser.stm.ParserContext;
import com.beloin.domain.syntax.interperter.parser.stm.State;

public class DTOStart extends State {
    @Override
    protected State receiveEvent(CrudToken event, ParserContext context) throws TokenNotAcceptedException {
        if (event.getType() == TokenType.LITERAL) {
            return new DTOName();
        }
        throw new TokenNotAcceptedException(event);
    }
}
