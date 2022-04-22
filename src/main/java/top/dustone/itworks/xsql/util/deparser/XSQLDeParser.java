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

import net.sf.jsqlparser.util.deparser.ExpressionDeParser;
import net.sf.jsqlparser.util.deparser.SelectDeParser;
import net.sf.jsqlparser.util.deparser.StatementDeParser;
import top.dustone.itworks.xsql.statement.XSelectStatement;

/**
 * @Author Chenyan
 * @Date 12:18
 * @Magic ItWorks-SeeingFlow
 * @Device Macbook Air 2020 M1
 **/
public class XSQLDeParser extends StatementDeParser {
    XSelectStatement xSelectStatement;
    XParamDeParser xParamDeParser;
    SelectDeParser selectDeParser;

    public static XSQLDeParser build(StringBuilder stringBuilder) {
        XParamDeParser xParamDeParser = new XParamDeParser();
        SelectDeParser selectDeParser = new SelectDeParser(xParamDeParser, stringBuilder);
        xParamDeParser.setSelectVisitor(selectDeParser);
        xParamDeParser.setBuffer(stringBuilder);
        return new XSQLDeParser(xParamDeParser, selectDeParser, stringBuilder);
    }

    public XSQLDeParser(ExpressionDeParser expressionDeParser, SelectDeParser selectDeParser, StringBuilder buffer) {
        super(expressionDeParser, selectDeParser, buffer);
    }

    @Override
    public void visit(XSelectStatement xSelectStatement) {
        super.visit(xSelectStatement);
        this.xSelectStatement = xSelectStatement;
    }

    public XSelectStatement getxSelectStatement() {
        return xSelectStatement;
    }

    public void setxSelectStatement(XSelectStatement xSelectStatement) {
        this.xSelectStatement = xSelectStatement;
    }
}
