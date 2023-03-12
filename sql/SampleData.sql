Insert into OrderStatus(Description) values('Cancelled'),('PendingPayment'),('Failed'),('Processing'),('Completed'),('OnHold'),('Refunded');
insert into [Brands](Name) values('Nike'),('Puma'),('Addidas');
insert into [Categories](Description,Code) values('For men','Men'),('For women','Women'),('For kid','Kid');

insert into Products(Name,ImageLink,Price,InStock,IsAvailable,BrandId,CategoryId)
values(N'Nike Force 1 Low ASW','https://static.nike.com/a/images/c_limit,w_592,f_a…b2d-675f1de5dd6e/force-1-low-asw-shoes-5fp6WC.png',200,2,1,1,3),
(N'Nike Air Max 270 GO','https://static.nike.com/a/images/c_limit,w_592,f_a…1db02/air-max-270-go-easy-on-off-shoes-cKPvgH.png',100,10,1,1,3),
(N'Nike Air Max 90 LTR SE','https://static.nike.com/a/images/c_limit,w_592,f_a…1d8034/air-max-90-ltr-se-younger-shoes-ZHBVdP.png',150,12,1,1,3),
(N'Retaliate 2 Sneakers Kids','https://images.puma.com/image/upload/f_auto,q_auto…08/sv01/fnd/GBR/fmt/png/Retaliate-2-Sneakers-Kids',100,15,1,2,3),
(N'Rider FV Future Vintage Sneakers Youth','https://images.puma.com/image/upload/f_auto,q_auto…BR/fmt/png/Rider-FV-Future-Vintage-Sneakers-Youth',100,10,1,2,3),

(N'Nike ACG Air Zoom Gaiadome GORE-TEX','https://static.nike.com/a/images/c_limit,w_592,f_a…c/acg-air-zoom-gaiadome-gore-tex-shoes-2t1Qbv.png',250,5,1,1,1),
(N'Jordan Max Aura 4','https://static.nike.com/a/images/c_limit,w_592,f_a…e-08856ed76f78/jordan-max-aura-4-shoes-cKMcXJ.png',230,9,1,1,1),
(N'Nike Go FlyEase','https://static.nike.com/a/images/c_limit,w_592,f_a…08a924b78/go-flyease-easy-on-off-shoes-3svRCL.png',190,10,1,1,1),
(N'Slipstream Leather Sneakers','https://images.puma.com/image/upload/f_auto,q_auto…/sv01/fnd/GBR/fmt/png/Slipstream-Leather-Sneakers',110,10,1,2,1),
(N'RS-X Efekt PRM Sneakers','https://images.puma.com/image/upload/f_auto,q_auto…6/09/sv01/fnd/GBR/fmt/png/RS-X-Efekt-PRM-Sneakers',100,10,1,2,1),

(N'Sustainnable Materials','https://static.nike.com/a/images/c_limit,w_592,f_a…uperrep-4-next-nature-hiit-class-shoes-vL8WXL.png',100,10,1,1,2),
(N'Bestseller','https://static.nike.com/a/images/c_limit,w_592,f_a…a05b-3124ece1962c/icon-classic-sandals-Jrc3kN.png',150,10,1,1,2),
(N'RS-X Efekt PRM Sneakers','https://images.puma.com/image/upload/f_auto,q_auto…6/03/sv01/fnd/GBR/fmt/png/RS-X-Efekt-PRM-Sneakers',200,4,1,2,2),
(N'Cassia Via Sneakers Women','https://images.puma.com/image/upload/f_auto,q_auto…03/sv01/fnd/GBR/fmt/png/Cassia-Via-Sneakers-Women',230,9,1,2,2),
(N'Mayze Stack Sneakers Women','https://images.puma.com/image/upload/f_auto,q_auto…3/sv01/fnd/GBR/fmt/png/Mayze-Stack-Sneakers-Women',200,15,1,2,2);

insert into Products(Name,ImageLink,Price,InStock,IsAvailable,BrandId,CategoryId)
values('OZWEEGO SHOES','https://assets.adidas.com/images/w_383,h_383,f_auto,q_auto,fl_lossy,c_fill,g_auto/59b4f21d63de4245aa8bacb600b23e52_9366/ozweego-shoes.jpg',120,10,0,3,1),
('ZX 22 BOOST SHOES','https://assets.adidas.com/images/w_383,h_383,f_auto,q_auto,fl_lossy,c_fill,g_auto/b9d626560aad4dcba170af0e011e1899_9366/zx-22-boost-shoes.jpg',110,12,1,3,1),
('SUPERSTAR SHOES','https://assets.adidas.com/images/w_383,h_383,f_auto,q_auto,fl_lossy,c_fill,g_auto/f112bd38aab24636aa55aae700d35989_9366/superstar-shoes.jpg',100,12,0,3,1),
('STAN SMITH SHOES','https://assets.adidas.com/images/w_383,h_383,f_auto,q_auto,fl_lossy,c_fill,g_auto/46227649bd0f44b9b71caf5b01373a67_9366/stan-smith-shoes.jpg',210,12,1,3,1),
('GAZELLE SHOES','https://assets.adidas.com/images/w_383,h_383,f_auto,q_auto,fl_lossy,c_fill,g_auto/7b66dec9de06441aae52a60501798199_9366/gazelle-shoes.jpg',240,12,0,3,1),

('STAN SMITH SHOES','https://assets.adidas.com/images/w_383,h_383,f_auto,q_auto,fl_lossy,c_fill,g_auto/e89688e79f594923a505af7900c0e974_9366/stan-smith-shoes.jpg',150,12,1,3,2),
('SUPERSTAR SHOES','https://assets.adidas.com/images/w_383,h_383,f_auto,q_auto,fl_lossy,c_fill,g_auto/ea1a71e380aa4e2b8542af9c011def1d_9366/superstar-shoes.jpg',180,12,0,3,2),
('FORUM BONEGA SHOES','https://assets.adidas.com/images/w_383,h_383,f_auto,q_auto,fl_lossy,c_fill,g_auto/c0e2ad3b48f94842bfe5af9b00f92b49_9366/forum-bonega-shoes.jpg',210,16,1,3,2),
('ZX 9020 SHOES','https://assets.adidas.com/images/w_383,h_383,f_auto,q_auto,fl_lossy,c_fill,g_auto/051b40523f15428199b5af5c014074c4_9366/zx-9020-shoes.jpg',410,12,0,3,2),
('NIZZA PLATFORM SHOES','https://assets.adidas.com/images/w_383,h_383,f_auto,q_auto,fl_lossy,c_fill,g_auto/82dde22969f345e5aaa9abeb000f2e3d_9366/nizza-platform-shoes.jpg',240,17,1,3,2),

('TENSAUR RUN SHOES','https://assets.adidas.com/images/w_383,h_383,f_auto,q_auto,fl_lossy,c_fill,g_auto/c90d792d79a0406e89afad6e007a25ee_9366/tensaur-run-shoes.jpg',240,16,1,3,3),
('TENSAUR SPORT TRAINING LACE SHOES','https://assets.adidas.com/images/w_383,h_383,f_auto,q_auto,fl_lossy,c_fill,g_auto/647c700ff8bd4aec99f2ae8c01720810_9366/tensaur-sport-training-lace-shoes.jpg',140,14,0,3,3),
('TENSAUR RUN SHOES','https://assets.adidas.com/images/w_383,h_383,f_auto,q_auto,fl_lossy,c_fill,g_auto/da1f0cf300a240e19b13ad79008b439c_9366/tensaur-run-shoes.jpg',340,21,1,3,3),
('TENSAUR HOOK AND LOOP SHOES','https://assets.adidas.com/images/w_383,h_383,f_auto,q_auto,fl_lossy,c_fill,g_auto/1c52375ddc5e4358844eae9200ddb84f_9366/tensaur-hook-and-loop-shoes.jpg',160,13,0,3,3),
('SUPERSTAR SHOES','https://assets.adidas.com/images/w_383,h_383,f_auto,q_auto,fl_lossy,c_fill,g_auto/91c427ef509e464e8dffab030135c7b0_9366/superstar-shoes.jpg',250,17,1,3,3);