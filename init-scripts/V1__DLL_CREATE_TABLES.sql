-- public.ingredient definition

-- Drop table

-- DROP TABLE public.ingredient;

CREATE TABLE public.ingredient (
	id uuid NOT NULL,
	calories_per_gram numeric(38, 2) NULL,
	fecha_creacion timestamp NULL,
	fecha_modificacion timestamp NULL,
	description varchar(255) NULL,
	estado varchar(255) NULL,
	"name" varchar(255) NULL,
	transaccion varchar(255) NULL,
	unit_measure varchar(255) NULL,
	usuario_creacion varchar(255) NULL,
	usuario_modificacion varchar(255) NULL,
	CONSTRAINT ingredient_pkey PRIMARY KEY (id)
);


-- public.meal_plan definition

-- Drop table

-- DROP TABLE public.meal_plan;

CREATE TABLE public.meal_plan (
	id uuid NOT NULL,
	id_nutricionist uuid NULL,
	id_patient uuid NULL,
	id_appointment uuid NULL,
    id_subscription uuid NULL,
    total_calories numeric NULL,
	end_date timestamp NULL,
	star_date timestamp NULL,
	total_days int4 NULL,
	fecha_creacion timestamp NULL,
	fecha_modificacion timestamp NULL,
	estado varchar(255) NULL,
	transaccion varchar(255) NULL,
	usuario_creacion varchar(255) NULL,
	usuario_modificacion varchar(255) NULL,
	CONSTRAINT meal_plan_pkey PRIMARY KEY (id)
);


-- public.meal_plan_day definition

-- Drop table

-- DROP TABLE public.meal_plan_day;

CREATE TABLE public.meal_plan_day (
	id uuid NOT NULL,
	id_meal_plan uuid NULL,
	"day" int4 NULL,
	fecha_creacion timestamp NULL,
	fecha_modificacion timestamp NULL,
	estado varchar(255) NULL,
	transaccion varchar(255) NULL,
	usuario_creacion varchar(255) NULL,
	usuario_modificacion varchar(255) NULL,
	CONSTRAINT meal_plan_day_pkey PRIMARY KEY (id)
);


-- public.nutricionist definition

-- Drop table

-- DROP TABLE public.nutricionist;

CREATE TABLE public.nutricionist (
	id uuid NOT NULL,
	"name" varchar(255) NULL,
	CONSTRAINT nutricionist_pkey PRIMARY KEY (id)
);


-- public.patient definition

-- Drop table

-- DROP TABLE public.patient;

CREATE TABLE public.patient (
	id uuid NOT NULL,
	"name" varchar(255) NULL,
	phone varchar(255) NULL,
	CONSTRAINT patient_pkey PRIMARY KEY (id)
);

-- public.subscription_type definition

-- Drop table

-- DROP TABLE public.subscription_type;

CREATE TABLE public.subscription_type (
    id UUID PRIMARY KEY,
    name VARCHAR(255)
);

-- public.appointment definition

-- Drop table

-- DROP TABLE public.appointment;

CREATE TABLE public.appointment (
    id UUID PRIMARY KEY,
    status VARCHAR(255)
);


-- public.recipe definition

-- Drop table

-- DROP TABLE public.recipe;

CREATE TABLE public.recipe (
	id uuid NOT NULL,
	total_calories numeric NULL,
	fecha_creacion timestamp NULL,
	fecha_modificacion timestamp NULL,
	description varchar(255) NULL,
	estado varchar(255) NULL,
	instructions varchar(255) NULL,
	"name" varchar(255) NULL,
	transaccion varchar(255) NULL,
	usuario_creacion varchar(255) NULL,
	usuario_modificacion varchar(255) NULL,
	CONSTRAINT recipe_pkey PRIMARY KEY (id)
);


-- public.recipe_ingredient definition

-- Drop table

-- DROP TABLE public.recipe_ingredient;

CREATE TABLE public.recipe_ingredient (
	id uuid NOT NULL,
	id_recipe uuid NULL,
	id_ingredient uuid NULL,
	quantity numeric NULL,
	fecha_creacion timestamp NULL,
	fecha_modificacion timestamp NULL,
	estado varchar(255) NULL,
	transaccion varchar(255) NULL,
	usuario_creacion varchar(255) NULL,
	usuario_modificacion varchar(255) NULL,
	CONSTRAINT recipe_ingredient_pkey PRIMARY KEY (id)
);


-- public.time_food definition

-- Drop table

-- DROP TABLE public.time_food;

CREATE TABLE public.time_food (
	id uuid NOT NULL,
	id_meal_plan_day uuid NULL,
	sort_order numeric NULL,
	fecha_creacion timestamp NULL,
	fecha_modificacion timestamp NULL,
	estado varchar(255) NULL,
	transaccion varchar(255) NULL,
	"type" varchar(255) NULL,
	usuario_creacion varchar(255) NULL,
	usuario_modificacion varchar(255) NULL,
	CONSTRAINT time_food_pkey PRIMARY KEY (id)
);


-- public.time_food_recipe definition

-- Drop table

-- DROP TABLE public.time_food_recipe;

CREATE TABLE public.time_food_recipe (
	id uuid NOT NULL,
	id_recipe uuid NULL,
	id_time_food uuid NULL,
	portion numeric NULL,
	fecha_creacion timestamp NULL,
	fecha_modificacion timestamp NULL,
	estado varchar(255) NULL,
	transaccion varchar(255) NULL,
	usuario_creacion varchar(255) NULL,
	usuario_modificacion varchar(255) NULL,
	CONSTRAINT time_food_recipe_pkey PRIMARY KEY (id)
);