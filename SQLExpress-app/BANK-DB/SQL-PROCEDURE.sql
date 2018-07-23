delimiter //
CREATE PROCEDURE START_TRANSACTION (IN _NAME VARCHAR(20), IN _AMOUNT FLOAT, IN _TYPE VARCHAR(1))
BEGIN

IF _TYPE = "D" THEN
	UPDATE bank_master SET BALANCE = BALANCE + _AMOUNT WHERE NAME = _NAME;
END IF;

IF _TYPE = "W" THEN
	UPDATE bank_master SET BALANCE = BALANCE - _AMOUNT WHERE NAME = _NAME;
END IF;

INSERT INTO bank_transaction VALUES(_NAME, _AMOUNT, _TYPE, NOW());

END//


CALL START_TRANSACTION ("DHEERAJ", 100, "W");