insert into users (name, age, email) values ('Alex', 37, '123@ya.ru');
select * from users;
select * from users where id=1;
select name, age from users where id=2;
update users set name='Steve', age=55, email='345@mail.ru' where id=5;
delete from users where id=6;