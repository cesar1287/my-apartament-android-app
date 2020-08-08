package cesar1287.com.github.conversordemoedas.extensions

import java.text.NumberFormat
import java.util.*

fun String.replaceDesiredToBlank(regex: String): String {
    return this.replace(regex, "")
}

fun String.brlToDouble(): Double {
    return NumberFormat.getInstance(Locale("pt", "BR")).parse(this).toDouble()
}

fun String.unmask(): String {
    return this.replace("[.]".toRegex(), "").replace("[-]".toRegex(), "").replace("[/]".toRegex(), "")
        .replace("[(]".toRegex(), "").replace(
            "[ ]".toRegex(), ""
        ).replace("[:]".toRegex(), "").replace("[)]".toRegex(), "")
}