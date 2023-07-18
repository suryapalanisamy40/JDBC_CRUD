create database personal_details;
use personal_details;
create table t1 (
		id INT primary key,
        name varchar(20),
        phone bigint,
        email varchar(30)
);
insert into t1 values(1,"Surya",1234567,"hai40@gmail.com");
describe t1; 
select * from t1;