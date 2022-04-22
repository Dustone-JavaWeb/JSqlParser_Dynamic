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
import top.dustone.itworks.xsql.util.deparser.XSQLDeParser;

/**
 * @Author Chenyan
 * @Date 12:14
 * @Magic ItWorks-SeeingFlow
 * @Device Macbook Air 2020 M1
 **/
public class DeparserDebug {

    public static void main(String[] args) throws JSQLParserException {
        Vertx vertx = Vertx.vertx();
        String sql = vertx.fileSystem().readFileBlocking("data/test.sql").toString();
        StringBuilder builder = new StringBuilder();
        Statements stmts = CCJSqlParserUtil.parseStatements(sql);
        XSQLDeParser deParser = XSQLDeParser.build(builder);
        stmts.getStatements().forEach(statement -> {
            builder.setLength(0);
            statement.accept(deParser);
            System.out.println(deParser.getxSelectStatement().getId());
            System.out.println(builder);
        });
    }
}
