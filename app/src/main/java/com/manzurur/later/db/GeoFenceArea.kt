package com.manzurur.later.db

import androidx.room.ColumnInfo

data class GeoFenceArea(
    @ColumnInfo(name = "latitude")
    val latitude: Double,

    @ColumnInfo(name = "longitude")
    val longitude: Double,

    @ColumnInfo(name = "radius_meter")
    val radiusMeter: Double,
)