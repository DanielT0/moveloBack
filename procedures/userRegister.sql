CREATE DEFINER=`root`@`localhost` PROCEDURE `userRegister`(usr_name varchar(50), usr_email varchar(50),usr_address varchar(50),
usr_phone varchar(50),OUT checked bool)
BEGIN
DECLARE usr_id int;
DECLARE usr_cc varchar(50);
SET checked= true;
SELECT id FROM usuario WHERE correo=usr_email INTO usr_id;
SELECT cc FROM biciusuario WHERE nombre=usr_name INTO usr_cc;
SELECT cc FROM biciusuario WHERE direccion=usr_address INTO usr_cc;
SELECT cc FROM biciusuario WHERE telefono=usr_phone INTO usr_cc;
if (usr_id IS NOT NULL OR usr_cc IS NOT NULL) 
THEN SET checked=false;
END IF;
END