package cn.edu.cup.document

class QuestionDocument extends CommonDocument {

    def QuestionDocument() {
        super('试题库辅助工具. V0.1.')

        setupLocalProperties()
    }

    private void setupLocalProperties() {
        guidStrings.clear()
        guidStrings.add('打开文档')
    }

}
