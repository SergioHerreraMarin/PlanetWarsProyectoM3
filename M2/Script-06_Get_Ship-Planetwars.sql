create or replace procedure get_ship(
pid_ship in out int,
pship_name out varchar,
pmetal_cost out int,
pcrystal_cost out int, 
pdeuterium_cost out int,
pinitial_armor out int,
parmor out int,
pbase_damage out int,
pspeed out int,
pgenerate_wastings out int)

as
cursor c1 is select * from ships where id_ship = pid_ship;
ship_row c1%rowtype;

begin

open c1;
fetch c1 into ship_row;

pid_ship := ship_row.id_ship;
pship_name := ship_row.ship_name;
pmetal_cost := ship_row.metal_cost;
pcrystal_cost := ship_row.crystal_cost;
pdeuterium_cost := ship_row.deuterium_cost;
pinitial_armor := ship_row.initial_armor;
parmor := ship_row.armor;
pbase_damage := ship_row.base_damage;
pspeed := ship_row.speed;
pgenerate_wastings := ship_row.generate_wastings;

end;