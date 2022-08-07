package com.beloin.domain.syntax.interperter.parser.expressions;

import java.util.LinkedList;
import java.util.List;

import static com.beloin.domain.syntax.interperter.parser.expressions.ExpressionType.CONFIGURATION;

public class ConfigurationExpression extends Expression {
    public ConfigurationExpression() {
        super();
        this.setType(CONFIGURATION);
        this.configurationName = "";
        this.configurationValueArray = new LinkedList<>();
    }

    private String configurationName;
    private final List<String> configurationValueArray;

    public String getConfigurationName() {
        return configurationName;
    }

    public List<String> getConfigurationValueArray() {
        return configurationValueArray;
    }

    public void setConfigurationName(String name){
        this.configurationName = name;
    }

    public void addConfigurationValue(String name){
        this.configurationValueArray.add(name);
    }
}
