-- xselect id='hello'
select name,sidt.name as type_name
from sf_iot_device left join sf_iot_device_type sidt on sf_iot_device.type_id = sidt.id
where name = 'hello';
-- xselect id='hello2'
select name,sidt.name as type_name
from sf_iot_device left join sf_iot_device_type sidt on sf_iot_device.type_id = sidt.id
where name = 'hello';
SELECT 'abc', 5 FROM mytable WHERE col='test';
UPDATE table1 A SET A.columna = 'XXX' WHERE A.cod_table = 'YYY';
INSERT INTO example (num, name, address, tel) VALUES (1, 'name', 'test ', '1234-1234');
DELETE FROM table1 where col=5 and col2=4;;