drop database if exists ventasMySQL;
create database ventasMySQL;

use ventasMySQL;

create table usuarios (
	id_usuario int primary key auto_increment,	
    nombre varchar(250) not null,
    email varchar(250) not null,
    ano_nacimiento int
);

create table pedidos (
	id_pedido int primary key auto_increment,
    id_usuario int,
    fecha_pedido date,
    constraint fk_usuario foreign key (id_usuario) references usuarios(id_usuario)   
);

create table productos (
    id_producto int primary key auto_increment,
	nombre_producto varchar(250) not null,      
    precio decimal(5,2) not null,
    stock int not null
);

insert into usuarios(nombre, email, ano_nacimiento) values ('Roberto Mazos', 'agudi@gmail.com', 2001 );
insert into usuarios(nombre, email, ano_nacimiento) values ('Cristian Lopez', 'lopez@gmail.com', 2003);
insert into usuarios(nombre, email, ano_nacimiento) values ('Sara Carbonero', 'sara@gmail.com', 1973 );
insert into usuarios(nombre, email, ano_nacimiento) values ('Patricia Ballester', 'patri@gmail.com', 1998 );

insert into pedidos(id_usuario, fecha_pedido) values (1, '2024-08-15');
insert into pedidos(id_usuario, fecha_pedido) values (2,  '2023-12-10');
insert into pedidos(id_usuario, fecha_pedido) values (3, '2022-02-8');
insert into pedidos(id_usuario, fecha_pedido) values (4, '2024-04-13');
insert into pedidos(id_usuario, fecha_pedido) values (1, '2023-02-22');

insert into productos(nombre_producto, precio, stock) values ('bata', 200, 50);
insert into productos(nombre_producto, precio, stock) values ('chaqueta', 95, 50);
insert into productos(nombre_producto, precio, stock) values ('jersey', 75, 28);
insert into productos(nombre_producto, precio, stock) values ('abrigo', 135, 3);
insert into productos(nombre_producto, precio, stock) values ('pan', 1.2, 150);
insert into productos(nombre_producto, precio, stock) values ('martillo', 15.5, 20);
insert into productos(nombre_producto, precio, stock) values ('naranjas', 6, 80);
insert into productos(nombre_producto, precio, stock) values ('pala', 25, 1);

create table pedidos_productos (
	id_pedido int,
    id_producto int,
    cantidad int not null,
    primary key (id_pedido, id_producto),
    constraint fk_pedido foreign key (id_pedido) references pedidos(id_pedido),
    constraint fk_producto foreign key (id_producto) references productos(id_producto)
);

insert into pedidos_productos values (1, 1, 3);
insert into pedidos_productos values (2, 4, 2);
insert into pedidos_productos values (2, 3, 1);
insert into pedidos_productos values (3, 2, 3);
insert into pedidos_productos values (4, 5, 5);
insert into pedidos_productos values (5, 6, 1);
insert into pedidos_productos values (5, 7, 9);

select * from productos;