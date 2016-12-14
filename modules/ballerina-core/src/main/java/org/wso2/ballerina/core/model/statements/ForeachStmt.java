/*
*  Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
*  Unless required by applicable law or agreed to in writing,
*  software distributed under the License is distributed on an
*  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
*  KIND, either express or implied.  See the License for the
*  specific language governing permissions and limitations
*  under the License.
*/
package org.wso2.ballerina.core.model.statements;

import org.wso2.ballerina.core.interpreter.Context;
import org.wso2.ballerina.core.model.NodeVisitor;
import org.wso2.ballerina.core.model.expressions.Expression;
import org.wso2.ballerina.core.model.types.IteratorType;

/**
 * {@code ForeachStmt} Represents a foreach statement.
 *
 * @since 1.0.0
 */
public class ForeachStmt implements Statement {
    private Expression condition;
    private IteratorType itr;
    private Statement forEachBlock;

    public ForeachStmt(Expression condition, IteratorType itr, Statement forEachBlock) {
        this.condition = condition;
        this.itr = itr;
        this.forEachBlock = forEachBlock;
    }

    public void interpret(Context ctx) {

    }

    @Override
    public void visit(NodeVisitor visitor) {
//        visitor.visit(this);
    }
}