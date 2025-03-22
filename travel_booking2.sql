-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 22, 2025 at 06:43 PM
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
-- Database: `travel_booking2`
--
CREATE DATABASE IF NOT EXISTS `travel_booking2` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `travel_booking2`;

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
(9, 'Tour Miền Tây'),
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
(1, 'Tour Sapa 3 ngày 2 đêm: Hành trình khám phá Đỉnh Fansipan và thăm Bản Cát Cát', 'dinhfasipan.jpg', 'Chiêm ngưỡng cảnh sắc núi rừng Sapa.\r\nCheck-in tại cảnh điểm Moana với nhiều tiểu cảnh độc đáo, cảnh sắc xinh đẹp.\r\nĐặt chân đến bản Cát Cát, tìm hiểu về đời sống, văn hóa của người H’mông.\r\nChinh phục đỉnh Fansipan - Nóc nhà Đông Dương đầy hùng vĩ.\r\nTự do tham quan, dạo chơi tại Sapa.', '2,800,000', 4, '<p><strong>Ng&agrave;y 1: H&agrave; Nội &ndash; Cao Bằng &ndash; P&aacute;c B&oacute;</strong></p>\r\n\r\n<ul>\r\n	<li><strong>S&aacute;ng:</strong> Khởi h&agrave;nh từ H&agrave; Nội đi Cao Bằng (6-8 tiếng).</li>\r\n	<li><strong>Trưa:</strong> Đến Cao Bằng, ăn trưa v&agrave; nhận ph&ograve;ng kh&aacute;ch sạn.</li>\r\n	<li><strong>Chiều:</strong> Tham quan Khu di t&iacute;ch P&aacute;c B&oacute; (Hang Cốc B&oacute;, suối L&ecirc; Nin).</li>\r\n	<li><strong>Tối:</strong> Ăn tối v&agrave; nghỉ ngơi tại kh&aacute;ch sạn.</li>\r\n</ul>\r\n\r\n<p><strong>Ng&agrave;y 2: Th&aacute;c Bản Giốc &ndash; Động Ngườm Ngao &ndash; H&agrave; Nội</strong></p>\r\n\r\n<ul>\r\n	<li><strong>S&aacute;ng:</strong> Ăn s&aacute;ng, khởi h&agrave;nh đi <strong>Th&aacute;c Bản Giốc</strong> (tham quan v&agrave; chụp ảnh).</li>\r\n	<li><strong>Trưa:</strong> Đến <strong>Động Ngườm Ngao</strong>, kh&aacute;m ph&aacute; động.</li>\r\n	<li><strong>Chiều:</strong> Khởi h&agrave;nh về H&agrave; Nội, dừng ch&acirc;n ăn uống tr&ecirc;n đường.</li>\r\n	<li><strong>Tối:</strong> Về đến H&agrave; Nội, kết th&uacute;c tour.</li>\r\n</ul>\r\n', 'Ô tô', 3, 'Hà Nội', 50, '2025-03-22', 15),
(2, 'Tour du lịch Ninh Bình Hang Múa 2 ngày 1 đêm | Hoa Lư – Tam Cốc – Hang Múa – Tràng An', 'hangmua.jpg', 'Chinh phục 500 bước thang lên Hang Múa, điểm check-in HOT nhất hiện nay.\r\nGhé thăm cố đô Hoa Lư với những di tích lịch sử cổ kính.\r\nVé thuyền ở Tràng An + Tam Cốc để cảm nhận vẻ đẹp bình yên của núi rừng.\r\nThưởng thức những bữa ăn với các món đặc sản hấp dẫn.', '2,480,000', 2, '<p><strong>Ng&agrave;y 1:</strong></p>\r\n\r\n<ul>\r\n	<li>\r\n	<p><strong>07:00</strong>: Khởi h&agrave;nh từ H&agrave; Nội, di chuyển đến Ninh B&igrave;nh.</p>\r\n	</li>\r\n	<li>\r\n	<p><strong>09:00</strong>: Tham quan cố đ&ocirc; Hoa Lư, t&igrave;m hiểu lịch sử v&agrave; văn h&oacute;a.</p>\r\n	</li>\r\n	<li>\r\n	<p><strong>11:30</strong>: Ăn trưa tại nh&agrave; h&agrave;ng địa phương với đặc sản d&ecirc; n&uacute;i.</p>\r\n	</li>\r\n	<li>\r\n	<p><strong>13:00</strong>: Đi thuyền kh&aacute;m ph&aacute; Tam Cốc &ndash; &quot;Hạ Long tr&ecirc;n cạn,&quot; ngắm cảnh n&uacute;i non v&agrave; hang động.</p>\r\n	</li>\r\n	<li>\r\n	<p><strong>15:30</strong>: Tham quan Hang M&uacute;a, chinh phục 500 bậc thang để ngắm to&agrave;n cảnh đẹp ngoạn mục từ đỉnh n&uacute;i.</p>\r\n	</li>\r\n	<li>\r\n	<p><strong>17:30</strong>: Nhận ph&ograve;ng kh&aacute;ch sạn, nghỉ ngơi v&agrave; tự do kh&aacute;m ph&aacute;.</p>\r\n	</li>\r\n</ul>\r\n\r\n<p><strong>Ng&agrave;y 2:</strong></p>\r\n\r\n<ul>\r\n	<li>\r\n	<p><strong>07:30</strong>: D&ugrave;ng bữa s&aacute;ng tại kh&aacute;ch sạn, sau đ&oacute; di chuyển đến khu du lịch Tr&agrave;ng An.</p>\r\n	</li>\r\n	<li>\r\n	<p><strong>09:00</strong>: Trải nghiệm đi thuyền tham quan c&aacute;c hang động, di t&iacute;ch lịch sử v&agrave; ngắm vẻ đẹp thi&ecirc;n nhi&ecirc;n.</p>\r\n	</li>\r\n	<li>\r\n	<p><strong>12:00</strong>: Ăn trưa tại nh&agrave; h&agrave;ng địa phương.</p>\r\n	</li>\r\n	<li>\r\n	<p><strong>13:30</strong>: Khởi h&agrave;nh trở về H&agrave; Nội.</p>\r\n	</li>\r\n	<li>\r\n	<p><strong>16:00</strong>: Kết th&uacute;c h&agrave;nh tr&igrave;nh.</p>\r\n	</li>\r\n</ul>\r\n', 'Ô tô', 2, 'Hà Nội', 40, '2025-03-22', 18),
(3, 'Tour Phú Quốc 3N2D – Tham Quan VinWonders và Safari', 'phuquoc.jpg', 'Ghé thăm địa danh linh thiêng Dinh Cậu.\r\nTrải nghiệm vui chơi tại Hòn Thơm hoặc khám phá Đảo Ngọc với tour ca nô 4 đảo.\r\nDừng chân tại Bãi Sao - Một trong những bãi biển đẹp nhất Phú Quốc.\r\nNgắm hoàng hôn tại Sunset Town.\r\nChiêm ngưỡng vẻ đẹp của Cầu Hôn giữa biển trời mênh mông.\r\nDừng chân tham quan tại Thiền viện Trúc Lâm hộ quốc.\r\nTìm hiểu quy trình sản xuất hồ tiêu Phú Quốc, rượu sim.\r\nKhám phá Suối Tranh thơ mộng.', '2,200,000', 8, '<p><strong>Ng&agrave;y 1:</strong></p>\r\n\r\n<ul>\r\n	<li>\r\n	<p><strong>S&aacute;ng:</strong> Đến Ph&uacute; Quốc, nhận ph&ograve;ng kh&aacute;ch sạn.</p>\r\n	</li>\r\n	<li>\r\n	<p><strong>Chiều:</strong> Tham quan Vinpearl Safari &ndash; c&ocirc;ng vi&ecirc;n b&aacute;n hoang d&atilde; lớn nhất Việt Nam, kh&aacute;m ph&aacute; c&aacute;c lo&agrave;i động vật qu&yacute; hiếm.</p>\r\n	</li>\r\n	<li>\r\n	<p><strong>Tối:</strong> Tự do kh&aacute;m ph&aacute; Grand World &ndash; &quot;Th&agrave;nh phố kh&ocirc;ng ngủ,&quot; thưởng thức nhạc nước v&agrave; c&aacute;c hoạt động giải tr&iacute;.</p>\r\n	</li>\r\n</ul>\r\n\r\n<p><strong>Ng&agrave;y 2:</strong></p>\r\n\r\n<ul>\r\n	<li>\r\n	<p><strong>S&aacute;ng:</strong> Tham quan VinWonders &ndash; c&ocirc;ng vi&ecirc;n giải tr&iacute; hiện đại với nhiều tr&ograve; chơi, c&ocirc;ng vi&ecirc;n nước v&agrave; thủy cung.</p>\r\n	</li>\r\n	<li>\r\n	<p><strong>Chiều:</strong> Tự do tắm biển hoặc tham quan c&aacute;c điểm nổi bật kh&aacute;c tr&ecirc;n đảo.</p>\r\n	</li>\r\n	<li>\r\n	<p><strong>Tối:</strong> Thưởng thức hải sản tại chợ đ&ecirc;m Ph&uacute; Quốc.</p>\r\n	</li>\r\n</ul>\r\n\r\n<p><strong>Ng&agrave;y 3:</strong></p>\r\n\r\n<ul>\r\n	<li>\r\n	<p><strong>S&aacute;ng:</strong> Tham quan l&agrave;ng ch&agrave;i hoặc mua sắm đặc sản l&agrave;m qu&agrave;.</p>\r\n	</li>\r\n	<li>\r\n	<p><strong>Trưa:</strong> Trả ph&ograve;ng, khởi h&agrave;nh về.</p>\r\n	</li>\r\n</ul>\r\n', 'Máy bay', 3, 'Hà Nội', 40, '2025-03-29', 20),
(4, 'Tour du lịch Hạ Long 2 ngày 1 đêm | Hành trình khám phá Vịnh Hạ Long', 'halong.jpg', 'Khám phá Vịnh Hạ Long - Kỳ quan thiên nhiên thế giới được Unesco công nhận.\r\nTrải nghiệm đi du thuyền và chiêm ngưỡng cảnh đẹp Vịnh Hạ Long. \r\nThưởng thức đặc sản của Hạ Long.\r\nHiểu hơn về văn hóa, con người nơi đây.', '2,090,000', 8, '<p><strong>Ng&agrave;y 1:</strong></p>\r\n\r\n<ul>\r\n	<li>\r\n	<p><strong>07:00</strong>: Khởi h&agrave;nh từ H&agrave; Nội, di chuyển đến Hạ Long.</p>\r\n	</li>\r\n	<li>\r\n	<p><strong>11:30</strong>: Đến cảng t&agrave;u, l&ecirc;n t&agrave;u bắt đầu h&agrave;nh tr&igrave;nh tham quan Vịnh Hạ Long.</p>\r\n	</li>\r\n	<li>\r\n	<p><strong>12:30</strong>: Ăn trưa tr&ecirc;n t&agrave;u với c&aacute;c m&oacute;n hải sản tươi ngon.</p>\r\n	</li>\r\n	<li>\r\n	<p><strong>14:00</strong>: Tham quan động Thi&ecirc;n Cung, hang Đầu Gỗ hoặc h&ograve;n Trống M&aacute;i.</p>\r\n	</li>\r\n	<li>\r\n	<p><strong>16:30</strong>: T&agrave;u dừng tại khu vực tắm biển hoặc ch&egrave;o thuyền kayak.</p>\r\n	</li>\r\n	<li>\r\n	<p><strong>18:00</strong>: Ăn tối tr&ecirc;n t&agrave;u v&agrave; thưởng thức cảnh ho&agrave;ng h&ocirc;n tr&ecirc;n vịnh.</p>\r\n	</li>\r\n	<li>\r\n	<p><strong>20:00</strong>: Tham gia c&aacute;c hoạt động giải tr&iacute; tr&ecirc;n t&agrave;u hoặc nghỉ ngơi qua đ&ecirc;m.</p>\r\n	</li>\r\n</ul>\r\n\r\n<p><strong>Ng&agrave;y 2:</strong></p>\r\n\r\n<ul>\r\n	<li>\r\n	<p><strong>06:30</strong>: Dậy sớm ngắm b&igrave;nh minh tr&ecirc;n vịnh, thưởng thức bữa s&aacute;ng.</p>\r\n	</li>\r\n	<li>\r\n	<p><strong>08:00</strong>: Tham quan l&agrave;ng ch&agrave;i Vung Vi&ecirc;ng hoặc khu vực nu&ocirc;i ngọc trai.</p>\r\n	</li>\r\n	<li>\r\n	<p><strong>10:30</strong>: Quay lại cảng, l&ecirc;n xe trở về H&agrave; Nội.</p>\r\n	</li>\r\n	<li>\r\n	<p><strong>12:30</strong>: Ăn trưa tại nh&agrave; h&agrave;ng tr&ecirc;n đường về.</p>\r\n	</li>\r\n	<li>\r\n	<p><strong>16:00</strong>: Đến H&agrave; Nội, kết th&uacute;c h&agrave;nh tr&igrave;nh.</p>\r\n	</li>\r\n</ul>\r\n', 'Tàu thủy', 2, 'Hải Phòng', 40, '2025-03-22', 14),
(5, 'Tour Đồng bằng sông Cửu Long 4N3Đ: Hành trình khám phá 8 tỉnh miền Tây', 'mientay.jpg', 'Mỹ Tho: chiêm bái chùa Vĩnh Tràng, lênh đênh sông Tiền ngắm 4 cù lao Long, Lân, Qui, Phụng \r\nThưởng thức đặc sản kẹo dừa Bến Tre, hòa mình vào nếp sống văn hóa của người dân Nam Bộ hiền lành, chất phác.\r\nChâu Đốc: Rừng Tràm Trà Sư, Miếu Bà Chúa Xứ, Lăng Thoại Ngọc Hầu, Tây An Cổ Tự...\r\nChơi các trò dân gian, ăn trái cây miệt vườn, lắng nghe Đờn Ca Tài Tử\r\nCần Thơ: Chợ nổi Cái Răng, ăn tối trên du thuyền Cần Thơ\r\nGhé Sóc Trăng, tham quan chùa Chén Kiểu của người Khmer\r\nBạc Liêu: viếng mộ Cha Trương Bửu Diệp, cánh đồng quạt gió, nhà công tử Bạc Liêu,...', '4,200,000', 4, '<p><strong>Ng&agrave;y 1:</strong></p>\r\n\r\n<ul>\r\n	<li>\r\n	<p><strong>07:00</strong>: Khởi h&agrave;nh từ điểm hẹn, di chuyển đến Mỹ Tho.</p>\r\n	</li>\r\n	<li>\r\n	<p><strong>09:30</strong>: Tham quan cồn Thới Sơn, trải nghiệm đi thuyền ba l&aacute;.</p>\r\n	</li>\r\n	<li>\r\n	<p><strong>12:00</strong>: Ăn trưa tại nh&agrave; h&agrave;ng địa phương.</p>\r\n	</li>\r\n	<li>\r\n	<p><strong>13:30</strong>: Đến Bến Tre, tham quan l&ograve; kẹo dừa v&agrave; l&agrave;ng nghề.</p>\r\n	</li>\r\n	<li>\r\n	<p><strong>16:00</strong>: Về lại kh&aacute;ch sạn, nghỉ ngơi.</p>\r\n	</li>\r\n</ul>\r\n\r\n<p><strong>Ng&agrave;y 2:</strong></p>\r\n\r\n<ul>\r\n	<li>\r\n	<p><strong>06:30</strong>: Khởi h&agrave;nh đi Cần Thơ, tham quan chợ nổi C&aacute;i Răng.</p>\r\n	</li>\r\n	<li>\r\n	<p><strong>09:00</strong>: Tiếp tục đến S&oacute;c Trăng, viếng ch&ugrave;a Dơi v&agrave; ch&ugrave;a Đất S&eacute;t.</p>\r\n	</li>\r\n	<li>\r\n	<p><strong>12:30</strong>: Ăn trưa tại S&oacute;c Trăng.</p>\r\n	</li>\r\n	<li>\r\n	<p><strong>15:00</strong>: Tham quan th&ecirc;m điểm địa phương (tuỳ chọn).</p>\r\n	</li>\r\n	<li>\r\n	<p><strong>17:30</strong>: Nhận ph&ograve;ng kh&aacute;ch sạn, nghỉ ngơi.</p>\r\n	</li>\r\n</ul>\r\n\r\n<p><strong>Ng&agrave;y 3:</strong></p>\r\n\r\n<ul>\r\n	<li>\r\n	<p><strong>07:00</strong>: Di chuyển đến Bạc Li&ecirc;u, tham quan nh&agrave; C&ocirc;ng tử Bạc Li&ecirc;u v&agrave; c&aacute;nh đồng quạt gi&oacute;.</p>\r\n	</li>\r\n	<li>\r\n	<p><strong>10:30</strong>: Đến C&agrave; Mau, chinh phục mũi C&agrave; Mau.</p>\r\n	</li>\r\n	<li>\r\n	<p><strong>12:30</strong>: D&ugrave;ng bữa trưa tại C&agrave; Mau.</p>\r\n	</li>\r\n	<li>\r\n	<p><strong>15:00</strong>: Tự do tham quan v&agrave; mua sắm đặc sản.</p>\r\n	</li>\r\n	<li>\r\n	<p><strong>18:00</strong>: Về kh&aacute;ch sạn nghỉ ngơi.</p>\r\n	</li>\r\n</ul>\r\n\r\n<p><strong>Ng&agrave;y 4:</strong></p>\r\n\r\n<ul>\r\n	<li>\r\n	<p><strong>06:30</strong>: Khởi h&agrave;nh đi Long Xuy&ecirc;n, kh&aacute;m ph&aacute; l&agrave;ng nổi Ch&acirc;u Đốc.</p>\r\n	</li>\r\n	<li>\r\n	<p><strong>10:00</strong>: Gh&eacute; thăm Chợ Tịnh Bi&ecirc;n, mua đặc sản l&agrave;m qu&agrave;.</p>\r\n	</li>\r\n	<li>\r\n	<p><strong>12:30</strong>: Ăn trưa v&agrave; nghỉ ngơi.</p>\r\n	</li>\r\n	<li>\r\n	<p><strong>14:00</strong>: Khởi h&agrave;nh về điểm xuất ph&aacute;t.</p>\r\n	</li>\r\n	<li>\r\n	<p><strong>18:00</strong>: Kết th&uacute;c h&agrave;nh tr&igrave;nh.</p>\r\n	</li>\r\n</ul>\r\n', 'Ô tô', 4, 'Cần Thơ', 60, '2025-03-24', 16),
(6, 'Tour du lịch miền Tây: Mỹ Tho – Bến Tre – Cần Thơ 2 ngày 1 đêm', 'mientay1.jpg', 'Lên thuyền khám phá Cù Lao Thới Sơn, tự tay hái những trái cây tươi ngon ngay tại vườn.\r\nThưởng thức bữa tối sang trọng trên du thuyền 5 sao đẳng cấp tại bến Ninh Kiều.\r\nKhám phá hương vị độc đáo của ẩm thực miền Tây tại chợ nổi Cái Răng.\r\nTìm hiểu về lịch sử và văn hóa Việt Nam tại thiền viện Trúc Lâm Phương Nam.\r\nGhi lại những khoảnh khắc đẹp tại Căn Nhà Màu Tím với khung cảnh nên thơ.', '1,700,000', 9, '<h3>Lịch Tr&igrave;nh Tour Miền T&acirc;y: Mỹ Tho &ndash; Bến Tre &ndash; Cần Thơ 2 Ng&agrave;y 1 Đ&ecirc;m</h3>\r\n\r\n<p>Ng&agrave;y 1: H&agrave; Nội/TP.HCM &ndash; Mỹ Tho &ndash; Bến Tre</p>\r\n\r\n<ul>\r\n	<li><strong>08:00</strong>: Khởi h&agrave;nh từ H&agrave; Nội/TP.HCM đến Mỹ Tho.</li>\r\n	<li><strong>09:30</strong>: Tham quan ch&ugrave;a Vĩnh Tr&agrave;ng.</li>\r\n	<li><strong>12:00</strong>: Đi thuyền tham quan s&ocirc;ng Mekong, ăn trưa với đặc sản địa phương.</li>\r\n	<li><strong>14:00</strong>: Đến Bến Tre, tham quan l&agrave;ng nghề l&agrave;m kẹo dừa.</li>\r\n	<li><strong>16:00</strong>: Trải nghiệm đi xe đạp kh&aacute;m ph&aacute; Bến Tre.</li>\r\n	<li><strong>18:30</strong>: Nhận ph&ograve;ng, ăn tối v&agrave; nghỉ đ&ecirc;m tại Bến Tre.</li>\r\n</ul>\r\n\r\n<p>Ng&agrave;y 2: Bến Tre &ndash; Cần Thơ</p>\r\n\r\n<ul>\r\n	<li><strong>07:30</strong>: Ăn s&aacute;ng tại kh&aacute;ch sạn.</li>\r\n	<li><strong>09:00</strong>: Khởi h&agrave;nh đi Cần Thơ, tham quan chợ nổi C&aacute;i Răng.</li>\r\n	<li><strong>12:00</strong>: D&ugrave;ng bữa trưa tại nh&agrave; h&agrave;ng ở Cần Thơ.</li>\r\n	<li><strong>14:00</strong>: Tham quan vườn tr&aacute;i c&acirc;y.</li>\r\n	<li><strong>16:00</strong>: Khởi h&agrave;nh về lại H&agrave; Nội/TP.HCM.</li>\r\n</ul>\r\n', 'Ô tô', 2, 'Hồ Chí Minh', 50, '2025-03-22', 15),
(7, 'Tour Miền Tây 3 Ngày 2 Đêm: Khám Phá Vẻ Đẹp Miền Tây Sông Nước', 'mientay.jpg', 'Đắm mình trong không gian linh thiêng của chùa Vĩnh Tràng, một kiệt tác kiến trúc cổ.\r\nChiêm ngưỡng nét đẹp độc đáo của chùa Som Rong, một công trình kiến trúc Khmer.\r\nTham quan những địa điểm nổi tiếng của Bạc Liêu như nhà thờ Tắc Sậy, nhà công tử Bạc Liêu,...\r\nĐặt chân đến điểm cực Nam của Tổ quốc và check-in tại cột mốf  c tọa độ.\r\nBữa tối thượng hạng trên du thuyền 5 sao tại bến Ninh Kiều', '3,100,000', 9, '', 'Ô tô', 4, 'Hồ Chí Minh', 45, '2025-03-22', 13),
(92, 'Tour Đà nẵng Hội An Bà Nà Hills 3N2Đ: Khám Phá Miền Trung Hằng Ngày', 'danang.jpg', 'Khám phá bán đảo Sơn Trà, điểm đến đầy hấp dẫn mà bất kỳ du khách nào đến với Đà Nẵng cùng đều ghé qua.\r\nViếng chùa Linh Ứng trên bán đảo Sơn Trà, cầu bình an, sức khỏe cho bản thân, gia đình.\r\nDạo chơi phố cổ Hội An với vẻ đẹp đầy hoài niệm, nơi nhịp sống diễn ra đầy chậm rãi.\r\nVui chơi tại Bà Nà Hills. Tại đây, bạn sẽ được đặt chân đến những điểm check-in hot tại đỉnh núi Chúa. Cùng với đó là thử sức cùng những trò chơi thú vị tại Fantasy Park.\r\nTham quan Ngũ Hành Sơn với những điểm đến đặc sắc.', '2,290,000', 4, '<h3>Lịch Tr&igrave;nh Tour Đ&agrave; Nẵng - Hội An - B&agrave; N&agrave; Hills 3 Ng&agrave;y 2 Đ&ecirc;m</h3>\r\n\r\n<p>Ng&agrave;y 1: H&agrave; Nội/TP.HCM &ndash; Đ&agrave; Nẵng &ndash; Hội An</p>\r\n\r\n<ul>\r\n	<li><strong>S&aacute;ng</strong>: Bay đến Đ&agrave; Nẵng, di chuyển về Hội An.</li>\r\n	<li><strong>Trưa</strong>: Ăn trưa tại Hội An (Cao Lầu, Ho&agrave;nh Th&aacute;nh).</li>\r\n	<li><strong>Chiều</strong>: Kh&aacute;m ph&aacute; Phố Cổ Hội An: Ch&ugrave;a Cầu, Hội qu&aacute;n Ph&uacute;c Kiến.</li>\r\n	<li><strong>Tối</strong>: D&ugrave;ng bữa tối, dạo phố Hội An. Nghỉ đ&ecirc;m tại Hội An.</li>\r\n</ul>\r\n\r\n<p>Ng&agrave;y 2: Hội An &ndash; B&agrave; N&agrave; Hills</p>\r\n\r\n<ul>\r\n	<li><strong>S&aacute;ng</strong>: Ăn s&aacute;ng, khởi h&agrave;nh đi B&agrave; N&agrave; Hills, tham quan khu du lịch.</li>\r\n	<li><strong>Trưa</strong>: Buffet trưa tại B&agrave; N&agrave;.</li>\r\n	<li><strong>Chiều</strong>: Thăm Cầu V&agrave;ng, Vườn Hoa Thi&ecirc;n Cầm, Fantasy Park.</li>\r\n	<li><strong>Tối</strong>: Quay về Đ&agrave; Nẵng, ăn tối, nghỉ đ&ecirc;m tại Đ&agrave; Nẵng.</li>\r\n</ul>\r\n\r\n<p>Ng&agrave;y 3: Đ&agrave; Nẵng &ndash; Ngũ H&agrave;nh Sơn &ndash; S&acirc;n Bay</p>\r\n\r\n<ul>\r\n	<li><strong>S&aacute;ng</strong>: Ăn s&aacute;ng, tham quan Ngũ H&agrave;nh Sơn.</li>\r\n	<li><strong>Trưa</strong>: Ăn trưa tại Đ&agrave; Nẵng.</li>\r\n	<li><strong>Chiều</strong>: Mua sắm tại chợ H&agrave;n, ra s&acirc;n bay l&agrave;m thủ tục trở về.</li>\r\n</ul>\r\n', 'Máy bay', 3, 'Hồ Chí Minh', 50, '2025-03-22', 10),
(93, 'Tour du lịch Hà Nội – Sapa – Hạ Long – Ninh Bình 5N4Đ | Khám phá danh thắng miền Bắc', 'sapa.jpg', 'Viếng lăng Chủ tịch Hồ Chí Minh\r\nTham quan Chùa Trấn Quốc – Hồ Tây\r\nTìm hiểu lịch sử: Văn Miếu – Quốc Tử Giám, Nhà tù Hỏa Lò, Bảo tàng Dân tộc học\r\nKhám phá Ninh Bình: Chùa Bái Đính, khu du lịch Sinh thái Tràng An\r\nVi vu Hạ Long: Hang Sửng Sốt, Đảo Titop, Vịnh Hạ Long\r\nChinh phục Sapa: Đỉnh Fansipan, bản Cát Cát – Thác Tiên Sa', '5,250,000', 4, '<h3>Lịch Tr&igrave;nh Tour H&agrave; Nội &ndash; Sapa &ndash; Hạ Long &ndash; Ninh B&igrave;nh 5 Ng&agrave;y 4 Đ&ecirc;m</h3>\r\n\r\n<p>Ng&agrave;y 1: H&agrave; Nội &ndash; Sapa</p>\r\n\r\n<ul>\r\n	<li><strong>S&aacute;ng</strong>: Khởi h&agrave;nh từ H&agrave; Nội đi Sapa (khoảng 5-6 tiếng).</li>\r\n	<li><strong>Trưa</strong>: Đến Sapa, nhận ph&ograve;ng, ăn trưa tại nh&agrave; h&agrave;ng.</li>\r\n	<li><strong>Chiều</strong>: Tham quan thị trấn Sapa, gh&eacute; thăm chợ Sapa v&agrave; Nh&agrave; thờ Đ&aacute;.</li>\r\n	<li><strong>Tối</strong>: Ăn tối, tự do kh&aacute;m ph&aacute; Sapa về đ&ecirc;m. Nghỉ đ&ecirc;m tại Sapa.</li>\r\n</ul>\r\n\r\n<p>Ng&agrave;y 2: Sapa &ndash; Th&aacute;c Bạc &ndash; Fansipan</p>\r\n\r\n<ul>\r\n	<li><strong>S&aacute;ng</strong>: Đi bộ hoặc &ocirc; t&ocirc; đến Th&aacute;c Bạc, chụp ảnh.</li>\r\n	<li><strong>Trưa</strong>: Ăn trưa tại nh&agrave; h&agrave;ng.</li>\r\n	<li><strong>Chiều</strong>: Tham quan c&aacute;p treo l&ecirc;n đỉnh Fansipan, ngắm cảnh.</li>\r\n	<li><strong>Tối</strong>: D&ugrave;ng bữa tối v&agrave; nghỉ đ&ecirc;m tại Sapa.</li>\r\n</ul>\r\n\r\n<p>Ng&agrave;y 3: Sapa &ndash; H&agrave; Nội &ndash; Hạ Long</p>\r\n\r\n<ul>\r\n	<li><strong>S&aacute;ng</strong>: Sau bữa s&aacute;ng, tham quan bản C&aacute;t C&aacute;t, t&igrave;m hiểu văn h&oacute;a người H&#39;m&ocirc;ng.</li>\r\n	<li><strong>Trưa</strong>: Quay về H&agrave; Nội, ăn trưa.</li>\r\n	<li><strong>Chiều</strong>: Khởi h&agrave;nh đi Hạ Long (khoảng 2-3 tiếng).</li>\r\n	<li><strong>Tối</strong>: Nhận ph&ograve;ng kh&aacute;ch sạn tại Hạ Long, ăn tối v&agrave; nghỉ đ&ecirc;m.</li>\r\n</ul>\r\n\r\n<p>Ng&agrave;y 4: Hạ Long &ndash; Tour Thuyền</p>\r\n\r\n<ul>\r\n	<li><strong>S&aacute;ng</strong>: D&ugrave;ng bữa s&aacute;ng tại kh&aacute;ch sạn, tham gia tour du thuyền Halong Bay.</li>\r\n	<li><strong>Trưa</strong>: Ăn trưa tr&ecirc;n thuyền, tham quan c&aacute;c đảo v&agrave; hang động (Động Thi&ecirc;n Cung, Đảo Ti Tốp).</li>\r\n	<li><strong>Tối</strong>: Quay về đất liền, ăn tối tại nh&agrave; h&agrave;ng v&agrave; nghỉ đ&ecirc;m tại Hạ Long.</li>\r\n</ul>\r\n\r\n<p>Ng&agrave;y 5: Hạ Long &ndash; Ninh B&igrave;nh &ndash; H&agrave; Nội</p>\r\n\r\n<ul>\r\n	<li><strong>S&aacute;ng</strong>: Khởi h&agrave;nh đi Ninh B&igrave;nh (khoảng 2 tiếng).</li>\r\n	<li><strong>Trưa</strong>: Tham quan Tr&agrave;ng An, đi thuyền tham quan c&aacute;c hang động.</li>\r\n	<li><strong>Chiều</strong>: Tham quan ch&ugrave;a B&aacute;i Đ&iacute;nh.</li>\r\n	<li><strong>Tối</strong>: Quay về H&agrave; Nội, kết th&uacute;c chuyến tour.</li>\r\n</ul>\r\n', 'Máy bay', 5, 'Hồ Chí Minh', 50, '2025-03-22', 10),
(94, 'Tour Phú Quốc Trong 1 Ngày – Khám Phá Đảo Ngọc Thiên Nhiên Hoang Sơ', 'phuquoc1.jpg', 'Tìm hiểu những làng nghề truyền thống lâu đời ở đảo Phú Quốc: Hồ tiêu Phú Quốc, Nhà thùng nước mắm, Rượu Sim.\r\nTham quan di tích lịch sử Nhà Tù Phú Quốc để hiểu hơn về lịch sử Việt Nam trong giai đoạn chống Pháp và Mỹ.\r\nTắm biển, check-in thỏa thích tại Bãi Sao - Một trong những bãi biển đẹp nhất tại Phú Quốc.\r\nMê đắm trước vẻ đẹp hoang sơ, mộc mạc nhưng đầy kỳ vĩ của Suối Tranh. \r\nChiêm bái và cầu may mắn tại Chùa Muôn Sư.', '890,000', 4, '<p><strong>Buổi s&aacute;ng:</strong></p>\r\n\r\n<ul>\r\n	<li>\r\n	<p><strong>08:00:</strong> Khởi h&agrave;nh đến b&atilde;i Sao &ndash; một trong những b&atilde;i biển đẹp nhất Ph&uacute; Quốc, thả m&igrave;nh trong l&agrave;n nước trong xanh.</p>\r\n	</li>\r\n	<li>\r\n	<p><strong>10:30:</strong> Tham quan nh&agrave; th&ugrave;ng nước mắm Ph&uacute; Quốc, t&igrave;m hiểu quy tr&igrave;nh l&agrave;m nước mắm truyền thống.</p>\r\n	</li>\r\n	<li>\r\n	<p><strong>11:30:</strong> Gh&eacute; l&agrave;ng ch&agrave;i H&agrave;m Ninh, thưởng thức hải sản tươi sống.</p>\r\n	</li>\r\n</ul>\r\n\r\n<p><strong>Buổi chiều:</strong></p>\r\n\r\n<ul>\r\n	<li>\r\n	<p><strong>13:30:</strong> Tham quan Suối Tranh &ndash; d&ograve;ng suối thơ mộng giữa thi&ecirc;n nhi&ecirc;n.</p>\r\n	</li>\r\n	<li>\r\n	<p><strong>15:00:</strong> Tham quan ch&ugrave;a Hộ Quốc (Thiền viện Tr&uacute;c L&acirc;m Hộ Quốc), ngắm cảnh h&ugrave;ng vĩ từ tr&ecirc;n cao.</p>\r\n	</li>\r\n	<li>\r\n	<p><strong>16:30:</strong> Gh&eacute; mua sắm đặc sản tại chợ Dương Đ&ocirc;ng trước khi kết th&uacute;c h&agrave;nh tr&igrave;nh.</p>\r\n	</li>\r\n</ul>\r\n', 'Ô tô', 1, 'Hồ Chí Minh', 50, '2025-03-29', 20),
(95, 'Tour Hà Giang Giá Rẻ từ TP.HCM: Khám Phá Vùng Cao 5 Ngày 4 Đêm', 'hagiang.jpg', 'Check-in tại Bản Nậm Hồng, nơi sinh sống của 37 hộ dân tộc đồng bào Dao Đỏ. Nhìn ngắm những thửa ruộng bậc thang như những nấc thang lên thiên đường.\r\nĐến Hồ Thầu, chinh phục đỉnh Chiêu Lầu Thi. Trải nghiệm săn mây và ngắm núi đồi, khung cảnh từ độ cao 2.402 mét.\r\nKhám phá thị trấn Cốc Pài, đặt chân đến Bản Phùng hoặc tận hưởng thiên nhiên núi rừng nơi thảo nguyên Suôi Thầu.\r\nMua sắm tại chợ Bắc Hà. Nơi bán những món ăn mang đậm hương vị Tây Bắc. Giao tiếp cùng những người dân tộc đồng bào nơi đây.', '7,100,000', 6, '<ul>\r\n	<li>\r\n	<p><strong>Ng&agrave;y 1</strong>: Bay từ TP.HCM đến H&agrave; Nội, sau đ&oacute; đi &ocirc; t&ocirc; l&ecirc;n H&agrave; Giang. Nghỉ đ&ecirc;m tại H&agrave; Giang.</p>\r\n	</li>\r\n	<li>\r\n	<p><strong>Ng&agrave;y 2</strong>: Kh&aacute;m ph&aacute; Cổng trời Quản Bạ, N&uacute;i đ&ocirc;i C&ocirc; Ti&ecirc;n v&agrave; Y&ecirc;n Minh. Thưởng ngoạn cảnh n&uacute;i non h&ugrave;ng vĩ.</p>\r\n	</li>\r\n	<li>\r\n	<p><strong>Ng&agrave;y 3</strong>: Tham quan Cao nguy&ecirc;n Đồng Văn, Đ&egrave;o M&atilde; P&igrave; L&egrave;ng v&agrave; S&ocirc;ng Nho Quế. Ngắm nh&igrave;n thi&ecirc;n nhi&ecirc;n tuyệt đẹp.</p>\r\n	</li>\r\n	<li>\r\n	<p><strong>Ng&agrave;y 4</strong>: Tham quan Cột cờ Lũng C&uacute; (cực bắc của Việt Nam) v&agrave; c&aacute;c bản l&agrave;ng d&acirc;n tộc. Quay lại H&agrave; Giang.</p>\r\n	</li>\r\n	<li>\r\n	<p><strong>Ng&agrave;y 5:&nbsp;</strong>Trở về H&agrave; Nội, bay về TP.HCM.</p>\r\n	</li>\r\n</ul>\r\n', 'Máy bay', 5, 'Hồ Chí Minh', 50, '2025-03-26', 20),
(96, 'Tour Hà Nội – Côn Đảo 3N2Đ – Du Lịch Biển Đảo 3 Ngày 2 Đêm', 'condao.jpg', 'Viếng mộ cô Sáu nổi tiếng linh thiêng và huyền bí - Nghĩa trang duy nhất có phong tục viếng vào lúc 23 giờ trở đi. \r\nTự do ngắm biển Côn Đảo và tận hưởng không gian thư thái.\r\nVãn cảnh chùa cổ Núi Một nổi tiếng của xứ đảo.\r\nTham An Sơn Miếu - Nghe câu ca ai oán về thứ phi Hoàng Phi Yến.\r\nViếng Miếu Cậu - nơi thờ Hoàng Tử Cải.\r\nTắm bãi Đầm Trầu đẹp và sạch nhất Côn Đảo.', '6,300,000', 5, '<ul>\r\n	<li>\r\n	<p><strong>Ng&agrave;y 1</strong>:</p>\r\n\r\n	<ul>\r\n		<li>\r\n		<p>Khởi h&agrave;nh từ H&agrave; Nội đến C&ocirc;n Đảo bằng m&aacute;y bay.</p>\r\n		</li>\r\n		<li>\r\n		<p>Tham quan Miếu Cậu, B&atilde;i Đầm Trầu v&agrave; tận hưởng kh&ocirc;ng gian biển đảo.</p>\r\n		</li>\r\n		<li>\r\n		<p>Nghỉ đ&ecirc;m tại kh&aacute;ch sạn ti&ecirc;u chuẩn.</p>\r\n		</li>\r\n	</ul>\r\n	</li>\r\n	<li>\r\n	<p><strong>Ng&agrave;y 2</strong>:</p>\r\n\r\n	<ul>\r\n		<li>\r\n		<p>Tham quan c&aacute;c địa danh lịch sử như Bảo t&agrave;ng C&ocirc;n Đảo, Trại t&ugrave; Ph&uacute; Sơn, Ph&uacute; Hải.</p>\r\n		</li>\r\n		<li>\r\n		<p>Viếng Nghĩa Trang H&agrave;ng Dương v&agrave; Mộ C&ocirc; S&aacute;u.</p>\r\n		</li>\r\n		<li>\r\n		<p>Kh&aacute;m ph&aacute; Ch&ugrave;a N&uacute;i Một v&agrave; c&aacute;c điểm t&acirc;m linh kh&aacute;c.</p>\r\n		</li>\r\n	</ul>\r\n	</li>\r\n	<li>\r\n	<p><strong>Ng&agrave;y 3</strong>:</p>\r\n\r\n	<ul>\r\n		<li>\r\n		<p>Tự do tham quan, mua sắm qu&agrave; lưu niệm.</p>\r\n		</li>\r\n		<li>\r\n		<p>Trở về H&agrave; Nội bằng m&aacute;y bay.</p>\r\n		</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n', 'Tàu Thủy', 3, 'Hà Nội', 50, '2025-03-26', 15),
(97, 'Tour Làng Vũ Đại – Khu du lịch tâm linh Tam Chúc – Ngũ Động Thi Sơn 2 ngày 1 đêm', 'vudai.jpg', 'Tham quan Làng Vũ Đại với món cá kho trứ danh mọi miền.\r\n\r\nTrải nghiệm đi thuyền du ngoạn hồ Tam Chúc sơn thủy hữu tình.\r\n\r\nChiêm ngưỡng những công trình kiến trúc đồ sộ của khu du lịch Tam Chúc.\r\n\r\nNgắm nhìn tuyệt tác của đất trời Ngũ Động Thi Sơn với nhiều nhũ đá độc đáo.\r\n\r\nThưởng thức ẩm thực địa phương độc đáo.', '1,900,000', 3, '<ul>\r\n	<li>\r\n	<p><strong>Ng&agrave;y 1</strong>:</p>\r\n\r\n	<ul>\r\n		<li>\r\n		<p>Khởi h&agrave;nh từ H&agrave; Nội đến L&agrave;ng Vũ Đại (H&agrave; Nam). Tham quan ng&ocirc;i nh&agrave; B&aacute; Kiến, mộ nh&agrave; văn Nam Cao, v&agrave; l&agrave;ng nghề kho c&aacute; truyền thống.</p>\r\n		</li>\r\n		<li>\r\n		<p>Thưởng thức đặc sản địa phương như c&aacute; kho l&agrave;ng Vũ Đại, chuối ngự Đại Ho&agrave;ng.</p>\r\n		</li>\r\n		<li>\r\n		<p>Tiếp tục đến khu du lịch Tam Ch&uacute;c, tham quan Điện Tam Thế, Điện Gi&aacute;o Chủ, vườn cột kinh, v&agrave; du ngoạn hồ Tam Ch&uacute;c bằng thuyền.</p>\r\n		</li>\r\n		<li>\r\n		<p>Nghỉ đ&ecirc;m tại kh&aacute;ch x&aacute; Tam Ch&uacute;c.</p>\r\n		</li>\r\n	</ul>\r\n	</li>\r\n	<li>\r\n	<p><strong>Ng&agrave;y 2</strong>:</p>\r\n\r\n	<ul>\r\n		<li>\r\n		<p>Tham quan Ngũ Động Thi Sơn với c&aacute;c hang động độc đ&aacute;o v&agrave; nhũ đ&aacute; tuyệt đẹp.</p>\r\n		</li>\r\n		<li>\r\n		<p>Trở về H&agrave; Nội, kết th&uacute;c h&agrave;nh tr&igrave;nh.</p>\r\n		</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n', 'Ô tô', 2, 'Hà Nội', 50, '2025-03-24', 15),
(98, 'Tour Singapore 3N2Đ | Merlion Park – Garden By The Bay – Đảo Sentosa', 'singapore.jpg', 'Chiêm ngưỡng khung cảnh siêu cây khổng lồ tại Garden by the Bay.\r\nViếng thăm, chiêm bái Chùa Răng Phật - Nơi lưu giữ xá lợi răng Đức Phật cùng với hàng nghìn bức tượng khổng lồ. \r\nThỏa sức vui chơi quên lối về ở đảo Sentosa.\r\nThử vận may tại Casino Resort World.\r\nTrải nghiệm 1 đêm city tour Singapore với những điều ký thú.\r\nThưởng thức buffet BBQ hoành sáng.', '17,900,000', 7, '<ol>\r\n	<li>\r\n	<p><strong>Ng&agrave;y 1</strong>:</p>\r\n\r\n	<ul>\r\n		<li>\r\n		<p>Khởi h&agrave;nh từ Việt Nam đến Singapore.</p>\r\n		</li>\r\n		<li>\r\n		<p>Tham quan Merlion Park (biểu tượng của Singapore), Nh&agrave; h&aacute;t Victoria, v&agrave; Nh&agrave; h&aacute;t Esplanade.</p>\r\n		</li>\r\n		<li>\r\n		<p>Nghỉ đ&ecirc;m tại kh&aacute;ch sạn.</p>\r\n		</li>\r\n	</ul>\r\n	</li>\r\n	<li>\r\n	<p><strong>Ng&agrave;y 2</strong>:</p>\r\n\r\n	<ul>\r\n		<li>\r\n		<p>Kh&aacute;m ph&aacute; Gardens by the Bay với c&aacute;c si&ecirc;u c&acirc;y khổng lồ v&agrave; khu vườn nh&acirc;n tạo.</p>\r\n		</li>\r\n		<li>\r\n		<p>Tham quan Ch&ugrave;a Răng Phật tại Chinatown.</p>\r\n		</li>\r\n		<li>\r\n		<p>Buổi chiều, đến Đảo Sentosa để vui chơi v&agrave; tham quan Universal Studios (chụp ảnh b&ecirc;n ngo&agrave;i).</p>\r\n		</li>\r\n		<li>\r\n		<p>Nghỉ đ&ecirc;m tại kh&aacute;ch sạn.</p>\r\n		</li>\r\n	</ul>\r\n	</li>\r\n	<li>\r\n	<p><strong>Ng&agrave;y 3</strong>:</p>\r\n\r\n	<ul>\r\n		<li>\r\n		<p>Tự do mua sắm tại c&aacute;c trung t&acirc;m thương mại hoặc tham quan th&ecirc;m c&aacute;c điểm nổi bật.</p>\r\n		</li>\r\n		<li>\r\n		<p>Trở về Việt Nam.</p>\r\n		</li>\r\n	</ul>\r\n	</li>\r\n</ol>\r\n\r\n<p>&nbsp;</p>\r\n', 'Máy bay', 3, 'Hà Nội', 50, '2025-03-25', 20),
(99, 'Tour Nha Trang – Đà Lạt 4 ngày 3 đêm: Khám phá thành phố biển đến xứ ngàn hoa', 'nhatrang.jpg', 'Khám phá Vinpearl Land Nha Trang công viên giải trí hàng đầu Việt Nam.\r\nTham quan Nhà thờ Chánh Tòa Nha Trang - công trình kiến trúc độc đáo.\r\nTham quan Nhà Yến Nha Trang là nơi sản xuất tổ yến nổi tiếng.\r\nTham quan công trình Chăm nổi bật Tháp Bà Ponagar tại Nha Trang.\r\nTận hưởng liệu pháp tắm bùn khoáng nóng độc đáo tại khu du lịch suối khoáng Tháp Bà.', '5,000,000', 5, '<ul>\r\n	<li>\r\n	<p><strong>Ng&agrave;y 1</strong>:</p>\r\n\r\n	<ul>\r\n		<li>\r\n		<p>Đến Nha Trang, tham quan Nh&agrave; thờ Ch&aacute;nh T&ograve;a, Ch&ugrave;a Long Sơn, v&agrave; c&aacute;c điểm nổi bật trong th&agrave;nh phố.</p>\r\n		</li>\r\n		<li>\r\n		<p>Tự do tắm biển hoặc kh&aacute;m ph&aacute; VinWonders (chi ph&iacute; tự t&uacute;c).</p>\r\n		</li>\r\n		<li>\r\n		<p>Nghỉ đ&ecirc;m tại Nha Trang.</p>\r\n		</li>\r\n	</ul>\r\n	</li>\r\n	<li>\r\n	<p><strong>Ng&agrave;y 2</strong>:</p>\r\n\r\n	<ul>\r\n		<li>\r\n		<p>Du ngoạn Vịnh Nha Trang, tham gia c&aacute;c hoạt động như lặn ngắm san h&ocirc;, d&ugrave; lượn, hoặc tắm biển tại B&atilde;i Tranh.</p>\r\n		</li>\r\n		<li>\r\n		<p>Thưởng thức hải sản tươi ngon tại L&agrave;ng Ch&agrave;i.</p>\r\n		</li>\r\n		<li>\r\n		<p>Nghỉ đ&ecirc;m tại Nha Trang.</p>\r\n		</li>\r\n	</ul>\r\n	</li>\r\n	<li>\r\n	<p><strong>Ng&agrave;y 3</strong>:</p>\r\n\r\n	<ul>\r\n		<li>\r\n		<p>Di chuyển đến Đ&agrave; Lạt, tham quan Thung lũng T&igrave;nh Y&ecirc;u, Vườn Hoa Th&agrave;nh Phố, v&agrave; Thiền Viện Tr&uacute;c L&acirc;m.</p>\r\n		</li>\r\n		<li>\r\n		<p>Tận hưởng kh&ocirc;ng kh&iacute; m&aacute;t mẻ v&agrave; cảnh quan thi&ecirc;n nhi&ecirc;n tuyệt đẹp.</p>\r\n		</li>\r\n		<li>\r\n		<p>Nghỉ đ&ecirc;m tại Đ&agrave; Lạt.</p>\r\n		</li>\r\n	</ul>\r\n	</li>\r\n	<li>\r\n	<p><strong>Ng&agrave;y 4</strong>:</p>\r\n\r\n	<ul>\r\n		<li>\r\n		<p>Tham quan c&aacute;c điểm nổi bật kh&aacute;c như Dinh Bảo Đại hoặc Langbiang.</p>\r\n		</li>\r\n		<li>\r\n		<p>Trở về điểm xuất ph&aacute;t, kết th&uacute;c h&agrave;nh tr&igrave;nh.</p>\r\n		</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n', 'Máy bay', 4, 'Hồ Chí Minh', 50, '2025-03-25', 10),
(100, 'Tour Team Building – Gala Lunch Hồ Tràm: Một ngày khám phá vùng biển hoang sơ', 'hotram.jpg', 'Khám phá và tắm biển Hồ Tràm\r\nTham gia chương trình team building với các trò chơi vui nhộn\r\nTham gia tiệc Gala Lunch sôi động và nhận quà siêu hấp dẫn', '1,190,000', 5, '<ul>\r\n	<li>\r\n	<p><strong>Buổi s&aacute;ng</strong>:</p>\r\n\r\n	<ul>\r\n		<li>\r\n		<p>Khởi h&agrave;nh từ TP.HCM đến Hồ Tr&agrave;m.</p>\r\n		</li>\r\n		<li>\r\n		<p>Tham gia c&aacute;c hoạt động team building tr&ecirc;n b&atilde;i biển với c&aacute;c tr&ograve; chơi tập thể vui nhộn, nhằm gắn kết v&agrave; ph&aacute;t huy tinh thần đồng đội.</p>\r\n		</li>\r\n		<li>\r\n		<p>Tắm biển v&agrave; tận hưởng kh&ocirc;ng gian hoang sơ của Hồ Tr&agrave;m.</p>\r\n		</li>\r\n	</ul>\r\n	</li>\r\n	<li>\r\n	<p><strong>Buổi trưa</strong>:</p>\r\n\r\n	<ul>\r\n		<li>\r\n		<p>Tham gia tiệc Gala Lunch với c&aacute;c m&oacute;n ăn đặc sản địa phương.</p>\r\n		</li>\r\n		<li>\r\n		<p>Chương tr&igrave;nh giao lưu văn nghệ, nhận qu&agrave; tặng v&agrave; tổ chức sinh nhật cho c&aacute;c th&agrave;nh vi&ecirc;n c&oacute; ng&agrave;y sinh trong th&aacute;ng.</p>\r\n		</li>\r\n	</ul>\r\n	</li>\r\n	<li>\r\n	<p><strong>Buổi chiều</strong>:</p>\r\n\r\n	<ul>\r\n		<li>\r\n		<p>Gh&eacute; trạm dừng ch&acirc;n B&ograve; Sữa Long Th&agrave;nh để mua sắm qu&agrave; lưu niệm.</p>\r\n		</li>\r\n		<li>\r\n		<p>Trở về TP.HCM, kết th&uacute;c h&agrave;nh tr&igrave;nh.</p>\r\n		</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n', 'Ô tô', 1, 'Vũng Tàu', 50, '2025-03-25', 30),
(101, 'Tour du lịch Mộc Châu Tà Xùa 2 ngày 1 đêm: Khám Phá Cao Nguyên và Săn Mây', 'mocchau.jpg', 'Đón nắng mai trên đèo Thung Khe.\r\nCheck-in các điểm đến siêu HOT ở Mộc Châu: Vườn hoa Happy land, Cầu Kính Bạch Long\r\nSăn mây Tà Xùa ngắm bình minh lên, thưởng thức tách cà phê sáng trên đỉnh núi. ', '1,590,000', 6, '<ul>\r\n	<li>\r\n	<p><strong>Ng&agrave;y 1</strong>:</p>\r\n\r\n	<ul>\r\n		<li>\r\n		<p>Khởi h&agrave;nh từ H&agrave; Nội đến Mộc Ch&acirc;u, dừng ch&acirc;n tại Đ&egrave;o Đ&aacute; Trắng (Thung Khe) để ngắm cảnh.</p>\r\n		</li>\r\n		<li>\r\n		<p>Tham quan Cầu k&iacute;nh Bạch Long (cầu k&iacute;nh d&agrave;i nhất thế giới) v&agrave; Đồi ch&egrave; Tr&aacute;i Tim.</p>\r\n		</li>\r\n		<li>\r\n		<p>Nghỉ đ&ecirc;m tại Bắc Y&ecirc;n.</p>\r\n		</li>\r\n	</ul>\r\n	</li>\r\n	<li>\r\n	<p><strong>Ng&agrave;y 2</strong>:</p>\r\n\r\n	<ul>\r\n		<li>\r\n		<p>S&aacute;ng sớm, di chuyển đến T&agrave; X&ugrave;a để săn m&acirc;y tại Sống Lưng Khủng Long.</p>\r\n		</li>\r\n		<li>\r\n		<p>Tự do chụp ảnh v&agrave; tận hưởng khung cảnh thi&ecirc;n nhi&ecirc;n h&ugrave;ng vĩ.</p>\r\n		</li>\r\n		<li>\r\n		<p>Trở về H&agrave; Nội, kết th&uacute;c h&agrave;nh tr&igrave;nh.</p>\r\n		</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n', 'Ô tô', 2, 'Hà Nội', 50, '2025-03-29', 10),
(102, 'Tour Tây Bắc số 1 Sapa – Lai Châu – Điện Biên – Mộc Châu – Mai Châu 5N4Đ', 'so1taybacjpg.jpg', 'Check-in với những tiểu cảnh \"xinh lung linh\" tại cảnh điểm Moana như: Cổng Trời Bali, Tượng Cô Gái Moana, Hồ Vô Cực, Bàn Tay Vàng, Xích Đu Tử Thần...\r\nChinh phục đỉnh Fansipan bằng cáp treo 3 dây tân tiến, hiện đại bậc nhất thế giới.\r\n\"Sống lại\" những phút giây hào hùng với những di tích lịch sử Điện Biên nổi tiếng: Hầm Đờ Cát, đồi A1...', '5,700,000', 6, '<ul>\r\n	<li>\r\n	<p><strong>Ng&agrave;y 1</strong>:</p>\r\n\r\n	<ul>\r\n		<li>\r\n		<p>Khởi h&agrave;nh từ H&agrave; Nội đến Sapa.</p>\r\n		</li>\r\n		<li>\r\n		<p>Tham quan Nh&agrave; thờ Đ&aacute; Sapa, bản C&aacute;t C&aacute;t, v&agrave; c&aacute;c tiểu cảnh tại Moana như Cổng Trời Bali, Hồ V&ocirc; Cực.</p>\r\n		</li>\r\n		<li>\r\n		<p>Nghỉ đ&ecirc;m tại Sapa.</p>\r\n		</li>\r\n	</ul>\r\n	</li>\r\n	<li>\r\n	<p><strong>Ng&agrave;y 2</strong>:</p>\r\n\r\n	<ul>\r\n		<li>\r\n		<p>Chinh phục đỉnh Fansipan bằng c&aacute;p treo.</p>\r\n		</li>\r\n		<li>\r\n		<p>Di chuyển đến Lai Ch&acirc;u, tham quan c&aacute;c điểm nổi bật như Tượng đ&agrave;i Th&agrave;nh phố Lai Ch&acirc;u.</p>\r\n		</li>\r\n		<li>\r\n		<p>Nghỉ đ&ecirc;m tại Lai Ch&acirc;u.</p>\r\n		</li>\r\n	</ul>\r\n	</li>\r\n	<li>\r\n	<p><strong>Ng&agrave;y 3</strong>:</p>\r\n\r\n	<ul>\r\n		<li>\r\n		<p>Tham quan Điện Bi&ecirc;n, c&aacute;c di t&iacute;ch lịch sử như Hầm Đờ C&aacute;t, Đồi A1, v&agrave; Tượng đ&agrave;i Chiến thắng Điện Bi&ecirc;n.</p>\r\n		</li>\r\n		<li>\r\n		<p>Nghỉ đ&ecirc;m tại Điện Bi&ecirc;n.</p>\r\n		</li>\r\n	</ul>\r\n	</li>\r\n	<li>\r\n	<p><strong>Ng&agrave;y 4</strong>:</p>\r\n\r\n	<ul>\r\n		<li>\r\n		<p>Di chuyển đến Mộc Ch&acirc;u, tham quan Cầu k&iacute;nh Bạch Long, Đồi ch&egrave; Tr&aacute;i Tim, v&agrave; Thung lũng mận N&agrave; Ka.</p>\r\n		</li>\r\n		<li>\r\n		<p>Nghỉ đ&ecirc;m tại Mộc Ch&acirc;u.</p>\r\n		</li>\r\n	</ul>\r\n	</li>\r\n	<li>\r\n	<p><strong>Ng&agrave;y 5</strong>:</p>\r\n\r\n	<ul>\r\n		<li>\r\n		<p>Kh&aacute;m ph&aacute; Mai Ch&acirc;u, tham quan c&aacute;c bản l&agrave;ng d&acirc;n tộc v&agrave; tận hưởng kh&ocirc;ng gian y&ecirc;n b&igrave;nh.</p>\r\n		</li>\r\n		<li>\r\n		<p>Trở về H&agrave; Nội, kết th&uacute;c h&agrave;nh tr&igrave;nh.</p>\r\n		</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n', 'Ô tô', 5, 'Hà Nội', 50, '2025-03-29', 10);

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
(1, 'user12', '$2a$10$VMLR4nWjBw866XsLmBR/weDrqrADipfrcT2HytPinssjYmrXLrMsW', 'Nguyen Van A', 'nguyenvana@example.com', 1, '0123456789', 'Hanoi', 'Admin');

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
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

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
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=103;

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
