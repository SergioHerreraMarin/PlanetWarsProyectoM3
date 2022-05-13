SET SERVEROUTPUT ON;

DECLARE

    new_id_user users.id_user%TYPE;
    
    new_user_name users.user_name%TYPE := UPPER('&supplier_name_user');
    exception_new_name_NO_null exception;
    
    new_password users.user_password%TYPE := '&new_password';
    exception_new_password_NO_null exception;
    
    new_birth_date users.birth_date%TYPE := '&new_birth_date';
    exception_birth_date exception;
    exception_birth_date_mas_actual exception;
    no_letras_birth_date exception;
    
BEGIN

    --busco el ultimo id y le sumo 10 para adjudicar el supplier_code al nuevo vendedor
    select (max(id_user)+1) into new_id_user from users;
    
    if new_id_user is null then
    
        new_id_user := 1;
    
    end if;
    
    --comprobar que el supplier_name_user NO es null
    if new_user_name is null then
        raise exception_new_name_NO_null;
        
    else
        DBMS_OUTPUT.PUT_LINE('el nombre de usuario introducido es correcto');
        
        if new_password is null then
            raise exception_new_password_NO_null;
        
        else
            DBMS_OUTPUT.PUT_LINE('el password introducido es correcto');
            
            if new_birth_date is null then
                raise exception_birth_date;
                
            elsif (new_birth_date > current_date) then
                raise exception_birth_date_mas_actual;
            
            elsif (new_birth_date 
            
            else
                DBMS_OUTPUT.PUT_LINE('la fecha de nacimiento es correcta se procede a insertar el nuevo usuario.');
                INSERT INTO users(id_user, user_name, user_password, birth_date)
                VALUES (new_id_user, new_user_name, new_password, new_birth_date);
                DBMS_OUTPUT.PUT_LINE('Se ha anadido al nuevo usuario a la tabla users.');
                
            end if;  
            
        end if;
        
    end if;

EXCEPTION

    --excepcion supplier_name_user nulo
    WHEN exception_new_name_NO_null THEN
    DBMS_OUTPUT.PUT_LINE('El nombre no puede ser nulo');
    DBMS_OUTPUT.PUT_LINE('No se ha podido insertar el usuario');
    ROLLBACK;
    
    --excepcion password nula
    WHEN exception_new_password_NO_null THEN
    DBMS_OUTPUT.PUT_LINE('El password no puede ser nulo');
    DBMS_OUTPUT.PUT_LINE('No se ha podido insertar el usuario');
    ROLLBACK;
    
    --excepcion new_birth_date nulo
    WHEN exception_birth_date THEN
    DBMS_OUTPUT.PUT_LINE('La fecha de nacimiento no puede ser nula');
    DBMS_OUTPUT.PUT_LINE('No se ha podido insertar al usuario');
    ROLLBACK;
    
    --excepcion new_birth_date nulo
    WHEN exception_birth_date_mas_actual THEN
    DBMS_OUTPUT.PUT_LINE('La fecha de nacimiento no puede ser mayor a la actual');
    DBMS_OUTPUT.PUT_LINE('No se ha podido insertar al usuario');
    ROLLBACK;   

END;