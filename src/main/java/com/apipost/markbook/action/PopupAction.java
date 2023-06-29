package com.apipost.markbook.action;

import com.apipost.markbook.data.DataCenter;
import com.apipost.markbook.dialog.AddNoteDialog;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;

/**
 * @author 石玉龙 at 2023/6/28 10:32
 */
public class PopupAction extends AnAction {
    /**
     * 点击 添加笔记 按钮调用此接口
     * @param e Carries information on the invocation place
     */
    @Override
    public void actionPerformed(AnActionEvent e) {
        //获取编辑器对象
        Editor editor = e.getRequiredData(CommonDataKeys.EDITOR);
        //获取选择模型
        SelectionModel selectionModel = editor.getSelectionModel();
        //获取选择的文本
        String selectedText = selectionModel.getSelectedText();
        //获取选择的文件名
        String name = e.getRequiredData(CommonDataKeys.PSI_FILE).getViewProvider().getVirtualFile().getName();
        DataCenter.SELECT_TEXT = selectedText;
        DataCenter.FILE_NAME = name;
        AddNoteDialog addNoteDialog = new AddNoteDialog();
        //面板展示
        addNoteDialog.show();

    }
}
