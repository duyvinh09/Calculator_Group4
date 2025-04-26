# Kết Quả Kiểm Thử Calculator App

## 📊 Tổng quan
| Metric | Value |
|--------|-------|
| Tổng số test case | 34 |
| Đã thực thi | 34 (100%) |
| Thành công | 22 |
| Thất bại | 8 |
| Có khả năng sai | 3 |

## 🔍 Chi tiết kết quả

### 🔬 Phép toán khoa học
| ID | Test Case | Kết quả | Ghi chú |
|----|-----------|---------|---------|
| 01 | 5! → 120 | ✅ Passed | - |
| 02 | 0! → 1 | ✅ Passed | - |
| 03 | (-3)! → 1 | ❌ Failed | - |
| 04 | 5.5! → Error | ✅ Passed | - |
| 05 | log(100) → 2 | ✅ Passed | - |
| 06 | log(0) → Error | ✅ Passed | - |
| 07 | log(-10) → Error | ✅ Passed | - |
| 08 | sin(30°) → 0.5 | ✅ Passed | Vũ làm đúng nhưng Nam Lê in ra "Memory" là 0.5 = 0.5 |
| 09 | tan(90°) → Error | ✅ Passed | - |
| 10 | cot(45°) → 1 | ✅ Passed | - |
| 11 | 180° → π rad | ✅ Passed | - |
| 12 | π rad → 180° | ✅ Passed | - |

### 📚 Lịch sử tính toán
| ID | Test Case | Kết quả | Ghi chú |
|----|-----------|---------|---------|
| 13 | Lưu lịch sử vào file | ✅ Passed | Đúng định dạng .txt |
| 14 | Tìm kiếm "sin" trong lịch sử | ✅ Passed | - |
| 15 | Xóa từng mục lịch sử | ✅ Passed | Chưa rõ |
| 16 | Định dạng file lịch sử | ✅ Passed | - |

### 🎨 Giao diện người dùng
| ID | Test Case | Kết quả | Ghi chú |
|----|-----------|---------|---------|
| 17 | Chuyển Dark/Light mode | ✅ Passed | - |
| 18 | Lưu tùy chọn chế độ | ✅ Passed | - |
| 19 | Thay đổi font chữ | ✅ Passed | - |
| 20 | Thay đổi màu giao diện | ✅ Passed | - |
| 21 | Phím tắt 5+3=8 | ✅ Passed | Nam Lê chưa sửa được khi nhập |
| 22 | Phím tắt sin(30)=0.5 | ❌ Failed | Nam Lê làm được |

### 🎛️ Chức năng điều khiển
| ID | Test Case | Kết quả | Ghi chú |
|----|-----------|---------|---------|
| 23 | Nút CE (5+3 CE 7=12) | ✅ Passed | Đúng kết quả nhưng bên phần calculator hiện số 0 khi ấn CE |
| 24 | Nút Backspace (123⌫⌫=1) | ✅ Passed | - |
| 25 | Nút Forward (123←→4=1243) | ✅ Passed | Cần phải click vào màn hình Calculator để hiện con trỏ |

### ✨ Tính năng bổ sung
| ID | Test Case | Kết quả | Ghi chú |
|----|-----------|---------|---------|
| 26 | Copy/Paste kết quả | ❌ Failed | - |
| 27 | 5+(3*2)-√9 → 8 | ❌ Failed | - |
| 28 | 5+3*2 → 11 | ❌ Failed | - |
| 29 | (5+3)*2 → 16 | ❌ Failed | - |
| 30 | √16 → 4 | ✅ Passed | - |
| 31 | 5/0 → Error | ✅ Passed | - |
| 32 | 999999999999999² | ❌ Failed | - |
| 33 | 1/3 → ≈0.333333 | ✅ Passed | - |
| 34 | 5++3 → Error | ❌ Failed | Nam Lê làm sai, bấm 5++ nó ra 10 |