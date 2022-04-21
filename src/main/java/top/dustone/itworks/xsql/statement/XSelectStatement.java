/*-
 * #%L
 * JSQLParser library
 * %%
 * Copyright (C) 2004 - 2022 JSQLParser
 * %%
 * Dual licensed under GNU LGPL 2.1 or Apache License 2.0
 * #L%
 */
package top.dustone.itworks.xsql.statement;

import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.StatementVisitor;
import net.sf.jsqlparser.statement.select.Select;

/**
 * @Author Chenyan
 * @Date 14:09
 * @Magic ItWorks-SeeingFlow
 * @Device Macbook Air 2020 M1
 **/
public class XSelectStatement implements Statement {
    Select select;
    String id;

    @Override
    public void accept(StatementVisitor statementVisitor) {
        statementVisitor.visit(this);
    }
    public StringBuilder appendTo(StringBuilder builder) {
        builder.append(select.toString());
        return builder;
    }

    public Select getSelect() {
        return select;
    }

    public void setSelect(Select select) {
        this.select = select;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id.substring(1,id.length()-1);
    }
}
