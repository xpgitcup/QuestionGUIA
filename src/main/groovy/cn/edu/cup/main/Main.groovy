package cn.edu.cup.main

import cn.edu.cup.document.CommonDocument
import cn.edu.cup.document.QuestionDocument
import cn.edu.cup.frame.CommonFrame
import cn.edu.cup.frame.QuestionFrame

class Main {

    static void main(String[] argvs) {

        def document = new QuestionDocument()//CommonDocument('种子程序, ver 0.1, 2018.03.03')
        println(document.name)

        def mainFrame = new QuestionFrame(document)//CommonFrame(document)
        mainFrame.run()
        mainFrame.showStatus()
    }
}
