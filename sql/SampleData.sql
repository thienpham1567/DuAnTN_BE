// Brands
insert into [Brands](Name) values('Nike'),('Puma'),('Addidas');
// Categories
insert into [Categories](Name) values('Men'),('Women'),('Kid');
insert into [Categories](ParentCategoryId,Name) values(3,'Out Door'),(1,'Football'),(2,'Running'),(1,'Running'),(3,'Running');
// Colors
insert into [Colors](Value) values('Pink'),('White'),('Gray'),('Blue'),('Red'),('Green'),('Black'),('Orange'),('Yellow'),('Brown'),('Purple');
// Sizes
insert into [Sizes](CategoryId,Value) values(3,'3'),(3,'3.5'),(3,'4'),(3,'4.5'),(3,'5'),(3,'5.5'),(3,'6'),(3,'6.5');
insert into [Sizes](CategoryId,Value) values(1,'7'),(1,'7.5'),(1,'8'),(1,'8.5'),(1,'9'),(1,'9.5'),(1,'10'),(1,'10.5'),(1,'11'),(1,'11.5'),(1,'12'),(1,'12.5'),(1,'13');
// Roles
insert into Roles(Description,Code) values('Admin','AD'),('User','USER'),('Customer','CUSTOMER');

// Addidas
insert into Products(BrandId,CategoryId,Name)
values
-- man
(3,5,'X SPEEDPORTAL.1 FIRM GROUND BOOTS'),
(3,5,'PREDATOR ACCURACY.1 LOW FIRM GROUND BOOTS'),
(3,5,'X SPEEDPORTAL.3 FIRM GROUND BOOTS'),
(3,5,'X SPEEDPORTAL.3 LACELESS FIRM GROUND BOOTS'),
(3,5,'X SPEEDPORTAL.2 FIRM GROUND BOOTS'),
--woman
(3,6,'SOLARGLIDE 6 SHOES'),
(3,6,'SUPERNOVA GORE-TEX SHOES'),
(3,6,'RUNFALCON 3.0 SHOES'),
(3,6,'ULTRABOOST LIGHT SHOES'),
(3,6,'ADIDAS ADIZERO SL RUNNING SHOES'),
--kid
(3,4,'TERREX TRAILMAKER HIKING SHOES'),
(3,4,'TERREX X LEGO® CAPTAIN TOEY SANDALS'),
(3,4,'TERREX TRAILMAKER MID RAIN.RDY HIKING SHOES'),
(3,4,'TERREX GORE-TEX HIKING SHOES'),
(3,4,'TERREX CAPTAIN TOEY 2.0 SANDALS')

// Puma
insert into [Products](BrandId,CategoryId,Name)
values(2,7,'Fast-Trac NITRO Men is Running Shoes'),
(2,7,'Voyage NITRO 2 Men is Running Shoes'),
(2,7,'Velocity NITRO 2 Men is Running Shoes'),
(2,7,'Magnify NITRO Surge Men is Running Shoes'),
(2,7,'PUMA x FIRST MILE Velocity NITRO 2 Men is Running Shoes'),
(2,6,'Softride Sophia Slip-on Women is Running Shoes'),
(2,6,'ForeverRUN NITRO Women is Running Shoes'),
(2,6,'PUMA x MAGGIE STEPHENSON Run XX NITRO Women is Running Shoes'),
(2,6,'Run XX Nitro Women is Running Shoes'),
(2,6,'Liberate NITRO Women is Running Shoes'),
(2,8,'PUMA x SPONGEBOB Little Kids Slipstream Sneakers'),
(2,8,'Suede Camowave Big Kids Sneakers'),
(2,8,'Softride Slide Sandals Big Kids'),
(2,8,'CA Pro Block Toddlers Shoes'),
(2,8,'PUMA x TINY COTTONS CA Pro Printed Little Kids Shoes');

// Nike
insert into [Products](BrandId,CategoryID,Name)
values
(1,7,'Nike Winflo 10'),
(1,7,'Nike React Miler 3'),
(1,7,'Nike Pegasus FlyEase'),
(1,7,'Nike Run Swift 3'),
(1,7,'Nike Pegasus Trail 4 By You'),
(1,6,'Nike Pegasus Turbo Next Nature'),
(1,6,'Nike Alphafly 2'),
(1,6,'Nike Zegama'),
(1,6,'Nike Escape Run 2'),
(1,6,'Nike Serenity Run 2'),
(1,8,'Nike Dynamo Go'),
(1,8,'Nike Air Max 270 GO'),
(1,8,'Nike Court Borough Low 2'),
(1,8,'Jordan Flare'),
(1,8,'Jordan 23/7');


insert into ProductItems(ProductId,ColorId,SizeId,Price,QuantityInStock,ImageUrl,Status)
values
-- 1
(1,1,8,250,12,'https://assets.adidas.com/images/w_600,f_auto,q_auto/43cd81b709e145e28406af730070d692_9366/X_Speedportal.1_Firm_Ground_Boots_Pink_GZ5108_22_model.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/e9be48c1d637479f85fcaf730067aca3_9366/X_Speedportal.1_Firm_Ground_Boots_Pink_GZ5108_01_standard_hover.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/b6e6153710114ac5b384af730067cea3_9366/X_Speedportal.1_Firm_Ground_Boots_Pink_GZ5108_02_standard.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/4d90661a75004dfabf79af730067e6e2_9366/X_Speedportal.1_Firm_Ground_Boots_Pink_GZ5108_03_standard.jpg
','Active'),
(1,2,8,256,19,'https://assets.adidas.com/images/w_600,f_auto,q_auto/b78b57e1158841fe805eaf730070bedd_9366/X_Speedportal.1_Firm_Ground_Boots_White_GZ5104_22_model.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/4f2297bd187b466d854caf7300674e85_9366/X_Speedportal.1_Firm_Ground_Boots_White_GZ5104_01_standard_hover.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/4c35e37c617c4d81a127af7300676be6_9366/X_Speedportal.1_Firm_Ground_Boots_White_GZ5104_02_standard.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/9668bf413c7040319f92af73006774a5_9366/X_Speedportal.1_Firm_Ground_Boots_White_GZ5104_03_standard.jpg
','Active'),
--2
(2,1,9,190,13,'https://assets.adidas.com/images/w_600,f_auto,q_auto/1c2e3df8b51a4d07b855af8c00f78692_9366/Predator_Accuracy.1_Low_Firm_Ground_Boots_Black_GW4577_22_model.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/9db73656697a4adb810eaf8c00f737cb_9366/Predator_Accuracy.1_Low_Firm_Ground_Boots_Black_GW4577_02_standard.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/94a0de699f7843e2b4eeaf8c00f74d3e_9366/Predator_Accuracy.1_Low_Firm_Ground_Boots_Black_GW4577_04_standard.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/0ac0425a5fe843d9b000af8c00f757a3_9366/Predator_Accuracy.1_Low_Firm_Ground_Boots_Black_GW4577_05_standard.jpg
','Active'),
(2,2,9,176,11,'https://assets.adidas.com/images/w_600,f_auto,q_auto/2ec0022918df43d295b9af5d011522c2_9366/Predator_Accuracy.1_Low_Firm_Ground_Boots_White_GW4576_22_model.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/5efc85857d6f48ad80a7af7100a7106e_9366/Predator_Accuracy.1_Low_Firm_Ground_Boots_White_GW4576_02_standard.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/1246efbd9f1f4f38b936af7100a719dc_9366/Predator_Accuracy.1_Low_Firm_Ground_Boots_White_GW4576_03_standard.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/edea42afdd514b6cb4d0af7100a72346_9366/Predator_Accuracy.1_Low_Firm_Ground_Boots_White_GW4576_04_standard.jpg
','Active'),
-- 3
(3,2,12,200,7,'https://assets.adidas.com/images/w_600,f_auto,q_auto/465b6f1c772b43c8a972af8c00f61d96_9366/X_Speedportal.1_Firm_Ground_Boots_Blue_FZ6289_22_model.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/91d61a02af3548068fd6af8c00f5d749_9366/X_Speedportal.1_Firm_Ground_Boots_Blue_FZ6289_01_standard_hover.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/465ff51596614d74b436af8c00f5e75f_9366/X_Speedportal.1_Firm_Ground_Boots_Blue_FZ6289_02_standard.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/6bd1a3d2d8504fa79bb2af8c00f5f059_9366/X_Speedportal.1_Firm_Ground_Boots_Blue_FZ6289_03_standard.jpg
','Active'),
(3,2,12,188,7,'https://assets.adidas.com/images/w_600,f_auto,q_auto/0951c06c0d7342e8ac2daf8c00f5cf9f_9366/X_Speedportal_Firm_Ground_Boots_Blue_FZ6288_22_model.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/76c9965e8adb4b049287af8c00f57c0a_9366/X_Speedportal_Firm_Ground_Boots_Blue_FZ6288_01_standard_hover.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/80d09fae17744f9f8439af8c00f58ce2_9366/X_Speedportal_Firm_Ground_Boots_Blue_FZ6288_02_standard.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/c2bcb0d26ea747689befaf8c00f5954d_9366/X_Speedportal_Firm_Ground_Boots_Blue_FZ6288_03_standard.jpg
','Active'),
-- 4
(4,2,11,110,8,'https://assets.adidas.com/images/w_600,f_auto,q_auto/15c17bab245f47369c8eaf7900dbc43b_9366/X_Speedportal.3_Laceless_Firm_Ground_Boots_White_FZ6101_22_model.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/be4cdb52603043bc9ac2af7900db6c46_9366/X_Speedportal.3_Laceless_Firm_Ground_Boots_White_FZ6101_01_standard_hover.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/85ea44a747874f50b0e3af7900db88fa_9366/X_Speedportal.3_Laceless_Firm_Ground_Boots_White_FZ6101_02_standard.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/5a94d0c46e7242719cb0af7900db910f_9366/X_Speedportal.3_Laceless_Firm_Ground_Boots_White_FZ6101_03_standard.jpg
','Active'),
(4,1,11,115,8,'https://assets.adidas.com/images/w_600,f_auto,q_auto/1bfb2e62bc9746139c43af720104c501_9366/X_Speedportal.3_Laceless_Firm_Ground_Boots_Pink_GZ5065_22_model.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/2d7f70839c92436aa45caf7200f54583_9366/X_Speedportal.3_Laceless_Firm_Ground_Boots_Pink_GZ5065_01_standard_hover.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/e786b6a76bc04475868caf7200f555b3_9366/X_Speedportal.3_Laceless_Firm_Ground_Boots_Pink_GZ5065_02_standard.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/c5e4511a1e664d42a2b5af7200f55e17_9366/X_Speedportal.3_Laceless_Firm_Ground_Boots_Pink_GZ5065_03_standard.jpg
','Active'),

--5
(5,1,12,89,9,'https://assets.adidas.com/images/w_600,f_auto,q_auto/074258cc50a94893ac43af7b00812aa0_9366/X_Speedportal.2_Firm_Ground_Boots_Pink_GV9563_22_model.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/d2c0109550c74c598761af7b0070ef5e_9366/X_Speedportal.2_Firm_Ground_Boots_Pink_GV9563_01_standard_hover.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/3fd48973152d49759a1aaf7b007101ea_9366/X_Speedportal.2_Firm_Ground_Boots_Pink_GV9563_02_standard.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/eae752be2909465086c3af7b00710b88_9366/X_Speedportal.2_Firm_Ground_Boots_Pink_GV9563_03_standard.jpg
','Active'),
(5,6,12,95,9,'https://assets.adidas.com/images/w_600,f_auto,q_auto/082f6048dd3a41108b6dae9e00ff44e4_9366/X_SPEEDPORTAL.2_Football_boots_Firm_Ground_Green_GW8450_22_model.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/37bc7b9195b445888bd4ae9e00fef266_9366/X_SPEEDPORTAL.2_Football_boots_Firm_Ground_Green_GW8450_01_standard_hover.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/f7bfe2cee002487db328ae9e00ff022a_9366/X_SPEEDPORTAL.2_Football_boots_Firm_Ground_Green_GW8450_02_standard.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/e0a4e0257b584787b626ae9e00ff10f9_9366/X_SPEEDPORTAL.2_Football_boots_Firm_Ground_Green_GW8450_04_standard.jpg
','Active'),

--women
-- 1
(6,3,10,200,11,'https://assets.adidas.com/images/w_600,f_auto,q_auto/969c0ae4004445a9a5d6aef600e44397_9366/SOLARGLIDE_6_Shoes_Purple_HP7655_01_standard.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/11fe109cb5ae406a9643aef600e45f6b_9366/SOLARGLIDE_6_Shoes_Purple_HP7655_02_standard.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/bcad76e3d5e1494c9009aef600e46c5f_9366/SOLARGLIDE_6_Shoes_Purple_HP7655_03_standard.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/92c65d9e8df64c13861daef600e47936_9366/SOLARGLIDE_6_Shoes_Purple_HP7655_04_standard.jpg
','Active'),
(6,7,10,200,11,'https://assets.adidas.com/images/w_600,f_auto,q_auto/d6435e55506b4fc3808faefa008af4d7_9366/SOLARGLIDE_6_Shoes_Black_HP7651_01_standard.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/58887513797b46ad9dd7aefa008b1143_9366/SOLARGLIDE_6_Shoes_Black_HP7651_02_standard_hover.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/927d43135ab64d799860aefa008b1f15_9366/SOLARGLIDE_6_Shoes_Black_HP7651_03_standard.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/86c3fbd5767c462fb7cfaefa008b2c8c_9366/SOLARGLIDE_6_Shoes_Black_HP7651_04_standard.jpg
','Active'),

-- 2
(7,1,8,250,10,'https://assets.adidas.com/images/w_600,f_auto,q_auto/19501922d0c142d2817fae980189136e_9366/Supernova_GORE-TEX_Shoes_Red_GZ6942_01_standard.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/a6c8ee7703444f3c9397ae9801892d53_9366/Supernova_GORE-TEX_Shoes_Red_GZ6942_02_standard_hover.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/aa8e9d9b792c41739166ae9801893977_9366/Supernova_GORE-TEX_Shoes_Red_GZ6942_03_standard.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/f2b6364ec6eb4e1289a8ae980189465b_9366/Supernova_GORE-TEX_Shoes_Red_GZ6942_04_standard.jpg
','Active'),
(7,7,8,260,10,'https://assets.adidas.com/images/w_600,f_auto,q_auto/1ba3fbb46c9742a2a991ae990106a1a7_9366/Supernova_GORE-TEX_Shoes_Black_GY8319_01_standard.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/81d96d5e2dbc489d8624ae990106b2ab_9366/Supernova_GORE-TEX_Shoes_Black_GY8319_02_standard_hover.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/e03e51519cd941dab095ae990106baa3_9366/Supernova_GORE-TEX_Shoes_Black_GY8319_03_standard.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/73316724b4854704ace7ae990106c2a6_9366/Supernova_GORE-TEX_Shoes_Black_GY8319_04_standard.jpg
','Active'),

-- 3
(8,2,9,250,11,'https://assets.adidas.com/images/w_600,f_auto,q_auto/cef8297b1dab42c48ee8af54009308c7_9366/Runfalcon_3.0_Shoes_White_HP7559_01_standard.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/8c2c6d4c52bb4daf9982af54009324b8_9366/Runfalcon_3.0_Shoes_White_HP7559_02_standard_hover.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/4330b0a4f25944f5a1edaf5400932d9a_9366/Runfalcon_3.0_Shoes_White_HP7559_03_standard.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/d894a7a26ede41bbb110af540093365d_9366/Runfalcon_3.0_Shoes_White_HP7559_04_standard.jpg
','Active'),
(8,4,9,250,11,'https://assets.adidas.com/images/w_600,f_auto,q_auto/e89e3ce0102e4f169ee0af540091debb_9366/Runfalcon_3.0_Shoes_Blue_HP7555_01_standard.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/1a6bc34c74974c4298a0af540091fb2a_9366/Runfalcon_3.0_Shoes_Blue_HP7555_02_standard_hover.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/5672aba665044f1f8a53af540092047d_9366/Runfalcon_3.0_Shoes_Blue_HP7555_03_standard.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/7841bcffb3074ab6ac25af5400920ddf_9366/Runfalcon_3.0_Shoes_Blue_HP7555_04_standard.jpg
','Active'),

-- 4
(9,5,9,220,15,'https://assets.adidas.com/images/w_600,f_auto,q_auto/e598151f2fad48efa749af7f00d9a4fb_9366/Ultraboost_Light_Shoes_Orange_HP9841_01_standard.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/c1ed2f661ef347cb80d2af7f00d9d08c_9366/Ultraboost_Light_Shoes_Orange_HP9841_02_standard_hover.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/e1bf6b9179074f1cb600af7f00d9de2d_9366/Ultraboost_Light_Shoes_Orange_HP9841_03_standard.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/ebfe5e7951714d62becbaf7f00d9ebe5_9366/Ultraboost_Light_Shoes_Orange_HP9841_04_standard.jpg
','Active'),
(9,2,9,220,15,'https://assets.adidas.com/images/w_600,f_auto,q_auto/0fbed4646c1d46e0aae0af6901301ff4_9366/Ultraboost_Light_Shoes_White_HQ6351_01_standard.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/cc1c639520ca44039c32af6901303809_9366/Ultraboost_Light_Shoes_White_HQ6351_02_standard_hover.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/e03d3078d77c489fbb1eaf6901304170_9366/Ultraboost_Light_Shoes_White_HQ6351_03_standard.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/ba851b9b2ce6421597deaf6901304b50_9366/Ultraboost_Light_Shoes_White_HQ6351_04_standard.jpg
','Active'),

-- 5
(10,6,10,210,21,'https://assets.adidas.com/images/w_600,f_auto,q_auto/cacdfe6bde8d41209e27aef600ebc823_9366/ADIDAS_ADIZERO_SL_RUNNING_SHOES_Turquoise_GV9090_01_standard.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/12900b7af20346c1a219aef600ec0a44_9366/ADIDAS_ADIZERO_SL_RUNNING_SHOES_Turquoise_GV9090_02_standard.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/9b43d6c2a36045f1b55caef600ec27ed_9366/ADIDAS_ADIZERO_SL_RUNNING_SHOES_Turquoise_GV9090_03_standard.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/8b731dc904404041b1a2aef600ec3dab_9366/ADIDAS_ADIZERO_SL_RUNNING_SHOES_Turquoise_GV9090_04_standard.jpg
','Active'),
(10,5,10,210,21,'https://assets.adidas.com/images/w_600,f_auto,q_auto/ab94416be3c7433b9b7eaef600ee8f27_9366/ADIDAS_ADIZERO_SL_RUNNING_SHOES_Red_HQ1337_01_standard.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/65ebcb7d9c8c4c3fa879aef600eeb855_9366/ADIDAS_ADIZERO_SL_RUNNING_SHOES_Red_HQ1337_02_standard_hover.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/4b4711dd57784b9e834caef600eecb5e_9366/ADIDAS_ADIZERO_SL_RUNNING_SHOES_Red_HQ1337_03_standard.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/89b485a2b81c4096b782aef600eeddc4_9366/ADIDAS_ADIZERO_SL_RUNNING_SHOES_Red_HQ1337_04_standard.jpg
','Active'),

-- kid
-- 1
(11,7,4,100,24,'https://assets.adidas.com/images/w_600,f_auto,q_auto/155aa084b6c543839cabac7f0146543e_9366/Terrex_Trailmaker_Hiking_Shoes_Grey_FW9324_01_standard.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/5df72f2f184c476d8275ac7f014663b7_9366/Terrex_Trailmaker_Hiking_Shoes_Grey_FW9324_02_standard_hover.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/d44c462bbaf043889a49ac7f01466afb_9366/Terrex_Trailmaker_Hiking_Shoes_Grey_FW9324_03_standard.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/67cc6436869744b3a69eac7f014671ef_9366/Terrex_Trailmaker_Hiking_Shoes_Grey_FW9324_04_standard.jpg
','Active'),
(11,8,4,100,24,'https://assets.adidas.com/images/w_600,f_auto,q_auto/49563d3501c0426fad14af7f01031b59_9366/Terrex_Trailmaker_Hiking_Shoes_Orange_HQ5814_01_standard.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/17ce846ee0d64f0ba6bbaf7f010340f5_9366/Terrex_Trailmaker_Hiking_Shoes_Orange_HQ5814_02_standard_hover.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/70e6d52b6ecf4795b167af7f01034a9e_9366/Terrex_Trailmaker_Hiking_Shoes_Orange_HQ5814_03_standard.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/c7ec4c71db1f42549db0af7f010353aa_9366/Terrex_Trailmaker_Hiking_Shoes_Orange_HQ5814_04_standard.jpg
','Active'),

-- 2
(12,6,5,160,14,'https://assets.adidas.com/images/w_600,f_auto,q_auto/d52b8717e0eb49a2b1bfaf9c01315b6f_9366/Terrex_x_LEGOr_Captain_Toey_Sandals_Green_HQ5847_01_standard.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/cf8d8da0f30d4058a3a1af9c013183e8_9366/Terrex_x_LEGOr_Captain_Toey_Sandals_Green_HQ5847_02_standard.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/e83a20af22c94c38a1aaaf9c01318d00_9366/Terrex_x_LEGOr_Captain_Toey_Sandals_Green_HQ5847_03_standard.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/60c712d0a653409d9ae7af9c01319502_9366/Terrex_x_LEGOr_Captain_Toey_Sandals_Green_HQ5847_04_standard.jpg
','Active'),
(12,1,5,160,14,'https://assets.adidas.com/images/w_600,f_auto,q_auto/243a48e2a7494ec0bd9eafa200c37d72_9366/Terrex_x_LEGOr_Captain_Toey_Sandals_Green_HQ5848_01_standard.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/91849ea751b44d668576afa200c3be52_9366/Terrex_x_LEGOr_Captain_Toey_Sandals_Green_HQ5848_02_standard.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/721f028492264463b14eafa200c3c97a_9366/Terrex_x_LEGOr_Captain_Toey_Sandals_Green_HQ5848_03_standard.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/aaa5a6bc36fc4cc7821bafa200c3d591_9366/Terrex_x_LEGOr_Captain_Toey_Sandals_Green_HQ5848_04_standard.jpg
','Active'),

-- 3
(13,3,6,140,16,'https://assets.adidas.com/images/w_600,f_auto,q_auto/60d542f3fa1b41acb23baf4f00fd7ad9_9366/Terrex_Trailmaker_Mid_RAIN.RDY_Hiking_Shoes_Purple_HQ5808_01_standard.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/4c84ef9120174c9bbd83af4f00fd8ee9_9366/Terrex_Trailmaker_Mid_RAIN.RDY_Hiking_Shoes_Purple_HQ5808_02_standard_hover.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/3f6cc86db90549afa8e4af4f00fd9ab5_9366/Terrex_Trailmaker_Mid_RAIN.RDY_Hiking_Shoes_Purple_HQ5808_03_standard.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/6df87ad3373b4c598f66af4f00fda43b_9366/Terrex_Trailmaker_Mid_RAIN.RDY_Hiking_Shoes_Purple_HQ5808_04_standard.jpg
','Active'),
(13,9,6,140,16,'https://assets.adidas.com/images/w_600,f_auto,q_auto/486436f1fc914438bc47af4f00fd0954_9366/Terrex_Trailmaker_Mid_RAIN.RDY_Hiking_Shoes_Beige_HQ5807_01_standard.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/d4f5240aed9e4863a96caf4f00fd2110_9366/Terrex_Trailmaker_Mid_RAIN.RDY_Hiking_Shoes_Beige_HQ5807_02_standard_hover.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/a2104c1c4a1e4d7ea5e6af4f00fd2bdb_9366/Terrex_Trailmaker_Mid_RAIN.RDY_Hiking_Shoes_Beige_HQ5807_03_standard.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/4912864f8657443b84bfaf4f00fd351a_9366/Terrex_Trailmaker_Mid_RAIN.RDY_Hiking_Shoes_Beige_HQ5807_04_standard.jpg
','Active'),

-- 4
(14,7,4,120,18,'https://assets.adidas.com/images/w_600,f_auto,q_auto/7dfc3b1dde954bfea71fabc100799d9e_9366/Terrex_GORE-TEX_Hiking_Shoes_Black_FU7268_01_standard.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/7964aee00a3348c28a11abc10079ae92_9366/Terrex_GORE-TEX_Hiking_Shoes_Black_FU7268_02_standard_hover.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/3910056d020d4593a878abc10079b681_9366/Terrex_GORE-TEX_Hiking_Shoes_Black_FU7268_03_standard.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/7159a2eac06740009e60abc10079be52_9366/Terrex_GORE-TEX_Hiking_Shoes_Black_FU7268_04_standard.jpg
','Active'),
(14,4,4,120,18,'https://assets.adidas.com/images/w_600,f_auto,q_auto/4db556b7f72348faaedaaf5f00f429d4_9366/Terrex_GORE-TEX_Hiking_Shoes_Blue_FZ6055_01_standard.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/3f410a5bc35b48b48782af5f00f451e6_9366/Terrex_GORE-TEX_Hiking_Shoes_Blue_FZ6055_02_standard_hover.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/a8ec2e7057d441168df5af5f00f45569_9366/Terrex_GORE-TEX_Hiking_Shoes_Blue_FZ6055_03_standard.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/c3f04cc408e543ae8a8caf5f00f45e91_9366/Terrex_GORE-TEX_Hiking_Shoes_Blue_FZ6055_04_standard.jpg
','Active'),

-- 5
(15,4,5,100,21,'https://assets.adidas.com/images/w_600,f_auto,q_auto/422662b765144f84bb07af3f00c40580_9366/Terrex_Captain_Toey_2.0_Sandals_Blue_HQ5836_01_standard.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/fb746a3d445a4644841aaf3f00c43901_9366/Terrex_Captain_Toey_2.0_Sandals_Blue_HQ5836_02_standard_hover.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/f7974d995a074129a8f6af3f00c4429e_9366/Terrex_Captain_Toey_2.0_Sandals_Blue_HQ5836_03_standard.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/38b29fe290404e9894a4af3f00c44bc6_9366/Terrex_Captain_Toey_2.0_Sandals_Blue_HQ5836_04_standard.jpg
','Active'),
(15,7,5,100,21,'https://assets.adidas.com/images/w_600,f_auto,q_auto/b0fd43c9348c435d9482af3f00b66cf2_9366/Terrex_Captain_Toey_2.0_Sandals_Black_HQ5835_01_standard.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/6055931fe7f64291a422af3f00c3b795_9366/Terrex_Captain_Toey_2.0_Sandals_Black_HQ5835_02_standard_hover.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/1e81e501199849c3b398af3f00c3c6a2_9366/Terrex_Captain_Toey_2.0_Sandals_Black_HQ5835_03_standard.jpg
|https://assets.adidas.com/images/w_600,f_auto,q_auto/e94902f715e44f9d8fc7af3f00c3d327_9366/Terrex_Captain_Toey_2.0_Sandals_Black_HQ5835_04_standard.jpg
','Active')

// Puma
insert into [ProductItems](ProductId,ColorId,SizeId,Price,QuantityInStock,ImageUrl,Status)
values
(16,7,9,'120',20,'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/377044/01/bv/fnd/PNA/fmt/png/Fast-Trac-NITRO-Men''s-Running-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/377044/01/fnd/PNA/fmt/png/Fast-Trac-NITRO-Men''s-Running-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/377044/01/sv02/fnd/PNA/fmt/png/Fast-Trac-NITRO-Men''s-Running-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/377044/01/sv04/fnd/PNA/fmt/png/Fast-Trac-NITRO-Men''s-Running-Shoes','Acttive'),
(16,5,10,'130',20,'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/377044/07/sv01/fnd/PNA/fmt/png/Fast-Trac-NITRO-Men''s-Running-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/377044/07/fnd/PNA/fmt/png/Fast-Trac-NITRO-Men''s-Running-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/377044/07/sv02/fnd/PNA/fmt/png/Fast-Trac-NITRO-Men''s-Running-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/377044/07/sv04/fnd/PNA/fmt/png/Fast-Trac-NITRO-Men''s-Running-Shoes','Acttive'),
(17,7,9,'130',20,'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/376919/01/sv01/fnd/PNA/fmt/png/Voyage-NITRO-2-Men''s-Running-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/376919/01/fnd/PNA/fmt/png/Voyage-NITRO-2-Men''s-Running-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/376919/01/sv02/fnd/PNA/fmt/png/Voyage-NITRO-2-Men''s-Running-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/376919/01/sv04/fnd/PNA/fmt/png/Voyage-NITRO-2-Men''s-Running-Shoes','Acttive'),
(17,6,9,'130',20,'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/376919/10/sv01/fnd/PNA/fmt/png/Voyage-NITRO-2-Men''s-Running-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/376919/10/fnd/PNA/fmt/png/Voyage-NITRO-2-Men''s-Running-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/376919/10/sv02/fnd/PNA/fmt/png/Voyage-NITRO-2-Men''s-Running-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/376919/10/sv04/fnd/PNA/fmt/png/Voyage-NITRO-2-Men''s-Running-Shoes','Acttive'),
(18,8,9,'130',20,'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/195337/12/sv01/fnd/PNA/fmt/png/Velocity-NITRO-2-Men''s-Running-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/195337/12/fnd/PNA/fmt/png/Velocity-NITRO-2-Men''s-Running-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/195337/12/sv02/fnd/PNA/fmt/png/Velocity-NITRO-2-Men''s-Running-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/195337/12/sv04/fnd/PNA/fmt/png/Velocity-NITRO-2-Men''s-Running-Shoes','Acttive'),
(18,5,9,'130',20,'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/195337/04/sv01/fnd/PNA/fmt/png/Velocity-NITRO-2-Men''s-Running-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/195337/04/fnd/PNA/fmt/png/Velocity-NITRO-2-Men''s-Running-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/195337/04/sv04/fnd/PNA/fmt/png/Velocity-NITRO-2-Men''s-Running-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/195337/04/sv02/fnd/PNA/fmt/png/Velocity-NITRO-2-Men''s-Running-Shoes','Acttive'),
(19,3,9,'130',20,'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/376905/02/sv01/fnd/PNA/fmt/png/Magnify-NITRO-Surge-Men''s-Running-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/376905/02/fnd/PNA/fmt/png/Magnify-NITRO-Surge-Men''s-Running-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/376905/02/sv02/fnd/PNA/fmt/png/Magnify-NITRO-Surge-Men''s-Running-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/376905/02/sv04/fnd/PNA/fmt/png/Magnify-NITRO-Surge-Men''s-Running-Shoes','Acttive'),
(19,4,9,'130',20,'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/376905/08/sv01/fnd/PNA/fmt/png/Magnify-NITRO-Surge-Men''s-Running-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/376905/08/fnd/PNA/fmt/png/Magnify-NITRO-Surge-Men''s-Running-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/376905/08/sv02/fnd/PNA/fmt/png/Magnify-NITRO-Surge-Men''s-Running-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/376905/08/sv04/fnd/PNA/fmt/png/Magnify-NITRO-Surge-Men''s-Running-Shoes','Acttive'),
(20,4,9,'130',20,'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/377291/02/sv01/fnd/PNA/fmt/png/PUMA-x-FIRST-MILE-Velocity-NITRO-2-Men''s-Running-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/377291/02/fnd/PNA/fmt/png/PUMA-x-FIRST-MILE-Velocity-NITRO-2-Men''s-Running-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/377291/02/sv02/fnd/PNA/fmt/png/PUMA-x-FIRST-MILE-Velocity-NITRO-2-Men''s-Running-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/377291/02/sv04/fnd/PNA/fmt/png/PUMA-x-FIRST-MILE-Velocity-NITRO-2-Men''s-Running-Shoes','Acttive'),
(20,3,9,'130',20,'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/377291/01/sv01/fnd/PNA/fmt/png/PUMA-x-FIRST-MILE-Velocity-NITRO-2-Men''s-Running-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/377291/01/fnd/PNA/fmt/png/PUMA-x-FIRST-MILE-Velocity-NITRO-2-Men''s-Running-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/377291/01/sv02/fnd/PNA/fmt/png/PUMA-x-FIRST-MILE-Velocity-NITRO-2-Men''s-Running-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/377291/01/sv04/fnd/PNA/fmt/png/PUMA-x-FIRST-MILE-Velocity-NITRO-2-Men''s-Running-Shoes','Acttive'),
(21,1,9,'130',20,'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/195161/17/sv01/fnd/PNA/fmt/png/Softride-Sophia-Slip-on-Women''s-Running-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/195161/17/fnd/PNA/fmt/png/Softride-Sophia-Slip-on-Women''s-Running-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/195161/17/sv02/fnd/PNA/fmt/png/Softride-Sophia-Slip-on-Women''s-Running-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/195161/17/sv04/fnd/PNA/fmt/png/Softride-Sophia-Slip-on-Women''s-Running-Shoes','Acttive'),
(21,7,9,'130',20,'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/195161/14/sv01/fnd/PNA/fmt/png/Softride-Sophia-Slip-on-Women''s-Running-Shoe|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/195161/14/fnd/PNA/fmt/png/Softride-Sophia-Slip-on-Women''s-Running-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/195161/14/sv02/fnd/PNA/fmt/png/Softride-Sophia-Slip-on-Women''s-Running-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/195161/14/sv04/fnd/PNA/fmt/png/Softride-Sophia-Slip-on-Women''s-Running-Shoes','Acttive'),
(22,1,9,'130',20,'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/377758/05/sv01/fnd/PNA/fmt/png/ForeverRUN-NITRO-Women''s-Running-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/377758/05/fnd/PNA/fmt/png/ForeverRUN-NITRO-Women''s-Running-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/377758/05/sv02/fnd/PNA/fmt/png/ForeverRUN-NITRO-Women''s-Running-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/377758/05/sv04/fnd/PNA/fmt/png/ForeverRUN-NITRO-Women''s-Running-Shoes','Acttive'),
(22,2,9,'130',20,'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/377758/06/sv01/fnd/PNA/fmt/png/ForeverRUN-NITRO-Women''s-Running-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/377758/06/fnd/PNA/fmt/png/ForeverRUN-NITRO-Women''s-Running-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/377758/06/sv02/fnd/PNA/fmt/png/ForeverRUN-NITRO-Women''s-Running-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/377758/06/sv04/fnd/PNA/fmt/png/ForeverRUN-NITRO-Women''s-Running-Shoes','Acttive'),
(23,1,9,'130',20,'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/377188/02/sv01/fnd/PNA/fmt/png/PUMA-x-MAGGIE-STEPHENSON-Run-XX-NITRO-Women''s-Running-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/377188/02/fnd/PNA/fmt/png/PUMA-x-MAGGIE-STEPHENSON-Run-XX-NITRO-Women''s-Running-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/377188/02/sv02/fnd/PNA/fmt/png/PUMA-x-MAGGIE-STEPHENSON-Run-XX-NITRO-Women''s-Running-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/377188/02/sv04/fnd/PNA/fmt/png/PUMA-x-MAGGIE-STEPHENSON-Run-XX-NITRO-Women''s-Running-Shoes','Acttive'),
(23,7,9,'130',20,'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/377188/01/sv01/fnd/PNA/fmt/png/PUMA-x-MAGGIE-STEPHENSON-Run-XX-NITRO-Women''s-Running-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/377188/01/fnd/PNA/fmt/png/PUMA-x-MAGGIE-STEPHENSON-Run-XX-NITRO-Women''s-Running-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/377188/01/sv02/fnd/PNA/fmt/png/PUMA-x-MAGGIE-STEPHENSON-Run-XX-NITRO-Women''s-Running-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/377188/01/sv04/fnd/PNA/fmt/png/PUMA-x-MAGGIE-STEPHENSON-Run-XX-NITRO-Women''s-Running-Shoes','Acttive'),
(24,2,9,'130',20,'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/376171/03/sv01/fnd/PNA/fmt/png/Run-XX-Nitro-Women''s-Running-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/376171/03/sv02/fnd/PNA/fmt/png/Run-XX-Nitro-Women''s-Running-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/376171/03/sv04/fnd/PNA/fmt/png/Run-XX-Nitro-Women''s-Running-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/376171/03/bv/fnd/PNA/fmt/png/Run-XX-Nitro-Women''s-Running-Shoes','Acttive'),
(24,2,9,'130',20,'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/376171/04/sv01/fnd/PNA/fmt/png/Run-XX-Nitro-Women''s-Running-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/376171/04/fnd/PNA/fmt/png/Run-XX-Nitro-Women''s-Running-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/376171/04/sv02/fnd/PNA/fmt/png/Run-XX-Nitro-Women''s-Running-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/376171/04/sv04/fnd/PNA/fmt/png/Run-XX-Nitro-Women''s-Running-Shoes','Acttive'),
(25,2,9,'130',20,'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/194458/04/sv01/fnd/PNA/fmt/png/Liberate-NITRO-Women''s-Running-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/194458/04/fnd/PNA/fmt/png/Liberate-NITRO-Women''s-Running-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/194458/04/sv02/fnd/PNA/fmt/png/Liberate-NITRO-Women''s-Running-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/194458/04/sv04/fnd/PNA/fmt/png/Liberate-NITRO-Women''s-Running-Shoes','Acttive'),
(25,7,9,'130',20,'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/194458/13/sv01/fnd/PNA/fmt/png/Liberate-NITRO-Women''s-Running-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/194458/13/fnd/PNA/fmt/png/Liberate-NITRO-Women''s-Running-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/194458/13/sv02/fnd/PNA/fmt/png/Liberate-NITRO-Women''s-Running-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/194458/13/sv04/fnd/PNA/fmt/png/Liberate-NITRO-Women''s-Running-Shoes','Acttive'),
(26,9,4,'130',20,'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/391645/01/sv01/fnd/PNA/fmt/png/PUMA-x-SPONGEBOB-Little-Kids''-Slipstream-Sneakers|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/391645/01/fnd/PNA/fmt/png/PUMA-x-SPONGEBOB-Little-Kids''-Slipstream-Sneakers|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/391645/01/sv02/fnd/PNA/fmt/png/PUMA-x-SPONGEBOB-Little-Kids''-Slipstream-Sneakers|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/391645/01/sv04/fnd/PNA/fmt/png/PUMA-x-SPONGEBOB-Little-Kids''-Slipstream-Sneakers','Acttive'),
(26,2,4,'130',20,'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/393745/01/sv01/fnd/PNA/fmt/png/PUMA-x-COCOMELON-Slipstream-AC-Little-Kids''-Sneakers%C2%A0|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/393745/01/fnd/PNA/fmt/png/PUMA-x-COCOMELON-Slipstream-AC-Little-Kids''-Sneakers%C2%A0|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/393745/01/sv02/fnd/PNA/fmt/png/PUMA-x-COCOMELON-Slipstream-AC-Little-Kids''-Sneakers%C2%A0|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/393745/01/sv04/fnd/PNA/fmt/png/PUMA-x-COCOMELON-Slipstream-AC-Little-Kids''-Sneakers%C2%A0','Acttive'),
(27,6,2,'130',20,'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/391972/01/sv01/fnd/PNA/fmt/png/Suede-Camowave-Big-Kids''-Sneakers|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/391972/01/fnd/PNA/fmt/png/Suede-Camowave-Big-Kids''-Sneakers|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/391972/01/sv02/fnd/PNA/fmt/png/Suede-Camowave-Big-Kids''-Sneakers|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/391972/01/sv04/fnd/PNA/fmt/png/Suede-Camowave-Big-Kids''-Sneakers','Acttive'),
(27,4,3,'130',20,'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_100,h_100/global/391972/02/sv01/fnd/PNA/fmt/png/Suede-Camowave-Big-Kids''-Sneakers|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/391972/02/sv01/fnd/PNA/fmt/png/Suede-Camowave-Big-Kids''-Sneakers|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/391972/02/fnd/PNA/fmt/png/Suede-Camowave-Big-Kids''-Sneakers|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/391972/02/sv02/fnd/PNA/fmt/png/Suede-Camowave-Big-Kids''-Sneakers','Acttive'),
(28,7,4,'130',20,'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/384992/01/sv01/fnd/PNA/fmt/png/Softride-Slide-Sandals-Big-Kids|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/384992/01/fnd/PNA/fmt/png/Softride-Slide-Sandals-Big-Kids|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/384992/01/sv02/fnd/PNA/fmt/png/Softride-Slide-Sandals-Big-Kids|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/384992/01/sv04/fnd/PNA/fmt/png/Softride-Slide-Sandals-Big-Kids','Acttive'),
(28,4,3,'130',20,'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/384992/08/sv01/fnd/PNA/fmt/png/Softride-Slide-Sandals-Big-Kids|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/384992/08/fnd/PNA/fmt/png/Softride-Slide-Sandals-Big-Kids|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/384992/08/sv02/fnd/PNA/fmt/png/Softride-Slide-Sandals-Big-Kids|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/384992/08/sv04/fnd/PNA/fmt/png/Softride-Slide-Sandals-Big-Kids','Acttive'),
(29,2,4,'130',20,'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/392005/01/sv01/fnd/PNA/fmt/png/CA-Pro-Block-Toddlers''-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/392005/01/fnd/PNA/fmt/png/CA-Pro-Block-Toddlers''-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/392005/01/sv02/fnd/PNA/fmt/png/CA-Pro-Block-Toddlers''-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/392005/01/sv04/fnd/PNA/fmt/png/CA-Pro-Block-Toddlers''-Shoes','Acttive'),
(29,11,3,'130',20,'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/392005/02/sv01/fnd/PNA/fmt/png/CA-Pro-Block-Toddlers''-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/392005/02/fnd/PNA/fmt/png/CA-Pro-Block-Toddlers''-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/392005/02/bv/fnd/PNA/fmt/png/CA-Pro-Block-Toddlers''-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/392005/02/sv04/fnd/PNA/fmt/png/CA-Pro-Block-Toddlers''-Shoes','Acttive'),
(30,8,3,'130',20,'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/388644/02/sv01/fnd/PNA/fmt/png/PUMA-x-TINY-COTTONS-CA-Pro-Printed-Little-Kids''-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/388644/02/fnd/PNA/fmt/png/PUMA-x-TINY-COTTONS-CA-Pro-Printed-Little-Kids''-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/388644/02/bv/fnd/PNA/fmt/png/PUMA-x-TINY-COTTONS-CA-Pro-Printed-Little-Kids''-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/388644/02/sv04/fnd/PNA/fmt/png/PUMA-x-TINY-COTTONS-CA-Pro-Printed-Little-Kids''-Shoes','Acttive'),
(30,3,2,'130',20,'https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/388644/01/sv01/fnd/PNA/fmt/png/PUMA-x-TINY-COTTONS-CA-Pro-Printed-Little-Kids''-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/388644/01/fnd/PNA/fmt/png/PUMA-x-TINY-COTTONS-CA-Pro-Printed-Little-Kids''-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/388644/01/bv/fnd/PNA/fmt/png/PUMA-x-TINY-COTTONS-CA-Pro-Printed-Little-Kids''-Shoes|
https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_1350,h_1350/global/388644/01/sv04/fnd/PNA/fmt/png/PUMA-x-TINY-COTTONS-CA-Pro-Printed-Little-Kids''-Shoes','Acttive');

// Nike
insert into [ProductItems](ProductId,ColorId,SizeId,Price,QuantityInStock,ImageUrl,Status)
values
(31,7,9,'130',20,'https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/6552f272-22ee-4172-a56e-1ca48ea8037c/wio-10-road-running-shoes-GBqQMW.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5,q_80/b53e55b1-bc3c-443e-8990-88c3d80e7590/wio-10-road-running-shoes-GBqQMW.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5,q_80/e332d9f9-4b12-4810-a437-fe614d30b1e7/wio-10-road-running-shoes-GBqQMW.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5,q_80/540e81b1-0104-482c-a91b-226e617775e8/wio-10-road-running-shoes-GBqQMW.png','Acttive'),
(31,2,9,'130',20,'https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/51833e97-f4d6-4063-a0cc-0ab6d6a03ad6/wio-10-road-running-shoes-GBqQMW.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5,q_80/e4594937-fd2c-4179-b6a7-f440ff096a48/wio-10-road-running-shoes-GBqQMW.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5,q_80/6cdcc106-9cde-4265-bf74-29cc0d826f92/wio-10-road-running-shoes-GBqQMW.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5,q_80/87161e4c-413b-4ab0-810b-9b00ad054d9a/wio-10-road-running-shoes-GBqQMW.png','Acttive'),
(32,2,9,'130',20,'https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/65485dea-78ab-40e1-9217-3c522842d3ff/react-miler-3-road-running-shoes-5xtNSj.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/2135062a-3fb4-4b2d-809b-b7966a23c917/react-miler-3-road-running-shoes-5xtNSj.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/4663fdc4-a734-4b53-bf30-bfff8da2e40e/react-miler-3-road-running-shoes-5xtNSj.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/6d4030ba-11d0-400e-81e6-e4e60b9239c4/react-miler-3-road-running-shoes-5xtNSj.png','Acttive'),
(32,5,9,'130',20,'https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/d93edf41-6a0b-407e-bd87-2ab4bfbf7b4f/react-miler-3-road-running-shoes-5xtNSj.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5,q_80/c51be323-a26f-469e-8d6e-969749195511/react-miler-3-road-running-shoes-5xtNSj.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5,q_80/d1e7dc28-dda4-4437-854f-54bf56c624ef/react-miler-3-road-running-shoes-5xtNSj.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5,q_80/057a965d-1a54-4c0a-957b-ed1821f8a8b0/react-miler-3-road-running-shoes-5xtNSj.png','Acttive'),
(33,11,9,'130',20,'https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/c13585d6-a1fc-4359-9a3a-3de1d5ece781/pegasus-flyease-easy-on-off-road-running-shoes-RlnnC7.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/2f8a4f18-4ade-4a57-9380-3b8e61fb6f9c/pegasus-flyease-easy-on-off-road-running-shoes-RlnnC7.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/3a4031cd-13bc-4601-954b-b127808e2571/pegasus-flyease-easy-on-off-road-running-shoes-RlnnC7.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/70ec4328-7242-40cc-936e-c18766f56faf/pegasus-flyease-easy-on-off-road-running-shoes-RlnnC7.png','Acttive'),
(33,4,9,'130',20,'https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/8e5c14a4-19fb-4778-a813-58245bb5877c/pegasus-flyease-easy-on-off-road-running-shoes-RlnnC7.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5,q_80/c60026c3-9863-460e-a174-1c77df6ae4c9/pegasus-flyease-easy-on-off-road-running-shoes-RlnnC7.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5,q_80/df7a01e4-b25a-4470-8c6d-c5688aa5ca65/pegasus-flyease-easy-on-off-road-running-shoes-RlnnC7.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5,q_80/3028e38c-3a35-4db0-8c04-a8dba296bf5d/pegasus-flyease-easy-on-off-road-running-shoes-RlnnC7.png','Acttive'),
(34,7,9,'130',20,'https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/da86f0f8-ca81-4c67-b1c5-e16baf96a078/run-swift-3-road-running-shoes-BrHm16.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5,q_80/ca00e93e-e826-4cd8-84bd-a9d137eab856/run-swift-3-road-running-shoes-BrHm16.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5,q_80/73115653-8e16-4de4-9e65-9e11a091ef52/run-swift-3-road-running-shoes-BrHm16.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5,q_80/e98e7318-bde1-458e-a9cc-3d18989ed6b4/run-swift-3-road-running-shoes-BrHm16.png','Acttive'),
(34,2,9,'130',20,'https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/8ef9fb42-d7e8-4b7c-a271-5308137f215a/run-swift-3-road-running-shoes-BrHm16.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5,q_80/201672ce-ca57-45bc-89ae-71237a8df015/run-swift-3-road-running-shoes-BrHm16.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5,q_80/a329562c-862f-4a77-8c4c-f4389ae1748e/run-swift-3-road-running-shoes-BrHm16.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5,q_80/66ab2ea5-137d-4273-ac57-a9d3763f6820/run-swift-3-road-running-shoes-BrHm16.png','Acttive'),
(35,3,9,'130',20,'https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/991b43da-2d24-446e-9fc3-959220cd4975/custom-pegasus-trail-4-by-you.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/a7891246-30c5-4ee8-88a4-f630fb5e6d60/custom-pegasus-trail-4-by-you.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/893689d7-fa9e-4212-90e8-97332e42bf99/custom-pegasus-trail-4-by-you.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/294836d1-405d-4f77-9070-191f419d0c6c/custom-pegasus-trail-4-by-you.png','Acttive'),
(35,11,9,'130',20,'https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/1b9f0520-76c9-4367-a341-9ceef988c6ca/custom-pegasus-trail-4-by-you.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/18519382-2bd6-4b91-946b-03622f02a503/custom-pegasus-trail-4-by-you.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/8104adec-3c50-421f-a4c6-49944e2e5196/custom-pegasus-trail-4-by-you.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/aeadc1e2-7f4d-4c7a-9d2b-9681da89baa5/custom-pegasus-trail-4-by-you.png','Acttive'),
(36,2,9,'130',20,'https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/df86af05-e274-4fd2-baa1-ec428da30eeb/pegasus-turbo-next-nature-road-running-shoes-wq9drv.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/da65230c-5d74-4c2b-91bd-3a58ba4e337f/pegasus-turbo-next-nature-road-running-shoes-wq9drv.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/9c3be840-8c7b-494a-b978-20f403aaca0f/pegasus-turbo-next-nature-road-running-shoes-wq9drv.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/7e1f7065-27e2-450f-b752-133cde1367ba/pegasus-turbo-next-nature-road-running-shoes-wq9drv.png','Acttive'),
(36,1,9,'130',20,'https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/f8dbc522-5729-4316-a119-447358ae0c51/pegasus-turbo-next-nature-road-running-shoes-wq9drv.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/86290f8d-e335-43ec-913b-4d6b80d2b8f4/pegasus-turbo-next-nature-road-running-shoes-wq9drv.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/df2c3fb8-b13e-49d9-94b7-e1f6c721576e/pegasus-turbo-next-nature-road-running-shoes-wq9drv.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/e55ca525-746f-42eb-b824-9776a66a4423/pegasus-turbo-next-nature-road-running-shoes-wq9drv.png','Acttive'),
(37,7,9,'130',20,'https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/6eb5520b-2daf-452a-8908-7fba420bcf57/alphafly-2-road-racing-shoes-DcWrKF.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/cc54f69a-5127-4861-aa84-432bcfff0c2f/alphafly-2-road-racing-shoes-DcWrKF.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/47ccdb5a-4097-4e70-9c27-5695f32cf65e/alphafly-2-road-racing-shoes-DcWrKF.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/d9d550c2-9e2b-484c-958e-6abaffce26b5/alphafly-2-road-racing-shoes-DcWrKF.png','Acttive'),
(37,1,9,'130',20,'https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/e0b55a0c-0619-4a43-8790-1d97318ad30b/alphafly-2-road-racing-shoes-DcWrKF.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/784675da-80d6-4e6f-95cd-bb0e80b01e5b/alphafly-2-road-racing-shoes-DcWrKF.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/5b42bd0e-ca64-41e5-a3e1-7bbc1dae57d3/alphafly-2-road-racing-shoes-DcWrKF.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/3346bc38-dedc-4bce-96f2-2c5c0a5acf11/alphafly-2-road-racing-shoes-DcWrKF.png','Acttive'),
(38,9,9,'130',20,'https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/815b0145-f025-42a6-aa6d-5d309a2b7163/zegama-trail-running-shoes-k8JNNn.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/3bd28bad-5bbe-4c93-94d5-33ba23612681/zegama-trail-running-shoes-k8JNNn.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/1aa9d1f7-afa5-40c7-9bd3-c882fc155e73/zegama-trail-running-shoes-k8JNNn.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/b5deb2a6-523e-4416-869a-7546d000b326/zegama-trail-running-shoes-k8JNNn.png','Acttive'),
(38,7,9,'130',20,'https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/076e6420-7c94-4e33-9c8f-6f6b8d2236f7/zegama-trail-running-shoes-k8JNNn.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5,q_80/22598f19-9324-4623-8d49-dac25b3e80dc/zegama-trail-running-shoes-k8JNNn.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5,q_80/e291103d-3dd2-414e-9ecd-9e02e1ff3452/zegama-trail-running-shoes-k8JNNn.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5,q_80/620f21c0-451a-4d14-af65-b01caf6e185a/zegama-trail-running-shoes-k8JNNn.png','Acttive'),
(39,1,9,'130',20,'https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/98393bae-2ce0-4be3-a5bf-dbbb353d80cb/escape-run-2-road-running-shoes-ktrfqG.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/414330eb-03dd-47ad-827f-2cafe3b50fa7/escape-run-2-road-running-shoes-ktrfqG.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/ca6281e0-f4f8-41c8-9ac9-c8c57b6acf9f/escape-run-2-road-running-shoes-ktrfqG.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/98fda33c-cc52-403c-9c8d-f07302c2fe2f/escape-run-2-road-running-shoes-ktrfqG.png','Acttive'),
(39,5,9,'130',20,'https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/1a88e533-cf0f-496d-976c-9009110a6fea/escape-run-2-road-running-shoes-ktrfqG.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5,q_80/c0b08078-ec73-44e3-abfd-c462d75a6e81/escape-run-2-road-running-shoes-ktrfqG.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5,q_80/32c4ff77-dc36-44fb-83f4-c78f73093f06/escape-run-2-road-running-shoes-ktrfqG.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5,q_80/14f3e393-10d6-4dd8-a872-ab6bffcb35c9/escape-run-2-road-running-shoes-ktrfqG.png','Acttive'),
(40,10,9,'130',20,'https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/ea30cafb-2c38-4151-8f6f-c0ccc32732d5/serenity-run-2-road-running-shoes-S4qm49.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/4d0bd2de-8767-471f-8604-e64e5d195748/serenity-run-2-road-running-shoes-S4qm49.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/61c97167-545b-4f7b-a461-b8b8191527d8/serenity-run-2-road-running-shoes-S4qm49.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/a408ceb8-1454-4f8b-8d09-05d7847bbaf1/serenity-run-2-road-running-shoes-S4qm49.png','Acttive'),
(40,7,9,'130',20,'https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/dd74dc2e-e094-48f1-a894-411d5a5e9f9c/serenity-run-2-road-running-shoes-S4qm49.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/5c4ae1fd-f55a-4f9b-9ea7-741ce65cb605/serenity-run-2-road-running-shoes-S4qm49.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/8aee264e-b063-4e72-907b-43e796a71ce8/serenity-run-2-road-running-shoes-S4qm49.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/77c34a51-85b2-43a7-8dc1-fa003fc1be58/serenity-run-2-road-running-shoes-S4qm49.png','Acttive'),
(41,2,2,'130',20,'https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/d375e725-3011-4350-a3ad-78dedd9ffa68/dynamo-go-easy-on-off-shoes-st92bW.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5,q_80/df3ef633-5e20-4f3c-a403-1c585a7de3e0/dynamo-go-easy-on-off-shoes-st92bW.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5,q_80/95b09471-af1f-4668-9389-3d2c1055bf7c/dynamo-go-easy-on-off-shoes-st92bW.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5,q_80/c18dbf66-880e-4882-ad25-0183e0fa2da2/dynamo-go-easy-on-off-shoes-st92bW.png','Acttive'),
(41,7,2,'130',20,'https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/30db7115-d860-4b7f-833d-458c99c2e448/dynamo-go-easy-on-off-shoes-st92bW.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5,q_80/669c159c-4332-4b60-938e-e05821a7b7ab/dynamo-go-easy-on-off-shoes-st92bW.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5,q_80/b0c6799c-47db-4a19-8f33-5200dd694cc4/dynamo-go-easy-on-off-shoes-st92bW.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5,q_80/fdbfd1c1-f742-456e-8969-8c3cc9932c08/dynamo-go-easy-on-off-shoes-st92bW.png','Acttive'),
(42,2,2,'130',20,'https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/5dcd3c7b-680f-411f-968f-99db6a52a03a/air-max-270-go-younger-easy-on-off-shoes-p5f5v1.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/f7476aa1-2dd4-4859-b818-4ab6651f269f/air-max-270-go-younger-easy-on-off-shoes-p5f5v1.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/5af812cb-371a-45a7-86dc-4557ef35965c/air-max-270-go-younger-easy-on-off-shoes-p5f5v1.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/2ad815d1-456a-4411-b67f-35e8e96134d1/air-max-270-go-younger-easy-on-off-shoes-p5f5v1.png','Acttive'),
(42,7,2,'130',20,'https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/e8e2d037-b69a-4941-9459-0e9b5c6bd50a/air-max-270-go-younger-easy-on-off-shoes-p5f5v1.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5,q_80/7b9da0fa-671d-46b1-a01b-75c40facfc38/air-max-270-go-younger-easy-on-off-shoes-p5f5v1.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5,q_80/aaa70c25-d9d8-44a8-ab4d-273bc3e6a625/air-max-270-go-younger-easy-on-off-shoes-p5f5v1.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5,q_80/f34af5cf-06ee-48da-902c-b3f58563c559/air-max-270-go-younger-easy-on-off-shoes-p5f5v1.png','Acttive'),
(43,2,2,'130',20,'https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/a33486c1-f833-4be9-a491-26f1561caf19/court-borough-low-2-shoes-HL7d8l.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/5a467934-8f90-468d-af33-76306ba3078c/court-borough-low-2-shoes-HL7d8l.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/29317b1c-add3-4909-ac87-e1bb22576fb7/court-borough-low-2-shoes-HL7d8l.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/ddf6590f-74b6-4a99-9c49-edaf4008b91a/court-borough-low-2-shoes-HL7d8l.png','Acttive'),
(43,7,2,'130',20,'https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/i1-9150f9a5-1dda-439b-9fd1-42864a39896a/court-borough-low-2-shoes-HL7d8l.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/i1-27e0176c-60f3-41f7-8169-fc8945ede40c/court-borough-low-2-shoes-HL7d8l.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/i1-9a0611b3-7998-4768-9b99-f21977dbdefc/court-borough-low-2-shoes-HL7d8l.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/i1-64842faa-f497-4f02-9b71-0242415b2edc/court-borough-low-2-shoes-HL7d8l.png','Acttive'),
(44,2,2,'130',20,'https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/5c767382-f0d6-4b24-9cdc-7f13ccc165ec/jordan-flare-and-shoe-xdcH5J.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/d8af4f44-f877-4bc2-a3e4-5baf2dbb232e/jordan-flare-and-shoe-xdcH5J.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/1a47d741-b874-4b2c-ba5a-2c15547cfad1/jordan-flare-and-shoe-xdcH5J.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/25b58976-ed2a-4310-a66e-9e73a87fd06f/jordan-flare-and-shoe-xdcH5J.png','Acttive'),
(44,5,2,'130',20,'https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/4d92a7e4-c18c-466b-953b-2afabd3ba509/jordan-flare-and-shoe-xdcH5J.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5,q_80/a327cd86-b432-4cc0-95ab-08b3b77cb59a/jordan-flare-and-shoe-xdcH5J.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5,q_80/2aec0580-d993-4ff2-9841-1823731ba132/jordan-flare-and-shoe-xdcH5J.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5,q_80/44b86842-9f30-42c7-9b3d-dd553d589ab8/jordan-flare-and-shoe-xdcH5J.png','Acttive'),
(45,6,2,'130',20,'https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/91818a09-632e-439e-8a0f-69dc917674df/jordan-23-7-shoes-VgL3Kq.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/fcf167d0-d109-4f5d-baba-ff21af95a1f2/jordan-23-7-shoes-VgL3Kq.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/d1296c72-b4ae-4efb-9bfa-49bb3d2084b1/jordan-23-7-shoes-VgL3Kq.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/a65fb186-ebd4-4aac-984f-0f74a51c17b7/jordan-23-7-shoes-VgL3Kq.png','Acttive'),
(45,11,2,'130',20,'https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/2a8e1c46-0a2a-4705-8613-9e6f9a166791/jordan-23-7-shoes-VgL3Kq.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5,q_80/c5f8a64a-a940-4a8a-bc9c-df2593196276/jordan-23-7-shoes-VgL3Kq.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5,q_80/8b3fa57e-5ee0-48c5-808e-640f6e536d78/jordan-23-7-shoes-VgL3Kq.png|
https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5,q_80/9fb4bd43-387f-44eb-b86a-fa83865068d5/jordan-23-7-shoes-VgL3Kq.png','Acttive');