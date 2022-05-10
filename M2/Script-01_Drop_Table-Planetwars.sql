/*01_Drop_Table*/
create or replace procedure drop_table 

as
existe int := 0;

begin
/*ELIMINACIO BATTLES #######################################################*/
select count(*) into existe from user_tables where table_name = 'BATTLES';
if existe != 0 then
execute immediate 'drop table battles cascade constraints';
existe := 0;
end if;
/*ELIMINACIO DEFENSES ######################################################*/
select count(*) into existe from user_tables where table_name = 'DEFENSES';
if existe = 1 then
execute immediate 'drop table defenses cascade constraints';
existe := 0;
end if;
/*ELIMINACIO PLANETS #######################################################*/
select count(*) into existe from user_tables where table_name = 'PLANETS';
if existe = 1 then
execute immediate 'drop table planets cascade constraints';
existe := 0;
end if;
/*ELIMINACIO SHIPS ########################################################*/
select count(*) into existe from user_tables where table_name = 'SHIPS';
if existe = 1 then
execute immediate 'drop table ships cascade constraints';
existe := 0;
end if;
/*ELIMINACIO USERS ########################################################*/
select count(*) into existe from user_tables where table_name = 'USERS';
if existe = 1 then
execute immediate 'drop table users cascade constraints';
existe := 0;
end if;
end;