-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 22, 2025 at 04:08 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `travel_booking1`
--
CREATE DATABASE IF NOT EXISTS `travel_booking1` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `travel_booking1`;

-- --------------------------------------------------------

--
-- Table structure for table `chuyentien`
--

CREATE TABLE `chuyentien` (
  `id` bigint(20) NOT NULL,
  `noidungchuyenkhoan` varchar(255) DEFAULT NULL,
  `sotienchuyenkhoan` varchar(255) DEFAULT NULL,
  `thoigian` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `chuyentien`
--

INSERT INTO `chuyentien` (`id`, `noidungchuyenkhoan`, `sotienchuyenkhoan`, `thoigian`) VALUES
(31, 'MB_DaoHongBon_0325088705', '18,000,000', NULL),
(32, 'ZaloPay_DaoHongBon_0325088705', '18,000,000', NULL),
(33, 'VietelMoney_DaoHongBon_0325088705', '18,000,000', NULL),
(34, 'MB_DaoHongBon_0325088705', '9,000,000', '2025-03-20 00:01:49'),
(35, 'MB_DaoHongBon_0325088705', '9,000,000', '2025-03-20 00:03:48'),
(36, 'MB_DaoHongBon_0325088705', '9,000,000', '2025-03-20 00:05:42'),
(37, 'MB_DaoHongBon_0325088705', '9,000,000', '2025-03-20 00:05:51');

-- --------------------------------------------------------

--
-- Table structure for table `datlich`
--

CREATE TABLE `datlich` (
  `id` bigint(20) NOT NULL,
  `hoten` varchar(50) DEFAULT NULL,
  `gmail` varchar(50) DEFAULT NULL,
  `sodienthoai` varchar(50) DEFAULT NULL,
  `soluong` int(11) DEFAULT NULL,
  `tentour` varchar(200) DEFAULT NULL,
  `sotien` varchar(50) NOT NULL DEFAULT '0',
  `ngaythanhtoan` varchar(50) DEFAULT NULL,
  `trangthai` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `datlich`
--

INSERT INTO `datlich` (`id`, `hoten`, `gmail`, `sodienthoai`, `soluong`, `tentour`, `sotien`, `ngaythanhtoan`, `trangthai`) VALUES
(169, 'DaoHongBon', 'bonkoisd123@gmail.com', '0325088705', 2, 'Tết 2024: Đà Nẵng - Hội An - Bà Nà - Huế - Động Thiên Đường 4N3Đ', '4,200,000', '2025-03-18 03:46:51', 'Hoan Thanh'),
(191, 'DaoHongBon', 'daohongbon2k2@gmail.com', '0325088705', 6, 'Tour núi Fansipan', '18,000,000', '2025-03-18 23:49:02', 'Hoan Thanh'),
(192, 'DaoHongBon', 'daohongbon2k2@gmail.com', '0325088705', 6, 'Tour núi Fansipan', '18,000,000', '2025-03-19 00:44:49', 'Cho Xu Ly'),
(193, 'DaoHongBon', 'daohongbon2k2@gmail.com', '0325088705', 6, 'Tour đồng bằng sông Cửu Long', '9,000,000', '2025-03-20 00:00:52', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `lichtrinh`
--

CREATE TABLE `lichtrinh` (
  `id` bigint(20) NOT NULL,
  `tourid` bigint(20) DEFAULT NULL,
  `noidung` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `lichtrinh`
--

INSERT INTO `lichtrinh` (`id`, `tourid`, `noidung`) VALUES
(1, 1, 'Khởi hành từ Hà Nội.'),
(2, 2, 'Tham quan đỉnh Fansipan.');

-- --------------------------------------------------------

--
-- Table structure for table `loaiphuongtien`
--

CREATE TABLE `loaiphuongtien` (
  `id` bigint(20) NOT NULL,
  `tenphuongtien` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `loaiphuongtien`
--

INSERT INTO `loaiphuongtien` (`id`, `tenphuongtien`) VALUES
(1, 'Máy bay'),
(2, 'Tàu hỏa');

-- --------------------------------------------------------

--
-- Table structure for table `loaitour`
--

CREATE TABLE `loaitour` (
  `id` bigint(20) NOT NULL,
  `tentheloai` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `loaitour`
--

INSERT INTO `loaitour` (`id`, `tentheloai`) VALUES
(8, 'Du lịch Biển Đảo'),
(5, 'Tour du lịch biển'),
(3, 'Tour lịch tâm linh'),
(1, 'Tour mạo hiểm'),
(7, 'Tour nước ngoài'),
(2, 'Tour sinh thái'),
(6, 'Tour Tây Bắc'),
(4, 'Tour Trải Nghiệm');

-- --------------------------------------------------------

--
-- Table structure for table `review`
--

CREATE TABLE `review` (
  `id` bigint(20) NOT NULL,
  `userid` bigint(20) DEFAULT NULL,
  `tourid` bigint(20) DEFAULT NULL,
  `reviewdate` varchar(50) DEFAULT NULL,
  `rating` int(11) DEFAULT NULL CHECK (`rating` between 1 and 5),
  `binhluan` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `review`
--

INSERT INTO `review` (`id`, `userid`, `tourid`, `reviewdate`, `rating`, `binhluan`) VALUES
(29, 11, 1, '2025-02-25', 3, '123456'),
(30, 13, 1, '2025-02-25', 5, 'đẹp'),
(32, 13, 1, '2025-02-25', 5, 'asdfghjkl;'),
(33, 13, 1, '2025-02-25', 4, NULL),
(34, 13, 1, '2025-02-25', 4, NULL),
(35, 13, 1, '2025-02-25', 5, 'ádfghjkl'),
(36, 11, 22, '2025-03-02', 5, 'Siêu đẹp.'),
(37, 4, 25, '2025-03-04', 5, '123456'),
(38, 4, 2, '2025-03-04', 5, 'gfgsgsh'),
(39, 11, 1, '2025-03-18', 3, 'qưertrytyu');

-- --------------------------------------------------------

--
-- Table structure for table `tintuc`
--

CREATE TABLE `tintuc` (
  `id` bigint(20) NOT NULL,
  `tieude` varchar(200) NOT NULL,
  `noidung` text NOT NULL,
  `ngaydang` datetime DEFAULT current_timestamp(),
  `author` varchar(50) DEFAULT NULL,
  `image` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tintuc`
--

INSERT INTO `tintuc` (`id`, `tieude`, `noidung`, `ngaydang`, `author`, `image`) VALUES
(1, 'Tin tức 1', '<p><strong>M&ugrave;a hoa</strong> mận ở Mộc Ch&acirc;u thường diễn ra từ giữa th&aacute;ng 1 đến đầu th&aacute;ng 2, mang đến vẻ đẹp tuyệt sắc cho v&ugrave;ng đất n&agrave;y. Những c&aacute;nh hoa mận trắng muốt, tinh kh&ocirc;i nở rộ tr&ecirc;n c&aacute;c sườn đồi, tạo n&ecirc;n một bức tranh thi&ecirc;n nhi&ecirc;n đầy thơ mộng.</p>\r\n', '2025-01-27 23:02:53', 'admin', 'hagiang.jpg'),
(2, 'Tin tức 2', '<p><strong>M&ugrave;a hoa</strong> mận ở Mộc Ch&acirc;u thường diễn ra từ giữa th&aacute;ng 1 đến đầu th&aacute;ng 2, mang đến vẻ đẹp tuyệt sắc cho v&ugrave;ng đất n&agrave;y. Những c&aacute;nh hoa mận trắng muốt, tinh kh&ocirc;i nở rộ tr&ecirc;n c&aacute;c sườn đồi, tạo n&ecirc;n một bức tranh thi&ecirc;n nhi&ecirc;n đầy thơ mộng.</p>\r\n', '2025-01-27 23:02:53', 'admin', 'caobang.jpg'),
(3, 'Tết 2025', '<p><strong>M&ugrave;a hoa</strong> mận ở Mộc Ch&acirc;u thường diễn ra từ giữa th&aacute;ng 1 đến đầu th&aacute;ng 2, mang đến vẻ đẹp tuyệt sắc cho v&ugrave;ng đất n&agrave;y. Những c&aacute;nh hoa mận trắng muốt, tinh kh&ocirc;i nở rộ tr&ecirc;n c&aacute;c sườn đồi, tạo n&ecirc;n một bức tranh thi&ecirc;n nhi&ecirc;n đầy thơ mộng.</p>\r\n', '2025-02-27 21:33:00', 'bon', 'hagiang.jpg'),
(8, 'Tết 2025, Tết đong đầy', '<p><strong>M&ugrave;a hoa</strong> mận ở Mộc Ch&acirc;u thường diễn ra từ giữa th&aacute;ng 1 đến đầu th&aacute;ng 2, mang đến vẻ đẹp tuyệt sắc cho v&ugrave;ng đất n&agrave;y. Những c&aacute;nh hoa mận trắng muốt, tinh kh&ocirc;i nở rộ tr&ecirc;n c&aacute;c sườn đồi, tạo n&ecirc;n một bức tranh thi&ecirc;n nhi&ecirc;n đầy thơ mộng.</p>\r\n', '2025-02-27 21:33:00', 'bon', 'chua-huong.jpg'),
(9, 'Du lịch Sapa', '<p><strong>Sapa</strong> l&agrave;&nbsp;</p>\r\n', '2025-03-22 23:35:00', 'Tác giả ', 'sapa.jpg'),
(10, 'Tết 202, Tết đong đầy', '<p><strong>M&ugrave;a hoa</strong>&nbsp;mận ở Mộc Ch&acirc;u thường diễn ra từ giữa th&aacute;ng 1 đến đầu th&aacute;ng 2, mang đến vẻ đẹp tuyệt sắc cho v&ugrave;ng đất n&agrave;y. Những c&aacute;nh hoa mận trắng muốt, tinh kh&ocirc;i nở rộ tr&ecirc;n c&aacute;c sườn đồi, tạo n&ecirc;n một bức tranh thi&ecirc;n nhi&ecirc;n đầy thơ mộng.<strong>M&ugrave;a hoa</strong>&nbsp;mận ở Mộc Ch&acirc;u thường diễn ra từ giữa th&aacute;ng 1 đến đầu th&aacute;ng 2, mang đến vẻ đẹp tuyệt sắc cho v&ugrave;ng đất n&agrave;y. Những c&aacute;nh hoa mận trắng muốt, tinh kh&ocirc;i nở rộ tr&ecirc;n c&aacute;c sườn đồi, tạo n&ecirc;n một bức tranh thi&ecirc;n nhi&ecirc;n đầy thơ mộng.</p>\r\n', '2025-03-17 22:50:00', 'boôn', 'sapa.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `tour`
--

CREATE TABLE `tour` (
  `id` bigint(20) NOT NULL,
  `tentour` varchar(100) NOT NULL,
  `image` varchar(100) NOT NULL,
  `mota` text DEFAULT NULL,
  `gia` varchar(50) NOT NULL DEFAULT '0',
  `loaitour_id` bigint(20) DEFAULT NULL,
  `lichtrinh` varchar(3000) DEFAULT NULL,
  `phuongtien` varchar(100) DEFAULT NULL,
  `soday` int(11) DEFAULT NULL,
  `diadiem` varchar(100) DEFAULT NULL,
  `soluongghe` int(11) DEFAULT NULL,
  `ngaykhoihanh` date DEFAULT NULL,
  `uudai` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tour`
--

INSERT INTO `tour` (`id`, `tentour`, `image`, `mota`, `gia`, `loaitour_id`, `lichtrinh`, `phuongtien`, `soday`, `diadiem`, `soluongghe`, `ngaykhoihanh`, `uudai`) VALUES
(1, 'Tour núi Fansipan', 'caobang.jpg', 'Chinh phục đỉnh Fansipan.', '3000000', 6, '<p><strong>Ng&agrave;y 1: H&agrave; Nội &ndash; Cao Bằng &ndash; P&aacute;c B&oacute;</strong></p>\r\n\r\n<ul>\r\n	<li><strong>S&aacute;ng:</strong> Khởi h&agrave;nh từ H&agrave; Nội đi Cao Bằng (6-8 tiếng).</li>\r\n	<li><strong>Trưa:</strong> Đến Cao Bằng, ăn trưa v&agrave; nhận ph&ograve;ng kh&aacute;ch sạn.</li>\r\n	<li><strong>Chiều:</strong> Tham quan Khu di t&iacute;ch P&aacute;c B&oacute; (Hang Cốc B&oacute;, suối L&ecirc; Nin).</li>\r\n	<li><strong>Tối:</strong> Ăn tối v&agrave; nghỉ ngơi tại kh&aacute;ch sạn.</li>\r\n</ul>\r\n\r\n<p><strong>Ng&agrave;y 2: Th&aacute;c Bản Giốc &ndash; Động Ngườm Ngao &ndash; H&agrave; Nội</strong></p>\r\n\r\n<ul>\r\n	<li><strong>S&aacute;ng:</strong> Ăn s&aacute;ng, khởi h&agrave;nh đi <strong>Th&aacute;c Bản Giốc</strong> (tham quan v&agrave; chụp ảnh).</li>\r\n	<li><strong>Trưa:</strong> Đến <strong>Động Ngườm Ngao</strong>, kh&aacute;m ph&aacute; động.</li>\r\n	<li><strong>Chiều:</strong> Khởi h&agrave;nh về H&agrave; Nội, dừng ch&acirc;n ăn uống tr&ecirc;n đường.</li>\r\n	<li><strong>Tối:</strong> Về đến H&agrave; Nội, kết th&uacute;c tour.</li>\r\n</ul>\r\n', 'Ô tô', 3, 'Hà Nội', 50, '2025-02-20', 15),
(2, 'hòa binh', 'sapa.jpg', 'ádfg', '1200000', 5, '<p><strong>Ng&agrave;y 1: H&agrave; Nội &ndash; Cao Bằng &ndash; P&aacute;c B&oacute;</strong></p>', 'Máy bay', 2, 'Hà Nội', 40, '2025-01-29', 18),
(3, 'cc', 'hagiang.jpg', 'ccc', '12413523', 4, NULL, 'Ô tô', 3, 'Hà Nội', 40, '2025-01-23', 20),
(4, 'Đà Nẵng - Hà Nội - Ninh Bình - Du thuyền Hạ Long cao cấp', 'hagiang.jpg', 'Khám phá vịnh Hạ Long.', '2500000', 6, '', 'Tàu thủy', 3, 'Hải Phòng', 40, '2023-06-03', 14),
(5, 'Tour đồng bằng sông Cửu Long', 'hagiang.jpg', 'Thăm quan đồng bằng sông Cửu Long.', '1500000', 5, NULL, 'Ô tô', 2, 'Cần Thơ', 60, '2023-06-04', 16),
(6, 'Tour biển Đà Nẵng', 'hagiang.jpg', 'Tham gia các hoạt động giải trí tại biển Đà Nẵng.', '2200000', 1, NULL, 'Máy bay', 3, 'Đà Nẵng', 50, '2023-06-05', 15),
(7, 'Tour núi Fansipan1', 'hagiang.jpg', 'Chinh phục đỉnh Fansipan.', '1680000', 6, NULL, 'Ô tô', 4, 'Hồ Chí Minh', 45, '2025-02-05', 13),
(20, 'Tour cao nguyên Mộc Châu', 'hagiang.jpg', 'Thăm quan cao nguyên Mộc Châu.', '1800000', 3, NULL, 'Ô tô', 2, 'Sơn La', 55, '2023-06-06', 6),
(21, 'Tour biển Phú Quốc', 'hagiang.jpg', 'Khám phá đảo ngọc Phú Quốc.', '3500000', 6, NULL, 'Máy bay', 4, 'Kiên Giang', 50, '2023-06-07', 24),
(22, 'Tour 9', 'hagiang.jpg', 'Mô tả tour 9', '1600000', 6, 'Lịch trình tour 9', 'Tàu', 1, 'Địa điểm 9', 50, '2025-02-19', 8),
(23, 'Tour thành phố Hồ Chí Minh', 'hagiang.jpg', 'Khám phá Sài Gòn hoa lệ.', '6,900,000', 5, NULL, 'Máy bay', 2, 'TP Hồ Chí Minh', 70, '2023-06-09', 30),
(24, 'Tour núi Bà Nà', 'hagiang.jpg', 'Thăm quan đỉnh Bà Nà.', '2600000', 1, NULL, 'Máy bay', 7, 'Đà Nẵng', 35, '2023-06-10', 10),
(25, 'Tết 2024: Đà Nẵng - Hội An - Bà Nà - Huế - Động Thiên Đường 4N3Đ', 'hagiang.jpg', 'Thăm quan cố đô Huế.', '2,100,000', 4, NULL, 'Ô tô', 2, 'Thừa Thiên Huế', 40, '2023-06-11', 21),
(26, 'Tour đảo Cát Bà', 'hagiang.jpg', 'Khám phá đảo Cát Bà.', '2300000', 5, '', 'Tàu thủy', 3, 'Hải Phòng', 50, '2023-06-12', 13),
(27, 'Tour Hà Giang', 'hagiang.jpg', 'Tour du lịch Hà Giang, một điểm đến nổi tiếng với cảnh sắc thiên nhiên hùng vĩ và văn hóa phong phú:', '2500000', 6, NULL, 'Ô tô', 3, 'Hà Nội', 50, '2025-02-05', 22),
(28, 'Tour Hà Giang', 'hagiang.jpg', 'qưaf', '1320000', 3, '', 'Ô tô', 2, 'Hà Nội', 45, '2025-02-06', 15),
(29, 'Tour Hà Giang', 'hagiang.jpg', 'jfykjfjfg', '1320000', 1, '<h3>Tour Du Lịch H&agrave; Giang</h3>\r\n\r\n<p>1. <strong>Ng&agrave;y 1: H&agrave; Nội - H&agrave; Giang</strong></p>\r\n\r\n<ul>\r\n	<li><strong>S&aacute;ng</strong>: Khởi h&agrave;nh từ H&agrave; Nội, di chuyển đến H&agrave; Giang. Tr&ecirc;n đường đi, bạn c&oacute; thể dừng ch&acirc;n tại một số điểm để chụp ảnh v&agrave; thưởng thức đặc sản địa phương.</li>\r\n	<li><strong>Chiều</strong>: Đến H&agrave; Giang, check-in kh&aacute;ch sạn. Kh&aacute;m ph&aacute; khu vực xung quanh, thưởng thức bữa tối với c&aacute;c m&oacute;n ăn đặc sản như thắng cố, x&ocirc;i ngũ sắc.</li>\r\n</ul>\r\n\r\n<p>2. <strong>Ng&agrave;y 2: H&agrave; Giang - Đồng Văn</strong></p>\r\n\r\n<ul>\r\n	<li><strong>S&aacute;ng</strong>: Khởi h&agrave;nh đi Đồng Văn, dừng lại tại đ&egrave;o M&atilde; P&igrave; L&egrave;ng &ndash; một trong những con đ&egrave;o đẹp nhất Việt Nam. Từ đ&acirc;y, bạn c&oacute; thể ngắm nh&igrave;n d&ograve;ng s&ocirc;ng Nho Quế thơ mộng.</li>\r\n	<li><strong>Chiều</strong>: Tham quan phố cổ Đồng Văn, t&igrave;m hiểu văn h&oacute;a d&acirc;n tộc thiểu số. Gh&eacute; thăm chợ phi&ecirc;n Đồng Văn, nơi bạn c&oacute; thể mua sắm c&aacute;c sản phẩm thủ c&ocirc;ng mỹ nghệ v&agrave; thưởng thức c&aacute;c m&oacute;n ăn truyền thống.</li>\r\n</ul>\r\n\r\n<p>3. <strong>Ng&agrave;y 3: Đồng Văn - Lũng C&uacute; - M&egrave;o Vạc</strong></p>\r\n\r\n<ul>\r\n	<li><strong>S&aacute;ng</strong>: Điểm dừng ch&acirc;n đầu ti&ecirc;n l&agrave; cột cờ Lũng C&uacute;, nơi được coi l&agrave; điểm cực Bắc của Tổ quốc. Từ đ&acirc;y, bạn c&oacute; thể nh&igrave;n ra cảnh quan h&ugrave;ng vĩ của n&uacute;i rừng.</li>\r\n	<li><strong>Chiều</strong>: Di chuyển về M&egrave;o Vạc, tham quan c&aacute;c thung lũng hoa tam gi&aacute;c mạch v&agrave; chụp h&igrave;nh với những c&aacute;nh đồng xanh mướt. Thưởng thức bữa tối tại M&egrave;o Vạc v&agrave; nghỉ đ&ecirc;m tại đ&acirc;y.</li>\r\n</ul>\r\n\r\n<p>4. <strong>Ng&agrave;y 4: M&egrave;o Vạc - H&agrave; Giang - H&agrave; Nội</strong></p>\r\n\r\n<ul>\r\n	<li><strong>S&aacute;ng</strong>: Khởi h&agrave;nh về lại H&agrave; Giang, tr&ecirc;n đường c&oacute; thể gh&eacute; thăm c&aacute;c bản l&agrave;ng của người d&acirc;n tộc H&#39;M&ocirc;ng, T&agrave;y để cảm nhận cuộc sống đời thường của họ.</li>\r\n	<li><strong>Chiều</strong>: Về đến H&agrave; Giang, ăn trưa v&agrave; mua sắm qu&agrave; lưu niệm. Sau đ&oacute;, khởi h&agrave;nh quay trở về H&agrave; Nội, kết th&uacute;c chuyến đi.</li>\r\n</ul>\r\n', 'Máy bay', 4, 'Hồ Chí Minh', 45, '2025-02-15', 5),
(30, 'Thái Bình', 'hagiang.jpg', 'dhd', '2,490,000', 6, '<p>Ng&agrave;y 1:&agrave;g</p>\r\n\r\n<p>Ng&agrave;y 2:gsr</p>\r\n\r\n<p>Ng&agrave;y 3:hrhdr</p>\r\n\r\n<p>Ng&agrave;y 4:hjtj</p>\r\n\r\n<p>&nbsp;</p>\r\n', 'Ô tô', 4, 'Hồ Chí Minh', 45, '2025-02-05', NULL),
(31, 'Tour 1', 'hagiang.jpg', 'Mô tả tour 1', '1000000', 6, 'Lịch trình tour 1', 'Máy bay', 2, 'Địa điểm 1', 50, '2025-02-11', 10),
(32, 'Tour 2', 'hagiang.jpg', 'Mô tả tour 2', '1000000', 2, 'Lịch trình tour 2', 'Ô tô', 3, 'Địa điểm 2', 50, '2025-02-12', 15),
(33, 'Tour 3', 'hagiang.jpg', 'Mô tả tour 3', '1500000', 7, 'Lịch trình tour 3', 'Tàu', 1, 'Địa điểm 3', 50, '2025-02-13', 5),
(34, 'Tour 4', 'hagiang.jpg', 'Mô tả tour 4', '2500000', 5, 'Lịch trình tour 4', 'Máy bay', 4, 'Địa điểm 4', 50, '2025-02-14', 20),
(35, 'Tour 5', 'hagiang.jpg', 'Mô tả tour 5', '3000000', 1, 'Lịch trình tour 5', 'Ô tô', 5, 'Địa điểm 5', 50, '2025-02-15', 10),
(36, 'Tour 6', 'hagiang.jpg', 'Mô tả tour 6', '1200000', 2, 'Lịch trình tour 6', 'Tàu', 3, 'Địa điểm 6', 50, '2025-02-16', 12),
(37, 'Tour 7', 'hagiang.jpg', 'Mô tả tour 7', '1800000', 5, 'Lịch trình tour 7', 'Máy bay', 2, 'Địa điểm 7', 50, '2025-02-17', 18),
(38, 'Tour 8', 'hagiang.jpg', 'Mô tả tour 8', '2200000', 6, 'Lịch trình tour 8', 'Ô tô', 4, 'Địa điểm 8', 50, '2025-02-18', 25),
(40, 'Tour 10', 'hagiang.jpg', 'Mô tả tour 10', '2900000', 6, 'Lịch trình tour 10', 'Máy bay', 3, 'Địa điểm 10', 50, '2025-02-20', 15),
(41, 'Tour 11', 'hagiang.jpg', 'Mô tả tour 11', '1100000', 6, 'Lịch trình tour 11', 'Ô tô', 2, 'Địa điểm 11', 50, '2025-02-21', 11),
(42, 'Tour Sapa 3 ngày 2 đêm: Hành trình khám phá Đỉnh Fansipan và thăm Bản Cát Cát', 'hagiang.jpg', 'Mô tả tour 12', '2100000', 6, 'Lịch trình tour 12', 'Tàu', 4, 'Địa điểm 12', 50, '2025-02-22', 20),
(43, 'Tour 13', 'hagiang.jpg', 'Mô tả tour 13', '1300000', 6, 'Lịch trình tour 13', 'Máy bay', 3, 'Địa điểm 13', 50, '2025-02-23', 5),
(44, 'Tour 14', 'hagiang.jpg', 'Mô tả tour 14', '2400000', 6, 'Lịch trình tour 14', 'Ô tô', 1, 'Địa điểm 14', 50, '2025-02-24', 10),
(91, 'Tour Cao Bằng 2 Ngày 1 Đêm : Pác Bó – Thác Bản Giốc – Động Ngườm Ngao', 'caobang.jpg', 'Tour Cao Bằng 2 ngày 1 đêm mang đến cho du khách trải nghiệm tuyệt vời với cảnh đẹp thiên nhiên hùng vĩ và những di tích lịch sử ý nghĩa. Ngày đầu tiên, bạn sẽ khởi hành từ Hà Nội, vượt qua những cung đường đèo núi để đến với tỉnh Cao Bằng. Sau khi ăn trưa và nhận phòng khách sạn, bạn sẽ ghé thăm Khu di tích Pác Bó, nơi Bác Hồ đã sống và làm việc trong những năm đầu cách mạng. Tại đây, bạn sẽ được khám phá Hang Cốc Bó, suối Lê Nin và tận hưởng không khí trong lành giữa núi rừng.\r\n\r\nNgày thứ hai, sau bữa sáng, bạn sẽ tham quan Thác Bản Giốc, một trong những thác nước đẹp nhất Việt Nam và là biên giới tự nhiên giữa Việt Nam và Trung Quốc. Thác nước hùng vĩ, quanh năm tung bọt trắng xóa, tạo nên khung cảnh thơ mộng. Tiếp theo, bạn sẽ khám phá Động Ngườm Ngao với những nhũ đá kỳ thú và không gian huyền bí. Sau khi tham quan, bạn sẽ khởi hành trở về Hà Nội, mang theo những kỷ niệm đẹp và những trải nghiệm đáng nhớ từ chuyến đi.\r\n\r\nTour Cao Bằng không chỉ là hành trình khám phá thiên nhiên mà còn là dịp để tìm hiểu về lịch sử và văn hóa của vùng đất này. Hãy cùng tham gia để cảm nhận vẻ đẹp của Cao Bằng!', '2,100,000', 6, '<p><strong>Ng&agrave;y 1: H&agrave; Nội &ndash; Cao Bằng &ndash; P&aacute;c B&oacute;</strong></p>\r\n\r\n<ul>\r\n	<li><strong>S&aacute;ng:</strong> Khởi h&agrave;nh từ H&agrave; Nội đi Cao Bằng (6-8 tiếng).</li>\r\n	<li><strong>Trưa:</strong> Đến Cao Bằng, ăn trưa v&agrave; nhận ph&ograve;ng kh&aacute;ch sạn.</li>\r\n	<li><strong>Chiều:</strong> Tham quan Khu di t&iacute;ch P&aacute;c B&oacute; (Hang Cốc B&oacute;, suối L&ecirc; Nin).</li>\r\n	<li><strong>Tối:</strong> Ăn tối v&agrave; nghỉ ngơi tại kh&aacute;ch sạn.</li>\r\n</ul>\r\n\r\n<p><strong>Ng&agrave;y 2: Th&aacute;c Bản Giốc &ndash; Động Ngườm Ngao &ndash; H&agrave; Nội</strong></p>\r\n\r\n<ul>\r\n	<li><strong>S&aacute;ng:</strong> Ăn s&aacute;ng, khởi h&agrave;nh đi <strong>Th&aacute;c Bản Giốc</strong> (tham quan v&agrave; chụp ảnh).</li>\r\n	<li><strong>Trưa:</strong> Đến <strong>Động Ngườm Ngao</strong>, kh&aacute;m ph&aacute; động.</li>\r\n	<li><strong>Chiều:</strong> Khởi h&agrave;nh về H&agrave; Nội, dừng ch&acirc;n ăn uống tr&ecirc;n đường.</li>\r\n	<li><strong>Tối:</strong> Về đến H&agrave; Nội, kết th&uacute;c tour.</li>\r\n</ul>\r\n', 'Ô tô', 2, 'Hà Nội', 50, '2025-02-20', 15);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `username` varchar(50) NOT NULL DEFAULT '0',
  `password` varchar(255) NOT NULL,
  `fullname` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `gender` tinyint(4) DEFAULT NULL,
  `phonenumber` varchar(15) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `role` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `username`, `password`, `fullname`, `email`, `gender`, `phonenumber`, `address`, `role`) VALUES
(1, 'user12', '$2a$10$VMLR4nWjBw866XsLmBR/weDrqrADipfrcT2HytPinssjYmrXLrMsW', 'Nguyen Van A', 'nguyenvana@example.com', 1, '0123456789', 'Hanoi', 'Admin'),
(2, 'user2', 'password2', 'Nguyen Van B', 'nguyenvanb@example.com', 1, '0123456790', 'Hanoi', 'member'),
(3, 'user3', '$2a$10$5ox0gfYZLzQxA86uTwQm8ON4zdmeuI./Y0wGRQ9DivpIqAbLkCuC.', 'Nguyen Van C', 'nguyenvanc@example.com', 0, '0123456791', 'Hanoi', 'member'),
(4, '1', '$2a$10$5ox0gfYZLzQxA86uTwQm8ON4zdmeuI./Y0wGRQ9DivpIqAbLkCuC.', 'daobon111', 'daohonon2k3@gmail.com', 1, '0912523364', 'Phu xuyen', 'Admin'),
(10, 'Daobon', '$2a$10$CbtcN2RjwQ.7czogWxRcBOHrPNx3IJJi0HIZLPeJxOjYdbZu0sDLq', 'khanhvu1924', 'khanhvu19243t4@gmail.com', 0, '0923725636', 'Hồ Chí minh', NULL),
(11, 'lanhuong', '$2a$10$XMuigInmmrrtomRi..vT6O59jKGU2JukBCmIci3.jj1w0nqGNOHcC', 'Vũ thiên lan hương', 'lanhuong12345@gmail.com', 0, '0951423674', 'Hồ Chí minh', NULL),
(13, 'tranhuy', '$2a$10$kRG81rkFOMF6PgHymMOyZeOqwQxcgLooLekbowhHp9z4Y88CqkCvi', 'Trần Thế Huy', 'tranthehuy@Gmail.com', 1, '0213654789', 'Hà Nội', NULL),
(14, 'VuDinh', '$2a$10$udnGnKtUn6zqnz5JbjTBP.lGgbfInHpl6u8aS7P6.SOlHpHflxahS', 'VuTienDinh', 'daohonon2k2@gmail.com', 1, '0325088705', 'Phu xuyen', NULL),
(16, 'DangHuy1', '$2a$10$q9FzOb53.w/Il4g8dbuuhe3sREhg6s.HO15gZo.1iprffVIRzYeXa', 'DangTheHuy', 'dangthhuy@gmail.com', 0, '0852136479', 'Hồ Chí minh', NULL),
(17, 'DangHuy2', '$2a$10$xJcSODsxi.Bd2DJwrnDR4OOXxxAEei41C0e1l7zM6mF8uezLdT9Pq', 'DangTheHuy', 'dangthhuy@gmail.com', 1, '0852136479', 'Hồ Chí minh', NULL),
(18, 'DangHuy3', '$2a$10$yx/e/133ayLy7iHC1usnKO17FcF8TyUbOtbdX1x/q5ync4Xd3O4T.', 'DangTheHuy', 'dangthhuy@gmail.com', 0, '0852136479', 'Hồ Chí minh', NULL),
(19, 'DangHuy4', '$2a$10$2MaCwuTO/j53PyoAnI7k1u5FdMVBMNaTx8/YZwsaIPkDkAmIG0f6e', 'DangTheHuy', 'dangthhuy@gmail.com', 1, '0852136479', 'Hồ Chí minh', NULL),
(20, 'Daobon200224', '$2a$10$ASN5MzkINVRschl.gQIV1OdTpwZRNj7vx7n8zFvlmgmYwviJCJgvK', 'DaoHongBon', 'daohongbon2k2@gmail.com', 1, '0325088705', 'Hồ Chí minh', 'Admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chuyentien`
--
ALTER TABLE `chuyentien`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `datlich`
--
ALTER TABLE `datlich`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `lichtrinh`
--
ALTER TABLE `lichtrinh`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `loaiphuongtien`
--
ALTER TABLE `loaiphuongtien`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `loaitour`
--
ALTER TABLE `loaitour`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `tentheloai` (`tentheloai`);

--
-- Indexes for table `review`
--
ALTER TABLE `review`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tintuc`
--
ALTER TABLE `tintuc`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tour`
--
ALTER TABLE `tour`
  ADD PRIMARY KEY (`id`),
  ADD KEY `loaitour_id` (`loaitour_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `chuyentien`
--
ALTER TABLE `chuyentien`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT for table `datlich`
--
ALTER TABLE `datlich`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=194;

--
-- AUTO_INCREMENT for table `lichtrinh`
--
ALTER TABLE `lichtrinh`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `loaiphuongtien`
--
ALTER TABLE `loaiphuongtien`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `loaitour`
--
ALTER TABLE `loaitour`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `review`
--
ALTER TABLE `review`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;

--
-- AUTO_INCREMENT for table `tintuc`
--
ALTER TABLE `tintuc`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `tour`
--
ALTER TABLE `tour`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=92;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tour`
--
ALTER TABLE `tour`
  ADD CONSTRAINT `tour_ibfk_1` FOREIGN KEY (`loaitour_id`) REFERENCES `loaitour` (`id`) ON DELETE SET NULL;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
