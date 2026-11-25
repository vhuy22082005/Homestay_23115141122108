package com.example.homestay_23115141122108

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.homestay_23115141122108.databinding.ActivityMainBinding

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

    fun sinhMa(tienTo: String = "HOME"): String = "${tienTo}%02d2108".format(stt2108++)

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
class MainActivity : AppCompatActivity() {

    private lateinit var b: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)

        // 1. NÚT LƯU CHÍNH (btnLuu2108)
        b.btnLuu.setOnClickListener {
            b.edtTen.error = null
            b.edtSoLuong.error = null
            b.edtDonGia.error = null
            b.tvKetQua.text = ""

            var hopLe = true

            // Ô 1: Tên (ten)
            val ten = Logic.kiemTraTen(b.edtTen.text.toString(), min = 3, max = 30)
            if (ten == null) {
                b.edtTen.error = "Tên phải từ  đến  ký tự"
                if (hopLe) b.edtTen.requestFocus()
                hopLe = false
            }

            // Ô 2: Số lượng (soLuong)
            val soLuong = Logic.docSoDem(b.edtSoLuong.text.toString(), min = 1, max = 7)
            if (soLuong == null) {
                b.edtSoLuong.error = "Số lượng phải từ  đến "
                if (hopLe) b.edtSoLuong.requestFocus()
                hopLe = false
            }

            // Ô 3: Đơn giá (donGia)
            val donGia = Logic.docGiaPhong(b.edtDonGia.text.toString(), min = 200_000.0, max =2_500_000.0)
            if (donGia == null) {
                b.edtDonGia.error = "Giá trị phải từ  đến "
                if (hopLe) b.edtDonGia.requestFocus()
                hopLe = false
            }
            // NẾU CÓ BẤT KỲ Ô NÀO LỖI HOẶC NULL THÌ DỪNG
            if (!hopLe || ten == null || soLuong == null || donGia == null) {
                return@setOnClickListener
            }

            // (Commit 4 c4save sẽ dán tiếp ngay tại đây)
        }
    }
}