CREATE TABLE `tb_person` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `gender` char(1) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
);

