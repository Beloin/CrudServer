package com.beloin.domain.syntax.interperter.parser.stm.states.configuration;

import com.beloin.domain.exceptions.TokenNotAcceptedException;
import com.beloin.domain.syntax.interperter.CrudToken;
import com.beloin.domain.syntax.interperter.TokenType;
import com.beloin.domain.syntax.interperter.parser.stm.ParserContext;
import com.beloin.domain.syntax.interperter.parser.stm.State;

public class ValueState extends State {

    public ValueState() {
        super(true);
    }

    @Override
    protected State receiveEvent(CrudToken event, ParserContext context) throws TokenNotAcceptedException {
        if (event.getType() == TokenType.ARRAYTOKEN) return new ArrayState();
        throw new TokenNotAcceptedException(event);
    }
}
