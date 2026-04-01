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
    id_patient UUID,
    status VARCHAR(255)
);

-- public.ingredient definition
-- Drop table
-- DROP TABLE public.ingredient;
CREATE TABLE public.ingredient (
	id uuid NOT NULL,
	"name" varchar(255) NULL,
	description varchar(255) NULL,
	unit_measure varchar(255) NULL,
	calories_per_gram numeric(38, 2) NULL,
	"transaction" varchar(255) NULL,
	status varchar(255) NULL,
	created_at timestamp NULL,
	created_by varchar(255) NULL,
    updated_at timestamp NULL,
	updated_by varchar(255) NULL,
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
	"transaction" varchar(255) NULL,
	status varchar(255) NULL,
	created_by varchar(255) NULL,
	created_at timestamp NULL,
	updated_by varchar(255) NULL,
	updated_at timestamp NULL,
	CONSTRAINT meal_plan_pkey PRIMARY KEY (id)
);

-- public.meal_plan_day definition
-- Drop table
-- DROP TABLE public.meal_plan_day;
CREATE TABLE public.meal_plan_day (
	id uuid NOT NULL,
	id_meal_plan uuid NULL,
	day_number int4 NULL,
	"transaction" varchar(255) NULL,
	status varchar(255) NULL,
	created_by varchar(255) NULL,
	created_at timestamp NULL,
	updated_by varchar(255) NULL,
	updated_at timestamp NULL,
	CONSTRAINT meal_plan_day_pkey PRIMARY KEY (id)
);

-- public.recipe definition
-- Drop table
-- DROP TABLE public.recipe;
CREATE TABLE public.recipe (
	id uuid NOT NULL,
	"name" varchar(255) NULL,
	description varchar(255) NULL,
	instructions varchar(255) NULL,
	total_calories numeric NULL,
	"transaction" varchar(255) NULL,
	status varchar(255) NULL,
	created_by varchar(255) NULL,
	created_at timestamp NULL,
	updated_by varchar(255) NULL,
	updated_at timestamp NULL,
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
	"transaction" varchar(255) NULL,
	status varchar(255) NULL,
	created_by varchar(255) NULL,
	created_at timestamp NULL,
	updated_by varchar(255) NULL,
	updated_at timestamp NULL,
	CONSTRAINT recipe_ingredient_pkey PRIMARY KEY (id)
);

-- public.time_food definition
-- Drop table
-- DROP TABLE public.time_food;
CREATE TABLE public.time_food (
	id uuid NOT NULL,
	id_meal_plan_day uuid NULL,
	"type" varchar(255) NULL,
	sort_order numeric NULL,
	"transaction" varchar(255) NULL,
	status varchar(255) NULL,
	created_by varchar(255) NULL,
	created_at timestamp NULL,
	updated_by varchar(255) NULL,
	updated_at timestamp NULL,
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
    "transaction" varchar(255) NULL,
	status varchar(255) NULL,
    created_by varchar(255) NULL,
    created_at timestamp NULL,
    updated_by varchar(255) NULL,
    updated_at timestamp NULL,
	CONSTRAINT time_food_recipe_pkey PRIMARY KEY (id)
);

-- public.outbox_events definition
-- Drop table
-- DROP TABLE public.outbox_events;
CREATE TABLE public.outbox_events (
	id uuid NOT NULL,
	event_id uuid NOT NULL,
	aggregate_type varchar(255) NOT NULL,
	aggregate_id varchar(255) NOT NULL,
	event_type varchar(255) NOT NULL,
	event_name varchar(255) NOT NULL,
	routing_key varchar(255) NULL,
	schema_version int4 NULL,
	correlation_id uuid NULL,
	payload text NULL,
	occurred_on timestamp NOT NULL,
	processed_on timestamp NULL,
	attempts int4 NULL DEFAULT 0,
	next_attempt_at timestamp NULL,
	last_error text NULL,
	created_at timestamp NULL DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT outbox_events_pkey PRIMARY KEY (id)
);

-- public.inbound_events definition
-- Drop table
-- DROP TABLE public.inbound_events;
CREATE TABLE public.inbound_events (
	id uuid NOT NULL,
	event_id uuid NOT NULL,
	event_name varchar(255) NULL,
	routing_key varchar(255) NULL,
	correlation_id uuid NULL,
	schema_version int4 NULL,
	status varchar(50) NOT NULL,
	occurred_on timestamp NULL,
	received_on timestamp NOT NULL,
	processed_on timestamp NULL,
	updated_on timestamp NULL,
	payload text NULL,
	last_error text NULL,
	created_at timestamp NULL DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT inbound_events_event_id_key UNIQUE (event_id),
	CONSTRAINT inbound_events_pkey PRIMARY KEY (id)
);
