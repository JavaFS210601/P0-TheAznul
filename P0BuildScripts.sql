-- comment

--creating the initial table

CREATE TABLE items (
item_id SERIAL PRIMARY key,
item_name TEXT,
obtain_method int references get_methods(method_id),
item_type int REFERENCES item_types(type_id)
);

CREATE TABLE get_methods (
method_id SERIAL PRIMARY KEY,
method_name text

);

CREATE TABLE item_types (
type_id SERIAL PRIMARY KEY,
type_name text
);

INSERT INTO get_methods (method_name) VALUES ('Random Drop'), ('Strikes'), ('Nightfalls'), ('Crucible'), ('Gambit'), ('Quest');

INSERT INTO item_types (type_name) VALUES ('Weapon'), ('Armor'), ('Exotic Catalyst'), ('Ship'), ('Sparrow'), ('Ghost');

DROP TABLE items;
