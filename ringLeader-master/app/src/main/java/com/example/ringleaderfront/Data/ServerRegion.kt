package com.example.ringleaderfront.Data

import java.io.Serializable

data class ServerRegion(val regionId:Int?,
                        val ServerLookReviews: List<ServerLookReview>?=null)
    : Serializable
