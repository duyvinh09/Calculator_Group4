# Kết Quả Kiểm Thử Calculator App

## 📊 Tổng quan
| Metric | Value |
|--------|-------|
| Tổng số test case | 34 |
| Đã thực thi | 34 (100%) |
| Thành công | 30 (88.2%) |
| Thất bại | 4 |

## 🔍 Chi tiết kết quả

### 🔬 Phép toán khoa học
| ID | Test Case | Kết quả | Ghi chú |
|----|-----------|---------|---------|
| 01 | 5! → 120 | ✅ Passed | - |
| 02 | 0! → 1 | ✅ Passed | - |
| 03 | (-3)! → Error | ✅ Passed | Hiện lỗi "Không xác định |
| 04 | 5.5! → Error | ✅ Passed | - |
| 05 | log(100) → 2 | ✅ Passed | - |
| 06 | log(0) → Error | ✅ Passed | - |
| 07 | log(-10) → Error | ✅ Passed | - |
| 08 | sin(30°) → 0.5 | ✅ Passed | Kết quả đúng, nhưng phần Memory hiển thị "0.5 = 0.5" |
| 09 | tan(90°) → Error | ✅ Passed | - |
| 10 | cot(45°) → 1 | ✅ Passed | - |
| 11 | 180° → π rad (3.14) | ✅ Passed | Kết quả đúng, nhưng Memory hiện "3.14 = 3.14" |
| 12 | π rad (3.14) → 180° | ✅ Passed | - |

### 📚 Lịch sử tính toán
| ID | Test Case | Kết quả | Ghi chú |
|----|-----------|---------|---------|
| 13 | Lưu lịch sử vào file | ✅ Passed | Đúng định dạng .txt |
| 14 | Tìm kiếm "sin" trong lịch sử | ✅ Passed | - |
| 15 | Xóa từng mục lịch sử | ✅ Passed | - |
| 16 | Định dạng file lịch sử | ✅ Passed | - |

### 🎨 Giao diện người dùng
| ID | Test Case | Kết quả | Ghi chú |
|----|-----------|---------|---------|
| 17 | Chuyển Dark/Light mode | ✅ Passed | - |
| 18 | Lưu tùy chọn chế độ | ✅ Passed | - |
| 19 | Thay đổi font chữ | ✅ Passed | - |
| 20 | Thay đổi màu giao diện | ✅ Passed | - |
| 21 | Phím tắt 5+3=8 | ✅ Passed | Cần bấm vào màn hình Calculator để nhập  |
| 22 | Phím tắt sin(30)=0.5 | ❌ Failed | Chỉ hỗ trợ toán tử đơn giản |

### 🎛️ Chức năng điều khiển
| ID | Test Case | Kết quả | Ghi chú |
|----|-----------|---------|---------|
| 23 | Nút CE (5+3 CE 7=12) | ✅ Passed | Ấn CE, màn hình hiện 0 nhưng tính toán vẫn đúng |
| 24 | Nút Backspace (123⌫⌫=1) | ✅ Passed | - |
| 25 | Nút Forward (123←→4=1243) | ✅ Passed | Cần click để hiện con trỏ trên màn hình Calculator |

### ✨ Tính năng bổ sung
| ID | Test Case | Kết quả | Ghi chú |
|----|-----------|---------|---------|
| 26 | Copy/Paste kết quả | ✅ Passed | - |
| 27 | 5+(3*2)-√9 → 8 | ❌ Failed | Không xử lý được phép toán phức tạp |
| 28 | 5+3*2 → 11 | ❌ Failed | Không phân biệt thứ tự ưu tiên toán tử |
| 29 | (5+3)*2 → 16 | ✅ Passed | - |
| 30 | √16 → 4 | ✅ Passed | - |
| 31 | 5/0 → Error | ✅ Passed | - |
| 32 | 999999999999999² | ❌ Failed | Giới hạn kiểu số nguyên: 2147483647 |
| 33 | 1/3 → ≈0.333333 | ✅ Passed | - |
| 34 | 5++3 → Error | ✅ Passed | Khi nhập 2 dấu cộng sẽ báo lỗi (với đều kiện num2 rỗng) |