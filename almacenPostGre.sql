-- Database: almacenPostGre

-- Definir el tipo de datos personalizado "contacto"
CREATE TYPE Contacto AS (
    nombre_contacto VARCHAR(255),
    nif VARCHAR(50),
    telefono INT,
    email VARCHAR(250)
);

create table categorias (
	id_categoria serial primary key, 	
    nombre_categoria varchar(250) not null
);

create table proveedores (
	id_proveedor serial primary key, 	
    nombre_proveedor varchar(250) not null,
	contacto Contacto
);

create table productos (
	id_producto int PRIMARY KEY,   
    id_categoria INT REFERENCES categorias(id_categoria),
	id_proveedor int references proveedores(id_proveedor)
);

create table almacenes (
    id_almacen serial primary key,
	nombre_almacen varchar(250) not null,      
    ubicacion varchar(500) not null
);

insert into almacenes(nombre_almacen, ubicacion) values ('Almacen Campos', 'Torrelodones 34');
insert into almacenes(nombre_almacen, ubicacion) values ('La pirita', 'Finca la marquesa 5');
insert into almacenes(nombre_almacen, ubicacion) values ('Todo Chen', 'Torrejon de Ardoz 89');
insert into almacenes(nombre_almacen, ubicacion) values ('Comsum', 'Mercenarios 45');

insert into categorias(nombre_categoria) values ('Ropa');
insert into categorias(nombre_categoria) values ('Herramientas');
insert into categorias(nombre_categoria) values ('Alimentacion');

insert into proveedores(nombre_proveedor, contacto) values ('Chinatown', ROW('Luis Fernandez', '36111222A', 656565568, 'luis@gmail.com'));
insert into proveedores(nombre_proveedor, contacto) values ('Rusia', ROW('Charly Ballester', '58458789B', 985653254, 'charly@gmail.com'));
insert into proveedores(nombre_proveedor, contacto) values ('Alimentacion Juan', ROW('Juan Santos', '25654654A', 956784789, 'juan@gmail.com'));
insert into proveedores(nombre_proveedor, contacto) values ('Ferretería Tita', ROW('Antonia Bastos', '25478489B', 986545214, 'tita@gmail.com'));

insert into productos(id_producto, id_categoria, id_proveedor) values (1, 1, 2);
insert into productos(id_producto, id_categoria, id_proveedor) values (2, 2, 4);
insert into productos(id_producto, id_categoria, id_proveedor) values (3, 3, 3);
insert into productos(id_producto, id_categoria, id_proveedor) values (4, 1, 1);

create table almacenes_productos (	
    primary key (id_almacen, id_producto),
	id_almacen int references almacenes(id_almacen),
    id_producto int references productos(id_producto),
	cantidad int not null
);

insert into almacenes_productos(id_almacen,id_producto,cantidad) values (1, 2, 4);
insert into almacenes_productos(id_almacen,id_producto,cantidad) values (2, 4, 20);
insert into almacenes_productos(id_almacen,id_producto,cantidad) values (3, 3, 12);
insert into almacenes_productos(id_almacen,id_producto,cantidad) values (4, 2, 4);

select * from categorias;
select * from  proveedores;
select * from  productos;
select * from  almacenes;
select * from  almacenes_productos;