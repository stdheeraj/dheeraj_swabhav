delimiter $$
    create trigger CHECK_INSERT_BALANCE before insert on bank_master 
      for each row 
       begin  
      	if  new.BALANCE<500 then
        		SIGNAL SQLSTATE '45000'   
        		SET MESSAGE_TEXT = 'INSUFFICIENT BALANCE';
     		end if; 
    	end; 
    $$