# Ứng dụng Máy tính - CMU-CS 246 NIS (2025S) - Nhóm 4

## Tổng quan dự án

Ứng dụng Máy tính được phát triển bởi Nhóm 4 trong khuôn khổ môn học CMU-CS 246: Application Development Practices (2025S), do [ThS. Nguyễn Đăng Quang Huy](https://pdaotao.duytan.edu.vn/PERSION_Detail/?PERSION_ID=80) giảng dạy. Ứng dụng hỗ trợ các phép toán cơ bản, tính toán khoa học nâng cao và các tính năng tương tác người dùng, mang lại trải nghiệm thân thiện và mạnh mẽ.

## Thành viên nhóm

- **Đinh Duy Vinh** (Trưởng nhóm)\
  **Nhiệm vụ**: Thiết kế giao diện người dùng (UI/UX)

  - Phát triển chế độ tối (Dark Mode) và sáng (Light Mode).
  - Tùy chỉnh phông chữ và màu sắc giao diện.

- **Phạm Ngọc Vũ**\
  **Nhiệm vụ**: Các phép toán khoa học

  - Thực hiện giai thừa (n!), logarit (log₁₀ x, ln x), hàm lượng giác (sin, cos, tan, cot).
  - Chuyển đổi đơn vị góc: Độ ↔ Radian.

- **Trần Nguyễn Quốc Huy**\
  **Nhiệm vụ**: Lịch sử tính toán

  - Lưu trữ lịch sử phép tính vào file JSON hoặc text.
  - Hỗ trợ tìm kiếm và xóa các phép tính cũ.

- **Lê Anh Nam**\
  **Nhiệm vụ**: Điều khiển bàn phím

  - Hỗ trợ phím tắt (keyboard shortcuts) cho phép tính.
  - Thêm nút CE (Clear Entry), Backspace (←), và Forward (→).

- **Nguyễn Hoàng Nhật**\
   **Nhiệm vụ**: Biểu thức & Clipboard

  - Hỗ trợ tính toán biểu thức phức tạp (ví dụ: "5 + (3 \* 2) - √9").
  - **Đã được thực hiện bởi Đinh Duy Vinh**: Chức năng sao chép/dán (copy/paste) kết quả.

## Tính năng

### Các phép toán khoa học

- Giai thừa (n!).
- Logarit (log₁₀ x, ln x).
- Hàm lượng giác: sin(x), cos(x), tan(x), cot(x).
- Chuyển đổi đơn vị góc: Độ ↔ Radian.

### Lịch sử tính toán

- Lưu trữ lịch sử phép tính vào file JSON hoặc text.
- Cho phép tìm kiếm các phép tính cũ.
- Hỗ trợ xóa từng dòng lịch sử.

### Giao diện người dùng

- Chuyển đổi giữa chế độ tối (Dark Mode) và sáng (Light Mode).
- Tùy chỉnh phông chữ và màu sắc giao diện.
- Hỗ trợ phím tắt để nhập phép tính.

### Chức năng điều khiển

- Nút CE (Clear Entry) để xóa một số mà không ảnh hưởng phép tính.
- Chức năng Backspace (←) và Forward (→) để chỉnh sửa ký tự theo hai hướng.
- Xử lý nhập liệu cho các biểu thức phức tạp.

### Tính năng bổ sung

- Sao chép/dán kết quả vào/ra clipboard.
- Hỗ trợ tính toán biểu thức phức tạp (ví dụ: "5 + (3 \* 2) - √9").
- Xử lý lỗi nâng cao với thông báo chi tiết cho các đầu vào không hợp lệ (ví dụ: chia cho 0, "5++2", "√-9").

### Xử lý lỗi

- Kiểm tra các trường hợp lỗi như vượt giới hạn, phép toán không hợp lệ.
- Cung cấp thông báo lỗi rõ ràng (ví dụ: "Đầu vào không hợp lệ: √-9").

## Cài đặt

1. **Sao chép kho lưu trữ**:

   - Tải mã nguồn từ GitHub:
     ```bash
     git clone https://github.com/duyvinh09/Calculator_Group4.git
     ```
   - Hoặc tải file ZIP từ GitHub và giải nén.

2. **Mở dự án trong IDE**:

   - **NetBeans**:
     - Mở NetBeans, chọn `File > Open Project`.
     - Điều hướng đến thư mục `Calculator_Group4` và chọn dự án.
     - Đảm bảo đã cài đặt Java (JDK 17 trở lên) và Maven được cấu hình trong NetBeans.
   - **VSCode**:
     - Mở VSCode, chọn `File > Open Folder` và chọn thư mục `Calculator_Group4`.
     - Cài đặt extension `Java Extension Pack` và `Maven for Java` trong VSCode.
     - Đảm bảo đã cài đặt Java (JDK 17 trở lên) và Maven trên máy.

3. **Cài đặt phụ thuộc**:

   - Trong **NetBeans**: Nhấp chuột phải vào dự án, chọn `Build` hoặc `Clean and Build` để tự động cài đặt các phụ thuộc Maven.
   - Trong **VSCode**: Mở terminal trong VSCode (Ctrl+`), chạy:
     ```bash
     mvn install
     ```
     Hoặc nhấp vào biểu tượng Maven ở sidebar và chọn `install`.

4. **Chạy ứng dụng**:
   - Trong **NetBeans**: Nhấp chuột phải vào file `Main.java` (hoặc file chính của ứng dụng), chọn `Run File`.
   - Trong **VSCode**: Nhấp chuột phải vào file `Main.java`, chọn `Run Java` hoặc sử dụng nút `Run` trong editor.

## Hướng dẫn sử dụng

- Khởi động ứng dụng và sử dụng giao diện hoặc phím tắt để thực hiện phép tính.
- Chuyển đổi chế độ tối/sáng thông qua menu cài đặt.
- Xem lịch sử tính toán trong bảng lịch sử để tìm kiếm hoặc xóa mục.
- Sao chép kết quả vào clipboard hoặc dán biểu thức để tính nhanh.

## Kiểm thử

- Ứng dụng đã được kiểm thử cho các trường hợp lỗi, bao gồm:

  - Chia cho 0.
  - Biểu thức không hợp lệ (ví dụ: "5++2", "√-9").
  - Số lớn và các tình huống tràn số.
