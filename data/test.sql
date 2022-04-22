-- xselect id='hello'
select name, sidt.name as type_name
from sf_iot_device
         left join sf_iot_device_type sidt on sf_iot_device.type_id = sidt.id
where 1 = 1
  and name = 'abc'
  and id = '1';
/**
  sad
 */
-- xselect id='hello2'
select name, sidt.name as type_name
from sf_iot_device
         left join sf_iot_device_type sidt on sf_iot_device.type_id = sidt.id
where name = 'hello';