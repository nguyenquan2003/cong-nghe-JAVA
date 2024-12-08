use master
go

--DROP DATABASE QL_QUAN_TRA_SUA
--GO 
-----------------------------------------------------------------------------
create database QL_QUAN_TRA_SUA
GO




use QL_QUAN_TRA_SUA
GO
------------------------------------------------------------------------------

	CREATE TABLE QUYEN
	(
		MAQUYEN VARCHAR(255) NOT NULL, --khóa chính 
		TENQUYEN NVARCHAR(255),
		TAIKHOAN VARCHAR(255) NOT NULL, -- khóa ngoại 
	)
	alter table QUYEN add CONSTRAINT PK_QUYEN PRIMARY KEY (MAQUYEN)


	CREATE TABLE DANGNHAP
	(
		TAIKHOAN VARCHAR(255) NOT NULL,
		MATKHAU VARCHAR(255) NOT NULL,
		MANV VARCHAR (10) NOT NULL,
	)
	alter table DANGNHAP add CONSTRAINT PK_DANGNHAP PRIMARY KEY (TAIKHOAN)
	alter table QUYEN add CONSTRAINT FK_QUYEN_DANGNHAP foreign KEY(TAIKHOAN) references DANGNHAP(TAIKHOAN) 


	--drop table QUYEN
	--drop table DANGNHAP


	CREATE TABLE NHANVIEN 
	(
		MANV VARCHAR (10) NOT NULL,
		TENNV NVARCHAR (255),
		SDT VARCHAR(11),
		CHUCVU NVARCHAR (255),
		DIACHI NVARCHAR (255),
	)
	alter table NHANVIEN add CONSTRAINT PK_NHANVIEN PRIMARY KEY (MANV)
	alter table DANGNHAP add CONSTRAINT FK_DANGNHAP_NHANVIEN foreign KEY(MANV) references NHANVIEN(MANV) 


	create table KHACHHANG
	(
		MAKH VARCHAR (10) NOT NULL,
		TENKH NVARCHAR (255), 
		SDT VARCHAR(11),
	)
	alter table KHACHHANG add CONSTRAINT PK_KHACHHANG PRIMARY KEY (MAKH)


	CREATE TABLE TRASUA
	(
		MATRASUA VARCHAR (10) NOT NULL,
		TENTRASUA NVARCHAR (255), 
		GiaBan INT,
		GiaNhap INT,
		MaNCC VARCHAR (10) NOT NULL,
		IdHinh varchar (255),
	)
	alter table TRASUA add CONSTRAINT PK_TRASUA PRIMARY KEY (MATRASUA)

	create table NhaCungCap
	(
		MaNCC VARCHAR (10) NOT NULL,
		TenNCC NVARCHAR (255), 
		SDT VARCHAR(11),
		TrangThai int,
	)
	alter table NhaCungCap add CONSTRAINT PK_NhaCungCap PRIMARY KEY (MaNCC)
	alter table TRASUA add CONSTRAINT FK_TRASUA_NhaCungCap foreign KEY(MaNCC) references NhaCungCap(MaNCC) 


	--ALTER TABLE HOADON
	--DROP CONSTRAINT PK_HOADON
	--DROP TABLE HOADON
	--DROP TABLE NHANVIEN
	--DROP TABLE KHACHHANG

	CREATE TABLE HoaDonBan 
	(
		MaHDB VARCHAR (10) NOT NULL, -- Mã hóa đơn bán 
		MANV VARCHAR (10) NOT NULL, 
		MAKH VARCHAR (10) NOT NULL,
		TongTienBan float,
		TongTienGiamGia float,
	)
	alter table HoaDonBan add CONSTRAINT PK_HoaDonBan PRIMARY KEY (MaHDB)
	alter table HoaDonBan add CONSTRAINT FK_HoaDonBan_NHANVIEN foreign KEY(MANV) references NHANVIEN(MANV) 
	alter table HoaDonBan add CONSTRAINT FK_HoaDonBan_KHACHHANG foreign KEY(MAKH) references KHACHHANG(MAKH) 

	--ALTER TABLE CHITIETHOADON
	--DROP CONSTRAINT PK_CHITIETHOADON


	--DROP TABLE CHITIETHOADON

	CREATE TABLE ChiTietHoaDon
	(	
		MaHDB VARCHAR (10) NOT NULL,
		MATRASUA VARCHAR (10) NOT NULL,
		SoLuong INT,
		GiamGia float,
		ThanhTien float,
	)
	alter table ChiTietHoaDon add CONSTRAINT PK_ChiTietHoaDon PRIMARY KEY (MaHDB,MATRASUA)
	alter table ChiTietHoaDon add CONSTRAINT FK_ChiTietHoaDon_HoaDonBan foreign KEY(MaHDB) references HoaDonBan(MaHDB) 
	alter table ChiTietHoaDon add CONSTRAINT FK_ChiTietHoaDon_TRASUA foreign KEY(MATRASUA) references TRASUA(MATRASUA) 


	CREATE TABLE PhieuNhap 
	(
		MaPN VARCHAR (10) NOT NULL, --Mã hóa đơn nhập 
		MaNCC VARCHAR (10) NOT NULL,
		MANV VARCHAR (10) NOT NULL,
		TongTienNhap float,
		NgayNhap date,
	)
	alter table PhieuNhap add CONSTRAINT PK_PhieuNhap PRIMARY KEY (MaPN)
	alter table PhieuNhap add CONSTRAINT FK_PhieuNhap_NhaCungCap foreign KEY(MaNCC) references NhaCungCap(MaNCC) 
	alter table PhieuNhap add CONSTRAINT FK_PhieuNhap_NHANVIEN foreign KEY(MANV) references NHANVIEN(MANV) 


	CREATE TABLE ChiTietPhieuNhap 
	(
		MaCTPN VARCHAR (10) NOT NULL,
		MaPN VARCHAR (10) NOT NULL,
		SoLuong INT,
		GiaNhap float,
	)
	alter table ChiTietPhieuNhap add CONSTRAINT PK_ChiTietPhieuNhap PRIMARY KEY (MaCTPN)
	alter table ChiTietPhieuNhap add CONSTRAINT FK_ChiTietPhieuNhap_PhieuNhap foreign KEY(MaPN) references PhieuNhap(MaPN) 

	--ALTER TABLE HOADON 
	--ADD
	--CONSTRAINT FK_MANHANVIEN FOREIGN KEY (MANHANVIEN) REFERENCES NHANVIEN(MANHANVIEN),
	--CONSTRAINT FK_MAKHACHHANG FOREIGN KEY (MAKHACHHANG) REFERENCES KHACHHANG(MAKHACHHANG)

	--ALTER TABLE CHITIETHOADON 
	--ADD 
	--CONSTRAINT FK_MATRASUA FOREIGN KEY (MATRASUA) REFERENCES TRASUA(MATRASUA)

	--ALTER TABLE CHITIETHOADON 
	--ADD
	--CONSTRAINT FK_MAHOADON FOREIGN KEY (MAHOADON) REFERENCES HOADON(MAHOADON)
	
	--ALTER TABLE HOADON 

	--DROP CONSTRAIN FK_MANHANVIEN,
	--DROP CONSTRAIN FK_MAKHACHHANG

	--MAQUYEN VARCHAR(255) NOT NULL, --khóa chính 
	--	TENQUYEN NVARCHAR(255),
	--	TAIKHOAN VARCHAR(255) NOT NULL, -- khóa ngoại 

		insert into NHANVIEN values ('NV001',N' Nguyễn Văn A', '04255352562',N' Quản lý',N' Thành phố Hồ Chí Minh'),
								('NV002',N' Nguyễn Cát Tường','0352576389',N' Nhân viên',N'Bến Tre'),
								('NV003',N' Bình Tiểu Lĩnh','0375849219',N' Nhân viên',N'Bình Thuận'),
								('NV004',N' Nguyễn An Vinh','0743939858',N' Nhân  viên',N'Đăk Lăk')

	select * from NHANVIEN

		insert into DANGNHAP values  ('admin','admin123','NV001'),
								('tuongnc','tuong123','NV002'),
								('linhbt','linh123','NV003'),
								('vinhna','vinh123','NV004')


	select * from DANGNHAP

	insert into QUYEN values ('QL1', N' Quản Lý', 'admin'),
							('NV1', N' Nhân Viên', 'tuongnc'),
							('NV2', N' Nhân Viên', 'linhbt'),
							('NV3', N' Nhân Viên', 'vinhna')
	select * from QUYEN







	insert into KHACHHANG values ('KH001',N' Nguyễn Thị B','0587692446'),
								 ('KH002',N' Huỳnh Văn C','0694855687'),
								 ('KH003',N' Trần Chí C','0385922016'),
								 ('KH004',N' Đặng Thanh D','0692987765'),
								 ('KH005',N' Đinh Thành H','0847285998')

	select * from KHACHHANG

	 insert into NhaCungCap values ('S0001',N' Trà thông thường', '0538390221',1),
									('S0002',N' Dứa thơm xanh', '056852956',1),
									('S0003',N' Dâu tây Đà Lạt', '0475855769',1),
									('S0004',N'  Socola Bình Dương','0234968587',1),
									('S0005',N' Chuối Chợ Lách','0685776923',1)

	select * from NhaCungCap

	insert into TRASUA values
							('TS001',N' Trà sữa truyền thống size M', 15000, 5000, 'S0001','trasuatruyenthong.jpg'),
							('TS002',N' Trà sữa truyền thống size L', 20000, 10000, 'S0001','trasuatruyenthong.jpg'),	
							('TS003',N' Trà sữa hương dứa full topping size M', 20000,10000,'S0002','trasuahuongdua.jpg'),
						    ('TS004',N' Trà sữa hương dứa full topping sile L', 25000,15000,'S0002','trasuahuongdua.jpg'),
							('TS005',N' Trà sữa hương dâu chân trâu trắng size M', 15000, 5000,'S0003','trasuahuongdautranchautrang.jpg'),
							('TS006',N' Trà sữa hương dâu chân trâu trắng sile L', 20000, 10000,'S0003','trasuahuongdautranchautrang.jpg'),
							('TS007',N'Trà sữa hương socola size M', 20000, 10000, 'S0004','trasuasocola.jpg'),
							('TS008',N'Trà sữa hương socola size L', 25000, 15000, 'S0004','trasuasocola.jpg'),
						    ('TS009',N' Trà sữa hương chuối trân châu đường đen size M', 20000, 10000, 'S0005','trasuachuoi.jpg'),
							('TS010',N' Trà sữa hương chuối trân châu đường đen size L', 25000, 15000, 'S0005','trasuachuoi.jpg')
	 
	 select  * from TRASUA

	

	insert into HoaDonBan values ('HD001','NV002','KH001', 15000,0),
	                             ('HD002','NV001','KH002', 15000,0),
								 ('HD003','NV003','KH003', 15000,0),
								 ('HD004','NV001','KH001', 15000,0),
								 ('HD005','NV002','KH003', 15000,0),
								 ('HD006','NV002','KH003', 15000,0)
	select *  from HoaDonBan

	insert into ChiTietHoaDon values  ('HD001','TS001',2,0, 30000),
	                                  ('HD002','TS002',2,0, 30000),
									  ('HD003','TS003',1,0, 15000),
									  ('HD004','TS005',1,0, 15000)
									  
	select * from ChiTietHoaDon


	--MaPN VARCHAR (10) NOT NULL, --Mã hóa đơn nhập 
	--	MaNCC VARCHAR (10) NOT NULL,
	--	MANV VARCHAR (10) NOT NULL,
	--	TongTienNhap float,
	--	NgayNhap date,
	
	insert into PhieuNhap values ( 'PN001','S0001', 'NV001', 1000000, '2024/04/15'),
	                             ( 'PN002','S0001', 'NV001', 1000000, '2024/04/16'),
								 ( 'PN003','S0002', 'NV003', 1000000, '2024/04/17'),
								 ( 'PN004','S0003', 'NV002', 1000000, '2024/04/17'),
								 ( 'PN005','S0003', 'NV002', 1000000, '2024/04/18')
	select * from PhieuNhap


	--MaCTPN VARCHAR (10) NOT NULL,
	--	MaPN VARCHAR (10) NOT NULL,
	--	SoLuong INT,
	--	GiaNhap float,

	insert into ChiTietPhieuNhap values ('CP001','PN001',1,1000000),
										('CP002','PN002',1,1000000),
										('CP003','PN003',1,1000000),
										('CP004','PN004',1,1000000),
										('CP005','PN005',1,1000000)

	select * from ChiTietPhieuNhap


	
