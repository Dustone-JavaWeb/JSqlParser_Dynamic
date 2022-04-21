/*-
 * #%L
 * JSQLParser library
 * %%
 * Copyright (C) 2004 - 2022 JSQLParser
 * %%
 * Dual licensed under GNU LGPL 2.1 or Apache License 2.0
 * #L%
 */
package top.dustone.itworks.xsql.debug;

import io.vertx.core.Vertx;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.expression.LongValue;
import net.sf.jsqlparser.expression.StringValue;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.Statements;
import net.sf.jsqlparser.util.deparser.ExpressionDeParser;
import net.sf.jsqlparser.util.deparser.SelectDeParser;
import net.sf.jsqlparser.util.deparser.StatementDeParser;
import top.dustone.itworks.xsql.statement.XSelectStatement;

/**
 * @Author Chenyan
 * @Date 12:14
 * @Magic ItWorks-SeeingFlow
 * @Device Macbook Air 2020 M1
 **/
public class DeparserDebug {
    static class ReplaceColumnAndLongValues extends ExpressionDeParser {

        @Override
        public void visit(StringValue stringValue) {
            this.getBuffer().append("?");
        }

        @Override
        public void visit(LongValue longValue) {
            this.getBuffer().append("?");
        }
    }

    static class XStatementDeParser extends StatementDeParser{

        public XStatementDeParser(ExpressionDeParser expressionDeParser, SelectDeParser selectDeParser, StringBuilder buffer) {
            super(expressionDeParser, selectDeParser, buffer);
        }

        @Override
        public void visit(XSelectStatement xSelectStatement) {
            super.visit(xSelectStatement);
            System.err.println(xSelectStatement.getId());
            System.err.println(xSelectStatement.getSelect());
        }
    }
    public static String cleanStatement(String sql) throws JSQLParserException {
        StringBuilder buffer = new StringBuilder();
        ExpressionDeParser expr = new ReplaceColumnAndLongValues();

        SelectDeParser selectDeparser = new SelectDeParser(expr, buffer);
        expr.setSelectVisitor(selectDeparser);
        expr.setBuffer(buffer);
        StatementDeParser stmtDeparser = new XStatementDeParser(expr, selectDeparser, buffer);

        Statements stmt = (Statements) CCJSqlParserUtil.parse(sql);
        stmt.getStatements().forEach(statement -> statement.accept(stmtDeparser));
//        stmt.accept(stmtDeparser);
        return stmtDeparser.getBuffer().toString();
    }

    public static void main(String[] args) throws JSQLParserException {
        Vertx vertx = Vertx.vertx();
        String sql = vertx.fileSystem().readFileBlocking("data/test.sql").toString();
        System.out.println(cleanStatement(sql));
    }
}
