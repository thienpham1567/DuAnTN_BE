CREATE TABLE [OrderAddresses] (
  [OrderAddressId] int,
  [Address] nvarchar(255),
  [Ward] nvarchar(50),
  [District] nvarchar(50),
  [PhoneNumber] int,
  PRIMARY KEY ([OrderAddressId])
);

ALTER TABLE [Orders] ADD OrderAddressId int;

ALTER TABLE Orders ADD CONSTRAINT FK_Order_OrderAddress FOREIGN KEY (OrderAddressId) REFERENCES OrderAddresses(OrderAddressId);

ALTER TABLE Orders DROP COLUMN OrderAddress;