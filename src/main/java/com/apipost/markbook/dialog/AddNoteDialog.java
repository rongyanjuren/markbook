package com.apipost.markbook.dialog;

import com.apipost.markbook.data.DataCenter;
import com.apipost.markbook.data.DataConvert;
import com.apipost.markbook.data.NoteData;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.ui.MessageDialogBuilder;
import com.intellij.ui.EditorTextField;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;

/**
 * @author 石玉龙 at 2023/6/28 14:10
 */
public class AddNoteDialog extends DialogWrapper {

    EditorTextField title;
    EditorTextField mark;
    public AddNoteDialog() {
        super(true);
        setTitle("添加笔记注释");
        init();
    }

    /**
     * 面板的创建
     * @return
     */
    @Override
    protected @Nullable JComponent createCenterPanel() {
        //new BorderLayout()为布局，布局有多种，此为东南西北中5个位置的布局
        JPanel jPanel = new JPanel(new BorderLayout());
        title = new EditorTextField("笔记标题");
        mark = new EditorTextField("笔记内容");
        //设置大小
        mark.setPreferredSize(new Dimension(200,100));
        jPanel.add(title,BorderLayout.NORTH);
        jPanel.add(mark,BorderLayout.CENTER);
        return jPanel;
    }

    /**
     * 创建南边的按钮
     * @return
     */
    @Override
    protected JComponent createSouthPanel() {
        JPanel jPanel = new JPanel();
        JButton button = new JButton("添加笔记到列表");
         //点击事件，点击 添加笔记到列表 按钮调用此lambda表达式
        button.addActionListener(e->{
            String titleText = title.getText();
            String markText = mark.getText();
            String fileType = DataCenter.FILE_NAME.substring(DataCenter.FILE_NAME.lastIndexOf(".")+1);
            NoteData noteData = new NoteData(titleText,markText,DataCenter.SELECT_TEXT,DataCenter.FILE_NAME,fileType);
            DataCenter.NOTE_LIST.add(noteData);
            //windowtool添加数据用于展示
            DataCenter.TABLE_MODEL.addRow(DataConvert.convert(noteData));
            MessageDialogBuilder.yesNo("操作结果","添加成功");
            AddNoteDialog.this.dispose();
        });
        jPanel.add(button);
        return jPanel;
    }
}
