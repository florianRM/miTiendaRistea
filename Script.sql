CREATE DATABASE CarritoCompra;

CREATE TABLE CarritoCompra.Category 
(
	id VARCHAR(30),
    name VARCHAR(100),
    description VARCHAR(300),
    CONSTRAINT PK_Category PRIMARY KEY(id)
);

CREATE TABLE CarritoCompra.Item
(
	id VARCHAR(30),
    name VARCHAR(100),
    description VARCHAR(300),
    price DECIMAL(5, 2),
    category_id VARCHAR(30),
    img longblob,
    CONSTRAINT PK_Item PRIMARY KEY(id, name),
    CONSTRAINT FK_Item FOREIGN KEY (category_id) REFERENCES CarritoCompra.Category(id)
);

CREATE TABLE CarritoCompra.Users 
(
	username VARCHAR(50),
    password VARCHAR(32),
    name VARCHAR(30),
    last_name VARCHAR(60),
    date_birth DATE,
    gender CHAR(1),
    admin BOOLEAN,
    CONSTRAINT PK_User PRIMARY KEY(username)
);

CREATE TABLE CarritoCompra.Bought
(
    id VARCHAR(30),
    username VARCHAR(50),
	amount INT(6),
    price DECIMAL(4, 2),
    purchase_date DATE,
    CONSTRAINT PK_Bought PRIMARY KEY(id, username),
    CONSTRAINT FK_Bought_Id FOREIGN KEY (id) REFERENCES CarritoCompra.Item(id),
    CONSTRAINT FK_Bought_Username FOREIGN KEY (username) REFERENCES CarritoCompra.Users(username)
);

-- Insertamos un usuario administrador
insert into CarritoCompra.Users values ('florian', '56910c52ed70539e3ce0391edeb6d339', 'Florian', 'Ristea', '2001-10-30', 'M', 1);

-- Insertamos las categorias
insert into CarritoCompra.Category (id, name, description) values ('Cyperaceae', 'Havana Nutrush', 'Scleria havanensis Britton');
insert into CarritoCompra.Category (id, name, description) values ('Ericaceae', 'Kalmiopsis', 'Kalmiopsis Rehder');
insert into CarritoCompra.Category (id, name, description) values ('Rhamnaceae', 'Point Reyes Ceanothus', 'Ceanothus gloriosus J.T. Howell var. exaltatus J.T. Howell');
insert into CarritoCompra.Category (id, name, description) values ('Melastomataceae', 'Mameyuelo', 'Mouriri helleri Britton');
insert into CarritoCompra.Category (id, name, description) values ('Lamiaceae', 'Blue Ridge Skullcap', 'Scutellaria arguta Buckley');
insert into CarritoCompra.Category (id, name, description) values ('Fabaceae', 'Dwarf Erythrina', 'Erythrina humeana Spreng.');
insert into CarritoCompra.Category (id, name, description) values ('Parmeliaceae', 'Sinuous Hypotrachyna Lichen', 'Hypotrachyna sinuosa (Sm.) Hale');
insert into CarritoCompra.Category (id, name, description) values ('Campanulaceae', 'San Gabriel Bluecup', 'Githopsis diffusa A. Gray ssp. diffusa');
insert into CarritoCompra.Category (id, name, description) values ('Polygonaceae', 'Money Buckwheat', 'Eriogonum nummulare M.E. Jones');
insert into CarritoCompra.Category (id, name, description) values ('Poaceae', 'Silky Thatching Grass', 'Hyparrhenia dregeana (Nees) Stent');
insert into CarritoCompra.Category (id, name, description) values ('Brassicaceae', 'Bladderpod', 'Lesquerella S. Watson');
insert into CarritoCompra.Category (id, name, description) values ('Scrophulariaceae', 'Pincushion Beardtongue', 'Penstemon procerus Douglas ex Graham var. brachyanthus (Pennell) Cronquist');
insert into CarritoCompra.Category (id, name, description) values ('Solanaceae', 'Green Nightshade', 'Solanum viride G. Forst. ex Spreng.');
insert into CarritoCompra.Category (id, name, description) values ('Asteraceae', 'Hairybeast Turtleback', 'Psathyrotes pilifera A. Gray');
insert into CarritoCompra.Category (id, name, description) values ('Caryophyllaceae', 'Eurasian Nailwort', 'Paronychia echinulata Chater');
insert into CarritoCompra.Category (id, name, description) values ('Rosaceae', 'Clarkton Hawthorn', 'Crataegus helvina Ashe');
insert into CarritoCompra.Category (id, name, description) values ('Strigulaceae', 'Strigula Lichen', 'Strigula viridiseda (Nyl.) R.C. Harris');
insert into CarritoCompra.Category (id, name, description) values ('Portulacaceae', 'Truckee Lewisia', 'Lewisia longipetala (Piper) S. Clay');
insert into CarritoCompra.Category (id, name, description) values ('Pilocarpaceae', 'Fellhanera Lichen', 'Fellhanera Vezda');
insert into CarritoCompra.Category (id, name, description) values ('Thelotremataceae', 'Myriotrema Lichen', 'Myriotrema Fée');
insert into CarritoCompra.Category (id, name, description) values ('Liliaceae', 'Spider Plant', 'Chlorophytum comosum (Thunb.) Jacq.');
insert into CarritoCompra.Category (id, name, description) values ('Pteridaceae', 'Missouri Cliffbrake', 'Pellaea glabella Mett. ex Kuhn ssp. missouriensis (Gastony) Windham');
insert into CarritoCompra.Category (id, name, description) values ('Ulmaceae', 'Siberian Elm', 'Ulmus pumila L.');
insert into CarritoCompra.Category (id, name, description) values ('Fagaceae', 'California Black Oak', 'Quercus kelloggii Newberry');
insert into CarritoCompra.Category (id, name, description) values ('Juncaceae', 'Pennsylvania Rush', 'Juncus gymnocarpus Coville');
insert into CarritoCompra.Category (id, name, description) values ('Trypetheliaceae', 'Trypelthelium Lichen', 'Trypethelium ochroleucum (Eschw.) Nyl.');
insert into CarritoCompra.Category (id, name, description) values ('Dryopteridaceae', 'Halfnetfern', 'Hemidictyum marginatum (L.) C. Presl');
insert into CarritoCompra.Category (id, name, description) values ('Verbenaceae', 'Chinese Chastetree', 'Vitex negundo L. var. negundo');
insert into CarritoCompra.Category (id, name, description) values ('Salicaceae', 'Northern Willow', 'Salix arctophila Cockerell ex A. Heller');
insert into CarritoCompra.Category (id, name, description) values ('Asclepiadaceae', 'Redring Milkweed', 'Asclepias variegata L.');
insert into CarritoCompra.Category (id, name, description) values ('Urticaceae', 'Hawai''i Lopleaf', 'Cypholophus moluccanus (Blume) Miq.');
insert into CarritoCompra.Category (id, name, description) values ('Polypodiaceae', 'Colombian Rockcap Fern', 'Pecluma camptophyllaria (Fée) M.G. Price ssp. abbreviata (A.M. Evans) Kartesz & Gandhi');

-- Insertamos los items
insert into CarritoCompra.Item (id, name, description, price, category_id) values ('0093-2075', 'San Joaquin Saltbush', 'Chenopodiaceae', 123.01, 'Solanaceae');
insert into CarritoCompra.Item (id, name, description, price, category_id) values ('63981-571', 'Newberry''s Twinpod', 'Brassicaceae', 136.83, 'Caryophyllaceae');
insert into CarritoCompra.Item (id, name, description, price, category_id) values ('65862-102', 'Solmsiella Moss', 'Erpodiaceae', 209.79, 'Asteraceae');
insert into CarritoCompra.Item (id, name, description, price, category_id) values ('15231-100', 'Hybrid Willow', 'Salicaceae', 313.82, 'Verbenaceae');
insert into CarritoCompra.Item (id, name, description, price, category_id) values ('0869-0804', 'Incised Halberd Fern', 'Dryopteridaceae', 371.89, 'Rosaceae');
insert into CarritoCompra.Item (id, name, description, price, category_id) values ('60505-0759', 'White Doll''s Daisy', 'Asteraceae', 465.02, 'Rosaceae');
insert into CarritoCompra.Item (id, name, description, price, category_id) values ('55154-2650', 'Purpleflower Blacksnakeroot', 'Apiaceae', 106.23, 'Asteraceae');
insert into CarritoCompra.Item (id, name, description, price, category_id) values ('51345-117', 'Spreading Chervil', 'Apiaceae', 363.87, 'Parmeliaceae');
insert into CarritoCompra.Item (id, name, description, price, category_id) values ('52959-130', 'Sickle Island Spleenwort', 'Aspleniaceae', 133.55, 'Asteraceae');
insert into CarritoCompra.Item (id, name, description, price, category_id) values ('55154-8330', 'Mediterranean Rose', 'Rosaceae', 375.09, 'Asteraceae');
insert into CarritoCompra.Item (id, name, description, price, category_id) values ('52125-494', 'Wissadula', 'Malvaceae', 42.24, 'Scrophulariaceae');
insert into CarritoCompra.Item (id, name, description, price, category_id) values ('65517-1006', 'Porpidia Lichen', 'Porpidiaceae', 172.11, 'Pteridaceae');
insert into CarritoCompra.Item (id, name, description, price, category_id) values ('0113-0950', 'White Waterleaf', 'Hydrophyllaceae', 366.39, 'Asteraceae');
insert into CarritoCompra.Item (id, name, description, price, category_id) values ('52125-304', 'Fuschia Gum', 'Myrtaceae', 351.49, 'Solanaceae');
insert into CarritoCompra.Item (id, name, description, price, category_id) values ('55312-200', 'Sacred Garlic Pear', 'Capparaceae', 99.94, 'Melastomataceae');
insert into CarritoCompra.Item (id, name, description, price, category_id) values ('52959-613', 'Nuttall''s Sunflower', 'Asteraceae', 361.86, 'Salicaceae');
insert into CarritoCompra.Item (id, name, description, price, category_id) values ('0407-2223', 'Southern Meadow-rue', 'Ranunculaceae', 454.31, 'Asteraceae');
insert into CarritoCompra.Item (id, name, description, price, category_id) values ('52125-430', 'European Heliotrope', 'Boraginaceae', 409.65, 'Campanulaceae');
insert into CarritoCompra.Item (id, name, description, price, category_id) values ('47682-015', 'Meadow Bistort', 'Polygonaceae', 455.31, 'Fabaceae');
insert into CarritoCompra.Item (id, name, description, price, category_id) values ('63667-962', 'Trichoptilium', 'Asteraceae', 253.65, 'Urticaceae');
insert into CarritoCompra.Item (id, name, description, price, category_id) values ('0023-4948', 'Phyllopsora Lichen', 'Bacidiaceae', 313.47, 'Cyperaceae');
insert into CarritoCompra.Item (id, name, description, price, category_id) values ('50268-263', 'Largepod Pinweed', 'Cistaceae', 372.0, 'Pteridaceae');
insert into CarritoCompra.Item (id, name, description, price, category_id) values ('0121-4727', 'Ram''s Horn', 'Pedaliaceae', 243.38, 'Scrophulariaceae');
insert into CarritoCompra.Item (id, name, description, price, category_id) values ('36987-3266', 'Cucumberleaf Sunflower', 'Asteraceae', 94.59, 'Asteraceae');
insert into CarritoCompra.Item (id, name, description, price, category_id) values ('68210-1510', 'Vlassov''s Phascum Moss', 'Pottiaceae', 491.66, 'Rosaceae');
insert into CarritoCompra.Item (id, name, description, price, category_id) values ('49288-0950', 'Soft Milkpea', 'Fabaceae', 14.73, 'Rosaceae');
insert into CarritoCompra.Item (id, name, description, price, category_id) values ('63187-099', 'California Pricklypear', 'Cactaceae', 342.92, 'Rosaceae');
insert into CarritoCompra.Item (id, name, description, price, category_id) values ('64942-1117', 'Wood Saxifrage', 'Saxifragaceae', 397.37, 'Verbenaceae');
insert into CarritoCompra.Item (id, name, description, price, category_id) values ('55312-668', 'Florida Orchid', 'Orchidaceae', 375.84, 'Rosaceae');
insert into CarritoCompra.Item (id, name, description, price, category_id) values ('52685-364', 'California Clematis', 'Ranunculaceae', 453.01, 'Liliaceae');
insert into CarritoCompra.Item (id, name, description, price, category_id) values ('50563-124', 'Corymbia', 'Myrtaceae', 186.22, 'Asteraceae');
insert into CarritoCompra.Item (id, name, description, price, category_id) values ('68001-153', 'Arizona Sneezeweed', 'Asteraceae', 454.05, 'Poaceae');
insert into CarritoCompra.Item (id, name, description, price, category_id) values ('63323-321', 'Amazon Waterlily', 'Nymphaeaceae', 279.31, 'Pteridaceae');
insert into CarritoCompra.Item (id, name, description, price, category_id) values ('0093-0083', 'Rabbit-tobacco', 'Asteraceae', 32.63, 'Liliaceae');
insert into CarritoCompra.Item (id, name, description, price, category_id) values ('64720-216', 'Grapefern', 'Ophioglossaceae', 101.26, 'Ericaceae');
insert into CarritoCompra.Item (id, name, description, price, category_id) values ('41163-600', 'Lone Mesa Snakeweed', 'Asteraceae', 365.64, 'Poaceae');
insert into CarritoCompra.Item (id, name, description, price, category_id) values ('51346-036', 'Pacific Island Silvergrass', 'Poaceae', 79.03, 'Asteraceae');
insert into CarritoCompra.Item (id, name, description, price, category_id) values ('48951-4075', 'Coastal Plain Buckbrush', 'Rhamnaceae', 389.88, 'Scrophulariaceae');
insert into CarritoCompra.Item (id, name, description, price, category_id) values ('0904-5850', 'Sesbania', 'Fabaceae', 123.53, 'Liliaceae');
insert into CarritoCompra.Item (id, name, description, price, category_id) values ('55154-2876', 'Arrowgrass', 'Juncaginaceae', 408.51, 'Fabaceae');
insert into CarritoCompra.Item (id, name, description, price, category_id) values ('0904-7891', 'Mexican Orange', 'Rutaceae', 466.22, 'Portulacaceae');
insert into CarritoCompra.Item (id, name, description, price, category_id) values ('63868-549', 'Subterranean Clover', 'Fabaceae', 345.05, 'Asteraceae');
insert into CarritoCompra.Item (id, name, description, price, category_id) values ('64380-742', 'Gyalideopsis Lichen', 'Gomphillaceae', 404.94, 'Melastomataceae');
insert into CarritoCompra.Item (id, name, description, price, category_id) values ('64117-108', 'Porter''s Wormwood', 'Asteraceae', 380.73, 'Poaceae');
insert into CarritoCompra.Item (id, name, description, price, category_id) values ('54868-5388', 'California Cracked Lichen', 'Acarosporaceae', 352.01, 'Cyperaceae');
insert into CarritoCompra.Item (id, name, description, price, category_id) values ('41520-206', 'European Honeysuckle', 'Caprifoliaceae', 101.39, 'Dryopteridaceae');
insert into CarritoCompra.Item (id, name, description, price, category_id) values ('49873-705', 'Sweet Crab Apple', 'Rosaceae', 465.67, 'Lamiaceae');
insert into CarritoCompra.Item (id, name, description, price, category_id) values ('10096-0199', 'Pitcherplant', 'Sarraceniaceae', 34.05, 'Poaceae');
insert into CarritoCompra.Item (id, name, description, price, category_id) values ('68180-655', 'San Benito Monardella', 'Lamiaceae', 387.41, 'Fabaceae');
insert into CarritoCompra.Item (id, name, description, price, category_id) values ('0603-3739', 'Quillwort', 'Isoetaceae', 385.65, 'Thelotremataceae');
insert into CarritoCompra.Item (id, name, description, price, category_id) values ('41520-213', 'Hooker''s Matted Lichen', 'Pannariaceae', 355.71, 'Scrophulariaceae');
insert into CarritoCompra.Item (id, name, description, price, category_id) values ('59779-482', 'Weeping Gum', 'Myrtaceae', 26.87, 'Fabaceae');

CREATE USER 'ristea'@'%' IDENTIFIED BY 'marianflorian';
GRANT ALL PRIVILEGES ON CarritoCompra.* to 'ristea'@'%';
