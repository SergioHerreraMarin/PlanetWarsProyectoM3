create or replace procedure get_cost_defenses(id_number in number, metal in out ships.metal_cost%TYPE, deuterium in out ships.deuterium_cost%TYPE)
is
    
begin

    select metal_cost, deuterium_cost into metal, deuterium from defenses where id_number = id_defense;

end;