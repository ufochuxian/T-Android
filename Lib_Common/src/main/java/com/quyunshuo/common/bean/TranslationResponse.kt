package com.quyunshuo.common.bean


data class TranslationResponse(
    val from: String,
    val to: String,
    val trans_result: List<TransResult>
)

data class TransResult(
    val dst: String,
    val src: String
)