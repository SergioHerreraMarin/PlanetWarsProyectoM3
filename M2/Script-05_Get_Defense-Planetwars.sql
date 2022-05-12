create or replace procedure get_defense(
pid_defense in out int,
pdefense_name out varchar,
pmetal_cost out int,
pcrystal_cost out int, 
pdeuterium_cost out int,
pinitial_armor out int,
parmor out int,
pbase_damage out int,
pspeed out int,
pgenerate_wastings out int)

as
cursor c1 is select * from defenses where id_defense = pid_defense;
defense_row c1%rowtype;

begin

open c1;
fetch c1 into defense_row;

pid_defense := defense_row.id_defense;
pdefense_name := defense_row.defense_name;
pmetal_cost := defense_row.metal_cost;
pcrystal_cost := defense_row.crystal_cost;
pdeuterium_cost := defense_row.deuterium_cost;
pinitial_armor := defense_row.initial_armor;
parmor := defense_row.armor;
pbase_damage := defense_row.base_damage;
pspeed := defense_row.speed;
pgenerate_wastings := defense_row.generate_wastings;

end;
/*Pon variables out, en java se llama al procedimiento con una variable in y se recorre el resultado con getTipovalor(posicion)*/