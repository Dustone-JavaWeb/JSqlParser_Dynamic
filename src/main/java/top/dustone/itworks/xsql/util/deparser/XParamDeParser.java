/*-
 * #%L
 * JSQLParser library
 * %%
 * Copyright (C) 2004 - 2022 JSQLParser
 * %%
 * Dual licensed under GNU LGPL 2.1 or Apache License 2.0
 * #L%
 */
package top.dustone.itworks.xsql.util.deparser;

import net.sf.jsqlparser.expression.LongValue;
import net.sf.jsqlparser.expression.StringValue;
import net.sf.jsqlparser.util.deparser.ExpressionDeParser;

/**
 * @Author Chenyan
 * @Date 12:24
 * @Magic ItWorks-SeeingFlow
 * @Device Macbook Air 2020 M1
 **/
public class XParamDeParser extends ExpressionDeParser {
    @Override
    public void visit(StringValue stringValue) {
        this.getBuffer().append("?");
    }

    @Override
    public void visit(LongValue longValue) {
        this.getBuffer().append("?");
    }
}
