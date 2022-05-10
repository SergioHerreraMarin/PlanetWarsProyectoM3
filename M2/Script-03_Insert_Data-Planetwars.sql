create or replace procedure insert_data
as
existe int := 0;
begin

/*INSERCIO SHIPS #############################################################*/
select count(*) into existe from user_tables where table_name = 'SHIPS';
if existe != 0 then

execute immediate 'insert into ships (id_ship, ship_name, metal_cost, crystal_cost, deuterium_cost,
initial_armor, armor, base_damage, speed, generate_wastings) 
values (1,''Light hunter'', 3000, 0, 50, 400, 0, 80, 3, 20)';

execute immediate 'insert into ships (id_ship, ship_name, metal_cost, crystal_cost, deuterium_cost,
initial_armor, armor, base_damage, speed, generate_wastings) 
values (2,''Heavy hunter'', 6500, 0, 50, 1000, 0, 150, 7, 30)';

execute immediate 'insert into ships (id_ship, ship_name, metal_cost, crystal_cost, deuterium_cost,
initial_armor, armor, base_damage, speed, generate_wastings) 
values (3,''Battle ship'', 45000, 0, 7000, 6000, 0, 1000, 45, 60)';

execute immediate 'insert into ships (id_ship, ship_name, metal_cost,  crystal_cost, deuterium_cost,
initial_armor, armor, base_damage, speed, generate_wastings) 
values (4,''Armored ship'', 30000, 0, 15000, 8000, 0, 700, 70, 75)';

end if;

/*INSERCIO DEFENSES ##########################################################*/
select count(*) into existe from user_tables where table_name = 'DEFENSES';
if existe != 0 then

execute immediate 'insert into defenses (id_defense, defense_name, metal_cost, crystal_cost, 
deuterium_cost, initial_armor, armor, base_damage, speed, generate_wastings) 
values (1,''Missile launcher'', 2000, 0, 0, 200, 0, 80, 5, 10)';

execute immediate 'insert into defenses (id_defense, defense_name, metal_cost, crystal_cost, 
deuterium_cost, initial_armor, armor, base_damage, speed, generate_wastings) 
values (2,''Ion cannon'', 4000, 0, 500, 1200, 0, 250, 12, 25)';

execute immediate 'insert into defenses (id_defense, defense_name, metal_cost, crystal_cost, 
deuterium_cost, initial_armor, armor, base_damage, speed, generate_wastings) 
values (3,''Plasma cannon'', 50000, 0, 5000, 7000, 0, 2000, 30, 50)';

end if;

end;