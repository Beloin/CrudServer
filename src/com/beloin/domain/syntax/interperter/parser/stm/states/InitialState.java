package com.beloin.domain.syntax.interperter.parser.stm.states;

import com.beloin.domain.syntax.interperter.CrudToken;
import com.beloin.domain.syntax.interperter.TokenType;
import com.beloin.domain.syntax.interperter.parser.stm.State;

import java.util.HashMap;
import java.util.Map;

public class InitialState extends State {
    private final Map<TokenType, State> stateMapper;

    public InitialState() {
        this.stateMapper = new HashMap<>();
    }

    public void addStateTransition(TokenType tk, State st) {
        this.stateMapper.put(tk, st);
    }


    @Override
    protected State receiveEvent(CrudToken event) {
        if (this.stateMapper.containsKey(event.getType())) {
            return this.stateMapper.get(event.getType()).addEvent(event);
        }

        return this;
    }
}
