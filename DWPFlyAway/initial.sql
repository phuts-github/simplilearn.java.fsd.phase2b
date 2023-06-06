
INSERT INTO users (`id`,`contact`,`email`,`name`,`pass`,`type`) VALUES 
(10,'','user','master user','user123','admin'),
(11,'','user1','normal user','user123','');

INSERT INTO flightsschedule (`id`,`airline`,`date`,`destination`,`price`,`seatsAvailable`,`seatsBooked`,`seatsTotal`,`source`) VALUES 
(1,'AFR','Aug-10th','TOKYO',51,20,0,20,'LAGOS'),
(2,'ASI','Aug-11th','SYDNEY',52,20,0,20,'TOKYO'),
(3,'AUS','Aug-12th','ISTANBUL',53,20,0,20,'SYDNEY'),
(4,'EUR','Aug-13th','MEXICO',54,20,0,20,'ISTANBUL'),
(5,'NOR','Aug-14th','SAO PAULO',55,20,0,20,'MEXICO'),
(6,'AFR','Sep-10th','TOKYO',71,20,0,20,'LAGOS'),
(7,'ASI','Sep-11th','SYDNEY',72,20,0,20,'TOKYO'),
(8,'AUS','Sep-12th','ISTANBUL',73,20,0,20,'SYDNEY'),
(9,'EUR','Sep-13th','MEXICO',74,20,0,20,'ISTANBUL'),
(10,'NOR','Sep-14th','SAO PAULO',76,20,0,20,'MEXICO');

INSERT INTO airlines (`id`,`city`,`country`,`name`,`route`) VALUES 
(1,'Lagos','Nigeria','Air Africa','Africa'),
(2,'Tokyo','Japan','Air Asia','Asia'),
(3,'Sydney','Australia','Air Australia','Australia'),
(4,'Istanbul','Turkey','Air Europe','Europe'),
(5,'Mexico City','Mexico','Air North America','North America'),
(6,'São Paulo','Brazil','Air South America','South America');

INSERT INTO cities (`id`,`continent`,`country`,`name`) VALUES 
(1,'Africa','Nigeria','Lagos'),
(2,'Asia','Japan','Tokyo'),
(3,'Australia','Australia','Sydney'),
(4,'Europe','Turkey','Istanbul'),
(5,'North America','Mexico','Mexico City'),
(6,'South America','Brazil','São Paulo');
