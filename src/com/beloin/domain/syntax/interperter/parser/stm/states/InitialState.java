package com.beloin.domain.syntax.interperter.parser.stm.states;

import com.beloin.domain.syntax.interperter.CrudToken;
import com.beloin.domain.syntax.interperter.parser.stm.State;

import java.util.Map;

public class InitialState extends State {
    private Map<CrudToken, State> stateMapper;


    @Override
    protected State receiveEvent(CrudToken event) {
        if (this.stateMapper.containsKey(event)) {
            return this.stateMapper.get(event);
        }

        return this;
    }
}
