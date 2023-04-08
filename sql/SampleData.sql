insert into [Brands](Name) values('Nike'),('Puma'),('Addidas');
insert into [Categories](Name) values('Men'),('Women'),('Kid');

insert into Products(Name,ImageLink,Price,InStock,IsAvailable,BrandId,CategoryId)
values(N'Nike Force 1 Low ASW','https://static.nike.com/a/images/c_limit,w_592,f_auto/t_product_v1/1cda356d-09f0-402f-92d7-e41e9a57b0fc/dunk-low-older-shoes-1b2qSK.png',200,2,1,1,3),
(N'Nike Air Max 270 GO','https://static.nike.com/a/images/c_limit,w_592,f_auto/t_product_v1/4c96ea9f-ca01-4697-bfd3-187ab4432c93/air-max-270-go-older-easy-on-off-shoes-dlD632.png',100,10,1,1,3),
(N'Nike Air Max 90 LTR SE','https://static.nike.com/a/images/c_limit,w_592,f_auto/t_product_v1/53682b53-52a1-44de-9b55-a7e1b8eb37e6/court-borough-low-2-older-shoes-chDVgV.png',150,12,1,1,3),
(N'Retaliate 2 Sneakers Kids','https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_350,h_350/global/392737/01/sv01/fnd/PNA/fmt/png/RS-TRCK-Vacay-Queen-Big-KIds''-Sneakers',100,15,1,2,3),
(N'Rider FV Future Vintage Sneakers Youth','https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_350,h_350/global/380560/05/sv01/fnd/PNA/fmt/png/Suede-Classic-XXI-Sneakers-Big-Kids',100,10,1,2,3),

(N'Nike ACG Air Zoom Gaiadome GORE-TEX','https://static.nike.com/a/images/c_limit,w_592,f_auto/t_product_v1/16146248-1627-4300-bbd9-77f7a00f6ed6/air-jordan-xxxvii-low-pf-basketball-shoes-7z7ltC.png',250,5,1,1,1),
(N'Jordan Max Aura 4','https://static.nike.com/a/images/c_limit,w_592,f_auto/t_product_v1/9b0a3ee6-843c-4303-ba08-8bebfcd9b4e1/jordan-why-not-6-pf-shoes-Bsggwn.png',230,9,1,1,1),
(N'Nike Go FlyEase','https://static.nike.com/a/images/c_limit,w_592,f_auto/t_product_v1/cef1c1e1-8e83-4a1c-9202-8c60bd221a76/air-jordan-1-mid-se-craft-shoes-RmP7J6.png',190,10,1,1,1),
(N'Slipstream Leather Sneakers','https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_500,h_500/global/389277/01/sv01/fnd/PNA/fmt/png/Suede-Camowave-Sneakers',110,10,1,2,1),
(N'RS-X Efekt PRM Sneakers','https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_500,h_500/global/374915/05/sv01/fnd/PNA/fmt/png/Suede-Classic-XXI-Sneakers',100,10,1,2,1),

(N'Sustainnable Materials','https://static.nike.com/a/images/c_limit,w_592,f_auto/t_product_v1/a434379e-98ac-4b7a-bb31-5b179e9a010b/metcon-8-amp-training-shoes-cZ5hVh.png',100,10,1,1,2),
(N'Bestseller','https://static.nike.com/a/images/c_limit,w_592,f_auto/t_product_v1/b38395a0-3d85-4bfe-b897-14717ba923ae/nikecourt-legacy-next-nature-shoes-rdTfqH.png',150,10,1,1,2),
(N'RS-X Efekt PRM Sneakers','https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_350,h_350/global/389267/03/sv01/fnd/PNA/fmt/png/PUMA-180-Sneakers',200,4,1,2,2),
(N'Cassia Via Sneakers Women','https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_350,h_350/global/389873/02/sv01/fnd/PNA/fmt/png/Cali-Dream-Camo-Women''s-Sneakers',230,9,1,2,2),
(N'Mayze Stack Sneakers Women','https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_350,h_350/global/307624/02/sv01/fnd/PNA/fmt/png/BMW-M-Motorsport-TRC-Mira-Tech-Motorsport-Women''s-Shoes',200,15,1,2,2);

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