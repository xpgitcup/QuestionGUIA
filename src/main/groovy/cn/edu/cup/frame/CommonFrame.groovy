package cn.edu.cup.frame

import groovy.swing.SwingBuilder

import javax.swing.JFileChooser
import java.io.FileFilter
import javax.swing.JFrame
import javax.swing.UIManager
import java.awt.BorderLayout
import java.awt.Toolkit
import java.awt.event.ActionEvent

class CommonFrame {
    //基础GUI设置
    def swing = new SwingBuilder()
    JFrame frame
    def toolkit = Toolkit.getDefaultToolkit()
    def screenSize = toolkit.getScreenSize()

    def WIDTH = 1200
    def HEIGHT = 768
    int X = (screenSize.width - WIDTH) / 2
    int Y = (screenSize.height - HEIGHT) / 2

    def document
    def status

    /*
    * 打开文件
    * */
    def openFile(extName) {
        def o = new JFileChooser()
        o.setFileSelectionMode(JFileChooser.FILES_ONLY)

        o.setFileFilter(new javax.swing.filechooser.FileFilter() {

            @Override
            boolean accept(File afile) {
                if (afile.getName().endsWith(extName)){
                    return true
                } else {
                    return false
                }
            }

            @Override
            String getDescription() {
                return "word 文档"
            }
        })

        def ok = o.showOpenDialog(null)
        if (ok == JFileChooser.APPROVE_OPTION) {
            return o.getSelectedFile()
        } else {
            return null
        }

    }


    /*
    * 显示程序当前的状态
    * */

    def showStatus() {
        //显示结果
    }

    /*
    * 处理用户的操作
    * */

    def commonAction(ActionEvent evt) {
        def actionName = evt.actionCommand

        println("通用事件处理：${actionName} -- ${evt}")
        if (evt.source?.name) {
            status.text = actionName
        }

        if (document.guidStrings.indexOf(actionName) > 0) {
            //属于预定义的操作
            //根据事件的名称，来决定如何处理事件
            switch (actionName) {
                case "源域类":
                    changeSourceDomain()
                    break

            }
        } else {
            //根据事件的发起者来决定如何处理事件
            println("source: ${evt.source}")
            println("sourceName: ${evt.source.name}")
            processDefinedEvent(evt)
        }

        showStatus()
    }

    protected void processDefinedEvent(ActionEvent evt) {
        println("called from CommonFrame...")
        switch ("${evt.source.name}") {
            case "targetInput":
                inputTargetDomain()
                break
            case "mainDomainInput":
                grailsAuxDcoument.mainDomain = mainDomainInput.text
                println("主域类变更为：${grailsAuxDcoument.mainDomain}")
                break;
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    //工具栏
    def theToolBar = {
        swing.panel(layout: new BorderLayout(), constraints: BorderLayout.NORTH) {
            toolBar(constraints: BorderLayout.NORTH) {
                label(text: "操作流程：")
                document.guidStrings.each { e ->
                    button(text: e, actionPerformed: { evt -> commonAction(evt) })
                    label(text: "->")
                }
                separator()
                label(text: "当前操作:")
                status = label(text: "")
            }
        }
    }

    /*
    * 设置界面
    * */

    def setupUI() {
        theToolBar()
    }

    /*
    * 执行--主消息系循环
    * */

    def run() {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName())
        frame = swing.frame(title: document.name,
                size: [WIDTH, HEIGHT],
                location: [X, Y],
                defaultCloseOperation: javax.swing.WindowConstants.DISPOSE_ON_CLOSE) {
            setupUI()
        }
        frame.setVisible(true)
    }

    /*
    * 构造函数
    * */

    public CommonFrame(doc) {
        document = doc
    }

}
