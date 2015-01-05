package com.torstling.bychanuser;

import org.bychan.core.dynamic.Language;
import org.bychan.core.dynamic.LanguageBuilder;

public class User {

    private final Language<Integer> l;

    public User() {
        LanguageBuilder<Integer> lb = new LanguageBuilder<>("plus");
        lb.newToken().named("number").matchesPattern("[0-9]+").nud((previous, parser, lexeme) -> Integer.parseInt(lexeme.getText())).build();
        lb.newToken().named("plus").matchesString("+").led((previous, parser, lexeme) -> previous + parser.expression(previous)).build();
        l = lb.completeLanguage();
    }

    public Integer calculate(final String s) {
        return l.newLexParser().parse(s);
    }
}
