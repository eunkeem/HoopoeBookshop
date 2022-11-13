package com.example.hoopoebookshop

import android.os.Parcel
import android.os.Parcelable

data class CartDataVO(
    val picture: Int,
    val sub: String,
    val price: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt().toInt(),
        parcel.readString().toString(),
        parcel.readString().toString()
    )

    override fun writeToParcel(parcel: Parcel?, flags: Int) {
        parcel?.writeInt(picture)
        parcel?.writeString(sub)
        parcel?.writeString(price)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CartDataVO> {
        override fun createFromParcel(parcel: Parcel): CartDataVO {
            return CartDataVO(parcel)
        }

        override fun newArray(size: Int): Array<CartDataVO?> {
            return arrayOfNulls(size)
        }
    }
}
