-- xselect id='hello'
select name,sidt.name as type_name
from sf_iot_device left join sf_iot_device_type sidt on sf_iot_device.type_id = sidt.id
where name = 'hello';

-- xselect id='hello2'
select name,sidt.name as type_name
from sf_iot_device left join sf_iot_device_type sidt on sf_iot_device.type_id = sidt.id
where name = 'hello';