DELIMITER //
CREATE TRIGGER `CHECK_INSERT_M_BALANCE` 
BEFORE INSERT ON `merchant` 
FOR EACH ROW begin  
    	if  new.BALANCE<1000 then
        SIGNAL SQLSTATE '45000'   
        SET MESSAGE_TEXT = 'INSUFFICIENT BALANCE';
     	end if; 
   end;//
   
DELIMITER //
CREATE TRIGGER `CHECK_UPDATE_M_BALANCE` 
BEFORE UPDATE ON `merchant` 
FOR EACH ROW begin  
    	if  new.BALANCE<1000 then
        SIGNAL SQLSTATE '45000'   
        SET MESSAGE_TEXT = 'INSUFFICIENT BALANCE';
     	end if; 
   end;//


DROP TRIGGER `CHECK_UPDATE_BALANCE`;

DELIMITER //
CREATE TRIGGER `CHECK_INSERT_C_BALANCE` 
BEFORE INSERT ON `customer` 
FOR EACH ROW begin  
    	if  new.BALANCE<1000 then
        SIGNAL SQLSTATE '45000'   
        SET MESSAGE_TEXT = 'INSUFFICIENT BALANCE';
     	end if; 
   end;//
   
DELIMITER //
CREATE TRIGGER `CHECK_UPDATE_C_BALANCE` 
BEFORE UPDATE ON `customer` 
FOR EACH ROW begin  
    	if  new.BALANCE<1000 then
        SIGNAL SQLSTATE '45000'   
        SET MESSAGE_TEXT = 'INSUFFICIENT BALANCE';
     	end if; 
   end;//
   
