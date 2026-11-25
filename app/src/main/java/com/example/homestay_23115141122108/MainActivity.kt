package com.example.homestay_23115141122108

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

data class Homestay2108(
    val ma_2108: String,
    val ten_2108: String,
    val soLuong_2108: Int,
    val donGia_2108: Double
)

fun String.chuanHoaTen_2108(): String = this.trim()
.split("\\s+".toRegex())
.joinToString(" ") { it.lowercase().replaceFirstChar(Char::uppercase) }

object Logic {
    private var stt2108 = 1

    fun sinhMa(tienTo: String = "DV"): String = "${tienTo}%02d2108".format(stt2108++)

    fun kiemTraTen(text: String, min: Int = 3 , max: Int = 30 ): String? {
        val trimmed = text.trim() // Sửa trim thành tên hàm chuẩn hóa
        return if (trimmed.length !in min..max) null else trimmed
    }

    fun docSoDem(text: String, min: Int = 1, max: Int = 7): Int? {
        return try {
            val so = text.trim().toInt()
            if (so !in min..max) null else so
        } catch (e: Exception) {
            null
        }
    }

    fun docGiaPhong(text: String, min: Double = 200_000.0, max: Double = 2_500_000.0): Double? {
        return try {
            val so = text.trim().toDouble()
            if (so !in min..max) null else so
        } catch (e: Exception) {
            null
        }
    }

    fun tinhTienPhong(soLuong: Int, donGia: Double): Double = soLuong * donGia

    fun dinhDang(ma: String, ten: String, soLuong: Int, donGia: Double, tong: Double): String {
        return "Thành công: $ma | $ten | $soLuong lượt | Tổng: %,.0f đ".format(tong)
    }
}
