create database ql_sanpham
use ql_sanpham
create table danhmuc
(
	MaDM varchar(10) primary key not null,
	TenDM nvarchar(30),
	isDelete bit
)
create table SanPham
(
	MaSP varchar(10) primary key not null,
	TenSP nvarchar(30),
	SoLuong int,
	DonGia float,
	MaDM varchar(10),
	isDelete bit
)
Alter table SanPham
Add constraint fk_sp_dm foreign key(MaDM)
References DanhMuc(MaDM)
-- Thêm dữ liệu vào bảng 'danhmuc'
INSERT INTO danhmuc (MaDM, TenDM, isDelete) VALUES
('DM001', N'Điện thoại di động', 1),
('DM002', N'Laptop', 1),
('DM003', N'Máy tính bảng', 1);

-- Thêm dữ liệu vào bảng 'SanPham'
INSERT INTO SanPham (MaSP, TenSP, SoLuong, DonGia, MaDM, isDelete) VALUES
('SP001', N'iPhone 13 Pro Max', 100, 29990000, 'DM001', 1),
('SP002', N'Samsung Galaxy S21 Ultra', 120, 27990000, 'DM001', 1),
('SP003', N'Dell XPS 15', 80, 45990000, 'DM002', 1),
('SP004', N'MacBook Pro 16-inch', 60, 59990000, 'DM002', 1),
('SP005', N'iPad Pro 12.9-inch', 150, 23990000, 'DM003', 1),
('SP006', N'Samsung Galaxy Tab S7+', 90, 18990000, 'DM003', 1),
('SP007', N'iPhone 12', 80, 21990000, 'DM001', 1),
('SP008', N'Asus ROG Zephyrus G14', 100, 31990000, 'DM002', 1),
('SP009', N'iPad Air 4', 110, 14990000, 'DM003', 1);



