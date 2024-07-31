USE [master]
GO
/****** Object:  Database [QLCaPhe]    Script Date: 5/30/2024 8:23:54 PM ******/
CREATE DATABASE [QLCaPhe]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QLCaPhe', FILENAME = N'd:\Program Files\Microsoft SQL Server\MSSQL16.SQLEXPRESS\MSSQL\DATA\QLCaPhe.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'QLCaPhe_log', FILENAME = N'd:\Program Files\Microsoft SQL Server\MSSQL16.SQLEXPRESS\MSSQL\DATA\QLCaPhe_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [QLCaPhe] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QLCaPhe].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QLCaPhe] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QLCaPhe] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QLCaPhe] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QLCaPhe] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QLCaPhe] SET ARITHABORT OFF 
GO
ALTER DATABASE [QLCaPhe] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [QLCaPhe] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QLCaPhe] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QLCaPhe] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QLCaPhe] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QLCaPhe] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QLCaPhe] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QLCaPhe] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QLCaPhe] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QLCaPhe] SET  ENABLE_BROKER 
GO
ALTER DATABASE [QLCaPhe] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QLCaPhe] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QLCaPhe] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QLCaPhe] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QLCaPhe] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QLCaPhe] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QLCaPhe] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QLCaPhe] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [QLCaPhe] SET  MULTI_USER 
GO
ALTER DATABASE [QLCaPhe] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QLCaPhe] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QLCaPhe] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QLCaPhe] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [QLCaPhe] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [QLCaPhe] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [QLCaPhe] SET QUERY_STORE = ON
GO
ALTER DATABASE [QLCaPhe] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [QLCaPhe]
GO
/****** Object:  Table [dbo].[Ban]    Script Date: 5/30/2024 8:23:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Ban](
	[ID_Ban] [varchar](10) NOT NULL,
	[Ten_Ban] [nvarchar](50) NULL,
	[ViTri] [nvarchar](50) NULL,
	[TinhTrang] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[ID_Ban] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChucVuNhanVien]    Script Date: 5/30/2024 8:23:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChucVuNhanVien](
	[ID_ChucVu] [varchar](10) NOT NULL,
	[TenChucVu] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID_ChucVu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CTHD]    Script Date: 5/30/2024 8:23:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CTHD](
	[ID_HoaDon] [varchar](10) NOT NULL,
	[ID_SanPham] [varchar](10) NOT NULL,
	[SOLUONG] [int] NOT NULL,
	[THANHTIEN] [float] NULL,
 CONSTRAINT [PK_CTHD] PRIMARY KEY CLUSTERED 
(
	[ID_HoaDon] ASC,
	[ID_SanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 5/30/2024 8:23:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[ID_HoaDon] [varchar](10) NOT NULL,
	[ID_Ban] [varchar](10) NULL,
	[NGAYHD] [date] NOT NULL,
	[TIENMONAN] [float] NULL,
	[ID_PhuThu] [varchar](10) NULL,
	[TIENGIAM] [float] NULL,
	[TONGTIEN] [float] NULL,
	[TRANGTHAI] [nvarchar](50) NULL,
	[MaNV] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID_HoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LoaiSanPham]    Script Date: 5/30/2024 8:23:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiSanPham](
	[ID_LoaiSanPham] [varchar](10) NOT NULL,
	[Ten_LoaiSanPham] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID_LoaiSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 5/30/2024 8:23:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[MaNV] [varchar](10) NOT NULL,
	[TenNV] [nvarchar](50) NULL,
	[NgaySinh] [date] NULL,
	[cccd] [char](15) NOT NULL,
	[sdt] [char](12) NULL,
	[GioiTinh] [nvarchar](5) NULL,
	[ID_ChucVu] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhuThu]    Script Date: 5/30/2024 8:23:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhuThu](
	[ID_PhuThu] [varchar](10) NOT NULL,
	[Ten_PhuThu] [nvarchar](50) NULL,
	[PhanTram] [decimal](5, 2) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID_PhuThu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 5/30/2024 8:23:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[ID_SanPham] [varchar](10) NOT NULL,
	[Ten_SanPham] [nvarchar](50) NULL,
	[Gia] [decimal](10, 2) NULL,
	[ID_LoaiSanPham] [varchar](10) NULL,
	[MoTa] [text] NULL,
PRIMARY KEY CLUSTERED 
(
	[ID_SanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TkNhanVien]    Script Date: 5/30/2024 8:23:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TkNhanVien](
	[ID_TaiKhoan] [varchar](10) NOT NULL,
	[Taikhoan] [varchar](30) NULL,
	[MatKhau] [varchar](30) NULL,
	[MaNV] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID_TaiKhoan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Ban] ([ID_Ban], [Ten_Ban], [ViTri], [TinhTrang]) VALUES (N'01', N'Bàn A1', N'Góc cửa sổ', 1)
INSERT [dbo].[Ban] ([ID_Ban], [Ten_Ban], [ViTri], [TinhTrang]) VALUES (N'02', N'Bàn A2', N'Gần Thu Ngân', 1)
INSERT [dbo].[Ban] ([ID_Ban], [Ten_Ban], [ViTri], [TinhTrang]) VALUES (N'03', N'Take away ', N'  ', 0)
INSERT [dbo].[Ban] ([ID_Ban], [Ten_Ban], [ViTri], [TinhTrang]) VALUES (N'04', N'Bàn A3', N'Trung Tâm', 0)
INSERT [dbo].[Ban] ([ID_Ban], [Ten_Ban], [ViTri], [TinhTrang]) VALUES (N'05', N'Bàn A4', N'Góc cửa sổ', 0)
INSERT [dbo].[Ban] ([ID_Ban], [Ten_Ban], [ViTri], [TinhTrang]) VALUES (N'06', N'Bàn A5', N'Gần Thu Ngân', 1)
INSERT [dbo].[Ban] ([ID_Ban], [Ten_Ban], [ViTri], [TinhTrang]) VALUES (N'07', N'Bàn A6', N'Góc cửa sổ', 0)
INSERT [dbo].[Ban] ([ID_Ban], [Ten_Ban], [ViTri], [TinhTrang]) VALUES (N'08', N'Bàn A7', N'Trung Tâm', 1)
INSERT [dbo].[Ban] ([ID_Ban], [Ten_Ban], [ViTri], [TinhTrang]) VALUES (N'09', N'Bàn A8', N'Góc cửa sổ', 0)
INSERT [dbo].[Ban] ([ID_Ban], [Ten_Ban], [ViTri], [TinhTrang]) VALUES (N'10', N'Bàn A9', N'Gần Thu Ngân', 0)
INSERT [dbo].[Ban] ([ID_Ban], [Ten_Ban], [ViTri], [TinhTrang]) VALUES (N'11', N'Bàn A10', N'Góc cửa sổ', 0)
INSERT [dbo].[Ban] ([ID_Ban], [Ten_Ban], [ViTri], [TinhTrang]) VALUES (N'12', N'Bàn A11', N'Gần Thu Ngân', 1)
INSERT [dbo].[Ban] ([ID_Ban], [Ten_Ban], [ViTri], [TinhTrang]) VALUES (N'13', N'Bàn A12', N'Trung Tâm', 1)
INSERT [dbo].[Ban] ([ID_Ban], [Ten_Ban], [ViTri], [TinhTrang]) VALUES (N'14', N'Bàn A13', N'Góc cửa sổ', 0)
INSERT [dbo].[Ban] ([ID_Ban], [Ten_Ban], [ViTri], [TinhTrang]) VALUES (N'15', N'Bàn A14', N'Gần Thu Ngân', 0)
INSERT [dbo].[Ban] ([ID_Ban], [Ten_Ban], [ViTri], [TinhTrang]) VALUES (N'16', N'Bàn B1', N'Góc tầng B', 1)
INSERT [dbo].[Ban] ([ID_Ban], [Ten_Ban], [ViTri], [TinhTrang]) VALUES (N'17', N'Bàn B2', N'Gần cầu thang tầng B', 1)
INSERT [dbo].[Ban] ([ID_Ban], [Ten_Ban], [ViTri], [TinhTrang]) VALUES (N'18', N'Bàn B3', N'Trung tâm tầng B', 0)
INSERT [dbo].[Ban] ([ID_Ban], [Ten_Ban], [ViTri], [TinhTrang]) VALUES (N'19', N'Bàn B4', N'Góc tầng B', 0)
INSERT [dbo].[Ban] ([ID_Ban], [Ten_Ban], [ViTri], [TinhTrang]) VALUES (N'20', N'Bàn B5', N'Gần cầu thang tầng B', 0)
INSERT [dbo].[Ban] ([ID_Ban], [Ten_Ban], [ViTri], [TinhTrang]) VALUES (N'21', N'Bàn C1', N'Góc tầng C', 0)
INSERT [dbo].[Ban] ([ID_Ban], [Ten_Ban], [ViTri], [TinhTrang]) VALUES (N'22', N'Bàn C2', N'Gần cửa ra vào', 0)
INSERT [dbo].[Ban] ([ID_Ban], [Ten_Ban], [ViTri], [TinhTrang]) VALUES (N'23', N'Bàn C3', N'Trung tâm tầng C', 0)
INSERT [dbo].[Ban] ([ID_Ban], [Ten_Ban], [ViTri], [TinhTrang]) VALUES (N'24', N'Bàn C4', N'Góc tầng C', 1)
INSERT [dbo].[Ban] ([ID_Ban], [Ten_Ban], [ViTri], [TinhTrang]) VALUES (N'25', N'Bàn C5', N'Gần cửa sổ', 0)
INSERT [dbo].[Ban] ([ID_Ban], [Ten_Ban], [ViTri], [TinhTrang]) VALUES (N'26', N'Bàn C6', N'Gần cầu thang', 1)
INSERT [dbo].[Ban] ([ID_Ban], [Ten_Ban], [ViTri], [TinhTrang]) VALUES (N'27', N'Bàn C7', N'Góc tầng C', 0)
INSERT [dbo].[Ban] ([ID_Ban], [Ten_Ban], [ViTri], [TinhTrang]) VALUES (N'28', N'Bàn C8', N'Trung tâm tầng C', 0)
INSERT [dbo].[Ban] ([ID_Ban], [Ten_Ban], [ViTri], [TinhTrang]) VALUES (N'29', N'Bàn C9', N'Gần cửa sổ', 0)
INSERT [dbo].[Ban] ([ID_Ban], [Ten_Ban], [ViTri], [TinhTrang]) VALUES (N'30', N'Bàn C10', N'Góc tầng C', 1)
INSERT [dbo].[Ban] ([ID_Ban], [Ten_Ban], [ViTri], [TinhTrang]) VALUES (N'31', N'Bàn C11', N'Gần cửa ra vào', 0)
INSERT [dbo].[Ban] ([ID_Ban], [Ten_Ban], [ViTri], [TinhTrang]) VALUES (N'32', N'Bàn C12', N'Trung tâm tầng C', 0)
INSERT [dbo].[Ban] ([ID_Ban], [Ten_Ban], [ViTri], [TinhTrang]) VALUES (N'33', N'Bàn D03', N'Tầng D14', 1)
GO
INSERT [dbo].[ChucVuNhanVien] ([ID_ChucVu], [TenChucVu]) VALUES (N'111', N'Thu ngân')
INSERT [dbo].[ChucVuNhanVien] ([ID_ChucVu], [TenChucVu]) VALUES (N'112', N'Phục vụ')
INSERT [dbo].[ChucVuNhanVien] ([ID_ChucVu], [TenChucVu]) VALUES (N'113', N'Quản lý')
INSERT [dbo].[ChucVuNhanVien] ([ID_ChucVu], [TenChucVu]) VALUES (N'114', N'Bảo vệ')
INSERT [dbo].[ChucVuNhanVien] ([ID_ChucVu], [TenChucVu]) VALUES (N'115', N'Kế toán')
INSERT [dbo].[ChucVuNhanVien] ([ID_ChucVu], [TenChucVu]) VALUES (N'116', N'Pha chế')
INSERT [dbo].[ChucVuNhanVien] ([ID_ChucVu], [TenChucVu]) VALUES (N'117', N'Vệ sinh')
INSERT [dbo].[ChucVuNhanVien] ([ID_ChucVu], [TenChucVu]) VALUES (N'118', N'Giao hàng')
GO
INSERT [dbo].[CTHD] ([ID_HoaDon], [ID_SanPham], [SOLUONG], [THANHTIEN]) VALUES (N'101', N'1', 2, 50000)
INSERT [dbo].[CTHD] ([ID_HoaDon], [ID_SanPham], [SOLUONG], [THANHTIEN]) VALUES (N'101', N'10', 3, 20000)
INSERT [dbo].[CTHD] ([ID_HoaDon], [ID_SanPham], [SOLUONG], [THANHTIEN]) VALUES (N'101', N'26', 2, 44000)
INSERT [dbo].[CTHD] ([ID_HoaDon], [ID_SanPham], [SOLUONG], [THANHTIEN]) VALUES (N'102', N'1', 2, 50000)
INSERT [dbo].[CTHD] ([ID_HoaDon], [ID_SanPham], [SOLUONG], [THANHTIEN]) VALUES (N'102', N'2', 1, 30000)
INSERT [dbo].[CTHD] ([ID_HoaDon], [ID_SanPham], [SOLUONG], [THANHTIEN]) VALUES (N'103', N'12', 2, 44000)
INSERT [dbo].[CTHD] ([ID_HoaDon], [ID_SanPham], [SOLUONG], [THANHTIEN]) VALUES (N'104', N'30', 3, 32000)
INSERT [dbo].[CTHD] ([ID_HoaDon], [ID_SanPham], [SOLUONG], [THANHTIEN]) VALUES (N'105', N'1', 2, 50000)
INSERT [dbo].[CTHD] ([ID_HoaDon], [ID_SanPham], [SOLUONG], [THANHTIEN]) VALUES (N'105', N'14', 2, 56000)
INSERT [dbo].[CTHD] ([ID_HoaDon], [ID_SanPham], [SOLUONG], [THANHTIEN]) VALUES (N'105', N'28', 1, 36000)
INSERT [dbo].[CTHD] ([ID_HoaDon], [ID_SanPham], [SOLUONG], [THANHTIEN]) VALUES (N'106', N'27', 4, 100000)
INSERT [dbo].[CTHD] ([ID_HoaDon], [ID_SanPham], [SOLUONG], [THANHTIEN]) VALUES (N'106', N'38', 2, 90000)
INSERT [dbo].[CTHD] ([ID_HoaDon], [ID_SanPham], [SOLUONG], [THANHTIEN]) VALUES (N'106', N'49', 3, 54000)
INSERT [dbo].[CTHD] ([ID_HoaDon], [ID_SanPham], [SOLUONG], [THANHTIEN]) VALUES (N'107', N'12', 5, 44000)
INSERT [dbo].[CTHD] ([ID_HoaDon], [ID_SanPham], [SOLUONG], [THANHTIEN]) VALUES (N'107', N'32', 2, 66000)
INSERT [dbo].[CTHD] ([ID_HoaDon], [ID_SanPham], [SOLUONG], [THANHTIEN]) VALUES (N'108', N'12', 1, 44000)
INSERT [dbo].[CTHD] ([ID_HoaDon], [ID_SanPham], [SOLUONG], [THANHTIEN]) VALUES (N'108', N'40', 4, 24000)
INSERT [dbo].[CTHD] ([ID_HoaDon], [ID_SanPham], [SOLUONG], [THANHTIEN]) VALUES (N'109', N'45', 4, 128000)
INSERT [dbo].[CTHD] ([ID_HoaDon], [ID_SanPham], [SOLUONG], [THANHTIEN]) VALUES (N'110', N'1', 2, 50000)
INSERT [dbo].[CTHD] ([ID_HoaDon], [ID_SanPham], [SOLUONG], [THANHTIEN]) VALUES (N'110', N'11', 2, 40000)
INSERT [dbo].[CTHD] ([ID_HoaDon], [ID_SanPham], [SOLUONG], [THANHTIEN]) VALUES (N'110', N'34', 2, 108000)
INSERT [dbo].[CTHD] ([ID_HoaDon], [ID_SanPham], [SOLUONG], [THANHTIEN]) VALUES (N'110', N'43', 4, 60000)
INSERT [dbo].[CTHD] ([ID_HoaDon], [ID_SanPham], [SOLUONG], [THANHTIEN]) VALUES (N'111', N'25', 2, 24000)
INSERT [dbo].[CTHD] ([ID_HoaDon], [ID_SanPham], [SOLUONG], [THANHTIEN]) VALUES (N'111', N'47', 4, 10000)
INSERT [dbo].[CTHD] ([ID_HoaDon], [ID_SanPham], [SOLUONG], [THANHTIEN]) VALUES (N'112', N'21', 2, 50000)
INSERT [dbo].[CTHD] ([ID_HoaDon], [ID_SanPham], [SOLUONG], [THANHTIEN]) VALUES (N'112', N'31', 5, 64000)
INSERT [dbo].[CTHD] ([ID_HoaDon], [ID_SanPham], [SOLUONG], [THANHTIEN]) VALUES (N'112', N'49', 3, 54000)
INSERT [dbo].[CTHD] ([ID_HoaDon], [ID_SanPham], [SOLUONG], [THANHTIEN]) VALUES (N'113', N'40', 2, 24000)
INSERT [dbo].[CTHD] ([ID_HoaDon], [ID_SanPham], [SOLUONG], [THANHTIEN]) VALUES (N'114', N'30', 2, 32000)
INSERT [dbo].[CTHD] ([ID_HoaDon], [ID_SanPham], [SOLUONG], [THANHTIEN]) VALUES (N'114', N'32', 3, 66000)
INSERT [dbo].[CTHD] ([ID_HoaDon], [ID_SanPham], [SOLUONG], [THANHTIEN]) VALUES (N'115', N'1', 2, 50000)
INSERT [dbo].[CTHD] ([ID_HoaDon], [ID_SanPham], [SOLUONG], [THANHTIEN]) VALUES (N'115', N'12', 2, 44000)
INSERT [dbo].[CTHD] ([ID_HoaDon], [ID_SanPham], [SOLUONG], [THANHTIEN]) VALUES (N'115', N'40', 2, 24000)
INSERT [dbo].[CTHD] ([ID_HoaDon], [ID_SanPham], [SOLUONG], [THANHTIEN]) VALUES (N'115', N'44', 2, 50000)
INSERT [dbo].[CTHD] ([ID_HoaDon], [ID_SanPham], [SOLUONG], [THANHTIEN]) VALUES (N'116', N'34', 1, 108000)
INSERT [dbo].[CTHD] ([ID_HoaDon], [ID_SanPham], [SOLUONG], [THANHTIEN]) VALUES (N'116', N'47', 2, 10000)
INSERT [dbo].[CTHD] ([ID_HoaDon], [ID_SanPham], [SOLUONG], [THANHTIEN]) VALUES (N'117', N'13', 2, 50000)
INSERT [dbo].[CTHD] ([ID_HoaDon], [ID_SanPham], [SOLUONG], [THANHTIEN]) VALUES (N'118', N'34', 10, 108000)
INSERT [dbo].[CTHD] ([ID_HoaDon], [ID_SanPham], [SOLUONG], [THANHTIEN]) VALUES (N'118', N'35', 5, 90000)
INSERT [dbo].[CTHD] ([ID_HoaDon], [ID_SanPham], [SOLUONG], [THANHTIEN]) VALUES (N'119', N'28', 2, 36000)
INSERT [dbo].[CTHD] ([ID_HoaDon], [ID_SanPham], [SOLUONG], [THANHTIEN]) VALUES (N'119', N'43', 2, 60000)
INSERT [dbo].[CTHD] ([ID_HoaDon], [ID_SanPham], [SOLUONG], [THANHTIEN]) VALUES (N'120', N'38', 5, 90000)
INSERT [dbo].[CTHD] ([ID_HoaDon], [ID_SanPham], [SOLUONG], [THANHTIEN]) VALUES (N'120', N'39', 4, 88000)
INSERT [dbo].[CTHD] ([ID_HoaDon], [ID_SanPham], [SOLUONG], [THANHTIEN]) VALUES (N'121', N'31', 4, 64000)
INSERT [dbo].[CTHD] ([ID_HoaDon], [ID_SanPham], [SOLUONG], [THANHTIEN]) VALUES (N'122', N'33', 5, 110000)
INSERT [dbo].[CTHD] ([ID_HoaDon], [ID_SanPham], [SOLUONG], [THANHTIEN]) VALUES (N'122', N'34', 6, 108000)
INSERT [dbo].[CTHD] ([ID_HoaDon], [ID_SanPham], [SOLUONG], [THANHTIEN]) VALUES (N'123', N'1', 2, 50000)
INSERT [dbo].[CTHD] ([ID_HoaDon], [ID_SanPham], [SOLUONG], [THANHTIEN]) VALUES (N'123', N'23', 6, 45000)
INSERT [dbo].[CTHD] ([ID_HoaDon], [ID_SanPham], [SOLUONG], [THANHTIEN]) VALUES (N'124', N'13', 3, 50000)
INSERT [dbo].[CTHD] ([ID_HoaDon], [ID_SanPham], [SOLUONG], [THANHTIEN]) VALUES (N'125', N'6', 5, 100000)
INSERT [dbo].[CTHD] ([ID_HoaDon], [ID_SanPham], [SOLUONG], [THANHTIEN]) VALUES (N'126', N'3', 5, 75000)
INSERT [dbo].[CTHD] ([ID_HoaDon], [ID_SanPham], [SOLUONG], [THANHTIEN]) VALUES (N'130', N'1', 2, 50000)
INSERT [dbo].[CTHD] ([ID_HoaDon], [ID_SanPham], [SOLUONG], [THANHTIEN]) VALUES (N'130', N'13', 2, 50000)
INSERT [dbo].[CTHD] ([ID_HoaDon], [ID_SanPham], [SOLUONG], [THANHTIEN]) VALUES (N'132', N'1', 2, 50000)
INSERT [dbo].[CTHD] ([ID_HoaDon], [ID_SanPham], [SOLUONG], [THANHTIEN]) VALUES (N'134', N'12', 2, 44000)
INSERT [dbo].[CTHD] ([ID_HoaDon], [ID_SanPham], [SOLUONG], [THANHTIEN]) VALUES (N'138', N'1', 2, 50000)
INSERT [dbo].[CTHD] ([ID_HoaDon], [ID_SanPham], [SOLUONG], [THANHTIEN]) VALUES (N'140', N'1', 2, 50000)
INSERT [dbo].[CTHD] ([ID_HoaDon], [ID_SanPham], [SOLUONG], [THANHTIEN]) VALUES (N'142', N'1', 2, 50000)
INSERT [dbo].[CTHD] ([ID_HoaDon], [ID_SanPham], [SOLUONG], [THANHTIEN]) VALUES (N'144', N'1', 2, 50000)
GO
INSERT [dbo].[HoaDon] ([ID_HoaDon], [ID_Ban], [NGAYHD], [TIENMONAN], [ID_PhuThu], [TIENGIAM], [TONGTIEN], [TRANGTHAI], [MaNV]) VALUES (N'101', N'01', CAST(N'2023-01-10' AS Date), 1207000, NULL, 0, 1207000, N'Chua thanh toan', N'727581')
INSERT [dbo].[HoaDon] ([ID_HoaDon], [ID_Ban], [NGAYHD], [TIENMONAN], [ID_PhuThu], [TIENGIAM], [TONGTIEN], [TRANGTHAI], [MaNV]) VALUES (N'102', N'02', CAST(N'2023-01-15' AS Date), 1207000, NULL, 0, 1207000, N'Chua thanh toan', N'727582')
INSERT [dbo].[HoaDon] ([ID_HoaDon], [ID_Ban], [NGAYHD], [TIENMONAN], [ID_PhuThu], [TIENGIAM], [TONGTIEN], [TRANGTHAI], [MaNV]) VALUES (N'103', N'03', CAST(N'2023-01-20' AS Date), 434000, NULL, 0, 434000, N'Da thanh toan', N'727582')
INSERT [dbo].[HoaDon] ([ID_HoaDon], [ID_Ban], [NGAYHD], [TIENMONAN], [ID_PhuThu], [TIENGIAM], [TONGTIEN], [TRANGTHAI], [MaNV]) VALUES (N'104', N'01', CAST(N'2023-02-13' AS Date), 64000, NULL, 0, 64000, N'Da thanh toan', N'74534')
INSERT [dbo].[HoaDon] ([ID_HoaDon], [ID_Ban], [NGAYHD], [TIENMONAN], [ID_PhuThu], [TIENGIAM], [TONGTIEN], [TRANGTHAI], [MaNV]) VALUES (N'105', N'12', CAST(N'2023-02-12' AS Date), 1207000, NULL, 0, 1207000, N'Chua thanh toan', N'74537')
INSERT [dbo].[HoaDon] ([ID_HoaDon], [ID_Ban], [NGAYHD], [TIENMONAN], [ID_PhuThu], [TIENGIAM], [TONGTIEN], [TRANGTHAI], [MaNV]) VALUES (N'106', N'10', CAST(N'2023-03-16' AS Date), 334000, NULL, 0, 334000, N'Chua thanh toan', N'74538')
INSERT [dbo].[HoaDon] ([ID_HoaDon], [ID_Ban], [NGAYHD], [TIENMONAN], [ID_PhuThu], [TIENGIAM], [TONGTIEN], [TRANGTHAI], [MaNV]) VALUES (N'107', N'01', CAST(N'2023-03-20' AS Date), 434000, NULL, 0, 434000, N'Da thanh toan', N'727581')
INSERT [dbo].[HoaDon] ([ID_HoaDon], [ID_Ban], [NGAYHD], [TIENMONAN], [ID_PhuThu], [TIENGIAM], [TONGTIEN], [TRANGTHAI], [MaNV]) VALUES (N'108', N'01', CAST(N'2023-04-10' AS Date), 434000, NULL, 0, 434000, N'Da thanh toan', N'74534')
INSERT [dbo].[HoaDon] ([ID_HoaDon], [ID_Ban], [NGAYHD], [TIENMONAN], [ID_PhuThu], [TIENGIAM], [TONGTIEN], [TRANGTHAI], [MaNV]) VALUES (N'109', N'10', CAST(N'2023-04-20' AS Date), 128000, NULL, 0, 128000, N'Da thanh toan', N'727581')
INSERT [dbo].[HoaDon] ([ID_HoaDon], [ID_Ban], [NGAYHD], [TIENMONAN], [ID_PhuThu], [TIENGIAM], [TONGTIEN], [TRANGTHAI], [MaNV]) VALUES (N'110', N'01', CAST(N'2023-05-05' AS Date), 1207000, NULL, 0, 1207000, N'Da thanh toan', N'727583')
INSERT [dbo].[HoaDon] ([ID_HoaDon], [ID_Ban], [NGAYHD], [TIENMONAN], [ID_PhuThu], [TIENGIAM], [TONGTIEN], [TRANGTHAI], [MaNV]) VALUES (N'111', N'02', CAST(N'2023-05-10' AS Date), 44000, NULL, 0, 44000, N'Da thanh toan', N'727581')
INSERT [dbo].[HoaDon] ([ID_HoaDon], [ID_Ban], [NGAYHD], [TIENMONAN], [ID_PhuThu], [TIENGIAM], [TONGTIEN], [TRANGTHAI], [MaNV]) VALUES (N'112', N'03', CAST(N'2023-05-15' AS Date), 232000, NULL, 0, 232000, N'Da thanh toan', N'75231')
INSERT [dbo].[HoaDon] ([ID_HoaDon], [ID_Ban], [NGAYHD], [TIENMONAN], [ID_PhuThu], [TIENGIAM], [TONGTIEN], [TRANGTHAI], [MaNV]) VALUES (N'113', N'02', CAST(N'2023-05-20' AS Date), 94000, NULL, 0, 94000, N'Da thanh toan', N'74538')
INSERT [dbo].[HoaDon] ([ID_HoaDon], [ID_Ban], [NGAYHD], [TIENMONAN], [ID_PhuThu], [TIENGIAM], [TONGTIEN], [TRANGTHAI], [MaNV]) VALUES (N'114', N'03', CAST(N'2023-06-05' AS Date), 98000, NULL, 0, 98000, N'Da thanh toan', N'74537')
INSERT [dbo].[HoaDon] ([ID_HoaDon], [ID_Ban], [NGAYHD], [TIENMONAN], [ID_PhuThu], [TIENGIAM], [TONGTIEN], [TRANGTHAI], [MaNV]) VALUES (N'115', N'04', CAST(N'2023-06-07' AS Date), 1207000, NULL, 0, 1207000, N'Da thanh toan', N'74536')
INSERT [dbo].[HoaDon] ([ID_HoaDon], [ID_Ban], [NGAYHD], [TIENMONAN], [ID_PhuThu], [TIENGIAM], [TONGTIEN], [TRANGTHAI], [MaNV]) VALUES (N'116', N'05', CAST(N'2023-06-07' AS Date), 702000, NULL, 0, 702000, N'Da thanh toan', N'74535')
INSERT [dbo].[HoaDon] ([ID_HoaDon], [ID_Ban], [NGAYHD], [TIENMONAN], [ID_PhuThu], [TIENGIAM], [TONGTIEN], [TRANGTHAI], [MaNV]) VALUES (N'117', N'06', CAST(N'2023-06-10' AS Date), 50000, NULL, 0, 50000, N'Chua thanh toan', N'74534')
INSERT [dbo].[HoaDon] ([ID_HoaDon], [ID_Ban], [NGAYHD], [TIENMONAN], [ID_PhuThu], [TIENGIAM], [TONGTIEN], [TRANGTHAI], [MaNV]) VALUES (N'118', N'06', CAST(N'2023-02-10' AS Date), 702000, NULL, 0, 702000, N'Da thanh toan', N'727583')
INSERT [dbo].[HoaDon] ([ID_HoaDon], [ID_Ban], [NGAYHD], [TIENMONAN], [ID_PhuThu], [TIENGIAM], [TONGTIEN], [TRANGTHAI], [MaNV]) VALUES (N'119', N'06', CAST(N'2023-02-12' AS Date), 96000, NULL, 0, 96000, N'Da thanh toan', N'727582')
INSERT [dbo].[HoaDon] ([ID_HoaDon], [ID_Ban], [NGAYHD], [TIENMONAN], [ID_PhuThu], [TIENGIAM], [TONGTIEN], [TRANGTHAI], [MaNV]) VALUES (N'120', N'06', CAST(N'2023-04-10' AS Date), 178000, NULL, 0, 178000, N'Da thanh toan', N'727581')
INSERT [dbo].[HoaDon] ([ID_HoaDon], [ID_Ban], [NGAYHD], [TIENMONAN], [ID_PhuThu], [TIENGIAM], [TONGTIEN], [TRANGTHAI], [MaNV]) VALUES (N'121', N'06', CAST(N'2023-04-12' AS Date), 64000, NULL, 0, 64000, N'Da thanh toan', N'75231')
INSERT [dbo].[HoaDon] ([ID_HoaDon], [ID_Ban], [NGAYHD], [TIENMONAN], [ID_PhuThu], [TIENGIAM], [TONGTIEN], [TRANGTHAI], [MaNV]) VALUES (N'122', N'06', CAST(N'2023-05-12' AS Date), 218000, NULL, 0, 218000, N'Da thanh toan', N'74538')
INSERT [dbo].[HoaDon] ([ID_HoaDon], [ID_Ban], [NGAYHD], [TIENMONAN], [ID_PhuThu], [TIENGIAM], [TONGTIEN], [TRANGTHAI], [MaNV]) VALUES (N'123', N'08', CAST(N'2023-12-05' AS Date), 1207000, NULL, 0, 1207000, N'Chua thanh toan', N'74538')
INSERT [dbo].[HoaDon] ([ID_HoaDon], [ID_Ban], [NGAYHD], [TIENMONAN], [ID_PhuThu], [TIENGIAM], [TONGTIEN], [TRANGTHAI], [MaNV]) VALUES (N'124', N'20', CAST(N'2023-05-26' AS Date), 300000, NULL, 0, 300000, N'Chua thanh toan', N'74538')
INSERT [dbo].[HoaDon] ([ID_HoaDon], [ID_Ban], [NGAYHD], [TIENMONAN], [ID_PhuThu], [TIENGIAM], [TONGTIEN], [TRANGTHAI], [MaNV]) VALUES (N'125', N'17', CAST(N'2024-05-27' AS Date), 100000, NULL, 0, 100000, N'Chua thanh toan', N'727581')
INSERT [dbo].[HoaDon] ([ID_HoaDon], [ID_Ban], [NGAYHD], [TIENMONAN], [ID_PhuThu], [TIENGIAM], [TONGTIEN], [TRANGTHAI], [MaNV]) VALUES (N'126', N'18', CAST(N'2024-05-27' AS Date), 75000, NULL, 0, 75000, N'Da thanh toan', N'727581')
INSERT [dbo].[HoaDon] ([ID_HoaDon], [ID_Ban], [NGAYHD], [TIENMONAN], [ID_PhuThu], [TIENGIAM], [TONGTIEN], [TRANGTHAI], [MaNV]) VALUES (N'130', N'22', CAST(N'2023-10-01' AS Date), 1207000, NULL, 0, 1207000, N'Da thanh toan', N'74538')
INSERT [dbo].[HoaDon] ([ID_HoaDon], [ID_Ban], [NGAYHD], [TIENMONAN], [ID_PhuThu], [TIENGIAM], [TONGTIEN], [TRANGTHAI], [MaNV]) VALUES (N'132', N'13', CAST(N'2023-10-01' AS Date), 1207000, NULL, 0, 1207000, N'Chua thanh toan', N'74538')
INSERT [dbo].[HoaDon] ([ID_HoaDon], [ID_Ban], [NGAYHD], [TIENMONAN], [ID_PhuThu], [TIENGIAM], [TONGTIEN], [TRANGTHAI], [MaNV]) VALUES (N'134', N'33', CAST(N'2024-05-28' AS Date), 44000, NULL, 0, 44000, N'Da thanh toan', N'74538')
INSERT [dbo].[HoaDon] ([ID_HoaDon], [ID_Ban], [NGAYHD], [TIENMONAN], [ID_PhuThu], [TIENGIAM], [TONGTIEN], [TRANGTHAI], [MaNV]) VALUES (N'136', N'16', CAST(N'2024-05-28' AS Date), 0, NULL, 0, NULL, N'Chua thanh toan', N'74538')
INSERT [dbo].[HoaDon] ([ID_HoaDon], [ID_Ban], [NGAYHD], [TIENMONAN], [ID_PhuThu], [TIENGIAM], [TONGTIEN], [TRANGTHAI], [MaNV]) VALUES (N'138', N'30', CAST(N'2024-05-28' AS Date), 1207000, NULL, 0, 1207000, N'Chua thanh toan', N'74538')
INSERT [dbo].[HoaDon] ([ID_HoaDon], [ID_Ban], [NGAYHD], [TIENMONAN], [ID_PhuThu], [TIENGIAM], [TONGTIEN], [TRANGTHAI], [MaNV]) VALUES (N'140', N'26', CAST(N'2024-05-28' AS Date), 1207000, NULL, 0, 1207000, N'Chua thanh toan', N'74538')
INSERT [dbo].[HoaDon] ([ID_HoaDon], [ID_Ban], [NGAYHD], [TIENMONAN], [ID_PhuThu], [TIENGIAM], [TONGTIEN], [TRANGTHAI], [MaNV]) VALUES (N'142', N'33', CAST(N'2024-05-28' AS Date), 1207000, NULL, 0, 1207000, N'Chua thanh toan', N'74538')
INSERT [dbo].[HoaDon] ([ID_HoaDon], [ID_Ban], [NGAYHD], [TIENMONAN], [ID_PhuThu], [TIENGIAM], [TONGTIEN], [TRANGTHAI], [MaNV]) VALUES (N'144', N'24', CAST(N'2024-05-28' AS Date), 50000, NULL, 0, 50000, N'Chua thanh toan', N'74538')
GO
INSERT [dbo].[LoaiSanPham] ([ID_LoaiSanPham], [Ten_LoaiSanPham]) VALUES (N'1', N'Trà')
INSERT [dbo].[LoaiSanPham] ([ID_LoaiSanPham], [Ten_LoaiSanPham]) VALUES (N'10', N'Nước tăng lực')
INSERT [dbo].[LoaiSanPham] ([ID_LoaiSanPham], [Ten_LoaiSanPham]) VALUES (N'2', N'Coffe')
INSERT [dbo].[LoaiSanPham] ([ID_LoaiSanPham], [Ten_LoaiSanPham]) VALUES (N'3', N'Nước Ép Trái Cây')
INSERT [dbo].[LoaiSanPham] ([ID_LoaiSanPham], [Ten_LoaiSanPham]) VALUES (N'4', N'Sinh Tố')
INSERT [dbo].[LoaiSanPham] ([ID_LoaiSanPham], [Ten_LoaiSanPham]) VALUES (N'5', N'Nước ngọt')
INSERT [dbo].[LoaiSanPham] ([ID_LoaiSanPham], [Ten_LoaiSanPham]) VALUES (N'6', N'Nước trái cây')
INSERT [dbo].[LoaiSanPham] ([ID_LoaiSanPham], [Ten_LoaiSanPham]) VALUES (N'7', N'Nước khoáng')
INSERT [dbo].[LoaiSanPham] ([ID_LoaiSanPham], [Ten_LoaiSanPham]) VALUES (N'8', N'Nước lọc')
INSERT [dbo].[LoaiSanPham] ([ID_LoaiSanPham], [Ten_LoaiSanPham]) VALUES (N'9', N'Nước suối')
GO
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [NgaySinh], [cccd], [sdt], [GioiTinh], [ID_ChucVu]) VALUES (N'727581', N'Nguyễn Thị Linh', CAST(N'1999-01-27' AS Date), N'0797556789     ', N'03474329    ', N'Nữ', N'111')
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [NgaySinh], [cccd], [sdt], [GioiTinh], [ID_ChucVu]) VALUES (N'727582', N'Nguyễn Thị B', CAST(N'1999-01-27' AS Date), N'0797556781     ', N'03474321    ', N'Nữ', N'114')
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [NgaySinh], [cccd], [sdt], [GioiTinh], [ID_ChucVu]) VALUES (N'727583', N'Nguyễn Văn E', CAST(N'1999-01-27' AS Date), N'0797556782     ', N'03474322    ', N'Nam', N'117')
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [NgaySinh], [cccd], [sdt], [GioiTinh], [ID_ChucVu]) VALUES (N'74534', N'Trần Viết Bảo', CAST(N'2003-01-16' AS Date), N'0793454289     ', N'09772389    ', N'Nam', N'112')
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [NgaySinh], [cccd], [sdt], [GioiTinh], [ID_ChucVu]) VALUES (N'74535', N'Trần Văn A', CAST(N'1990-01-01' AS Date), N'0793456781     ', N'03472381    ', N'Nam', N'113')
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [NgaySinh], [cccd], [sdt], [GioiTinh], [ID_ChucVu]) VALUES (N'74536', N'Lê Văn C', CAST(N'2003-01-16' AS Date), N'0793454281     ', N'09772381    ', N'Nam', N'115')
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [NgaySinh], [cccd], [sdt], [GioiTinh], [ID_ChucVu]) VALUES (N'74537', N'Phạm Thị D', CAST(N'1990-01-01' AS Date), N'0793456782     ', N'03472382    ', N'Nữ', N'116')
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [NgaySinh], [cccd], [sdt], [GioiTinh], [ID_ChucVu]) VALUES (N'74538', N'Trần Thị F', CAST(N'2003-01-16' AS Date), N'0793454282     ', N'09772382    ', N'Nữ', N'118')
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [NgaySinh], [cccd], [sdt], [GioiTinh], [ID_ChucVu]) VALUES (N'75231', N'Nguyễn Văn Tài', CAST(N'1990-01-01' AS Date), N'0793456789     ', N'03472389    ', N'Nam', N'112')
GO
INSERT [dbo].[PhuThu] ([ID_PhuThu], [Ten_PhuThu], [PhanTram]) VALUES (N'1', N'VAT 10%', CAST(0.10 AS Decimal(5, 2)))
INSERT [dbo].[PhuThu] ([ID_PhuThu], [Ten_PhuThu], [PhanTram]) VALUES (N'2', N'Phụ thu dịch vụ', CAST(0.05 AS Decimal(5, 2)))
INSERT [dbo].[PhuThu] ([ID_PhuThu], [Ten_PhuThu], [PhanTram]) VALUES (N'3', N'Phụ thu VAT', CAST(0.10 AS Decimal(5, 2)))
INSERT [dbo].[PhuThu] ([ID_PhuThu], [Ten_PhuThu], [PhanTram]) VALUES (N'4', N'Phụ thu phí vận chuyển', CAST(0.02 AS Decimal(5, 2)))
INSERT [dbo].[PhuThu] ([ID_PhuThu], [Ten_PhuThu], [PhanTram]) VALUES (N'5', N'Phụ thu phí đóng gói', CAST(0.01 AS Decimal(5, 2)))
INSERT [dbo].[PhuThu] ([ID_PhuThu], [Ten_PhuThu], [PhanTram]) VALUES (N'6', N'Phụ thu phí bảo quản', CAST(0.03 AS Decimal(5, 2)))
INSERT [dbo].[PhuThu] ([ID_PhuThu], [Ten_PhuThu], [PhanTram]) VALUES (N'7', N'Phụ thu phí khác', CAST(0.04 AS Decimal(5, 2)))
GO
INSERT [dbo].[SanPham] ([ID_SanPham], [Ten_SanPham], [Gia], [ID_LoaiSanPham], [MoTa]) VALUES (N'1', N'Hồng Trà', CAST(25000.00 AS Decimal(10, 2)), N'1', N'Ng?t Thanh ')
INSERT [dbo].[SanPham] ([ID_SanPham], [Ten_SanPham], [Gia], [ID_LoaiSanPham], [MoTa]) VALUES (N'10', N'LaVie', CAST(10000.00 AS Decimal(10, 2)), N'9', N'Nu?c su?i LaVie')
INSERT [dbo].[SanPham] ([ID_SanPham], [Ten_SanPham], [Gia], [ID_LoaiSanPham], [MoTa]) VALUES (N'11', N'Trà xanh', CAST(20000.00 AS Decimal(10, 2)), N'1', N'Trà xanh tuoi mát')
INSERT [dbo].[SanPham] ([ID_SanPham], [Ten_SanPham], [Gia], [ID_LoaiSanPham], [MoTa]) VALUES (N'12', N'Trà hoa cúc', CAST(22000.00 AS Decimal(10, 2)), N'1', N'Trà hoa cúc thanh mát')
INSERT [dbo].[SanPham] ([ID_SanPham], [Ten_SanPham], [Gia], [ID_LoaiSanPham], [MoTa]) VALUES (N'13', N'Espresso', CAST(25000.00 AS Decimal(10, 2)), N'2', N'Cà phê Espresso d?m dà')
INSERT [dbo].[SanPham] ([ID_SanPham], [Ten_SanPham], [Gia], [ID_LoaiSanPham], [MoTa]) VALUES (N'14', N'Cappuccino', CAST(28000.00 AS Decimal(10, 2)), N'2', N'Cà phê Cappuccino béo ng?y')
INSERT [dbo].[SanPham] ([ID_SanPham], [Ten_SanPham], [Gia], [ID_LoaiSanPham], [MoTa]) VALUES (N'15', N'Nước ép cam', CAST(18000.00 AS Decimal(10, 2)), N'3', N'Nu?c ép cam tuoi nguyên ch?t')
INSERT [dbo].[SanPham] ([ID_SanPham], [Ten_SanPham], [Gia], [ID_LoaiSanPham], [MoTa]) VALUES (N'16', N'Nước ép táo', CAST(18000.00 AS Decimal(10, 2)), N'3', N'Nu?c ép táo thom ngon')
INSERT [dbo].[SanPham] ([ID_SanPham], [Ten_SanPham], [Gia], [ID_LoaiSanPham], [MoTa]) VALUES (N'17', N'Sinh tố dâu', CAST(20000.00 AS Decimal(10, 2)), N'4', N'Sinh t? dâu thom ng?t')
INSERT [dbo].[SanPham] ([ID_SanPham], [Ten_SanPham], [Gia], [ID_LoaiSanPham], [MoTa]) VALUES (N'18', N'Sinh tố xoài', CAST(20000.00 AS Decimal(10, 2)), N'4', N'Sinh t? xoài béo ng?y')
INSERT [dbo].[SanPham] ([ID_SanPham], [Ten_SanPham], [Gia], [ID_LoaiSanPham], [MoTa]) VALUES (N'19', N'Fanta', CAST(18000.00 AS Decimal(10, 2)), N'5', N'Nu?c ng?t Fanta v? cam')
INSERT [dbo].[SanPham] ([ID_SanPham], [Ten_SanPham], [Gia], [ID_LoaiSanPham], [MoTa]) VALUES (N'2', N'Trà đào', CAST(30000.00 AS Decimal(10, 2)), N'2', N'Trà dào mát l?nh')
INSERT [dbo].[SanPham] ([ID_SanPham], [Ten_SanPham], [Gia], [ID_LoaiSanPham], [MoTa]) VALUES (N'20', N'Sprite', CAST(18000.00 AS Decimal(10, 2)), N'5', N'Nu?c ng?t Sprite v? chanh')
INSERT [dbo].[SanPham] ([ID_SanPham], [Ten_SanPham], [Gia], [ID_LoaiSanPham], [MoTa]) VALUES (N'21', N'Trái cây đóng hộp', CAST(25000.00 AS Decimal(10, 2)), N'6', N'Các lo?i trái cây dóng h?p')
INSERT [dbo].[SanPham] ([ID_SanPham], [Ten_SanPham], [Gia], [ID_LoaiSanPham], [MoTa]) VALUES (N'22', N'Nước suối Aqua', CAST(12000.00 AS Decimal(10, 2)), N'7', N'Nu?c su?i Aqua thiên nhiên')
INSERT [dbo].[SanPham] ([ID_SanPham], [Ten_SanPham], [Gia], [ID_LoaiSanPham], [MoTa]) VALUES (N'23', N'Nước khoáng Vinspire', CAST(15000.00 AS Decimal(10, 2)), N'7', N'Nu?c khoáng Vinspire giàu khoáng ch?t')
INSERT [dbo].[SanPham] ([ID_SanPham], [Ten_SanPham], [Gia], [ID_LoaiSanPham], [MoTa]) VALUES (N'24', N'Nước lọc Dasani', CAST(10000.00 AS Decimal(10, 2)), N'8', N'Nu?c l?c Dasani tinh khi?t')
INSERT [dbo].[SanPham] ([ID_SanPham], [Ten_SanPham], [Gia], [ID_LoaiSanPham], [MoTa]) VALUES (N'25', N'Nước suối Lavie', CAST(12000.00 AS Decimal(10, 2)), N'9', N'Nu?c su?i Lavie t? nhiên')
INSERT [dbo].[SanPham] ([ID_SanPham], [Ten_SanPham], [Gia], [ID_LoaiSanPham], [MoTa]) VALUES (N'26', N'Trà hoa đậu biếc', CAST(22000.00 AS Decimal(10, 2)), N'1', N'Trà hoa d?u bi?c thanh mát và tinh t?')
INSERT [dbo].[SanPham] ([ID_SanPham], [Ten_SanPham], [Gia], [ID_LoaiSanPham], [MoTa]) VALUES (N'27', N'Trà oolong', CAST(25000.00 AS Decimal(10, 2)), N'1', N'Trà oolong có huong thom nh? nhàng')
INSERT [dbo].[SanPham] ([ID_SanPham], [Ten_SanPham], [Gia], [ID_LoaiSanPham], [MoTa]) VALUES (N'28', N'Cà phê phin đen', CAST(18000.00 AS Decimal(10, 2)), N'2', N'Cà phê phin den d?m v? truy?n th?ng')
INSERT [dbo].[SanPham] ([ID_SanPham], [Ten_SanPham], [Gia], [ID_LoaiSanPham], [MoTa]) VALUES (N'29', N'Cà phê sữa đá', CAST(20000.00 AS Decimal(10, 2)), N'2', N'Cà phê s?a dá thom ngon, mát l?nh')
INSERT [dbo].[SanPham] ([ID_SanPham], [Ten_SanPham], [Gia], [ID_LoaiSanPham], [MoTa]) VALUES (N'3', N'Sinh Tố Bơ', CAST(15000.00 AS Decimal(10, 2)), N'4', N'Bo nguyên ch?t')
INSERT [dbo].[SanPham] ([ID_SanPham], [Ten_SanPham], [Gia], [ID_LoaiSanPham], [MoTa]) VALUES (N'30', N'Nước ép cà rốt', CAST(16000.00 AS Decimal(10, 2)), N'3', N'Nu?c ép cà r?t giàu vitamin A')
INSERT [dbo].[SanPham] ([ID_SanPham], [Ten_SanPham], [Gia], [ID_LoaiSanPham], [MoTa]) VALUES (N'31', N'Nước ép cà chua', CAST(16000.00 AS Decimal(10, 2)), N'3', N'Nu?c ép cà chua tuoi mát và giàu vitamin C')
INSERT [dbo].[SanPham] ([ID_SanPham], [Ten_SanPham], [Gia], [ID_LoaiSanPham], [MoTa]) VALUES (N'32', N'Sinh tố dưa lưới', CAST(22000.00 AS Decimal(10, 2)), N'4', N'Sinh t? dua lu?i thom ng?t, b? du?ng')
INSERT [dbo].[SanPham] ([ID_SanPham], [Ten_SanPham], [Gia], [ID_LoaiSanPham], [MoTa]) VALUES (N'33', N'Sinh tố việt quất', CAST(22000.00 AS Decimal(10, 2)), N'4', N'Sinh t? vi?t qu?t t? nhiên, giàu ch?t ch?ng oxy hóa')
INSERT [dbo].[SanPham] ([ID_SanPham], [Ten_SanPham], [Gia], [ID_LoaiSanPham], [MoTa]) VALUES (N'34', N'Pepsi Twist', CAST(18000.00 AS Decimal(10, 2)), N'5', N'Pepsi Twist v?i v? chanh tuoi mát')
INSERT [dbo].[SanPham] ([ID_SanPham], [Ten_SanPham], [Gia], [ID_LoaiSanPham], [MoTa]) VALUES (N'35', N'Fanta Cam', CAST(18000.00 AS Decimal(10, 2)), N'5', N'Fanta Cam v?i v? cam ng?t thanh')
INSERT [dbo].[SanPham] ([ID_SanPham], [Ten_SanPham], [Gia], [ID_LoaiSanPham], [MoTa]) VALUES (N'36', N'Nước cam ép', CAST(20000.00 AS Decimal(10, 2)), N'6', N'Nu?c cam ép tuoi nguyên ch?t')
INSERT [dbo].[SanPham] ([ID_SanPham], [Ten_SanPham], [Gia], [ID_LoaiSanPham], [MoTa]) VALUES (N'37', N'Nước ổi ép', CAST(20000.00 AS Decimal(10, 2)), N'6', N'Nu?c ?i ép thom ngon, giàu vitamin C')
INSERT [dbo].[SanPham] ([ID_SanPham], [Ten_SanPham], [Gia], [ID_LoaiSanPham], [MoTa]) VALUES (N'38', N'Perrier', CAST(18000.00 AS Decimal(10, 2)), N'7', N'Nu?c khoáng Perrier có gas')
INSERT [dbo].[SanPham] ([ID_SanPham], [Ten_SanPham], [Gia], [ID_LoaiSanPham], [MoTa]) VALUES (N'39', N'Voss', CAST(22000.00 AS Decimal(10, 2)), N'7', N'Nu?c khoáng Voss tinh khi?t')
INSERT [dbo].[SanPham] ([ID_SanPham], [Ten_SanPham], [Gia], [ID_LoaiSanPham], [MoTa]) VALUES (N'4', N'Nước Ép Dưa Hấu', CAST(15000.00 AS Decimal(10, 2)), N'3', N'Dua h?u l?nh ng?t ngây')
INSERT [dbo].[SanPham] ([ID_SanPham], [Ten_SanPham], [Gia], [ID_LoaiSanPham], [MoTa]) VALUES (N'40', N'Aquafina', CAST(12000.00 AS Decimal(10, 2)), N'8', N'Nu?c l?c Aquafina tinh khi?t')
INSERT [dbo].[SanPham] ([ID_SanPham], [Ten_SanPham], [Gia], [ID_LoaiSanPham], [MoTa]) VALUES (N'41', N'Lavie', CAST(14000.00 AS Decimal(10, 2)), N'9', N'Nu?c su?i Lavie thiên nhiên')
INSERT [dbo].[SanPham] ([ID_SanPham], [Ten_SanPham], [Gia], [ID_LoaiSanPham], [MoTa]) VALUES (N'42', N'Viai', CAST(18000.00 AS Decimal(10, 2)), N'9', N'Nu?c su?i Viai tinh khi?t')
INSERT [dbo].[SanPham] ([ID_SanPham], [Ten_SanPham], [Gia], [ID_LoaiSanPham], [MoTa]) VALUES (N'43', N'Red Bull', CAST(30000.00 AS Decimal(10, 2)), N'10', N'Nu?c tang l?c Red Bull')
INSERT [dbo].[SanPham] ([ID_SanPham], [Ten_SanPham], [Gia], [ID_LoaiSanPham], [MoTa]) VALUES (N'44', N'Sting', CAST(25000.00 AS Decimal(10, 2)), N'10', N'Nu?c tang l?c Sting')
INSERT [dbo].[SanPham] ([ID_SanPham], [Ten_SanPham], [Gia], [ID_LoaiSanPham], [MoTa]) VALUES (N'45', N'Redbull Sugar Free', CAST(32000.00 AS Decimal(10, 2)), N'10', N'Nu?c tang l?c Red Bull không du?ng')
INSERT [dbo].[SanPham] ([ID_SanPham], [Ten_SanPham], [Gia], [ID_LoaiSanPham], [MoTa]) VALUES (N'46', N'Sting Zero', CAST(27000.00 AS Decimal(10, 2)), N'10', N'Nu?c tang l?c Sting không du?ng')
INSERT [dbo].[SanPham] ([ID_SanPham], [Ten_SanPham], [Gia], [ID_LoaiSanPham], [MoTa]) VALUES (N'47', N'Nước đá', CAST(5000.00 AS Decimal(10, 2)), N'8', N'Nu?c dá l?nh t? nhiên')
INSERT [dbo].[SanPham] ([ID_SanPham], [Ten_SanPham], [Gia], [ID_LoaiSanPham], [MoTa]) VALUES (N'48', N'Nước chanh', CAST(10000.00 AS Decimal(10, 2)), N'6', N'Nu?c chanh tuoi nguyên ch?t')
INSERT [dbo].[SanPham] ([ID_SanPham], [Ten_SanPham], [Gia], [ID_LoaiSanPham], [MoTa]) VALUES (N'49', N'Trà đen', CAST(18000.00 AS Decimal(10, 2)), N'1', N'Trà den thom ngon, giàu ch?t ch?ng oxy hóa')
INSERT [dbo].[SanPham] ([ID_SanPham], [Ten_SanPham], [Gia], [ID_LoaiSanPham], [MoTa]) VALUES (N'5', N'Coca Cola', CAST(20000.00 AS Decimal(10, 2)), N'5', N'Nu?c ng?t Coca Cola')
INSERT [dbo].[SanPham] ([ID_SanPham], [Ten_SanPham], [Gia], [ID_LoaiSanPham], [MoTa]) VALUES (N'50', N'Cà phê rang xay', CAST(22000.00 AS Decimal(10, 2)), N'2', N'Cà phê rang xay tuoi m?i, d?m v?')
INSERT [dbo].[SanPham] ([ID_SanPham], [Ten_SanPham], [Gia], [ID_LoaiSanPham], [MoTa]) VALUES (N'6', N'Pepsi', CAST(20000.00 AS Decimal(10, 2)), N'5', N'Nu?c ng?t Pepsi')
INSERT [dbo].[SanPham] ([ID_SanPham], [Ten_SanPham], [Gia], [ID_LoaiSanPham], [MoTa]) VALUES (N'7', N'7 Up', CAST(20000.00 AS Decimal(10, 2)), N'5', N'Nu?c ng?t 7 Up')
INSERT [dbo].[SanPham] ([ID_SanPham], [Ten_SanPham], [Gia], [ID_LoaiSanPham], [MoTa]) VALUES (N'8', N'Mirinda', CAST(20000.00 AS Decimal(10, 2)), N'5', N'Nu?c ng?t Mirinda')
INSERT [dbo].[SanPham] ([ID_SanPham], [Ten_SanPham], [Gia], [ID_LoaiSanPham], [MoTa]) VALUES (N'9', N'Aquafina', CAST(10000.00 AS Decimal(10, 2)), N'8', N'Nu?c l?c Aquafina')
GO
INSERT [dbo].[TkNhanVien] ([ID_TaiKhoan], [Taikhoan], [MatKhau], [MaNV]) VALUES (N'1', N'111', N'1', N'727581')
INSERT [dbo].[TkNhanVien] ([ID_TaiKhoan], [Taikhoan], [MatKhau], [MaNV]) VALUES (N'2', N'512', N'2', N'75231')
INSERT [dbo].[TkNhanVien] ([ID_TaiKhoan], [Taikhoan], [MatKhau], [MaNV]) VALUES (N'3', N'513', N'2', N'74534')
INSERT [dbo].[TkNhanVien] ([ID_TaiKhoan], [Taikhoan], [MatKhau], [MaNV]) VALUES (N'4', N'514', N'4', N'74535')
INSERT [dbo].[TkNhanVien] ([ID_TaiKhoan], [Taikhoan], [MatKhau], [MaNV]) VALUES (N'5', N'515', N'5', N'727582')
INSERT [dbo].[TkNhanVien] ([ID_TaiKhoan], [Taikhoan], [MatKhau], [MaNV]) VALUES (N'6', N'516', N'6', N'74536')
INSERT [dbo].[TkNhanVien] ([ID_TaiKhoan], [Taikhoan], [MatKhau], [MaNV]) VALUES (N'7', N'517', N'7', N'74537')
INSERT [dbo].[TkNhanVien] ([ID_TaiKhoan], [Taikhoan], [MatKhau], [MaNV]) VALUES (N'8', N'518', N'8', N'727583')
GO
ALTER TABLE [dbo].[HoaDon] ADD  CONSTRAINT [df_TIENMONAN]  DEFAULT ((0)) FOR [TIENMONAN]
GO
ALTER TABLE [dbo].[CTHD]  WITH CHECK ADD  CONSTRAINT [FK_CTHD_HOADON] FOREIGN KEY([ID_HoaDon])
REFERENCES [dbo].[HoaDon] ([ID_HoaDon])
GO
ALTER TABLE [dbo].[CTHD] CHECK CONSTRAINT [FK_CTHD_HOADON]
GO
ALTER TABLE [dbo].[CTHD]  WITH CHECK ADD  CONSTRAINT [FK_CTHD_MONAN] FOREIGN KEY([ID_SanPham])
REFERENCES [dbo].[SanPham] ([ID_SanPham])
GO
ALTER TABLE [dbo].[CTHD] CHECK CONSTRAINT [FK_CTHD_MONAN]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HOADON_BAN] FOREIGN KEY([ID_Ban])
REFERENCES [dbo].[Ban] ([ID_Ban])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HOADON_BAN]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HOADON_NV] FOREIGN KEY([MaNV])
REFERENCES [dbo].[NhanVien] ([MaNV])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HOADON_NV]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HOADON_PhuThu] FOREIGN KEY([ID_PhuThu])
REFERENCES [dbo].[PhuThu] ([ID_PhuThu])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HOADON_PhuThu]
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD FOREIGN KEY([ID_ChucVu])
REFERENCES [dbo].[ChucVuNhanVien] ([ID_ChucVu])
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD FOREIGN KEY([ID_LoaiSanPham])
REFERENCES [dbo].[LoaiSanPham] ([ID_LoaiSanPham])
GO
ALTER TABLE [dbo].[TkNhanVien]  WITH CHECK ADD FOREIGN KEY([MaNV])
REFERENCES [dbo].[NhanVien] ([MaNV])
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [chk_HOADON_TRANGTHAI] CHECK  (([TRANGTHAI]='Da thanh toan' OR [TRANGTHAI]='Chua thanh toan'))
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [chk_HOADON_TRANGTHAI]
GO
/****** Object:  StoredProcedure [dbo].[GetTotalPaidBillAmount]    Script Date: 5/30/2024 8:23:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[GetTotalPaidBillAmount]
AS
BEGIN
    SELECT SUM(TONGTIEN) AS TotalAmount
    FROM HoaDon
    WHERE TRANGTHAI = 'Da thanh toan'
END
GO
/****** Object:  StoredProcedure [dbo].[GetUnpaidOrderDetails]    Script Date: 5/30/2024 8:23:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create PROCEDURE [dbo].[GetUnpaidOrderDetails]
    @ID_Ban VARCHAR(10)
AS
BEGIN
    SELECT 
		hd.ID_HoaDon,
        sp.Ten_SanPham, 
        ct.SOLUONG,sp.gia,ct.thanhtien,
        hd.TONGTIEN
    FROM 
        ban b
        INNER JOIN hoadon hd ON b.ID_Ban = hd.ID_Ban
        INNER JOIN CTHD ct ON hd.ID_HoaDon = ct.ID_HoaDon
        INNER JOIN SanPham sp ON ct.ID_SanPham = sp.ID_SanPham
    WHERE 
        b.ID_Ban = @ID_Ban
        AND b.TinhTrang = 1
        AND hd.TRANGTHAI = 'Chua thanh toan'
END
GO
/****** Object:  StoredProcedure [dbo].[layBill]    Script Date: 5/30/2024 8:23:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[layBill]
AS
BEGIN
    SELECT *
    FROM HoaDon
    WHERE TRANGTHAI = 'Da thanh toan'
END
GO
/****** Object:  StoredProcedure [dbo].[ThemDatMon]    Script Date: 5/30/2024 8:23:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[ThemDatMon]
    @ID_Ban INT,
    @ID_SanPham INT,
    @SoLuong INT
AS
BEGIN
    SET NOCOUNT ON;

    DECLARE @ID_HoaDon INT;

    -- Kiểm tra xem bàn này đã có hóa đơn chưa thanh toán chưa
    IF NOT EXISTS (
        SELECT 1 
        FROM HoaDon 
        WHERE ID_Ban = @ID_Ban 
          AND TRANGTHAI = N'Chưa thanh toán'
    )
    BEGIN
        -- Nếu không có, tạo một hóa đơn mới
        INSERT INTO HoaDon (ID_Ban, NGAYHD, TIENMONAN, TIENGIAM, TONGTIEN, TRANGTHAI)
        VALUES (@ID_Ban, GETDATE(), 0, 0, 0, N'Chưa thanh toán')
        
        SET @ID_HoaDon = SCOPE_IDENTITY();
    END
    ELSE
    BEGIN
        -- Lấy ID hóa đơn chưa thanh toán của bàn này
        SELECT @ID_HoaDon = ID_HoaDon
        FROM HoaDon
        WHERE ID_Ban = @ID_Ban
          AND TRANGTHAI = N'Chưa thanh toán'
    END

    -- Thêm món vào chi tiết hóa đơn
    INSERT INTO CTHD (ID_HoaDon, ID_SanPham, SOLUONG, THANHTIEN)
    VALUES (@ID_HoaDon, @ID_SanPham, @SoLuong, (SELECT GIA FROM SanPham WHERE ID_SanPham = @ID_SanPham) * @SoLuong)

    -- Cập nhật tổng tiền hóa đơn
    UPDATE HoaDon
    SET TIENMONAN = TIENMONAN + (SELECT GIA FROM SanPham WHERE ID_SanPham = @ID_SanPham) * @SoLuong,
        TONGTIEN = TONGTIEN + (SELECT GIA FROM SanPham WHERE ID_SanPham = @ID_SanPham) * @SoLuong
    WHERE ID_HoaDon = @ID_HoaDon
END
GO
/****** Object:  StoredProcedure [dbo].[usp_CreateHoaDon]    Script Date: 5/30/2024 8:23:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create PROCEDURE [dbo].[usp_CreateHoaDon]
    @ID_Ban VARCHAR(10),
    @NGAYHD DATE,
    @TIENMONAN float,
    @TIENGIAM float,
    @TRANGTHAI NVARCHAR(50),
    @MaNV VARCHAR(10)
AS
BEGIN
    SET NOCOUNT ON;

    DECLARE @LastID VARCHAR(10)
	SELECT @LastID = MAX(ID_HoaDon) FROM HoaDon
	DECLARE @NewID VARCHAR(10)
	SET @NewID =  RIGHT('000' + CAST((CAST(@LastID AS INT) + 1) AS VARCHAR(10)), 3)
    INSERT INTO HoaDon (ID_HoaDon, ID_Ban, NGAYHD, TIENMONAN, TIENGIAM, TRANGTHAI, MaNV)
    VALUES (@NewID, @ID_Ban, @NGAYHD, @TIENMONAN, @TIENGIAM, @TRANGTHAI, @MaNV)
END
GO
USE [master]
GO
ALTER DATABASE [QLCaPhe] SET  READ_WRITE 
GO
