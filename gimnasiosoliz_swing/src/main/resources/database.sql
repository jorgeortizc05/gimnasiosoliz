drop table if exists parametro cascade;
drop table if exists tipo_persona cascade;
drop table if exists persona cascade;
drop table if exists tipo_comprobante cascade;
drop table if exists tipo_suscripcion cascade;
drop table if exists suscripcion cascade;
drop table if exists categoria cascade;
drop table if exists canton cascade;
drop table if exists forma_pago cascade;
drop table if exists producto cascade;
drop table if exists empresa cascade;
---drop sequence categoria_seq_id cascade;
---drop sequence producto_seq_id;

create table parametro (
	id serial not null,
	numero_recibo int,
	primary key (id)
);

create table tipo_persona (
	id serial not null, -- serial crea una secuencia de manera automatica y no es necesario establecer id
	nombre varchar(50),
	descripcion varchar(300),
	primary key (id)
);

create table persona (
	id serial not null,
	nombre varchar(70),
	apellido varchar(70),
	cedula varchar(16),
	direccion varchar(300),
	email varchar(150),
	fecha_nacimiento DATE,
	telefono varchar(40),
	activo varchar(1),
	foto varchar(300),
	tipo_persona_id int not null,
	primary key (id),
	foreign key (tipo_persona_id) references tipo_persona (id)
);

create table tipo_comprobante (
	id serial not null,
	nombre varchar(50),
	descripcion varchar(300),
	primary key (id)
);

create table tipo_suscripcion (
	id serial not null,
	nombre varchar(50),
	numero_dias int,
	precio numeric(1000,2),
	descripcion varchar(300),
	primary key (id)
);

create table suscripcion (
	id serial not null,
	numero_recibo varchar(70),
	fecha_desde date,
	fecha_hasta date,
	precio numeric(1000,2),
	descuento numeric(1000,2),
	importe_total numeric(1000,2),
	observaciones varchar(300),
	persona_id int not null,
	tipo_suscripcion_id int not null,
	primary key (id),
	foreign key (persona_id) references persona (id),
	foreign key (tipo_suscripcion_id) references tipo_suscripcion (id)
	
);

create table categoria (
	id serial not null,
	nombre varchar(50),
	descripcion varchar(300),
	primary key (id)
);

create table canton (
	id serial not null,
	nombre varchar(50),
	descripcion varchar(300),
	primary key (id)
);

create table forma_pago (
	id serial not null,
	nombre varchar(50),
	descripcion varchar(300),
	primary key (id)
);

create table producto(
	id serial not null,
	nombre varchar(50),
	descripcion varchar(300),
	precio numeric(1000,2),
	codigo_barra varchar(30),
	foto varchar(300),
	categoria_id int not null,
	primary key(id),
	foreign key (categoria_id) references categoria (id)
);

create table empresa(
	id serial not null,
	ruc varchar(50),
	nombre varchar(50),
	descripcion varchar(300),
	direccion_matriz varchar(300),
	direccion_sucursal varchar(300),
	canton_id int not null,
	primary key(id),
	foreign key (canton_id) references canton (id)
);

---------------Datos--------------------------------
---Parametro---
INSERT INTO public.parametro
(numero_recibo)
VALUES(1);


-----Tipo Persona-----------
INSERT INTO public.tipo_persona(nombre, descripcion)VALUES('Cliente', 'Persona que usa servicios del gimnasio');
-------Persona---------
INSERT INTO public.persona
(nombre, apellido, cedula, direccion, email, fecha_nacimiento, telefono, activo, foto, tipo_persona_id)
VALUES('JORGE', 'ORTIZ', '0105182703', 'Paute', 'jorgeortizc05@gmail.com', '14/05/1992', '0983457699', 'A', '0105182703.png', 1);
INSERT INTO public.persona
(nombre, apellido, cedula, direccion, email, fecha_nacimiento, telefono, activo, foto, tipo_persona_id)
VALUES('ANDREA', 'TAQUEZ', '2101047237', 'Paute', 'andreamery05@gmail.com', '21/01/1995', '0996186835', 'A', '2101047237.png', 1);
INSERT INTO public.persona
(nombre, apellido, cedula, direccion, email, fecha_nacimiento, telefono, activo, foto, tipo_persona_id)
VALUES('DIANA', 'PERALTA', '0106148729', 'Paute', 'patyperalta06@gmail.com', '06/08/1997', '0996186835', 'A', '0106148729.png', 1);


------Tipo Comprobante
INSERT INTO public.tipo_comprobante(nombre, descripcion)VALUES('Factura', 'Se incluye el IVA del 12%');
----Tipo Suscripcion---------
INSERT INTO public.tipo_suscripcion(nombre, numero_dias, precio, descripcion)VALUES('Suscripción de 1 día', 0, 1.5, 'Valido por un día');
INSERT INTO public.tipo_suscripcion(nombre, numero_dias, precio, descripcion)VALUES('Suscripción de 1 semana', 7, 7, 'Valido por 7 días');
INSERT INTO public.tipo_suscripcion(nombre, numero_dias, precio, descripcion)VALUES('Suscripción de 2 semanas', 15, 15, 'Valido por 15 días');
INSERT INTO public.tipo_suscripcion(nombre, numero_dias, precio, descripcion)VALUES('Suscripción de 1 mes', 30, 25, 'Valido por un mes');
-------Suscripcion--------
/*INSERT INTO public.suscripcion
(numero_recibo, fecha_desde, fecha_hasta, precio, descuento, importe_total, observaciones, persona_id, tipo_suscripcion_id)
VALUES('9', '', '', 0, 0, 0, '', 0, 0);*/
-------Categoria-----------
INSERT INTO public.categoria(nombre, descripcion)VALUES('smartphones', 'solo telefonos');
INSERT INTO public.categoria(nombre, descripcion)VALUES('monitores', 'monitor a usar');
INSERT INTO public.categoria(nombre, descripcion)VALUES('laptops', 'Portatiles para trabajo');

----Canton---------
INSERT INTO public.canton(nombre, descripcion)VALUES('Paute', 'Lugar de establecimiento principal');

-----Forma Pago
INSERT INTO public.forma_pago(nombre, descripcion)VALUES('Efectivo', 'Solo dolares');

----Empresa---------
INSERT INTO public.empresa(ruc, nombre, descripcion, direccion_matriz, direccion_sucursal, canton_id)
VALUES('111111111111', 'Gimnasio Soliz', 'Comida rapida y gimnasio', 'Paute', 'Paute', 1);

-------Producto------
INSERT INTO public.producto(nombre, descripcion, precio, codigo_barra, foto, categoria_id)VALUES('Xiaomi Poco X3', 'Pantalla de 120hz, 5130 mha, carga rapida de 33w', 285, '11111', 'ce63dfea-586e-4e32-a089-2b7ee1cd43b3', 1);
INSERT INTO public.producto(nombre, descripcion, precio, codigo_barra, foto,  categoria_id)VALUES('Huawei y7', 'Camara de 16 mpx, 3 de RAM y 32 de ROM', 190, '11112', 'ce63dfea-586e-4e32-a089-2b7ee1cd43b3',1);
INSERT INTO public.producto(nombre, descripcion, precio, codigo_barra, foto, categoria_id)VALUES('LG 21 Pulgadas', 'Resolucion 1440x900 px', 120, '11113', 'ce63dfea-586e-4e32-a089-2b7ee1cd43b3',2);
INSERT INTO public.producto(nombre, descripcion, precio, codigo_barra, foto, categoria_id)VALUES('LG 29 pulgadas', 'Resolucion de 2560x1080',260, '11114', 'ce63dfea-586e-4e32-a089-2b7ee1cd43b3', 2);
INSERT INTO public.producto(nombre, descripcion, precio, codigo_barra, foto, categoria_id)VALUES('DELL Gaming g5', 'Dispone de nvidia gtx 1050',1550, '11115', 'ce63dfea-586e-4e32-a089-2b7ee1cd43b3', 3);
