package com.oppo.community.model

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class SeaCreature(
    val id: Long,
    @SerialName("file-name")
    val fileName: String,
    val speed: String,
    val price: Int,
    @SerialName("image-uri")
    val imageUri: String,
    @SerialName("icon-uri")
    val iconUri: String,
    @SerialName("museum-phrase")
    val museumPhrase: String
)
