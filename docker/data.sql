CREATE DATABASE IF NOT EXISTS `beautyproducts`;

USE `beautyproducts`;

-- Drop existing tables if they exist
DROP TABLE IF EXISTS `Brand`;
DROP TABLE IF EXISTS `Category`;
DROP TABLE IF EXISTS `Product`;

-- Create the Brand table
CREATE TABLE `Brand` (
                         `Id` INT AUTO_INCREMENT PRIMARY KEY,
                         `Name` VARCHAR(255) NOT NULL
);

-- Insert data into the Brand table
INSERT INTO `Brand` (`Name`) VALUES
                                 ('L''Oréal'),
                                 ('Estée Lauder'),
                                 ('Sephora'),
                                 ('Clinique'),
                                 ('Neutrogena'),
                                 ('MAC'),
                                 ('Dove');

-- Create the Category table
CREATE TABLE `Category` (
                            `Id` INT AUTO_INCREMENT PRIMARY KEY,
                            `Name` VARCHAR(255) NOT NULL
);

-- Insert data into the Category table for beauty product categories
INSERT INTO `Category` (`Name`) VALUES
                                    ('Skincare'),
                                    ('Hair Care'),
                                    ('Makeup');

-- Create the Product table
CREATE TABLE `Product` (
                           `Id` INT AUTO_INCREMENT PRIMARY KEY,
                           `Name` VARCHAR(255) NOT NULL,
                           `Description` TEXT,
                           `Price` DECIMAL(10, 2) NOT NULL,
                           `PictureUrl` VARCHAR(255),
                           `ProductCategoryId` INT NOT NULL,
                           `ProductBrandId` INT NOT NULL,
                           FOREIGN KEY (`ProductCategoryId`) REFERENCES `Category`(`Id`),
                           FOREIGN KEY (`ProductBrandId`) REFERENCES `Brand`(`Id`)
);

-- Insert data into the Product table with sample beauty products
INSERT INTO `Product` (`Name`, `Description`, `Price`, `PictureUrl`, `ProductCategoryId`, `ProductBrandId`) VALUES
                                                                                                                ('L''Oréal Revitalift Moisturizer', 'Anti-aging face moisturizer for radiant skin', 29.99, 'https://example.com/revitalift.jpg', 1, 1),
                                                                                                                ('Neutrogena Hydro Boost Gel Cream', 'Hydrating face cream for all skin types', 18.50, 'https://example.com/hydroboost.jpg', 1, 5),
                                                                                                                ('MAC Lipstick Ruby Woo', 'Classic matte red lipstick', 19.00, 'https://example.com/rubywoo.jpg', 3, 6),
                                                                                                                ('Dove Nourishing Shampoo', 'Gentle shampoo for all hair types', 12.00, 'https://example.com/doveshampoo.jpg', 2, 7),
                                                                                                                ('Clinique Moisture Surge', 'Lightweight gel-cream moisturizer', 35.00, 'https://example.com/moisturesurge.jpg', 1, 4),
                                                                                                                ('Estée Lauder Double Wear Foundation', 'Long-lasting, flawless coverage foundation', 42.00, 'https://example.com/doublewear.jpg', 3, 2),
                                                                                                                ('Sephora Collection Eyeshadow Palette', 'Multi-color eyeshadow palette for various looks', 25.00, 'https://example.com/eyeshadow.jpg', 3, 3),
                                                                                                                ('L''Oréal Pure Clay Mask', 'Detoxifying face mask with pure clay and charcoal', 10.99, 'https://example.com/pureclaymask.jpg', 1, 1),
                                                                                                                ('Neutrogena Oil-Free Acne Wash', 'Gentle cleanser with salicylic acid for acne-prone skin', 7.50, 'https://example.com/acnewash.jpg', 1, 5),
                                                                                                                ('MAC Studio Fix Foundation', 'Long-wear foundation for a matte finish', 30.00, 'https://example.com/studiofix.jpg', 3, 6),
                                                                                                                ('Dove Intense Repair Conditioner', 'Nourishing conditioner for damaged hair', 8.00, 'https://example.com/repairconditioner.jpg', 2, 7),
                                                                                                                ('Clinique Even Better Serum', 'Brightening serum for dark spots and uneven skin tone', 50.00, 'https://example.com/evenbetter.jpg', 1, 4),
                                                                                                                ('Estée Lauder Advanced Night Repair Serum', 'Anti-aging night serum with hyaluronic acid', 70.00, 'https://example.com/nightrepair.jpg', 1, 2),
                                                                                                                ('Sephora Cream Lip Stain', 'Long-lasting lip stain with a matte finish', 14.00, 'https://example.com/creamlipstain.jpg', 3, 3),
                                                                                                                ('L''Oréal Elvive Total Repair Shampoo', 'Reparative shampoo for damaged hair', 6.99, 'https://example.com/elviveshampoo.jpg', 2, 1),
                                                                                                                ('Neutrogena Rapid Wrinkle Repair Cream', 'Anti-aging cream with retinol for visible wrinkle reduction', 25.00, 'https://example.com/wrinklerepair.jpg', 1, 5),
                                                                                                                ('MAC Prep + Prime Fix+', 'Lightweight water mist to hydrate and refresh skin', 24.00, 'https://example.com/primefix.jpg', 3, 6),
                                                                                                                ('Dove Deep Moisture Body Wash', 'Gentle body wash for soft, nourished skin', 5.50, 'https://example.com/deepmoisture.jpg', 1, 7),
                                                                                                                ('Clinique High Impact Mascara', 'Volumizing mascara for bold lashes', 20.00, 'https://example.com/highimpactmascara.jpg', 3, 4),
                                                                                                                ('Estée Lauder Pure Color Envy Lipstick', 'Sculpting lipstick for high-impact color', 32.00, 'https://example.com/colorenvy.jpg', 3, 2),
                                                                                                                ('Sephora Collection Bright Skin Exfoliator', 'Gentle exfoliating scrub for radiant skin', 15.00, 'https://example.com/brightskin.jpg', 1, 3),
                                                                                                                ('L''Oréal Voluminous Lash Paradise Mascara', 'Lengthening mascara for voluminous lashes', 9.99, 'https://example.com/lashparadise.jpg', 3, 1),
                                                                                                                ('L''Oréal Hyaluronic Acid Serum', 'Hydrating serum with pure hyaluronic acid for plump skin', 23.00, 'https://example.com/hyaluronicserum.jpg', 1, 1),
                                                                                                                ('Neutrogena Clear Face Sunscreen SPF 55', 'Oil-free sunscreen for acne-prone skin', 10.00, 'https://example.com/clearsunscreen.jpg', 1, 5),
                                                                                                                ('MAC Powder Blush', 'Silky blush that provides a natural, flushed look', 25.00, 'https://example.com/powderblush.jpg', 3, 6),
                                                                                                                ('Dove Anti-Frizz Oil Therapy Shampoo', 'Shampoo for frizzy hair with nourishing oils', 6.50, 'https://example.com/antifrizzshampoo.jpg', 2, 7),
                                                                                                                ('Clinique Smart Custom-Repair Serum', 'Serum targeting fine lines, wrinkles, and dullness', 59.00, 'https://example.com/smartrepair.jpg', 1, 4),
                                                                                                                ('Estée Lauder Perfectionist Pro Serum', 'Rapid firming and lifting serum for mature skin', 82.00, 'https://example.com/perfectionistpro.jpg', 1, 2),
                                                                                                                ('Sephora Retractable Brow Pencil', 'Waterproof brow pencil for precise brow definition', 12.00, 'https://example.com/browpencil.jpg', 3, 3),
                                                                                                                ('L''Oréal Elnett Satin Hairspray', 'Long-lasting hairspray with a satin finish', 5.00, 'https://example.com/elnettsatin.jpg', 2, 1),
                                                                                                                ('Neutrogena Deep Clean Facial Cleanser', 'Facial cleanser that removes impurities and excess oil', 7.00, 'https://example.com/deepclean.jpg', 1, 5),
                                                                                                                ('MAC Strobe Cream', 'Moisturizing cream to boost radiance and luminosity', 35.00, 'https://example.com/strobecream.jpg', 3, 6),
                                                                                                                ('Dove Nutritive Solutions Daily Moisture Shampoo', 'Everyday shampoo for soft and smooth hair', 5.99, 'https://example.com/dailymoisture.jpg', 2, 7),
                                                                                                                ('Clinique Take the Day Off Makeup Remover', 'Gentle makeup remover for face, eyes, and lips', 22.00, 'https://example.com/takedayoff.jpg', 1, 4),
                                                                                                                ('Estée Lauder Pure Color Crystal Lipstick', 'Shimmering lipstick for a radiant smile', 30.00, 'https://example.com/colorcrystal.jpg', 3, 2),
                                                                                                                ('Sephora Collection Face Mask', 'Sheet mask for hydrated and glowing skin', 6.00, 'https://example.com/facemask.jpg', 1, 3),
                                                                                                                ('L''Oréal Magic Root Cover Up', 'Temporary root touch-up spray for gray coverage', 9.00, 'https://example.com/magicroot.jpg', 2, 1);
