# midtermJava
## 1. Tổng quan về đề tài
Xây dựng trang web bán giày bằng java spring boot với các kiến trúc và nguyên tắc sau:

1/ Kiến trúc Model-View-Controller (MVC): Ứng dụng tuân theo mô hình thiết kế MVC, chia ứng dụng thành ba thành phần - Model, View và Controller. Việc phân tách các trách nhiệm giúp duy trì mã nguồn dễ dàng và làm cho việc sửa đổi hoặc mở rộng ứng dụng trở nên thuận tiện trong tương lai.

2/ Dependency Injection (DI): Ứng dụng sử dụng chức năng DI của Spring Framework để tiêm các phụ thuộc vào các lớp, giảm sự liên kết giữa các thành phần và làm cho mã nguồn trở nên linh hoạt và dễ bảo trì hơn.

3/ Đối tượng-Quan hệ ánh xạ (ORM): Ứng dụng sử dụng Hibernate, một framework ORM, để ánh xạ đối tượng Java vào các bảng cơ sở dữ liệu quan hệ. Lớp trừu tượng này giúp xử lý các vấn đề phức tạp của lập trình hướng đối tượng và cơ sở dữ liệu quan hệ.

4/ Bảo mật Spring (Spring Security): Ứng dụng tích hợp Spring Security, cung cấp một giải pháp toàn diện cho bảo mật ứng dụng. Nó cung cấp các tính năng như xác thực người dùng, quản lý phiên, kiểm soát quyền truy cập và nhiều tính năng bảo mật khác để bảo vệ ứng dụng khỏi các mối đe dọa bảo mật.

#### Website bán giày các chức năng chính:
- Đăng ký
- Đăng nhập
- Hiển thị danh sách sản phẩm
- Tìm kiếm sản phẩm( theo brand, price, category, color)
- Sắp xếp sản phẩm
- Giỏ hàng
- Checkout đơn hàng
## 2. Cơ sở dữ liệu
  Trong project này em sử dụng Mysql là nơi lưu trữ dữ liệu với Mysql WorkBench IDE.
  #### Mô hình Erd của project:
  ![image](https://github.com/lochoang818/midtermJava/assets/143815472/5d2c7e8e-2ae3-41a3-bee8-8303adb3927f)
  
## 3. Các bước để chạy project trên máy

     Bước 1 git clone "https://github.com/lochoang818/midtermJava.git"

    
     Bước 2 tải file midterm.sql trên resource sau đó import vào cơ sở dữ liệu
    
Ví dụ import trong Mysql workbench

![image](https://github.com/lochoang818/midtermJava/assets/143815472/2e40013f-7a78-4386-9821-d5d630dff58d)

Sau đó import file midterm.sql đã tải về 

![image](https://github.com/lochoang818/midtermJava/assets/143815472/d5dcc53d-7e60-4f18-9a01-468ab47901df)

   Bước 3 Nhập [local](http://localhost:8080/auth/login)http://localhost:8080/auth/login
   
  ![image](https://github.com/lochoang818/midtermJava/assets/143815472/6ac8db81-3769-4a7a-b5f0-efa80cc09d41)


  ## 4. Một số api của project
 #### api kiểm tra sau khi user đăng nhập thành công, sẽ trả về 1 token
 ![image](https://github.com/lochoang818/midtermJava/assets/143815472/bd307017-030b-4785-80a4-0cdbd7daad1e)
 #### api filter và sort các mặt hàng theo brand, category, color, price
 ![image](https://github.com/lochoang818/midtermJava/assets/143815472/ec5160e5-2615-4e43-90c0-8b60c93c5651)
 
## 5. Video demo

        - 
  

https://github.com/lochoang818/midtermJava/assets/143815472/8da9c3f3-e7d9-4de5-93db-c9276a30c0f7


