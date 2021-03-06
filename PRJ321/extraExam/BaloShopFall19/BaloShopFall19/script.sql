CREATE DATABASE [baloshop]

USE [baloshop]

CREATE TABLE [category](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[category] [nvarchar](200) NULL,
	[status] [int] NULL,
	primary key (id)
)


CREATE TABLE [image](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[product_id] [int] NULL,
	[image_name] [nvarchar](200) NULL,
	[status] [int] NULL,
	primary key (id)
)


CREATE TABLE [product](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[category_id] [int] NULL,
	[code] [nvarchar](50) NULL,
	[name] [nvarchar](200) NULL,
	[quantity] [int] NULL,
	[price] [float] NULL,
	[description] [nvarchar](2000) NULL,
	[image] [nvarchar](100) NULL,
	[create_date] [date] default getdate(),
	[status] [int] NULL,
	primary key (id)
)


CREATE TABLE [status_product](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[code] [int] NULL,
	[status] [nvarchar](100) NULL,
	primary key (id)
)


INSERT INTO category (category, status) VALUES (N'Balo', 1);
INSERT INTO category (category, status) VALUES (N'Túi tote', 1);
INSERT INTO category (category, status) VALUES (N'Túi bao tử', 1);
INSERT INTO category (category, status) VALUES (N'Túi đeo vai', 1);
INSERT INTO category (category, status) VALUES (N'Túi văn phòng', 1);


INSERT INTO product (category_id, code, name, quantity, price, description, image, status) VALUES (1, 'BL-001', N'SOLDIER GREEN/TAN', 10, 2000000, N'Balo vải bố dày có quai và đáy làm bằng da bò tự nhiên.<br>Một ngăn dây kéo lớn mặt trước.<br>Một ngăn dây kéo hông phải, 1 túi đắp hông trái.<br>Một ngăn dây kéo bên trong và 2 túi nhỏ.', N'soldier-green-tan.jpg', 1);
INSERT INTO product (category_id, code, name, quantity, price, description, image, status) VALUES (1, 'BL-002', N'TRAVELLER BLACK/SAND', 10, 1499000, N'Balo vải bố dày có quai và đáy làm bằng da bò tự nhiên.<br>Một ngăn dây kéo lớn mặt trước.<br>Một ngăn dây kéo hông phải,<br>Một ngăn túi đắp có đệm phía sau.<br>Ngăn chính có 1 ngăn chống sốc cho laptop 15''- 17''.<br>Một ngăn dây kéo bên trong và 2 túi nhỏ.<br>Khoá bấm kim loại chất lượng cao.<br>Dây kéo YKK, đầu kéo bằng da bò.<br>Vải bố dày, không xù lông.<br>Có khả năng chống thấm nước. Bảo hành 1 năm.', N'traveller-black-sand.jpg', 1);
INSERT INTO product (category_id, code, name, quantity, price, description, image, status) VALUES (1, 'BL-003', N'SOLDIER CARA/BLACK', 10, 2200000, N'Balo vải bố dày có quai và đáy làm bằng da bò tự nhiên.<br>Một ngăn dây kéo lớn mặt trước.<br>Một ngăn dây kéo hông phải, 1 túi đắp hông trái.<br>Một ngăn dây kéo bên trong và 2 túi nhỏ.', N'soldier-cara-black.jpg', 1);
INSERT INTO product (category_id, code, name, quantity, price, description, image, status) VALUES (1, 'BL-004', N'SOLDIER JET/BLACK', 10, 2200000, N'Balo vải bố dày có quai và đáy làm bằng da bò tự nhiên.<br>Một ngăn dây kéo lớn mặt trước.<br>Một ngăn dây kéo hông phải, 1 túi đắp hông trái.<br>Một ngăn dây kéo bên trong và 2 túi nhỏ.', N'soldier-jet-black.jpg', 2);
INSERT INTO product (category_id, code, name, quantity, price, description, image, status) VALUES (1, 'BL-005', N'HIRO NAVY/BLACK', 10, 2200000, N'Balo vải bố dày có quai và đáy làm bằng da bò tự nhiên.<br>Một ngăn dây kéo lớn mặt trước.<br>Một ngăn dây kéo hông phải, 1 túi đắp hông trái.<br>Một ngăn dây kéo bên trong và 2 túi nhỏ.', N'hiro-navy-black.jpg', 1);
INSERT INTO product (category_id, code, name, quantity, price, description, image, status) VALUES (1, 'BL-006', N'HIRO RED/BEIGE', 10, 2200000, N'Balo vải bố dày có quai và đáy làm bằng da bò tự nhiên.<br>Một ngăn dây kéo lớn mặt trước.<br>Một ngăn dây kéo hông phải, 1 túi đắp hông trái.<br>Một ngăn dây kéo bên trong và 2 túi nhỏ.', N'hiro-red-beige.jpg', 1);
INSERT INTO product (category_id, code, name, quantity, price, description, image, status) VALUES (1, 'BL-007', N'TRAVELLER GREEN/BEIGE', 10, 1234000, N'Balo vải bố dày có quai và đáy làm bằng da bò tự nhiên.<br>Một ngăn dây kéo lớn mặt trước.<br>Một ngăn dây kéo hông phải, 1 túi đắp hông trái.<br>Một ngăn dây kéo bên trong và 2 túi nhỏ.', N'traveller-green-beige.jpg', 2);
INSERT INTO product (category_id, code, name, quantity, price, description, image, status) VALUES (1, 'BL-008', N'TRAVELLER NAVY/BEIGE', 10, 1234000, N'Balo vải bố dày có quai và đáy làm bằng da bò tự nhiên.<br>Một ngăn dây kéo lớn mặt trước.<br>Một ngăn dây kéo hông phải, 1 túi đắp hông trái.<br>Một ngăn dây kéo bên trong và 2 túi nhỏ.', N'traveller-navy-beige.jpg', 1);
INSERT INTO product (category_id, code, name, quantity, price, description, image, status) VALUES (2, 'BL-009', N'MAX GREEN/TAN', 12, 750000, N'Hoàn hảo cho các hoạt động hằng ngày.<br>Quai đeo da bò tự nhiên, một ngăn dây kéo mặt trước.<br>Một túi nhỏ bên trong.', N'max-green-tan.jpg', 2);
INSERT INTO product (category_id, code, name, quantity, price, description, image, status) VALUES (2, 'BL-010', N'MAX RED', 12, 750000, N'Hoàn hảo cho các hoạt động hằng ngày.<br>Quai đeo da bò tự nhiên, một ngăn dây kéo mặt trước.<br>Một túi nhỏ bên trong.', N'max-red.jpg', 1);
INSERT INTO product (category_id, code, name, quantity, price, description, image, status) VALUES (3, 'BL-011', N'KIRA RED/BEIGE', 13, 850000, N'Một ngăn dây kéo mặt trước.<br>Ngăn chính có 1 ngăn dây kéo bên trong.<br>Dây đeo bằng cotton, khoá nhựa chất lượng cao.<br>Có khả năng chống thấm nước.<br>Bảo hành 1 năm.', N'kira-red-beige.jpg', 2);
INSERT INTO product (category_id, code, name, quantity, price, description, image, status) VALUES (3, 'BL-012', N'KIRA BLACK/TAN', 13, 850000, N'Một ngăn dây kéo mặt trước.<br>Ngăn chính có 1 ngăn dây kéo bên trong.<br>Dây đeo bằng cotton, khoá nhựa chất lượng cao.<br>Có khả năng chống thấm nước.<br>Bảo hành 1 năm.', N'kira-black-tan.jpg', 1);
INSERT INTO product (category_id, code, name, quantity, price, description, image, status) VALUES (4, 'BL-013', N'BASTILLE COBALT', 14, 1000000, N'Balo vải bố dày có quai và đáy làm bằng da bò tự nhiên.<br>Một ngăn dây kéo lớn mặt trước.<br>Một ngăn dây kéo hông phải, 1 túi đắp hông trái.<br>Một ngăn dây kéo bên trong và 2 túi nhỏ.', N'bastille-cobalt.jpg', 1);
INSERT INTO product (category_id, code, name, quantity, price, description, image, status) VALUES (4, 'BL-014', N'BENJI AIRY/RED', 14, 1000000, N'Balo vải bố dày có quai và đáy làm bằng da bò tự nhiên.<br>Một ngăn dây kéo lớn mặt trước.<br>Một ngăn dây kéo hông phải, 1 túi đắp hông trái.<br>Một ngăn dây kéo bên trong và 2 túi nhỏ.', N'benji-airy-red.jpg', 2);


INSERT INTO status_product (code, status) VALUES (1, N'Còn hàng');
INSERT INTO status_product (code, status) VALUES (2, N'Giảm giá');
INSERT INTO status_product (code, status) VALUES (3, N'Hết hàng');
INSERT INTO status_product (code, status) VALUES (4, N'Ngừng kinh doanh');