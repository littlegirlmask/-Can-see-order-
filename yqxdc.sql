-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.6.26 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win32
-- HeidiSQL 版本:                  9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 yqxdc 的数据库结构
CREATE DATABASE IF NOT EXISTS `yqxdc` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;
USE `yqxdc`;

-- 导出  表 yqxdc.cusorders 结构
CREATE TABLE IF NOT EXISTS `cusorders` (
  `ORDERID` varchar(50) COLLATE utf8_bin NOT NULL,
  `CUSID` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `ORDERTIME` datetime DEFAULT NULL,
  `ORDERSTATE` int(11) DEFAULT NULL COMMENT '0--临时\r\n            1--下单\r\n            2--正在处理\r\n            3--处理完成',
  `ORDERTOTLEPRICE` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`ORDERID`),
  KEY `FK_Relationship_5` (`CUSID`),
  CONSTRAINT `FK_Relationship_5` FOREIGN KEY (`CUSID`) REFERENCES `customer` (`CUSID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 正在导出表  yqxdc.cusorders 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `cusorders` DISABLE KEYS */;
INSERT INTO `cusorders` (`ORDERID`, `CUSID`, `ORDERTIME`, `ORDERSTATE`, `ORDERTOTLEPRICE`) VALUES
	('5394916c-5010-4b05-b76d-c5112f262c38', 'd2f6f3a4-c305-4dbe-b29f-53af2bb787c1', '2019-06-28 12:28:54', 3, 154.00),
	('81d5ea24-a4f7-489e-a370-6baa9dbd3c1c', 'd2f6f3a4-c305-4dbe-b29f-53af2bb787c1', '2020-03-12 14:42:26', 0, 126.00),
	('d1386265-40b8-41aa-b0c6-8939a28aaeb8', 'd2f6f3a4-c305-4dbe-b29f-53af2bb787c1', '2019-06-28 12:28:26', 0, 65.00);
/*!40000 ALTER TABLE `cusorders` ENABLE KEYS */;

-- 导出  表 yqxdc.customer 结构
CREATE TABLE IF NOT EXISTS `customer` (
  `CUSID` varchar(50) COLLATE utf8_bin NOT NULL,
  `OPENID` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `NICKNAME` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`CUSID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 正在导出表  yqxdc.customer 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` (`CUSID`, `OPENID`, `NICKNAME`) VALUES
	('4d97d513-8c71-48d8-8036-cb81cce62809', 'o3ODm5RqzZiBjhzbO9_f8JcbiX1Q', 'x.'),
	('d2f6f3a4-c305-4dbe-b29f-53af2bb787c1', 'o3ODm5Z5JPFXgqSdBrFNE6d8nDi0', '小丫头');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;

-- 导出  表 yqxdc.goods 结构
CREATE TABLE IF NOT EXISTS `goods` (
  `GID` varchar(50) COLLATE utf8_bin NOT NULL,
  `GTID` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `GNAME` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `GPRICE` decimal(10,2) DEFAULT NULL,
  `GSTATE` int(11) DEFAULT NULL,
  `GCONTENT` text COLLATE utf8_bin,
  `GIMG` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `GTIME` int(11) DEFAULT NULL COMMENT '需要时间（单位：分钟）',
  PRIMARY KEY (`GID`),
  KEY `FK_Relationship_4` (`GTID`),
  CONSTRAINT `FK_Relationship_4` FOREIGN KEY (`GTID`) REFERENCES `goodstype` (`GTID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 正在导出表  yqxdc.goods 的数据：~32 rows (大约)
/*!40000 ALTER TABLE `goods` DISABLE KEYS */;
INSERT INTO `goods` (`GID`, `GTID`, `GNAME`, `GPRICE`, `GSTATE`, `GCONTENT`, `GIMG`, `GTIME`) VALUES
	('1e39484a-652e-48e8-ba65-610b52e9eaa0', '260e41c8-1fb6-452a-bfc7-3bd0538c34d8', '龙虾汤泡饭', 188.00, 1, '龙虾 饭\\r\\n 用一整只波士顿龙虾做一份汤泡饭', 'c24fe236-ae01-4437-9dc6-ad01e0d792e2.jpg', 16),
	('2782f387-d410-4511-bf42-2b310c989cff', '91112970-9e3c-491b-bfc7-66f1f0b2747a', '年糕红豆沙', 32.00, 1, '红豆生南国，春来发几枝。愿君多采撷，此物最相思。甜甜的红豆沙，要和甜甜的她一起吃。', '417e50dd-dba1-4cfe-800d-e47724248174.jpg', 12),
	('2ca94853-d0eb-454e-b8ee-7d369771127c', '260e41c8-1fb6-452a-bfc7-3bd0538c34d8', '百万牛肉饭', 188.00, 1, '牛肉 饭\\r\\n 菲力中断低温煎烤，搭配蒜蓉辣椒酱，一层一层跌出来的百万牛肉饭。', 'f8b75eec-5488-4b07-b7b9-64ca5f0a81f2.jpg', 16),
	('34cca8e6-4abb-46a5-829d-2e93365b9072', 'f9afd9e2-74d5-483f-a04a-1154e2f33867', '芝士可乐饼', 29.00, 1, '"芝士\\r\\n 老板，来一份芝士可乐饼，要爆爆爆浆的！！！\r\n可乐饼有很多人做过，但是你见过会爆浆会拉丝的吗？芝士+蛋黄酱的组合绝对能让你重新认识可乐饼"', '400251a5-454a-4619-a959-fdb281ac104f.jpg', 10),
	('3d0738f1-6e6e-4b20-9721-26c34fa782ef', '8bcd3b47-d537-49c9-8338-7821fe2a8431', '翻转苹果塔', 68.00, 1, '原版是博古斯餐厅的整个苹果塔，此为改良版：底消化饼干和夏天冰淇淋版本， 搭配金箔有没有觉得很高大上了呢？', '61f5c378-32e0-458c-90ea-009a3a8847cf.jpg', 16),
	('3f4f886a-52d0-4555-b1a0-6de69518f222', 'f9afd9e2-74d5-483f-a04a-1154e2f33867', '燕麦蛋白棒', 36.00, 1, '健康\\r\\n这个燕麦棒的营养元素很丰富，油脂用了杏仁和椰子油，是很健康也利于减肥的，甜味的部分主要是燕麦中的果干和枫糖，相对来说也已经非常健康了。', '258720ed-624e-4f0f-bdc4-dc0d64c01d4f.jpg', 12),
	('3f743cc2-452b-445f-8a7c-c48b99948076', 'f9afd9e2-74d5-483f-a04a-1154e2f33867', '脆皮炸鲜奶', 28.00, 1, '炸鲜奶\\r\\n这块脆皮炸鲜奶嫩起来不要脸，就知道Duangduangduang~', 'f2e822b1-a13f-49b9-8e80-387bebbc69de.jpg', 12),
	('3ffa3a1b-5592-4edd-a6c0-82d6fc0636ea', '8bcd3b47-d537-49c9-8338-7821fe2a8431', '焦糖布丁', 58.00, 1, '采用水浴的方式蒸煮，质感非常好，口感丝滑。', '4d09d409-06dd-46f7-8bfb-ff7352d29c7d.jpg', 10),
	('440e51e1-be4d-497c-82e4-434069832bc0', '260e41c8-1fb6-452a-bfc7-3bd0538c34d8', '虾仁番茄滑蛋', 68.00, 1, '虾仁 蛋\\r\\n 高配版番茄炒蛋，番茄炒蛋注入虾仁，真的是超级好吃！', '24c4a0a1-79f8-4d8e-8da0-ce54c95cb903.jpg', 5),
	('454dcbe9-6e18-459c-b5b9-9b71edde0e98', '260e41c8-1fb6-452a-bfc7-3bd0538c34d8', '鲜椒酸汤肥牛', 128.00, 1, '肥牛 酸辣\\r\\n肥牛加蔬菜的组合完全满足你的味蕾，加入了海南黄灯笼辣椒酱，辣味十足', 'e7414826-6a73-4c7b-89bb-4391dbc92ad6.jpg', 12),
	('4a50451a-10da-4138-bd9e-b076eec94767', '260e41c8-1fb6-452a-bfc7-3bd0538c34d8', '茄汁大虾', 88.00, 1, '虾\\r\\n 酸酸甜甜就是我', '7ce47f38-b435-406b-8239-62d437e4bcf2.jpg', 18),
	('5462510c-0bbb-439b-a730-9c770d348391', '260e41c8-1fb6-452a-bfc7-3bd0538c34d8', '培根芝士蛋奶意面', 68.00, 1, '芝士 意面\\r\\n 选用帕玛森芝士碎搭配鸡蛋蛋奶，喜欢培根、芝士的朋友一定要尝试一下。', '68ab7c79-24f2-4373-8311-9f23db852e6c.jpg', 12),
	('6b975040-5a64-438a-bab1-0cd9d19f178b', '260e41c8-1fb6-452a-bfc7-3bd0538c34d8', '湖州羊肉面', 68.00, 1, '羊肉 面\\r\\n 适合冬日食用，搭配干挑面，希望您喜欢。', '5a1f03e7-7c17-4e98-aac9-1598397274f5.jpg', 8),
	('7958320e-8228-44c8-8186-14a83f5d5ab6', '260e41c8-1fb6-452a-bfc7-3bd0538c34d8', '熟牛肉石锅拌饭', 88.00, 1, '牛肉 拌饭\\r\\n 请回答1988之正焕家最爱的韩式辣牛肉石锅拌饭', '57c4dfde-7c53-462e-9a32-9746068d1791.jpg', 18),
	('7e4fe44b-760d-41af-a6ee-6ca12c2db9ac', '91112970-9e3c-491b-bfc7-66f1f0b2747a', '冰粉', 28.00, 1, '多种水果丁与冰粉的层层叠加，一定会让你感觉碰撞除了不一样的火花。', '178a6481-dd38-419d-bbb8-2f214f433ea8.jpg', 8),
	('853e6255-ec79-4f64-b9a2-3682d8be7dcc', 'f9afd9e2-74d5-483f-a04a-1154e2f33867', '麻辣牛肉干', 48.00, 1, '牛肉\\r\\n 选用精牛肉煮熟，切条后滚油，裹上酱汁辣椒花椒等香料炮制，牦牛肉干就做出来了～', '70dc5e2d-fe47-49e8-a0b9-fa0b2117e920.jpg', 5),
	('868d07b3-cd4b-4dc2-a82c-edc35802da47', '260e41c8-1fb6-452a-bfc7-3bd0538c34d8', '油爆虾', 168.00, 1, '虾\\r\\n 选用沼虾，油炸后的虾壳酥脆十足，一口一只，省事好吃还补钙', '061f0705-9060-4042-8b71-0aae32d082c0.jpg', 10),
	('8caed7d6-f9b9-4505-945a-023160b5e23c', '260e41c8-1fb6-452a-bfc7-3bd0538c34d8', '辣牛五方芝士max版', 88.00, 1, '牛肉 芝士 饭\\r\\n 热量警告，芝士警告，牛肉警告，会拉丝的嫩牛五方来啦！', '2ae05bb9-5d01-4941-8e20-a88d34766db2.jpg', 18),
	('8ef33ebd-5b87-42dc-8072-2364dd870463', '91112970-9e3c-491b-bfc7-66f1f0b2747a', '抹茶红豆年糕汤', 38.00, 1, '炎炎夏日，来一碗抹茶红豆年糕汤，透心凉，甜进心~', 'c8ce4880-301d-4eb3-a333-97495a21cd47.jpg', 16),
	('98543188-0510-4610-bcf6-9078e33f3fdf', '91112970-9e3c-491b-bfc7-66f1f0b2747a', '白玉抹茶丸子刨冰', 32.00, 1, '抹茶 丸子\\r\\n 超级解暑的白玉抹茶丸子刨冰，冰到你的心里去。', '6820e8be-5e78-43cd-ba2b-65be6ec9e10f.jpg', 15),
	('a4244212-95b3-45ce-bdd6-a6d993291c3a', '91112970-9e3c-491b-bfc7-66f1f0b2747a', '红薯芋圆糖水', 29.00, 1, '红薯香甜，芋圆Q弹，你要来一碗甜甜的红薯芋圆糖水吗？', '16cd6a63-da1c-4b5d-a1c7-15d44755042f.jpg', 15),
	('b0929d49-5549-44ff-a12c-01c1ca224fe9', '91112970-9e3c-491b-bfc7-66f1f0b2747a', '热巧克力奶盖', 36.00, 1, '热巧克力+海盐奶盖，让你感到秋裤般的温暖！奶盖轻盈口感细腻。', '8f2c4af7-c4c1-4760-b889-cfa3108d5704.jpg', 12),
	('b0e88052-f83a-4283-bb7b-8c787ee27807', '260e41c8-1fb6-452a-bfc7-3bd0538c34d8', '照烧猪梅花配温泉蛋盖饭', 68.00, 1, '猪梅花 照烧酱 饭\\r\\n 照烧酱搭配生姜猪肉，再来一个温泉蛋简直完美。', 'e270f742-60a1-4be6-a37b-16330bf0a6e0.jpg', 18),
	('bacb0dfe-0983-4c5e-8236-e28da0c13b23', '260e41c8-1fb6-452a-bfc7-3bd0538c34d8', '芝士年糕爆辣鸡', 89.00, 1, '芝士 辣\\r\\n 鸡腿两根，秘制酱料腌制，泰式辣椒面与二荆条辣椒面红油的完美结合。搭配年糕、芝士，满足你对食物的一切幻想，得劲！', '0e9c1c2a-f3a0-4b52-9b2a-bd2c50f811a9.jpg', 12),
	('bdeb5d8d-84cd-46ba-ae50-7ff3c6abe081', '260e41c8-1fb6-452a-bfc7-3bd0538c34d8', '手抓羊肉饭', 78.00, 1, '羊肉 饭\\r\\n 超多汁的手抓羊肉饭，米饭粒粒分开，饱满可口。搭配蔬菜：胡萝卜、洋葱等。', 'c57655e1-49d5-4510-86cd-10874b8a1ba3.jpg', 16),
	('c875e8e7-46b4-4899-9f80-f189720ae3d5', '260e41c8-1fb6-452a-bfc7-3bd0538c34d8', '凤尾虾天使意面', 99.00, 1, '虾 意面\\r\\n 大虾的鲜甜味，朝天椒的辣味，柠檬的酸味，大蒜的蒜香味，还有一些帕玛森芝士和黄油的奶香味，希望让你更有食欲，味蕾大开！', '1101ec42-3d9d-479c-aa88-932be4345f93.jpg', 12),
	('c88c3d44-280c-4d24-befa-d38d17d47b18', '260e41c8-1fb6-452a-bfc7-3bd0538c34d8', '荔枝肉', 88.00, 1, '"梅头肉 荔枝\\r\\n 真的有荔枝的荔枝肉。水果入菜，酸甜口味，清爽可口。肉类选用梅头肉，脂肪分布\r\n均匀，口感爽脆。"', '9161a729-a417-4bd0-9b29-f683ff656128.jpg', 10),
	('ca9a9f2a-0b8f-424e-9541-9760dfdeae10', '8bcd3b47-d537-49c9-8338-7821fe2a8431', '抹茶牛奶小方', 28.00, 1, '抹茶 牛奶\\r\\n抹茶与牛奶小方的结合，一点都不腻哟~', '052ed646-8fee-46af-94b5-06a6bf1dc74a.jpg', 15),
	('d92e1c9c-81a2-47e8-af22-2fac03de550d', '8bcd3b47-d537-49c9-8338-7821fe2a8431', '提拉米苏', 48.00, 1, '不含吉利丁的提拉米苏，炸弹面糊版本，超级健康。', '5110a499-de9f-4d85-ad21-7e4bd8a8991c.jpg', 12),
	('e979698a-fb80-47ac-bd88-81465bf0d1e1', '260e41c8-1fb6-452a-bfc7-3bd0538c34d8', '麻辣小龙虾盖饭', 168.00, 1, '虾 饭\\r\\n 完美虾肉，麻辣鲜香。愿意为你剥虾的人一定都是真爱，比如我呀！', '2fadee87-7531-47d9-bf8d-31bdb8fa36da.jpg', 16),
	('f2f211de-e67a-492d-8c7b-a3c80b40cfd1', '8bcd3b47-d537-49c9-8338-7821fe2a8431', '樱花椰汁冻', 58.00, 1, '超级弹弹弹的椰汁冻冻，见不到樱花的同学们，就吃一朵吧~', '4d8b1399-ec2a-4546-8906-af88c4a70a6b.jpg', 12),
	('f9453a28-3880-4909-89dd-133fb1db95f6', '8bcd3b47-d537-49c9-8338-7821fe2a8431', '快乐肥宅圈', 36.00, 1, '巧克力甜甜圈，甜食真的是能增添幸福感的食物，加上油炸真的就是人人爱吃了~', 'f56f2d5c-be39-4c22-ba18-e64c2f1051df.jpg', 8);
/*!40000 ALTER TABLE `goods` ENABLE KEYS */;

-- 导出  表 yqxdc.goodstype 结构
CREATE TABLE IF NOT EXISTS `goodstype` (
  `GTID` varchar(50) COLLATE utf8_bin NOT NULL,
  `GTNAME` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `GTSTATE` int(11) DEFAULT NULL,
  PRIMARY KEY (`GTID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 正在导出表  yqxdc.goodstype 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `goodstype` DISABLE KEYS */;
INSERT INTO `goodstype` (`GTID`, `GTNAME`, `GTSTATE`) VALUES
	('260e41c8-1fb6-452a-bfc7-3bd0538c34d8', '主食', 1),
	('8bcd3b47-d537-49c9-8338-7821fe2a8431', '甜点', 1),
	('91112970-9e3c-491b-bfc7-66f1f0b2747a', '饮品', 1),
	('f9afd9e2-74d5-483f-a04a-1154e2f33867', '小吃', 1);
/*!40000 ALTER TABLE `goodstype` ENABLE KEYS */;

-- 导出  表 yqxdc.orderdetail 结构
CREATE TABLE IF NOT EXISTS `orderdetail` (
  `GID` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `ORDERID` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `ODID` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `ODPRICE` decimal(10,2) DEFAULT NULL,
  `ODCOUNT` decimal(10,2) DEFAULT NULL,
  KEY `FK_Relationship_6` (`ORDERID`),
  KEY `FK_Relationship_7` (`GID`),
  CONSTRAINT `FK_Relationship_6` FOREIGN KEY (`ORDERID`) REFERENCES `cusorders` (`ORDERID`),
  CONSTRAINT `FK_Relationship_7` FOREIGN KEY (`GID`) REFERENCES `goods` (`GID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 正在导出表  yqxdc.orderdetail 的数据：~7 rows (大约)
/*!40000 ALTER TABLE `orderdetail` DISABLE KEYS */;
INSERT INTO `orderdetail` (`GID`, `ORDERID`, `ODID`, `ODPRICE`, `ODCOUNT`) VALUES
	('34cca8e6-4abb-46a5-829d-2e93365b9072', 'd1386265-40b8-41aa-b0c6-8939a28aaeb8', 'd8a9c25b-7649-4ed3-ba63-36914763dde6', 29.00, 1.00),
	('3f4f886a-52d0-4555-b1a0-6de69518f222', 'd1386265-40b8-41aa-b0c6-8939a28aaeb8', '24eece41-da4f-483d-b902-b9b8942afdc5', 36.00, 1.00),
	('3d0738f1-6e6e-4b20-9721-26c34fa782ef', '5394916c-5010-4b05-b76d-c5112f262c38', 'bb0d78a4-e91b-4c2a-b853-fa08aa3cf435', 68.00, 1.00),
	('3ffa3a1b-5592-4edd-a6c0-82d6fc0636ea', '5394916c-5010-4b05-b76d-c5112f262c38', '614f4294-afc9-4d87-bc19-47736ed87a7e', 58.00, 1.00),
	('ca9a9f2a-0b8f-424e-9541-9760dfdeae10', '5394916c-5010-4b05-b76d-c5112f262c38', 'f113218e-8424-40ff-850d-877d33e966b6', 28.00, 1.00),
	('3d0738f1-6e6e-4b20-9721-26c34fa782ef', '81d5ea24-a4f7-489e-a370-6baa9dbd3c1c', '8dcdb345-4762-442a-9894-b81213b738ae', 68.00, 1.00),
	('3ffa3a1b-5592-4edd-a6c0-82d6fc0636ea', '81d5ea24-a4f7-489e-a370-6baa9dbd3c1c', '39fb5b56-d922-4122-8170-6da856ccb9a8', 58.00, 1.00);
/*!40000 ALTER TABLE `orderdetail` ENABLE KEYS */;

-- 导出  表 yqxdc.roleright 结构
CREATE TABLE IF NOT EXISTS `roleright` (
  `RRID` varchar(50) COLLATE utf8_bin NOT NULL,
  `ROLEID` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `FUNID` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`RRID`),
  KEY `FK_Relationship_1` (`ROLEID`),
  KEY `FK_Relationship_2` (`FUNID`),
  CONSTRAINT `FK_Relationship_1` FOREIGN KEY (`ROLEID`) REFERENCES `sysrole` (`ROLEID`),
  CONSTRAINT `FK_Relationship_2` FOREIGN KEY (`FUNID`) REFERENCES `sysfunction` (`FUNID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 正在导出表  yqxdc.roleright 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `roleright` DISABLE KEYS */;
/*!40000 ALTER TABLE `roleright` ENABLE KEYS */;

-- 导出  表 yqxdc.sysfunction 结构
CREATE TABLE IF NOT EXISTS `sysfunction` (
  `FUNID` varchar(50) COLLATE utf8_bin NOT NULL,
  `FUNNAME` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `FUNPID` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `FUNURL` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `FUNSTATE` int(11) DEFAULT NULL,
  PRIMARY KEY (`FUNID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 正在导出表  yqxdc.sysfunction 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `sysfunction` DISABLE KEYS */;
/*!40000 ALTER TABLE `sysfunction` ENABLE KEYS */;

-- 导出  表 yqxdc.sysrole 结构
CREATE TABLE IF NOT EXISTS `sysrole` (
  `ROLEID` varchar(50) COLLATE utf8_bin NOT NULL,
  `ROLENAME` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `ROLESTATE` int(11) DEFAULT NULL,
  PRIMARY KEY (`ROLEID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 正在导出表  yqxdc.sysrole 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `sysrole` DISABLE KEYS */;
INSERT INTO `sysrole` (`ROLEID`, `ROLENAME`, `ROLESTATE`) VALUES
	('047450dd-7b56-4ad4-b733-bbbbf1c94f0e', '用户', 1),
	('2318d1a6-8863-44a0-918f-e654d64639bf', '测试', 1),
	('95460ae5-16a0-47af-9117-2d01d1df5137', '管理员', 1);
/*!40000 ALTER TABLE `sysrole` ENABLE KEYS */;

-- 导出  表 yqxdc.sysuser 结构
CREATE TABLE IF NOT EXISTS `sysuser` (
  `USERID` varchar(50) COLLATE utf8_bin NOT NULL,
  `ROLEID` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `USERNAME` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `USERPWD` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `USERSEX` char(2) COLLATE utf8_bin DEFAULT NULL,
  `USERTRUENAME` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `USERSTATE` int(11) DEFAULT NULL,
  PRIMARY KEY (`USERID`),
  KEY `FK_Relationship_3` (`ROLEID`),
  CONSTRAINT `FK_Relationship_3` FOREIGN KEY (`ROLEID`) REFERENCES `sysrole` (`ROLEID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 正在导出表  yqxdc.sysuser 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `sysuser` DISABLE KEYS */;
INSERT INTO `sysuser` (`USERID`, `ROLEID`, `USERNAME`, `USERPWD`, `USERSEX`, `USERTRUENAME`, `USERSTATE`) VALUES
	('15d38204-7b3c-4647-a27b-08fe50bd7006', '047450dd-7b56-4ad4-b733-bbbbf1c94f0e', '阿瑾', 'ajin', '0', '阿瑾', 1),
	('5708911e-e9b9-4eb3-a863-b7ba2babaf1a', '95460ae5-16a0-47af-9117-2d01d1df5137', '乔乔', 'qiaoqiao', '0', '乔乔', 1),
	('ee23933f-b840-4120-8711-cd9d45ececd4', '047450dd-7b56-4ad4-b733-bbbbf1c94f0e', '崽崽', 'zaizai', '1', '崽崽', 1);
/*!40000 ALTER TABLE `sysuser` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
