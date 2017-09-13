DROP TABLE IF EXISTS `user`;

CREATE TABLE `user`
(
`id` INT(4) auto_increment,
`firstname` VARCHAR(255) NOT NULL,
`lastname` VARCHAR(255) NOT NULL,
`email` VARCHAR(255) NOT NULL,
`password` VARCHAR(255) NOT NULL,
PRIMARY KEY(id)
);

INSERT INTO `user` (id,firstname,lastname,email,password)
VALUES (1,'test', 'test', 'test', 'test');
INSERT INTO `user` (id,firstname,lastname,email,password)
VALUES (2, 'wes', 'wes', 'wes@wes.nl', 'wes'); 