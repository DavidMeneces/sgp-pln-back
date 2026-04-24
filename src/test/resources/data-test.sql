-- CREATE EVENT VALUES
INSERT INTO public.subscription_type (id, name, days, status) VALUES('e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32'::uuid, 'Quincenal', 15, 'HABILITADO');
INSERT INTO public.nutricionist (id, name, status) VALUES('e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32'::uuid, 'David Meneces', 'HABILITADO');
INSERT INTO public.patient (id, name, phone, status) VALUES('e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32'::uuid, 'David Meneces', '61120416', 'HABILITADO');
INSERT INTO public.appointment (id, id_patient, schedule, status) VALUES('e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32'::uuid, 'e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32'::uuid, '2026-04-24 16:30:00.000', 'ATENDIDO');
-- CREATE INIT VALUES
-- create ingredients
INSERT INTO public.ingredient (id, name, description, unit_measure, calories_per_gram, transaction, status, created_by, created_at) VALUES('e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32'::uuid, 'Plátano', 'Fruta', 'GRAM', 100.00, 'CREAR', 'CREADO', 'sgp-pln', now());
-- create recipes
INSERT INTO public.recipe (id, name, description, instructions, total_calories, transaction, status, created_by, created_at) VALUES('e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32'::uuid, 'Smoothie Proteico Verde', 'Smoothie Proteico Verde', 'Instrucciones para Smoothie Proteico Verde', 100.00, 'CREAR', 'CREADO', 'sgp-pln', now());
INSERT INTO public.recipe_ingredient (id, id_ingredient, id_recipe, quantity, transaction, status, created_by, created_at) VALUES('e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32'::uuid, 'e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32'::uuid, 'e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32'::uuid, 1, 'CREAR', 'CREADO', 'sgp-pln', now());
-- create meal plans
INSERT INTO public.meal_plan (id, id_nutricionist, id_patient, id_appointment, id_subscription, star_date, end_date, total_days, total_calories, transaction, status, created_by, created_at) VALUES('e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32'::uuid, 'e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32'::uuid, 'e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32'::uuid, 'e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32'::uuid, 'e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32'::uuid, '2025-01-01 00:00:00.000', '2025-01-01 00:00:00.000', 1, 100.00, 'CREAR', 'CREADO', 'sgp-pln', now());
INSERT INTO public.meal_plan_day (id, id_meal_plan, day_number, transaction, status, created_by, created_at) VALUES('e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32'::uuid, 'e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32'::uuid, 1, 'CREAR', 'CREADO', 'sgp-pln', now());
INSERT INTO public.time_food (id, id_meal_plan_day, type, sort_order, transaction, status, created_by, created_at) VALUES('e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32'::uuid, 'e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32'::uuid, 'BREAKFAST', 1, 'CREAR', 'CREADO', 'sgp-pln', now());
INSERT INTO public.time_food_recipe (id, id_recipe, id_time_food, portion, transaction, status, created_by, created_at) VALUES('e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32'::uuid, 'e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32'::uuid, 'e7070f4e-47ba-4a86-8a78-ebdc5bbb9c32'::uuid, 1, 'CREAR', 'CREADO', 'sgp-pln', now());






