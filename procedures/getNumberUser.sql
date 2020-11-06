CREATE DEFINER=`root`@`localhost` PROCEDURE `getNumberUser`(OUT count int )
BEGIN
SELECT COUNT(*) FROM usuario into count;
END