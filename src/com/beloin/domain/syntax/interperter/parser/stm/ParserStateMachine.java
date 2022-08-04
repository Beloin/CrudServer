package com.beloin.domain.syntax.interperter.parser.stm;

import com.beloin.domain.syntax.interperter.CrudToken;
import com.beloin.domain.syntax.interperter.TokenType;
import com.beloin.domain.syntax.interperter.parser.stm.states.configuration.ConfigurationState;
import com.beloin.domain.syntax.interperter.parser.stm.states.InitialState;

public class ParserStateMachine {
    // Tree States ...
    // AST
    private final InitialState initialState = new InitialState();
    private State currentState;

    // TODO: Ignores " " (Space) Tokens
    public void addToken(CrudToken token) {}

    public void configureInitialState() {
        initialState.addStateTransition(TokenType.CONFIGURATION, new ConfigurationState());
    }


//    public AST generateAST() {}
}
