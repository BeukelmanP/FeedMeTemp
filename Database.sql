SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `feedback`;
DROP TABLE IF EXISTS `user_feedback`;
SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE `user`
(
`id` INT(4) auto_increment,
`firstname` VARCHAR(255) NOT NULL,
`lastname` VARCHAR(255) NOT NULL,
`email` VARCHAR(255) NOT NULL,
`password` VARCHAR(255) NOT NULL,
`score` INT(4) DEFAULT 0,
PRIMARY KEY(id)
);

CREATE TABLE `feedback`
(
`id` INT(4) auto_increment,
`sendTo` INT(4),
`sendFrom` INT(4),
`feedback` VARCHAR(255) NOT NULL,
`timeCreated` DATETIME NOT NULL,
PRIMARY KEY(id),
FOREIGN KEY (sendTo) REFERENCES `user`(id),
FOREIGN KEY (sendFrom) REFERENCES `user`(id)
);

CREATE TABLE `user_feedback`
(
`id` INT(4) auto_increment,
`feedbackId` INT(4) NOT NULL, 
`likeFrom` INT(4) NOT NULL,
`helpful` INT (1) NOT NULL,
PRIMARY KEY(id),
FOREIGN KEY (feedbackId) REFERENCES `feedback`(id),
FOREIGN KEY (likeFrom) REFERENCES `user`(id)
);

INSERT INTO `user` (id,firstname,lastname,email,password)
VALUES (1,'test', 'test', 'test', 'test');
INSERT INTO `user` (id,firstname,lastname,email,password)
VALUES (2, 'wes', 'wes', 'wes@wes.nl', 'wes'); 

INSERT INTO `feedback` (id,sendTo,sendFrom,feedback,timeCreated)
VALUES (1,1,2,'lekker gewerkt pik',CURRENT_TIMESTAMP());
INSERT INTO `feedback` (id,sendTo,sendFrom,feedback,timeCreated)
VALUES (2,2,1, 'Feedback all the way',CURRENT_TIMESTAMP());
INSERT INTO `feedback` (id,sendTo,sendFrom,feedback,timeCreated)
VALUES (3,2,1, 'Je stinkt',CURRENT_TIMESTAMP());

INSERT INTO `user_feedback` (id,feedbackId,likeFrom,helpful)
VALUES (1,1,1,1);
INSERT INTO `user_feedback` (id,feedbackId,likeFrom,helpful)
VALUES (2,1,2,1);



/*Server: sql11.freemysqlhosting.net
Name: sql11194356
Username: sql11194356
Password: YpVPS7iJwE
Port number: 3306
*/
