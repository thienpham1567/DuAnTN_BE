CREATE TABLE [Categories] (
  [CategoryId] int IDENTITY(1,1),
  [Description] nvarchar(255),
  [Code] nvarchar(255),
  PRIMARY KEY ([CategoryId])
);

CREATE TABLE [Brands] (
  [BrandId] int IDENTITY(1,1),
  [Name] nvarchar(255),
  PRIMARY KEY ([BrandId])
);

CREATE TABLE [Products] (
  [ProductId] int IDENTITY(1,1),
  [Name] nvarchar(255) NOT NULL,
  [ImageLink] varchar(max) NOT NULL,
  [Price] decimal(10,2) NOT NULL,
  [InStock] int NOT NULL,
  [Created] datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  [IsAvailable] bit NOT NULL,
  [BrandId] int,
  [CategoryId] int,
  PRIMARY KEY ([ProductId]),
  CONSTRAINT [FK_Products.CategoryId] FOREIGN KEY ([CategoryId]) REFERENCES [Categories]([CategoryId]),
  CONSTRAINT [FK_Products.BrandId] FOREIGN KEY ([BrandId]) REFERENCES [Brands]([BrandId])
);

CREATE TABLE [Users] (
  [UserId] int IDENTITY(1,1),
  [Password] varchar(255) NOT NULL,
  [FirstName] nvarchar(255) NOT NULL,
  [MiddleName] nvarchar(255) NOT NULL,
  [LastName] nvarchar(255) NOT NULL,
  [Email] varchar(255) NOT NULL,
  [UserAddress] nvarchar(max),
  [IsActive] bit NOT NULL DEFAULT (0),
  PRIMARY KEY ([UserId])
);

CREATE TABLE [Orders] (
  [OrderId] int IDENTITY(1,1),
  [OrderAddress] nvarchar(255) NOT NULL,
  [Created] datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  [Updated] datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  [OrderAmount] decimal(11,2) NOT NULL,
  [UserId] int,
  [OrdersStatusId] int,
  PRIMARY KEY ([OrderId]),
  CONSTRAINT [FK_Orders.UserId] FOREIGN KEY ([UserId]) REFERENCES [Users]([UserId])
);

CREATE TABLE [OrderDetails] (
  [OrderDetailId] int IDENTITY(1,1),
  [DetailPrice] decimal(11,2) NOT NULL,
  [Quantity] int NOT NULL,
  [OrderId] int,
  [ProductId] int,
  PRIMARY KEY ([OrderDetailId]),
  CONSTRAINT [FK_OrderDetails.ProductId] FOREIGN KEY ([ProductId]) REFERENCES [Products]([ProductId]),
  CONSTRAINT [FK_OrderDetails.OrderId] FOREIGN KEY ([OrderId]) REFERENCES [Orders]([OrderId])
);

CREATE TABLE [Roles] (
  [RoleId] int IDENTITY(1,1),
  [Description] nvarchar(255) NOT NULL,
  [Code] nvarchar(255) NOT NULL,
  PRIMARY KEY ([RoleId])
);

CREATE TABLE [UserRoles] (
  [UserRoleId] int IDENTITY(1,1),
  [UserId] int,
  [RoleId] int,
  PRIMARY KEY ([UserRoleId]),
  CONSTRAINT [FK_UserRoles.UserId] FOREIGN KEY ([UserId]) REFERENCES [Users]([UserId]),
  CONSTRAINT [FK_UserRoles.RoleId] FOREIGN KEY ([RoleId]) REFERENCES [Roles]([RoleId])
);

CREATE TABLE [OrderStatus] (
  [OrderStatusId] int IDENTITY(1,1),
  [Description] nvarchar(255) NOT NULL,
  PRIMARY KEY ([OrderStatusId])
);

