create or replace procedure initialize(reset int:=0)
as
existe int := 0;
begin
select count(*) into existe from user_tables;
if reset != 0 or existe = 0 then /*Reset o taules no existeixen*/
    drop_table;
    create_table;
    insert_data;
    dbms_output.put_line('Reseted database');
else
dbms_output.put_line('Tables already exist');
end if;
end;