USE `survey`;
 
 
CREATE TABLE `brands` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`topic_Id` int(11) NOT NULL,
`topic` varchar(50) NOT NULL,
`score` int(11) NOT NULL,
`feed_Back` varchar(50) NOT NULL,
 PRIMARY KEY (`id`)
 )ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;