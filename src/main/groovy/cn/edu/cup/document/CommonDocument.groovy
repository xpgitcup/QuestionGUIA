package cn.edu.cup.document

class CommonDocument {

    def name
    def guidStrings = ['这是', '操作', '指南']
    def status = [
            'key1': 'value1'
    ]

    def CommonDocument(str) {
        name = str
    }

}
