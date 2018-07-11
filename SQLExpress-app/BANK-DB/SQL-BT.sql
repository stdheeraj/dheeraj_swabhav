INSERT INTO bank_transaction VALUES ("PRASAD", 100, "D", NOW());



delimiter $$
    create trigger CHECK_TYPE before insert on bank_transaction 
      for each row 
       begin  
      	if  new.TYPE NOT IN ("D", "W")
				then
	       		SIGNAL SQLSTATE '45000'   
	       		SET MESSAGE_TEXT = 'INVALID TYPE';
       	end if; 
    	end; 
    $$
    
    
DROP TRIGGER CHECK_TYPE`bank-db`
    
    
