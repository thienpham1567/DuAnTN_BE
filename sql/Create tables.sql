--- Create 1
CREATE TABLE [Users] (
  [UserId] int PRIMARY KEY IDENTITY(1,1),
  [Password] varchar(255) NOT NULL,
  [FirstName] nvarchar(255),
  [LastName] nvarchar(255),
  [EmailAddress] varchar(max) NOT NULL,
  [PhoneNumber] varchar(max),
);

CREATE TABLE [Colors] (
  [ColorId] int PRIMARY KEY IDENTITY(1,1),
  [Value] varchar(50) NOT NULL,
);

CREATE TABLE [Provinces] (
  [ProvinceId] int PRIMARY KEY IDENTITY(1,1),
  [Name] nvarchar(255) NOT NULL,
  [Code] varchar(10) NOT NULL,
);

CREATE TABLE [Brands] (
  [BrandId] int PRIMARY KEY IDENTITY(1,1),
  [Name] nvarchar(255) NOT NULL,
);

CREATE TABLE [Categories] (
  [CategoryId] int PRIMARY KEY IDENTITY(1,1),
  [ParentCategoryId] int,
  [Name] varchar(255) NOT NULL,
  CONSTRAINT [FK_Categories.ParentCategoryId] FOREIGN KEY ([ParentCategoryId]) REFERENCES [Categories]([CategoryId])
);

CREATE TABLE [Carts] (
  [CartId] char(255) PRIMARY KEY,
  [ItemTotalQuantity] int,
  [ItemSubtotalPrice] decimal(11,2),
);

CREATE TABLE [Roles] (
  [RoleId] int PRIMARY KEY IDENTITY(1,1), 
  [Description] nvarchar(255),
  [Code] nvarchar(255),
);

--- Create 2
CREATE TABLE [Orders] (
  [OrderId] char(255) PRIMARY KEY,
  [UserId] int,
  [CreatedAt] datetime DEFAULT CURRENT_TIMESTAMP,
  [UpdatedAt] datetime DEFAULT CURRENT_TIMESTAMP,
  [denormalizedAddress] varchar(max) NOT NULL,
  [OrderTotalPrice] decimal(11,2),
  [OrdersStatus] varchar(max),
  [OrderAddress] nvarchar(max),
  CONSTRAINT [FK_Orders.UserId] FOREIGN KEY ([UserId]) REFERENCES [Users]([UserId])
);

CREATE TABLE [Districts] (
  [DistrictId] int PRIMARY KEY IDENTITY(1,1),
  [ProvinceId] int,
  [Name] nvarchar(255) NOT NULL,
  [Prefix] nvarchar(50),
  CONSTRAINT [FK_Districts.ProvinceId] FOREIGN KEY ([ProvinceId]) REFERENCES [Provinces]([ProvinceId])
);

CREATE TABLE [Wards] (
  [WardId] int PRIMARY KEY IDENTITY(1,1),
  [DistrictId] int,
  [ProvinceId] int,
  [Name] int NOT NULL,
  [Prefix] nvarchar(50),
  CONSTRAINT [FK_Wards.ProvinceId] FOREIGN KEY ([ProvinceId]) REFERENCES [Provinces]([ProvinceId]),
  CONSTRAINT [FK_Wards.DistrictId]FOREIGN KEY ([DistrictId]) REFERENCES [Districts]([DistrictId])
);

CREATE TABLE [Address] (
  [AddressId] int PRIMARY KEY IDENTITY(1,1),
  [Address] nvarchar(255),
  [WardId] int,
  CONSTRAINT [FK_Address.Ward] FOREIGN KEY ([WardId]) REFERENCES [Wards]([WardId])
);

CREATE TABLE [UserAddress] (
  [UserAddressId] int PRIMARY KEY IDENTITY(1,1),
  [UserId] int,
  [AddressId] int,
  [IsDefault] bit NOT NULL DEFAULT (0),
  CONSTRAINT [FK_UserAddress.AddressId] FOREIGN KEY ([AddressId]) REFERENCES [Address]([AddressId]),
  CONSTRAINT [FK_UserAddress.UserId] FOREIGN KEY ([UserId]) REFERENCES [Users]([UserId])
);

CREATE TABLE [Products] (
  [ProductId] int PRIMARY KEY IDENTITY(1,1),
  [BrandId] int,
  [CategoryID] int,
  [Name] nvarchar(255) NOT NULL,
  [Description] varchar(max),
  [CreatedAt] datetime DEFAULT CURRENT_TIMESTAMP,
  [UpdateAt] datetime DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT [FK_Products.BrandId] FOREIGN KEY ([BrandId]) REFERENCES [Brands]([BrandId]),
  CONSTRAINT [FK_Products.CategoryID] FOREIGN KEY ([CategoryID]) REFERENCES [Categories]([CategoryId])
);

CREATE TABLE [Sizes] (
  [SizeId] int PRIMARY KEY IDENTITY(1,1),
  [CategoryId] int,
  [Value] varchar(10) NOT NULL,
  CONSTRAINT [FK_Size.CategoryId] FOREIGN KEY ([CategoryId]) REFERENCES [Categories]([CategoryId])
);

CREATE TABLE [ProductItems] (
  [ProductItemId] int PRIMARY KEY IDENTITY(1,1),
  [ProductId] int,
  [ColorId] int,
  [SizeId] int,
  [SKU] varchar(255),
  [Price] decimal(10,2),
  [QuantityInStock] int,
  [ImageUrl] varchar(max),
  [Status] nvarchar(50),
  CONSTRAINT [FK_ProductItems.ProductId] FOREIGN KEY ([ProductId]) REFERENCES [Products]([ProductId]),
  CONSTRAINT [FK_ProductItems.SizeId] FOREIGN KEY ([SizeId]) REFERENCES [Sizes]([SizeId]),
  CONSTRAINT [FK_ProductItems.ColorId] FOREIGN KEY ([ColorId]) REFERENCES [Colors]([ColorId])
);

CREATE TABLE [UserRoles] (
  [UserRoleId] int PRIMARY KEY IDENTITY(1,1), 
  [UserId] int,
  [RoleId] int,
  CONSTRAINT [FK_UserRoles.RoleId] FOREIGN KEY ([RoleId]) REFERENCES [Roles]([RoleId]),
  CONSTRAINT [FK_UserRoles.UserId] FOREIGN KEY ([UserId]) REFERENCES [Users]([UserId])
);

CREATE TABLE [CartItems] (
  [CartItemId] int PRIMARY KEY IDENTITY(1,1),
  [ProductItemId] int,
  [CartId] char(255),
  [Price] decimal(11,2),
  [Quantity] int,
  CONSTRAINT [FK_CartItems.CartId] FOREIGN KEY ([CartId]) REFERENCES [Carts]([CartId]),
  CONSTRAINT [FK_CartItems.ProductItemId] FOREIGN KEY ([ProductItemId]) REFERENCES [ProductItems]([ProductItemId])
);

CREATE TABLE [OrderLines] (
  [OrderLineId] int PRIMARY KEY IDENTITY(1,1),
  [ProductItemId] int,
  [OrderId] char(255),
  [Price] decimal(11,2),
  [Quantity] int,
  CONSTRAINT [FK_OrderLines.OrderId] FOREIGN KEY ([OrderId]) REFERENCES [Orders]([OrderId]),
  CONSTRAINT [FK_OrderLines.ProductItemId] FOREIGN KEY ([ProductItemId]) REFERENCES [ProductItems]([ProductItemId])
);

CREATE TABLE [Reviews] (
  [ReviewId] int PRIMARY KEY IDENTITY(1,1),
  [OrderedProductId] int,
  [UserId] int,
  [RateValue] int,
  [Comment] nvarchar(255),
  CONSTRAINT [FK_Reviews.OrderedProductId] FOREIGN KEY ([OrderedProductId]) REFERENCES [OrderLines]([OrderLineId]),
  CONSTRAINT [FK_Reviews.UserId] FOREIGN KEY ([UserId]) REFERENCES [Users]([UserId])
);