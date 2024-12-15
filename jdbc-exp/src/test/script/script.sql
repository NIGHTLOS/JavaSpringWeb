explain
select * from address a where a.user_id = '1296859193107865600';

explain
select * from address a,user u where a.user_id=u.id and a.id='1';

explain
select * from user u join address a on u.id=a.user_id where u.id='1296859193107865600';

explain
select u.id,u.name,count(a.user_id) as count from user u left join address a on u.id=a.user_id group by u.id order by count;

explain
select u.id as user_id,u.name,count(a.user_id) as count from user u join address a on u.id=a.user_id group by u.id order by count;
