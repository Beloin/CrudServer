package com.beloin.domain.syntax.interperter.parser.stm;

import com.beloin.domain.exceptions.DomainException;
import com.beloin.domain.syntax.interperter.CrudToken;
import com.beloin.domain.syntax.interperter.TokenType;
import com.beloin.domain.syntax.interperter.parser.stm.states.configuration.ConfigurationStart;
import com.beloin.domain.syntax.interperter.parser.stm.states.InitialState;
import com.beloin.domain.syntax.interperter.parser.stm.states.dto.DTOStart;

import java.util.Objects;

// TODO: ADD TO STATES A ORDER, WHAT THEY DO, WHAT THEY CREATE ETC ETC...
// https://www.twilio.com/blog/abstract-syntax-trees
public class ParserStateMachine {
    private ParserStateMachine() {
    }

    private InitialState initialState;
    private State currentState;
    private ParserContext currentContext;

    public static ParserStateMachine createParser() {
        ParserStateMachine psM = new ParserStateMachine();
        psM.initialStateSetup();
        return psM;
    }

    private void initialStateSetup() {
        initialState = new InitialState();
        currentState = initialState;

        initialState.addStateTransition(TokenType.CONFIGURATION, new ConfigurationStart());
        initialState.addStateTransition(TokenType.DTO, new DTOStart());
        currentContext = new ParserContext();
    }

    // TODO: Ignores " " (Space) Tokens
    public void addToken(CrudToken token) throws DomainException {
        if (!Objects.equals(token.getText(), " ")) {
            currentState = this.currentState.updateState(token, currentContext);
        }
    }


//    public AST generateAST() {}
}
