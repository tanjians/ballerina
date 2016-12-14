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

/**
 * {@code WhileStmt} represents a while statement
 *
 * @since 1.0.0
 */
public class WhileStmt implements Statement {
    private Expression whileCondition;
    private BlockStmt whileBody;

    public WhileStmt(Expression whileCondition, BlockStmt whileBody) {
        this.whileCondition = whileCondition;
        this.whileBody = whileBody;
    }

    public void interpret(Context ctx) {
        while (whileCondition.evaluate(ctx).getBoolean()) {
            whileBody.interpret(ctx);
        }
    }

    @Override
    public void visit(NodeVisitor visitor) {
        visitor.visit(this);
    }

    /**
     * Builds a {@code WhileStmt} statement
     *
     * @since 1.0.0
     */
    public static class WhileStmtBuilder {

        private Expression whileCondition;
        private BlockStmt whileBody;

        public WhileStmtBuilder() {
        }

        public void setCondition(Expression whileCondition) {
            this.whileCondition = whileCondition;
        }

        public void setWhileBody(BlockStmt whileBody) {
            this.whileBody = whileBody;
        }

        public WhileStmt build() {
            return new WhileStmt(whileCondition, whileBody);
        }
    }
}