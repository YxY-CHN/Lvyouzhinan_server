-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- 主机： db
-- 生成日期： 2019-06-23 08:37:43
-- 服务器版本： 5.7.25
-- PHP 版本： 7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 数据库： `lvyouzhinan`
--

-- --------------------------------------------------------

--
-- 表的结构 `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- 转存表中的数据 `admin`
--

INSERT INTO `admin` (`id`, `name`, `password`) VALUES
(1, 'admin', 'admin');

-- --------------------------------------------------------

--
-- 表的结构 `article`
--

CREATE TABLE `article` (
  `id` int(11) NOT NULL,
  `title` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `area` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `image` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `content` varchar(1000) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- 转存表中的数据 `article`
--

INSERT INTO `article` (`id`, `title`, `area`, `image`, `content`) VALUES
(18, '鼓浪屿', '厦门', 'http://lvyouzhinan.oss-cn-hangzhou.aliyuncs.com/0ed962a3-49f3-42d3-b44e-3a5b19cad149.png', '鼓浪屿（英文：Kulangsu）原名“圆沙洲”，别名“圆洲仔”，南宋时期命“五龙屿”，明朝改称“鼓浪屿”。因岛西南方海滩上有一块两米多高、中有洞穴的礁石，每当涨潮水涌，浪击礁石，声似擂鼓，人们称“鼓浪石”，鼓浪屿因此而得名。鼓浪屿街道短小，纵横交错，是厦门最大的一个屿，与厦门岛上的厦门世茂海峡大厦、厦门大学等隔海相望。'),
(19, '厦门方特梦幻王国', '厦门', 'http://lvyouzhinan.oss-cn-hangzhou.aliyuncs.com/6eb6340f-fd2f-4fdb-9ede-37662d0b89ef.png', '厦门方特梦幻王国，是一个以高科技为主要表现形式的文化科技主题公园。坐落于美丽的海滨古城厦门●同安，是由深圳华强集团投资巨额兴建的大型高科技第四代主题公园。其最大特点是以科幻和互动体验为最大特色，将动漫卡通、电影特技等国际时尚娱乐元素与中国传统文化符号巧妙融合，创造出充满幻想和创意的神奇天地，被誉为“东方梦幻乐园”、“亚洲科幻神奇”。'),
(20, '云水谣', '漳州', 'http://lvyouzhinan.oss-cn-hangzhou.aliyuncs.com/db0a7b10-5ce0-4dcb-8452-b1983a5c3d3f.png', '云水谣，“南靖云水谣”原名长教，位于漳州市南靖县境内，属于世界文化遗产“福建土楼”的一个景区，国家5A级。那里山川秀美、人文丰富。村中幽长古道、百年老榕、神奇土楼，还有那灵山碧水，无不给人以超然的感觉。 2005年底，由张克辉以自己和几位台胞的生活阅历为原型创作的电影文学剧本《寻找》改编的电影《云水谣》，曾经在此拍摄取景。'),
(21, '风动石', '漳州', 'http://lvyouzhinan.oss-cn-hangzhou.aliyuncs.com/2a43da5a-4707-4b46-b873-5209d5d50e50.png', '东山风动石位于福建省漳州市东山岛，以奇、险、悬而居全国60多块风动石之最，被誉为“天下第一奇石”。它是东山岛的标志性景观。东山风动石景区是国家4A级景区，福建省首批省级风景名胜区之一。其中东山风动石在漳州市东山县铜陵镇东南隅岣嵝山东麓，塔屿在铜陵镇东侧。以风动石为中心，加上铜山古城、塔屿和西面的九仙顶、南面的马銮湾，构成独特完整的旅游景区。');

-- --------------------------------------------------------

--
-- 表的结构 `comment`
--

CREATE TABLE `comment` (
  `id` int(11) NOT NULL,
  `message` varchar(80) COLLATE utf8mb4_unicode_ci NOT NULL,
  `article_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- 转存表中的数据 `comment`
--

INSERT INTO `comment` (`id`, `message`, `article_id`) VALUES
(5, '鼓浪屿第二次去', 18),
(6, '还不错', 18),
(7, '票价学生有优惠', 19),
(8, '有点远，坐车比较方便', 19),
(9, '风土人情', 20),
(10, '可以顺便去看看土楼', 20),
(11, '东山著名风景区', 21),
(12, '下星期准备过去玩一玩', 21),
(13, '那里卖的都挺贵的！', 22),
(14, '福州人都知道的地方，挺繁华的啊！', 22),
(17, '测试手机', 18),
(18, '继续测试', 18),
(19, '还有吗', 18),
(22, '测试手机', 22),
(23, '这个地方很好玩！', 20);

-- --------------------------------------------------------

--
-- 表的结构 `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `phone` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- 转储表的索引
--

--
-- 表的索引 `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- 表的索引 `article`
--
ALTER TABLE `article`
  ADD PRIMARY KEY (`id`);

--
-- 表的索引 `comment`
--
ALTER TABLE `comment`
  ADD PRIMARY KEY (`id`);

--
-- 表的索引 `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- 使用表AUTO_INCREMENT `article`
--
ALTER TABLE `article`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- 使用表AUTO_INCREMENT `comment`
--
ALTER TABLE `comment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- 使用表AUTO_INCREMENT `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
