package com.tgm.base.utils


object JsonUtil {

    /**
     * 格式化json字符串
     *
     * @param jsonStr 需要格式化的json串
     * @return string
     */
    fun formatJson(jsonStr: String?): String {
        if (null == jsonStr || "" == jsonStr) return ""
        val sb = StringBuffer()
        var last = '\u0000'
        var current = '\u0000'
        var indent = 0
        for (element in jsonStr) {
            last = current
            current = element
            //遇到{ [换行，且下一行缩进
            when (current) {
                '{', '[' -> {
                    sb.append(current)
                    sb.append('\n')
                    indent++
                    addIndentBlank(sb, indent)
                }
                //遇到} ]换行，当前行缩进
                '}', ']' -> {
                    sb.append('\n')
                    indent--
                    addIndentBlank(sb, indent)
                    sb.append(current)
                }
                //遇到,换行
                ',' -> {
                    sb.append(current)
                    if (last != '\\') {
                        sb.append('\n')
                        addIndentBlank(sb, indent)
                    }
                }
                else -> sb.append(current)
            }
        }
        return sb.toString()
    }

    /**
     * 添加space
     *
     * @param sb
     * @param indent
     */
    private fun addIndentBlank(sb: StringBuffer, indent: Int) {
        for (i in 0 until indent) {
            sb.append('\t')
        }
    }

}
