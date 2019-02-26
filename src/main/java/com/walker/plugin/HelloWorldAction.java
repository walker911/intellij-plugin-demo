package com.walker.plugin;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.psi.PsiFile;

import java.util.Objects;

/**
 * @author walker
 * @date 2019/2/25
 */
public class HelloWorldAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent event) {
        // 获取当前在操作的工程上下文
        Project project = event.getData(PlatformDataKeys.PROJECT);

        // 获取当前操作的类文件
        PsiFile psiFile = event.getData(CommonDataKeys.PSI_FILE);
        // 获取当前类文件的路径
        String classpath = Objects.requireNonNull(psiFile).getVirtualFile().getPath();
        String title = "Hello World!";

        // 显示对话框
        Messages.showMessageDialog(project, classpath, title, Messages.getInformationIcon());
    }
}
