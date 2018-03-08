package cn.edu.cup.frame

import java.awt.event.ActionEvent

class QuestionFrame extends CommonFrame {

    protected void processDefinedEvent(ActionEvent evt) {
        println("called from QuestionFrame...")
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

    /*
    * 构造函数
    * */
    def QuestionFrame(questionDocument) {
        super(questionDocument)
    }

}
