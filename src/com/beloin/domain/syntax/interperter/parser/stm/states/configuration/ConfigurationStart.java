package com.beloin.domain.syntax.interperter.parser.stm.states.configuration;

import com.beloin.domain.exceptions.TokenNotAcceptedException;
import com.beloin.domain.syntax.interperter.CrudToken;
import com.beloin.domain.syntax.interperter.TokenType;
import com.beloin.domain.syntax.interperter.parser.expressions.ConfigurationExpression;
import com.beloin.domain.syntax.interperter.parser.stm.ParserContext;
import com.beloin.domain.syntax.interperter.parser.stm.State;

public class ConfigurationStart extends State {


    @Override
    protected State receiveEvent(CrudToken event, ParserContext context) throws TokenNotAcceptedException {
        if (event.getType() == TokenType.CONFIGURATION) {
            context.setExpression(new ConfigurationExpression());

            // Add Configuration Name
            ConfigurationExpression exp = (ConfigurationExpression) context.getExpression();
            exp.setConfigurationName(event.getText());
            
            return new NameState();
        }
        throw new TokenNotAcceptedException(event);
    }
}
