/*******************************************************************************
 * Copyright (c) 2020, 2022 IBM Corporation.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package io.openliberty.tools.intellij.actions;

import com.intellij.ide.CommonActionsManager;
import com.intellij.ide.DefaultTreeExpander;
import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.ui.treeStructure.Tree;

public class LibertyToolbarActionGroup extends DefaultActionGroup {
    private Tree tree;

    public LibertyToolbarActionGroup(Tree tree) {
        super("LibertyActionToolBar", false);
        this.tree = tree;
        final ActionManager actionManager = ActionManager.getInstance();
        add(actionManager.getAction("io.openliberty.tools.intellij.actions.RefreshLibertyToolbar"));
        addSeparator();
        add(actionManager.getAction("io.openliberty.tools.intellij.actions.RunLibertyDevTask"));
        addSeparator();

        if (tree != null) {
            DefaultTreeExpander expander = new DefaultTreeExpander(tree);
            CommonActionsManager commonActionsManager = CommonActionsManager.getInstance();
            add(commonActionsManager.createCollapseAllAction(expander, tree));
            add(commonActionsManager.createExpandAllAction(expander, tree));
        }
    }
}
