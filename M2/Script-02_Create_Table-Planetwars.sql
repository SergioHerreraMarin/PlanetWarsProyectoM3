create or replace procedure create_table
as
begin
/*
INFORMACIO IMPORTANT
-Degut a la longitud maxima de caracters del nom de les columnes, els atributs 
 technology_X han sigut renombrats a tech_X.
-Degut a que 'name' i 'password' són paraules reservades, les columnes passen a 
 anomenar-se X_name i X_password, on X representa el tipus d'objecte al que 
 perany el nom o contrasenya (Ex: planet_name).
-Username passa a anomenar-se 'user_name' per paritat amb la nomenclatura 
 anterior.
-La longitud maxima de caracters dels valors de tipus varchar ha sigut 
 establerta en 50.
*/

/*GENERACIO DE TAULES ########################################################*/

/*TAULA BATTLES --------------------------------------------------------------*/
execute immediate 'CREATE TABLE battles (
    id_battle         NUMBER NOT NULL,
    user_start_units  VARCHAR(50) NOT NULL,
    user_end_units    VARCHAR(50) NOT NULL,
    enemy_start_units VARCHAR(50) NOT NULL,
    enemy_end_units   VARCHAR(50) NOT NULL,
    id_user           NUMBER NOT NULL
)';
execute immediate 'ALTER TABLE battles ADD CONSTRAINT battles_pk PRIMARY KEY ( id_battle )';

/*TAULA BATTLE_EVENTS --------------------------------------------------------*/
execute immediate 'CREATE TABLE battle_events (
    id_event         NUMBER NOT NULL,
    position         NUMBER NOT NULL,
    description   VARCHAR(50) NOT NULL,
    id_battle         NUMBER NOT NULL
)';
execute immediate 'ALTER TABLE battle_events ADD CONSTRAINT battle_events_pk PRIMARY KEY ( id_event )';

/*TAULA DEFENSES -------------------------------------------------------------*/
execute immediate 'CREATE TABLE defenses (
    id_defense        NUMBER NOT NULL,
    defense_name      VARCHAR2(50) NOT NULL,
    metal_cost        NUMBER NOT NULL,
    deuterium_cost    NUMBER NOT NULL,
    crystal_cost      NUMBER NOT NULL,
    initial_armor     NUMBER NOT NULL,
    armor             NUMBER NOT NULL,
    base_damage       NUMBER NOT NULL,
    speed             NUMBER NOT NULL,
    generate_wastings NUMBER NOT NULL
)';
execute immediate 'ALTER TABLE defenses ADD CONSTRAINT defenses_pk PRIMARY KEY ( id_defense )';

/*TAULA PLANET_DEFENSES -------------------------------------------------------------*/
execute immediate 'CREATE TABLE planet_defenses (
    id_planet_defense NUMBER NOT NULL,
    defense_name      VARCHAR2(50) NOT NULL,
    metal_cost        NUMBER NOT NULL,
    deuterium_cost    NUMBER NOT NULL,
    crystal_cost      NUMBER NOT NULL,
    initial_armor     NUMBER NOT NULL,
    armor             NUMBER NOT NULL,
    base_damage       NUMBER NOT NULL,
    speed             NUMBER NOT NULL,
    generate_wastings NUMBER NOT NULL,
    id_planet         NUMBER NOT NULL
)';
execute immediate 'ALTER TABLE planet_defenses ADD CONSTRAINT planet_defenses_pk PRIMARY KEY ( id_planet_defense )';

/*TAULA PLANETS --------------------------------------------------------------*/
execute immediate 'CREATE TABLE planets (
    id_planet                       NUMBER NOT NULL,
    planet_name                     VARCHAR2(50) NOT NULL,
    tech_attack                     NUMBER NOT NULL,
    tech_defense                    NUMBER NOT NULL,
    tech_attack_upgrade_cost        NUMBER NOT NULL,
    tech_defense_upgrade_cost       NUMBER NOT NULL,
    deuterium                       NUMBER NOT NULL,
    metal                           NUMBER NOT NULL,
    crystal                         NUMBER NOT NULL,
    id_user                         NUMBER NOT NULL
)';
execute immediate 'ALTER TABLE planets ADD CONSTRAINT planets_pk PRIMARY KEY ( id_planet )';
execute immediate 'ALTER TABLE planets ADD CONSTRAINT planets_planet_name UNIQUE ( planet_name )';

/*TAULA SHIPS ----------------------------------------------------------------*/

execute immediate 'CREATE TABLE ships (
    id_ship           NUMBER NOT NULL,
    ship_name         VARCHAR2(50) NOT NULL,
    metal_cost        NUMBER NOT NULL,
    deuterium_cost    NUMBER NOT NULL,
    crystal_cost      NUMBER NOT NULL,
    initial_armor     NUMBER NOT NULL,
    armor             NUMBER NOT NULL,
    base_damage       NUMBER NOT NULL,
    speed             NUMBER NOT NULL,
    generate_wastings NUMBER NOT NULL
)';
execute immediate 'ALTER TABLE ships ADD CONSTRAINT ships_pk PRIMARY KEY ( id_ship )';

/*TAULA SHIPS ----------------------------------------------------------------*/

execute immediate 'CREATE TABLE planet_ships (
    id_planet_ship    NUMBER NOT NULL,
    ship_name         VARCHAR2(50) NOT NULL,
    metal_cost        NUMBER NOT NULL,
    deuterium_cost    NUMBER NOT NULL,
    crystal_cost      NUMBER NOT NULL,
    initial_armor     NUMBER NOT NULL,
    armor             NUMBER NOT NULL,
    base_damage       NUMBER NOT NULL,
    speed             NUMBER NOT NULL,
    generate_wastings NUMBER NOT NULL,
    id_planet         NUMBER NOT NULL
)';
execute immediate 'ALTER TABLE planet_ships ADD CONSTRAINT planet_ships_pk PRIMARY KEY ( id_planet_ship )';

/*TAULA USERS ----------------------------------------------------------------*/

execute immediate 'CREATE TABLE users (
    id_user         NUMBER NOT NULL,
    user_name       VARCHAR2(50) NOT NULL,
    user_password   VARCHAR2(50) NOT NULL,
    birth_date      DATE
)';
execute immediate 'ALTER TABLE users ADD CONSTRAINT users_pk PRIMARY KEY ( id_user )';
execute immediate 'ALTER TABLE users ADD CONSTRAINT users_user_name UNIQUE ( user_name )';



/*FOREIGN KEYS ###############################################################*/

execute immediate 'ALTER TABLE battles ADD CONSTRAINT battles_users_fk FOREIGN KEY ( id_user ) 
REFERENCES users ( id_user )';

execute immediate 'ALTER TABLE battle_events ADD CONSTRAINT battle_events_battle_fk FOREIGN KEY ( id_battle ) 
REFERENCES battles ( id_battle )';

execute immediate 'ALTER TABLE planets ADD CONSTRAINT planets_users_fk FOREIGN KEY ( id_user )
REFERENCES users ( id_user )';

execute immediate 'ALTER TABLE planet_ships ADD CONSTRAINT planet_ships_planets_fk FOREIGN KEY ( id_planet )
REFERENCES planets ( id_planet )';

execute immediate 'ALTER TABLE planet_defenses ADD CONSTRAINT planet_defenses_planets_fk FOREIGN KEY ( id_planet )
REFERENCES planets ( id_planet )';

end;