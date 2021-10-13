INSERT INTO `location`(`name`,`country`, `city`,`state`, `street`,`number`,`coordinate`, `zip_code`,`number_available_cars`) VALUES
('LVIV AIRPORT','UA','Lviv','','Liubinska Str.','168','2421-4214-5513-543','53523',2),
('Main Train Station','UA','Lviv','','Lvivsky region','','42-2444-3234-543','34525',2),
('KIEV ZHULIANY AIRPORT','UA','KIEV','','Medova','2','42-24344-3234-543','53553',4),
('KIEV BORYSPIL AIRPORT','UA','KIEV','','Borispol','7','42-2444-53555-543','55354',3),
('KIEV/INTERCONTINENTAL','UA','KIEV','','Velyka Zhytomyrska','2a','123-4244-444-543','34420',5),
('KIEV/HYATT REGENCY','UA','KIEV','','Alla Tarasova Str','5','123-33-41244-331','42440',3),
('KIEV DMYTRIVSKA STR','UA','KIEV','','Dmytrivska Str.','46','123-32213-3453-3321','42440',3),
('KIEV/HILTON HOTEL','UA','KIEV','','Tarasa Shavchenka Av','30','121223-313-2222-1233','41244',3);


INSERT INTO `security`(`login`,`password`) VALUES
('Pearce@gmail.com','password'),
('Whiteley@gmail.com','password'),
('Mckeown@gmail.com','password'),
('Montoya@gmail.com','password'),
('Thomas@gmail.com','password'),
('Williamson@gmail.com','password'),
('Murillo@gmail.com','password'),
('Andrews@gmail.com','password'),
('Wolf@gmail.com','password'),
('Ryder@gmail.com','password');

INSERT INTO `user`(`first_name`,`last_name`, `identity_document`,`driver_license`, `mail`,`phone_number`,`payment_card`, `security_login`) VALUES
('Carol','Pearce','2144400023','5595900032','Pearce1@gmail.com','094824842','939329394923','Pearce@gmail.com'),
('Mateo','Whiteley','424343424','45546456456','Whiteley1@gmail.com','0436436436','463464666','Whiteley@gmail.com'),
('Musab','Mckeown','3424343434','4565467377','Mckeown1@gmail.com','078858757','4636436436','Mckeown@gmail.com'),
('Najma','Montoya','32455236','367457457','Montoya1@gmail.com','0648747664','3466436346','Montoya@gmail.com'),
('Tomi','Thomas','2345235623','3426463573','Thomas1@gmail.com','0736565755','34664646446','Thomas@gmail.com'),
('Kimberly','Williamson','235643444','4436667737','Williamson1@gmail.com','098654373','3523525325','Williamson@gmail.com'),
('Avi','Murillo','2343243245','3466436444','Murillo1@gmail.com','0357563755','235532535','Murillo@gmail.com'),
('Huseyin','Andrews','2355765856','36773848884','Andrews1@gmail.com','0427575755','23535235325','Andrews@gmail.com'),
('Aisha','Wolf','4577658656','3646565555','Wolf1@gmail.com','068477474','35256662','Wolf@gmail.com'),
('Ayden','Ryder','367563766','364666643','Ryder1@gmail.com','0347667676','34325532535253','Ryder@gmail.com');

INSERT INTO `fine`(`type_of_fine`,`date`, `user_id`) VALUES
('speeding','12.10.2021',2),
('using a mobile phone while driving','10.10.2021',3),
('not wearing a seat belt','09.10.2021',6),
('not indicating when turning a corner','08.10.2021',5),
('stopping within ten metres of an intersection','12.10.2021',4),
('driving an unregistered car','11.10.2021',1),
('driving through a red light.','10.10.2021',5);


INSERT INTO `location_has_user`(`location_id`, `user_id`) VALUES
(2,2),
(4,5),
(2,1),
(1,3),
(3,4),
(5,6),
(7,7),
(8,8),
(3,9),
(1,10);

INSERT INTO `car`(`name`, `car_body_style`,`price_for_day`,`seats`,`doors`,`gearbox_type`,`accessible`,`date_take`,`to_pay`,`location_id`) VALUES
('VW POLO',' Sedan',64.85,5,4,'Manual',1,0,0,2),
('RENAULT LOGAN',' Sedan',50.00,5,4,'Aut',1,0,0,3),
('FORD KUGA',' Station wagon',57.05,5,4,'Aut',1,0,0,4),
('TOYOTA COROLLA',' Sedan',49.85,5,4,'Manual',1,0,0,2),
('TOYOTA CAMRY',' Premium SUV',30.85,5,4,'Aut',1,0,0,6),
('AUDI Q3',' Station wagon',50.85,5,4,'Manual',1,0,0,6),
('TOYOTA LAND CRUISER PRADO',' Premium SUV',64.85,5,4,'Aut',1,0,0,8),
('AUDI Q8',' Premium SUV',80.85,5,4,'Manual',1,0,0,8);
