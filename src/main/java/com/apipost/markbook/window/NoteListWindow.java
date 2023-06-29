package com.apipost.markbook.window;

import com.apipost.markbook.data.DataCenter;
import com.apipost.markbook.processor.DefaultSourceNoteData;
import com.apipost.markbook.processor.MdFreeMarkProcessor;
import com.apipost.markbook.processor.Processor;
import com.intellij.notification.Notification;
import com.intellij.notification.NotificationDisplayType;
import com.intellij.notification.NotificationGroup;
import com.intellij.notification.Notifications;
import com.intellij.openapi.fileChooser.FileChooser;
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.MessageDialogBuilder;
import com.intellij.openapi.ui.MessageType;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.wm.ToolWindow;
import freemarker.template.TemplateException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * @author 石玉龙 at 2023/6/28 16:15
 */
public class NoteListWindow {
    private JTextField tfTopic;
    private JTable tbConent;
    private JButton btnCreate;
    private JButton btnClean;
    private JButton btnClose;
    private JPanel contetPanel;

    private void init() {
        tbConent.setModel(DataCenter.TABLE_MODEL);
        tbConent.setEnabled(true);
    }

    public NoteListWindow(Project project, ToolWindow toolWindow) {

        init();

        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                //输入文件名称
                String topic = tfTopic.getText();
                if (topic == null || "".equals(topic)) {
                    MessageDialogBuilder.yesNo("操作结果", "文档标题没有输入");

                }
                String fileName = topic + ".md";
                //选择目录
                VirtualFile virtualFile = FileChooser.chooseFile(
                        FileChooserDescriptorFactory.createSingleFileDescriptor(),
                        project,
                        project.getBaseDir());
                //生成文件
                if (virtualFile != null) {
                    String path = virtualFile.getPath();
                    String fileFullPath = path + "/" + fileName;
                    Processor processor = new MdFreeMarkProcessor();
                    try {
                        processor.processor(new DefaultSourceNoteData(fileFullPath, topic, DataCenter.NOTE_LIST));

                        NotificationGroup notificationGroup =
                                new NotificationGroup("markbook_id", NotificationDisplayType.BALLOON, false);
                        //content :  通知内容      type  ：通知的类型，warning,info,error
                        Notification notification = notificationGroup.createNotification("生成文档成功" + fileFullPath, MessageType.INFO);
                        Notifications.Bus.notify(notification);
                    } catch (TemplateException | IOException e) {
                        throw new RuntimeException(e);
                    }


                }
            }
        });
        btnClean.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                DataCenter.reset();
            }
        });
        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                toolWindow.hide();
            }
        });
    }

    public JPanel getContetPanel() {
        return contetPanel;
    }


}
