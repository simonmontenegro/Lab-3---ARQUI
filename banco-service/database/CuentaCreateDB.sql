--Dropear las tablas
--Estas sentencias verifican que no existan las tablas previamente
--En caso de existir, las elimina en CASCADA, es decir,
--elimina todo el flujo asociado a la tabla
DROP TABLE IF EXISTS public.cuenta CASCADE;


-- SE CREAN LAS TABLAS QUE NO TIENEN LLAVE FORANEA
CREATE TABLE public.cuenta(
  "id" varchar(100),
  "saldo" integer,
  "nombre_persona" varchar(100),
  PRIMARY KEY ("id")
);
ALTER TABLE public.cuenta OWNER TO postgres;