package com.beloin.domain.syntax.interperter.parser.stm.states.configuration;

import com.beloin.domain.syntax.interperter.CrudToken;
import com.beloin.domain.syntax.interperter.TokenType;
import com.beloin.domain.syntax.interperter.parser.stm.State;

public class ConfigurationState extends State {


    @Override
    protected State receiveEvent(CrudToken event) {
        if (event.getType() == TokenType.CONFIGURATION) {
            return new NameState();
        }

        return this;
    }
}
